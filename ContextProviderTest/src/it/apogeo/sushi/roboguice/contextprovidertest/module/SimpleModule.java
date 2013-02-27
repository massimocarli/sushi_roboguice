package it.apogeo.sushi.roboguice.contextprovidertest.module;

import it.apogeo.sushi.roboguice.contextprovidertest.ContextProviderActivity2;
import it.apogeo.sushi.roboguice.contextprovidertest.db.InjectDBHelper;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.inject.AbstractModule;

/**
 * This is a Module to configure the Singleton with annotated
 * 
 * @author Massimo Carli - 29/ago/2012
 * 
 */
public class SimpleModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override		
	protected void configure() {
		// Example of static field injection
		requestStaticInjection(ContextProviderActivity2.class);
		// Bind the SQLiteOpenHelper
		bind(SQLiteOpenHelper.class).to(InjectDBHelper.class);
	}

}
