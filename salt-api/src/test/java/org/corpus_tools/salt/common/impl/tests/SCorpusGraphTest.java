/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.common.impl.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusDocumentRelation;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SCorpusRelation;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltInsertionException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.tests.SaltTestsUtil;
import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class SCorpusGraphTest extends TestCase implements GraphTraverseHandler {

	public static final String FILE_RESOURCE_DIR = SaltTestsUtil.FILE_RESOURCE_DIR + "SCorpusGraphTest/";
	public static final String FILE_TMP_DIR = "./_TMP/";

	private List<SNode> traversedNodes;

	protected SCorpusGraph fixture = null;

	protected void setFixture(SCorpusGraph fixture) {
		this.fixture = fixture;
	}

	protected SCorpusGraph getFixture() {
		return fixture;
	}

	private SCorpus alibiCorpus = null;
	private SDocument alibiDocument = null;

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSCorpusGraph());
		alibiCorpus = SaltFactory.createSCorpus();
		alibiDocument = SaltFactory.createSDocument();
	}

	/**
	 * Tests the setter and getter for salt-project.
	 */
	@Test
	public void testSetGetSaltProjetc() {
		assertNull(getFixture().getSaltProject());
		SaltProject project = SaltFactory.createSaltProject();
		getFixture().setSaltProject(project);
		assertEquals(project, getFixture().getSaltProject());
	}

	/**
	 * Tests the double chaining between {@link SCorpusGraph} and
	 * {@link SaltProject}.
	 */
	@Test
	public void testSaltProject_doubleChaining() {
		SaltProject project = SaltFactory.createSaltProject();
		assertEquals(0, project.getCorpusGraphs().size());
		getFixture().setSaltProject(project);
		assertEquals(1, project.getCorpusGraphs().size());
		assertEquals(getFixture(), project.getCorpusGraphs().get(0));
		getFixture().setSaltProject(null);
		assertEquals(0, project.getCorpusGraphs().size());
	}

	@Test
	public void testGetDocuments() {
		String[] ids = { "salt:/graph1#doc1", "salt:/graph1#doc2", "salt:/graph1#doc3", "salt:/graph1#doc4" };
		List<SDocument> docDSs = new ArrayList<SDocument>();
		for (String id : ids) {
			SDocument docDs = SaltFactory.createSDocument();
			docDs.setId(id);
			getFixture().addNode(docDs);
			docDSs.add(docDs);
		}

		assertTrue(docDSs.containsAll(getFixture().getDocuments()));
		assertTrue(getFixture().getDocuments().containsAll(docDSs));
	}

	@Test
	public void testGetCorpora() {
		String[] ids = { "salt:/graph1#corp1", "salt:/graph1#corp2", "salt:/graph1#corp3", "salt:/graph1#corp4" };
		List<SCorpus> corpDSs = new ArrayList<SCorpus>();
		for (String id : ids) {
			SCorpus corpDs = SaltFactory.createSCorpus();
			corpDs.setId(id);
			getFixture().addNode(corpDs);
			corpDSs.add(corpDs);
		}

		assertTrue(corpDSs.containsAll(getFixture().getCorpora()));
		assertTrue(getFixture().getCorpora().containsAll(corpDSs));
	}

	@Test
	public void testGetSCorpusRelations() {
		String[] ids = { "salt:/graph1#corpRel1", "salt:/graph1#corpRel2", "salt:/graph1#corpRel3",
				"salt:/graph1#corpRel4" };
		List<SCorpusRelation> corpRelDSs = new ArrayList<SCorpusRelation>();
		getFixture().addNode(alibiCorpus);
		for (String id : ids) {
			SCorpusRelation corpRel = SaltFactory.createSCorpusRelation();
			corpRel.setId(id);
			corpRel.setSource(alibiCorpus);
			corpRel.setTarget(alibiCorpus);
			getFixture().addRelation(corpRel);
			corpRelDSs.add(corpRel);
		}

		assertTrue(corpRelDSs.containsAll(getFixture().getCorpusRelations()));
		assertTrue(getFixture().getCorpusRelations().containsAll(corpRelDSs));
	}

	@Test
	public void testGetCorpusDocumentRelations() {
		String[] ids = { "salt:/graph1#corpRel1", "salt:/graph1#corpRel2", "salt:/graph1#corpRel3",
				"salt:/graph1#corpRel4" };
		List<SCorpusDocumentRelation> corpRelDSs = new ArrayList<SCorpusDocumentRelation>();
		getFixture().addNode(alibiCorpus);
		getFixture().addNode(alibiDocument);
		for (String id : ids) {
			SCorpusDocumentRelation corpDocRel = SaltFactory.createSCorpusDocumentRelation();
			corpDocRel.setId(id);
			corpDocRel.setSource(alibiCorpus);
			corpDocRel.setTarget(alibiDocument);
			getFixture().addRelation(corpDocRel);
			corpRelDSs.add(corpDocRel);
		}

		assertTrue(corpRelDSs.containsAll(getFixture().getCorpusDocumentRelations()));
		assertTrue(getFixture().getCorpusDocumentRelations().containsAll(corpRelDSs));
	}

	@Test
	public void testGetSCorpus__SId() {
		String[] ids = { "salt:/graph1#corp1", "salt:/graph1#corp2", "salt:/graph1#corp3", "salt:/graph1#corp4" };
		List<SCorpus> corpDSs = new ArrayList<SCorpus>();
		for (String id : ids) {
			SCorpus corpDs = SaltFactory.createSCorpus();
			corpDs.setId(id);
			getFixture().addNode(corpDs);
			corpDSs.add(corpDs);
		}

		for (SCorpus corpus : corpDSs) {
			assertEquals(corpus, getFixture().getCorpus(corpus.getIdentifier()));
		}
	}

	@Test
	public void testGetDocument__SId() {
		String[] ids = { "salt:/graph1#doc1", "salt:/graph1#doc2", "salt:/graph1#doc3", "salt:/graph1#doc4" };
		List<SDocument> docDSs = new ArrayList<SDocument>();
		for (String id : ids) {
			SDocument docDs = SaltFactory.createSDocument();
			docDs.setId(id);
			getFixture().addNode(docDs);
			docDSs.add(docDs);
		}

		for (SDocument corpus : docDSs) {
			assertEquals(corpus, getFixture().getDocument(corpus.getIdentifier()));
		}
	}

	/**
	 * Checks whether the adding of a sub corpus works as expected. Means an
	 * error if an empty super or sub corpus was passed, or if the super corpus
	 * was not already inserted into the graph. If the parameters are ok, sub
	 * corpus must be part of the graph.
	 */
	@Test
	public void testAddSSubCorpus__SCorpus_SCorpus() {
		SCorpus superCorpus = null;
		SCorpus subCorpus = null;
		// empty sub and super corpus
		try {
			getFixture().addSubCorpus(superCorpus, subCorpus);
			fail();
		} catch (SaltParameterException e) {
		}

		superCorpus = SaltFactory.createSCorpus();
		// empty sub corpus
		try {
			getFixture().addSubCorpus(superCorpus, subCorpus);
			fail();
		} catch (SaltParameterException e) {
		}

		superCorpus = null;
		subCorpus = SaltFactory.createSCorpus();
		// empty super corpus
		try {
			getFixture().addSubCorpus(superCorpus, subCorpus);
			fail();
		} catch (SaltParameterException e) {
		}

		superCorpus = SaltFactory.createSCorpus();
		try {
			getFixture().addSubCorpus(superCorpus, subCorpus);
			fail("An exception must be thrown, because the root corpus has not been inserted yet.");
		} catch (SaltInsertionException e) {
		}

		superCorpus.setId("fakeId");
		try {
			getFixture().addSubCorpus(superCorpus, subCorpus);
			fail("An exception must be thrown, because the root corpus has not been inserted yet.");
		} catch (SaltInsertionException e) {
		}

		getFixture().addNode(superCorpus);
		assertNotNull(getFixture().addSubCorpus(superCorpus, subCorpus));

		List<SRelation<? extends SNode, ? extends SNode>> relations = getFixture().getOutRelations(superCorpus.getId());
		assertNotNull(relations);
		assertTrue(relations.size() == 1);
		assertEquals(subCorpus, relations.get(0).getTarget());

		relations = getFixture().getInRelations(subCorpus.getId());
		assertNotNull(relations);
		assertTrue(relations.size() == 1);
		assertEquals(superCorpus, relations.get(0).getSource());
	}

	/**
	 * Checks whether the adding of a document works as expected. Means an error
	 * if an empty corpus or document was passed, or if the corpus was not
	 * already inserted into the graph. If the parameters are ok, document must
	 * be part of the graph.
	 */
	@Test
	public void testAddSDocument__SCorpus_SDocument() {
		SCorpus corpus = null;
		SDocument document = null;
		// empty sub and super corpus
		try {
			getFixture().addDocument(corpus, document);
			fail();
		} catch (SaltParameterException e) {
		}

		corpus = SaltFactory.createSCorpus();
		// empty sub corpus
		try {
			getFixture().addDocument(corpus, document);
			fail();
		} catch (SaltParameterException e) {
		}

		corpus = null;
		document = SaltFactory.createSDocument();
		// empty super corpus
		try {
			getFixture().addDocument(corpus, document);
			fail();
		} catch (SaltParameterException e) {
		}

		corpus = SaltFactory.createSCorpus();
		try {
			getFixture().addDocument(corpus, document);
			fail("An exception must be thrown, because the root corpus has not been inserted yet.");
		} catch (SaltInsertionException e) {
		}

		corpus.setId("fakeId");
		try {
			getFixture().addDocument(corpus, document);
			fail("An exception must be thrown, because the root corpus has not been inserted yet.");
		} catch (SaltInsertionException e) {
		}

		try {
			getFixture().addDocument(corpus, document);
			fail("An exception must be thrown, because the corpus has not been inserted yet.");
		} catch (Exception e) {
		}

		getFixture().addNode(corpus);
		assertNotNull(getFixture().addDocument(corpus, document));

		List<SRelation<? extends SNode, ? extends SNode>> relations = getFixture().getOutRelations(corpus.getId());
		assertNotNull(relations);
		assertTrue(relations.size() == 1);
		assertEquals(document, relations.get(0).getTarget());

		relations = getFixture().getInRelations(document.getId());
		assertNotNull(relations);
		assertTrue(relations.size() == 1);
		assertEquals(corpus, relations.get(0).getSource());
	}

	@Test
	public void testGetSCorpus__SDocument() {
		getFixture().getCorpus((SDocument) null);

		SCorpus sCorpus = null;
		SCorpus sSubCorpus = null;
		SDocument sDocument = null;

		sCorpus = SaltFactory.createSCorpus();
		getFixture().addNode(sCorpus);

		sDocument = SaltFactory.createSDocument();
		getFixture().addDocument(sCorpus, sDocument);
		assertEquals(sCorpus, getFixture().getCorpus(sDocument));

		sSubCorpus = SaltFactory.createSCorpus();
		getFixture().addSubCorpus(sCorpus, sSubCorpus);

		sDocument = SaltFactory.createSDocument();
		getFixture().addDocument(sSubCorpus, sDocument);
		assertEquals(sSubCorpus, getFixture().getCorpus(sDocument));
		assertFalse(sCorpus.equals(getFixture().getCorpus(sDocument)));
	}

	@Test
	public void testGetSRootCorpus() {
		SCorpus sCorp1 = SaltFactory.createSCorpus();
		SCorpus sCorp2 = SaltFactory.createSCorpus();
		SCorpus sCorp3 = SaltFactory.createSCorpus();
		getFixture().addNode(sCorp1);
		getFixture().addSubCorpus(sCorp1, sCorp2);
		getFixture().addSubCorpus(sCorp1, sCorp3);

		assertTrue(getFixture().getRoots().contains(sCorp1));
		assertEquals(1, getFixture().getRoots().size());
	}

	// TODO fixme, needs to adapt SampleGenerator
	// /**
	// * Tests the '{@link
	// de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#load(org.eclipse.emf.common.util.URI)
	// <em>Load</em>}' operation.
	// * Tests the loading of a {@link SCorpusGraph} object contained in a
	// {@link SaltProject} object persist in a
	// * SaltXML file. The used corpus structure is created via {@link
	// SampleGenerator#createCorpusStructure()}
	// * @see
	// de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#load(org.eclipse.emf.common.util.URI)
	// */
	// @Test
	// public void testLoad__URI()
	// {
	// SCorpusGraph template = SampleGenerator.createCorpusStructure();
	// for (SDocument sDocument: template.getDocuments())
	// {
	// SampleGenerator.createSDocumentStructure(sDocument);
	// }
	// SaltProject saltProject= SaltFactory.createSaltProject();
	// saltProject.getCorpusGraphs().add(template);
	// String tmpDir = System.getProperty("java.io.tmpdir")+"/"+
	// this.getClass().getName();
	// File tmpFile= new File(tmpDir);
	// URI tmpUri= URI.createFileURI(tmpFile.getAbsolutePath());
	// saltProject.saveSaltProject(tmpUri);
	// assertTrue("Cannot run test, because file does not exist: "+
	// tmpFile.getAbsolutePath(), tmpFile.exists());
	// getFixture().load(tmpUri);
	// assertNotNull(getFixture());
	// assertEquals("differences: "+ template.differences(getFixture()),
	// template, getFixture());
	// }

	/**
	 * Creating a corpus from a relational URI without a root corpus should
	 * create a new top-level corpus with the name of the first segment.
	 */
	@Test
	public void testCreateSCorpus_NoRoot() {
		List<SCorpus> corpora = getFixture().createCorpus(URI.createURI("corp1"));
		assertNotNull(corpora);
		assertEquals(1, corpora.size());
		assertEquals("corp1", corpora.get(0).getName());
	}

	/**
	 * Tests the creation of a {@link SCorpus} object via a super corpus.
	 */
	@Test
	public void testCreateSCorpus__SCorpus_String() {
		SCorpus sCorpus = SaltFactory.createSCorpus();
		getFixture().addNode(sCorpus);
		SCorpus sCorp2 = getFixture().createCorpus(sCorpus, "corp2");

		assertNotNull(getFixture().getNode(sCorp2.getId()));
		assertEquals(2, getFixture().getNodes().size());
		assertEquals(1, getFixture().getRelations().size());
	}

	/**
	 * Tests the creation of a {@link SDocument} object via a super corpus.
	 */
	@Test
	public void testCreateSDocument__SCorpus_String() {
		SCorpus sCorpus = SaltFactory.createSCorpus();
		getFixture().addNode(sCorpus);
		SDocument sDoc = getFixture().createDocument(sCorpus, "doc1");

		assertNotNull(getFixture().getNode(sDoc.getId()));
		assertEquals(2, getFixture().getNodes().size());
		assertEquals(1, getFixture().getRelations().size());
	}

	@Test
	public void testwhenCreatingCorporaViaURIWithoutScheme_thenShouldBeEqualToWithScheme() {
		URI path = URI.createURI("/c1/c2/c3");
		List<SCorpus> corpora = getFixture().createCorpus(path);

		assertNotNull(corpora);
		assertEquals(3, corpora.size());
		assertEquals(3, getFixture().getNodes().size());
		assertEquals(2, getFixture().getRelations().size());

		path = URI.createURI("/c1/c2/c4");
		corpora = getFixture().createCorpus(path);
		assertNotNull(corpora);
		assertEquals(1, corpora.size());
		assertEquals(4, getFixture().getNodes().size());
		assertEquals(3, getFixture().getRelations().size());
	}

	/**
	 * Tests the creation of {@link SCorpus} objects via a URI. The URI is
	 * c1/c2/c3 and c1/c2/c4
	 */
	@Test
	public void testwhenCreatingTwoCorporaViaCorpusPathes_thenFourCorporaShouldExist() {
		URI path = URI.createURI("salt:/c1/c2/c3");
		List<SCorpus> corpora = getFixture().createCorpus(path);

		assertNotNull(corpora);
		assertEquals(3, corpora.size());
		assertEquals(3, getFixture().getNodes().size());
		assertEquals(2, getFixture().getRelations().size());

		path = URI.createURI("salt:/c1/c2/c4");
		corpora = getFixture().createCorpus(path);
		assertNotNull(corpora);
		assertEquals(1, corpora.size());
		assertEquals(4, getFixture().getNodes().size());
		assertEquals(3, getFixture().getRelations().size());
	}

	/**
	 * Tests the creation of {@link SCorpus} objects via a URI. The URI is
	 * c1/c2/d1 and c1/c2/d2
	 */
	@Test
	public void testCreateSDocument__URI() {
		URI path = URI.createURI("salt:/c1/c2/c3");
		SDocument sDoc = getFixture().createDocument(path);

		assertNotNull(sDoc);
		assertEquals(3, getFixture().getNodes().size());
		assertEquals(2, getFixture().getRelations().size());

		path = URI.createURI("salt:/c1/c2/c4");
		sDoc = getFixture().createDocument(path);
		assertNotNull(sDoc);
		assertEquals(4, getFixture().getNodes().size());
		assertEquals(3, getFixture().getRelations().size());
	}

	@Test
	public void testCheckElementId() {
		SCorpus sCorpus = SaltFactory.createSCorpus();
		getFixture().addNode(sCorpus);
		assertEquals("salt:/corp1", sCorpus.getId());

		SDocument sDocument = SaltFactory.createSDocument();
		getFixture().addNode(sDocument);
		assertEquals("salt:/doc1", sDocument.getId());

		// TODO check, for corpora and documents with relations
		// salt:/corp1/corp2 ...
	}

	@Test
	public void testGraphTraversion() {
		this.traversedNodes = new ArrayList<SNode>();
		this.createCorpusStructure(getFixture());
		getFixture().traverse(getFixture().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "", this);

		assertTrue("GraphTraversionTest: First traversed object is not null, but " + this.traversedNodes.get(0) + "!",
				this.traversedNodes.get(0) == null);
		assertTrue("GraphTraversionTest: Second traversed object is not the corpus, but " + this.traversedNodes.get(1)
				+ "!", this.traversedNodes.get(1) instanceof SCorpus);
		assertTrue("GraphTraversionTest: Third traversed object is not the corpus, but " + this.traversedNodes.get(2)
				+ "!", this.traversedNodes.get(2) instanceof SCorpus);
		assertTrue("GraphTraversionTest: Fourth traversed object is not the document, but " + this.traversedNodes.get(3)
				+ "!", this.traversedNodes.get(3) instanceof SDocument);

	}

	/**
	 * Creates a corpus structure with one corpus and one document. It returns
	 * the created document. corp1 | doc1
	 * 
	 * @param corpGraph
	 * @return
	 */
	@Test
	private SDocument createCorpusStructure(SCorpusGraph corpGraph) {
		{// creating corpus structure
			// corpGraph= SaltFactory.createSCorpusGraph();
			// getFixture().getSaltProject().getCorpusGraphs().add(corpGraph);
			// corp1
			// |
			// doc1

			// corp1
			SCorpus corp1 = SaltFactory.createSCorpus();
			corp1.setName("corp1");
			corp1.setId("corp1");
			GraphFactory.createIdentifier(corp1, "corp1");

			corpGraph.addNode(corp1);

			// doc1
			SDocument doc1 = SaltFactory.createSDocument();
			GraphFactory.createIdentifier(doc1, "doc1");
			doc1.setName("doc1");
			corpGraph.addNode(doc1);
			doc1.setDocumentGraph(SaltFactory.createSDocumentGraph());
			// CorpDocRel
			SCorpusDocumentRelation corpDocRel1 = SaltFactory.createSCorpusDocumentRelation();
			GraphFactory.createIdentifier(corpDocRel1, "rel1");
			corpDocRel1.setName("rel1");
			corpDocRel1.setSource(corp1);
			corpDocRel1.setTarget(doc1);
			corpGraph.addRelation(corpDocRel1);
			return (doc1);
		}
	}

	@Test
	public void testwhenPrintingCorpusGraphToTreeString_thenTreeStringShouldBeReturned() {
		getFixture().createDocument(URI.createURI("/corpus1/corpus2/document1"));
		getFixture().createDocument(URI.createURI("/corpus1/corpus2/document2"));
		getFixture().createDocument(URI.createURI("/corpus1/corpus3/corpus4/document3"));
		getFixture().createDocument(URI.createURI("/corpus1/corpus3/corpus4/document4"));

		assertThat(fixture.toTreeString()).isEqualTo(
				"└── corpus1\n    ├── corpus2\n    │   ├── document1\n    │   └── document2\n    └── corpus3\n        └── corpus4\n            ├── document3\n            └── document4\n");
	}

	@Override
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
			SRelation<? extends SNode, ? extends SNode> relation, SNode fromNode, long order) {
		this.traversedNodes.add(fromNode);
		this.traversedNodes.add(currNode);

	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
			SRelation<?, ?> relation, SNode fromNode, long order) {
	}

	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation<?, ?> relation,
			SNode currNode, long order) {
		return true;
	}
} // SCorpusGraphTest
