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

import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.common.STimelineRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.graph.Relation;

@SuppressWarnings("serial")
public class STimelineRelationImpl extends SSequentialRelationImpl<SToken, STimeline, Integer> implements STimelineRelation {
	/** Initializes an object of type {@link STimelineRelationImpl}. **/
	public STimelineRelationImpl() {
		this(null);
	}

	/**
	 * Initializes an object of type {@link STimelineRelationImpl}. If
	 * {@link #delegate} is not null, all functions of this method are delegated
	 * to the delegate object. Setting {@link #delegate} makes this object to a
	 * container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public STimelineRelationImpl(Relation<SToken, STimeline> delegate) {
		super(delegate, SToken.class, STimeline.class, Integer.class);
	}


} // STimelineRelationImpl
