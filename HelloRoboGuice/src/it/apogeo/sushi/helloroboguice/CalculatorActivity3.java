package it.apogeo.sushi.helloroboguice;

import it.apogeo.sushi.helloroboguice.service.Calculator;
import it.apogeo.sushi.helloroboguice.service.Calculator.Control;
import it.apogeo.sushi.helloroboguice.service.Calculator.Digit;
import it.apogeo.sushi.helloroboguice.service.SimpleCalculator;
import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Implementation of the CalculatorActivity using Service instead of spaghetti code
 * and Mapper for mapping between buttons and Calculator key
 * 
 * @author Massimo Carli - 05/set/2012
 *
 */
public class CalculatorActivity3 extends Activity {
	
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
			Calculator.Control currentControl = controlMapper.get(v.getId());
			Calculator.Digit currentDigit = digitMapper.get(v.getId());
			// Send events to calculator knowing that the calculator is robust (works with null input value)
			calculator.digit(currentDigit);
			calculator.control(currentControl);
			showInOutput(calculator.getCurrentInput());
		}
	};

}
