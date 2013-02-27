package it.apogeo.sushi.roboguice.roboeventtest;

import roboguice.activity.RoboActivity;
import roboguice.event.EventManager;
import roboguice.inject.ContentView;
import android.view.View;

import com.google.inject.Inject;

/**
 * 
 * @author Massimo Carli - 05/set/2012
 *
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {	

	@Inject ActivityListener activityListener;
	
	@Inject EventManager eventManager;
	
	/**
	 * Called from SendEvent button
	 * @param v The sendEvent button
	 */
	public void sendEvent(View v){
		eventManager.fire(CustomEvent.createEvent().withEventName("from MainActivity"));
	}
	
}
