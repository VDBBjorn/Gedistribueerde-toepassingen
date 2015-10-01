/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.iii.boeken.web;

import be.iii.catalogus.Boek;
import be.iii.catalogus.BoekenLijst;
import be.iii.catalogus.impl.BoekenLijstImpl;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author tiwi
 */
@WebService(serviceName = "Catalogus")
public class Catalogus {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
     /**
     * Web service operation: geeft boek op basis van ISBN-nummer
     * @param isbn
     * @return 
     */
    @WebMethod(operationName = "geefBoek")
    public Boek geefBoek(@WebParam(name = "isbn") String isbn) {
        try {
            BoekenLijst boeken = new BoekenLijstImpl();
            return boeken.geefBoek(isbn);
        } catch (Exception e) {
            return null;
        }
    }
}
