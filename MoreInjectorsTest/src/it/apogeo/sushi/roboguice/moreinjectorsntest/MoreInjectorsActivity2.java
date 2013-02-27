package it.apogeo.sushi.roboguice.moreinjectorsntest;

import it.apogeo.sushi.roboguice.moreinjectorsntest.module.Module2;
import it.apogeo.sushi.roboguice.moreinjectorsntest.service.MyService;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.inject.Inject;
import com.google.inject.Injector;

@ContentView(R.layout.activity_more_injection)
public class MoreInjectorsActivity2 extends RoboActivity{
	
	private final static String LOG_TAG = "MoreInjectorsActivity";	
	
	private MyService myService;
	
	private static Module2 module2 = new Module2();
	
	@Inject
	private Injector injector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Let's create a childInjector
        //Injector childInjector = injector.createChildInjector(new Module2());
        Injector childInjector = injector.createChildInjector(module2);
        Injector childInjector2 = injector.createChildInjector(module2);
        Log.i(LOG_TAG, (childInjector==childInjector2)?"SAME INJECTOR":" DIFFERENT INJECTOR");
        myService = childInjector.getInstance(MyService.class);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
		Log.i(LOG_TAG, "Service in MoreInjectorsActivity2 "+myService.whoAmI());    	
    }    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_more_injection, menu);
        return true;
    }
}
