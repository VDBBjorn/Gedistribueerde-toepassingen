package ui;

import domain.QuizServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

/**
 *
 * @author bjorn
 */
public class Main {

    @Resource(mappedName = "QuizQueueConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/QuizQueue")
    private static Queue queue;

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            QuizServer server = new QuizServer(connectionFactory, queue,serverSocketChannel);
            Thread t = new Thread(server);
            t.start();
            Scanner sc = new Scanner(System.in);
            if (sc.nextLine().equals("quit")) {
                server.stop();
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
