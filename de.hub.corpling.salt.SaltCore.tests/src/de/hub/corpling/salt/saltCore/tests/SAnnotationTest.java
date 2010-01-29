/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.tests;

import junit.textui.TestRunner;
import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SAnnotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatableElement() <em>SAnnotatable Element</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SAnnotationTest extends SAbstractAnnotationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SAnnotationTest.class);
	}

	/**
	 * Constructs a new SAnnotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SAnnotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SAnnotation getFixture() {
		return (SAnnotation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SaltCoreFactory.eINSTANCE.createSAnnotation());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatableElement() <em>SAnnotatable Element</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatableElement()
	 */
	public void testGetSAnnotatableElement() 
	{
		SAnnotatableElement sAElement= SaltCoreFactory.eINSTANCE.createSAnnotatableElement();
		this.getFixture().setSAnnotatableElement(sAElement);
		assertEquals(sAElement, this.getFixture().getSAnnotatableElement());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SAnnotation#setSAnnotatableElement(de.hub.corpling.salt.saltCore.SAnnotatableElement) <em>SAnnotatable Element</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SAnnotation#setSAnnotatableElement(de.hub.corpling.salt.saltCore.SAnnotatableElement)
	 */
	public void testSetSAnnotatableElement() 
	{
		this.testGetSAnnotatableElement();
	}

} //SAnnotationTest
