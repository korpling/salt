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
package org.corpus_tools.salt.semantics.impl;

import org.corpus_tools.salt.core.impl.SAnnotationImpl;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.semantics.SWordAnnotation;
import org.corpus_tools.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class SWordAnnotationImpl extends SAnnotationImpl implements SWordAnnotation {
	/** Initializes an object of type {@link SWordAnnotationImpl}. **/
	public SWordAnnotationImpl() {
		super.setNamespace(SaltUtil.SALT_NAMESPACE);
		super.setName(SaltUtil.SEMANTICS_UNIT);
		super.setValue(SaltUtil.SEMANTICS_WORD);
	}

	/**
	 * Initializes an object of type {@link SWordAnnotationImpl}. If
	 * {@link #delegate} is not null, all functions of this method are delegated
	 * to the delegate object. Setting {@link #delegate} makes this object to a
	 * container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SWordAnnotationImpl(Label delegate) {
		super(delegate);
		super.setNamespace(SaltUtil.SALT_NAMESPACE);
		super.setName(SaltUtil.SEMANTICS_UNIT);
		super.setValue(SaltUtil.SEMANTICS_WORD);
	}

	/** Calling this method has no effect. **/
	@Override
	public void setName(String name) {
	}

	/** Calling this method has no effect. **/
	@Override
	public void setNamespace(String namespace) {
	}

	/** Calling this method has no effect. **/
	@Override
	public void setValue(Object value) {
	}
} // SWordAnnotationImpl
