package server;

import java.util.Scanner;

/**
 *
 * @author bjorn
 */
public class Server {
    
    public static void main(String[] args) {
        ServerThread server = new ServerThread();
        Thread thread = new Thread(server);
        thread.start();
        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().equals("quit")) {
            server.end();
        }
    }

}
