package it.apogeo.sushi.roboguice.roboeventtest;

/**
 * Custom event with custom data
 * 
 * @author Massimo Carli - 05/set/2012
 *
 */
public class CustomEvent {
	
	/*
	 * The number of the istance
	 */
	private static int instanceNumber = 0;
	
	private int eventId;
	
	private long timestamp;
	
	private String eventName;
	
	// Private constructor
	private CustomEvent(){
		timestamp = System.currentTimeMillis();
		eventId = instanceNumber++;
	}
	
	/**
	 * @return A CustomEvent with timestamp and unique id  
	 */
	public static CustomEvent createEvent(){
		CustomEvent customEvent = new CustomEvent();
		return customEvent;
	}
	
	public CustomEvent withEventName(String eventName){
		this.eventName = eventName;
		return this;
	}
	
	public int getEventId() {
		return eventId;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

}
