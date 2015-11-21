/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testequationservice;

import be.ws.EquationService;
import be.ws.EquationService_Service;

/**
 *
 * @author vongenae
 */
public class TestEquationService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (double root : berekenNulpunten(1, -5, 6)) {
            System.out.println(root);
        }
        
        for (double root : berekenNulpunten(2, -4, 2)) {
            System.out.println(root);
        }
        
        for (double root : berekenNulpunten(5, 1, 2)) {
            System.out.println(root);
        }
    }

    private static java.util.List<java.lang.Double> berekenNulpunten(double a, double b, double c) {
        EquationService_Service service = new EquationService_Service();
        EquationService port = service.getEquationServicePort();
        return port.bepaalNulpunten(a, b, c);
    }
    
}
