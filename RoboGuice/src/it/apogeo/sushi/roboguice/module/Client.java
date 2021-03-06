package it.apogeo.sushi.roboguice.module;

import it.apogeo.sushi.roboguice.dependency.annotation.InjectEnabled;

/**
 * Example of Client that uses unified annotation for managing dependency with
 * 2 different objects
 * 
 * @author Massimo Carli - 17/ago/2012
 *
 */
public class Client implements InjectEnabled{
	
	@Inject
	private Service service;
	
	@Inject 
	private Manager manager;
	
	/**
	 * We use the service
	 */
	public String useService(String who){
		manager.manageSomething(who);
		// We're using the service
		return service.sayHello(who);
	}
	
}
