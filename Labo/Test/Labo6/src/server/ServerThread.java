package server;

import game.Player;
import game.PlayerListener;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author bjorn
 */
public class ServerThread implements Runnable {
    
    private final BlockingQueue<Player> players;
    PlayerListener endGame;
    ServerListener listener;

    public ServerThread() {
        players = new LinkedBlockingQueue<>();
        endGame = new PlayerListener(players);
        listener = new ServerListener(players);
    }
    
    @Override
    public void run() {
        new Thread(endGame).start();
        new Thread(listener).start();
    }

    void end() {
        endGame.end();
        listener.end();
    }

}
