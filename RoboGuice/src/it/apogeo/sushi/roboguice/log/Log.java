package it.apogeo.sushi.roboguice.log;

/**
 * Just to inclapsulate log messages
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
public class Log {

	// Private constructor
	private Log(){
		throw new AssertionError("Never instantiate me!!!");
	}
	
	/**
	 * Print a log as a log :)
	 * @param log The log to print
	 */
	public static void log(String log){
		System.out.println(log);
	}
	
	/**
	 * Print a log as a warning
	 * @param warningMessage The warning message to print
	 */
	public static void warn(String warningMessage){
		System.out.println("Warning:"+warningMessage);
	}	
}
