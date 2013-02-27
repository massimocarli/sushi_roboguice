package it.apogeo.sushi.roboguice.contextprovidertest;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/**
	 * Go to NOT Injection example
	 * @param button The button pressed
	 */
	public void goToNoInjection(View button){
		Intent intent = new Intent(this,ContextProviderActivity.class);
		startActivity(intent);
	}

	/**
	 * Go to Injection example
	 * @param button The button pressed
	 */	
	public void goToInjection(View button){
		Intent intent = new Intent(this,ContextProviderActivity2.class);
		startActivity(intent);
	}	
	

}
