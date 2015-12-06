package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import javax.jms.JMSRuntimeException;

/**
 *
 * @author bjorn
 */
public class QuizServer implements Runnable {

    private ConnectionFactory connectionFactory;
    private Queue queue;

    private static final int BUFFER_SIZE = 255;
    private ServerSocketChannel channel;
    private Selector inputSelector;
    private boolean running;
    private final LinkedList<SocketChannel> clients;
    private final ByteBuffer writeBuffer;
    private final ByteBuffer readBuffer;
    private final CharsetDecoder asciiDecoder;
    private HashMap<SelectionKey, String> usermap;

    private JMSContext context;

    public QuizServer(ConnectionFactory cf, Queue q, ServerSocketChannel serverSocketChannel) {
        this.connectionFactory = cf;
        this.queue = q;
        this.channel = serverSocketChannel;
        running = true;
        clients = new LinkedList<>();
        writeBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE);
        readBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE);
        asciiDecoder = Charset.forName("US-ASCII").newDecoder();
        usermap = new HashMap<>();
        context = connectionFactory.createContext();
    }

    @Override
    public void run() {
        try {
            inputSelector = Selector.open();
            channel.configureBlocking(false);
            channel.register(inputSelector, SelectionKey.OP_ACCEPT);
            QuestionProducer qp = new QuestionProducer(this);
            Thread t = new Thread(qp);
            t.start();
            while (running) {
                waitForInput();
            }
        } catch (IOException ex) {
            Logger.getLogger(QuizServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void waitForInput() {
        try {
            int readyChannels = inputSelector.select();
            if (readyChannels != 0) {
                inputSelector.selectedKeys().stream().forEach((selectedKey) -> {
                    if (selectedKey.isAcceptable()) {
                        addNewClient(selectedKey);
                    } else if (selectedKey.isReadable()) {
                        readIncomingMessages(selectedKey);
                    }
                });
                inputSelector.selectedKeys().clear();
            }
        } catch (IOException ex) {
            Logger.getLogger(QuizServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void readIncomingMessages(SelectionKey key) {

        try {
            SocketChannel ch = (SocketChannel) key.channel();
            readBuffer.clear();
            long nbytes = ch.read(readBuffer);
            if (nbytes == -1) {
                Logger.getLogger(QuizServer.class.getName()).log(Level.INFO, "disconnect: {0}, end-of-stream", ch.socket().getInetAddress());
                ch.close();
                clients.remove(ch);
                sendBroadcastMessage("logout: " + ch.socket().getInetAddress(), ch);
            } else {
                StringBuffer sb = (StringBuffer) key.attachment();
                readBuffer.flip();
                String str = asciiDecoder.decode(readBuffer).toString();
                readBuffer.clear();
                sb.append(str);

                String line = sb.toString();
                if ((line.contains("\n")) || (line.contains("\r"))) {
                    line = line.trim();
                    if (line.startsWith("QUIT")) {
                        Logger.getLogger(QuizServer.class.getName()).log(Level.INFO, "got quit msg, closing channel for : {0}", ch.socket().getInetAddress());
                        sendMessage(ch, "You left the game! Bye!");
                        ch.close();
                        clients.remove(ch);
                        usermap.remove(key);
                        sendBroadcastMessage("logout: " + ch.socket().getInetAddress(), ch);
                    } else if (line.startsWith("REGISTER")) {
                        Boolean ok = true;
                        String name = line.split(" ")[1];
                        for (SelectionKey k : usermap.keySet()) {
                            Logger.getLogger(QuizServer.class.getName()).log(Level.INFO, "key");
                            if (key.equals(k)) {
                                sendMessage(ch, "You have already registered!");
                                ok = false;
                                break;
                            }
                        }
                        for (String n : usermap.values()) {
                            if (n.equals(name)) {
                                sendMessage(ch, "Somebody already took this name, pick another!");
                                ok = false;
                                break;
                            }
                        }
                        if (ok) {
                            Logger.getLogger(QuizServer.class.getName()).log(Level.INFO, "user {0} registred for the game", name);
                            sendBroadcastMessage(name + " entered the game!",ch);
                            sendMessage(ch, "Get ready, "+name+"!");
                            sendMessage(ch, "Next question will be right up, hold on!");
                            usermap.put(key, name);
                        }
                        sb.delete(0, sb.length());
                    } else if (line.startsWith("ANSWER")) {
                        String[] linesplit = line.split(" ", 3);
                        if(linesplit[1].equalsIgnoreCase("") || linesplit[1].isEmpty()) {
                            sendMessage(ch, "Couldn't find the question id, try answering again in format: ANSWER <id> <answer>");
                        } 
                        else if(linesplit[2].equalsIgnoreCase("") || linesplit[2].isEmpty()) {
                            sendMessage(ch, "Couldn't find your answer, try answering again in format: ANSWER <id> <answer>");
                        }
                        else {                            
                            Logger.getLogger(QuizServer.class.getName()).log(Level.INFO, "answer received by {0}", usermap.get(key));
                            sendMessage(ch, "Your answer was received by the server: "+linesplit[2]);
                            
                            pushToQueue("ANSWER QUESTION "+linesplit[1]+" "+linesplit[2]+" BY "+usermap.get(key));
                        }
                        
                        sb.delete(0, sb.length());
                    } else {
                        sendMessage(ch, "Your command could not be recognized by the server, try again!");
                        sb.delete(0, sb.length());
                    }
                }
            }
        } catch (IOException ioe) {
            Logger.getLogger(QuizServer.class.getName()).log(Level.WARNING, "error during select(): {0}", ioe.getMessage());
        } catch (Exception e) {
            Logger.getLogger(QuizServer.class.getName()).log(Level.SEVERE, "exception in run(){0}", e.getMessage());
        }

    }

    private void addNewClient(SelectionKey key) {
        try {
            ServerSocketChannel ch = (ServerSocketChannel) key.channel();
            SocketChannel clientChannel = ch.accept();
            
            Logger.getLogger(QuizServer.class.getName()).log(Level.INFO, "got connection from: {0}", clientChannel.socket().getInetAddress());
            sendMessage(clientChannel, "Welcome to the quiz, there are "
                    + clients.size() + " users online.\n"
                    + "> type REGISTER <name> in order to register for the quiz questions\n");
            sendMessage(clientChannel, "Type 'QUIT' to exit.\n");

            clients.add(clientChannel);

            clientChannel.configureBlocking(false);
            clientChannel.register(inputSelector, SelectionKey.OP_READ, new StringBuffer());
        } catch (IOException ex) {
            Logger.getLogger(QuizServer.class.getName()).log(Level.SEVERE, "problemen bij afhandelen client", ex);
        }
    }

    private void sendMessage(SocketChannel channel, String mesg) {
        prepWriteBuffer(mesg);
        channelWrite(channel, writeBuffer);
    }

    private void sendBroadcastMessage(String mesg, SocketChannel from) {
        prepWriteBuffer(mesg);
        clients.stream().filter((c) -> (c != from)).forEach((ch) -> {
            channelWrite(ch, writeBuffer);
        });
    }

    private void prepWriteBuffer(String mesg) {
        writeBuffer.clear();
        mesg = "> "+mesg;
        writeBuffer.put(mesg.getBytes());
        writeBuffer.putChar('\n');
        writeBuffer.flip();
    }

    private void channelWrite(SocketChannel channel, ByteBuffer writeBuffer) {
        long nbytes = 0;
        long toWrite = writeBuffer.remaining();
        try {
            while (nbytes != toWrite) {
                nbytes += channel.write(writeBuffer);
            }
        } catch (IOException ex) {
            Logger.getLogger(QuizServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        writeBuffer.rewind();
    }

    public void stop() {
        running = false;
    }
    
    public void pushToQueue(String message) {
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.createProducer().send(queue, message);
            jmsContext.createProducer().send(queue, jmsContext.createMessage());            
        } catch (JMSRuntimeException e) {
            System.err.println("Exception occurred: " + e.toString());
            System.exit(1);
        }
    }
    
    public LinkedList<SocketChannel> getClients() {
        return this.clients;
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public Queue getQueue() {
        return queue;
    }

    public HashMap<SelectionKey, String> getUsermap() {
        return usermap;
    }

    public boolean isRunning() {
        return running;
    }
    
    
}
