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
import org.corpus_tools.salt.semantics.SPOSAnnotation;
import org.corpus_tools.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class SPOSAnnotationImpl extends SAnnotationImpl implements SPOSAnnotation {
	public SPOSAnnotationImpl() {
		super.setNamespace(SaltUtil.SALT_NAMESPACE);
		super.setName(SaltUtil.SEMANTICS_POS);
	}

	/** Calling this method has no effect. **/
	@Override
	public void setName(String name) {
	}

	/** Calling this method has no effect. **/
	@Override
	public void setNamespace(String namespace) {
	}
} // SPOSAnnotationImpl
