package it.apogeo.sushi.roboguice.justintimeinjection.app;

import android.app.Activity;

import com.google.inject.Inject;

/**
 * Simple Activity injection implementation
 * 
 * @author Massimo Carli - 04/set/2012
 *
 */
public class MyActivityInjectedObject  {
	
	private Activity activity;
	
	@Inject
	public MyActivityInjectedObject(Activity activity){
		this.activity=activity;
	}

}
