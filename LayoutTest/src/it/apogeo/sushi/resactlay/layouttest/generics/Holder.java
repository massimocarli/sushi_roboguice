package it.apogeo.sushi.resactlay.layouttest.generics;

/**
 * Example of Generic Class
 * @author Massimo Carli - 22/ott/2012
 * @param <T> type of the object held
 */
public class Holder<T> {
	
	// The reference to the held object
	private final T mObj;
	
	/**
	 * Create a Holder with the given object
	 * @param obj The object held
	 */
	public Holder(T obj){
		this.mObj = obj;
	}
	
	/**
	 * @return The held object
	 */
	public T getObj() {
		return mObj;
	}

}
