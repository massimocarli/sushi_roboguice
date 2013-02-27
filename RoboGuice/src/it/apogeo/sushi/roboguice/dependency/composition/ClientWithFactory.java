package it.apogeo.sushi.roboguice.dependency.composition;

import it.apogeo.sushi.roboguice.dependency.Service;
import it.apogeo.sushi.roboguice.dependency.ServiceFactory;

/**
 * Example of a client that uses a factory method to obtain the Service instance
 * 
 * @author Massimo Carli - 20/ago/2012
 *
 */
public class ClientWithFactory {
	
	/*
	 * We get an instance of Service from a ServiceFactory
	 */
	private Service service = ServiceFactory.INSTANCE.getInstance();
	
	public String useService(String who){
		// We're using the service
		return service.sayHello(who);
	}	

}
