package it.apogeo.sushi.roboguice.module;

import java.util.HashMap;
import java.util.Map;

/**
 * This abstract class describes the method we can use to bind an interface
 * to its implementations
 *  
 * @author Massimo Carli - 22/ago/2012
 *
 */
public class GenericModule {
	
	/*
	 * The modules Map who maps the implementations to the type
	 */
	private final Map<Class<?>,Class<?>> bindMap = new HashMap<Class<?>,Class<?>>();
	
	/*
	 * Private constructor
	 */
	private GenericModule(){
	}
	
	/**
	 * Static Factory method to return a GenericModule instance	
	 * @return The GenericModule instance
	 */
	public static final GenericModule createModule(){
		return new GenericModule();
	}
	
	/**
	 * here we bind the particular implementation class to the type class. The generic method
	 * ensure that the implementation is really an implementation of T
	 * @param type The Class for the type we're annotating
	 * @param implementation The Class for the implementation. This must be a related to the type class
	 */
	public <T> GenericModule  bind(Class<T> type,Class<? extends T> implementation){
		// Here we bind the type to the implementation
		bindMap.put(type, implementation);
		// return the same object in chaining
		return this;
	}	
	
	/**
	 * Unbind the particular implementation class if present.
	 * 
	 * @param type
	 *            The Class for the type to unbind
	 */
	public void unbind(Class<?> type) {
		// Here we unbind the type
		bindMap.remove(type);
	}

	/**
	 * @return The current mapping
	 */
	public Map<Class<?>, Class<?>> getBindMap() {
		// We return a defensive copy
		return new HashMap<Class<?>, Class<?>>(bindMap);
	}

}
