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
package org.corpus_tools.salt.graph;

import java.util.Set;

/**
 * A layer is a grouping mechanism for nodes and relations, and can also contain
 * further layers (called sub layers). The containment relation implements a
 * recursive structure for layers, to build hierarchies. In general this
 * mechanism enables the creation of sub graphs. But note that a layer cannot be
 * contained by itself, so cycles of layers are not possible.
 * 
 * @author florian
 *
 */
public interface Layer <N,R> 
	extends IdentifiableElement {

	/**
	 * Returns the container graph of this node.
	 * 
	 * @return graph object which contains this node.
	 */
	public Graph getGraph();

	/**
	 * Sets the container graph of this node. For double chaining between this
	 * {@link Layer} and the passed {@link Graph} object, the real insertion is
	 * done by method {@link #basicSetGraph(Graph)}.
	 * 
	 * @param graph
	 *            graph which contains this layer
	 */
	public void setGraph(Graph graph);

	/**
	 * Adds the passed node to this layer. The insertion order is preserved. If
	 * this layer is contained by a graph, the passed node is also added to the
	 * graph in case it was not already contained in the graph.
	 * 
	 * @param node
	 *            node to be inserted into this layer
	 */
	public void addNode(N node);

	/**
	 * Removes the passed node from this layer. If the passed relation is null,
	 * nothing is done.
	 * 
	 * @param node
	 *            to be removed
	 */
	public void removeNode(N node);

	/**
	 * Returns a set of all contained nodes, in the order how the nodes were
	 * inserted.
	 * 
	 * @return all contained nodes
	 */
	public Set<N> getNodes();

	/**
	 * Adds the passed relation to this layer. The insertion order is preserved.
	 * If this layer is contained by a graph, the passed relation is also added
	 * to the graph in case it was not already contained in the graph.
	 * 
	 * @param relation
	 *            relation to be inserted into this layer
	 */
	public void addRelation(R relation);

	/**
	 * Removes the passed relation from this layer. If the passed relation is
	 * null, nothing is done.
	 * 
	 * @param relation
	 *            to be removed
	 */
	public void removeRelation(R relation);

	/**
	 * Returns a set of all contained relations, in the order how the relations
	 * were inserted.
	 * 
	 * @return all contained relations
	 */
	public Set<R> getRelations();
}
