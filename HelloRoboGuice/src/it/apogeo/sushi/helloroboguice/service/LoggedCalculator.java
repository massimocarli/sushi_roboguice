package it.apogeo.sushi.helloroboguice.service;

import it.apogeo.sushi.helloroboguice.log.Logger;

import com.google.inject.Inject;

/**
 * @author Massimo Carli - 29/ago/2012
 * 
 */
public class LoggedCalculator extends SimpleCalculator {
	
	// The logger implementation
	private final Logger logger;

	@Inject
	public LoggedCalculator(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void digit(Digit digit) {
		super.digit(digit);
		logger.log("Pressed digit "+digit);
	}

	@Override
	public void control(Control control) {
		super.control(control);
		logger.log("Pressed control "+control);		
	}

	@Override
	public float getResult() {
		float result = super.getResult();
		logger.log("result is "+result);	
		return result;
	}

	@Override
	public float getCurrentInput() {
		float currentInput =super.getCurrentInput();
		logger.log("current input is "+currentInput);
		return currentInput;
	}

}
