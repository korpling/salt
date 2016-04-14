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
import org.corpus_tools.salt.graph.Relation;

public interface SRelation<S extends SNode, T extends SNode> extends SAnnotationContainer, SNamedElement, STypedElement, SPathElement {

	/**
	 * Returns all layers containing this relation. This is a computed set and
	 * only works, when this relation is contained in a graph. If this list is
	 * used multiple times, it makes sense to store that set.
	 * 
	 * @return a set of layers containing this relation
	 */
	public Set<SLayer> getLayers();
	
	/**
	 * Returns the source node of this relation object.
	 * 
	 * @return source node
	 */
	public S getSource();

	/**
	 * Returns the source node of this relation object. If this relation belongs
	 * to a graph, the graph's indexes will be updated automatically.
	 * 
	 * @param source
	 *            source node
	 */
	public void setSource(S source);

	/**
	 * Returns the target node of this relation object.
	 * 
	 * @return target node
	 */
	public T getTarget();

	/**
	 * Sets the target node of this relation object. If this relation belongs to
	 * a graph, the graph's indexes will be updated automatically.
	 * 
	 * @param target
	 *            target node
	 */
	public void setTarget(T target);

	/**
	 * Returns the container graph of this relation.
	 * 
	 * @return graph object which contains this relation.
	 */
	public SGraph getGraph();

	/**
	 * Sets the container graph of this relation.
	 * 
	 * @param graph
	 *            object which contains this relation.
	 */
	/**
	 * Sets the container graph of this relation. The passed graph and this
	 * relation will be double chained, which means the method
	 * {@link Graph#getRelations()} will return a list containing this relation.
	 * 
	 * @param graph
	 *            graph which contains this relation
	 */
	public void setGraph(SGraph graph);

	/**
	 * Adds this relation to the passed layer. If this relation is not already
	 * contained in the layer's graph, it will be added to the graph.
	 * 
	 * @param layer
	 *            to which this node should be added
	 */
	public void addLayer(SLayer layer);

	/**
	 * Removes this relation from the passed layer.
	 * 
	 * @param layer
	 *            from which this node should be removed
	 */
	public void removeLayer(SLayer layer);
}
