/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.impl.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.GraphFactory;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.core.GraphTraverseHandler;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;


public class SCorpusGraphTest extends TestCase implements GraphTraverseHandler{

	public static final String FILE_RESOURCE_DIR= SaltFactoryImplTest.FILE_RESOURCE_DIR_GENERAL+"SCorpusGraphTest/";
	public static final String FILE_TMP_DIR= "./_TMP/";
	
	private List<SNode> traversedNodes;

	protected SCorpusGraph fixture = null;
	
	protected void setFixture(SCorpusGraph fixture) {
		this.fixture = fixture;
	}

	protected SCorpusGraph getFixture() {
		return fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSCorpusGraph());
	}

	@Test
	public void testgetDocuments() 
	{
		String[] ids= {"salt:/graph1#doc1", "salt:/graph1#doc2", "salt:/graph1#doc3", "salt:/graph1#doc4"};
		List<SDocument> docDSs= new ArrayList<SDocument>();
		for (String id: ids)
		{
			SDocument docDs= SaltFactory.createSDocument();
			docDs.setId(id);
			getFixture().addNode(docDs);
			docDSs.add(docDs);
		}	
		
		assertTrue(docDSs.containsAll(getFixture().getDocuments()));
		assertTrue(getFixture().getDocuments().containsAll(docDSs));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getCorpora() <em>SCorpora</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getCorpora()
	 */
	@Test
	public void testgetCorpora() 
	{
		String[] ids= {"salt:/graph1#corp1", "salt:/graph1#corp2", "salt:/graph1#corp3", "salt:/graph1#corp4"};
		List<SCorpus> corpDSs= new ArrayList<SCorpus>();
		for (String id: ids)
		{
			SCorpus corpDs= SaltFactory.createSCorpus();
			corpDs.setId(id);
			getFixture().addNode(corpDs);
			corpDSs.add(corpDs);
		}	
		
		assertTrue(corpDSs.containsAll(getFixture().getCorpora()));
		assertTrue(getFixture().getCorpora().containsAll(corpDSs));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations() <em>SCorpus Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations()
	 */
	@Test
	public void testGetSCorpusRelations() 
	{
		String[] ids= {"salt:/graph1#corpRel1", "salt:/graph1#corpRel2", "salt:/graph1#corpRel3", "salt:/graph1#corpRel4"};
		List<SCorpusRelation> corpRelDSs= new ArrayList<SCorpusRelation>();
		for (String id: ids)
		{
			SCorpusRelation corpRelDs= SaltFactory.createSCorpusRelation();
			corpRelDs.setId(id);
			getFixture().addRelation(corpRelDs);
			corpRelDSs.add(corpRelDs);
		}	
		
		assertTrue(corpRelDSs.containsAll(getFixture().getCorpusRelations()));
		assertTrue(getFixture().getCorpusRelations().containsAll(corpRelDSs));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getCorpusDocumentRelations() <em>SCorpus Document Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getCorpusDocumentRelations()
	 */
	@Test
	public void testgetCorpusDocumentRelations() 
	{
		String[] ids= {"salt:/graph1#corpRel1", "salt:/graph1#corpRel2", "salt:/graph1#corpRel3", "salt:/graph1#corpRel4"};
		List<SCorpusDocumentRelation> corpRelDSs= new ArrayList<SCorpusDocumentRelation>();
		for (String id: ids)
		{
			SCorpusDocumentRelation corpRelDs= SaltFactory.createSCorpusDocumentRelation();
			corpRelDs.setId(id);
			getFixture().addRelation(corpRelDs);
			corpRelDSs.add(corpRelDs);
		}	
		
		assertTrue(corpRelDSs.containsAll(getFixture().getCorpusDocumentRelations()));
		assertTrue(getFixture().getCorpusDocumentRelations().containsAll(corpRelDSs));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hub.corpling.salt.saltCore.SElementId) <em>Get SCorpus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hub.corpling.salt.saltCore.SElementId)
	 */
	@Test
	public void testGetSCorpus__SElementId() 
	{
		String[] ids= {"salt:/graph1#corp1", "salt:/graph1#corp2", "salt:/graph1#corp3", "salt:/graph1#corp4"};
		List<SCorpus> corpDSs= new ArrayList<SCorpus>();
		for (String id: ids)
		{
			SCorpus corpDs= SaltFactory.createSCorpus();
			corpDs.setId(id);
			getFixture().addNode(corpDs);
			corpDSs.add(corpDs);
		}	
		
		for (SCorpus corpus: corpDSs)
		{
			assertEquals(corpus, getFixture().getSCorpus(corpus.getSElementId()));
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getDocument(de.hub.corpling.salt.saltCore.SElementId) <em>Get SDocument</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getDocument(de.hub.corpling.salt.saltCore.SElementId)
	 */
	@Test
	public void testgetDocument__SElementId() 
	{
		String[] ids= {"salt:/graph1#doc1", "salt:/graph1#doc2", "salt:/graph1#doc3", "salt:/graph1#doc4"};
		List<SDocument> docDSs= new ArrayList<SDocument>();
		for (String id: ids)
		{
			SDocument docDs= SaltFactory.createSDocument();
			docDs.setId(id);
			getFixture().addNode(docDs);
			docDSs.add(docDs);
		}	
		
		for (SDocument corpus: docDSs)
		{
			assertEquals(corpus, getFixture().getDocument(corpus.getSElementId()));
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#addSubCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus) <em>Add SSub Corpus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#addSubCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus)
	 */
	@Test
	public void testAddSSubCorpus__SCorpus_SCorpus() 
	{
		SCorpus sSuperCorpus= SaltFactory.createSCorpus();
		SCorpus sSubCorpus= SaltFactory.createSCorpus();
		try {
			getFixture().addSubCorpus(sSuperCorpus, sSubCorpus);
			fail("An exception must be thrown, because the root corpus has not been inserted yet.");
		} catch (Exception e) {
		}
		
		getFixture().addNode(sSuperCorpus);
		assertNotNull(getFixture().addSubCorpus(sSuperCorpus, sSubCorpus));
		
		List<Edge> edges= ImmutablList.copyOf(getFixture().getOutRelations(sSuperCorpus.getId()));
		assertNotNull(edges);
		assertTrue(edges.size()== 1);
		assertEquals(sSubCorpus, edges.get(0).getTarget());
		
		edges= ImmutablList.copyOf(getFixture().getInRelations(sSubCorpus.getId()));
		assertNotNull(edges);
		assertTrue(edges.size()== 1);
		assertEquals(sSuperCorpus, edges.get(0).getSource());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#addSDocument(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument) <em>Add SDocument</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#addSDocument(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument)
	 */
	@Test
	public void testAddSDocument__SCorpus_SDocument() 
	{
		SCorpus sSuperCorpus= SaltFactory.createSCorpus();
		SDocument sDocument= SaltFactory.createSDocument();
		try {
			getFixture().addSDocument(sSuperCorpus, sDocument);
			fail("An exception must be thrown, because the corpus has not been inserted yet.");
		} catch (Exception e) {
		}
		
		getFixture().addNode(sSuperCorpus);
		assertNotNull(getFixture().addSDocument(sSuperCorpus, sDocument));
		
		List<Edge> edges= ImmutablList.copyOf(getFixture().getOutRelations(sSuperCorpus.getId()));
		assertNotNull(edges);
		assertTrue(edges.size()== 1);
		assertEquals(sDocument, edges.get(0).getTarget());
		
		edges= ImmutablList.copyOf(getFixture().getInRelations(sDocument.getId()));
		assertNotNull(edges);
		assertTrue(edges.size()== 1);
		assertEquals(sSuperCorpus, edges.get(0).getSource());
	}

	/**
	 * Tests the equals method, if it is correctly working with two identical empty graphs.
	 */
	@Test
	public void testEquals_Identtical_Empty()
	{
		assertTrue(getFixture().equals(getFixture()));
		assertTrue(getFixture().equals(SaltFactory.createSCorpusGraph()));
	}
	
	/**
	 * Tests the equals method, if it is correctly working with two identical non empty graphs.
	 * 
	 * 		corp1
	 * 		/	\
	 * corp2	corp3
	 */
	@Test
	public void testEquals_Identtical_NotEmpty()
	{
		SCorpus sCorp1= SaltFactory.createSCorpus();
		SCorpus sCorp2= SaltFactory.createSCorpus();
		SCorpus sCorp3= SaltFactory.createSCorpus();
		getFixture().addNode(sCorp1);
		getFixture().addSubCorpus(sCorp1, sCorp2);
		getFixture().addSubCorpus(sCorp1, sCorp3);
		
		assertEquals(getFixture(), getFixture());
		
		SCorpusGraph other= SaltFactory.createSCorpusGraph();
		SCorpus sCorp1Other= SaltFactory.createSCorpus();
		SCorpus sCorp2Other= SaltFactory.createSCorpus();
		SCorpus sCorp3Other= SaltFactory.createSCorpus();
		other.addNode(sCorp1Other);
		other.addSubCorpus(sCorp1Other, sCorp2Other);
		other.addSubCorpus(sCorp1Other, sCorp3Other);
		assertEquals(getFixture(), other);
	}
	
	/**
	 * Tests the equals method, if it is correctly working with two not identical non empty graphs.
	 * 
	 * 		corp1
	 * 		/	\
	 * corp2	corp3
	 */
	@Test
	public void testEquals_NotIdenttical()
	{
		SCorpusGraph other= SaltFactory.createSCorpusGraph();
		assertEquals(getFixture(), other);
		
		SCorpus sCorp1= SaltFactory.createSCorpus();
		SCorpus sCorp2= SaltFactory.createSCorpus();
		SCorpus sCorp3= SaltFactory.createSCorpus();
		getFixture().addNode(sCorp1);
		getFixture().addSubCorpus(sCorp1, sCorp2);
		getFixture().addSubCorpus(sCorp1, sCorp3);
		
		assertFalse(getFixture().equals(other));
		
		SCorpus sCorp1Other= SaltFactory.createSCorpus();
		SCorpus sCorp2Other= SaltFactory.createSCorpus();
		SCorpus sCorp3Other= SaltFactory.createSCorpus();
		other.addNode(sCorp1Other);
		other.addSubCorpus(sCorp1Other, sCorp2Other);
		other.addSubCorpus(sCorp1Other, sCorp3Other);
		
		assertEquals(getFixture(), other);
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument) <em>Get SCorpus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument)
	 */
	@Test
	public void testGetSCorpus__SDocument() 
	{
		getFixture().getSCorpus((SDocument)null);
		
		SCorpus sCorpus= null;
		SCorpus sSubCorpus= null;
		SDocument sDocument= null;
		
		sCorpus= SaltFactory.createSCorpus();
		getFixture().addNode(sCorpus);
		
		sDocument= SaltFactory.createSDocument();
		getFixture().addSDocument(sCorpus, sDocument);
		assertEquals(sCorpus, getFixture().getSCorpus(sDocument));
		
		sSubCorpus= SaltFactory.createSCorpus();
		getFixture().addSubCorpus(sCorpus, sSubCorpus);
		
		sDocument= SaltFactory.createSDocument();
		getFixture().addSDocument(sSubCorpus, sDocument);
		assertEquals(sSubCorpus, getFixture().getSCorpus(sDocument));
		assertFalse(sCorpus.equals(getFixture().getSCorpus(sDocument)));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSRootCorpus() <em>Get SRoot Corpus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSRootCorpus()
	 */
	@Test
	public void testGetSRootCorpus() 
	{
		SCorpus sCorp1= SaltFactory.createSCorpus();
		SCorpus sCorp2= SaltFactory.createSCorpus();
		SCorpus sCorp3= SaltFactory.createSCorpus();
		getFixture().addNode(sCorp1);
		getFixture().addSubCorpus(sCorp1, sCorp2);
		getFixture().addSubCorpus(sCorp1, sCorp3);
		
		assertTrue(getFixture().getSRootCorpus().contains(sCorp1));
		assertEquals(1, getFixture().getSRootCorpus().size());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#load(org.eclipse.emf.common.util.URI) <em>Load</em>}' operation.
	 * Tests the loading of a {@link SCorpusGraph} object contained in a {@link SaltProject} object persist in a
	 * SaltXML file. The used corpus structure is created via {@link SampleGenerator#createCorpusStructure()}
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#load(org.eclipse.emf.common.util.URI)
	 */
	@Test
	public void testLoad__URI() 
	{
		SCorpusGraph template = SampleGenerator.createCorpusStructure();
		for (SDocument sDocument: template.getDocuments())
		{
			SampleGenerator.createSDocumentStructure(sDocument);
		}
		SaltProject saltProject= SaltFactory.createSaltProject();
		saltProject.getCorpusGraphs().add(template);
		String tmpDir = System.getProperty("java.io.tmpdir")+"/"+ this.getClass().getName();
		File tmpFile= new File(tmpDir);
		URI tmpUri= URI.createFileURI(tmpFile.getAbsolutePath());
		saltProject.saveSaltProject(tmpUri);
		assertTrue("Cannot run test, because file does not exist: "+ tmpFile.getAbsolutePath(), tmpFile.exists());
		getFixture().load(tmpUri);
		assertNotNull(getFixture());
		assertEquals("differences: "+ template.differences(getFixture()), template, getFixture());
	}

	/**
	 * Tests the creation of a {@link SCorpus} object via a super corpus.  
	 */
	@Test
	public void testCreateSCorpus__SCorpus_String() {
		SCorpus sCorpus= SaltFactory.createSCorpus();
		getFixture().addNode(sCorpus);
		SCorpus sCorp2= getFixture().createSCorpus(sCorpus, "corp2");
		
		assertNotNull(getFixture().getSNode(sCorp2.getId()));
		assertEquals(2, getFixture().getNodes().size());
		assertEquals(1, getFixture().getRelations().size());
	}

	/**
	 * Tests the creation of a {@link SDocument} object via a super corpus.  
	 */
	@Test
	public void testCreateSDocument__SCorpus_String() {
		SCorpus sCorpus= SaltFactory.createSCorpus();
		getFixture().addNode(sCorpus);
		SDocument sDoc= getFixture().createSDocument(sCorpus, "doc1");
		
		assertNotNull(getFixture().getSNode(sDoc.getId()));
		assertEquals(2, getFixture().getNodes().size());
		assertEquals(1, getFixture().getRelations().size());
	}

	/**
	 * Tests the creation of {@link SCorpus} objects via a URI. 
	 * The URI is c1/c2/c3 and c1/c2/c4
	 */
	@Test
	public void testCreateSCorpus__URI() {
		URI path= URI.createURI("salt:/c1/c2/c3");
		List<SCorpus> corpora= getFixture().createSCorpus(path);
		
		assertNotNull(corpora);
		assertEquals(3, corpora.size());
		assertEquals(3, getFixture().getNodes().size());
		assertEquals(2, getFixture().getRelations().size());
		
		path= URI.createURI("salt:/c1/c2/c4");
		corpora= getFixture().createSCorpus(path);
		assertNotNull(corpora);
		assertEquals(1, corpora.size());
		assertEquals(4, getFixture().getNodes().size());
		assertEquals(3, getFixture().getRelations().size());
	}

	/**
	 * Tests the creation of {@link SCorpus} objects via a URI. 
	 * The URI is c1/c2/d1 and c1/c2/d2
	 */
	@Test
	public void testCreateSDocument__URI() {
		URI path= URI.createURI("salt:/c1/c2/c3");
		SDocument sDoc= getFixture().createSDocument(path);
		
		assertNotNull(sDoc);
		assertEquals(3, getFixture().getNodes().size());
		assertEquals(2, getFixture().getRelations().size());
		
		path= URI.createURI("salt:/c1/c2/c4");
		sDoc= getFixture().createSDocument(path);
		assertNotNull(sDoc);
		assertEquals(4, getFixture().getNodes().size());
		assertEquals(3, getFixture().getRelations().size());
	}

	@Test
	public void testCheckElementId()
	{
		SCorpus sCorpus = SaltFactory.createSCorpus();
		getFixture().addNode(sCorpus);
		assertEquals("salt:/corp1", sCorpus.getId());
		
		SDocument sDocument = SaltFactory.createSDocument();
		getFixture().addNode(sDocument);
		assertEquals("salt:/doc1", sDocument.getId());
		
		//TODO check, for corpora and documents with relations salt:/corp1/corp2 ...
	}
	
	@Test
	public void testGraphTraversion()
	{
		this.traversedNodes = new ArrayList()<SNode>();
		this.createCorpusStructure(getFixture());
		getFixture()
			.traverse(getFixture().getSRootCorpus(),	
					GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "",this);
		
		assertTrue("GraphTraversionTest: First traversed object is not null, but "+this.traversedNodes.get(0)+"!", this.traversedNodes.get(0) == null); 
		assertTrue("GraphTraversionTest: Second traversed object is not the corpus, but "+this.traversedNodes.get(1)+"!",this.traversedNodes.get(1) instanceof SCorpus);
		assertTrue("GraphTraversionTest: Third traversed object is not the corpus, but "+this.traversedNodes.get(2)+"!",this.traversedNodes.get(2) instanceof SCorpus );
		assertTrue("GraphTraversionTest: Fourth traversed object is not the document, but "+this.traversedNodes.get(3)+"!",this.traversedNodes.get(3) instanceof SDocument);
	
	}
	
	/**
	 * Creates a corpus structure with one corpus and one document. It returns the created document.
	 * 		corp1
	 *		|
	 *		doc1
	 * @param corpGraph 
	 * @return
	 */
	@Test
	private SDocument createCorpusStructure(SCorpusGraph corpGraph)
	{
		{//creating corpus structure
			//corpGraph= SaltFactory.createSCorpusGraph();
			//getFixture().getSaltProject().getCorpusGraphs().add(corpGraph);
			//		corp1
			//		|
			//		doc1
			
			//corp1
			SCorpus corp1= SaltFactory.createSCorpus();
			corp1.setName("corp1");
			corp1.setId("corp1");
			GraphFactory.createIdentifier(corp1, "corp1");
			
			corpGraph.addNode(corp1);
			
			
			//doc1
			SDocument doc1= SaltFactory.createSDocument();
			GraphFactory.createIdentifier(doc1, "doc1");
			doc1.setName("doc1");
			corpGraph.addNode(doc1);
			doc1.setDocumentGraph(SaltFactory.createSDocumentGraph());
			//CorpDocRel
			SCorpusDocumentRelation corpDocRel1= SaltFactory.createSCorpusDocumentRelation();
			GraphFactory.createIdentifier(corpDocRel1, "rel1");
			corpDocRel1.setName("rel1");
			corpDocRel1.setSource(corp1);
			corpDocRel1.setTarget(doc1);
			corpGraph.addRelation(corpDocRel1);
			return(doc1);
		}
	}

	

	@Override
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType,
			String traversalId, SNode currNode, SRelation<SNode, SNode> edge, SNode fromNode,
			long order) {
		
		this.traversedNodes.add(fromNode);
		this.traversedNodes.add(currNode);
		

	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId,
			SNode currNode, SRelation edge, SNode fromNode, long order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType,
			String traversalId, SRelation edge, SNode currNode, long order) {
		// TODO Auto-generated method stub
		return true;
	}
} //SCorpusGraphTest
