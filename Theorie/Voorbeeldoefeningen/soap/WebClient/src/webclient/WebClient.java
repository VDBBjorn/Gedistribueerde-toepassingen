/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webclient;

import webclient.catalogus.web.Boek;

/**
 *
 * @author tiwi
 */
public class WebClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 2; i <= 3; i++) {
            java.lang.String isbn = Integer.toString(i);
            Boek boek = geefBoek("isbn"+isbn);
            System.out.println(boek.getTitel());
        }
    }
    
    private static Boek geefBoek(java.lang.String isbn) {
        webclient.catalogus.web.Catalogus_Service service 
                = new webclient.catalogus.web.Catalogus_Service();
        webclient.catalogus.web.Catalogus port 
                = service.getCatalogusPort();
        return port.geefBoek(isbn);
    }
 
    
    
}
