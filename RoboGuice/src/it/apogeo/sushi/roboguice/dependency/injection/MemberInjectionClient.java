package it.apogeo.sushi.roboguice.dependency.injection;

import it.apogeo.sushi.roboguice.dependency.aggregation.Service;
import it.apogeo.sushi.roboguice.dependency.aggregation.ServiceB;
import it.apogeo.sushi.roboguice.dependency.annotation.InjectEnabled;
import it.apogeo.sushi.roboguice.dependency.annotation.MemberInjection;

/**
 * Example of Client that uses MemberInjection annotation
 * 
 * @author Massimo Carli - 17/ago/2012
 *
 */
public class MemberInjectionClient implements InjectEnabled{
	
	@MemberInjection(ServiceB.class)
	private Service service;
	
	/**
	 * We use the service
	 */
	public String useService(String who){
		// We're using the service
		return service.sayHello(who);
	}
	
}
