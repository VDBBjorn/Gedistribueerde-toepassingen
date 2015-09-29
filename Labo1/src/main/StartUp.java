/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import DictService.ArrayOfDictionaryWord;
import DictService.DictionaryWord;
import java.util.Scanner;

/**
 *
 * @author Tim Ranson
 */
public class StartUp {

    private static ArrayOfDictionaryWord match(java.lang.String word, java.lang.String strategy) {
        DictService.DictService service = new DictService.DictService();
        DictService.DictServiceSoap port = service.getDictServiceSoap();
        return port.match(word, strategy);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] woorden = in.nextLine().split(" ");
        for(String woord : woorden){
            ArrayOfDictionaryWord array = match(woord,"lev");
            System.out.printf("->%s\n",woord);
            for(DictionaryWord dict : array.getDictionaryWord()){
                System.out.printf(" %s",dict.getWord());
            }
            System.out.println();
        }
    }
    
}
