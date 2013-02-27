package it.apogeo.sushi.roboguice.dependency.aggregation;

/**
 * This is a class that give access to Service instance
 * 
 * @author Massimo Carli - 20/ago/2012
 *
 */
public class ServiceStaticFactoryMethod {
	
	/*
	 * The instance of the service
	 */
	private static Service serviceInstance;
	
	private ServiceStaticFactoryMethod(){
		throw new AssertionError("Never instantiate me!!!");
	}
	
	/**1
	 * Syncronized static factory method for the Service 
	 * 
	 * @return The Service instance
	 */
	public static final synchronized Service getInstance(){
		if(serviceInstance==null){
			// We return ServiceA but we could return ServiceB or other implementations
			// of Service interface
			serviceInstance = new ServiceA();
		}
		return serviceInstance;
	}

}
