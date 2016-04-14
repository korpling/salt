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
package org.corpus_tools.salt.core;

import java.util.Set;

import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Layer;

public interface SLayer extends SAnnotationContainer, SNamedElement {
	
	/**
	 * Returns the container graph of this node.
	 * 
	 * @return graph object which contains this node.
	 */
	public SGraph getGraph();

	/**
	 * Sets the container graph of this node. For double chaining between this
	 * {@link Layer} and the passed {@link Graph} object, the real insertion is
	 * done by method {@link #basicSetGraph(Graph)}.
	 * 
	 * @param graph
	 *            graph which contains this layer
	 */
	public void setGraph(SGraph graph);

	/**
	 * Adds the passed node to this layer. The insertion order is preserved. If
	 * this layer is contained by a graph, the passed node is also added to the
	 * graph in case it was not already contained in the graph.
	 * 
	 * @param node
	 *            node to be inserted into this layer
	 */
	public void addNode(SNode node);

	/**
	 * Removes the passed node from this layer. If the passed relation is null,
	 * nothing is done.
	 * 
	 * @param node
	 *            to be removed
	 */
	public void removeNode(SNode node);

	/**
	 * Returns a set of all contained nodes, in the order how the nodes were
	 * inserted.
	 * 
	 * @return all contained nodes
	 */
	public Set<SNode> getNodes();

	/**
	 * Adds the passed relation to this layer. The insertion order is preserved.
	 * If this layer is contained by a graph, the passed relation is also added
	 * to the graph in case it was not already contained in the graph.
	 * 
	 * @param relation
	 *            relation to be inserted into this layer
	 */
	public void addRelation(SRelation<? extends SNode, ? extends SNode> relation);

	/**
	 * Removes the passed relation from this layer. If the passed relation is
	 * null, nothing is done.
	 * 
	 * @param relation
	 *            to be removed
	 */
	public void removeRelation(SRelation<? extends SNode, ? extends SNode> relation);

	/**
	 * Returns a set of all contained relations, in the order how the relations
	 * were inserted.
	 * 
	 * @return all contained relations
	 */
	public Set<SRelation<? extends SNode, ? extends SNode>> getRelations();

}
