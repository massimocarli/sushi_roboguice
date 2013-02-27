package it.apogeo.sushi.helloroboguice.service;

import it.apogeo.sushi.helloroboguice.service.Calculator.Control;
import it.apogeo.sushi.helloroboguice.service.Calculator.Digit;

/**
 * Interface that describes the method to map a button id to the key of
 * our calculator
 * 
 * @author Massimo Carli - 29/ago/2012
 *
 */
public interface KeyMapper {
	
	/**
	 * Get the Digit for a given buttonId or null if not a digit
	 *  
	 * @param buttonId The buttonId for the Digit
	 * @return The Digit for a given buttonId or null if not a digit button
	 */
	public Digit digitForKey(int buttonId);
	
	/**
	 * Get the Control for a given buttonId or null if not a control
	 *  
	 * @param buttonId The buttonId for the Control
	 * @return The Control for a given buttonId or null if not a control button
	 */	
	public Control controlForKey(int buttonId);

}
