/**
 * 
 */
package it.apogeo.sushi.helloroboguice.test;

import it.apogeo.sushi.helloroboguice.service.Calculator;
import it.apogeo.sushi.helloroboguice.service.Calculator.Control;
import it.apogeo.sushi.helloroboguice.service.Calculator.Digit;
import it.apogeo.sushi.helloroboguice.service.SimpleCalculator;
import junit.framework.TestCase;

/**
 * @author Massimo Carli - 23/ago/2012
 *
 */
public class SimpleCalculatorTest extends TestCase {
	
	private Calculator calculator;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		calculator = new SimpleCalculator();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		calculator = null;
	}


	public void testInsertNumber() {
		calculator.digit(Digit.KEY_1);
		calculator.digit(Digit.KEY_0);
		float input = calculator.getCurrentInput();
		assertEquals(input, 10.0f);
	}
	
	
	public void testInsertNumberAfterZero() {
		calculator.digit(Digit.KEY_0);
		calculator.digit(Digit.KEY_1);
		calculator.digit(Digit.KEY_0);
		float input = calculator.getCurrentInput();
		assertEquals(input, 10.0f);
	}

	public void testAdd() {
		// Insert first number 10
		calculator.digit(Digit.KEY_1);
		calculator.digit(Digit.KEY_0);
		float input = calculator.getCurrentInput();
		assertEquals(input, 10.0f);
		// Insert second number (33) after a ADD
		calculator.control(Control.CNT_ADD);
		calculator.digit(Digit.KEY_3);
		calculator.digit(Digit.KEY_3);	
		float input2 = calculator.getCurrentInput();
		assertEquals(input2, 33.0f);
		// Make sum
		calculator.control(Control.CNT_RES);
		// Check result value 43?
		float result = calculator.getResult();
		assertEquals(result, 42.0f);
	}	
	
	public void testSub() {
		// Insert first number 10
		calculator.digit(Digit.KEY_1);
		calculator.digit(Digit.KEY_0);
		float input = calculator.getCurrentInput();
		assertEquals(input, 10.0f);
		// Insert second number (33) after a ADD
		calculator.control(Control.CNT_SUB);
		calculator.digit(Digit.KEY_3);
		calculator.digit(Digit.KEY_3);	
		float input2 = calculator.getCurrentInput();
		assertEquals(input2, 33.0f);
		// Make sum
		calculator.control(Control.CNT_RES);
		// Check result value -23?
		float result = calculator.getResult();
		assertEquals(result, -23.0f);
	}	
	
	public void testAddSub() {
		// Insert first number 10
		calculator.digit(Digit.KEY_1);
		calculator.digit(Digit.KEY_0);
		// Add 8
		calculator.control(Control.CNT_ADD);
		calculator.digit(Digit.KEY_8);
		// Press result
		calculator.control(Control.CNT_RES);
		// Subtract 4
		calculator.control(Control.CNT_SUB);
		calculator.digit(Digit.KEY_4);		
		// Press result 
		calculator.control(Control.CNT_RES);
		// Check for result is 14
		float result = calculator.getResult();
		assertEquals(result, 14.0f);		
	}	
	
	public void testReset() {
		// Insert first number 10
		calculator.digit(Digit.KEY_1);
		calculator.digit(Digit.KEY_0);
		// Add 8
		calculator.control(Control.CNT_CLR);
		float input = calculator.getCurrentInput();
		assertEquals(input, 0.0f);		
	}	
	
	

}
