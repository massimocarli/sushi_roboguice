package it.apogeo.sushi.roboguice.providertest.service;

import com.google.inject.Singleton;


/**
 * The Service implementation to use test
 * 
 * @author Massimo Carli - 29/ago/2012
 * 
 */
@Singleton
public class BeforeDunatServiceImpl implements MyService {

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
	public BeforeDunatServiceImpl() {
		// We increment instanceCount
		myCount = instanceCount++;
	}

	@Override
	public String whoAmI() {
		return "BeforeDunatServiceImpl#" + myCount;
	}

}
