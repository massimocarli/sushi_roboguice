package it.apogeo.sushi.roboguice.module;

/**
 * First implementation of Service 
 * 
 * @author Massimo Carli - 20/ago/2012
 *
 */
public class ServiceA implements Service{

	@Override
	public String sayHello(String who) {
		return "Service A says hello to "+who;
	}

}
