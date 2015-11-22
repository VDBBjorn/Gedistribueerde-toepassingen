package server;

import game.Player;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bjorn
 */
public class ServerListener implements Runnable, AutoCloseable {

    private static final int POORT = 8901;
    private ServerSocket listener;
    private boolean active;
    BlockingQueue<Player> players;
    
    public ServerListener(BlockingQueue<Player> players) {
        try {
            this.players = players;
            listener = new ServerSocket(POORT);
            System.out.println("Server is up!");
            active = true;
        } catch (IOException ex) {
            Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void run() {
        while(active) {
            try {
                Player player = new Player(listener.accept());
                players.add(player);
            } catch (IOException ex) {
                Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void close() {
        try {
            listener.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void end() {
        active = false;
    }
}
