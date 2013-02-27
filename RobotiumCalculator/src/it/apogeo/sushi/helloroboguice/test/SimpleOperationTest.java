package it.apogeo.sushi.helloroboguice.test;

import it.apogeo.sushi.helloroboguice.CalculatorActivity7;
import it.apogeo.sushi.helloroboguice.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;

public class SimpleOperationTest extends 
		ActivityInstrumentationTestCase2<MainActivity> {
	
	// We define the Solo object
	private Solo solo;
	
	public SimpleOperationTest() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		// We initialize the Solo object with the Instrumentation
		// object and the Activity under examination
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	/**
	 * This method is a test to be sure we're in the corrent Activity
	 */
	public void testWeAreInTheRightActivity(){
		solo.assertCurrentActivity("Uhm! Maybe you need a compass!!", MainActivity.class);
	}
	
	/**
	 * This method is a test for the button selection. We want to be sure that clicking on the
	 * button with the label "Service Injection version" we go to the right Activity
	 * described by the class CalculatorActivity7
	 */
	public void testGoToCalculatorActivity(){
		// We check we're in the right Activity
		solo.assertCurrentActivity("Uhm! Maybe you need a compass!!", MainActivity.class);
		// We click on the "Service Injection version" button
		solo.clickOnButton("Service Injection version");
		// We check we go in the right Activity
		solo.assertCurrentActivity("Uhm! Right button???", CalculatorActivity7.class);
	}	
	
	/**
	 * Method to test a sum
	 */
	public void testAdd(){
		// We check we're in the right Activity
		solo.assertCurrentActivity("Uhm! Maybe you need a compass!!", MainActivity.class);
		// We click on the "Service Injection version" button
		solo.clickOnButton("Service Injection version");
		// We check we go in the right Activity
		solo.assertCurrentActivity("Uhm! Right button???", CalculatorActivity7.class);
		// Here we press on the 1 and then on the 0
		solo.clickOnButton("1");
		solo.clickOnButton("0");
		// We test for the 10 visualized. The output is the second TextView
		TextView outputView = solo.getText(1);
		String outputText = outputView.getText().toString();
		assertEquals("10,00", outputText);
		// We select the +
		solo.clickOnButton("\\+");
		outputText = outputView.getText().toString();
		assertEquals("0,00", outputText);
		// Digit 33
		solo.clickOnButton("3");
		solo.clickOnButton("3");
		// 33,00 is shown
		outputText = outputView.getText().toString();
		assertEquals("33,00", outputText);		
		// Click on result
		solo.clickOnButton("=");
		// Check for 43
		outputText = outputView.getText().toString();
		assertEquals("43,00", outputText);
		// Clear
		solo.clickOnButton("C");
		// Check for 0,00
		outputText = outputView.getText().toString();
		assertEquals("0,00", outputText);		
	}	
	

}
