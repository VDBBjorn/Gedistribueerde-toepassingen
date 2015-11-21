/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.Collections;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author vongenae
 */
public class TestMessageHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext messageContext) {
        Boolean outbound = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!outbound) {
            SOAPMessage msg = messageContext.getMessage();
            try {
                SOAPBody body = msg.getSOAPBody();
                Node bepaalNulpunten = body.getFirstChild();
                NodeList coefficienten = bepaalNulpunten.getChildNodes();
                for (int i = 0; i < coefficienten.getLength(); i++) {
                    Node coefficient = coefficienten.item(i);
                    switch (coefficient.getLocalName()) {
                        case "a":
                            veranderNodeName("c0", coefficient, bepaalNulpunten);
                            break;
                        case "b":
                            veranderNodeName("c1", coefficient, bepaalNulpunten);
                            break;
                        case "c":
                            veranderNodeName("c2", coefficient, bepaalNulpunten);
                            break;
                    }
                }
                msg.saveChanges();
            } catch (SOAPException ex) {
                Logger.getLogger(TestMessageHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    private void veranderNodeName(String naam, Node coefficient, Node bepaalNulpunten) throws DOMException {
        Document document = coefficient.getOwnerDocument();
        Node nieuw = document.createElement(naam);
        nieuw.appendChild(document.createTextNode(coefficient.getFirstChild().getNodeValue()));
        bepaalNulpunten.replaceChild(nieuw, coefficient);
    }

    @Override
    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }

    @Override
    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
    }

}
