package it.apogeo.sushi.helloroboguice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
	
	// Format for 
	private final static String OUTPUT_FORMAT = "%.02f";
	
	// Possible operations
	private enum CalculatorOperation {ADD,SUB,NONE};
	
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
	
	/*
	 * The current value on the calculator screen
	 */
	private float currentValue;
	
	/*
	 * The current value on the calculator memory
	 */
	private float currentResult;	
	
	/*
	 * The current operation
	 */
	private CalculatorOperation currentOperation = CalculatorOperation.NONE;
	

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
        showInOutput(currentResult);
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
			// We need to check the key pressed and make the related action
			switch (v.getId()) {
			case R.id.key_0_button: // 0
				if(currentValue!=0){
					currentValue = currentValue*10;
				}
				break;
			case R.id.key_1_button: // 1
				if(currentValue!=0){
					currentValue = currentValue*10+1;
				}else{
					currentValue = 1;
				}
				break;
			case R.id.key_2_button: // 2
				if(currentValue!=0){
					currentValue = currentValue*10+2;
				}else{
					currentValue = 2;
				}				
				break;
			case R.id.key_3_button: // 3
				if(currentValue!=0){
					currentValue = currentValue*10+3;
				}else{
					currentValue = 3;
				}				
				break;
			case R.id.key_4_button: // 4
				if(currentValue!=0){
					currentValue = currentValue*10+4;
				}else{
					currentValue = 4;
				}					
				break;
			case R.id.key_5_button: // 5
				if(currentValue!=0){
					currentValue = currentValue*10+5;
				}else{
					currentValue = 5;
				}					
				break;
			case R.id.key_6_button: // 6
				if(currentValue!=0){
					currentValue = currentValue*10+6;
				}else{
					currentValue = 6;
				}					
				break;
			case R.id.key_7_button: // 7
				if(currentValue!=0){
					currentValue = currentValue*10+7;
				}else{
					currentValue = 7;
				}					
				break;
			case R.id.key_8_button: // 8
				if(currentValue!=0){
					currentValue = currentValue*10+8;
				}else{
					currentValue = 8;
				}					
				break;
			case R.id.key_9_button: // 9
				if(currentValue!=0){
					currentValue = currentValue*10+9;
				}else{
					currentValue = 9;
				}					
				break;
			case R.id.key_plus_button: // +
				currentOperation = CalculatorOperation.ADD;
				currentResult = currentValue;
				currentValue = 0.0f;				
				break;
			case R.id.key_minus_button: // -
				currentOperation = CalculatorOperation.SUB;
				currentResult = currentValue;
				currentValue = 0.0f;
				break;
			case R.id.key_canc_button: // Canc
				currentOperation = CalculatorOperation.NONE;
				currentResult = 0.0f;
				currentValue = 0.0f;
				break;
			case R.id.key_result_button: // Result
				switch (currentOperation) {
				case ADD:
					currentResult = currentResult+currentValue;
					currentValue = currentResult;
					break;
				case SUB:
					currentResult = currentResult-currentValue;
					currentValue = currentResult;					
					break;
				default:
					break;
				}
				break;													
			default:
				break;
			}
			showInOutput(currentValue);
		}
	};

}
