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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;

public class GraphModule 
{
	/**
	 * The graph, which shall be traversed.
	 */
	private Graph graph= null;

	/**
	 * Sets the current graph to work on.
	 * @param graph graph to traverse
	 */
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	/**
	 * Returns the current graph to work on.
	 * @return the current graph
	 */
	public Graph getGraph() {
		return graph;
	}
}
