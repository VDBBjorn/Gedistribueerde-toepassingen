package client;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author bjorn
 */
public class Client implements AutoCloseable, Observer {

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
