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

public interface SimpleTraverseHandler {
	/**
	 * This method is invoked, when a node is reached. When the graph should be
	 * traversed any further, the method must return true.
	 * 
	 * @param traversalLocation
	 *            contains current node and the node which was reached before
	 *            and other information.
	 * @return should be true as long as the traversal should go on
	 */
	public boolean nodeReached(TraversalLocation traversalLocation);
}
