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
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.w3c.dom.Document;

/**
 *
 * @author Bjorn
 */
public class EquationServiceSOAPHandler implements SOAPHandler<SOAPMessageContext> {
    
    public boolean handleMessage(SOAPMessageContext messageContext) {
        Boolean outboundProperty = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!outboundProperty) {            
            SOAPMessage msg = messageContext.getMessage();
            try {
                SOAPBody body = msg.getSOAPBody();
                Node solveQuadratic = null;
                for(int i=0; i<body.getChildNodes().getLength();i++) {
                    if(body.getChildNodes().item(i).getLocalName().equals("solveQuadratic")) {
                        solveQuadratic = (Node) body.getChildNodes().item(i);
                        break;
                    }
                }
                if(solveQuadratic == null) return false;
                for(int i = 0; i< solveQuadratic.getChildNodes().getLength(); i++)  {
                    Document doc = solveQuadratic.getOwnerDocument();
                    Node node = (Node) solveQuadratic.getChildNodes().item(i);
                    switch(node.getLocalName()) {
                        case "a": doc.renameNode(node, node.getNamespaceURI(), "c1");
                            break;
                        case "b": doc.renameNode(node, node.getNamespaceURI(), "c2");
                            break;
                        case "c": doc.renameNode(node, node.getNamespaceURI(), "c3");
                            break;
                    }
                }
                msg.saveChanges();
            } catch (SOAPException ex) {
                Logger.getLogger(EquationServiceSOAPHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return true;
    }
    
    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }
    
    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }
    
    public void close(MessageContext context) {
    }
    
}
