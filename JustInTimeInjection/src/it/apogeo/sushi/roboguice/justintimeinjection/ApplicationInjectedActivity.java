package it.apogeo.sushi.roboguice.justintimeinjection;

import it.apogeo.sushi.roboguice.justintimeinjection.app.MyAppInjectedObject;
import roboguice.activity.RoboActivity;
import roboguice.inject.RoboApplicationProvider;
import android.app.Application;

import com.google.inject.Inject;

public class ApplicationInjectedActivity extends RoboActivity {

	@Inject
	MyAppInjectedObject myObject;

	static class MyStaticComponent {
		Application application;

		@Inject
		MyStaticComponent(RoboApplicationProvider<Application> prApplication) {
			application = prApplication.get();
		}
	}
}
