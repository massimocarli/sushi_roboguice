package it.apogeo.sushi.roboguice.justintimeinjection;

import it.apogeo.sushi.roboguice.justintimeinjection.obj.MyContextInjectedObject;
import roboguice.activity.RoboActivity;
import android.content.Context;

import com.google.inject.Inject;

public class ContextInjectedActivity extends RoboActivity {

	@Inject
	MyContextInjectedObject myObject;

	static class MyStaticComponent {
		Context context;

		@Inject
		MyStaticComponent(Context context) {
			this.context = context;
		}
	}
}
