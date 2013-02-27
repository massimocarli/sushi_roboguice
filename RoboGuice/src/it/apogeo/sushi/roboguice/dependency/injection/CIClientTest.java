package it.apogeo.sushi.roboguice.dependency.injection;

/**
 * This is a simple class for testing ConstructorInjectionClient
 * 
 * @author Massimo Carli - 21/ago/2012
 *
 */
public class CIClientTest {
	
	public static void main(String[] args) {
		// We create thje client
		ConstructorInjectionClient client = CustomInjector.createInjected(ConstructorInjectionClient.class);
		// We use the client
		String greetings = client.useService("Pippo");
		// We print the object
		System.out.println(greetings);
	}

}
