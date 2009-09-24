/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.hub.corpling.salt.saltCore.SMetaAnnotatableElement;
import de.hub.corpling.salt.saltCore.SMetaAnnotation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SMeta Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement() <em>SMeta Annotatable Element</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#getSNS() <em>SNS</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#getSName() <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#getSValue() <em>SValue</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SMetaAnnotationTest extends TestCase {

	/**
	 * The fixture for this SMeta Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SMetaAnnotation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SMetaAnnotationTest.class);
	}

	/**
	 * Constructs a new SMeta Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SMetaAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SMeta Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SMetaAnnotation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SMeta Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SMetaAnnotation getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSMetaAnnotation());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#getSNS() <em>SNS</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotation#getSNS()
	 */
	public void testGetSNS() 
	{

		assertNull(this.getFixture().getSNS());
		
		String ns= "namespace";
		this.getFixture().setSNS(ns);
		assertEquals(ns, this.getFixture().getSNS());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#setSNS(java.lang.String) <em>SNS</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotation#setSNS(java.lang.String)
	 */
	public void testSetSNS() 
	{
		this.testGetSNS();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingMetaAnnotation#getSName() <em>SName</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingMetaAnnotation#getSName()
	 */
	public void testGetSName() 
	{
		assertNull(this.getFixture().getSName());
		
		String name= "name";
		this.getFixture().setSName(name);
		assertEquals(name, this.getFixture().getSName());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingMetaAnnotation#setSName(java.lang.String) <em>SName</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingMetaAnnotation#setSName(java.lang.String)
	 */
	public void testSetSName() 
	{
		this.testGetSName();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingMetaAnnotation#getSValue() <em>SValue</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingMetaAnnotation#getSValue()
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
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingMetaAnnotation#setSValue(java.lang.Object) <em>SValue</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingMetaAnnotation#setSValue(java.lang.Object)
	 */
	public void testSetSValue() 
	{
		this.testGetSValue();
	}
	

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement() <em>SMetaAnnotatable Element</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement()
	 */
	public void testGetSMetaAnnotatableElement() 
	{
		SMetaAnnotatableElement sAElement= SaltCoreFactory.eINSTANCE.createSMetaAnnotatableElement();
		this.getFixture().setSMetaAnnotatableElement(sAElement);
		assertEquals(sAElement, this.getFixture().getSMetaAnnotatableElement());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#setSMetaAnnotatableElement(de.hub.corpling.salt.saltCore.SMetaAnnotatableElement) <em>SMetaAnnotatable Element</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotation#setSMetaAnnotatableElement(de.hub.corpling.salt.saltCore.SMetaAnnotatableElement)
	 */
	public void testSetSMetaAnnotatableElement() 
	{
		this.testGetSMetaAnnotatableElement();
	}
} //SMetaAnnotationTest
