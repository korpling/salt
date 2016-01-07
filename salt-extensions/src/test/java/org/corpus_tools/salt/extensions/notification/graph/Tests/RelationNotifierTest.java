package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertEquals;

import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.graph.Notifier;
import org.corpus_tools.salt.extensions.notification.graph.Tests.Helper.MyListener;
import org.corpus_tools.salt.extensions.notification.graph.impl.NotifierHelper;
import org.corpus_tools.salt.extensions.notification.graph.impl.RelationNotifierImpl;
import org.junit.Before;
import org.junit.Test;

import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;

public class RelationNotifierTest {

	private RelationNotifierImpl fixture = null;

	public RelationNotifierImpl getFixture() {
		return fixture;
	}

	public void setFixture(RelationNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new RelationNotifierImpl());
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture, GRAPH_ATTRIBUTES.RELATION_LABELS);
	}
	
	@Test
	public void testNotificationSetSource() {
		MyListener listener = new MyListener();
		fixture.addListener(listener);
		Node node= GraphFactory.createNode();
		
		fixture.setSource(node);
		assertEquals(NOTIFICATION_TYPE.SET, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.RELATION_SOURCE, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals(node, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);
	}

	@Test
	public void testNotificationSetTarget() {
		MyListener listener = new MyListener();
		fixture.addListener(listener);
		Node node= GraphFactory.createNode();
	
		fixture.setTarget(node);
		assertEquals(NOTIFICATION_TYPE.SET, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.RELATION_TARGET, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals(node, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);
	}
}