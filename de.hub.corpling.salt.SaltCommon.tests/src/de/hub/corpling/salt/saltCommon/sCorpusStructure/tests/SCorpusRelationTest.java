/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SCorpus Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSuperCorpus() <em>SSuper Corpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSubCorpus() <em>SSub Corpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph() <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SCorpusRelationTest extends TestCase {

	/**
	 * The fixture for this SCorpus Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusRelation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SCorpusRelationTest.class);
	}

	/**
	 * Constructs a new SCorpus Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusRelationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SCorpus Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SCorpusRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SCorpus Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusRelation getFixture() {
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
		setFixture(SCorpusStructureFactory.eINSTANCE.createSCorpusRelation());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSuperCorpus() <em>SSuper Corpus</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSuperCorpus()
	 */
	public void testGetSSuperCorpus() 
	{
		SCorpus sCorpus= SaltCommonFactory.eINSTANCE.createSCorpus();
		this.getFixture().setSSuperCorpus(sCorpus);
		assertEquals(sCorpus, this.getFixture().getSSuperCorpus());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#setSSuperCorpus(de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus) <em>SSuper Corpus</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#setSSuperCorpus(de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus)
	 */
	public void testSetSSuperCorpus() 
	{
		this.testGetSSuperCorpus();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSubCorpus() <em>SSub Corpus</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSubCorpus()
	 */
	public void testGetSSubCorpus() 
	{
		SCorpus sCorpus= SaltCommonFactory.eINSTANCE.createSCorpus();
		this.getFixture().setSSubCorpus(sCorpus);
		assertEquals(sCorpus, this.getFixture().getSSubCorpus());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#setSSubCorpus(de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus) <em>SSub Corpus</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#setSSubCorpus(de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus)
	 */
	public void testSetSSubCorpus() 
	{
		this.testGetSSubCorpus();
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

} //SCorpusRelationTest
