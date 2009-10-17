/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SCorpus Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments() <em>SDocuments</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora() <em>SCorpora</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations() <em>SCorpus Relations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations() <em>SCorpus Document Relations</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hub.corpling.salt.saltCore.SElementId) <em>Get SCorpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocument(de.hub.corpling.salt.saltCore.SElementId) <em>Get SDocument</em>}</li>
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments() <em>SDocuments</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments()
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora() <em>SCorpora</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora()
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations() <em>SCorpus Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations()
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations() <em>SCorpus Document Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations()
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hub.corpling.salt.saltCore.SElementId) <em>Get SCorpus</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpus(de.hub.corpling.salt.saltCore.SElementId)
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocument(de.hub.corpling.salt.saltCore.SElementId) <em>Get SDocument</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocument(de.hub.corpling.salt.saltCore.SElementId)
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
