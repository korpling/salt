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
import org.corpus_tools.salt.common.SCorpusDocumentRelation;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.core.impl.SRelationImpl;
import org.corpus_tools.salt.graph.Relation;

@SuppressWarnings("serial")
public class SCorpusDocumentRelationImpl extends SRelationImpl<SCorpus, SDocument> implements SCorpusDocumentRelation {
	/** Initializes an object of type {@link SCorpusDocumentRelationImpl}. **/
	public SCorpusDocumentRelationImpl() {
		this(null);
	}

	/**
	 * Initializes an object of type {@link SCorpusDocumentRelationImpl}. If
	 * {@link #delegate} is not null, all functions of this method are delegated
	 * to the delegate object. Setting {@link #delegate} makes this object to a
	 * container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SCorpusDocumentRelationImpl(Relation<SCorpus, SDocument> delegate) {
		super(delegate, SCorpus.class, SDocument.class);
	}
} // SCorpusDocumentRelationImpl
