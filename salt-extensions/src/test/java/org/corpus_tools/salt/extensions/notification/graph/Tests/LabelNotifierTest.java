package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertEquals;

import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.graph.Tests.Helper.MyListener;
import org.corpus_tools.salt.extensions.notification.graph.impl.LabelNotifierImpl;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.junit.Before;
import org.junit.Test;

public class LabelNotifierTest {

	private LabelNotifierImpl fixture = null;

	public LabelNotifierImpl getFixture() {
		return fixture;
	}

	public void setFixture(LabelNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new LabelNotifierImpl());
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationNamespace() {
		MyListener listener = new MyListener();
		getFixture().addListener(listener);
		getFixture().setNamespace("myNamespace");
		assertEquals(NOTIFICATION_TYPE.SET, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.LABEL_NAMESPACE, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals("myNamespace", listener.lastEvent.newValue);
		assertEquals(getFixture(), listener.lastEvent.container);
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationName() {
		MyListener listener = new MyListener();
		getFixture().addListener(listener);

		getFixture().setName("myName");
		assertEquals(NOTIFICATION_TYPE.SET, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.LABEL_NAME, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals("myName", listener.lastEvent.newValue);
		assertEquals(getFixture(), listener.lastEvent.container);
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationValue() {
		MyListener listener = new MyListener();
		getFixture().addListener(listener);
		getFixture().setValue("myValue");
		assertEquals(NOTIFICATION_TYPE.SET, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.LABEL_VALUE, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals("myValue", listener.lastEvent.newValue);
		assertEquals(getFixture(), listener.lastEvent.container);
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture, GRAPH_ATTRIBUTES.LABEL_LABELS);
	}
}