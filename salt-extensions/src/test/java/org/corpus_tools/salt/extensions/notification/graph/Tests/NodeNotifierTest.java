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

import org.corpus_tools.salt.extensions.notification.graph.impl.GraphNotifierImpl;
import org.corpus_tools.salt.extensions.notification.graph.impl.LayerNotifierImpl;
import org.corpus_tools.salt.extensions.notification.graph.impl.NodeNotifierImpl;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.graph.impl.tests.NodeTest;
import org.junit.Before;
import org.junit.Test;

public class NodeNotifierTest extends NodeTest {

	private NodeNotifierImpl fixture = null;

	@Override
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

	@Override
	public Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> createGraph() {
		return new GraphNotifierImpl<>(Node.class, GraphFactory.RELATION_CLASS, GraphFactory.LAYER_CLASS);
	}

	@Override
	public Layer<Node, Relation<Node, Node>> createLayer() {
		return new LayerNotifierImpl<>();
	}

	@Override
	public Node createNode() {
		return new NodeNotifierImpl();
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture, GRAPH_ATTRIBUTES.NODE_LABELS);
	}
}