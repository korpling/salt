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

import de.hub.corpling.salt.saltCore.SFeature;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SGraph</b></em>'.
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
 *   <li>{@link de.hub.corpling.salt.saltCore.SGraph#getSRelations() <em>SRelations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SGraph#getSNodes() <em>SNodes</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SGraph#addSNode(de.hub.corpling.salt.saltCore.SNode) <em>Add SNode</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SGraph#getSNode(java.lang.String) <em>Get SNode</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SGraph#addSRelation(de.hub.corpling.salt.saltCore.SRelation) <em>Add SRelation</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SGraph#getSRelation(java.lang.String) <em>Get SRelation</em>}</li>
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
public class SGraphTest extends TestCase {

	/**
	 * The fixture for this SGraph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SGraph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SGraphTest.class);
	}

	/**
	 * Constructs a new SGraph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SGraphTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SGraph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SGraph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SGraph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SGraph getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSGraph());
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
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SGraph#getSNodes() <em>SNodes</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSNodes()
	 */
	public void testGetSNodes() 
	{
		String[] sNodeNames= {"sNode1", "sNode2", "sNode3", "sNode4", "sNode5"};
		EList<SNode> sNodes= new BasicEList<SNode>(); 
		SNode sNode= null;
		for (String sNodeName: sNodeNames)
		{
			sNode= SaltCoreFactory.eINSTANCE.createSNode();
			sNode.setSId(sNodeName);
			sNodes.add(sNode);
			this.getFixture().addSNode(sNode);
		}	
		
		//checking if all nodes are there
		assertTrue(this.getFixture().getSNodes().containsAll(sNodes));
		assertTrue(sNodes.containsAll(this.getFixture().getSNodes()));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SGraph#addSNode(de.hub.corpling.salt.saltCore.SNode) <em>Add SNode</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SGraph#addSNode(de.hub.corpling.salt.saltCore.SNode)
	 */
	public void testAddSNode__SNode() 
	{
		this.testGetSNode__String();
		
		SNode node= SaltCoreFactory.eINSTANCE.createSNode();
		node.setId("node99999");
		this.getFixture().addSNode(node);
		try {
			this.getFixture().addSNode(node);
			fail("Shall not add a node two times.");
		} catch (Exception e) {
		}
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SGraph#getSNode(java.lang.String) <em>Get SNode</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSNode(java.lang.String)
	 */
	public void testGetSNode__String() 
	{
		String[] sNodeNames= {"sNode1", "sNode2", "sNode3", "sNode4", "sNode5"};
		EList<SNode> sNodes= new BasicEList<SNode>(); 
		SNode sNode= null;
		for (String sNodeName: sNodeNames)
		{
			sNode= SaltCoreFactory.eINSTANCE.createSNode();
			sNode.setSId(sNodeName);
			sNodes.add(sNode);
			this.getFixture().addSNode(sNode);
		}	
		
		//checking if all nodes are there
		assertEquals(sNodes.size(), this.getFixture().getSNodes().size());
		for (SNode sNodeSearch: sNodes)
		{
			assertEquals(sNodeSearch, this.getFixture().getSNode(sNodeSearch.getSId()));
		}
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SGraph#addSRelation(de.hub.corpling.salt.saltCore.SRelation) <em>Add SRelation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SGraph#addSRelation(de.hub.corpling.salt.saltCore.SRelation)
	 */
	public void testAddSRelation__SRelation() 
	{
		this.testGetSRelation__SElementId();
		
		SRelation rel= SaltCoreFactory.eINSTANCE.createSRelation();
		rel.setId("rel99999");
		this.getFixture().addSRelation(rel);
		try {
			this.getFixture().addSRelation(rel);
			fail("Shall not add a relation two times.");
		} catch (Exception e) {
		}
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SGraph#getSRelation(java.lang.String) <em>Get SRelation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSRelation(java.lang.String)
	 */
	public void testGetSRelation__String() 
	{
		String[] sRelNames= {"sEdge1", "sEdge2", "sEdge3", "sEdge4", "sEdge5"};
		EList<SRelation> sRels= new BasicEList<SRelation>();
		SRelation sRel= null;
		for (String sEdgeName: sRelNames)
		{
			sRel= SaltCoreFactory.eINSTANCE.createSRelation();
			sRel.setSId(sEdgeName);
			sRels.add(sRel);
			this.getFixture().addSRelation(sRel);
		}
		
		//checking if all nodes are there
		assertEquals(sRels.size(), this.getFixture().getSRelations().size());
		for (SRelation sRelSearch: sRels)
		{
			assertEquals(sRelSearch, this.getFixture().getSRelation(sRelSearch.getSId()));
		}
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SGraph#getSRelations() <em>SRelations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSRelations()
	 */
	public void testGetSRelations() 
	{
//		//nodes
//		String[] sNodeNames= {"sNode1", "sNode2", "sNode3", "sNode4", "sNode5"};
//		EList<SNode> sNodes= new BasicEList<SNode>(); 
//		SNode sNode= null;
//		for (String sNodeName: sNodeNames)
//		{
//			sNode= SaltCoreFactory.eINSTANCE.createSNode();
//			SElementId sElementId= SaltCoreFactory.eINSTANCE.createSElementId();
//			sElementId.setSId(sNodeName);
//			sNode.setSElementId(sElementId);
//			sNodes.add(sNode);
//			this.getFixture().addSNode(sNode);
//		}	
		
		//edges
		String[] sRelNames= {"sEdge1", "sEdge2", "sEdge3", "sEdge4", "sEdge5"};
		EList<SRelation> sRels= new BasicEList<SRelation>();
		SRelation sRel= null;
		for (String sEdgeName: sRelNames)
		{
			sRel= SaltCoreFactory.eINSTANCE.createSRelation();
			sRel.setSId(sEdgeName);
			sRels.add(sRel);
			this.getFixture().addSRelation(sRel);
		}
		
		//checking if all nodes are there
		assertTrue(this.getFixture().getSRelations().containsAll(sRels));
		assertTrue(sRels.containsAll(this.getFixture().getSRelations()));
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SGraph#getSRelation(de.hub.corpling.salt.saltCore.SElementId) <em>Get SRelation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSRelation(de.hub.corpling.salt.saltCore.SElementId)
	 */
	public void testGetSRelation__SElementId() 
	{
		String[] sRelNames= {"sEdge1", "sEdge2", "sEdge3", "sEdge4", "sEdge5"};
		EList<SRelation> sRels= new BasicEList<SRelation>();
		SRelation sRel= null;
		for (String sEdgeName: sRelNames)
		{
			sRel= SaltCoreFactory.eINSTANCE.createSRelation();
			sRel.setSId(sEdgeName);
			sRels.add(sRel);
			this.getFixture().addSRelation(sRel);
		}
		
		//checking if all nodes are there
		assertEquals(sRels.size(), this.getFixture().getSRelations().size());
		for (SRelation sRelSearch: sRels)
		{
			assertEquals(sRelSearch, this.getFixture().getSRelation(sRelSearch.getSId()));
		}
	}

// ========================= start: testing SIdentifiableElement
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
//========================= end: testing SIdentifiableElement
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
} //SGraphTest
