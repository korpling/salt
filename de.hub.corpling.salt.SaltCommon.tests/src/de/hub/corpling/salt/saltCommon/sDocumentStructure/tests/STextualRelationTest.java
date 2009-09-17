/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests;

import junit.textui.TestRunner;
import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>STextual Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken() <em>SToken</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS() <em>STextual DS</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph() <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class STextualRelationTest extends SSequentialRelationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(STextualRelationTest.class);
	}

	/**
	 * Constructs a new STextual Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextualRelationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this STextual Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected STextualRelation getFixture() {
		return (STextualRelation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SDocumentStructureFactory.eINSTANCE.createSTextualRelation());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken() <em>SToken</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken()
	 */
	public void testGetSToken() 
	{
		SToken sToken= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().setSToken(sToken);
		assertEquals(sToken, this.getFixture().getSToken());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#setSToken(de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken) <em>SToken</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#setSToken(de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken)
	 */
	public void testSetSToken() 
	{
		this.testGetSToken();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS() <em>STextual DS</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS()
	 */
	public void testGetSTextualDS() 
	{
		STextualDS sSTextualDS= SaltCommonFactory.eINSTANCE.createSTextualDS();
		this.getFixture().setSTextualDS(sSTextualDS);
		assertEquals(sSTextualDS, this.getFixture().getSTextualDS());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#setSTextualDS(de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS) <em>STextual DS</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#setSTextualDS(de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS)
	 */
	public void testSetSTextualDS() 
	{
		this.testGetSTextualDS();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph() <em>SDocument Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph()
	 */
	public void testGetSDocumentGraph() 
	{
		SDocumentGraph sSDocumentGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sSDocumentGraph);
		assertEquals(sSDocumentGraph, this.getFixture().getSDocumentGraph());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#setSDocumentGraph(de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph) <em>SDocument Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#setSDocumentGraph(de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph)
	 */
	public void testSetSDocumentGraph() 
	{
		this.testGetSDocumentGraph();
	}

} //STextualRelationTest
