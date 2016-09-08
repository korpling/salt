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
package org.corpus_tools.salt.graph.impl;

import org.corpus_tools.salt.graph.IdentifiableElement;
import org.corpus_tools.salt.graph.Identifier;
import org.corpus_tools.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class IdentifierImpl extends LabelImpl implements Identifier {

	/**
	 * Instantiates an {@link IdentifierImpl} object and sets its passed
	 * container and id. Further sets its namespace to
	 * {@link SaltUtil#SALT_NAMESPACE} and its name to {@link SaltUtil#LABEL_ID}
	 * .
	 * 
	 * @param container
	 * @param id
	 */
	public IdentifierImpl(IdentifiableElement container, String id) {
		this.container = container;
		this.value = id;
		super.setNamespace(SaltUtil.SALT_NAMESPACE);
		super.setName(SaltUtil.LABEL_ID);
		if (container != null) {
			container.setIdentifier(this);
		}
	}

	/** Do nothing **/
	@Override
	public void setNamespace(String namespace) {
	}

	/** Do nothing **/
	@Override
	public void setName(String name) {
	}

	/** {@inheritDoc Identifier#setValue(String)} **/
	@Override
	public void setValue(String value) {
	}

	/** {@inheritDoc Identifier#getId()} **/
	@Override
	public String getId() {
		return (getValue().toString());
	}

	private IdentifiableElement container = null;

	/** {@inheritDoc Identifier#getIdentifiableElement()} **/
	@Override
	public IdentifiableElement getIdentifiableElement() {
		return (container);
	}
}
