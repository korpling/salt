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
package org.corpus_tools.salt.exceptions;

import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;

/**
 * This exception is thrown, if one object could not be inserted into another
 * object. For instance if a {@link Node} can not be set to an {@link Relation}s
 * source or target, a {@link Relation} cannot be added to a {@link Graph} or a
 * {@link Label} cannot be added to a {@link Node} etc. .
 * 
 * @author Florian Zipser
 *
 */
@SuppressWarnings("serial")
public class SaltInsertionException extends java.lang.RuntimeException {

	/**
	 * Initializes an object of this exception class.
	 * 
	 * @param container
	 *            the container object, which could not insert the passed
	 *            object.
	 * @param object
	 *            the object to be inserted into the container
	 */
	public SaltInsertionException(Object container, Object object) {
		this(container, object, null);
	}

	/**
	 * Initializes an object of this exception class.
	 * 
	 * @param container
	 *            the container object, which could not insert the passed
	 *            object.
	 * @param object
	 *            the object to be inserted into the container
	 * @param msg
	 *            a message to be passed
	 */
	public SaltInsertionException(Object container, Object object, String msg) {
		this(container, object, msg, null);
	}

	/**
	 * Initializes an object of this exception class.
	 * 
	 * @param container
	 *            the container object, which could not insert the passed
	 *            object.
	 * @param object
	 *            the object to be inserted into the container
	 * @param msg
	 *            a message to be passed
	 * @param ex
	 *            a sub exception too be passed
	 */
	public SaltInsertionException(Object container, Object object, String msg, Throwable ex) {
		super("Cannot insert object '" + object + "' into container '" + container + "'. " + msg, ex);
	}
}
