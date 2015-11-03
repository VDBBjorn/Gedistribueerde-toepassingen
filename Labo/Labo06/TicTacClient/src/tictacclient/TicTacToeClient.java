package tictacclient;

import gui.TicTacToeFrame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bjorn
 */
public class TicTacToeClient {

    private static int PORT = 8901;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    TicTacToeFrame frame;

    public TicTacToeClient(String serverAddress) throws IOException {
        socket = new Socket(serverAddress, PORT);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        this.frame = new TicTacToeFrame(this);
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void message(String message) {
        out.println(message);
    }

    boolean wantsToPlayAgain() {
        return frame.wantsToPlayAgain();
    }

    public void play() throws Exception {
        String response;
        try {
            response = in.readLine();
            if (response.startsWith("WELCOME")) {
                char mark = response.charAt(8);
                frame.setMark(mark);
                frame.setTitle("Tic Tac Toe - Player " + mark);
            }
            while (true) {
                response = in.readLine();
                if (response.startsWith("VALID_MOVE")) {
                    frame.validMove();
                } else if (response.startsWith("OPPONENT_MOVED")) {
                    int loc = Integer.parseInt(response.substring(15));
                    frame.opponentMoved(loc);
                } else if (response.startsWith("VICTORY")) {
                    frame.bericht("You win");
                    break;
                } else if (response.startsWith("DEFEAT")) {
                    frame.bericht("You lose");
                    break;
                } else if (response.startsWith("TIE")) {
                    frame.bericht("You tied");
                    break;
                } else if (response.startsWith("MESSAGE")) {
                    frame.bericht(response.substring(8));
                }
            }
            out.println("QUIT");
        } finally {
            socket.close();
        }
    }
}
