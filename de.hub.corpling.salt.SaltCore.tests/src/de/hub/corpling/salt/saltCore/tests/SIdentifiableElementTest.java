/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;

import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SIdentifiable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId() <em>SElement Id</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSId() <em>SId</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementPath() <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SIdentifiableElementTest extends TestCase {

	/**
	 * The fixture for this SIdentifiable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SIdentifiableElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SIdentifiableElementTest.class);
	}

	/**
	 * Constructs a new SIdentifiable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIdentifiableElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SIdentifiable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SIdentifiableElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SIdentifiable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SIdentifiableElement getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSIdentifiableElement());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId() <em>SElement Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId()
	 */
	public void testGetSElementId() 
	{
		SElementId sElementId= SaltCoreFactory.eINSTANCE.createSElementId();
		this.getFixture().setSElementId(sElementId);
		assertEquals(sElementId, this.getFixture().getSElementId());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#setSElementId(de.hub.corpling.salt.saltCore.SElementId) <em>SElement Id</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#setSElementId(de.hub.corpling.salt.saltCore.SElementId)
	 */
	public void testSetSElementId() 
	{
		this.testGetSElementId();
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
} //SIdentifiableElementTest
