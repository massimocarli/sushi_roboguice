package it.apogeo.sushi.roboguice.dependency.composition;

import it.apogeo.sushi.roboguice.dependency.Service;
import it.apogeo.sushi.roboguice.dependency.ServiceStaticFactoryMethod;

/**
 * Example of a client that uses a factory method to obtain the Service instance
 * 
 * @author Massimo Carli - 20/ago/2012
 *
 */
public class ClientWithStaticFactory {
	
	/*
	 * We created a service instance of the Service class
	 */
	private Service service = ServiceStaticFactoryMethod.getInstance();
	
	public String useService(String who){
		// We're using the service
		return service.sayHello(who);
	}	

}
