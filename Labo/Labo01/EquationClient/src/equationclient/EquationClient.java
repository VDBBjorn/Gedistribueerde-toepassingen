/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equationclient;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bjorn
 */
public class EquationClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a? ");
        int a = sc.nextInt();
        System.out.print("b? ");
        int b = sc.nextInt();
        System.out.print("c? ");
        int c = sc.nextInt();
        List<Double> roots = solveQuadratic(a,b,c);
        System.out.printf("roots -> { ");
        for(Double root:roots) {
            System.out.printf("%.0f ", root);
        }
        System.out.printf("}\n");
    }

    private static java.util.List<java.lang.Double> solveQuadratic(double a, double b, double c) {
        service.EquationSolver_Service service = new service.EquationSolver_Service();
        service.EquationSolver port = service.getEquationSolverPort();
        return port.solveQuadratic(a, b, c);
    }
    
    
    
}
