/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author vongenae
 */
@WebService(serviceName = "EquationService")
@HandlerChain(file = "EquationService_handler.xml")
public class EquationService {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "bepaalNulpunten")
    public double[] solveQuadratic(@WebParam(name = "c0") double a, @WebParam(name = "c1") double b, @WebParam(name = "c2") double c) {
         // solve a x^2 + b x + c
        double discr = b * b - 4 * a * c;
        if (discr < 0) {
            return new double[0];
        } else if (Math.abs(discr) < 1e-10) {
            return new double[]{(-b + Math.sqrt(discr)) / (2 * a)};
        } else {
            return new double[]{
                (-b + Math.sqrt(discr)) / (2 * a),
                (-b - Math.sqrt(discr)) / (2 * a)
            };
        }
    }
}
