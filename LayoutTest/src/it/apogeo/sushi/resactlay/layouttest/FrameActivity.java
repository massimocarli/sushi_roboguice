package it.apogeo.sushi.resactlay.layouttest;

import it.apogeo.sushi.resactlay.layouttest.util.ViewUtility;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Example of a usage of a RelativeLayout
 * 
 * @author Massimo Carli - 21/ott/2012
 *
 */
public class FrameActivity extends Activity {
	
	// The Tag for the Log
	private final static String TAG_LOG = FrameActivity.class.getName();
	
	/*
	 * The Blue View
	 */
	private View mBlueView;
	
	/*
	 * The Green View
	 */	
	private View mGreenView;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);
        mBlueView = ViewUtility.findViewById(this, R.id.blueFrame);
        mGreenView = ViewUtility.findViewById(this, R.id.greenFrame);
    }
    
    /**
     * Called when the button is selected
     */
    public void changeColor(View buttonSelected){
    	switch (buttonSelected.getId()) {
		case R.id.toGreenButton:
			mGreenView.setVisibility(View.VISIBLE);
			mBlueView.setVisibility(View.GONE);
			break;
		case R.id.toBlueButton:
			mGreenView.setVisibility(View.GONE);
			mBlueView.setVisibility(View.VISIBLE);			
			break;
		default:
			break;
		}
    }

}
