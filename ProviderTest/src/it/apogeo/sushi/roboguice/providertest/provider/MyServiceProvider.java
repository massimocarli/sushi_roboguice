package it.apogeo.sushi.roboguice.providertest.provider;

import it.apogeo.sushi.roboguice.providertest.service.MyService;
import it.apogeo.sushi.roboguice.providertest.service.MyServiceImpl;

import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Provider implementation for the MyService interface
 *  
 * @author Massimo Carli - 30/ago/2012
 *
 */
@Singleton
public class MyServiceProvider implements Provider<MyService>{

	@Override
	public MyService get() {
		return new MyServiceImpl();
	}
	

}
