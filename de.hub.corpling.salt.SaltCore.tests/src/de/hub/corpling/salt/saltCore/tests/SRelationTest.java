/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SFeature;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SRelation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations() <em>SAnnotations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId() <em>SElement Id</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSId() <em>SId</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementPath() <em>SElement Path</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations() <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeatures() <em>SFeatures</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations() <em>SMeta Annotations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SRelation#getSSource() <em>SSource</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SRelation#getSTarget() <em>STarget</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SRelation#getSGraph() <em>SGraph</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hub.corpling.salt.saltCore.SMetaAnnotation) <em>Add SMeta Annotation</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String) <em>Get SMeta Annotation</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeaturableElement#addSFeature(de.hub.corpling.salt.saltCore.SFeature) <em>Add SFeature</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String) <em>Get SFeature</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String) <em>Get SFeature</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hub.corpling.salt.saltCore.SProcessingAnnotation) <em>Add SProcessing Annotation</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String) <em>Get SProcessing Annotation</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#addSAnnotation(de.hub.corpling.salt.saltCore.SAnnotation) <em>Add SAnnotation</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotation(java.lang.String) <em>Get SAnnotation</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SRelationTest extends TestCase {

	/**
	 * The fixture for this SRelation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SRelation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SRelationTest.class);
	}

	/**
	 * Constructs a new SRelation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SRelationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SRelation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SRelation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SRelation getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSRelation());
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

	
// ========================= start: testing SIdentifiableElement
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId() <em>SElement Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId()
	 */
	public void testGetSElementId() throws Exception 
	{
		SIdentifiableElementTest identTest= new SIdentifiableElementTest(this.getName());
		identTest.setUp();
		identTest.setFixture(this.getFixture());
		identTest.testGetSElementId();
		identTest.tearDown();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#setSElementId(de.hub.corpling.salt.saltCore.SElementId) <em>SElement Id</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#setSElementId(de.hub.corpling.salt.saltCore.SElementId)
	 */
	public void testSetSElementId() throws Exception 
	{
		SIdentifiableElementTest identTest= new SIdentifiableElementTest(this.getName());
		identTest.setUp();
		identTest.setFixture(this.getFixture());
		identTest.testSetSElementId();
		identTest.tearDown();
	}
	
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSId() <em>SId</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
		 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#getSId()
	 */
	public void testGetSId() throws Exception 
	{
		SIdentifiableElementTest identTest= new SIdentifiableElementTest(this.getName());
		identTest.setUp();
		identTest.setFixture(this.getFixture());
		identTest.testGetSId();
		identTest.tearDown();
	}
	
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#setSId(java.lang.String) <em>SId</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#setSId(java.lang.String)
	 */
	public void testSetSId() throws Exception 
	{
		SIdentifiableElementTest identTest= new SIdentifiableElementTest(this.getName());
		identTest.setUp();
		identTest.setFixture(this.getFixture());
		identTest.testSetSId();
		identTest.tearDown();
	}
	
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementPath() <em>SElement Path</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementPath()
	 */
	public void testGetSElementPath() throws Exception 
	{
		SIdentifiableElementTest identTest= new SIdentifiableElementTest(this.getName());
		identTest.setUp();
		identTest.setFixture(this.getFixture());
		identTest.testGetSElementPath();
		identTest.tearDown();
	}
	
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#setSElementPath(org.eclipse.emf.common.util.URI) <em>SElement Path</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#setSElementPath(org.eclipse.emf.common.util.URI)
	 */
	public void testSetSElementPath() throws Exception 
	{
		SIdentifiableElementTest identTest= new SIdentifiableElementTest(this.getName());
		identTest.setUp();
		identTest.setFixture(this.getFixture());
		identTest.testSetSElementPath();
		identTest.tearDown();
	}
//========================= end: testing SIdentifiableElement


	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SRelation#getSSource() <em>SSource</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SRelation#getSSource()
	 */
	public void testGetSSource() 
	{
		SNode sNode= SaltCoreFactory.eINSTANCE.createSNode();
		this.getFixture().setSSource(sNode);
		assertEquals(sNode, this.getFixture().getSSource());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SRelation#setSSource(de.hub.corpling.salt.saltCore.SNode) <em>SSource</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SRelation#setSSource(de.hub.corpling.salt.saltCore.SNode)
	 */
	public void testSetSSource() 
	{
		this.testGetSSource();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SRelation#getSTarget() <em>STarget</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SRelation#getSTarget()
	 */
	public void testGetSTarget() 
	{
		SNode sNode= SaltCoreFactory.eINSTANCE.createSNode();
		this.getFixture().setSTarget(sNode);
		assertEquals(sNode, this.getFixture().getSTarget());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SRelation#setSTarget(de.hub.corpling.salt.saltCore.SNode) <em>STarget</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SRelation#setSTarget(de.hub.corpling.salt.saltCore.SNode)
	 */
	public void testSetSTarget() 
	{
		this.testGetSTarget();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SRelation#getSGraph() <em>SGraph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SRelation#getSGraph()
	 */
	public void testGetSGraph() 
	{
		SGraph sGraph= SaltCoreFactory.eINSTANCE.createSGraph();
		this.getFixture().setSGraph(sGraph);
		assertEquals(sGraph, sGraph);
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SRelation#setSGraph(de.hub.corpling.salt.saltCore.SGraph) <em>SGraph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SRelation#setSGraph(de.hub.corpling.salt.saltCore.SGraph)
	 */
	public void testSetSGraph() 
	{
		this.testGetSGraph();
	}

// ========================= start: testing SMetaAnnotatableElement
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations() <em>SMetaAnnotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations()
	 */
	public void testGetSMetaAnnotations() throws Exception 
	{
		SMetaAnnotatableElementTest sPATest= new SMetaAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testGetSMetaAnnotations();
		sPATest.tearDown();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hub.corpling.salt.saltCore.SMetaAnnotation) <em>Add SMetaAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hub.corpling.salt.saltCore.SMetaAnnotation)
	 */
	public void testAddSMetaAnnotation__SMetaAnnotation() throws Exception 
	{
		SMetaAnnotatableElementTest sPATest= new SMetaAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testAddSMetaAnnotation__SMetaAnnotation();
		sPATest.tearDown();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String) <em>Get SMetaAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String)
	 */
	public void testGetSMetaAnnotation__String() throws Exception 
	{
		SMetaAnnotatableElementTest sPATest= new SMetaAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testGetSMetaAnnotation__String();
		sPATest.tearDown();
	}
// ========================= end: testing SMetaAnnotatableElement	

// ========================= start: testing SAnnotatableElement
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations() <em>SAnnotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations()
	 */
	public void testGetSAnnotations() throws Exception 
	{
		SAnnotatableElementTest sPATest= new SAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testGetSAnnotations();
		sPATest.tearDown();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#addSAnnotation(de.hub.corpling.salt.saltCore.SAnnotation) <em>Add SAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SAnnotatableElement#addSAnnotation(de.hub.corpling.salt.saltCore.SAnnotation)
	 */
	public void testAddSAnnotation__SAnnotation() throws Exception 
	{
		SAnnotatableElementTest sPATest= new SAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testAddSAnnotation__SAnnotation();
		sPATest.tearDown();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotation(java.lang.String) <em>Get SAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotation(java.lang.String)
	 */
	public void testGetSAnnotation__String() throws Exception 
	{
		SAnnotatableElementTest sPATest= new SAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testGetSAnnotation__String();
		sPATest.tearDown();
	}
// ========================= end: testing SAnnotatableElement	
// ========================= start: testing SProcessingAnnotatableElement
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations() <em>SProcessing Annotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations()
	 */
	public void testGetSProcessingAnnotations() throws Exception 
	{
		SProcessingAnnotatableElementTest sPATest= new SProcessingAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testGetSProcessingAnnotations();
		sPATest.tearDown();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hub.corpling.salt.saltCore.SProcessingAnnotation) <em>Add SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hub.corpling.salt.saltCore.SProcessingAnnotation)
	 */
	public void testAddSProcessingAnnotation__SProcessingAnnotation() throws Exception 
	{
		SProcessingAnnotatableElementTest sPATest= new SProcessingAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testAddSProcessingAnnotation__SProcessingAnnotation();
		sPATest.tearDown();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String) <em>Get SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String)
	 */
	public void testGetSProcessingAnnotation__String() throws Exception 
	{
		SProcessingAnnotatableElementTest sPATest= new SProcessingAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testGetSProcessingAnnotation__String();
		sPATest.tearDown();
	}
	public void testReverseGetSProcessingAnnotation() throws Exception
	{
		SProcessingAnnotatableElementTest sPATest= new SProcessingAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testReverseGetSProcessingAnnotation();
		sPATest.tearDown();
	}
// ========================= end: testing SProcessingAnnotatableElement	
// ========================= start: testing SFeaturableElement	
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeatures() <em>SFeatures</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeatures()
	 */
	public void testGetSFeatures() throws Exception 
	{
		SFeaturableElementTest sFeatTest= new SFeaturableElementTest(this.getName());
		sFeatTest.setUp();
		sFeatTest.setFixture(this.getFixture());
		sFeatTest.testGetSFeatures();
		sFeatTest.tearDown();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeaturableElement#addSFeature(de.hub.corpling.salt.saltCore.SFeature) <em>Add SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SFeaturableElement#addSFeature(de.hub.corpling.salt.saltCore.SFeature)
	 */
	public void testAddSFeature__SFeature() throws Exception 
	{
		SFeaturableElementTest sFeatTest= new SFeaturableElementTest(this.getName());
		sFeatTest.setUp();
		sFeatTest.setFixture(this.getFixture());
		sFeatTest.testAddSFeature__SFeature();
		sFeatTest.tearDown();
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String) <em>Get SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String)
	 */
	public void testGetSFeature__String() throws Exception 
	{
		SFeaturableElementTest sFeatTest= new SFeaturableElementTest(this.getName());
		sFeatTest.setUp();
		sFeatTest.setFixture(this.getFixture());
		sFeatTest.testGetSFeature__String();
		sFeatTest.tearDown();
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

	// ========================= end: testing SFeaturableElement
	/**
	 * Checks if the equals mezhod is correctly implemented.
	 */
	public void testEquals()
	{
		{//adding id
			String id= "salt:/rel1";
			this.getFixture().setSId(id);
		}
		
		{//adding annotations
			SAnnotation sAnno= null;
			sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
			sAnno.setFullName("ns1::annoName1");
			sAnno.setSValue("annoValue1");
			this.getFixture().addSAnnotation(sAnno);
			
			sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
			sAnno.setFullName("ns2::annoName2");
			sAnno.setSValue("annoValue2");
			this.getFixture().addSAnnotation(sAnno);
		}
		
		{//adding Processing-Annotations
			SProcessingAnnotation sPAnno= null;
			sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
			sPAnno.setFullName("procAnnos::annoName1");
			sPAnno.setSValue("pAnnoValue1");
			this.getFixture().addSProcessingAnnotation(sPAnno);
			
			sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
			sPAnno.setFullName("procAnnos::annoName2");
			sPAnno.setSValue("pAnnoValue2");
			this.getFixture().addSProcessingAnnotation(sPAnno);
		}
		{//setting source node
			SNode sNode= SaltCoreFactory.eINSTANCE.createSNode();
			sNode.setId("salt:/sNode1");
			this.getFixture().setSSource(sNode);
		}
		{//setting target node
			SNode sNode= SaltCoreFactory.eINSTANCE.createSNode();
			sNode.setId("salt:/sNode2");
			this.getFixture().setSTarget(sNode);
		}
		assertSame(this.getFixture(), this.getFixture());
	}
} //SRelationTest
