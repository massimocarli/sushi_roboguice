package it.apogeo.sushi.roboguice.moreinjectorsntest.module;

import it.apogeo.sushi.roboguice.moreinjectorsntest.service.MyService;
import it.apogeo.sushi.roboguice.moreinjectorsntest.service.MyServiceImpl2;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * This is a Module to configure a different bindings
 * 
 * @author Massimo Carli - 29/ago/2012
 * 
 */
public class Module2 extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override		
	protected void configure() {
		// The case with NO scope
		//bind(MyService.class).to(MyServiceImpl2.class);
		// Or as a singleton
		bind(MyService.class).to(MyServiceImpl2.class).in(Scopes.SINGLETON);		
	}

}
