package it.apogeo.sushi.roboguice.providertest.module;

import it.apogeo.sushi.roboguice.providertest.provider.MyServiceProvider;
import it.apogeo.sushi.roboguice.providertest.service.MyService;

import com.google.inject.AbstractModule;

/**
 * This is a Module to configure bindings
 * 
 * @author Massimo Carli - 29/ago/2012
 * 
 */
public class ProviderModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override		
	protected void configure() {
		// The bind of the Provider for the MyService interface
		bind(MyService.class).toProvider(MyServiceProvider.class);
		// You can also use a particulat instance
		//bind(MyService.class).toProvider(new MyServiceProvider());
	}

}
