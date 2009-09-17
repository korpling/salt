/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.tests;

import de.hub.corpling.salt.saltCore.SFeaturableElement;
import de.hub.corpling.salt.saltCore.SFeature;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SFeature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeature#getSName() <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeature#getSValue() <em>SValue</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeature#getSFeaturableElement() <em>SFeaturable Element</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeature#getSNS() <em>SNS</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SFeatureTest extends TestCase {

	/**
	 * The fixture for this SFeature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SFeature fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SFeatureTest.class);
	}

	/**
	 * Constructs a new SFeature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SFeatureTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SFeature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SFeature fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SFeature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SFeature getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSFeature());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeature#getSFeaturableElement() <em>SFeaturable Element</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SFeature#getSFeaturableElement()
	 */
	public void testGetSFeaturableElement() 
	{
		SFeaturableElement featElem= SaltCoreFactory.eINSTANCE.createSFeaturableElement();
		this.getFixture().setSFeaturableElement(featElem);
		assertEquals(featElem, this.getFixture().getSFeaturableElement());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeature#setSFeaturableElement(de.hub.corpling.salt.saltCore.SFeaturableElement) <em>SFeaturable Element</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SFeature#setSFeaturableElement(de.hub.corpling.salt.saltCore.SFeaturableElement)
	 */
	public void testSetSFeaturableElement() 
	{
		this.testGetSFeaturableElement();
	}
	
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeature#getSNS() <em>SNS</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SFeature#getSNS()
	 */
	public void testGetSNS() 
	{
		assertNull(this.getFixture().getSNS());
		
		String ns= "ns";
		this.getFixture().setSNS(ns);
		assertEquals(ns, this.getFixture().getSNS());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeature#setSNS(java.lang.String) <em>SNS</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SFeature#setSNS(java.lang.String)
	 */
	public void testSetSNS() 
	{
		this.testGetSNS();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName() <em>SName</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName()
	 */
	public void testGetSName() 
	{
		assertNull(this.getFixture().getSName());
		
		String name= "name";
		this.getFixture().setSName(name);
		assertEquals(name, this.getFixture().getSName());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String) <em>SName</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String)
	 */
	public void testSetSName() 
	{
		this.testGetSName();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSValue() <em>SValue</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSValue()
	 */
	public void testGetSValue() 
	{
		assertNull(this.getFixture().getSValue());
		
		String value= "value";
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValue());
		
		Object valueObj= new Object();
		this.getFixture().setSValue(valueObj);
		assertEquals(valueObj, this.getFixture().getSValue());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSValue(java.lang.Object) <em>SValue</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSValue(java.lang.Object)
	 */
	public void testSetSValue() 
	{
		this.testGetSValue();
	}

} //SFeatureTest
