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
package org.corpus_tools.salt.core;

import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.graph.Node;

public interface SNode extends Node, SAnnotationContainer, SNamedElement, SPathElement {
	/**
	 * When this node belongs to a {@link SGraph}, a list of outgoing relations
	 * of this node are returned.
	 * 
	 * @return list of outgoing relations
	 */
	public List<SRelation<? extends SNode, ? extends SNode>> getOutRelations();

	/**
	 * When this node belongs to a {@link SGraph}, a list of incoming relations
	 * of this node are returned.
	 * 
	 * @return list of incoming relations
	 */
	public List<SRelation<? extends SNode, ? extends SNode>> getInRelations();

	/**
	 * Returns all layers containing this node. This is a computed set and only
	 * works, when this node is contained in a graph. If this list is used
	 * multiple times, it makes sense to store that set.
	 * 
	 * @return a set of layers containing this node
	 */
	@Override
	public Set<SLayer> getLayers();

	@Override
	public SGraph getGraph();
}
