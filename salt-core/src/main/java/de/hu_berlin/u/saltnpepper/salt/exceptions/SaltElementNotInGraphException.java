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
package de.hu_berlin.u.saltnpepper.salt.exceptions;

import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;

/**
 * This Exception is thrown when an element ({@link SNode}, {@link SRelation} or
 * {@link SLayer}) is not contained in a graph, but a method which is called
 * needs that element to be in the graph.
 * 
 * @author florian
 */
@SuppressWarnings("serial")
public class SaltElementNotInGraphException extends SaltException {

	public SaltElementNotInGraphException() {
		super();
	}

	public SaltElementNotInGraphException(String s) {
		super(s);
	}

	public SaltElementNotInGraphException(String s, Throwable ex) {
		super(s, ex);
	}
}
