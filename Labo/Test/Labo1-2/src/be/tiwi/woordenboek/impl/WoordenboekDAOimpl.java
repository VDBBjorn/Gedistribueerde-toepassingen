/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.tiwi.woordenboek.impl;

import be.tiwi.woordenboek.data.Woordenboek;
import be.tiwi.woordenboek.data.WoordenboekDAO;
import com.aonaware.services.webservices.ArrayOfDictionary;
import com.aonaware.services.webservices.ArrayOfDictionaryWord;
import com.aonaware.services.webservices.Definition;
import com.aonaware.services.webservices.Dictionary;
import com.aonaware.services.webservices.DictionaryWord;
import com.aonaware.services.webservices.WordDefinition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bjorn
 */
public class WoordenboekDAOimpl implements WoordenboekDAO {

    @Override
    public List<Woordenboek> getWoordenboeken() {
        ArrayOfDictionary lijst = dictionaryList();
        List<Dictionary> dictionaries = lijst.getDictionary();
        List<Woordenboek> woordenboeken = new ArrayList<>();
        dictionaries.stream().forEach((d) -> {
            woordenboeken.add(new Woordenboek(d.getId(),d.getName()));
        });
        return woordenboeken;
    }

    @Override
    public List<String> zoekWoorden(String prefix, String woordenboekId) {
        List<DictionaryWord> words = matchInDict(woordenboekId, prefix, "lev").getDictionaryWord();
        List<String> woorden = new ArrayList<>();
        words.stream().forEach((w) -> { 
            woorden.add(w.getWord()); 
        });
        return woorden;
    }

    @Override
    public List<String> getDefinities(String woord, String woordenboekId) {
        List<Definition> lijst = defineInDict(woordenboekId,woord).getDefinitions().getDefinition();
        List<String> definities = new ArrayList<>();
        lijst.stream().forEach((d) -> {
            definities.add(d.getWordDefinition());
        });
        return definities;
    }

    private static ArrayOfDictionary dictionaryList() {
        com.aonaware.services.webservices.DictService service = new com.aonaware.services.webservices.DictService();
        com.aonaware.services.webservices.DictServiceSoap port = service.getDictServiceSoap();
        return port.dictionaryList();
    }

    private static ArrayOfDictionaryWord matchInDict(java.lang.String dictId, java.lang.String word, java.lang.String strategy) {
        com.aonaware.services.webservices.DictService service = new com.aonaware.services.webservices.DictService();
        com.aonaware.services.webservices.DictServiceSoap port = service.getDictServiceSoap();
        return port.matchInDict(dictId, word, strategy);
    }

    private static WordDefinition defineInDict(java.lang.String dictId, java.lang.String word) {
        com.aonaware.services.webservices.DictService service = new com.aonaware.services.webservices.DictService();
        com.aonaware.services.webservices.DictServiceSoap port = service.getDictServiceSoap();
        return port.defineInDict(dictId, word);
    }
    
    
    
}
