/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SLayer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeatures() <em>SFeatures</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement#getSName() <em>SName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementId() <em>SElement Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSId() <em>SId</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementPath() <em>SElement Path</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations() <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotations() <em>SAnnotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations() <em>SMeta Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSRelations() <em>SRelations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSNodes() <em>SNodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSGraph() <em>SGraph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSubLayers() <em>SSub Layers</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSuperLayer() <em>SSuper Layer</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation) <em>Add SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String) <em>Get SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#addSAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation) <em>Add SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotation(java.lang.String) <em>Get SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation) <em>Add SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String) <em>Get SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#addSFeature(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature) <em>Add SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String) <em>Get SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String) <em>Get SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.String) <em>Create SFeature</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SLayerTest extends SNamedElementTest {

	/**
	 * The fixture for this SLayer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SLayer fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SLayerTest.class);
	}

	/**
	 * Constructs a new SLayer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SLayerTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SLayer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SLayer fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SLayer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SLayer getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSLayer());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSRelations() <em>SRelations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSRelations()
	 */
	public void testGetSRelations() 
	{
		//edges
		String[] sRelNames= {"sEdge1", "sEdge2", "sEdge3", "sEdge4", "sEdge5"};
		EList<SRelation> sRels= new BasicEList<SRelation>();
		SRelation sRel= null;
		for (String sEdgeName: sRelNames)
		{
			sRel= SaltCoreFactory.eINSTANCE.createSRelation();
			sRel.setSId(sEdgeName);
			sRels.add(sRel);
			this.getFixture().getSRelations().add(sRel);
		}
		
		//checking if all nodes are there
		assertTrue(this.getFixture().getSRelations().containsAll(sRels));
		assertTrue(sRels.containsAll(this.getFixture().getSRelations()));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSNodes() <em>SNodes</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSNodes()
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
			this.getFixture().getSNodes().add(sNode);
		}	
		
		//checking if all nodes are there
		assertTrue(this.getFixture().getSNodes().containsAll(sNodes));
		assertTrue(sNodes.containsAll(this.getFixture().getSNodes()));
	}

	// ========================= start: testing SIdentifiableElement
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSId() <em>SId</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
		 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSId()
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#setSId(java.lang.String) <em>SId</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#setSId(java.lang.String)
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementPath() <em>SElement Path</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementPath()
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#setSElementPath(org.eclipse.emf.common.util.URI) <em>SElement Path</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#setSElementPath(org.eclipse.emf.common.util.URI)
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementId() <em>SElement Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementId()
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#setSElementId(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>SElement Id</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#setSElementId(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId)
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
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSGraph() <em>SGraph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSGraph()
	 */
	public void testGetSGraph() 
	{
		SGraph sGraph= SaltCoreFactory.eINSTANCE.createSGraph();
		this.getFixture().setSGraph(sGraph);
		assertEquals(sGraph, sGraph);
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#setSGraph(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph) <em>SGraph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#setSGraph(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph)
	 */
	public void testSetSGraph() 
	{
		this.testGetSGraph();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSubLayers() <em>SSub Layers</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSubLayers()
	 */
	public void testGetSSubLayers() 
	{
		assertEquals(0, this.getFixture().getSSubLayers().size());
		
		SLayer sSubLayer1= SaltCoreFactory.eINSTANCE.createSLayer();
		this.getFixture().getSSubLayers().add(sSubLayer1);
		assertNotNull(this.getFixture().getSSubLayers());
		assertEquals(1, this.getFixture().getSSubLayers().size());
		assertEquals(sSubLayer1, this.getFixture().getSSubLayers().get(0));
		assertEquals(this.getFixture(), sSubLayer1.getSSuperLayer());
		
		SLayer sSubLayer2= SaltCoreFactory.eINSTANCE.createSLayer();
		this.getFixture().getSSubLayers().add(sSubLayer2);
		assertNotNull(this.getFixture().getSSubLayers());
		assertEquals(2, this.getFixture().getSSubLayers().size());
		assertEquals(sSubLayer2, this.getFixture().getSSubLayers().get(1));
		assertEquals(this.getFixture(), sSubLayer2.getSSuperLayer());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSuperLayer() <em>SSuper Layer</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSuperLayer()
	 */
	public void testGetSSuperLayer() 
	{
		SLayer sSuperLayer= SaltCoreFactory.eINSTANCE.createSLayer();
		this.getFixture().setSSuperLayer(sSuperLayer);
		assertEquals(sSuperLayer, this.getFixture().getSSuperLayer());
		assertTrue(sSuperLayer.getSSubLayers().contains(this.getFixture()));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#setSSuperLayer(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer) <em>SSuper Layer</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#setSSuperLayer(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer)
	 */
	public void testSetSSuperLayer() {
		this.testGetSSuperLayer();
	}

	// ========================= start: testing SMetaAnnotatableElement
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations() <em>SMetaAnnotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations()
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation) <em>Add SMetaAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation)
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String) <em>Get SMetaAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String)
	 */
	public void testGetSMetaAnnotation__String() throws Exception 
	{
		SMetaAnnotatableElementTest sPATest= new SMetaAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testGetSMetaAnnotation__String();
		sPATest.tearDown();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SMeta Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE)
	 */
	public void testCreateSMetaAnnotation__String_String_Object_SDATATYPE() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SMetaAnnotation metaAnno = this.getFixture().createSMetaAnnotation(namespace, name, value, SDATATYPE.STEXT);
		assertEquals(metaAnno, this.getFixture().getSMetaAnnotations().get(this.getFixture().getSMetaAnnotations().size()-1));
		assertEquals(metaAnno, this.getFixture().getSMetaAnnotation(namespace+"::"+name));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SMeta Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void testCreateSMetaAnnotation__String_String_String() {
		this.testCreateSMetaAnnotation__String_String_Object_SDATATYPE();
	}

	// ========================= end: testing SMetaAnnotatableElement	
