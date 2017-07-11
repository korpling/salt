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

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.graph.IdentifiableElement;

/**
 * This Exception is thrown when an element ({@link SNode}, {@link SRelation} or
 * {@link SLayer}) is not contained in a graph, but a method which is called
 * needs that element to be in the graph.
 * 
 * @author florian
 */
@SuppressWarnings("serial")
public class SaltElementNotInGraphException extends SaltException {

	private static String createMsg(SGraph graph, IdentifiableElement element) {
		return ("The passed element '" + element.getId() + "' is not contained in the graph '" + graph.getId() + "'. ");
	}

	public SaltElementNotInGraphException(SGraph graph, IdentifiableElement element, String s) {
		this(graph, element, s, null);
	}

	public SaltElementNotInGraphException(SGraph graph, IdentifiableElement element, String s, Throwable ex) {
		super(createMsg(graph, element) + s, ex);
	}
}
