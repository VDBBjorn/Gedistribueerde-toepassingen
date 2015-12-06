/*
 */
package ui;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import domain.QuizWorker;

/**
 *
 * @author bjorn
 */
public class Main {

    @Resource(mappedName = "QuizQueueConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/QuizQueue")
    private static Queue queue;
    public static void main(String[] args) {
        Thread t = new Thread(new QuizWorker(connectionFactory, queue));
        t.start();
    }
    
}
