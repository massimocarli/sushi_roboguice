package it.apogeo.sushi.roboguice.dependency;

/**
 * This is a simple class that describes a Service with a method 
 * 
 * @author Massimo Carli - 17/ago/2012
 *
 */
public class Service {

	/**
	 * Says hello to the diven name
	 * @param who The name to say hello
	 * @return The greetings for the given who
	 */
	public String sayHello(String who){
		// Not so efficient to use + but in this case it doesn't matter
		return "Hello "+who;
	}
	
	
}
