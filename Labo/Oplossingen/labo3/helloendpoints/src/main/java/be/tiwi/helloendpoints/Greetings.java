package be.tiwi.helloendpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.users.User;

import java.util.ArrayList;

import javax.inject.Named;

/**
 * Defines v1 of a helloworld API, which provides simple "greeting" methods.
 */
@Api(
    name = "helloworld",
    version = "v1",
    scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    audiences = {Constants.ANDROID_AUDIENCE}
)
public class Greetings {

  public static ArrayList<HelloGreeting> greetings = new ArrayList<HelloGreeting>();

  static {
    greetings.add(new HelloGreeting("hello world!"));
    greetings.add(new HelloGreeting("goodbye world!"));
  }

  public HelloGreeting getGreeting(@Named("id") Integer id) throws NotFoundException {
    try {
      return greetings.get(id);
    } catch (IndexOutOfBoundsException e) {
      throw new NotFoundException("Greeting not found with an index: " + id);
    }
  }

  public ArrayList<HelloGreeting> listGreeting() {
    return greetings;
  }

  @ApiMethod(name = "greetings.multiply", httpMethod = "post")
  public HelloGreeting insertGreeting(@Named("times") Integer times, HelloGreeting greeting) {
    HelloGreeting response = new HelloGreeting();
    StringBuilder responseBuilder = new StringBuilder();
    for (int i = 0; i < times; i++) {
      responseBuilder.append(greeting.getMessage());
    }
    response.setMessage(responseBuilder.toString());
    return response;
  }

  @ApiMethod(name = "greetings.authed", path = "hellogreeting/authed")
  public HelloGreeting authedGreeting(User user) {
    HelloGreeting response = new HelloGreeting("hello " + user.getEmail());
    return response;
  }

  public HelloGreeting solveEquation(@Named("a") int a, @Named("b") int b, @Named("c") int c) {
    // solve a x^2 + b x + c
        double discr = b * b - 4 * a * c;
        double[] nulptn;
        if (discr < 0) {
            nulptn = new double[0];
        } else if (Math.abs(discr) < 1e-10) {
            nulptn = new double[]{(-b + Math.sqrt(discr)) / (2 * a)};
        } else {
            nulptn = new double[]{
                (-b + Math.sqrt(discr)) / (2 * a),
                (-b - Math.sqrt(discr)) / (2 * a)
            };
        }
        StringBuilder bericht = new StringBuilder("nulpunten: ");
	for(double nulpt : nulptn) {
	  bericht.append(nulpt);
	  bericht.append(", ");
        }
        bericht.deleteCharAt(bericht.length()-1);
	return new HelloGreeting(bericht.toString());
  }
}
