package it.apogeo.sushi.roboguice.dependency.composition;

import it.apogeo.sushi.roboguice.dependency.Service;

/**
 * Example of using Service with composition
 * 
 * @author Massimo Carli - 17/ago/2012
 *
 */
public class Client {
	
	/*
	 * We created a service instance of the Service class
	 */
	private Service service = new Service();
	
	/**
	 * We use the service
	 */
	public String useService(String who){
		// We're using the service
		return service.sayHello(who);
	}

}
