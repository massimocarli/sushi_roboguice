package it.apogeo.sushi.helloroboguice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	// Go to awful version
	public void goToAwful(View v) {
		Intent goToNext = new Intent(this, CalculatorActivity.class);
		startActivity(goToNext);
	}

	// Go to version with Service
	public void goToWithService(View v) {
		Intent goToNext = new Intent(this, CalculatorActivity2.class);
		startActivity(goToNext);
	}

	// Go to version with Service and Mappers
	public void goToWithMappers(View v) {
		Intent goToNext = new Intent(this, CalculatorActivity3.class);
		startActivity(goToNext);
	}

	// Go to version with Layout Injection
	public void goToWithLayoutInjection(View v) {
		Intent goToNext = new Intent(this, CalculatorActivity4.class);
		startActivity(goToNext);
	}

	// Go to version with Optimize version
	public void goToOptimizedInjection(View v) {
		Intent goToNext = new Intent(this, CalculatorActivity5.class);
		startActivity(goToNext);
	}

	// Go to version with Mapped optimize version
	public void goToMappedInjection(View v) {
		Intent goToNext = new Intent(this, CalculatorActivity6.class);
		startActivity(goToNext);
	}

	// Go to version with Service Injection version
	public void goToServiceInjection(View v) {
		Intent goToNext = new Intent(this, CalculatorActivity7.class);
		startActivity(goToNext);
	}

}
