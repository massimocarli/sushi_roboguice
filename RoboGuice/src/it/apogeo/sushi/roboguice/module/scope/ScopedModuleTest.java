package it.apogeo.sushi.roboguice.module.scope;

import it.apogeo.sushi.roboguice.log.Log;
import it.apogeo.sushi.roboguice.module.GenericModule;
import it.apogeo.sushi.roboguice.module.Logger;
import it.apogeo.sushi.roboguice.module.Manager;
import it.apogeo.sushi.roboguice.module.ManagerB;
import it.apogeo.sushi.roboguice.module.Service;
import it.apogeo.sushi.roboguice.module.ServiceA;
import it.apogeo.sushi.roboguice.module.SysLog;

/**
 * The application we're using to test the Module usage
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
public class ScopedModuleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// We create the module
		GenericModule module1 = GenericModule.createModule()
				.bind(Service.class, ServiceA.class)
				.bind(Manager.class, ManagerB.class)
				.bind(Logger.class,SysLog.class);
		// We register the module
		ScopedModuleContainer.INSTANCE.bind(module1);
		// We Create the client
		Client client = new Client();
		// We parse the client with the ModuleInjector
		ScopedModuleInjector.inject(client);
		// We use the client
		String greeting = client.useService("Pluto");
		Log.log(greeting);
	}

}
