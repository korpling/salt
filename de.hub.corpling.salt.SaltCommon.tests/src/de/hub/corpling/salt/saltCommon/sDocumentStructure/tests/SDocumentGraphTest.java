/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs() <em>STextual DSs</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations() <em>STextual Relations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens() <em>STokens</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline() <em>STimeline</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SDocumentGraphTest extends TestCase {

	/**
	 * The fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocumentGraph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SDocumentGraphTest.class);
	}

	/**
	 * Constructs a new SDocument Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraphTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SDocumentGraph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocumentGraph getFixture() {
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
		setFixture(SDocumentStructureFactory.eINSTANCE.createSDocumentGraph());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs() <em>STextual DSs</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs()
	 */
	public void testGetSTextualDSs() 
	{
		String[] ids= {"salt:/graph1#text1", "salt:/graph1#text2", "salt:/graph1#text3", "salt:/graph1#text4"};
		EList<STextualDS> textDSs= new BasicEList<STextualDS>();
		for (String id: ids)
		{
			STextualDS textDs= SaltCommonFactory.eINSTANCE.createSTextualDS();
			textDs.setSId(id);
			this.getFixture().addSNode(textDs);
			textDSs.add(textDs);
		}	
		
		assertTrue(textDSs.containsAll(this.getFixture().getSTextualDSs()));
		assertTrue(this.getFixture().getSTextualDSs().containsAll(textDSs));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations() <em>STextual Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations()
	 */
	public void testGetSTextualRelations() 
	{
		String[] ids= {"salt:/graph1#textRel1", "salt:/graph1#textRel2", "salt:/graph1#textRel3", "salt:/graph1#textRel4"};
		EList<STextualRelation> textRels= new BasicEList<STextualRelation>();
		for (String id: ids)
		{
			STextualRelation textRel= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel.setSId(id);
			this.getFixture().addSRelation(textRel);
			textRels.add(textRel);
		}	
		
		assertTrue(textRels.containsAll(this.getFixture().getSTextualRelations()));
		assertTrue(this.getFixture().getSTextualRelations().containsAll(textRels));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens() <em>STokens</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens()
	 */
	public void testGetSTokens() 
	{
		String[] ids= {"salt:/graph1#tok1", "salt:/graph1#tok2", "salt:/graph1#tok3", "salt:/graph1#tok4"};
		EList<SToken> toks= new BasicEList<SToken>();
		for (String id: ids)
		{
			SToken tok= SaltCommonFactory.eINSTANCE.createSToken();
			tok.setSId(id);
			this.getFixture().addSNode(tok);
			toks.add(tok);
		}	
		
		assertTrue(toks.containsAll(this.getFixture().getSTokens()));
		assertTrue(this.getFixture().getSTokens().containsAll(toks));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline() <em>STimeline</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline()
	 */
	public void testGetSTimeline() 
	{
		STimeline sTimeline= SaltCommonFactory.eINSTANCE.createSTimeline();
		EList<Double> timeline= new BasicEList<Double>();
		timeline.add(1.0);
		timeline.add(1.1);
		timeline.add(1.2);
		timeline.add(1.3);
		timeline.add(1.4);
		for (Double point: timeline)
			sTimeline.addSPointOfTime(point);
		this.getFixture().setSTimeline(sTimeline);
		assertNotNull(this.getFixture().getSTimeline());
		assertNotNull(this.getFixture().getSTimeline().getSPointsOfTime());
		for (Double point1: timeline)
		{
			boolean hasOpponend= false;
			for (Double point2: this.getFixture().getSTimeline().getSPointsOfTime())
			{
				if (point1.equals(point2))
					hasOpponend= true;
			}
			assertTrue(hasOpponend);
		}
		assertTrue(timeline.containsAll(this.getFixture().getSTimeline().getSPointsOfTime()));
		assertTrue(this.getFixture().getSTimeline().getSPointsOfTime().containsAll(timeline));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#setSTimeline(de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline) <em>STimeline</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#setSTimeline(de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline)
	 */
	public void testSetSTimeline() 
	{
		this.testGetSTimeline();
	}

} //SDocumentGraphTest
