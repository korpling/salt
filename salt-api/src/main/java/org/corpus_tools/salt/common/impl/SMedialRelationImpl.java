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

import org.corpus_tools.salt.common.SMedialDS;
import org.corpus_tools.salt.common.SMedialRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.graph.Relation;

@SuppressWarnings("serial")
public class SMedialRelationImpl extends SSequentialRelationImpl<SToken, SMedialDS, Double> implements SMedialRelation {
	/** Initializes an object of type {@link SMedialRelationImpl}. **/
	public SMedialRelationImpl() {
		this(null);
	}

	/**
	 * Initializes an object of type {@link SMedialRelationImpl}. If
	 * {@link #delegate} is not null, all functions of this method are delegated
	 * to the delegate object. Setting {@link #delegate} makes this object to a
	 * container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SMedialRelationImpl(Relation<SToken, SMedialDS> delegate) {
		super(delegate, SToken.class, SMedialDS.class);
	}

} // SAudioDSRelationImpl
