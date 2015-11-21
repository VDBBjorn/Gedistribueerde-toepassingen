/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.tiwi.woordenboek;

import be.tiwi.woordenboek.data.Woordenboek;
import be.tiwi.woordenboek.data.WoordenboekDAO;
import be.tiwi.woordenboek.impl.WoordenboekDAOimpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bjorn
 */
public class Main {
    public static void main(String[] args)
    {
        WoordenboekDAO woordenboek = new WoordenboekDAOimpl();
        
        List<Woordenboek> lijst = woordenboek.getWoordenboeken();
        
        System.out.println("Enter text: ");
            Scanner sc = new Scanner(System.in);
            String[] woorden = sc.nextLine().split(" ");
            for (String woord : woorden) {
                List<String> wordList = new ArrayList<>();
                for (Woordenboek w : lijst) {
                    wordList.addAll(woordenboek.zoekWoorden(woord, w.getID()));
                }
                if (!wordList.isEmpty()) {
                    System.out.println(woord + "->");
                    for (String word : wordList) {
                        System.out.print(word+" ");
                    }
                    System.out.println();
                }
            }
    }
}
