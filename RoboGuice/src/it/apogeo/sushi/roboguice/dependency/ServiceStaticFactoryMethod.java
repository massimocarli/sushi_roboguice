package it.apogeo.sushi.roboguice.dependency;

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
			// In this case we return the same Service instance but we could
			// return also a pulled or different instance on every invokation
			serviceInstance = new Service();
		}
		return serviceInstance;
	}

}
