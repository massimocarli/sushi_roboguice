package it.apogeo.sushi.roboguice.contextprovidertest.fragment;

import it.apogeo.sushi.roboguice.contextprovidertest.R;
import it.apogeo.sushi.roboguice.contextprovidertest.db.DB;
import it.apogeo.sushi.roboguice.contextprovidertest.db.DBLoader;
import it.apogeo.sushi.roboguice.contextprovidertest.db.SimpleDBHelper;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.widget.SimpleCursorAdapter;

/**
 * @author Massimo Carli - 04/set/2012
 *
 */
public class TestListFragment extends ListFragment implements LoaderCallbacks<Cursor>{

	// The loader's unique id
	private static final int LOADER_ID = 0;
	
	private final String[] FROM = new String[]{DB.TEST.NAME,DB.TEST.AGE};
	private final int[] TO = new int[]{R.id.item_name,R.id.item_age};	
	
	private SimpleCursorAdapter adapter;
	
	private SimpleDBHelper dbHelper;
	
	/**
	 * Static factory method for Fragment
	 * @return The TestListFragment instance
	 */
	public static TestListFragment getInstance(){
		TestListFragment testFragment = new TestListFragment();
		return testFragment;
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		dbHelper = new SimpleDBHelper(getActivity());
		updateAdapterWithCursor(null);
		// We initialize the Loader
		getLoaderManager().initLoader(LOADER_ID, null, this);		
	}
	
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// We create our DBLoader
		return new DBLoader(getActivity(),dbHelper,"SELECT _id,name,age FROM TEST",null);
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
		adapter = new SimpleCursorAdapter(getActivity(),R.layout.list_row_layout,cursor,FROM,TO);
		setListAdapter(adapter);
	}

}
