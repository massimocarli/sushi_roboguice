package it.apogeo.sushi.resactlay.layouttest;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Example of definition of a layout in imperative mode 
 * 
 * @author Massimo Carli - 21/ott/2012
 *
 */
public class ImperativeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We define the container layout
        LinearLayout parentLayout = new LinearLayout(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        parentLayout.setLayoutParams(lp);
        parentLayout.setOrientation(LinearLayout.VERTICAL);
        // We define 3 buttons
        for(int i=0;i<3;i++){
        	Button button = new Button(this);
        	LinearLayout.LayoutParams buttonLp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        	button.setLayoutParams(buttonLp);
        	button.setText("Button #"+i);
        	// We add the button to the linear layout
        	parentLayout.addView(button);
        }
        // We add the parent layout
        setContentView(parentLayout);
    }

}
