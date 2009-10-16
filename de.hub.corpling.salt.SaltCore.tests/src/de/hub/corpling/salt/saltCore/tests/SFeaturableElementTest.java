/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.hub.corpling.salt.saltCore.SFeaturableElement;
import de.hub.corpling.salt.saltCore.SFeature;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SFeaturable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeatures() <em>SFeatures</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeaturableElement#addSFeature(de.hub.corpling.salt.saltCore.SFeature) <em>Add SFeature</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String) <em>Get SFeature</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String) <em>Get SFeature</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SFeaturableElementTest extends TestCase {

	/**
	 * The fixture for this SFeaturable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SFeaturableElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SFeaturableElementTest.class);
	}

	/**
	 * Constructs a new SFeaturable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SFeaturableElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SFeaturable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SFeaturableElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SFeaturable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SFeaturableElement getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSFeaturableElement());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature() <em>SFeature</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature()
	 */
	public void testGetSFeatures() 
	{
		EList<SFeature> sFeats= new BasicEList<SFeature>();
		for (int i= 0; i < 5; i++)
		{
			SFeature sFeature= SaltCoreFactory.eINSTANCE.createSFeature();
			sFeature.setSName("sFeature"+ i);
			sFeature.setSValue("featVal"+i);
			this.getFixture().addSFeature(sFeature);
			sFeats.add(sFeature);
		}
		assertTrue(sFeats.containsAll(this.getFixture().getSFeatures()));
		assertTrue(this.getFixture().getSFeatures().containsAll(sFeats));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeaturableElement#addSFeature(de.hub.corpling.salt.saltCore.SFeature) <em>Add SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SFeaturableElement#addSFeature(de.hub.corpling.salt.saltCore.SFeature)
	 */
	public void testAddSFeature__SFeature() 
	{
		EList<SFeature> sFeats= new BasicEList<SFeature>();
		for (int i= 0; i < 5; i++)
		{
			SFeature sFeature= SaltCoreFactory.eINSTANCE.createSFeature();
			sFeature.setSName("sFeature"+ i);
			sFeature.setSValue("featVal"+i);
			this.getFixture().addSFeature(sFeature);
			sFeats.add(sFeature);
		}
		
		for (SFeature sFeat: sFeats)
		{
			assertEquals(sFeat, this.getFixture().getSFeature(sFeat.getSName()));
		}	
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String) <em>Get SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String)
	 */
	public void testGetSFeature__String() 
	{
		this.testAddSFeature__SFeature();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String) <em>Get SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String)
	 */
	public void testGetSFeature__String_String() 
	{
		SFeature sFeature= SaltCoreFactory.eINSTANCE.createSFeature();
		sFeature.setSNS("sNS");
		sFeature.setSName("name");
		this.getFixture().addSFeature(sFeature);
		assertEquals(sFeature, this.getFixture().getSFeature(sFeature.getSNS(), sFeature.getSName()));
	}

} //SFeaturableElementTest
