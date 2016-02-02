package org.corpus_tools.salt.extensions.notification.graph.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.graph.Notifier;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;

public class NotifierHelper {

	/** @see Notifier#getListener() */
	public static List<Listener> getListener(List<Listener> listenerList) {
		if (listenerList == null) {
			return (Collections.unmodifiableList(new ArrayList<Listener>()));
		} else {
			return (Collections.unmodifiableList(listenerList));
		}
	}

	/** @see Notifier#addListener(Listener) */
	public static List<Listener> addListener(List<Listener> listenerList, Listener listener) {
		if (listener != null) {
			if (listenerList == null) {
				listenerList = new ArrayList<Listener>();
			}
			listenerList.add(listener);
		}
		return (listenerList);
	}

	/** @see Notifier#addListener(Listener) */
	public static List<Listener> addListener(List<Listener> listenerList, Collection<Listener> newListeners) {
		if (newListeners != null) {
			if (listenerList == null) {
				listenerList = new ArrayList<Listener>();
			}
			listenerList.addAll(newListeners);
		}
		return (listenerList);
	}

	/** @see Notifier#removeListener(Listener) */
	public static List<Listener> removeListener(List<Listener> listenerList, Listener listener) {
		if (listener != null) {
			if (listenerList != null) {
				if (listenerList.size() == 1) {
					listenerList = null;
				} else {
					listenerList.remove(listener);
				}
			}
		}
		return (listenerList);
	}

	/**
	 * Passes the notification to all listeners in list.
	 * 
	 * @param listenerList
	 * @param type
	 * @param attribute
	 * @param oldValue
	 * @param newValue
	 * @param container
	 */
	public static void notify(List<Listener> listenerList, NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
		if (listenerList != null && listenerList.size() > 0) {
			Iterator<Listener> it = listenerList.iterator();
			while (it.hasNext()) {
				it.next().notify(type, attribute, oldValue, newValue, container);
			}
		}
	}
}
