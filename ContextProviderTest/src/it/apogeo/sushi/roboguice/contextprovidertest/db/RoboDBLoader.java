package it.apogeo.sushi.roboguice.contextprovidertest.db;

import it.apogeo.sushi.roboguice.contextprovidertest.loaders.AbstractCustomLoader;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.inject.Inject;

/**
 * Version of DBloader with Injection from RoboGuice
 * 
 * @author Massimo Carli - 03/set/2012
 * 
 */
public class RoboDBLoader extends AbstractCustomLoader<Cursor> {
	
	
	@Inject protected SQLiteOpenHelper dbHelper; 
	
	protected String query;
	
	protected String[] params;

	protected Cursor cursor;
	
	@Inject
	public RoboDBLoader(Context context,String query,String[] params) {
		super(context);
		this.query = query;
		this.params = params;
	}

	@Override
	protected Cursor createData() {
		// We reutrn the Cursor executing the query
		cursor = dbHelper.getReadableDatabase().rawQuery(query, params);
		return cursor;
	}

	@Override
	protected void onReleaseResources(final Cursor data) {
		// Here we need to release the cursor
		if(data!=null && !data.isClosed()){
			data.close();
		}
	}

	@Override
	protected void registerObserver() {
		// TODO here we should implement a custom way to nbotify that cursor data
		// are Changed
	}

	@Override
	protected void unregisterObserver() {
		// Deregister observer but in this case is null
	}

}
