/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static java.lang.Math.sqrt;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author bjorn
 */
@WebService(serviceName = "EquationSolver")
@Stateless()
public class EquationSolver {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solveQuadratic")
    public double[] solveQuadratic(@WebParam(name = "a") double a, @WebParam(name = "b") double b, @WebParam(name = "c") double c) {
        double roots[];
        double d = b*b-4*a*c;
        if(d>=0) {
            double x1 = (-b+sqrt(d))/(2*a);
            double x2 = (-b-sqrt(d))/(2*a);
            if(x1!=x2) {
                roots = new double[2];
                roots[0] = x1;
                roots[1] = x2;                
            }
            else {
                roots = new double[1];
                roots[0] = x1;
            }
        }
        else {
            roots = new double[0];
        }
        return roots;
    }
}
