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
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;
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
public class EdgeStoringTest extends TestCase {

	protected Edge fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EdgeStoringTest.class);
	}

	/**
	 * Constructs a new Labelable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeStoringTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Labelable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void setFixture(Edge fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Labelable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Edge getFixture() {
		return fixture;
	}

	private ResourceSet resourceSet = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		this.setFixture(GraphFactory.eINSTANCE.createEdge());
		this.resourceSet= new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("graph",new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(GraphPackage.eINSTANCE.getNsURI(), GraphPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("graph",new XMIResourceFactoryImpl());
		
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

	public void testStoringWithoutNodes() throws IOException
	{
		Edge EdgeNew= null;
		String tmpFileName= "_TMP/Edge.graph";
		
		
		Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
		identifier.setId("Edge1");
		this.getFixture().setIdentifier(identifier);
		
		Label label1= GraphFactory.eINSTANCE.createLabel();
		label1.setNamespace("annoNS");
		label1.setName("annoName1");
		label1.setValue("annoValue1");
		this.getFixture().addLabel(label1);
		
		Label label2= GraphFactory.eINSTANCE.createLabel();
		label2.setNamespace("annoNS");
		label2.setName("annoName2");
		label2.setValue("annoValue2");
		this.getFixture().addLabel(label2);
		
		{//save and reload
			// Register XML resource factory
			
			URI outURI= URI.createFileURI(tmpFileName);
			
			//save resources
			XMLResource resourceOut = (XMLResource)resourceSet.createResource(outURI);
			resourceOut.getContents().add(this.getFixture());
			resourceOut.setEncoding("UTF-8");
			resourceOut.save(null);
			
			
			//load resource 
			Resource resource = resourceSet.createResource(URI.createFileURI(tmpFileName));
			
			if (resource== null)
				throw new NullPointerException("The resource is null.");
			resource.load(null);
			EdgeNew= (Edge) resource.getContents().get(0);
			
		}
		{//check if both are equal
			assertEquals(this.getFixture(), EdgeNew);
		}
	}

	/**
	 * This method tests the storing of an edge with nodes as source or target. To store an edge with nodes
	 * a graph as container is used.
	 * @throws IOException
	 */
	public void testStoringInGraph() throws IOException
	{
		Graph graphNew= null;
		String tmpFileName= "_TMP/Edge2.graph";
		
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		graph.addEdge(this.getFixture());
		Node sourceNode= GraphFactory.eINSTANCE.createNode();
		sourceNode.setId("MyNode1");
		Node targetNode= GraphFactory.eINSTANCE.createNode();
		targetNode.setId("MyNode2");
		graph.addNode(sourceNode);
		graph.addNode(targetNode);
		
		this.getFixture().setSource(sourceNode);
		this.getFixture().setTarget(targetNode);
		{//save and reload
			// Register XML resource factory
			
			URI outURI= URI.createFileURI(tmpFileName);
			
			//save resources
			XMLResource resourceOut = (XMLResource)resourceSet.createResource(outURI);
			resourceOut.getContents().add(graph);
			resourceOut.setEncoding("UTF-8");
			resourceOut.save(null);
			
			
			//load resource 
			Resource resource = resourceSet.createResource(URI.createFileURI(tmpFileName));
			
			if (resource== null)
				throw new NullPointerException("The resource is null.");
			resource.load(null);
			graphNew= (Graph) resource.getContents().get(0);
		}
		{//check if both are equal
			assertEquals(graph, graphNew);
		}
	}
} //EdgeStoringTest
