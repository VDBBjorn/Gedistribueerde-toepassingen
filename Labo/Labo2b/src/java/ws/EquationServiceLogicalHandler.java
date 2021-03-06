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
 * @author Bjorn
 */
public class EquationServiceLogicalHandler implements LogicalHandler<LogicalMessageContext> {
    
    public boolean handleMessage(LogicalMessageContext messageContext) {
        Boolean outbound = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!outbound) {
            try {
                LogicalMessage msg = messageContext.getMessage();
                Source inhoud = msg.getPayload();
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer tf = factory.newTransformer(new StreamSource(this.getClass().getClassLoader().getResourceAsStream("ws/nieuweversie.xsl")));
                DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = dFactory.newDocumentBuilder();
                Document document = builder.newDocument();
                DOMResult aangepast = new DOMResult(document);
                tf.transform(inhoud, aangepast);
                msg.setPayload(new DOMSource(aangepast.getNode()));
            } catch (TransformerConfigurationException | ParserConfigurationException ex) {
                Logger.getLogger(EquationServiceLogicalHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(EquationServiceLogicalHandler.class.getName()).log(Level.SEVERE, null, ex);
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
