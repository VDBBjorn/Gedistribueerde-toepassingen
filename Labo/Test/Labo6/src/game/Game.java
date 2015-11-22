package game;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author bjorn
 */
public class Game implements Runnable {
    
    static final char X = 'X';
    static final char O = 'O';
    Map<Character, Player> players;
    char currentPlayer;
    BlockingQueue list;
    
    private final Player[] board = {
        null, null, null,
        null, null, null,
        null, null, null};

    public Game(BlockingQueue<Player> players, Player player1, Player player2) {
        this.list = players;
        this.players = new HashMap<>();
        Player playerX = this.players.put(X,player1);
        Player playerO = this.players.put(O,player2);
        playerX.start(X);
        playerO.start(O);
    }
    
    public boolean hasWinner() {
        return (board[0] != null && board[0] == board[1] && board[0] == board[2])
                || (board[3] != null && board[3] == board[4] && board[3] == board[5])
                || (board[6] != null && board[6] == board[7] && board[6] == board[8])
                || (board[0] != null && board[0] == board[3] && board[0] == board[6])
                || (board[1] != null && board[1] == board[4] && board[1] == board[7])
                || (board[2] != null && board[2] == board[5] && board[2] == board[8])
                || (board[0] != null && board[0] == board[4] && board[0] == board[8])
                || (board[2] != null && board[2] == board[4] && board[2] == board[6]);
    }

    public boolean boardFilledUp() {
        for (Player board1 : board) {
            if (board1 == null) {
                return false;
            }
        }
        return true;
    }

    public boolean legalMove(int location, Player player) {
        if (location >= 0 && location < 9 && board[location] == null) {
            board[location] = player;
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        currentPlayer = X;
        Player player = players.get(currentPlayer);
        int location;
        boolean hasWinner = false;
        boolean boardFilledUp = false;
        boolean end = false;
        do {
            player.send("MESSAGE Your move");
            location = player.move();
            if (legalMove(location, player)) {
                player.send("VALID_MOVE");
                hasWinner = hasWinner();
                boardFilledUp = boardFilledUp();
                player.send(hasWinner ? "VICTORY"
                        : boardFilledUp ? "TIE"
                                : "");
                currentPlayer = currentPlayer == X ? O : X;
                player = players.get(currentPlayer);
                player.otherPlayerMoved(location);
                player.send(hasWinner ? "DEFEAT" : boardFilledUp ? "TIE" : "");
            } else if (location == -1) {
                player.close();
                end = true;
                currentPlayer = currentPlayer == X ? O : X;
                player = players.get(currentPlayer);
                player.send("QUIT");
            } else {
                player.send("MESSAGE ?");
            }
        }
        while(!boardFilledUp && !end);
    }
    
}
