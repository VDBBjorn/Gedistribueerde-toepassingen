
package webclient.catalogus.web;

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
@WebService(name = "Catalogus", targetNamespace = "http://web.boeken.iii.be/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Catalogus {


    /**
     * 
     * @param isbn
     * @return
     *     returns webclient.catalogus.web.Boek
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "geefBoek", targetNamespace = "http://web.boeken.iii.be/", className = "webclient.catalogus.web.GeefBoek")
    @ResponseWrapper(localName = "geefBoekResponse", targetNamespace = "http://web.boeken.iii.be/", className = "webclient.catalogus.web.GeefBoekResponse")
    @Action(input = "http://web.boeken.iii.be/Catalogus/geefBoekRequest", output = "http://web.boeken.iii.be/Catalogus/geefBoekResponse")
    public Boek geefBoek(
        @WebParam(name = "isbn", targetNamespace = "")
        String isbn);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://web.boeken.iii.be/", className = "webclient.catalogus.web.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://web.boeken.iii.be/", className = "webclient.catalogus.web.HelloResponse")
    @Action(input = "http://web.boeken.iii.be/Catalogus/helloRequest", output = "http://web.boeken.iii.be/Catalogus/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
