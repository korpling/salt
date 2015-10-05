/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.storing.tests;

import java.io.IOException;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Labeled Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#addLabel(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label) <em>Add Label</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabel(java.lang.String, java.lang.String) <em>Get Label</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabel(java.lang.String) <em>Get Label</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#removeLabel(java.lang.String) <em>Remove Label</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getNumOfLabels() <em>Get Num Of Labels</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#removeAll() <em>Remove All</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabelsByNamespace(java.lang.String) <em>Get Labels By Namespace</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#hasLabel(java.lang.String) <em>Has Label</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class GraphStoringTest extends TestCase {

	protected Graph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphStoringTest.class);
	}

	/**
	 * Constructs a new Labelable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphStoringTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Labelable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Graph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Labelable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Graph getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		this.setFixture(GraphFactory.eINSTANCE.createGraph());
		this.resourceSet= new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("graph",new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",new XMIResourceFactoryImpl());
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

	private String outputFileName= null;
	private String inputFileName= null;
	
	private ResourceSet resourceSet = null;
	
	/**
	 * name: graph1
	 * @throws IOException 
	 */
	public void testSaving1() throws IOException
	{
		this.outputFileName= "./_TMP/output/graphSaving1.graph";
		
		this.getFixture().setId("graph1");
		
		Resource resourceOut = resourceSet.createResource(URI.createFileURI(outputFileName));
		resourceOut.getContents().add(this.getFixture());
		resourceOut.save(null);
	}
	
	/**
	 * name: graph1
	 * @throws IOException 
	 */
	public void testLoading1() throws IOException
	{
		this.inputFileName= "./src/test/resources/data/input/graphLoading1.graph";
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFileName));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		this.setFixture((Graph)resource.getContents().get(0));
		assertEquals("graph1", this.getFixture().getId());
	}
	
	/**
	 * name: graph1
	 * 
	 * node1		node2
	 * 			x
	 * node3		node4
	 * @throws IOException 
	 */
	public void testSaving2() throws IOException
	{
		this.outputFileName= "./_TMP/output/graphSaving2.graph";
		this.getFixture().setId("graph1");
		
		Node node1= GraphFactory.eINSTANCE.createNode();
		node1.setId("node1");
		this.getFixture().addNode(node1);
		
		Node node2= GraphFactory.eINSTANCE.createNode();
		node2.setId("node2");
		this.getFixture().addNode(node2);
		
		Node node3= GraphFactory.eINSTANCE.createNode();
		node3.setId("node3");
		this.getFixture().addNode(node3);
		
		Node node4= GraphFactory.eINSTANCE.createNode();
		node4.setId("node4");
		this.getFixture().addNode(node4);
		
		
		//Edges
		Edge edge1= GraphFactory.eINSTANCE.createEdge();
		edge1.setId("edge1");
		edge1.setSource(node1);
		edge1.setTarget(node4);
		this.getFixture().addEdge(edge1);
		
		Edge edge2= GraphFactory.eINSTANCE.createEdge();
		edge2.setId("edge2");
		edge2.setSource(node2);
		edge2.setTarget(node3);
		this.getFixture().addEdge(edge2);
		
		Resource resourceOut = resourceSet.createResource(URI.createFileURI(outputFileName));
		resourceOut.getContents().add(this.getFixture());
		resourceOut.save(null);
		
	}
	
	/**
	  * name: graph1
	 * 
	 * node1		node2
	 * 			x
	 * node3		node4
	 * @throws IOException 
	 */
	public void testLoading2() throws IOException
	{
		this.inputFileName= "./src/test/resources/data/input/graphLoading2.graph";
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFileName));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		this.setFixture((Graph)resource.getContents().get(0));
		assertEquals("graph1", this.getFixture().getId());
		assertNotNull(this.getFixture().getNode("node1"));
		assertNotNull(this.getFixture().getNode("node2"));
		assertNotNull(this.getFixture().getNode("node3"));
		assertNotNull(this.getFixture().getNode("node4"));
		
		Edge edge1= this.getFixture().getEdge("edge1");
		assertEquals("node1", edge1.getSource().getId());
		assertEquals("node4", edge1.getTarget().getId());
		
		Edge edge2= this.getFixture().getEdge("edge2");
		assertEquals("node2", edge2.getSource().getId());
		assertEquals("node3", edge2.getTarget().getId());
	}

	public void testStoring() throws IOException
	{
		Graph graph2= GraphFactory.eINSTANCE.createGraph(); 
			
		String tmpFileName= "./_TMP/Graph.graph";
		this.getFixture().setId("graph1");
		
		Node node1= GraphFactory.eINSTANCE.createNode();
		node1.setId("MyNode1");
		this.getFixture().addNode(node1);
		
		Node node2= GraphFactory.eINSTANCE.createNode();
		node2.setId("MyNode2");
		this.getFixture().addNode(node2);
		
		Node node3= GraphFactory.eINSTANCE.createNode();
		node3.setId("MyNode3");
		this.getFixture().addNode(node3);
		
		Node node4= GraphFactory.eINSTANCE.createNode();
		node4.setId("MyNode4");
		this.getFixture().addNode(node4);
		
		
		//Edges
		Edge edge1= GraphFactory.eINSTANCE.createEdge();
		edge1.setId("MyEdge1");
		edge1.setSource(node1);
		edge1.setTarget(node4);
		this.getFixture().addEdge(edge1);
		
		Edge edge2= GraphFactory.eINSTANCE.createEdge();
		edge2.setId("MyEdge2");
		edge2.setSource(node2);
		edge2.setTarget(node3);
		this.getFixture().addEdge(edge2);
		
		{
			Resource resource = resourceSet.createResource(URI.createFileURI(tmpFileName));
			resource.getContents().add(this.getFixture());
			resource.save(null);
			//load resource 
			resource = resourceSet.createResource(URI.createFileURI(tmpFileName));
			
			if (resource== null)
				throw new NullPointerException("The resource is null.");
			resource.load(null);
			
			
			graph2= (Graph)resource.getContents().get(0);
		}
		assertEquals(this.getFixture(), graph2);
	}
} //GraphStoringTest
