/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Bjorn
 */
public class EquationHandler implements SOAPHandler<SOAPMessageContext> {
    
    public boolean handleMessage(SOAPMessageContext messageContext) {
        String outProperty = SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY;
        boolean outgoing = (Boolean)messageContext.get(outProperty);
        
        SOAPMessage msg = messageContext.getMessage();
        try
        {
          if (outgoing)        
             msg.writeTo(new FileOutputStream("C:/temp/responseMessage.txt"));
          else {
              
            msg.writeTo(new FileOutputStream("C:/temp/inputMessage.txt"));
            SOAPMessage soapMessage =  messageContext.getMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            SOAPBody soapBody = soapEnvelope.getBody();
            NodeList nodeList = soapBody.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node currentNode = nodeList.item(i);
                if ("solveQuadratic".equals(currentNode.getLocalName())) {
                    NodeList properties = currentNode.getChildNodes();                       
                    Document doc = currentNode.getOwnerDocument();
                    doc.renameNode(properties.item(0), properties.item(0).getNamespaceURI(), "c1");
                    doc.renameNode(properties.item(1), properties.item(1).getNamespaceURI(), "c2");
                    doc.renameNode(properties.item(2), properties.item(2).getNamespaceURI(), "c3");
                }
           }            
          }
        }
        catch(IOException | SOAPException e)
        {
            throw new RuntimeException(e) ;
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
