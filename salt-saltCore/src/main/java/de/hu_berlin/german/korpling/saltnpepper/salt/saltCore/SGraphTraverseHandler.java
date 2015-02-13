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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

/**
 * The interface of a callback handler for traversing a {@link Graph} object. When invoking the method 
 * {@link Graph#traverse(org.eclipse.emf.common.util.EList, GRAPH_TRAVERSE_TYPE, String, GraphTraverseHandler)} an object
 * implementing this interface must be passed. This interface contains three methods {@link #checkConstraint(GRAPH_TRAVERSE_TYPE, String, SRelation, SNode, long)},
 * {@link #nodeReached(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)} and {@link #nodeLeft(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)}.
 * If the traversal reaches a new {@link Node} object being contained in the {@link Graph} object, the method
 * {@link #checkConstraint(GRAPH_TRAVERSE_TYPE, String, Edge, Node, long)} will be invoked. If this method returns true, it means
 * that this node and eventually its sub-graph will also be traversed. When true is returned, the method {@link #nodeReached(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)}
 * will be invoked, when reaching the node and {@link #nodeLeft(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)} when leaving
 * the node. 
 * 
 * @author Florian Zipser
 *
 */
public interface SGraphTraverseHandler {
	
	/**
	 * This method will be invoked, when a node is reached, after the method {@link #checkConstraint(GRAPH_TRAVERSE_TYPE, String, SRelation, SNode, long)}
	 * has returned true and before the method {@link #nodeLeft(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)} 
	 * is invoked.
	 * @param traversalType the type of current traversal
	 * @param traversalId the id of current traversal, given by the invoking object
	 * @param currNode the current node
	 * @param edge the edge via which the current node was reached
	 * @param fromNode the parent node 
	 * @param order the number of the edge in the parent node
	 */
	public void nodeReached(	GRAPH_TRAVERSE_TYPE traversalType, 
								String traversalId,
								SNode currNode, 
								SRelation sRelation, 
								SNode fromNode, 
								long order);

	/**
	 * This method will be invoked, when a node is left, after the method {@link #checkConstraint(GRAPH_TRAVERSE_TYPE, String, SRelation, SNode, long)}
	 * has returned true and the method {@link #nodeReached(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)} 
	 * has been invoked.
	 * @param traversalType the type of current traversal
	 * @param traversalId the id of current traversal, given by the invoking object
	 * @param currNode the current node
	 * @param edge the edge via which the current node was reached
	 * @param fromNode the parent node 
	 * @param order the number of the edge in the parent node
	 */
	public void nodeLeft(	GRAPH_TRAVERSE_TYPE traversalType, 
							String traversalId,
							SNode currNode, 
							SRelation edge, 
							SNode fromNode, 
							long order);

	/**
	 * This method is called during a traversal to check if the current node and eventually its sub-graph shall 
	 * be traversed or not. If the return value is false, the traversion for the current path, will stop at the
	 * current node and the methods {@link #nodeReached(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)} and
	 * {@link #nodeLeft(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)} as well will not be invoked. Otherwise
	 * the method {@link #nodeReached(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)} will be invoked, when
	 * a new node is reached and {@link #nodeLeft(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)} will  be 
	 * invoked, when this node is left.
	 * @param traversalType the type of current traversal
	 * @param traversalId the id of current traversal, given by the invoking object
	 * @param edge the edge via which the current node was reached
	 * @param currNode the current node
	 * @param order the number of the edge in the parent node
	 */
	public boolean checkConstraint(		GRAPH_TRAVERSE_TYPE traversalType, 
										String traversalId,
										SRelation edge, 
										SNode currNode, 
										long order);
}
