/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import static java.lang.Math.sqrt;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.HandlerChain;

/**
 *
 * @author Bjorn
 */
@WebService(serviceName = "EquationService")
@Stateless()
@HandlerChain(file = "EquationService_handler.xml")
public class EquationService {

    @WebMethod(operationName = "solveQuadratic")
    public Double[] solveQuadratic(@WebParam(name = "c1") Double a, @WebParam(name = "c2") Double b, @WebParam(name = "c3") Double c) {
        double discr = b*b-4*a*c;
        if(discr > 0) {
            Double[] root = new Double[2];
            root[0] = (b+sqrt(discr))/(-2*a);            
            root[1] = (b-sqrt(discr))/(-2*a);
            return root;
        }
        else if (discr == 0) {
            Double[] root = new Double[1];
            root[0] = (b+sqrt(discr))/(-2*a);
            return root;
        }
        return new Double[0];
    }
}
