package it.apogeo.sushi.roboguice.module;

/**
 * Second implementation of Service 
 * 
 * @author Massimo Carli - 20/ago/2012
 *
 */
public class ServiceB implements Service{

	@Override
	public String sayHello(String who) {
		return "Service B says hello to "+who;
	}

}
