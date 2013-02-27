package it.apogeo.sushi.roboguice.dependency.injection;

import it.apogeo.sushi.roboguice.dependency.aggregation.Service;
import it.apogeo.sushi.roboguice.dependency.aggregation.ServiceA;
import it.apogeo.sushi.roboguice.dependency.annotation.InjectEnabled;
import it.apogeo.sushi.roboguice.dependency.annotation.SetterInjection;

/**
 * Example of Client that uses SetterInjection annotation
 * 
 * @author Massimo Carli - 17/ago/2012
 *
 */
public class SetterInjectionClient implements InjectEnabled{
	
	private Service localService;
	
	@SetterInjection(ServiceA.class)
	public void setService(Service service) {
		this.localService = service;
	}
	
	/**
	 * We use the service
	 */
	public String useService(String who){
		// We're using the service
		return localService.sayHello(who);
	}
	
}
