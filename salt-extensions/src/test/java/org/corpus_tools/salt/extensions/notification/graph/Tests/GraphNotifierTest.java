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

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.graph.Tests.Helper.MyListener;
import org.corpus_tools.salt.extensions.notification.graph.impl.GraphNotifierImpl;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.graph.impl.tests.GraphTest;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.tests.SaltTestsUtil;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;
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

	@Test
	public void testSerializeGraphWithDelegates() throws IOException {

		SaltFactory.setFactory(new SaltNotificationFactory());

		// create template
		SaltProject template = SampleGenerator.createSaltProject();
		template.setName(null);
		assertEquals(1, template.getCorpusGraphs().size());

		SDocument doc1 = template.getCorpusGraphs().get(0).getDocuments().get(0);
		List<SToken> tokens = doc1.getDocumentGraph().getSortedTokenByText();
		doc1.getDocumentGraph().createSpan(tokens.get(0), tokens.get(1));

		// store other document
		File tmpFile = SaltTestsUtil.getTempTestFolder("/testLoadStoreExampleProject");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		template.saveSaltProject(path);

		// load project
		SaltProject loaded = SaltUtil.loadCompleteSaltProject(path);

		// compare document graphs
		assertEquals(1, loaded.getCorpusGraphs().size());
		Set<Difference> corpusGraphDiff = SaltUtil.compare(template).with(loaded)
				.useOption(DiffOptions.OPTION_IGNORE_ID, false).andFindDiffs();
		assertEquals(0, corpusGraphDiff.size());

		// compare documents
		List<SDocument> templateDocs = template.getCorpusGraphs().get(0).getDocuments();
		List<SDocument> loadedDocs = loaded.getCorpusGraphs().get(0).getDocuments();
		assertEquals(templateDocs.size(), loadedDocs.size());
		for (int i = 0; i < templateDocs.size(); i++) {
			Set<Difference> docDiff = SaltUtil.compare(templateDocs.get(i).getDocumentGraph())
					.with(loadedDocs.get(i).getDocumentGraph()).andFindDiffs();
			assertEquals(0, docDiff.size());
		}
	}

}