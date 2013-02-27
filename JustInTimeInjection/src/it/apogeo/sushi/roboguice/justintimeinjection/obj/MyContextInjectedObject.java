package it.apogeo.sushi.roboguice.justintimeinjection.obj;

import android.content.Context;

import com.google.inject.Inject;

/**
 * Example of Context Injected Object
 * 
 * @author Massimo Carli - 04/set/2012
 *
 */
public class MyContextInjectedObject {
	private final Context context;
	
	@Inject
	public MyContextInjectedObject(Context pContext){
		this.context=pContext;
	}
	
}
