package it.apogeo.sushi.roboguice.contextprovidertest.db;

import roboguice.inject.ContextSingleton;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Classic implementation of a SQLiteOpenHelper without RoboGuice
 * 
 * @author Massimo Carli - 31/ago/2012
 *
 */
@ContextSingleton
public class InjectDBHelper extends SQLiteOpenHelper {
	
	@Inject
	public InjectDBHelper(Provider<Context> contextProvider){
		super(contextProvider.get(),DB.DB_NAME,null,DB.DB_VERSION);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			db.beginTransaction();
			db.execSQL("CREATE TABLE IF NOT EXISTS TEST (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age NUMERIC);");
			// Insert N test data
			SQLiteStatement st = db.compileStatement("INSERT INTO TEST (name,age) VALUES (?,?)");
			for(int i=0;i<100;i++){
				st.bindString(1, "Name_"+i);
				st.bindLong(2, 20+i);
				st.executeInsert();
			}
			db.setTransactionSuccessful();
		}finally{
			db.endTransaction();
		}
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop the Db and create it again
		try{
			db.beginTransaction();
			db.execSQL("DROP TABLE;");
			db.setTransactionSuccessful();
			onCreate(db);			
		}finally{
			db.endTransaction();
		}
	}

}
