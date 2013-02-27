package it.apogeo.sushi.roboguice.moreinjectorsntest.module;

import it.apogeo.sushi.roboguice.moreinjectorsntest.service.MyService;
import it.apogeo.sushi.roboguice.moreinjectorsntest.service.MyServiceImpl;

import com.google.inject.AbstractModule;

/**
 * This is a Module to configure bindings
 * 
 * @author Massimo Carli - 29/ago/2012
 * 
 */
public class Module1 extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override		
	protected void configure() {
		// The case with NO scope
		//bind(MyService.class).to(MyServiceImpl.class);
		// Or as a singleton
		bind(MyService.class).to(MyServiceImpl.class).asEagerSingleton();
	}

}
