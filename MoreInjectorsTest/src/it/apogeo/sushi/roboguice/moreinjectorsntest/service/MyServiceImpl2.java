package it.apogeo.sushi.roboguice.moreinjectorsntest.service;

/**
 * A second Service implementation to use test
 * 
 * @author Massimo Carli - 29/ago/2012
 * 
 */
//@Singleton
public class MyServiceImpl2 implements MyService {

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
	public MyServiceImpl2() {
		// We increment instanceCount
		myCount = instanceCount++;
	}

	@Override
	public String whoAmI() {
		return "Service_2#" + myCount;
	}

}
