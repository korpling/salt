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
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.SStructuredNode;
import org.corpus_tools.salt.core.impl.SRelationImpl;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;

@SuppressWarnings("serial")
public class SDominanceRelationImpl extends SRelationImpl<SStructure, SStructuredNode> implements SDominanceRelation {
	/** Initializes an object of type {@link SDominanceRelationImpl}. **/
	public SDominanceRelationImpl() {
		this(null);
	}

	/**
	 * Initializes an object of type {@link SDominanceRelationImpl}. If
	 * {@link #delegate} is not null, all functions of this method are delegated
	 * to the delegate object. Setting {@link #delegate} makes this object to a
	 * container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SDominanceRelationImpl(Relation<SStructure, SStructuredNode> delegate) {
		super(delegate, SStructure.class, SStructuredNode.class);
	}

	/** {@inheritDoc} **/
	@Override
	public SDocumentGraph getGraph() {
		return ((SDocumentGraph) super.getGraph());
	}
	
	@Override
	protected void basicSetGraph(Graph<? extends Node, ?, ?> graph) {
		if(graph != null && getDelegate() == null && !(graph instanceof SDocumentGraph)) {
			throw new SaltParameterException("graph", "basicSetGraph", getClass(), "Must be of type SDocumentGraph.");
		}
		super.basicSetGraph(graph);
	}

} // SDominanceRelationImpl