// ========================= start: testing SAnnotatableElement
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotations() <em>SAnnotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotations()
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#addSAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation) <em>Add SAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#addSAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation)
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotation(java.lang.String) <em>Get SAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotation(java.lang.String)
	 */
	public void testGetSAnnotation__String() throws Exception 
	{
		SAnnotatableElementTest sPATest= new SAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testGetSAnnotation__String();
		sPATest.tearDown();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE)
	 */
	public void testCreateSAnnotation__String_String_Object_SDATATYPE() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SAnnotation anno = this.getFixture().createSAnnotation(namespace, name, value, SDATATYPE.STEXT);
		assertEquals(anno, this.getFixture().getSAnnotations().get(this.getFixture().getSAnnotations().size()-1));
		assertEquals(anno, this.getFixture().getSAnnotation(namespace+"::"+name));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void testCreateSAnnotation__String_String_String() {
		this.testCreateSAnnotation__String_String_Object_SDATATYPE();
	}

	// ========================= end: testing SAnnotatableElement	
	
// ========================= start: testing SProcessingAnnotatableElement
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations() <em>SProcessing Annotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations()
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation) <em>Add SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation)
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String) <em>Get SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String)
	 */
	public void testGetSProcessingAnnotation__String() throws Exception 
	{
		SProcessingAnnotatableElementTest sPATest= new SProcessingAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testGetSProcessingAnnotation__String();
		sPATest.tearDown();
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE)
	 */
	public void testCreateSProcessingAnnotation__String_String_Object_SDATATYPE() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SProcessingAnnotation procAnno = this.getFixture().createSProcessingAnnotation(namespace, name, value, SDATATYPE.STEXT);
		assertEquals(procAnno, this.getFixture().getSProcessingAnnotations().get(this.getFixture().getSProcessingAnnotations().size()-1));
		assertEquals(procAnno, this.getFixture().getSProcessingAnnotation(namespace+"::"+name));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void testCreateSProcessingAnnotation__String_String_String() {
		this.testCreateSProcessingAnnotation__String_String_Object_SDATATYPE();
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeatures() <em>SFeatures</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeatures()
	 */
	public void testGetSFeatures() 
	{
		try
		{
			SFeaturableElementTest sFeatTest= new SFeaturableElementTest(this.getName());
			sFeatTest.setUp();
			sFeatTest.setFixture(this.getFixture());
			sFeatTest.testGetSFeatures();
			sFeatTest.tearDown();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#addSFeature(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature) <em>Add SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#addSFeature(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature)
	 */
	public void testAddSFeature__SFeature() 
	{
		try{
			SFeaturableElementTest sFeatTest= new SFeaturableElementTest(this.getName());
			sFeatTest.setUp();
			sFeatTest.setFixture(this.getFixture());
			sFeatTest.testAddSFeature__SFeature();
			sFeatTest.tearDown();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String) <em>Get SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String)
	 */
	public void testGetSFeature__String() 
	{
		try{
			SFeaturableElementTest sFeatTest= new SFeaturableElementTest(this.getName());
			sFeatTest.setUp();
			sFeatTest.setFixture(this.getFixture());
			sFeatTest.testGetSFeature__String();
			sFeatTest.tearDown();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String) <em>Get SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String)
	 */
	public void testGetSFeature__String_String() 
	{
		SFeature sFeature= SaltCoreFactory.eINSTANCE.createSFeature();
		sFeature.setSNS("sNS");
		sFeature.setSName("name");
		this.getFixture().addSFeature(sFeature);
		assertEquals(sFeature, this.getFixture().getSFeature(sFeature.getSNS(), sFeature.getSName()));
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE)
	 */
	public void testCreateSFeature__String_String_Object_SDATATYPE() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SFeature feat = this.getFixture().createSFeature(namespace, name, value, SDATATYPE.STEXT);
		assertEquals(feat, this.getFixture().getSFeatures().get(this.getFixture().getSFeatures().size()-1));
		assertEquals(feat, this.getFixture().getSFeature(namespace, name));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.String) <em>Create SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void testCreateSFeature__String_String_String() {
		this.testCreateSFeature__String_String_Object_SDATATYPE();
	}

	/**
	 * Tests when adding a node to a layer, if the node also contains the layer and vice versa. 
	 */
	public void testReverseSetSNode()
	{
		SNode sNode= null;
		
		sNode= SaltCoreFactory.eINSTANCE.createSNode();
		this.getFixture().getSNodes().add(sNode);
		assertTrue(sNode.getSLayers().contains(this.getFixture()));
		
		sNode= SaltCoreFactory.eINSTANCE.createSNode();
		sNode.getSLayers().add(this.getFixture());
		assertTrue(this.getFixture().getSNodes().contains(sNode));
	}
	
	/**
	 * Tests when adding a node to a layer, if the node also contains the layer and vice versa. 
	 */
	public void testReverseSetSRelation()
	{
		SRelation sRel= null;
		
		sRel= SaltCoreFactory.eINSTANCE.createSRelation();
		this.getFixture().getSRelations().add(sRel);
		assertTrue(sRel.getSLayers().contains(this.getFixture()));
		
		sRel= SaltCoreFactory.eINSTANCE.createSRelation();
		sRel.getSLayers().add(this.getFixture());
		assertTrue(this.getFixture().getSRelations().contains(sRel));
	}
// ========================= end: testing SFeaturableElement

} //SLayerTest
