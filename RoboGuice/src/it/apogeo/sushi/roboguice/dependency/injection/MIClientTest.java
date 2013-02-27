package it.apogeo.sushi.roboguice.dependency.injection;

/**
 * This is a simple class for testing MemberInjectionClient
 * 
 * @author Massimo Carli - 21/ago/2012
 *
 */
public class MIClientTest {
	
	public static void main(String[] args) {
		// We create thje client
		MemberInjectionClient client = new MemberInjectionClient();
		// We inject objects
		CustomInjector.inject(client);
		// We use the client
		String greetings = client.useService("Pippo");
		// We print the object
		System.out.println(greetings);
	}

}
