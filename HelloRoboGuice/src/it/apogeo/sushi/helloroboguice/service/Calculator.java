package it.apogeo.sushi.helloroboguice.service;

/**
 * This is an interface for a simple Calculator
 * 
 * @author Massimo Carli - 23/ago/2012
 *
 */
public interface Calculator {
	
	/**
	 * The enum that contains the possible digit to press
	 */
	public static enum Digit {KEY_0,KEY_1,KEY_2,KEY_3,KEY_4,KEY_5,KEY_6,KEY_7,KEY_8,KEY_9};
	
	/**
	 * The enum for control keys
	 */
	public static enum Control {CNT_ADD,CNT_SUB,CNT_RES,CNT_CLR,CNT_NONE};
	
	/**
	 * Digit pressed
	 * @param digit The digit pressed
	 */
	public void digit(Digit digit);

	/**
	 * Control key pressed
	 * @param control The control key pressed
	 */	
	public void control(Control control);
	
	/**
	 * @return The current result value
	 */
	public float getResult();
	
	/**
	 * The current value we need to show
	 * 
	 * @return The value to show in display
	 */
	public float getCurrentInput();
	
}
