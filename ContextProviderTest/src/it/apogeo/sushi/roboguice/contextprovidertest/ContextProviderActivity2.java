package it.apogeo.sushi.roboguice.contextprovidertest;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectFragment;
import roboguice.inject.InjectResource;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Example of RoboActivity that uses a Fragment defined into the layout
 * 
 * @author Massimo Carli - 04/set/2012
 * 
 */
@ContentView(R.layout.fragment_inside_layout)
public class ContextProviderActivity2 extends RoboFragmentActivity {
	
	@InjectResource(R.string.app_name)
	private static String LOG_TAG;
	
	@InjectFragment(R.id.list_fragment)
	private Fragment myFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(LOG_TAG, "THIS IS AN INJECTED TAG!");
	}

}
