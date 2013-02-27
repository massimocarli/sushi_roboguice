package it.apogeo.sushi.roboguice.providertest.provider;

import it.apogeo.sushi.roboguice.providertest.annotation.BeforeDunat;
import it.apogeo.sushi.roboguice.providertest.annotation.Eclair;
import it.apogeo.sushi.roboguice.providertest.annotation.HoneyComb;
import it.apogeo.sushi.roboguice.providertest.annotation.JellyBean;
import it.apogeo.sushi.roboguice.providertest.service.MyService;
import android.os.Build;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Provider implementation for the MyService interface
 * 
 * @author Massimo Carli - 30/ago/2012
 * 
 */
@Singleton
public class VersionedMyServiceProvider implements Provider<MyService> {
	
	@Inject @BeforeDunat
	private MyService beforeDunatService;
	
	@Inject @Eclair
	private MyService eclairService;
	
	@Inject @HoneyComb
	private MyService honeycombService;
	
	@Inject @JellyBean
	private MyService jellyBeanService;		

	@Override
	public MyService get() {
		// Check if the SDK_INT static field is present in Build.VERSION
		// if not we're in version before API Level 4
		try{
			Build.VERSION.class.getField("SDK_INT");
		}catch(NoSuchFieldException nsfe){
			// In this case the version is previous the API Level 4
			return beforeDunatService;
		};
		// In this case we check for the version
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){
			return jellyBeanService;
		}else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB){
			return honeycombService;
		}else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.ECLAIR){
			return eclairService;
		}else{
			return beforeDunatService;
		}	
	}

}
