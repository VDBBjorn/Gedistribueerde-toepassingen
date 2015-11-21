package com.example.helloworld;

/**
 *
 * @author bjorn
 */
public class MyBean {
    private String myData;
    private Double[] myRoots;

    public String getData() {
        return myData;
    }
    
    public Double[] getRoots() {
        return myRoots;
    }

    public void setData(String data) {
        myData = data;
    }

    void setRoots(Double[] roots) {
        myRoots = roots;
    }
}
