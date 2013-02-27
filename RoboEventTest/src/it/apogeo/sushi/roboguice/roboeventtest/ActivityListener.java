package it.apogeo.sushi.roboguice.roboeventtest;

import roboguice.activity.event.OnCreateEvent;
import roboguice.activity.event.OnResumeEvent;
import roboguice.activity.event.OnStartEvent;
import roboguice.event.Observes;
import roboguice.util.Ln;

/**
 * Example of a Listener.
 * 
 * @author Massimo Carli - 05/set/2012
 * 
 */
public class ActivityListener {

	/**
	 * Called after OnCreate
	 * 
	 * @param onCreateEvent
	 *            Incasulate onCreate data
	 */
	public void afterOnCreate(@Observes OnCreateEvent onCreateEvent) {
		Ln.i("afterOnCreate %s", onCreateEvent.getSavedInstanceState());
	}

	/**
	 * Called after OnStart
	 * 
	 * @param onCreateEvent
	 *            Incasulate onStart data
	 */
	public void afterOnStart(@Observes OnStartEvent onStartEvent) {
		Ln.i("afterOnStart");
	}

	/**
	 * Called after OnResume
	 * 
	 * @param onCreateEvent
	 *            Incasulate onResume data
	 */
	public void afterOnResume(@Observes OnResumeEvent onResumeEvent) {
		Ln.i("afterOnResume");
	}

	/**
	 * Custom event
	 * 
	 * @param CustomEvent
	 *            Incasulate custom data
	 */
	public void afterOnResume(@Observes CustomEvent customData) {
		Ln.i("CustomEvent with id:%d time:%d and name %s",
				customData.getEventId(), customData.getTimestamp(),
				customData.getEventName());
	}

}
