package it.apogeo.sushi.roboguice.contextprovidertest.fragment;

import it.apogeo.sushi.roboguice.contextprovidertest.R;
import it.apogeo.sushi.roboguice.contextprovidertest.db.DB;
import it.apogeo.sushi.roboguice.contextprovidertest.db.DBLoader;
import roboguice.fragment.RoboListFragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.widget.SimpleCursorAdapter;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Massimo Carli - 04/set/2012
 *
 */
public class InjectedTestListFragment extends RoboListFragment implements LoaderCallbacks<Cursor>{

	// The loader's unique id
	private static final int LOADER_ID = 0;
	
	private final String[] FROM = new String[]{DB.TEST.NAME,DB.TEST.AGE};
	private final int[] TO = new int[]{R.id.item_name,R.id.item_age};	
	
	private SimpleCursorAdapter adapter;
	
	@Inject
	private SQLiteOpenHelper dbHelper;
	
	@Inject 
	private Provider<Context> contextProvider;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		updateAdapterWithCursor(null);
		// We initialize the Loader
		getLoaderManager().initLoader(LOADER_ID, null, this);		
	}
	
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// We need to get The RoboDBloader from the Injector
		return new DBLoader(contextProvider.get(),dbHelper,"SELECT _id,name,age FROM TEST",null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        // A switch-case is useful when dealing with multiple Loaders/IDs
        switch(loader.getId()) {
          case LOADER_ID:
            // The asynchronous load is complete and the data
            // is now available for use. Only now can we associate
            // the queried Cursor with the SimpleCursorAdapter.
        	  updateAdapterWithCursor(cursor);
            break;
        }
        // The listview now displays the queried data.
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
	    // For whatever reason, the Loader's data is now unavailable.
        // Remove any references to the old data by replacing it with
        // a null Cursor.
		updateAdapterWithCursor(null);
	}	
	
	private void updateAdapterWithCursor(Cursor cursor){
		adapter = new SimpleCursorAdapter(contextProvider.get(),R.layout.list_row_layout,cursor,FROM,TO);
		setListAdapter(adapter);
	}

}
