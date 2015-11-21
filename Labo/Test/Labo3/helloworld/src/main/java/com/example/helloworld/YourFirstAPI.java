package com.example.helloworld;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import static java.lang.Math.sqrt;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(name = "myApi",
     version = "v1",
     namespace = @ApiNamespace(ownerDomain = "helloworld.example.com",
                                ownerName = "helloworld.example.com",
                                packagePath=""))
public class YourFirstAPI {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }
    
    @ApiMethod(name = "solveEquation")
    public MyBean solveEquations(@Named("a") Double a,@Named("b") Double b,@Named("c") Double c) {
        Double roots[];
        double d = b*b-4*a*c;
        if(d>=0) {
            double x1 = (-b+sqrt(d))/(2*a);
            double x2 = (-b-sqrt(d))/(2*a);
            if(x1!=x2) {
                roots = new Double[2];
                roots[0] = x1;
                roots[1] = x2;                
            }
            else {
                roots = new Double[1];
                roots[0] = x1;
            }
        }
        else {
            roots = new Double[0];
        }
                
        MyBean response = new MyBean();
        response.setRoots(roots);
        return response;
    }

}