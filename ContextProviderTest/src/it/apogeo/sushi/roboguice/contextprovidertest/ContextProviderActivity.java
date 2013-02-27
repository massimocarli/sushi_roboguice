package it.apogeo.sushi.roboguice.contextprovidertest;

import it.apogeo.sushi.roboguice.contextprovidertest.fragment.TestListFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Example of Activity that uses a Fragment defined into the layout
 * 
 * @author Massimo Carli - 04/set/2012
 *
 */
public class ContextProviderActivity extends FragmentActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_anchor_layout);
		TestListFragment fragment = TestListFragment.getInstance();
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_anchor, fragment).commit();
	}

}
