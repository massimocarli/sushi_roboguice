package it.apogeo.sushi.roboguice.dependency;

/**
 * This is a Singleton that give access to Service instance
 * 
 * @author Massimo Carli - 20/ago/2012
 *
 */
public enum ServiceFactory {
	
	INSTANCE;
	
	/*
	 * The instance of the service
	 */
	private Service serviceInstance;
	
	/**
	 * Syncronized factory method for the Service 
	 * 
	 * @return The Service instance
	 */
	public final synchronized Service getInstance(){
		if(serviceInstance!=null){
			// In this case we return the same Service instance but we could
			// return also a pulled or different instance on every invokation
			serviceInstance = new Service();
		}
		return serviceInstance;
	}
	
}
