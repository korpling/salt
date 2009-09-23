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
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>STimeline Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSTimeline() <em>STimeline</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSToken() <em>SToken</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph() <em>SDocument Graph</em>}</li>
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
public class STimelineRelationTest extends SSequentialRelationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(STimelineRelationTest.class);
	}

	/**
	 * Constructs a new STimeline Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STimelineRelationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this STimeline Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected STimelineRelation getFixture() {
		return (STimelineRelation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SDocumentStructureFactory.eINSTANCE.createSTimelineRelation());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart() <em>SStart</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart()
	 */
	public void testGetSStart() 
	{
		Integer start= 1;
		this.getFixture().setSStart(start);
		assertEquals(start, this.getFixture().getSStart());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#setSStart(java.lang.Integer) <em>SStart</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#setSStart(java.lang.Integer)
	 */
	public void testSetSStart() 
	{
		this.testGetSStart();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd() <em>SEnd</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd()
	 */
	public void testGetSEnd() 
	{
		Integer end= 1;
		this.getFixture().setSStart(end);
		assertEquals(end, this.getFixture().getSStart());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#setSEnd(java.lang.Integer) <em>SEnd</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#setSEnd(java.lang.Integer)
	 */
	public void testSetSEnd() 
	{
		this.testGetSEnd();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSTimeline() <em>STimeline</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSTimeline()
	 */
	public void testGetSTimeline() 
	{
		STimeline timeline= SaltCommonFactory.eINSTANCE.createSTimeline();
		this.getFixture().setSTimeline(timeline);
		assertEquals(timeline, this.getFixture().getSTimeline());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#setSTimeline(de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline) <em>STimeline</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#setSTimeline(de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline)
	 */
	public void testSetSTimeline() 
	{
		this.testGetSTimeline();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSToken() <em>SToken</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSToken()
	 */
	public void testGetSToken() 
	{
		SToken tok= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().setSToken(tok);
		assertEquals(tok, this.getFixture().getSToken());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#setSToken(de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken) <em>SToken</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#setSToken(de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken)
	 */
	public void testSetSToken() 
	{
		this.testGetSToken();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph() <em>SDocument Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph()
	 */
	public void testGetSDocumentGraph() 
	{
		SDocumentGraph docGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(docGraph);
		assertEquals(docGraph, this.getFixture().getSDocumentGraph());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#setSDocumentGraph(de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph) <em>SDocument Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#setSDocumentGraph(de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph)
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

} //STimelineRelationTest
