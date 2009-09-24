/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hub.corpling.salt.saltCore.SMetaAnnotatableElement;
import de.hub.corpling.salt.saltCore.SMetaAnnotation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SMeta Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations() <em>SMeta Annotations</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hub.corpling.salt.saltCore.SMetaAnnotation) <em>Add SMeta Annotation</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String) <em>Get SMeta Annotation</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SMetaAnnotatableElementTest extends TestCase {

	/**
	 * The fixture for this SMeta Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SMetaAnnotatableElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SMetaAnnotatableElementTest.class);
	}

	/**
	 * Constructs a new SMeta Annotatable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SMetaAnnotatableElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SMeta Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SMetaAnnotatableElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SMeta Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SMetaAnnotatableElement getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSMetaAnnotatableElement());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations() <em>SProcessing MetaAnnotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations()
	 */
	public void testGetSMetaAnnotations() 
	{
		String[] fullNames= {"ns::name1", "ns::name2", "ns::name3", "ns::name4"};
		EList<SMetaAnnotation> sProcMetaAnnos= new BasicEList<SMetaAnnotation>();
		for (String fullName: fullNames)
		{	
			SMetaAnnotation sProcMetaAnno1= SaltCoreFactory.eINSTANCE.createSMetaAnnotation();
			sProcMetaAnno1.setFullName(fullName);
			this.getFixture().addSMetaAnnotation(sProcMetaAnno1);
			sProcMetaAnnos.add(sProcMetaAnno1);
		}
		
		assertTrue(sProcMetaAnnos.containsAll(this.getFixture().getSMetaAnnotations()));
		assertTrue(this.getFixture().getSMetaAnnotations().containsAll(sProcMetaAnnos));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hub.corpling.salt.saltCore.SMetaAnnotation) <em>Add SProcessing MetaAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hub.corpling.salt.saltCore.SMetaAnnotation)
	 */
	public void testAddSMetaAnnotation__SMetaAnnotation() 
	{
		String fullName= "ns::name";
		SMetaAnnotation sProcMetaAnno= SaltCoreFactory.eINSTANCE.createSMetaAnnotation();
		sProcMetaAnno.setFullName(fullName);
		this.getFixture().addSMetaAnnotation(sProcMetaAnno);
		assertEquals(sProcMetaAnno, this.getFixture().getSMetaAnnotation(fullName));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String) <em>Get SProcessing MetaAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String)
	 */
	public void testGetSMetaAnnotation__String() 
	{
		this.testAddSMetaAnnotation__SMetaAnnotation();
	}
	
	public void testReverseGetSMetaAnnotation()
	{
		SMetaAnnotation procMetaAnno= SaltCoreFactory.eINSTANCE.createSMetaAnnotation();
		procMetaAnno.setSName("labelName");
		this.getFixture().addLabel(procMetaAnno);
		
		assertEquals(this.getFixture(), procMetaAnno.getLabelableElement());
	}

} //SMetaAnnotatableElementTest
