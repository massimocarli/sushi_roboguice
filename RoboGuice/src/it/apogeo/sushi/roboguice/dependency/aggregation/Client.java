package it.apogeo.sushi.roboguice.dependency.aggregation;

import it.apogeo.sushi.roboguice.dependency.Service;

/**
 * Implementation of the Client for using Service in a IoC context
 * 
 * @author Massimo Carli - 20/ago/2012
 *
 */
public class Client {
	
	/*
	 * The Service reference
	 */
	private Service service;
	
	/**
	 * Set the Service reference
	 * @param service The Service reference
	 */
	public void setService(Service service){
		this.service = service;
	}
	
	/**
	 * We use the service
	 */
	public String useService(String who){
		// We're using the service
		return service.sayHello(who);
	}	

}
