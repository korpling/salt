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
package org.corpus_tools.salt.util.traversal;

import org.corpus_tools.salt.util.traversal.internal.TraversalLocation;

/**
 * Using this traverse handler offers the possibility to observe the traversal
 * of the way forth and back again via {@link #nodeReachedOnWayForth(TraversalLocation)}
 * and {@link #nodeReachedOnWayBack(TraversalLocation)}. Further the method
 * {@link #shouldTraversalGoOn(TraversalLocation)} offers to check whether a node
 * shall be visited or not in advance. <br/>
 * The traverser calls the call-back handler in the following order:
 * <ol>
 * <li>{@link #shouldTraversalGoOn(TraversalLocation)}</li>
 * <li>{@link #nodeReachedOnWayForth(TraversalLocation)}</li>
 * <li>{@link #nodeReachedOnWayBack(TraversalLocation)}</li>
 * </ol>
 */
public interface BackAndForthTraverseHandler {
	/**
	 * This method is called during a traversal to check if the current node and
	 * eventually its sub-graph shall be traversed or not. If the return value
	 * is false, the traversal for the current path, will stop at the current
	 * node. Otherwise the method {@link #nodeReachedOnWayForth(TraversalLocation)} will
	 * be invoked, when a new node is reached and
	 * {@link #nodeReachedOnWayBack(TraversalLocation)} will be invoked, when this node is
	 * left.
	 * 
	 * @param location
	 *            contains current node and the node which was reached before
	 *            and other information.
	 */
	public boolean shouldTraversalGoOn(TraversalLocation location);

	/**
	 * This method will be invoked, when a node is reached, after the method
	 * {@link #shouldTraversalGoOn(TraversalLocation)} has returned true and before
	 * the method {@link #nodeReachedOnWayBack(TraversalLocation)} is invoked.
	 * 
	 * @param location
	 *            contains current node and the node which was reached before
	 *            and other information.
	 */
	public void nodeReachedOnWayForth(TraversalLocation location);

	/**
	 * This method will be invoked, when a node is left, after the method
	 * {@link #shouldTraversalGoOn(TraversalLocation)} has returned true and the
	 * method {@link #nodeReachedOnWayBack(TraversalLocation)} has been invoked.
	 * 
	 * @param location
	 *            contains current node and the node which was reached before
	 *            and other information.
	 */
	public void nodeReachedOnWayBack(TraversalLocation location);
}
