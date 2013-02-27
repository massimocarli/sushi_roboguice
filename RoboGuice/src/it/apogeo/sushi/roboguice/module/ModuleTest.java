package it.apogeo.sushi.roboguice.module;

import it.apogeo.sushi.roboguice.log.Log;

/**
 * The application we're using to test the Module usage
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
public class ModuleTest {

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
		ModuleContainer.INSTANCE.bind(module1);
		// We Create the client
		Client client = new Client();
		// We parse the client with the ModuleInjector
		ModuleInjector.inject(client);
		// We use the client
		String greeting = client.useService("Pluto");
		Log.log(greeting);
	}

}
