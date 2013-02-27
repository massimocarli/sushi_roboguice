package it.apogeo.sushi.roboguice.providertest;

import it.apogeo.sushi.roboguice.providertest.service.MyService;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.os.Bundle;
import android.util.Log;

import com.google.inject.Inject;
import com.google.inject.Provider;

@ContentView(R.layout.activity_provider_test)
public class ProviderTestActivity extends RoboActivity {

	private final static String LOG_TAG = "ProviderTestActivity";

	/*
	 * Provider of the service MyService
	 */
	@Inject
	private Provider<MyService> serviceProvider;

	private MyService service1;

	private MyService service2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		service1 = serviceProvider.get();
		service2 = serviceProvider.get();

		boolean sameService = service1 == service2;
		Log.d(LOG_TAG, (sameService ? "SAME INSTANCE" : "DIFFERENT INSTANCES"));
		Log.d(LOG_TAG,"First " + service1.whoAmI() + " Second:" + service2.whoAmI());
	}
}
