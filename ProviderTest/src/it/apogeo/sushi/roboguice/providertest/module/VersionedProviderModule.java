package it.apogeo.sushi.roboguice.providertest.module;

import it.apogeo.sushi.roboguice.providertest.annotation.BeforeDunat;
import it.apogeo.sushi.roboguice.providertest.annotation.Eclair;
import it.apogeo.sushi.roboguice.providertest.annotation.HoneyComb;
import it.apogeo.sushi.roboguice.providertest.annotation.JellyBean;
import it.apogeo.sushi.roboguice.providertest.provider.MyServiceProvider;
import it.apogeo.sushi.roboguice.providertest.provider.VersionedMyServiceProvider;
import it.apogeo.sushi.roboguice.providertest.service.BeforeDunatServiceImpl;
import it.apogeo.sushi.roboguice.providertest.service.EclairServiceImpl;
import it.apogeo.sushi.roboguice.providertest.service.HoneyCombServiceImpl;
import it.apogeo.sushi.roboguice.providertest.service.JellyBeanServiceImpl;
import it.apogeo.sushi.roboguice.providertest.service.MyService;

import com.google.inject.AbstractModule;

/**
 * This is a Module to configure bindings
 * 
 * @author Massimo Carli - 29/ago/2012
 * 
 */
public class VersionedProviderModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override		
	protected void configure() {
		// We bind implementation to versions
		bind(MyService.class).annotatedWith(BeforeDunat.class).to(BeforeDunatServiceImpl.class);
		bind(MyService.class).annotatedWith(Eclair.class).to(EclairServiceImpl.class);
		bind(MyService.class).annotatedWith(HoneyComb.class).to(HoneyCombServiceImpl.class);
		bind(MyService.class).annotatedWith(JellyBean.class).to(JellyBeanServiceImpl.class);
		// The provider for the MyService class
		bind(MyService.class).toProvider(VersionedMyServiceProvider.class);
	}

}
