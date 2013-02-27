package it.apogeo.sushi.roboguice.dependency.injection;

/**
 * This is a simple class for testing SetterInjectionClient
 * 
 * @author Massimo Carli - 21/ago/2012
 *
 */
public class SIClientTest {
	
	public static void main(String[] args) {
		// We create thje client
		SetterInjectionClient client = new SetterInjectionClient();
		// We inject objects
		CustomInjector.inject(client);
		// We use the client
		String greetings = client.useService("Pippo");
		// We print the object
		System.out.println(greetings);
	}

}
