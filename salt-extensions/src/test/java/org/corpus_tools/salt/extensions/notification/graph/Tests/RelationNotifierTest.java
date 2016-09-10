/**
 * Copyright 2009 Humboldt-Universität zu Berlin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertEquals;

import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.graph.Tests.Helper.MyListener;
import org.corpus_tools.salt.extensions.notification.graph.impl.RelationNotifierImpl;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.graph.impl.tests.RelationTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RelationNotifierTest extends RelationTest {

	private RelationNotifierImpl fixture = null;

	public RelationNotifierImpl getFixture() {
		return fixture;
	}

	public void setNotifyingFixture(RelationNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Override
	public void setFixture(Relation<Node, Node> fixture) {
		Assert.assertTrue("Relation in test must be of instance RelationNotifierImpl",
				fixture instanceof RelationNotifierImpl);
		this.fixture = (RelationNotifierImpl) fixture;
		super.setFixture(fixture);
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
		Node node = GraphFactory.createNode();

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
		Node node = GraphFactory.createNode();

		fixture.setTarget(node);
		assertEquals(NOTIFICATION_TYPE.SET, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.RELATION_TARGET, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals(node, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);
	}
}