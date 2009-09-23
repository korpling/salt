/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.tests;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SCorpus Document Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus() <em>SCorpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument() <em>SDocument</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph() <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SCorpusDocumentRelationTest extends TestCase {

	/**
	 * The fixture for this SCorpus Document Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusDocumentRelation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SCorpusDocumentRelationTest.class);
	}

	/**
	 * Constructs a new SCorpus Document Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusDocumentRelationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SCorpus Document Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SCorpusDocumentRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SCorpus Document Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusDocumentRelation getFixture() {
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
		setFixture(SCorpusStructureFactory.eINSTANCE.createSCorpusDocumentRelation());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus() <em>SCorpus</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus()
	 */
	public void testGetSCorpus() 
	{
		SCorpus sCorpus= SaltCommonFactory.eINSTANCE.createSCorpus();
		this.getFixture().setSCorpus(sCorpus);
		assertEquals(sCorpus, this.getFixture().getSCorpus());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#setSCorpus(de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus) <em>SCorpus</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#setSCorpus(de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus)
	 */
	public void testSetSCorpus() 
	{
		this.testGetSCorpus();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument() <em>SDocument</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument()
	 */
	public void testGetSDocument() 
	{
		SDocument sDoc= SaltCommonFactory.eINSTANCE.createSDocument();
		this.getFixture().setSDocument(sDoc);
		assertEquals(sDoc, this.getFixture().getSDocument());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#setSDocument(de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument) <em>SDocument</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#setSDocument(de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument)
	 */
	public void testSetSDocument() 
	{
		this.testGetSDocument();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph() <em>SCorpus Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph()
	 */
	public void testGetSCorpusGraph() 
	{
		SCorpusGraph sSCorpusGraph= SaltCommonFactory.eINSTANCE.createSCorpusGraph();
		this.getFixture().setSCorpusGraph(sSCorpusGraph);
		assertEquals(sSCorpusGraph, this.getFixture().getSCorpusGraph());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#setSCorpusGraph(de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph) <em>SCorpus Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#setSCorpusGraph(de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph)
	 */
	public void testSetSCorpusGraph() 
	{
		this.testGetSCorpusGraph();
	}

} //SCorpusDocumentRelationTest
