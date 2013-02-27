package it.apogeo.sushi.roboguice.module;

import it.apogeo.sushi.roboguice.dependency.annotation.InjectEnabled;

/**
 * Example of a simple Manager Interface
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
public interface Manager extends InjectEnabled{
	
	/**
	 * Example of an operation that manage something
	 * @param input The input for this method
	 */
	public void manageSomething(String input);

}
