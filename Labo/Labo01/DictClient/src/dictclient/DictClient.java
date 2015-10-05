/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictclient;

import com.aonaware.services.webservices.ArrayOfDictionaryWord;
import com.aonaware.services.webservices.DictionaryWord;
import java.util.Scanner;

/**
 *
 * @author bjorn
 */
public class DictClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter text:");
        Scanner in = new Scanner(System.in);
        String[] woorden = in.nextLine().split(" ");
        for(String woord : woorden){
            ArrayOfDictionaryWord array = match(woord,"lev");
            System.out.printf("%s->\n",woord);
            for(DictionaryWord dict : array.getDictionaryWord()){
                System.out.printf(" %s",dict.getWord());
            }
            System.out.println();
        }
    }

    private static ArrayOfDictionaryWord match(java.lang.String word, java.lang.String strategy) {
        com.aonaware.services.webservices.DictService service = new com.aonaware.services.webservices.DictService();
        com.aonaware.services.webservices.DictServiceSoap port = service.getDictServiceSoap();
        return port.match(word, strategy);
    }
    
}
