package it.apogeo.sushi.roboguice.justintimeinjection.app;

import roboguice.inject.RoboApplicationProvider;
import android.app.Application;

/**
 * Simple RoboApplication implementation
 * 
 * @author Massimo Carli - 04/set/2012
 *
 */
public class MyAppInjectedObject  {
	
	private RoboApplicationProvider<Application> prApplication;
	
	public MyAppInjectedObject(RoboApplicationProvider<Application> prApplication){
		// We use the app
		Application app = prApplication.get();
	}

}
