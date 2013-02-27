package it.apogeo.sushi.roboguice.module;

import it.apogeo.sushi.roboguice.dependency.annotation.ConstructorInjection;
import it.apogeo.sushi.roboguice.dependency.annotation.InjectEnabled;
import it.apogeo.sushi.roboguice.dependency.annotation.SetterInjection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This is a sample implementation of an Injector to inject items into an object based on its
 * annotations. It uses the Module bindings information
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
public class ModuleInjector {
	
	// private constructor
	private ModuleInjector(){
		throw new AssertionError("Never instantiate me!!!");
	}

	/**
	 * This methods perform injection on InjectEnabled objects
	 * @param injectEnabled The InjectEnabled object to "parse"
	 */
	public static final void inject(InjectEnabled injectEnabled){
		// Member injection
		applyMemberInjection(injectEnabled);
		// Setter injection
		applySetterInjection(injectEnabled);	
	}
		
	/*
	 * Member injection
	 * @param injectEnabled The object destination of the member injection 
	 */
	private static void applyMemberInjection(InjectEnabled injectEnabled){
		// We get fields reference
		Field[] fields = injectEnabled.getClass().getDeclaredFields();
		// We check if fields are annotated
		for(Field field:fields){
			// Looking for MemberInjection
			Inject injection = field.getAnnotation(Inject.class);
			if(injection!=null){
				boolean originalAccessible = field.isAccessible(); 
				field.setAccessible(true);				
				// If the field has already a value we skip it
				Object fieldValue = null;
				try {
					fieldValue = field.get(injectEnabled);
				} catch (Exception e1) {
					// TODO: This is not the good way to manage Exception
					// (Head in the sand). But it should never access because
					// we put eccessible to true
				}
				field.setAccessible(originalAccessible);
				if(fieldValue!=null){
					// The value is already set so we skip that property
					return;
				}
				// We need the type of the annotated field
				Class<?> annotatedType = field.getType();
				// This field is MemberInjection annotated so we have to
				// obtain the reference of the object to inject and assign to the
				// field. Here we use the Module to get the object
				try {
					// We manage exception locally.
					// TODO: Better exception management
					Object injectedObject = ModuleContainer.INSTANCE.getReference(annotatedType);
					// Hey, we need to inject injectedObject too if inject enabled
					if(injectedObject instanceof InjectEnabled){
						// TODO: Recursion is not fantastic. We must be careful
						// of some kind of cycles that lead to StackOverFlow!!!
						inject((InjectEnabled)injectedObject);
					}
					// We need to change the visibility of the field
					originalAccessible = field.isAccessible(); 
					field.setAccessible(true);
					// We assign the value to the field
					field.set(injectEnabled, injectedObject);
					// return visibility to previous value
					field.setAccessible(originalAccessible);
					// We write log message
					// TODO: Setup logs 
					System.out.println("Object of type "+annotatedType+" set to field "+field.getName());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}else{
				// Field not MemberInjection annotated
			}
		}
	}
	
	/*
	 * Setter injection
	 * @param injectEnabled The object destination of the setter injection 
	 */
	private static void applySetterInjection(InjectEnabled injectEnabled){
		// We get methods reference
		Method[] methods = injectEnabled.getClass().getMethods();
		// We check if methods are annotated
		for(Method method:methods){
			// Looking for SetterInjection
			SetterInjection setterInjection = method.getAnnotation(SetterInjection.class);
			if(setterInjection!=null){
				// This field is SetterInjection annotated so we have to
				// obtain the reference of the object to inject and assign to the
				// field
				// TODO Optimize the caching and lifecycle of injected object
				Class<?> injectedClass = setterInjection.value();
				// We manage exception locally.
				// TODO: Better exception management
				try {
					// This must have default constructor					
					Object injected = injectedClass.newInstance();
					// We need to change the visibility of the method
					boolean originalAccessible = method.isAccessible(); 
					method.setAccessible(true);
					// We invoke the method
					method.invoke(injectEnabled, injected);
					// return visibility to previous value
					method.setAccessible(originalAccessible);
					// We write log message
					// TODO: Setup logs 
					System.out.println("Object of type "+injectedClass+" set with method"+method.getName());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}else{
				// Field not MemberInjection annotated
			}
		}		
	}
	
	/**
	 * Constructor injection
	 * @param injectEnabled The object destination of the constructor injection 
	 */	
	@SuppressWarnings("unchecked")
	public static final <T extends InjectEnabled> T createInjected(Class<T> injectEnabled){
		T returnObject = null;
		// We get constructor reference
		Constructor<?>[] constructors = injectEnabled.getDeclaredConstructors();
		// We check if constructor are annotated
		for(Constructor<?> constructor:constructors){
			// Looking for ConstructorInjection
			ConstructorInjection constructorInjection = constructor.getAnnotation(ConstructorInjection.class);
			if(constructorInjection!=null){
				// This field is ConstructorInjection annotated so we have to
				// obtain the reference of the object to inject and assign to the
				// field
				// TODO Optimize the caching and lifecycle of injected object
				Class<?> injectedClass = constructorInjection.value();
				// We manage exception locally.
				// TODO: Better exception management
				try {
					// This must have default constructor					
					Object injected = injectedClass.newInstance();
					// We need to change the visibility of the method
					boolean originalAccessible = constructor.isAccessible(); 
					constructor.setAccessible(true);
					// We invoke the constructor
					returnObject = (T) constructor.newInstance(injected);
					// return visibility to previous value
					constructor.setAccessible(originalAccessible);
					// We write log message
					// TODO: Setup logs 
					System.out.println("Object of type "+injectedClass+" set with constructor"+constructor.getName());
					// If here we exit the cycle
					break;
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}else{
				// Field not MemberInjection annotated
			}
		}
		return returnObject;		
	}	
	
}
