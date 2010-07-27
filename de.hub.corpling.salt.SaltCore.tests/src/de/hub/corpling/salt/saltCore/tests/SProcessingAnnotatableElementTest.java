/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SProcessing Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations() <em>SProcessing Annotations</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hub.corpling.salt.saltCore.SProcessingAnnotation) <em>Add SProcessing Annotation</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String) <em>Get SProcessing Annotation</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SProcessingAnnotatableElementTest extends TestCase {

	/**
	 * The fixture for this SProcessing Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SProcessingAnnotatableElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SProcessingAnnotatableElementTest.class);
	}

	/**
	 * Constructs a new SProcessing Annotatable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SProcessingAnnotatableElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SProcessing Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SProcessingAnnotatableElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SProcessing Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SProcessingAnnotatableElement getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSProcessingAnnotatableElement());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations() <em>SProcessing Annotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations()
	 */
	public void testGetSProcessingAnnotations() 
	{
		String[] QNames= {"ns::name1", "ns::name2", "ns::name3", "ns::name4"};
		EList<SProcessingAnnotation> sProcAnnos= new BasicEList<SProcessingAnnotation>();
		for (String QName: QNames)
		{	
			SProcessingAnnotation sProcAnno1= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
			sProcAnno1.setQName(QName);
			this.getFixture().addSProcessingAnnotation(sProcAnno1);
			sProcAnnos.add(sProcAnno1);
		}
		
		assertTrue(sProcAnnos.containsAll(this.getFixture().getSProcessingAnnotations()));
		assertTrue(this.getFixture().getSProcessingAnnotations().containsAll(sProcAnnos));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hub.corpling.salt.saltCore.SProcessingAnnotation) <em>Add SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hub.corpling.salt.saltCore.SProcessingAnnotation)
	 */
	public void testAddSProcessingAnnotation__SProcessingAnnotation() 
	{
		String QName= "ns::name";
		SProcessingAnnotation sProcAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
		sProcAnno.setQName(QName);
		this.getFixture().addSProcessingAnnotation(sProcAnno);
		assertEquals(sProcAnno, this.getFixture().getSProcessingAnnotation(QName));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String) <em>Get SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String)
	 */
	public void testGetSProcessingAnnotation__String() 
	{
		this.testAddSProcessingAnnotation__SProcessingAnnotation();
	}
	
	public void testReverseGetSProcessingAnnotation()
	{
		SProcessingAnnotation procAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
		procAnno.setName("labelName");
		this.getFixture().addLabel(procAnno);
		
		assertEquals(this.getFixture(), procAnno.getLabelableElement());
	}

} //SProcessingAnnotatableElementTest
