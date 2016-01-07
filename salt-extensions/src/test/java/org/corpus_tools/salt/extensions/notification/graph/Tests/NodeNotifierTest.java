package org.corpus_tools.salt.extensions.notification.graph.Tests;

import org.corpus_tools.salt.extensions.notification.graph.impl.NodeNotifierImpl;
import org.junit.Before;
import org.junit.Test;

import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;

public class NodeNotifierTest {

	private NodeNotifierImpl fixture = null;

	public NodeNotifierImpl getFixture() {
		return fixture;
	}

	public void setFixture(NodeNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new NodeNotifierImpl());
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture, GRAPH_ATTRIBUTES.NODE_LABELS);
	}
}