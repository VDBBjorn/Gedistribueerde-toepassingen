/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacserver;

import domain.Player;
import domain.TicTacToe;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bjorn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = null;
        try {
            listener = new ServerSocket(8901);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        System.out.println("Tic Tac Toe Server is Running");
        try {
            while (true) {                 
                TicTacToe game = new TicTacToe();
                Player playerX = new Player(listener.accept(), 'X', game);
                Player playerO = new Player(listener.accept(), 'O', game);  
                playerX.setOpponent(playerO);
                playerO.setOpponent(playerX);
                game.setCurrentPlayer(playerX);
                playerX.start();
                playerO.start();
            }
        } finally {
            listener.close();
        }
    }
    
}
