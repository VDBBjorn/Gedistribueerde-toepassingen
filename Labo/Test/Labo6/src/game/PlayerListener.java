package game;

import game.Game;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bjorn
 */
public class PlayerListener implements Runnable {
    
    private BlockingQueue<Player> players;
    private boolean active;
    
    public PlayerListener(BlockingQueue<Player> list) {
        this.players = list;
        this.active = true;
    }

    @Override
    public void run() {
        ExecutorService es =  Executors.newFixedThreadPool(10);
        while(active) {
            try {
                Player player1 = players.take();
                Player player2 = players.take();
                Game game = new Game(players, player1, player2);
                es.submit(game);
            } catch (InterruptedException ex) {
                Logger.getLogger(PlayerListener.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }        
    }
    
    public void end() {
        this.active = false;
    }

}
