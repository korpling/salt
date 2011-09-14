/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SCorpus Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments() <em>SDocuments</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora() <em>SCorpora</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations() <em>SCorpus Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations() <em>SCorpus Document Relations</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>Get SCorpus</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocument(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>Get SDocument</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#addSSubCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus) <em>Add SSub Corpus</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#addSDocument(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument) <em>Add SDocument</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument) <em>Get SCorpus</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSRootCorpus() <em>Get SRoot Corpus</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SCorpusGraphTest extends TestCase {

	/**
	 * The fixture for this SCorpus Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusGraph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SCorpusGraphTest.class);
	}

	/**
	 * Constructs a new SCorpus Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusGraphTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SCorpus Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SCorpusGraph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SCorpus Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusGraph getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SCorpusStructureFactory.eINSTANCE.createSCorpusGraph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments() <em>SDocuments</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments()
	 */
	public void testGetSDocuments() 
	{
		String[] ids= {"salt:/graph1#doc1", "salt:/graph1#doc2", "salt:/graph1#doc3", "salt:/graph1#doc4"};
		EList<SDocument> docDSs= new BasicEList<SDocument>();
		for (String id: ids)
		{
			SDocument docDs= SaltCommonFactory.eINSTANCE.createSDocument();
			docDs.setSId(id);
			this.getFixture().addSNode(docDs);
			docDSs.add(docDs);
		}	
		
		assertTrue(docDSs.containsAll(this.getFixture().getSDocuments()));
		assertTrue(this.getFixture().getSDocuments().containsAll(docDSs));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora() <em>SCorpora</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora()
	 */
	public void testGetSCorpora() 
	{
		String[] ids= {"salt:/graph1#corp1", "salt:/graph1#corp2", "salt:/graph1#corp3", "salt:/graph1#corp4"};
		EList<SCorpus> corpDSs= new BasicEList<SCorpus>();
		for (String id: ids)
		{
			SCorpus corpDs= SaltCommonFactory.eINSTANCE.createSCorpus();
			corpDs.setSId(id);
			this.getFixture().addSNode(corpDs);
			corpDSs.add(corpDs);
		}	
		
		assertTrue(corpDSs.containsAll(this.getFixture().getSCorpora()));
		assertTrue(this.getFixture().getSCorpora().containsAll(corpDSs));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations() <em>SCorpus Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations()
	 */
	public void testGetSCorpusRelations() 
	{
		String[] ids= {"salt:/graph1#corpRel1", "salt:/graph1#corpRel2", "salt:/graph1#corpRel3", "salt:/graph1#corpRel4"};
		EList<SCorpusRelation> corpRelDSs= new BasicEList<SCorpusRelation>();
		for (String id: ids)
		{
			SCorpusRelation corpRelDs= SaltCommonFactory.eINSTANCE.createSCorpusRelation();
			corpRelDs.setSId(id);
			this.getFixture().addSRelation(corpRelDs);
			corpRelDSs.add(corpRelDs);
		}	
		
		assertTrue(corpRelDSs.containsAll(this.getFixture().getSCorpusRelations()));
		assertTrue(this.getFixture().getSCorpusRelations().containsAll(corpRelDSs));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations() <em>SCorpus Document Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations()
	 */
	public void testGetSCorpusDocumentRelations() 
	{
		String[] ids= {"salt:/graph1#corpRel1", "salt:/graph1#corpRel2", "salt:/graph1#corpRel3", "salt:/graph1#corpRel4"};
		EList<SCorpusDocumentRelation> corpRelDSs= new BasicEList<SCorpusDocumentRelation>();
		for (String id: ids)
		{
			SCorpusDocumentRelation corpRelDs= SaltCommonFactory.eINSTANCE.createSCorpusDocumentRelation();
			corpRelDs.setSId(id);
			this.getFixture().addSRelation(corpRelDs);
			corpRelDSs.add(corpRelDs);
		}	
		
		assertTrue(corpRelDSs.containsAll(this.getFixture().getSCorpusDocumentRelations()));
		assertTrue(this.getFixture().getSCorpusDocumentRelations().containsAll(corpRelDSs));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hub.corpling.salt.saltCore.SElementId) <em>Get SCorpus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hub.corpling.salt.saltCore.SElementId)
	 */
	public void testGetSCorpus__SElementId() 
	{
		String[] ids= {"salt:/graph1#corp1", "salt:/graph1#corp2", "salt:/graph1#corp3", "salt:/graph1#corp4"};
		EList<SCorpus> corpDSs= new BasicEList<SCorpus>();
		for (String id: ids)
		{
			SCorpus corpDs= SaltCommonFactory.eINSTANCE.createSCorpus();
			corpDs.setSId(id);
			this.getFixture().addSNode(corpDs);
			corpDSs.add(corpDs);
		}	
		
		for (SCorpus corpus: corpDSs)
		{
			assertEquals(corpus, this.getFixture().getSCorpus(corpus.getSElementId()));
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocument(de.hub.corpling.salt.saltCore.SElementId) <em>Get SDocument</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocument(de.hub.corpling.salt.saltCore.SElementId)
	 */
	public void testGetSDocument__SElementId() 
	{
		String[] ids= {"salt:/graph1#doc1", "salt:/graph1#doc2", "salt:/graph1#doc3", "salt:/graph1#doc4"};
		EList<SDocument> docDSs= new BasicEList<SDocument>();
		for (String id: ids)
		{
			SDocument docDs= SaltCommonFactory.eINSTANCE.createSDocument();
			docDs.setSId(id);
			this.getFixture().addSNode(docDs);
			docDSs.add(docDs);
		}	
		
		for (SDocument corpus: docDSs)
		{
			assertEquals(corpus, this.getFixture().getSDocument(corpus.getSElementId()));
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#addSSubCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus) <em>Add SSub Corpus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#addSSubCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus)
	 */
	public void testAddSSubCorpus__SCorpus_SCorpus() 
	{
		SCorpus sSuperCorpus= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sSubCorpus= SaltFactory.eINSTANCE.createSCorpus();
		try {
			this.getFixture().addSSubCorpus(sSuperCorpus, sSubCorpus);
			fail("An exception must be thrown, because the root corpus has not been inserted yet.");
		} catch (Exception e) {
		}
		
		this.getFixture().addSNode(sSuperCorpus);
		assertNotNull(this.getFixture().addSSubCorpus(sSuperCorpus, sSubCorpus));
		
		EList<Edge> edges= null;
		edges= this.getFixture().getOutEdges(sSuperCorpus.getSId());
		assertNotNull(edges);
		assertTrue(edges.size()== 1);
		assertEquals(sSubCorpus, edges.get(0).getTarget());
		
		edges= this.getFixture().getInEdges(sSubCorpus.getSId());
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
	public void testAddSDocument__SCorpus_SDocument() 
	{
		SCorpus sSuperCorpus= SaltFactory.eINSTANCE.createSCorpus();
		SDocument sDocument= SaltFactory.eINSTANCE.createSDocument();
		try {
			this.getFixture().addSDocument(sSuperCorpus, sDocument);
			fail("An exception must be thrown, because the corpus has not been inserted yet.");
		} catch (Exception e) {
		}
		
		this.getFixture().addSNode(sSuperCorpus);
		assertNotNull(this.getFixture().addSDocument(sSuperCorpus, sDocument));
		
		EList<Edge> edges= null;
		edges= this.getFixture().getOutEdges(sSuperCorpus.getSId());
		assertNotNull(edges);
		assertTrue(edges.size()== 1);
		assertEquals(sDocument, edges.get(0).getTarget());
		
		edges= this.getFixture().getInEdges(sDocument.getSId());
		assertNotNull(edges);
		assertTrue(edges.size()== 1);
		assertEquals(sSuperCorpus, edges.get(0).getSource());
	}

	/**
	 * Tests the equals method, if it is correctly working with two identical empty graphs.
	 */
	public void testEquals_Identtical_Empty()
	{
		System.out.println(this.getFixture().differences(getFixture()));
		assertTrue(this.getFixture().equals(this.getFixture()));
		assertTrue(this.getFixture().equals(SaltFactory.eINSTANCE.createSCorpusGraph()));
	}
	
	/**
	 * Tests the equals method, if it is correctly working with two identical non empty graphs.
	 * 
	 * 		corp1
	 * 		/	\
	 * corp2	corp3
	 */
	public void testEquals_Identtical_NotEmpty()
	{
		SCorpus sCorp1= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sCorp2= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sCorp3= SaltFactory.eINSTANCE.createSCorpus();
		this.getFixture().addSNode(sCorp1);
		this.getFixture().addSSubCorpus(sCorp1, sCorp2);
		this.getFixture().addSSubCorpus(sCorp1, sCorp3);
		
		assertEquals(this.getFixture(), this.getFixture());
		
		SCorpusGraph other= SaltFactory.eINSTANCE.createSCorpusGraph();
		SCorpus sCorp1Other= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sCorp2Other= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sCorp3Other= SaltFactory.eINSTANCE.createSCorpus();
		other.addSNode(sCorp1Other);
		other.addSSubCorpus(sCorp1Other, sCorp2Other);
		other.addSSubCorpus(sCorp1Other, sCorp3Other);
		assertEquals(this.getFixture(), other);
	}
	
	/**
	 * Tests the equals method, if it is correctly working with two not identical non empty graphs.
	 * 
	 * 		corp1
	 * 		/	\
	 * corp2	corp3
	 */
	public void testEquals_NotIdenttical()
	{
		SCorpusGraph other= SaltFactory.eINSTANCE.createSCorpusGraph();
		assertEquals(this.getFixture(), other);
		
		SCorpus sCorp1= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sCorp2= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sCorp3= SaltFactory.eINSTANCE.createSCorpus();
		this.getFixture().addSNode(sCorp1);
		this.getFixture().addSSubCorpus(sCorp1, sCorp2);
		this.getFixture().addSSubCorpus(sCorp1, sCorp3);
		
		assertFalse(this.getFixture().equals(other));
		
		SCorpus sCorp1Other= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sCorp2Other= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sCorp3Other= SaltFactory.eINSTANCE.createSCorpus();
		other.addSNode(sCorp1Other);
		other.addSSubCorpus(sCorp1Other, sCorp2Other);
		other.addSSubCorpus(sCorp1Other, sCorp3Other);
		
		assertEquals(this.getFixture(), other);
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument) <em>Get SCorpus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument)
	 */
	public void testGetSCorpus__SDocument() 
	{
		this.getFixture().getSCorpus((SDocument)null);
		
		SCorpus sCorpus= null;
		SCorpus sSubCorpus= null;
		SDocument sDocument= null;
		
		sCorpus= SaltFactory.eINSTANCE.createSCorpus();
		this.getFixture().addSNode(sCorpus);
		
		sDocument= SaltFactory.eINSTANCE.createSDocument();
		this.getFixture().addSDocument(sCorpus, sDocument);
		assertEquals(sCorpus, this.getFixture().getSCorpus(sDocument));
		
		sSubCorpus= SaltFactory.eINSTANCE.createSCorpus();
		this.getFixture().addSSubCorpus(sCorpus, sSubCorpus);
		
		sDocument= SaltFactory.eINSTANCE.createSDocument();
		this.getFixture().addSDocument(sSubCorpus, sDocument);
		assertEquals(sSubCorpus, this.getFixture().getSCorpus(sDocument));
		assertFalse(sCorpus.equals(this.getFixture().getSCorpus(sDocument)));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSRootCorpus() <em>Get SRoot Corpus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSRootCorpus()
	 */
	public void testGetSRootCorpus() 
	{
		SCorpus sCorp1= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sCorp2= SaltFactory.eINSTANCE.createSCorpus();
		SCorpus sCorp3= SaltFactory.eINSTANCE.createSCorpus();
		this.getFixture().addSNode(sCorp1);
		this.getFixture().addSSubCorpus(sCorp1, sCorp2);
		this.getFixture().addSSubCorpus(sCorp1, sCorp3);
		
		assertTrue(this.getFixture().getSRootCorpus().contains(sCorp1));
		assertEquals(1, this.getFixture().getSRootCorpus().size());
	}

	public void testCheckElementId()
	{
		SCorpus sCorpus = SaltCommonFactory.eINSTANCE.createSCorpus();
		this.getFixture().addSNode(sCorpus);
		assertEquals("salt:/corp1", sCorpus.getSId());
		
		SDocument sDocument = SaltCommonFactory.eINSTANCE.createSDocument();
		this.getFixture().addSNode(sDocument);
		assertEquals("salt:/doc1", sDocument.getSId());
		
		//TODO check, for corpora and documents with relations salt:/corp1/corp2 ...
	}
} //SCorpusGraphTest
