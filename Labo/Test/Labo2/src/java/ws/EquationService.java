/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.HandlerChain;

/**
 *
 * @author bjorn
 */
@WebService(serviceName = "EquationService")
@Stateless()
@HandlerChain(file = "EquationService_handler.xml")
public class EquationService {

    /**
     * This is a sample web service operation
     * ax² + bx + c = 0
     * @param a
     * @param b
     * @param c
     * @return array of roots
     */
    @WebMethod(operationName = "solveQuadratic")
    public double[] hello(@WebParam(name = "c1") double a, @WebParam(name = "c2") double b, @WebParam(name = "c3") double c) {
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
