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
import static org.junit.Assert.assertFalse;

import java.io.File;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.corpus_tools.salt.extensions.notification.graph.Notifier;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.LabelableElement;
import org.corpus_tools.salt.tests.SaltTestsUtil;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;

public class Helper {

	static class MyListener implements Listener {

		Event lastEvent = null;

		@Override
		public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue,
				Object container) {
			lastEvent = new Event(type, attribute, oldValue, newValue, container);
		}
	}

	/** Checks whether the notification about name change is correct. **/
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
	
	static class ProjectBuilder {
		
		/**
		 * Creates and persists a testable {@link SaltProject}.
		 * This can be used for testing implementation details
		 * of the Notification mechanism and its delegation setup.
		 * 
		 * Note that the project is built with the default
		 * {@link SaltFactory}, *not* the {@link SaltNotificationFactory}.
		 * 
		 * Structure:
		 * 
		 * - corpus1: contains doc1 and doc2
		 * - corpus2: contains doc3
		 * 
		 * All documents contain an {@link SDocumentGraph} and
		 * dummy data.
		 * 
		 * @author Stephan Druskat
		 */
		public static void buildPersistedTestableSaltProject() {
			assertFalse(SaltFactory.getFactory() instanceof SaltNotificationFactory);
			SaltProject project = SaltFactory.createSaltProject();
			SCorpusGraph corpusGraph = SaltFactory.createSCorpusGraph();
			project.addCorpusGraph(corpusGraph);
			SDocument doc1 = SaltFactory.createSDocument();
			SDocument doc2 = SaltFactory.createSDocument();
			SDocument doc3 = SaltFactory.createSDocument();
			SCorpus corpus1 = SaltFactory.createSCorpus();
			SCorpus corpus2 = SaltFactory.createSCorpus();
			corpusGraph.addNode(corpus1);
			corpusGraph.addNode(corpus2);
			corpusGraph.addDocument(corpus1, doc1);
			corpusGraph.addDocument(corpus1, doc2);
			corpusGraph.addDocument(corpus2, doc3);
			doc1.createDocumentGraph();
			doc2.createDocumentGraph();
			doc3.createDocumentGraph();
			SDocumentGraph graph1 = doc1.getDocumentGraph();
			SDocumentGraph graph2 = doc2.getDocumentGraph();
			SDocumentGraph graph3 = doc3.getDocumentGraph();
			createMinimalData(graph1);
			createMinimalData(graph2);
			createMinimalData(graph3);
			String outFolder = SaltTestsUtil.getTempTestFolder("/buildPersistedTestableSaltProject") + "/saltProject";
			File tmpFile = new File(outFolder + "/" + SaltUtil.FILE_SALT_PROJECT);
			SaltUtil.saveSaltProject(project, URI.createFileURI(tmpFile.getAbsolutePath()));
		}

		private static void createMinimalData(SDocumentGraph graph) {
			STextualDS ds = graph.createTextualDS("This is a birthday pony.");
			SToken t1 = graph.createToken(ds, 0, 4); // "This"
			SToken t2 = graph.createToken(ds, 5, 7); // "is"
			SToken t3 = graph.createToken(ds, 8, 9); // "a"
			SToken t4 = graph.createToken(ds, 10, 18); // "birthday"
			SToken t5 = graph.createToken(ds, 19, 23); // "pony"
			SToken t6 = graph.createToken(ds, 23, 24); // "."
			graph.createSpan(t4, t5); // "birthday pony."
			graph.createSpan(t1, t2, t3, t4, t5); // "This is a birthday pony"
			graph.createStructure(t1, t2, t3, t4, t5, t6); // "This is a birthday pony."
		}
		
		public static URI getProjectURI() {
			String outFolder = SaltTestsUtil.getTempTestFolder("/buildPersistedTestableSaltProject") + "/saltProject";
			File tmpFile = new File(outFolder + "/" + SaltUtil.FILE_SALT_PROJECT);
			return URI.createFileURI(tmpFile.getAbsolutePath());
		}
		
	}
}
