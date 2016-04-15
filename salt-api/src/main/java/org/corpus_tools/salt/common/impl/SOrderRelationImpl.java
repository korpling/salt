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
package org.corpus_tools.salt.common.impl;

import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SOrderRelation;
import org.corpus_tools.salt.common.SStructuredNode;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.impl.SRelationImpl;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Relation;

/**
 * This class provides {@link SOrderRelation}, to determine the order of
 * {@link SNode}s. Means creating a path through nodes on "same level", to
 * identify, that one nodes comes before another one, when it is not computable
 * from the datasources.
 * 
 * @author florian
 */
@SuppressWarnings("serial")
public class SOrderRelationImpl extends SRelationImpl<SStructuredNode, SStructuredNode> implements SOrderRelation {
	/** Initializes an object of type {@link SOrderRelationImpl}. **/
	public SOrderRelationImpl() {
	}

	/**
	 * Initializes an object of type {@link SOrderRelationImpl}. If
	 * {@link #delegate} is not null, all functions of this method are delegated
	 * to the delegate object. Setting {@link #delegate} makes this object to a
	 * container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SOrderRelationImpl(Relation delegate) {
		super(delegate);
	}

	/** {@inheritDoc} **/
	@Override
	public SDocumentGraph getGraph() {
		return ((SDocumentGraph) super.getGraph());
	}

} // SOrderRelationImpl
