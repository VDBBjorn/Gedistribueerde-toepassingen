
package webclient.catalogus.web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webclient.catalogus.web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GeefBoekResponse_QNAME = new QName("http://web.boeken.iii.be/", "geefBoekResponse");
    private final static QName _GeefBoek_QNAME = new QName("http://web.boeken.iii.be/", "geefBoek");
    private final static QName _HelloResponse_QNAME = new QName("http://web.boeken.iii.be/", "helloResponse");
    private final static QName _Hello_QNAME = new QName("http://web.boeken.iii.be/", "hello");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webclient.catalogus.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GeefBoekResponse }
     * 
     */
    public GeefBoekResponse createGeefBoekResponse() {
        return new GeefBoekResponse();
    }

    /**
     * Create an instance of {@link GeefBoek }
     * 
     */
    public GeefBoek createGeefBoek() {
        return new GeefBoek();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Boek }
     * 
     */
    public Boek createBoek() {
        return new Boek();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeefBoekResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.boeken.iii.be/", name = "geefBoekResponse")
    public JAXBElement<GeefBoekResponse> createGeefBoekResponse(GeefBoekResponse value) {
        return new JAXBElement<GeefBoekResponse>(_GeefBoekResponse_QNAME, GeefBoekResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeefBoek }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.boeken.iii.be/", name = "geefBoek")
    public JAXBElement<GeefBoek> createGeefBoek(GeefBoek value) {
        return new JAXBElement<GeefBoek>(_GeefBoek_QNAME, GeefBoek.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.boeken.iii.be/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.boeken.iii.be/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

}
