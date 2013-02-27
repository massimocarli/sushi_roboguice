package it.apogeo.sushi.roboguice.providertest.provider;

import it.apogeo.sushi.roboguice.providertest.service.BeforeDunatServiceImpl;
import it.apogeo.sushi.roboguice.providertest.service.MyService;

import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Provider implementation for the MyService interface
 *  
 * @author Massimo Carli - 30/ago/2012
 *
 */
@Singleton
public class BeforeDunatMyServiceProvider implements Provider<MyService>{

	@Override
	public MyService get() {
		return new BeforeDunatServiceImpl();
	}
	

}
