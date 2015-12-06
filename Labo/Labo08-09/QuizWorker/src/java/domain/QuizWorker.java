package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;

/**
 *
 * @author bjorn
 */
public class QuizWorker implements Runnable {
    
    private ConnectionFactory connectionFactory;
    private Queue queue;
    private Quiz quiz;
    private HashMap<String, Integer> userPoints;
    private int questionId;
    private boolean answered;
    private List<String> usersAnswered;
    
    public QuizWorker(ConnectionFactory cf, Queue q) {
        this.connectionFactory = cf;
        this.queue = q;
        this.quiz = new Quiz();
        
        userPoints = new HashMap<>();
        usersAnswered = new LinkedList<>();
    }

    @Override
    public void run() {
        try (JMSContext context = connectionFactory.createContext();) {
            JMSConsumer consumer = context.createConsumer(queue);
            TextListener listener = new TextListener(this);
            consumer.setMessageListener(listener);
            while(true) {
                //keep awake
            }
        } catch (JMSRuntimeException e) {
            Logger.getLogger(QuizWorker.class.getName()).log(Level.SEVERE, "Exception occurred: {0}", e.toString());
            System.exit(1);
        }
    }

    void parseAnswer(String message) {
        if(message.startsWith("SEND QUESTION")) {
            String[] split = message.split(" ", 3);
            questionId = Integer.parseInt(split[2]);
            answered = false;
            usersAnswered = new LinkedList<>();
        }
        else if(message.startsWith("ANSWER")) {
            String[] split = message.split(" ", 4);
            int qId = Integer.parseInt(split[2]);
            if(qId != questionId) {
                return;
            }
            String answer = split[3];
            int index = answer.indexOf("BY ");
            String a = answer.substring(0,index);
            String user = answer.substring(index+3);
            boolean ok = true;
            for(String u : usersAnswered) {
                if(u.equals(user)) {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                if(quiz.isCorrect(questionId, a.trim())) {
                    Logger.getLogger(QuizWorker.class.getName()).log(Level.INFO, "{0} answered a question correctly", user);
                    if(!answered) {
                        answered = true;
                        addPoints(user,5);
                    }
                    else {
                        addPoints(user,1);
                    }
                }
                else {
                    Logger.getLogger(QuizWorker.class.getName()).log(Level.INFO, "{0} answered a question wrong", user);
                }
                usersAnswered.add(user);
            }
            else {
                Logger.getLogger(QuizWorker.class.getName()).log(Level.INFO, "{0} tried to answer a question for the second time...", user);
            }
        }
    }

    private void addPoints(String user, int i) {
        if(!userPoints.containsKey(user)) {
            userPoints.put(user,i);
        }
        else {
            int points = userPoints.get(user);
            points += i;
            userPoints.put(user, points);
        }
    }
    
    public Map<String, Integer> getSortedUserPoints() {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(userPoints.entrySet());
        Collections.sort(list, (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> {
                return o2.getValue().compareTo(o1.getValue());            
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        list.stream().forEach((entry) -> {
            sortedMap.put(entry.getKey(), entry.getValue());
        });
        return sortedMap;
    }
    
    public Integer getPointsForUser(String user) {
        return userPoints.get(user);
    }

    void removeUser(String user) {
        userPoints.remove(user);
    }
    
    

}
