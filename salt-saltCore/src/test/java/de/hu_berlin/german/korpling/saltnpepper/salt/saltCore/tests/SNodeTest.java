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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import junit.framework.TestCase;
import junit.textui.TestRunner;
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
 * A test case for the model object '<em><b>SNode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotations() <em>SAnnotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeatures() <em>SFeatures</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement#getSName() <em>SName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementId() <em>SElement Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSId() <em>SId</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementPath() <em>SElement Path</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations() <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations() <em>SMeta Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSGraph() <em>SGraph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSLayers() <em>SLayers</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getOutgoingSRelations() <em>Get Outgoing SRelations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getIncomingSRelations() <em>Get Incoming SRelations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation) <em>Add SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String) <em>Get SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation) <em>Add SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String) <em>Get SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#addSFeature(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature) <em>Add SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String) <em>Get SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String) <em>Get SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.String) <em>Create SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#addSAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation) <em>Add SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotation(java.lang.String) <em>Get SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotations(java.lang.String) <em>Create SAnnotations</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SNodeTest extends TestCase {

	/**
	 * The fixture for this SNode test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SNode fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SNodeTest.class);
	}

	/**
	 * Constructs a new SNode test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNodeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SNode test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SNode fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SNode test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SNode getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSNode());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSLayers() <em>SLayers</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSLayers()
	 */
	public void testGetSLayers() 
	{
		assertEquals(0, this.getFixture().getSLayers().size());
		
		EList<SLayer> layers= new BasicEList<SLayer>();
		for (int i= 1; i< 5; i++)
		{
			SLayer layer= SaltCoreFactory.eINSTANCE.createSLayer(); 
			layers.add(layer);
			this.getFixture().getSLayers().add(layer);
		}
		assertTrue(layers.containsAll(this.getFixture().getSLayers()));
		assertTrue(this.getFixture().getSLayers().containsAll(layers));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getOutgoingSRelations() <em>Get Outgoing SRelations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getOutgoingSRelations()
	 * @generated
	 */
	public void testGetOutgoingSRelationsNoRelations() {		
		assertNull(this.getFixture().getOutgoingSRelations());
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getOutgoingSRelations() <em>Get Outgoing SRelations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getOutgoingSRelations()
	 * @generated
	 */
	public void testGetOutgoingSRelations() {
		SGraph sGraph = SaltCoreFactory.eINSTANCE.createSGraph();
		sGraph.addSNode(this.getFixture());
		SRelation sRelation = SaltCoreFactory.eINSTANCE.createSRelation();
		sRelation.setSSource(this.getFixture());
		sGraph.addSRelation(sRelation);
		assertNotNull(this.getFixture().getOutgoingSRelations());
		assertEquals(1, this.getFixture().getOutgoingSRelations().size());
		assertTrue(this.getFixture().getOutgoingSRelations().contains(sRelation));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getIncomingSRelations() <em>Get Incoming SRelations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getIncomingSRelations()
	 * @generated
	 */
	public void testGetIncomingSRelationsNoRelations() {
		assertNull(this.getFixture().getIncomingSRelations());
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getIncomingSRelations() <em>Get Incoming SRelations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getIncomingSRelations()
	 * @generated
	 */
	public void testGetIncomingSRelations() {
		SGraph sGraph = SaltCoreFactory.eINSTANCE.createSGraph();
		sGraph.addSNode(this.getFixture());
		SRelation sRelation = SaltCoreFactory.eINSTANCE.createSRelation();
		sRelation.setSTarget(this.getFixture());
		sGraph.addSRelation(sRelation);
		assertNotNull(this.getFixture().getIncomingSRelations());
		assertEquals(1, this.getFixture().getIncomingSRelations().size());
		assertTrue(this.getFixture().getIncomingSRelations().contains(sRelation));
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

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotations(java.lang.String) <em>Create SAnnotations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotations(java.lang.String)
	 */
	public void testCreateSAnnotations__String() {
		try 
		{
			SAnnotatableElementTest sFeatTest= new SAnnotatableElementTest(this.getName());
			sFeatTest.setUp();
			sFeatTest.setFixture(this.getFixture());
			sFeatTest.testCreateSAnnotations__String();
			sFeatTest.tearDown();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
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
		this.testCreateSAnnotation__String_String_Object_SDATATYPE();
	}

	public void testReverseGetSProcessingAnnotation() throws Exception
	{
		SProcessingAnnotatableElementTest sPATest= new SProcessingAnnotatableElementTest(this.getName());
		sPATest.setUp();
		sPATest.setFixture(this.getFixture());
		sPATest.testReverseGetSProcessingAnnotation();
		sPATest.tearDown();
	}
	
	/**
	 * Checks if the equals mezhod is correctly implemented.
	 */
	public void testEquals()
	{
		{//adding id
			String id= "salt:/node1";
			this.getFixture().setSId(id);
		}
		
		{//adding annotations
			SAnnotation sAnno= null;
			sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
			sAnno.setQName("ns1::annoName1");
			sAnno.setSValue("annoValue1");
			this.getFixture().addSAnnotation(sAnno);
			
			sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
			sAnno.setQName("ns2::annoName2");
			sAnno.setSValue("annoValue2");
			this.getFixture().addSAnnotation(sAnno);
		}
		
		{//adding Processing-Annotations
			SProcessingAnnotation sPAnno= null;
			sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
			sPAnno.setQName("procAnnos::annoName1");
			sPAnno.setSValue("pAnnoValue1");
			this.getFixture().addSProcessingAnnotation(sPAnno);
			
			sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
			sPAnno.setQName("procAnnos::annoName2");
			sPAnno.setSValue("pAnnoValue2");
			this.getFixture().addSProcessingAnnotation(sPAnno);
		}
		assertEquals(this.getFixture(), this.getFixture());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement#getSName() <em>SName</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement#getSName()
	 */
	public void testGetSName() {
		try 
		{
			SNamedElementTest sFeatTest= new SNamedElementTest(this.getName());
			sFeatTest.setUp();
			sFeatTest.setFixture(this.getFixture());
			sFeatTest.testGetSName();
			sFeatTest.tearDown();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement#setSName(java.lang.String) <em>SName</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement#setSName(java.lang.String)
	 */
	public void testSetSName() {
		try 
		{
			SNamedElementTest sFeatTest= new SNamedElementTest(this.getName());
			sFeatTest.setUp();
			sFeatTest.setFixture(this.getFixture());
			sFeatTest.testSetSName();
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
		try 
		{
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
		try
		{
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
		assertEquals(feat, this.getFixture().getSFeature(namespace+"::"+name));
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
// ========================= end: testing SFeaturableElement
} //SNodeTest
