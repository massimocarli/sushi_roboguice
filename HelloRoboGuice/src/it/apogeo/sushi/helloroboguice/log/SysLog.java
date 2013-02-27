package it.apogeo.sushi.helloroboguice.log;

import com.google.inject.Singleton;


/**
 * Implementation of a Logger that uses System.out PrintStream
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
@Singleton
public class SysLog implements Logger {

	/* (non-Javadoc)
	 * @see it.apogeo.sushi.roboguice.module.Logger#log(java.lang.String)
	 */
	@Override
	public void log(String message) {
		System.out.println(message);
	}

	/* (non-Javadoc)
	 * @see it.apogeo.sushi.roboguice.module.Logger#warn(java.lang.String)
	 */
	@Override
	public void warn(String warnMessage) {
		System.out.println(warnMessage);
	}

}
