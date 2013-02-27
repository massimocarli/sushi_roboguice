package it.apogeo.sushi.roboguice.justintimeinjection;

import roboguice.activity.RoboActivity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ServiceProviderInjectedActivity extends RoboActivity {

	@Inject private Provider<LocationManager> locationManagerPr;
	
	@Inject private Provider<WindowManager> windowManagerPr;
	
	@Inject private Provider<ActivityManager> activityManagerPr;
	
	@Inject private Provider<PowerManager> powerManagerPr;
	
	@Inject private Provider<AlarmManager> alarmManagerPr;
	
	@Inject private Provider<NotificationManager> notificationManagerPr;
	
	@Inject private Provider<KeyguardManager> keyguardManagerPr;
	
	@Inject private Provider<SearchManager> searchManagerPr;
	
	@Inject private Provider<Vibrator> vibratorManagerPr;
	
	@Inject private Provider<ConnectivityManager> connectivityManagerPr;
	
	@Inject private Provider<WifiManager> wifiManagerPr;
	
	@Inject private Provider<InputMethodManager> inputMethodManagerPr;
	
	@Inject private Provider<SensorManager> sensorManagerPr;
	
}
