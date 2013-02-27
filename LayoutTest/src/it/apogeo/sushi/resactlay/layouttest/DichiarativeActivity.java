package it.apogeo.sushi.resactlay.layouttest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Example of definition of a layout in imperative mode 
 * 
 * @author Massimo Carli - 21/ott/2012
 *
 */
public class DichiarativeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We set the layout
        setContentView(R.layout.buttons_layout);
    }

}
