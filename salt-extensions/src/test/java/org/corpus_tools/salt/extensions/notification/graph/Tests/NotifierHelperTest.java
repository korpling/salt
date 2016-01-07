package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.graph.impl.NotifierHelper;
import org.junit.Test;

import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;

public class NotifierHelperTest {

	@Test
	public void testAddRemoveGetListener() {
		Listener listener1 = new Listener() {
			@Override
			public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
			}
		};
		Listener listener2 = new Listener() {
			@Override
			public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
			}
		};

		assertNotNull(NotifierHelper.getListener(null));
		assertEquals(0, NotifierHelper.getListener(null).size());

		ArrayList<Listener> listenerList = new ArrayList<>();
		assertEquals(0, NotifierHelper.getListener(listenerList).size());

		NotifierHelper.addListener(listenerList, (Listener)null);
		assertEquals(0, NotifierHelper.getListener(listenerList).size());

		NotifierHelper.addListener(listenerList, listener1);
		assertEquals(1, NotifierHelper.getListener(listenerList).size());

		NotifierHelper.addListener(listenerList, listener2);
		assertEquals(2, NotifierHelper.getListener(listenerList).size());
	}

}
