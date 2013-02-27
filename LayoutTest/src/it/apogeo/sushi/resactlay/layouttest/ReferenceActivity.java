package it.apogeo.sushi.resactlay.layouttest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Example of definition of a layout with buttons.
 * 
 * @author Massimo Carli - 21/ott/2012
 *
 */
public class ReferenceActivity extends Activity {
	
	// The Tag for the Log
	private final static String TAG_LOG = ReferenceActivity.class.getName();
	
	// The Button references
	private Button mButton0;
	private Button mButton1;
	private Button mButton2;
	
	/**
	 * This is a listener we register to buttons to get events information
	 */
	private final OnClickListener mOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// We get the id of the button
			final int buttonId = v.getId();
			// We print a message based on the button pressed
			switch (buttonId) {
			case R.id.button0:
				Log.i(TAG_LOG,"Button 0 Pressed");
				break;
			case R.id.button1:
				Log.i(TAG_LOG,"Button 1 Pressed");
				break;				
			case R.id.button2:
				Log.i(TAG_LOG,"Button 2 Pressed");
				break;								
			default:
				break;
			}
			
		}
	};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We set the layout
        setContentView(R.layout.buttons_layout);
        // We get the reference of the Buttons given its id
        mButton0 = (Button)findViewById(R.id.button0);
        mButton1 = (Button)findViewById(R.id.button1);
        mButton2 = (Button)findViewById(R.id.button2);
        // We register the events to the Button
        mButton0.setOnClickListener(mOnClickListener);
        mButton1.setOnClickListener(mOnClickListener);
        mButton2.setOnClickListener(mOnClickListener);
    }

}
