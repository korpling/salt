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

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

/**
 * These tests checks if the resetting of an Id works fine including th eupdate of the indexes inside
 * the Graph object.
 */
public class IDTest extends TestCase
{
	
	protected Graph fixture= null;
	public void setFixture(Graph fixture) {
		this.fixture = fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IDTest.class);
	}

	/**
	 * Constructs a new Node test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Graph getFixture() {
		return (Graph)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * 
	 */
	protected void setUp() throws Exception 
	{
		setFixture(GraphFactory.eINSTANCE.createGraph());
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
	 * Checks if changing of Id for node also changes the indexing of graph.
	 */
	public void testResetId4Node()
	{
		//check node id
		Node node= GraphFactory.eINSTANCE.createNode();
		this.getFixture().getNodes().add(node);
		String nodeId= node.getId();
		assertEquals(node, this.getFixture().getNode(nodeId));
		//reset node id
		String newNodeId= "newNodeId1";
		node.setId(newNodeId);
		assertEquals(node, this.getFixture().getNode(newNodeId));
	}
	
	/**
	 * Checks if changing of Id for node also changes the indexing of graph. In this test a new IDentifier 
	 * will be set to Node object. 
	 */
	public void testResetId4Node_2()
	{
		//check node id
		Node node= GraphFactory.eINSTANCE.createNode();
		this.getFixture().addNode(node);
		String nodeId= node.getId();
		assertEquals(node, this.getFixture().getNode(nodeId));
		
		//reset node id
		Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
		identifier.setId("newNodeId1");
		node.setIdentifier(identifier);
		assertEquals(node, this.getFixture().getNode(identifier.getId()));	
	}
	
	/**
	 * Checks if changing of Id for edge also changes the indexing of graph.
	 */
	public void testResetId4Edge()
	{
		Node node= GraphFactory.eINSTANCE.createNode();
		this.getFixture().addNode(node);
		//check edge id
		Edge edge= GraphFactory.eINSTANCE.createEdge();
		edge.setSource(node);
		edge.setTarget(node);
		this.getFixture().addEdge(edge);
		String edgeId= edge.getId();
		assertEquals(edge, this.getFixture().getEdge(edgeId));
		//reset edge id
		String newEdgeId= "newEdgeId1";
		edge.setId(newEdgeId);
		assertEquals(edge, this.getFixture().getEdge(newEdgeId));
	}
	
	/**
	 * Checks if changing of Id for layer also changes the indexing of graph.
	 */
	public void testResetId4Layer()
	{
		//check layer id
		Layer layer= GraphFactory.eINSTANCE.createLayer();
		this.getFixture().addLayer(layer);
		String layerId= layer.getId();
		assertEquals(layer, this.getFixture().getLayer(layerId));
		//reset layer id
		String newLayerId= "newLayerId1";
		layer.setId(newLayerId);
		assertEquals(layer, this.getFixture().getLayer(newLayerId));
	}
}
