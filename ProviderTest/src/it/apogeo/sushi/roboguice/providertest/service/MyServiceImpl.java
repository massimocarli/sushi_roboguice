package it.apogeo.sushi.roboguice.providertest.service;


/**
 * The Service implementation to use test
 * 
 * @author Massimo Carli - 29/ago/2012
 * 
 */
//@Singleton
public class MyServiceImpl implements MyService {

	/*
	 * The current instance count
	 */
	private static int instanceCount = 0;
	
	/*
	 * The current count
	 */
	private int myCount;

	/**
	 * Default Constructor
	 */
	public MyServiceImpl() {
		// We increment instanceCount
		myCount = instanceCount++;
	}

	@Override
	public String whoAmI() {
		return "Service#" + myCount;
	}

}
