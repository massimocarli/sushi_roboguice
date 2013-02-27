package it.apogeo.sushi.helloroboguice;

import it.apogeo.sushi.helloroboguice.service.Calculator;
import it.apogeo.sushi.helloroboguice.service.Calculator.Control;
import it.apogeo.sushi.helloroboguice.service.Calculator.Digit;
import it.apogeo.sushi.helloroboguice.service.SimpleCalculator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Implementation of the CalculatorActivity using Service instead of spaghetti code
 * 
 * @author Massimo Carli - 05/set/2012
 *
 */
public class CalculatorActivity2 extends Activity {
	
	// Format for 
	private final static String OUTPUT_FORMAT = "%.02f";
	
	// The reference to the buttons
	private Button key0;
	private Button key1;
	private Button key2;
	private Button key3;
	private Button key4;
	private Button key5;
	private Button key6;
	private Button key7;
	private Button key8;
	private Button key9;
	private Button keyCanc;
	private Button keyResult;
	private Button keyPlus;
	private Button keyMinus;
	
	// The TextView for output 
	private TextView outputView;

	// Create the reference to the calculator
	private Calculator calculator = new SimpleCalculator();
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        // We get the reference to the buttons
        key0 = (Button)findViewById(R.id.key_0_button);
        key1 = (Button)findViewById(R.id.key_1_button);
        key2 = (Button)findViewById(R.id.key_2_button);
        key3 = (Button)findViewById(R.id.key_3_button);
        key4 = (Button)findViewById(R.id.key_4_button);
        key5 = (Button)findViewById(R.id.key_5_button);
        key6 = (Button)findViewById(R.id.key_6_button);
        key7 = (Button)findViewById(R.id.key_7_button);
        key8 = (Button)findViewById(R.id.key_8_button);
        key9 = (Button)findViewById(R.id.key_9_button);
        // Operational keys
        keyPlus = (Button)findViewById(R.id.key_plus_button);
        keyMinus = (Button)findViewById(R.id.key_minus_button);
        keyCanc = (Button)findViewById(R.id.key_canc_button);
        keyResult = (Button)findViewById(R.id.key_result_button);
        // We register the listener to all the keys
        key0.setOnClickListener(buttonListener);
        key1.setOnClickListener(buttonListener);
        key2.setOnClickListener(buttonListener);
        key3.setOnClickListener(buttonListener);
        key4.setOnClickListener(buttonListener);
        key5.setOnClickListener(buttonListener);
        key6.setOnClickListener(buttonListener);
        key7.setOnClickListener(buttonListener);
        key8.setOnClickListener(buttonListener);
        key9.setOnClickListener(buttonListener);
        keyPlus.setOnClickListener(buttonListener);
        keyMinus.setOnClickListener(buttonListener);
        keyCanc.setOnClickListener(buttonListener);
        keyResult.setOnClickListener(buttonListener);
        // The current View
        outputView = (TextView)findViewById(R.id.output_value);
        // Let's show the current result
        showInOutput(calculator.getResult());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculator, menu);
        return true;
    }

    /*
     * Show a value on diplay
     */
    private void showInOutput(float value){
    	String resultAsString= String.format(OUTPUT_FORMAT,value);
    	outputView.setText(resultAsString);
    }
    
    /*
     * The OnClickListener for the buttons
     */
    private OnClickListener buttonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// We need a way to mapping buttons to events in Calculator
			Calculator.Control currentControl = null;
			Calculator.Digit currentDigit = null;
			switch (v.getId()) {
			case R.id.key_0_button: // 0
				currentDigit = Digit.KEY_0;
				break;
			case R.id.key_1_button: // 1
				currentDigit = Digit.KEY_1;
				break;
			case R.id.key_2_button: // 2
				currentDigit = Digit.KEY_2;
				break;
			case R.id.key_3_button: // 3
				currentDigit = Digit.KEY_3;
				break;
			case R.id.key_4_button: // 4
				currentDigit = Digit.KEY_4;
				break;
			case R.id.key_5_button: // 5
				currentDigit = Digit.KEY_5;
				break;
			case R.id.key_6_button: // 6
				currentDigit = Digit.KEY_6;
				break;
			case R.id.key_7_button: // 7
				currentDigit = Digit.KEY_7;						
				break;
			case R.id.key_8_button: // 8
				currentDigit = Digit.KEY_8;
				break;
			case R.id.key_9_button: // 9
				currentDigit = Digit.KEY_9;	
				break;
			case R.id.key_plus_button: // +
				currentControl = Control.CNT_ADD;	
				break;
			case R.id.key_minus_button: // -
				currentControl = Control.CNT_SUB;
				break;
			case R.id.key_canc_button: // Canc
				currentControl = Control.CNT_CLR;
				break;
			case R.id.key_result_button: // Result
				currentControl = Control.CNT_RES;
				break;													
			default:
				break;
			}
			// Send events to calculator knowing that the calculator is robust (works with null input value)
			calculator.digit(currentDigit);
			calculator.control(currentControl);
			showInOutput(calculator.getCurrentInput());
		}
	};

}
