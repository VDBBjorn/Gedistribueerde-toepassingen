package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.JMSRuntimeException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author bjorn
 */
public class TextListener implements MessageListener {
    
    private QuizWorker worker;
    
    public TextListener(QuizWorker w) {
        worker = w;
    }

    @Override
    public void onMessage(Message m) {
        try {
            if (m instanceof TextMessage) {
                String message = m.getBody(String.class);
                Logger.getLogger(QuizWorker.class.getName()).log(Level.INFO, "Reading message: {0}", message);
                worker.parseAnswer(message);
            }
        } catch (JMSException | JMSRuntimeException e) {
            System.err.println("JMSException in onMessage(): " + e.toString());
        }
    }

}