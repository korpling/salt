/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltSemantics.tests;

import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;
import de.hub.corpling.salt.saltSemantics.SALT_SEMANTIC_NAMES;
import de.hub.corpling.salt.saltSemantics.SPOSAnnotation;
import de.hub.corpling.salt.saltSemantics.SaltSemanticsFactory;
import de.hub.corpling.salt.saltSemantics.SaltSemanticsPackage;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SPOS Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltSemantics.SPOSAnnotation#isSPOSAnnotation(de.hub.corpling.salt.saltCore.SAnnotation) <em>Is SPOS Annotation</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SPOSAnnotationTest extends TestCase {

	/**
	 * The fixture for this SPOS Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SPOSAnnotation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SPOSAnnotationTest.class);
	}

	/**
	 * Constructs a new SPOS Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPOSAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SPOS Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SPOSAnnotation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SPOS Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SPOSAnnotation getFixture() {
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
		setFixture(SaltSemanticsFactory.eINSTANCE.createSPOSAnnotation());
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
	 * Tests the '{@link de.hub.corpling.salt.saltSemantics.SPOSAnnotation#isSPOSAnnotation(de.hub.corpling.salt.saltCore.SAnnotation) <em>Is SPOS Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltSemantics.SPOSAnnotation#isSPOSAnnotation(de.hub.corpling.salt.saltCore.SAnnotation)
	 */
	public void testIsSPOSAnnotation__SAnnotation() 
	{
		SAnnotation sAnno= null;
		
		sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
		sAnno.setSNS(SaltSemanticsPackage.eNS_PREFIX);
		sAnno.setSName(SALT_SEMANTIC_NAMES.POS.toString());
		sAnno.setSValue("");
		assertTrue("This shall be identified as POSAnnotation.", this.getFixture().isSPOSAnnotation(sAnno));
		
		sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
		sAnno.setSNS("any");
		sAnno.setSName(SALT_SEMANTIC_NAMES.POS.toString());
		sAnno.setSValue("");
		assertFalse("This isn´t a PosAnnotation, because of ns.", this.getFixture().isSPOSAnnotation(sAnno));
		
		sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
		sAnno.setSNS(SaltSemanticsPackage.eNS_PREFIX);
		sAnno.setSName("any");
		sAnno.setSValue("");
		assertFalse("This isn´t a PosAnnotation, because of name.", this.getFixture().isSPOSAnnotation(sAnno));
	}
		
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName() <em>SName</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName()
	 */
	public void testGetSName() 
	{
		assertNotNull(this.getFixture().getSName());
		assertEquals(SALT_SEMANTIC_NAMES.POS.toString(), this.getFixture().getSName());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String) <em>SName</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String)
	 */
	public void testSetSName() 
	{
		try {
			this.getFixture().setSName("");
			fail("Shall not reset annotation-name.");
		} catch (Exception e) 
		{}
	}
	
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName() <em>SName</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName()
	 */
	public void testGetSNS() 
	{
		assertNotNull(this.getFixture().getSName());
		assertEquals(SaltSemanticsPackage.eNS_PREFIX, this.getFixture().getSNS());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String) <em>SName</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String)
	 */
	public void testSetSNS() 
	{
		try {
			this.getFixture().setSNS("");
			fail("Shall not reset annotation-ns.");
		} catch (Exception e) 
		{}
	}
} //SPOSAnnotationTest
