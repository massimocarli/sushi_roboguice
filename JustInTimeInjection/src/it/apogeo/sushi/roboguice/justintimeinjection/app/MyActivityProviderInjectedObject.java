package it.apogeo.sushi.roboguice.justintimeinjection.app;

import android.app.Activity;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Simple Activity injection implementation
 * 
 * @author Massimo Carli - 04/set/2012
 *
 */
public class MyActivityProviderInjectedObject  {
	
	private Provider<Activity> prActivity;
	
	@Inject
	public MyActivityProviderInjectedObject(Provider<Activity> prActivity){
		Activity a = prActivity.get();
	}

}
