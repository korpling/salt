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
 * In graph theory an relation is a relation between two nodes, often an
 * relation is realized as a pair of nodes.
 * 
 * This interface defines a directed and labeled relation. A directed relation
 * is a not symmetric relation. For instance if an relation relates a node
 * <i>a</i> with a node <i>b</i>, it is not the case for the way around. A
 * labeled relation is an relation, which can contain labels as defined in
 * {@link Label}. An relation always belong to 0..1 {@link Graph}s and can also
 * be contained in one or more {@link Layer} s.
 * 
 * @author florian
 *
 * @param <S>
 *            source node of the relation
 * @param <T>
 *            target node of the relation
 */
public interface Relation<S extends Node, T extends Node> extends IdentifiableElement {

	/**
	 * Returns the delegate object. If {@link #delegate} is not null, all
	 * functions of this method are delegated to the delegate object. Setting
	 * {@link #delegate} makes this object to a container.
	 * 
	 * @return the delegate object
	 */
	public Relation<S, T> getDelegate();

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
	public Graph getGraph();


	/**
	 * Returns all layers containing this relation. This is a computed set and
	 * only works, when this relation is contained in a graph. If this list is
	 * used multiple times, it makes sense to store that set.
	 * 
	 * @return a set of layers containing this relation
	 */
	public Set<? extends Layer> getLayers();

}
