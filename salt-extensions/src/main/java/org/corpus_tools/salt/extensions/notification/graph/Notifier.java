package org.corpus_tools.salt.extensions.notification.graph;

import java.util.Collection;
import java.util.List;

import org.corpus_tools.salt.extensions.notification.Listener;

/**
 * To all classes implementing this interface a listener can be added. This
 * listener would then be notified about all changes in the object.
 * 
 * @author florian
 *
 */
public interface Notifier {
	/**
	 * Returns an unmodifiable list of all listeners. If no listener is
	 * registered null is returned.
	 * 
	 * @return all registered listeners
	 **/
	public List<Listener> getListener();

	/**
	 * Adds a new listener, which then will be notified about a change in this
	 * object.
	 * 
	 * @param listener
	 *            to be notified
	 */
	public void addListener(Listener listener);

	/**
	 * Adds a set of new listener, which then will be notified about a change in
	 * this object.
	 * 
	 * @param listener
	 *            to be notified
	 */
	public void addListener(Collection<Listener> listener);

	/**
	 * Removes a listener, which won't be notified about a change in this object
	 * anymore.
	 * 
	 * @param listener
	 *            to be notified
	 */
	public void removeListener(Listener listener);
}
