/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bjorn
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket listener = null;
        BufferedReader input;
        PrintWriter output;
        try {
            listener = new ServerSocket(8888);
            
            System.out.println("Server is up!");
            Socket s1 = listener.accept();
            input = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            output = new PrintWriter(s1.getOutputStream(),true);
            String word = input.readLine();
            while(!"quit".equals(word)) {                
                output.println("you've typed "+word);
                word = input.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            listener.close();
        }
        
    }
    
}
