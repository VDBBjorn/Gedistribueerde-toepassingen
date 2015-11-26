/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import org.w3c.dom.Document;

/**
 *
 * @author bjorn
 */
public class EquationService_LogicalHandler implements LogicalHandler<LogicalMessageContext> {
    
    public boolean handleMessage(LogicalMessageContext messageContext) {
        Boolean outbound = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(!outbound) {
            try {
                LogicalMessage msg = messageContext.getMessage();
                Source inhoud = msg.getPayload();
                
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer tf = factory.newTransformer(new StreamSource(this.getClass().getClassLoader().getResourceAsStream("ws/nieuweVersie.xsl")));
                
                DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = dFactory.newDocumentBuilder();
                
                Document document = builder.newDocument();
                DOMResult aangepast = new DOMResult(document);
                
                tf.transform(inhoud, aangepast);
                
                msg.setPayload(new DOMSource(aangepast.getNode()));
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(EquationService_LogicalHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException | TransformerException ex) {
                Logger.getLogger(EquationService_LogicalHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
    
    public boolean handleFault(LogicalMessageContext messageContext) {
        return true;
    }
    
    public void close(MessageContext context) {
    }
    
}
