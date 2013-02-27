package it.apogeo.sushi.roboguice.contextprovidertest.db;

import android.provider.BaseColumns;

/**
 * Interface that describes the configuration data of the DB 
 * 
 * @author Massimo Carli - 31/ago/2012
 *
 */
public interface DB {
	
	/**
	 * The name of the test DB 
	 */
	public static final String DB_NAME = "TestDB";

	/**
	 * The version of the test DB 
	 */
	public static final int DB_VERSION = 1;	
	
	/**
	 * Metadata for the TEST Table 
	 *
	 */
	public static interface TEST extends BaseColumns{
		
		public static String TABLE_NAME = "TEST";
		
		public static String NAME = "name";
		public static String AGE = "age";
	}
	
}
