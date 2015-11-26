
package be.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EquationService", targetNamespace = "http://ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EquationService {


    /**
     * 
     * @param b
     * @param c
     * @param a
     * @return
     *     returns java.util.List<java.lang.Double>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "bepaalNulpunten", targetNamespace = "http://ws/", className = "be.ws.BepaalNulpunten")
    @ResponseWrapper(localName = "bepaalNulpuntenResponse", targetNamespace = "http://ws/", className = "be.ws.BepaalNulpuntenResponse")
    @Action(input = "http://ws/EquationService/bepaalNulpuntenRequest", output = "http://ws/EquationService/bepaalNulpuntenResponse")
    public List<Double> bepaalNulpunten(
        @WebParam(name = "a", targetNamespace = "")
        double a,
        @WebParam(name = "b", targetNamespace = "")
        double b,
        @WebParam(name = "c", targetNamespace = "")
        double c);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://ws/", className = "be.ws.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://ws/", className = "be.ws.HelloResponse")
    @Action(input = "http://ws/EquationService/helloRequest", output = "http://ws/EquationService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
