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

import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.graph.Relation;

@SuppressWarnings("serial")
public class STextualRelationImpl extends SSequentialRelationImpl<SToken, STextualDS, Integer> implements STextualRelation {
	/** Initializes an object of type {@link STextualRelationImpl}. **/
	public STextualRelationImpl() {
		this(null);
	}

	/**
	 * Initializes an object of type {@link STextualRelationImpl}. If
	 * {@link #delegate} is not null, all functions of this method are delegated
	 * to the delegate object. Setting {@link #delegate} makes this object to a
	 * container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public STextualRelationImpl(Relation<SToken, STextualDS> delegate) {
		super(delegate, SToken.class, STextualDS.class, Integer.class);
	}


} // STextualRelationImpl
