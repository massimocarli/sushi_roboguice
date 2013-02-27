package it.apogeo.sushi.helloroboguice;

import it.apogeo.sushi.helloroboguice.service.Calculator;
import it.apogeo.sushi.helloroboguice.service.KeyMapper;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.inject.Inject;

@ContentView(R.layout.activity_calculator_5)
public class CalculatorActivity7 extends RoboActivity {
		
	
	// The TextView for output 
	@InjectView(R.id.output_value)  private TextView outputView;
	
	// Format for output
	@InjectResource(R.string.output_format) private String OUTPUT_FORMAT;	

	// Create the reference to the calculator
	@Inject private Calculator calculator;
	
	// The key mapper
	@Inject private KeyMapper keyMapper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    	Calculator.Digit currentDigit = keyMapper.digitForKey(digitButton.getId());
    	calculator.digit(currentDigit);
    	showInOutput(calculator.getCurrentInput());
    }
    
    /**
     * Invoked when a control is pressed
     * @param controlButton The control button pressed 
     */    
    public void controlPressed(View controlButton){
    	Calculator.Control currentControl = keyMapper.controlForKey(controlButton.getId());
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
