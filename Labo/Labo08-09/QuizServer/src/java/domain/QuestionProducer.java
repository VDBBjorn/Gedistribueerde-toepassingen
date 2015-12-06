package domain;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;

/**
 *
 * @author bjorn
 */
public class QuestionProducer implements Runnable {

    private static final int BUFFER_SIZE = 255;
    private final ByteBuffer writeBuffer;
    private QuizServer server;

    public QuestionProducer(QuizServer server) {
        this.server = server;
        writeBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE);
    }

    @Override
    public void run() {
        Quiz quiz = new Quiz();
        while (server.isRunning()) {
            try {
                Question q = quiz.getQuestion();
                sendBroadcastMessageToRegistred("\n------------------------------------------------------\n"
                        + "QUESTION " + q.getId() + " " + q.getQuestion() + "\n"
                        + "Send your answer with ANSWER " + q.getId() + " <your answer> \n"
                        + "------------------------------------------------------\n");
                pushToQueue("SEND QUESTION " + q.getId());
                Logger.getLogger(QuizServer.class.getName()).log(Level.INFO, "question was broadcasted: {0}", q.getId());
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                Logger.getLogger(QuestionProducer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void sendBroadcastMessageToRegistred(String mesg) {
        HashMap<SelectionKey, String> usermap = server.getUsermap();
        prepWriteBuffer(mesg);
        usermap.keySet().stream().map((k) -> k.channel()).forEach((channel) -> {
            channelWrite((SocketChannel) channel, writeBuffer);
        });
    }

    private void prepWriteBuffer(String mesg) {
        writeBuffer.clear();
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

    public void pushToQueue(String message) {
        try (JMSContext context = server.getConnectionFactory().createContext();) {
            context.createProducer().send(server.getQueue(), message);
            context.createProducer().send(server.getQueue(), context.createMessage());
        } catch (JMSRuntimeException e) {
            System.err.println("Exception occurred: " + e.toString());
            System.exit(1);
        }
    }

    

}
