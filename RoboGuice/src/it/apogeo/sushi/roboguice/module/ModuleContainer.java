package it.apogeo.sushi.roboguice.module;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * This enum describes a Singleton we use to contains Module definitions and it'll be
 * used for component reference 
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
public enum ModuleContainer {
	
	// Single instance garanteed by the container
	INSTANCE;
	
	/*
	 * The Set of the modules we can manage
	 */
	private final Set<GenericModule> moduleSet = new HashSet<GenericModule>();
	
	/*
	 * The modules Map who maps the implementations to the type
	 */
	private final Map<Class<?>,Class<?>> componentMap = new HashMap<Class<?>,Class<?>>();	
	
		
	/**
	 * We add the module, with its binding, to the container
	 * 
	 * @param module The module to add
	 */
	public void  bind(GenericModule module){
		// We add the module
		moduleSet.add(module);
		// We add all module mapping to the global mapping
		componentMap.putAll(module.getBindMap());
	}
	
	
	/**
	 * This method returns the reference to the component associated to the Class passed as parameter 
	 * 
	 * @param type The Class object for the type we're looking for
	 * @return The reference of the type implementation
	 * @throws IllegalAccessException In case of error in accessibility 
	 * @throws InstantiationException In case of instantiating error
	 * @throws IllegalArgumentException No binding for this value
	 */
	public Object getReference(Class<?> type) throws InstantiationException, IllegalAccessException{
		// We create a new instance every time if a bind exists
		Class<?> referenceType = componentMap.get(type); 
		if(referenceType!=null){
			// This must have default constructor					
			Object injected = referenceType.newInstance();
			// We return it
			return injected;
		}else{
			// In this case we throw an exception 
			throw new IllegalArgumentException("No binding for the type "+type.getName());
		}
	}
	

}
