/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo2b.client;

import java.util.Scanner;

/**
 *
 * @author Bjorn
 */
public class Labo2bClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("a? ");
        double a = sc.nextDouble(); 
        System.out.println("b? ");       
        double b = sc.nextDouble();
        System.out.println("c? ");
        double c = sc.nextDouble();
        System.out.println("roots: "+solveQuadratic(a,b,c).toString());
    }

    private static java.util.List<java.lang.Double> solveQuadratic(java.lang.Double a, java.lang.Double b, java.lang.Double c) {
        ws.EquationService_Service service = new ws.EquationService_Service();
        ws.EquationService port = service.getEquationServicePort();
        return port.solveQuadratic(a, b, c);
    }
    
    
    
}
