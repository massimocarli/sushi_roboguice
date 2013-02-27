package it.apogeo.sushi.roboguice.module;

/**
 * This is an interface that abstracts the operation we need
 * 
 * @author Massimo Carli - 20/ago/2012
 *
 */
public interface Service {
	
	/**
	 * Says hello to the diven name
	 * @param who The name to say hello
	 * @return The greetings for the given who
	 */
	public String sayHello(String who);	

}
