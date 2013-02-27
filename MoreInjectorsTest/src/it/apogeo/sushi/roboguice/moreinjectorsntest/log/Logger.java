package it.apogeo.sushi.roboguice.moreinjectorsntest.log;

/**
 * Simple interface of a Logger
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
public interface Logger {
	
	
	/**
	 * Write the log
	 * @param message The message to Log
	 */
	public void log(String message);
	
	/**
	 * Write the warn log
	 * @param warnMessage The message for the wanr log
	 */
	public void warn(String warnMessage);

}
