/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.tests;

import org.eclipse.emf.common.util.URI;

import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SElement Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SElementId#getSIdentifiableElement() <em>SIdentifiable Element</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SElementId#getSId() <em>SId</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SElementId#getSElementPath() <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SElementIdTest extends TestCase {

	/**
	 * The fixture for this SElement Id test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SElementId fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SElementIdTest.class);
	}

	/**
	 * Constructs a new SElement Id test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SElementIdTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SElement Id test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SElementId fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SElement Id test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SElementId getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSElementId());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SElementId#getSIdentifiableElement() <em>SIdentifiable Element</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SElementId#getSIdentifiableElement()
	 */
	public void testGetSIdentifiableElement() 
	{
		SIdentifiableElement identElem= SaltCoreFactory.eINSTANCE.createSIdentifiableElement();
		this.getFixture().setSIdentifiableElement(identElem);
		assertEquals(identElem, this.getFixture().getSIdentifiableElement());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SElementId#setSIdentifiableElement(de.hub.corpling.salt.saltCore.SIdentifiableElement) <em>SIdentifiable Element</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SElementId#setSIdentifiableElement(de.hub.corpling.salt.saltCore.SIdentifiableElement)
	 */
	public void testSetSIdentifiableElement() 
	{
		this.testGetSElementPath();
	}
	
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSId() <em>SId</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#getSId()
	 */
	public void testGetSId() 
	{
		String id= "id1";
		this.getFixture().setSId(id);
		assertEquals(id, this.getFixture().getSId());
		assertEquals(id, this.getFixture().getId());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#setSId(java.lang.String) <em>SId</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#setSId(java.lang.String)
	 */
	public void testSetSId() 
	{
		this.testGetSId();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementPath() <em>SElement Path</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementPath()
	 */
	public void testGetSElementPath() 
	{
		URI elementPath= URI.createURI("salt:/element1");
		this.getFixture().setSElementPath(elementPath);
		assertEquals(elementPath, this.getFixture().getSElementPath());
		assertEquals(elementPath.toString(), this.getFixture().getSId());
		assertEquals(elementPath.toString(), this.getFixture().getId());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#setSElementPath(org.eclipse.emf.common.util.URI) <em>SElement Path</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#setSElementPath(org.eclipse.emf.common.util.URI)
	 */
	public void testSetSElementPath() 
	{
		this.testGetSElementPath();
	}

} //SElementIdTest
