
package be.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the be.ws package. 
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

    private final static QName _BepaalNulpunten_QNAME = new QName("http://ws/", "bepaalNulpunten");
    private final static QName _HelloResponse_QNAME = new QName("http://ws/", "helloResponse");
    private final static QName _Hello_QNAME = new QName("http://ws/", "hello");
    private final static QName _BepaalNulpuntenResponse_QNAME = new QName("http://ws/", "bepaalNulpuntenResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: be.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BepaalNulpunten }
     * 
     */
    public BepaalNulpunten createBepaalNulpunten() {
        return new BepaalNulpunten();
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
     * Create an instance of {@link BepaalNulpuntenResponse }
     * 
     */
    public BepaalNulpuntenResponse createBepaalNulpuntenResponse() {
        return new BepaalNulpuntenResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BepaalNulpunten }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "bepaalNulpunten")
    public JAXBElement<BepaalNulpunten> createBepaalNulpunten(BepaalNulpunten value) {
        return new JAXBElement<BepaalNulpunten>(_BepaalNulpunten_QNAME, BepaalNulpunten.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BepaalNulpuntenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "bepaalNulpuntenResponse")
    public JAXBElement<BepaalNulpuntenResponse> createBepaalNulpuntenResponse(BepaalNulpuntenResponse value) {
        return new JAXBElement<BepaalNulpuntenResponse>(_BepaalNulpuntenResponse_QNAME, BepaalNulpuntenResponse.class, null, value);
    }

}
