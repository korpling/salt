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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphModule;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import junit.framework.TestCase;

public class GraphModuleTest extends TestCase 
{

	private GraphModule fixture= null;

	public void setFixture(GraphModule fixture) {
		this.fixture = fixture;
	}

	public GraphModule getFixture() {
		return fixture;
	} 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception 
	{
		setFixture(new GraphModule());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	/**
	 */
	public void testGetGraph() 
	{
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		this.getFixture().setGraph(graph);
		assertEquals(graph, this.getFixture().getGraph());
	}
}
