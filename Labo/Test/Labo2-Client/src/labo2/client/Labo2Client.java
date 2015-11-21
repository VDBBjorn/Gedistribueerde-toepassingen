/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo2.client;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bjorn
 */
public class Labo2Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("a: ");
        double a = sc.nextDouble();
        System.out.println("b: ");
        double b = sc.nextDouble();
        System.out.println("c: ");
        double c = sc.nextDouble();
        List<Double> roots = solveQuadratic(a, b, c);
        System.out.print("roots for "+a+"x²+"+b+"x+"+c+" are ");
        for(Double r: roots) {
            System.out.print(r+" ");
        }
        System.out.println();
    }

    private static java.util.List<java.lang.Double> solveQuadratic(double a, double b, double c) {
        ws.EquationService_Service service = new ws.EquationService_Service();
        ws.EquationService port = service.getEquationServicePort();
        return port.solveQuadratic(a, b, c);
    }
    
    
}
