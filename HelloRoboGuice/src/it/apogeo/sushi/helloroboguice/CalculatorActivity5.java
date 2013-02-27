package it.apogeo.sushi.helloroboguice;

import it.apogeo.sushi.helloroboguice.service.Calculator;
import it.apogeo.sushi.helloroboguice.service.Calculator.Control;
import it.apogeo.sushi.helloroboguice.service.Calculator.Digit;
import it.apogeo.sushi.helloroboguice.service.SimpleCalculator;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

@ContentView(R.layout.activity_calculator_5)
public class CalculatorActivity5 extends RoboActivity {
		
	
	// The TextView for output 
	@InjectView(R.id.output_value)  private TextView outputView;
	
	// Format for output
	@InjectResource(R.string.output_format) private String OUTPUT_FORMAT;	

	// Create the reference to the calculator
	private Calculator calculator = new SimpleCalculator();
	
	/*
	 * Mapper for the Control items
	 */
	private SparseArray<Control> controlMapper;
	
	/*
	 * Mapper for the Digit items
	 */
	private SparseArray<Digit> digitMapper;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create and initialize mappers
        controlMapper = new SparseArray<Calculator.Control>();
        controlMapper.put(R.id.key_plus_button, Control.CNT_ADD);
        controlMapper.put(R.id.key_minus_button, Control.CNT_SUB);
        controlMapper.put(R.id.key_canc_button, Control.CNT_CLR);
        controlMapper.put(R.id.key_result_button, Control.CNT_RES);
        digitMapper = new SparseArray<Calculator.Digit>();
        digitMapper.put(R.id.key_0_button, Digit.KEY_0);
        digitMapper.put(R.id.key_1_button, Digit.KEY_1);
        digitMapper.put(R.id.key_2_button, Digit.KEY_2);
        digitMapper.put(R.id.key_3_button, Digit.KEY_3);
        digitMapper.put(R.id.key_4_button, Digit.KEY_4);
        digitMapper.put(R.id.key_5_button, Digit.KEY_5);
        digitMapper.put(R.id.key_6_button, Digit.KEY_6);
        digitMapper.put(R.id.key_7_button, Digit.KEY_7);
        digitMapper.put(R.id.key_8_button, Digit.KEY_8);
        digitMapper.put(R.id.key_9_button, Digit.KEY_9);
        // Let's show the current result
        showInOutput(calculator.getResult());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculator, menu);
        return true;
    }

    
    /**
     * Invoked when a digit is pressed
     * @param digitButton The digit button pressed 
     */
    public void digitPressed(View digitButton){
    	Calculator.Digit currentDigit = digitMapper.get(digitButton.getId());
    	calculator.digit(currentDigit);
    	showInOutput(calculator.getCurrentInput());
    }
    
    /**
     * Invoked when a control is pressed
     * @param controlButton The control button pressed 
     */    
    public void controlPressed(View controlButton){
    	Calculator.Control currentControl = controlMapper.get(controlButton.getId());
    	calculator.control(currentControl);
    	showInOutput(calculator.getCurrentInput());
    }    
    
    /*
     * Show a value on diplay
     */
    private void showInOutput(float value){
    	String resultAsString= String.format(OUTPUT_FORMAT,value);
    	outputView.setText(resultAsString);
    }
    

}
