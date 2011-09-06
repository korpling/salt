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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

import junit.framework.TestCase;

public class PerformanceTest extends TestCase 
{
	private Graph fixture= null;
	
	protected Graph getFixture() {
		return (Graph)fixture;
	}
	
	protected void setFixture(Graph fixture) {
		this.fixture = fixture;
	}
	
	protected void setUp() throws Exception {
		this.setFixture(GraphFactory.eINSTANCE.createGraph());
	}
	
	public void testPerformanceGetNodes()
	{
//		Integer[] runs= {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
//		for (int maxRuns: runs)
//		int initVal= 10000;
//		int maxVal= 100000;
//		int increase= 10000;
		int initVal= 100;
		int maxVal= 1001;
		int increase= 100;
		for (int maxRuns= initVal; maxRuns < maxVal; maxRuns= maxRuns+ increase)
		{	
			this.setFixture(GraphFactory.eINSTANCE.createGraph());
//			int maxRuns= 100000;
			String nodePrefix= "node";
			EList<Node> nodes= new BasicEList<Node>();
			//filling graph
			for (int i = 0; i < maxRuns; i++)
			{
				Node node= GraphFactory.eINSTANCE.createNode();
				node.setId(nodePrefix+ i);
				nodes.add(node);
				this.getFixture().addNode(node);
			}
			
			long scndTestSearch= System.currentTimeMillis();
			long neededTimeSearch= 0;
			//testing without using index
			for (Node node: nodes)
			{
				long timeStamp= System.currentTimeMillis();
				Node nodeFound= null;
				for (Node node2 : this.getFixture().getNodes())
				{
					if (node.getId().equalsIgnoreCase(node2.getId()))
					{
						nodeFound= node2;
						break;
					}
				}
				neededTimeSearch= neededTimeSearch + System.currentTimeMillis() - timeStamp;
				assertEquals(node, nodeFound);
			}
			scndTestSearch= System.currentTimeMillis() - scndTestSearch;
			
			//testing using index
			long scndTestIdx= System.currentTimeMillis();
			long neededTimeIdx= 0l;
			for (Node node: nodes)
			{
				long timeStamp= System.currentTimeMillis();
				Node nodeFound= this.getFixture().getNode(node.getId());
				neededTimeIdx= neededTimeIdx + System.currentTimeMillis() - timeStamp;
				assertEquals(node, nodeFound);
			}
			scndTestIdx= System.currentTimeMillis() - scndTestIdx;
		
			System.out.println("Needed time over all (number of runs: "+maxRuns+"):");
			System.out.println("\t with using idx:\t" +neededTimeIdx);
			System.out.println("\t controll value:\t" +scndTestIdx);
			System.out.println("\t without using idx:\t" +neededTimeSearch);
			System.out.println("\t controll value:\t" +scndTestSearch);
			
			System.out.println("Needed time per run ("+maxRuns+"):");
			System.out.println("\t with using idx:\t" +neededTimeIdx/ maxRuns);
			System.out.println("\t without using idx:\t" +neededTimeSearch / maxRuns);
		}
	}
}
