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

import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.impl.SLayerImpl;
import org.corpus_tools.salt.core.impl.SNodeImpl;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;

@SuppressWarnings("serial")
public class SCorpusImpl extends SNodeImpl implements SCorpus {
	/** Initializes an object of type {@link SLayerImpl}. **/
	public SCorpusImpl() {
	}

	/**
	 * Initializes an object of type {@link SLayerImpl}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SCorpusImpl(Node delegate) {
		super(delegate);
	}
	
	/** {@inheritDoc} **/
	@Override
	public SCorpusGraph getGraph() {
		SGraph superGraph = super.getGraph();

		if (superGraph == null) {
			return null;
		}

		if (superGraph instanceof SCorpusGraph) {
			return (SCorpusGraph) superGraph;
		}

		throw new SaltInvalidModelException("Graph implementation is not of type SCorpusGraph (actual type is " + superGraph.getClass().getName() + ")");
	}
}
