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

public class ServiceInjectedActivity extends RoboActivity {

	@Inject private LocationManager locationManager;
	
	@Inject private WindowManager windowManager;
	
	@Inject private ActivityManager activityManager;
	
	@Inject private PowerManager powerManager;
	
	@Inject private AlarmManager alarmManager;
	
	@Inject private NotificationManager notificationManager;
	
	@Inject private KeyguardManager keyguardManager;
	
	@Inject private SearchManager searchManager;
	
	@Inject private Vibrator vibratorManager;
	
	@Inject private ConnectivityManager connectivityManager;
	
	@Inject private WifiManager wifiManager;
	
	@Inject private InputMethodManager inputMethodManager;
	
	@Inject private SensorManager sensorManager;
	
}
