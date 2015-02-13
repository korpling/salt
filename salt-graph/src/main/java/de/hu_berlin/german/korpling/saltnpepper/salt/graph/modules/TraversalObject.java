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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser.GRAPH_TRAVERSE_MODE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
@Deprecated
public interface TraversalObject 
{
	/**
	 * Call back method to notify the listener of traversing.
	 * @param traversalMode
	 * @param traversalId - a unique id for one traversing process, the same id as for GraphTraverserObject
	 * @param currNode
	 * @param edge
	 * @param fromNode
	 * @param order
	 */
	public void nodeReached(	GRAPH_TRAVERSE_MODE traversalMode, 
								Long traversalId,
								Node currNode, 
								Edge edge, 
								Node fromNode, 
								long order);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	public void nodeLeft(	GRAPH_TRAVERSE_MODE traversalMode, 
							Long traversalId,
							Node currNode, 
							Edge edge, 
							Node fromNode, 
							long order);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	public boolean checkConstraint(		GRAPH_TRAVERSE_MODE traversalMode, 
										Long traversalId,
										Edge edge, 
										Node currNode, 
										long order);
}
