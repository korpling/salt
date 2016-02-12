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
import org.corpus_tools.salt.extensions.notification.graph.impl.GraphNotifierImpl;
import org.corpus_tools.salt.extensions.notification.graph.impl.LayerNotifierImpl;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.graph.impl.tests.GraphTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphNotifierTest extends GraphTest {

	private GraphNotifierImpl fixture = null;

  @Override
	public GraphNotifierImpl getFixture() {
		return fixture;
	}

	public void setNotifyingFixture(GraphNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Override
	public void setFixture(Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> fixture) {
		Assert.assertTrue("Graph in test must be of instance GraphNotifierImpl", fixture instanceof GraphNotifierImpl);
		this.fixture = (GraphNotifierImpl) fixture;
		super.setFixture(fixture);
	}
	

	@Before
	@Override
	public void setUp() throws Exception {
		setNotifyingFixture(new GraphNotifierImpl());
		super.setFixture(fixture);
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture, GRAPH_ATTRIBUTES.GRAPH_LABELS);
	}

	/** Checks whether the graph sends a notification when a node was added. **/
	@Test
	public void testNotificationAddNode() {
		MyListener listener = new MyListener();
		fixture.addListener(listener);
		Node node = GraphFactory.createNode();

		fixture.addNode(node);
		assertEquals(NOTIFICATION_TYPE.ADD, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.GRAPH_NODES, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals(node, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);
	}

	/**
	 * Checks whether the graph sends a notification when a relation was added.
	 **/
	@Test
	public void testNotificationRelationNode() {
		MyListener listener = new MyListener();
		fixture.addListener(listener);
		Relation relation = GraphFactory.createRelation();
		Node node = GraphFactory.createNode();
		getFixture().addNode(node);
		relation.setSource(node);
		relation.setTarget(node);

		fixture.addRelation(relation);
		assertEquals(NOTIFICATION_TYPE.ADD, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.GRAPH_RELATIONS, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals(relation, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);
	}

	/**
	 * Checks whether the graph sends a notification when a layer was added.
	 **/
	@Test
	public void testNotificationAddLayer() {
		MyListener listener = new MyListener();
		fixture.addListener(listener);
		Layer layer = GraphFactory.createLayer();

		fixture.addLayer(layer);
		assertEquals(NOTIFICATION_TYPE.ADD, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.GRAPH_LAYERS, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals(layer, listener.lastEvent.newValue);
		assertEquals(fixture, listener.lastEvent.container);
	}
}