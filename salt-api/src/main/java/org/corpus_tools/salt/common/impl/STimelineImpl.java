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
package org.corpus_tools.salt.common.impl;

import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.core.impl.SLayerImpl;
import org.corpus_tools.salt.graph.Node;

public class STimelineImpl extends SSequentialDSImpl<Integer, Integer> implements STimeline {
	private static final long serialVersionUID = -3323359309599746398L;

	/** Initializes an object of type {@link SLayerImpl}. **/
	public STimelineImpl() {
		this(null);
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
		super(delegate, Integer.class);
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
