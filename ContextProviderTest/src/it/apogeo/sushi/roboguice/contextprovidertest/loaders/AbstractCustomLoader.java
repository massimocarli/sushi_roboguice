package it.apogeo.sushi.roboguice.contextprovidertest.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

/**
 * Example of a Custom Loader implementation
 * 
 * @author Massimo Carli - 31/ago/2012
 * 
 */
public abstract class AbstractCustomLoader<D> extends AsyncTaskLoader<D> {

	/*
	 * The reference to the loaded Data
	 */
	protected D mData;

	public AbstractCustomLoader(Context context) {
		// Never retain the Context here to prevent memory leak!! The
		// super(Context) is retaining the Application Context
		// Before API Level 8 you had to call super()
		super(context);
	}

	@Override
	public D loadInBackground() {
		// Here we have to get the data in async way
		mData = createData();
		return mData;
	}

	@Override
	public void deliverResult(D data) {
		// Here we have to deliver the data to the listener but we MUST adhere
		// to the related state convention
		if (isReset()) {
			// In this case the state is reset so we have to clean the data
			onReleaseResources(data);
			// And finish
			return;
		}
		// We need to hold a reference to the old data until the new is
		// available to prevent GC in case of other component (es: Adapter) usage
		D oldData = mData;
		mData = data;
		if (isStarted()) {
			// If the Loader is in a started state, deliver the results to the
			// client with the super implementation
			super.deliverResult(mData);
		}
		// Invalidate the old data as we don't need it any more.
		if (oldData != null && oldData!=mData) {
			onReleaseResources(oldData);
		}
	};

	@Override
	protected void onStartLoading() {
		// Here we have to deliver the data if available
		if (mData != null) {
			deliverResult(mData);
		}
		// Now we're in start state so we need to monitor for data changes.
		// To do that we start to observer the data
		// Register for changes which is Loader dependent
		registerObserver();
		// Now if we're in the started state and content is changes we have
		// a flag that we can check with the method takeContentChanged()
		// and force the load					
		if (takeContentChanged() || mData == null) {
			forceLoad();
		}
	}

	@Override
	public void onStopLoading() {
		// This method is called when the Loader is in stopped state.
		// In this state we cancel the load if in place
		cancelLoad();
		// It's important that the Observers are active because in this state
		// the monitoring for changes is still active but it won't notify 
		// changes until in the started state again 
	}
	
	
	@Override
	public void onReset() {
		// Ensure the loader has been stopped.
		onStopLoading();

		// At this point we can release the resources associated with 'mData'.
		if (mData != null) {
			onReleaseResources(mData);
			mData = null;
		}
		// The Loader is being reset so we need to unregister Observer
		unregisterObserver();
	}
	
	@Override
	public void onCanceled(D data) {
		onReleaseResources(mData);
	};
	

	/**
	 * This method is responsable to fetch the data. it's executed in background thread
	 * 
	 * @return The data fetched from the Data Source
	 */
	protected abstract D createData();
	
	/**
	 * Method that will contain the release of data from memory if present. Be careful
	 * that putting data to null is NOT a solution. So we put the final there
	 * 
	 * @param data reference to the data to clean
	 */
	protected abstract void onReleaseResources(final D data);
	
	/**
	 * Every specific implementation must implement a way to detect a changes in the data
	 * so we need to register here the listener for that
	 */
	protected abstract void registerObserver();

	/**
	 * We must provide a way to unregister the observer
	 */	
	protected abstract void unregisterObserver();

}
