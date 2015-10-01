
package webclient.catalogus.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for boek complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="boek">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prijs" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="titel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "boek", propOrder = {
    "isbn",
    "prijs",
    "titel"
})
public class Boek {

    protected String isbn;
    protected double prijs;
    protected String titel;

    /**
     * Gets the value of the isbn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the value of the isbn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsbn(String value) {
        this.isbn = value;
    }

    /**
     * Gets the value of the prijs property.
     * 
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * Sets the value of the prijs property.
     * 
     */
    public void setPrijs(double value) {
        this.prijs = value;
    }

    /**
     * Gets the value of the titel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Sets the value of the titel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitel(String value) {
        this.titel = value;
    }

}
