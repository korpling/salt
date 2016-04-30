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
import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.core.impl.SLayerImpl;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Node;

@SuppressWarnings("serial")
public class STimelineImpl extends SSequentialDSImpl<Integer, Integer> implements STimeline {
	/** Initializes an object of type {@link SLayerImpl}. **/
	public STimelineImpl() {
	}

	/**
	 * Initializes an object of type {@link SLayerImpl}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public STimelineImpl(Node delegate) {
		super(delegate);
	}

	/** {@inheritDoc} **/
	@Override
	public SDocumentGraph getGraph() {
		return ((SDocumentGraph) super.getGraph());
	}

	/** {@inheritDoc} **/
	@Override
	public void setGraph(@SuppressWarnings("rawtypes") Graph graph) {
		if (!(graph instanceof SDocumentGraph)) {
			throw new SaltParameterException("graph", "setGrah", getClass(), "The parameter was not of type SDocumentGraph. ");
		}
		super.setGraph(graph);
	}

	/** {@inheritDoc} **/
	@Override
	public void increasePointOfTime() {
		increasePointOfTime(1);
	}

	/** {@inheritDoc} **/
	@Override
	public void increasePointOfTime(Integer additionalPOS) {
		Integer pos = getData();
		if (pos == null) {
			pos = additionalPOS;
		} else {
			pos = pos + additionalPOS;
		}
		setData(pos);
	}

	/** {@inheritDoc} **/
	@Override
	public Integer getStart() {
		if (getData() != null) {
			return (0);
		} else {
			return (null);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public Integer getEnd() {
		if (getData() != null) {
			return (getData());
		} else {
			return (null);
		}
	}
} // STimelineImpl
