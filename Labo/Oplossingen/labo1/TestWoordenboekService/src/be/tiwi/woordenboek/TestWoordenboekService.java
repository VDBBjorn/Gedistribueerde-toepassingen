/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.tiwi.woordenboek;

import dictservice.DictService;
import dictservice.DictServiceSoap;
import dictservice.Dictionary;
import dictservice.DictionaryWord;
import dictservice.Strategy;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vongenae
 */
public class TestWoordenboekService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DictService service = new DictService();
            DictServiceSoap port = service.getDictServiceSoap();

            List<Dictionary> dictList = port.dictionaryList().getDictionary();
            System.out.println("Woordenboeken:");
            for (Dictionary dict : dictList) {
                System.out.println(dict.getId() + ": " + dict.getName());
            }

            List<Dictionary> dictExtList = port.dictionaryListExtended().getDictionary();
            System.out.println("Extended:");
            for (Dictionary dict : dictExtList) {
                System.out.println(dict.getName());
            }

            List<Strategy> stratList = port.strategyList().getStrategy();
            System.out.println("Strategieen:");
            for (Strategy strat : stratList) {
                System.out.println(strat.getId() + ": " + strat.getDescription());
            }

            String searchWord = "obfus";
            String strategy = "prefix";
            List<DictionaryWord> wordList = port.match(searchWord, strategy).getDictionaryWord();
            System.out.println("Match \"obfus*\":");
            for (DictionaryWord word : wordList) {
                System.out.println(word.getWord());
            }

            System.out.println("Enter text: ");
            Scanner sc = new Scanner(System.in);
            String[] woorden = sc.nextLine().split(" ");
            strategy = "lev";
            for (String woord : woorden) {
                wordList = port.match(woord, strategy).getDictionaryWord();
                if (!wordList.isEmpty()) {
                    System.out.println(woord + "->");
                    for (DictionaryWord word : wordList) {
                        System.out.print(word.getWord()+" ");
                    }
                    System.out.println();
                }
            }
        } catch (Exception ex) {
            System.out.println("Fout: " + ex.getMessage());
        }
    }
}
