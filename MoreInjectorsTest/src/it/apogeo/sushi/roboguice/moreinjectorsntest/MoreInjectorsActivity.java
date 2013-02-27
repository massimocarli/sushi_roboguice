package it.apogeo.sushi.roboguice.moreinjectorsntest;

import it.apogeo.sushi.roboguice.moreinjectorsntest.module.Module1;
import it.apogeo.sushi.roboguice.moreinjectorsntest.service.MyService;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.google.inject.Inject;
import com.google.inject.Injector;

@ContentView(R.layout.activity_more_injection)
public class MoreInjectorsActivity extends RoboActivity{
	
	private final static String LOG_TAG = "MoreInjectorsActivity";	
	
	private MyService myService;
	
	@Inject
	private Injector injector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Let's create a childInjector
        Injector childInjector = injector.createChildInjector(new Module1());
        myService = childInjector.getInstance(MyService.class);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
		Log.i(LOG_TAG, "Service in MoreInjectorsActivity "+myService.whoAmI());    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_more_injection, menu);
        return true;
    }
    
    public void gotNext(View view){
    	Intent intent = new Intent(this,MoreInjectorsActivity2.class);
    	startActivity(intent);
    }
}
