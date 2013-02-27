package it.apogeo.sushi.helloroboguice.service;


/**
 * This is a simple Calculator implementation 
 * @author Massimo Carli - 23/ago/2012
 *
 */
public class SimpleCalculator implements Calculator {
	
	// The base for numbers
	private final static int NUMBER_BASE = 10;
	
	/*
	 * The current value in memory
	 */
	private float currentValue;
	
	/*
	 * The value to display
	 */
	private float currentInput;
	
	/*
	 * The current operation
	 */
	private Control currentOperation = Control.CNT_NONE;

	/* (non-Javadoc)
	 * @see it.apogeo.sushi.helloroboguice.service.Calculator#digit(it.apogeo.sushi.helloroboguice.service.Calculator.Digit)
	 */
	@Override
	public void digit(Digit digit) {
		if(digit==null){
			// Digit MUST be not null
			return;
		}		
		if(currentInput!=0){
			currentInput = currentInput*NUMBER_BASE+digit.ordinal();
		}else{
			currentInput = digit.ordinal();
		}
	}

	/* (non-Javadoc)
	 * @see it.apogeo.sushi.helloroboguice.service.Calculator#control(it.apogeo.sushi.helloroboguice.service.Calculator.Control)
	 */
	@Override
	public void control(Control control) {
		if(control==null){
			// Control MUST be not null
			return;
		}
		// We manage values based on selected control
		switch (control) {
		case CNT_ADD: // Add
			currentOperation = Control.CNT_ADD;
			currentValue = currentInput;
			currentInput = 0.0f;
			break;
		case CNT_SUB: // Sub
			currentOperation = Control.CNT_SUB;
			currentValue = currentInput;		
			currentInput = 0.0f;
			break;						
		case CNT_CLR: // Clear
			currentOperation = Control.CNT_NONE;
			currentValue = 0.0f;
			currentInput = 0.0f;
			break;
		case CNT_RES: // Result
			switch (currentOperation) {
			case CNT_ADD:
				currentValue +=currentInput;
				currentInput = currentValue;
				break;
			case CNT_SUB:
				currentValue -=currentInput;
				currentInput = currentValue;					
				break;
			default:
				break;
			}			
			break;
		default:
			break;
		}

	}


	/* (non-Javadoc)
	 * @see it.apogeo.sushi.helloroboguice.service.Calculator#getResult()
	 */
	@Override
	public float getResult() {
		return currentValue;
	}

	/* (non-Javadoc)
	 * @see it.apogeo.sushi.helloroboguice.service.Calculator#toDisplay()
	 */
	@Override
	public float getCurrentInput() {
		return currentInput;
	}

}
