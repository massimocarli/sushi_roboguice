package it.apogeo.sushi.roboguice.dependency.injection;

import it.apogeo.sushi.roboguice.dependency.aggregation.Service;
import it.apogeo.sushi.roboguice.dependency.aggregation.ServiceA;
import it.apogeo.sushi.roboguice.dependency.annotation.ConstructorInjection;
import it.apogeo.sushi.roboguice.dependency.annotation.InjectEnabled;

/**
 * Example of Client that uses ConstructorInjection annotation
 * 
 * @author Massimo Carli - 17/ago/2012
 *
 */
public class ConstructorInjectionClient implements InjectEnabled{
	
	// The field is now final
	private final Service service;
	
	@ConstructorInjection(ServiceA.class)
	public ConstructorInjectionClient(Service service){
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
