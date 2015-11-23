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
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;

/**
 *
 * @author bjorn
 */
public class EquationService_SOAPHandler implements SOAPHandler<SOAPMessageContext> {
    
    @Override
    public boolean handleMessage(SOAPMessageContext messageContext) {
        Boolean outbound = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(!outbound) {
            SOAPMessage msg = messageContext.getMessage();
            try {
                SOAPBody body = msg.getSOAPBody();
                Node bepaalNulpunten = null;
                for(int i=0; i<body.getChildNodes().getLength();i++) {
                    if(body.getChildNodes().item(i).getLocalName().equals("solveQuadratic")) {
                        bepaalNulpunten = (Node) body.getChildNodes().item(i);
                        break;
                    }
                }
                if(bepaalNulpunten == null) return false;
                for(int i=0; i<bepaalNulpunten.getChildNodes().getLength();i++) {
                    Node node = (Node) bepaalNulpunten.getChildNodes().item(i);
                    Document doc = node.getOwnerDocument();
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
            }
            catch (SOAPException | DOMException e) {
                Logger.getLogger(EquationService_SOAPHandler.class.getName()).log(Level.SEVERE, null, e);
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
