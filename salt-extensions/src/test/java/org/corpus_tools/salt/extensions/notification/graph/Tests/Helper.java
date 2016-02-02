package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertEquals;

import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.graph.Notifier;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.LabelableElement;
import org.junit.Test;

public class Helper {

	static class MyListener implements Listener {

		Event lastEvent = null;

		@Override
		public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
			lastEvent = new Event(type, attribute, oldValue, newValue, container);
		}
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public static void testNotificationAddRemoveValue(LabelableElement fixture, GRAPH_ATTRIBUTES attribute) {
		MyListener listener = new MyListener();
		if (fixture instanceof Notifier) {
			((Notifier) fixture).addListener(listener);
		}
		Label label = GraphFactory.createLabel();
		label.setNamespace("myNamespace");
		label.setName("myName");

		fixture.addLabel(label);
		assertEquals(NOTIFICATION_TYPE.ADD, listener.lastEvent.type);
		assertEquals(attribute, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals(label, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);

		fixture.removeLabel(label.getNamespace(), label.getName());
		assertEquals(NOTIFICATION_TYPE.REMOVE, listener.lastEvent.type);
		assertEquals(attribute, listener.lastEvent.attribute);
		assertEquals(label, listener.lastEvent.oldValue);
		assertEquals(null, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);
	}
}
