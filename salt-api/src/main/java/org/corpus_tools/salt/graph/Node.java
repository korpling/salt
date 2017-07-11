/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
 * In graph theory a node is a placeholder, which can be related with other
 * nodes via an relation.
 * 
 * The here defined node, is a labeled node, which means, it can contain a set
 * of {@link Label}s. Am node always belong to 0..1 {@link Graph}s and can also
 * be contained in one or more {@link Layer}s.
 * 
 * @author florian
 *
 */
public interface Node extends IdentifiableElement {
	/**
	 * Returns the container graph of this node.
	 * 
	 * @return graph object which contains this node.
	 */
	public Graph getGraph();

	/**
	 * Sets the container graph of this node. The passed graph and this node
	 * will be double chained, which means the method {@link Graph#getNodes()}
	 * will return a list containing this node.
	 * 
	 * @param graph
	 *            graph which contains this node
	 */
	public void setGraph(Graph graph);

	/**
	 * Returns all layers containing this node. This is a computed set and only
	 * works, when this node is contained in a graph. If this list is used
	 * multiple times, it makes sense to store that set.
	 * 
	 * @return a set of layers containing this node
	 */
	public Set<? extends Layer> getLayers();

	/**
	 * Adds this node to the passed layer. If this node is not already contained
	 * in the layer's graph, it will be added to the graph.
	 * 
	 * @param layer
	 *            to which this node should be added
	 */
	public void addLayer(Layer layer);

	/**
	 * Removes this node from the passed layer.
	 * 
	 * @param layer
	 *            from which this node should be removed
	 */
	public void removeLayer(Layer layer);
}
