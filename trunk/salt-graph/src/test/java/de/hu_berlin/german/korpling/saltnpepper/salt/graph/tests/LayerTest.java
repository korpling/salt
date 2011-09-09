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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests;

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllSubLayers() <em>Get All Sub Layers</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllIncludedNodes() <em>Get All Included Nodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllIncludedEdges() <em>Get All Included Edges</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class LayerTest extends IdentifiableElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LayerTest.class);
	}

	/**
	 * Constructs a new Layer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Layer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Layer getFixture() {
		return (Layer)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GraphFactory.eINSTANCE.createLayer());
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
	 * Checks that a layer cannot contain itself.
	 */
	public void testSelfContainment() 
	{
		try
		{
			this.getFixture().getSubLayers().add(getFixture());
			fail("A layer shall not contain itself");
		}
		catch (Exception e) {}
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllSubLayers() <em>Get All Sub Layers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 		layer1
	 *		/	\
	 *	layer2	layer3
	 *	|
	 *	layer4	
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllSubLayers()
	 */
	public void testGetAllSubLayers() 
	{
		Layer layer1= GraphFactory.eINSTANCE.createLayer();
		layer1.setId("layer1");
		Layer layer2= GraphFactory.eINSTANCE.createLayer();
		layer2.setId("layer2");
		Layer layer3= GraphFactory.eINSTANCE.createLayer();
		layer3.setId("layer3");
		Layer layer4= GraphFactory.eINSTANCE.createLayer();
		layer4.setId("layer4");
		
		assertNull(layer1.getAllSubLayers());
		assertNull(layer1.getSuperLayer());
		
		assertNull(layer2.getAllSubLayers());
		assertNull(layer2.getSuperLayer());
		
		assertNull(layer3.getAllSubLayers());
		assertNull(layer3.getSuperLayer());
		
		assertNull(layer4.getAllSubLayers());
		assertNull(layer4.getSuperLayer());
		
		//adding layer2 to layer1
		layer1.getSubLayers().add(layer2);
		assertTrue(layer1.getAllSubLayers().contains(layer2));
		assertEquals(layer1, layer2.getSuperLayer());
		
		//adding layer3 to layer1
		layer1.getSubLayers().add(layer3);
		assertTrue(layer1.getAllSubLayers().contains(layer3));
		assertEquals(layer1, layer3.getSuperLayer());
		
		//recursive part
		layer2.getSubLayers().add(layer4);
		assertTrue(layer2.getAllSubLayers().contains(layer4));
		
		assertTrue(layer1.getAllSubLayers().contains(layer2));
		assertTrue(layer1.getAllSubLayers().contains(layer4));
		assertEquals(layer2, layer4.getSuperLayer());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllIncludedNodes() <em>Get All Included Nodes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllIncludedNodes()
	 * 		layer1 (n1)
	 *		/				\
	 *	layer2(n2.1, n2.2)	layer3(n3)
	 *	|
	 *	layer4(n4)	
	 */
	public void testGetAllIncludedNodes() 
	{
		Layer layer1= GraphFactory.eINSTANCE.createLayer();
		layer1.setId("layer1");
		Node n1= GraphFactory.eINSTANCE.createNode();
		n1.setId("n1");
		layer1.getNodes().add(n1);
		
		Layer layer2= GraphFactory.eINSTANCE.createLayer();
		layer2.setId("layer2");
		Node n21= GraphFactory.eINSTANCE.createNode();
		n21.setId("n2.1");
		layer2.getNodes().add(n21);
		Node n22= GraphFactory.eINSTANCE.createNode();
		n22.setId("n2.2");
		layer2.getNodes().add(n22);
		
		Layer layer3= GraphFactory.eINSTANCE.createLayer();
		layer3.setId("layer3");
		Node n3= GraphFactory.eINSTANCE.createNode();
		n3.setId("n3");
		layer3.getNodes().add(n3);
		
		Layer layer4= GraphFactory.eINSTANCE.createLayer();
		layer4.setId("layer4");
		Node n4= GraphFactory.eINSTANCE.createNode();
		n4.setId("n4");
		layer4.getNodes().add(n4);
		
		//connect layers
		layer1.getSubLayers().add(layer2);
		layer1.getSubLayers().add(layer3);
		layer2.getSubLayers().add(layer4);
		
		{//check node containment
			assertNotNull(layer1.getAllIncludedNodes());
			assertNotNull(layer2.getAllIncludedNodes());
			assertNotNull(layer3.getAllIncludedNodes());
			assertNotNull(layer4.getAllIncludedNodes());
			
			assertEquals(1, layer4.getAllIncludedNodes().size());
			assertTrue(layer4.getAllIncludedNodes().contains(n4));
			
			assertEquals(1, layer3.getAllIncludedNodes().size());
			assertTrue(layer3.getAllIncludedNodes().contains(n3));
			
			assertEquals(3, layer2.getAllIncludedNodes().size());
			assertTrue(layer2.getAllIncludedNodes().contains(n4));
			assertTrue(layer2.getAllIncludedNodes().contains(n21));
			assertTrue(layer2.getAllIncludedNodes().contains(n22));
			
			assertEquals(5, layer1.getAllIncludedNodes().size());
			assertTrue(layer1.getAllIncludedNodes().contains(n4));
			assertTrue(layer1.getAllIncludedNodes().contains(n3));
			assertTrue(layer1.getAllIncludedNodes().contains(n21));
			assertTrue(layer1.getAllIncludedNodes().contains(n22));
			assertTrue(layer1.getAllIncludedNodes().contains(n1));
		}//check node containment
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllIncludedEdges() <em>Get All Included Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllIncludedEdges()
	 * 		layer1 (e1)
	 *		/				\
	 *	layer2(e2.1, e2.2)	layer3(e3)
	 *	|
	 *	layer4(e4)	
	 */
	public void testGetAllIncludedEdges() 
	{
		Layer layer1= GraphFactory.eINSTANCE.createLayer();
		layer1.setId("layer1");
		Edge e1= GraphFactory.eINSTANCE.createEdge();
		e1.setId("e1");
		layer1.getEdges().add(e1);
		
		Layer layer2= GraphFactory.eINSTANCE.createLayer();
		layer2.setId("layer2");
		Edge e21= GraphFactory.eINSTANCE.createEdge();
		e21.setId("e2.1");
		layer2.getEdges().add(e21);
		Edge e22= GraphFactory.eINSTANCE.createEdge();
		e22.setId("e2.2");
		layer2.getEdges().add(e22);
		
		Layer layer3= GraphFactory.eINSTANCE.createLayer();
		layer3.setId("layer3");
		Edge e3= GraphFactory.eINSTANCE.createEdge();
		e3.setId("e3");
		layer3.getEdges().add(e3);
		
		Layer layer4= GraphFactory.eINSTANCE.createLayer();
		layer4.setId("layer4");
		Edge e4= GraphFactory.eINSTANCE.createEdge();
		e4.setId("e4");
		layer4.getEdges().add(e4);
		
		//connect layers
		layer1.getSubLayers().add(layer2);
		layer1.getSubLayers().add(layer3);
		layer2.getSubLayers().add(layer4);
		
		{//check edge containment
			assertNotNull(layer1.getAllIncludedEdges());
			assertNotNull(layer2.getAllIncludedEdges());
			assertNotNull(layer3.getAllIncludedEdges());
			assertNotNull(layer4.getAllIncludedEdges());
			
			assertEquals(1, layer4.getAllIncludedEdges().size());
			assertTrue(layer4.getAllIncludedEdges().contains(e4));
			
			assertEquals(1, layer3.getAllIncludedEdges().size());
			assertTrue(layer3.getAllIncludedEdges().contains(e3));
			
			assertEquals(3, layer2.getAllIncludedEdges().size());
			assertTrue(layer2.getAllIncludedEdges().contains(e4));
			assertTrue(layer2.getAllIncludedEdges().contains(e21));
			assertTrue(layer2.getAllIncludedEdges().contains(e22));
			
			assertEquals(5, layer1.getAllIncludedEdges().size());
			assertTrue(layer1.getAllIncludedEdges().contains(e4));
			assertTrue(layer1.getAllIncludedEdges().contains(e3));
			assertTrue(layer1.getAllIncludedEdges().contains(e21));
			assertTrue(layer1.getAllIncludedEdges().contains(e22));
			assertTrue(layer1.getAllIncludedEdges().contains(e1));
		}//check node containment
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getId() <em>Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getId()
	 */
	public void testGetId() 
	{
		String id= null;
		
		{//shall not add an empty id
			try {
				this.getFixture().setId(id);
				fail("Shall not set the id to null.");
			} catch (GraphException e) {}
		}//shall not add an empty id
				
		{//add correct id
			id= "id";
			this.getFixture().setId(id);
			assertEquals(id, this.getFixture().getId());
		}//add correct id
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#setId(java.lang.String) <em>Id</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#setId(java.lang.String)
	 */
	public void testSetId() 
	{
		assertNull(this.getFixture().getId());
	}
	
	public void testGetGraph()
	{
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		
		assertNull(this.getFixture().getGraph());
		this.getFixture().setGraph(graph);
		assertEquals(graph, this.getFixture().getGraph());
		graph= null;
		this.getFixture().setGraph(graph);
		assertEquals(graph, this.getFixture().getGraph());
	}
	
	public void testEquals()
	{
		assertFalse(this.getFixture().equals(null));
		
		Layer newLayer= GraphFactory.eINSTANCE.createLayer();
		
		{//label
			Label label1= GraphFactory.eINSTANCE.createLabel();
			label1.setName("labelName");
			this.getFixture().addLabel(label1);
			Label label2= GraphFactory.eINSTANCE.createLabel();
			label2.setName("labelName");
			newLayer.addLabel(label2);
		}//label	
		
		{//node
			Node node= GraphFactory.eINSTANCE.createNode();
			this.getFixture().getNodes().add(node);
			newLayer.getNodes().add(node);
		}//node	
		
		{//edge
			Edge edge= GraphFactory.eINSTANCE.createEdge();
			this.getFixture().getEdges().add(edge);
			newLayer.getEdges().add(edge);
		}//edge	
		assertEquals(this.getFixture(), newLayer);
	}
} //LayerTest
