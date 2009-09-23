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
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructure;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructuredNode;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SDominance Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructure() <em>SStructure</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructuredTarget() <em>SStructured Target</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph() <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation#isSTimeOverlapping() <em>Is STime Overlapping</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SDominanceRelationTest extends STextOverlappingRelationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SDominanceRelationTest.class);
	}

	/**
	 * Constructs a new SDominance Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDominanceRelationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SDominance Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SDominanceRelation getFixture() {
		return (SDominanceRelation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SDocumentStructureFactory.eINSTANCE.createSDominanceRelation());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructure() <em>SStructure</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructure()
	 */
	public void testGetSStructure() 
	{
		SStructure struct= SaltCommonFactory.eINSTANCE.createSStructure();
		this.getFixture().setSStructure(struct);
		assertEquals(struct, this.getFixture().getSStructure());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSStructure(de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructure) <em>SStructure</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSStructure(de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructure)
	 */
	public void testSetSStructure() 
	{
		this.testGetSStructure();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructuredTarget() <em>SStructured Target</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructuredTarget()
	 */
	public void testGetSStructuredTarget() 
	{
		SStructuredNode sStructTarget= null;
		
		//test for token
		sStructTarget= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().setSStructuredTarget(sStructTarget);
		assertEquals(sStructTarget, this.getFixture().getSStructuredTarget());
		
		//test for span
		sStructTarget= SaltCommonFactory.eINSTANCE.createSSpan();
		this.getFixture().setSStructuredTarget(sStructTarget);
		assertEquals(sStructTarget, this.getFixture().getSStructuredTarget());
		
		//test for structure
		sStructTarget= SaltCommonFactory.eINSTANCE.createSStructure();
		this.getFixture().setSStructuredTarget(sStructTarget);
		assertEquals(sStructTarget, this.getFixture().getSStructuredTarget());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSStructuredTarget(de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructuredNode) <em>SStructured Target</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSStructuredTarget(de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructuredNode)
	 */
	public void testSetSStructuredTarget() 
	{
		this.testGetSStructuredTarget();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph() <em>SDocument Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph()
	 */
	public void testGetSDocumentGraph() 
	{
		SDocumentGraph sSDocumentGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sSDocumentGraph);
		assertEquals(sSDocumentGraph, this.getFixture().getSDocumentGraph());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSDocumentGraph(de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph) <em>SDocument Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSDocumentGraph(de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph)
	 */
	public void testSetSDocumentGraph() 
	{
		this.testGetSDocumentGraph();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation#isSTimeOverlapping() <em>Is STime Overlapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation#isSTimeOverlapping()
	 */
	public void testIsSTimeOverlapping() 
	{
		assertTrue(this.getFixture().isSTimeOverlapping());
	}

} //SDominanceRelationTest
