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

import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.IdentifiableElement;
import org.corpus_tools.salt.graph.Identifier;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.util.SaltUtil;

@SuppressWarnings("serial")
public abstract class IdentifiableElementImpl extends LabelableElementImpl implements IdentifiableElement {

	public IdentifiableElementImpl() {
		super();
	}

	public IdentifiableElementImpl(IdentifiableElement delegate) {
		super(delegate);
	}

	/** {@inheritDoc} **/
	@Override
	protected IdentifiableElement getDelegate() {
		return ((IdentifiableElement) super.getDelegate());
	}

	/** internal ref to the {@link Identifier} label **/
	private Identifier identifier = null;

	/** {@inheritDoc IdentifiableElement#getIdentifier()} **/
	@Override
	public Identifier getIdentifier() {
		if (getDelegate() != null) {
			return (getDelegate().getIdentifier());
		}
		return (identifier);
	}

	/** {@inheritDoc IdentifiableElement#setIdentifier(Identifier)} **/
	@Override
	public void setIdentifier(Identifier identifier) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().setIdentifier(identifier);
			return;
		}

		if (identifier != null) {
			if (getIdentifier() != null) {
				removeLabel(SaltUtil.SALT_NAMESPACE, SaltUtil.LABEL_ID);
			}
			this.identifier = identifier;
			addLabel(identifier);
		}
	}

	/**
	 * {@inheritDoc} In case the passed qualified name is equal to
	 * {@link SaltUtil#LABEL_ID_QNAME} the internal reference to
	 * {@link #identifier} is set to null.
	 **/
	@Override
	public void removeLabel(String qName) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().removeLabel(qName);
			return;
		}

		if (SaltUtil.LABEL_ID_QNAME.equals(qName)) {
			identifier = null;
		}
		super.removeLabel(qName);
	}

	/** {@inheritDoc IdentifiableElement#getId()} **/
	@Override
	public String getId() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getId();
		}

		if (getIdentifier() != null) {
			return (getIdentifier().getId());
		} else {
			return (null);
		}
	}

	/** {@inheritDoc IdentifiableElement#setId(String)} **/
	@Override
	public void setId(String id) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().setId(id);
			return;
		}

		if ((id != null) && (!id.isEmpty())) {
			GraphFactory.createIdentifier(this, id);
		}
	}

	@Override
	public String toString() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().toString();
		}

		StringBuilder str = new StringBuilder();
		str.append(getClass().getSimpleName());
		str.append("(");
		str.append(getId());
		str.append(")");
		if ((getLabels() != null) && (getLabels().size() > 0)) {
			str.append("[");
			boolean isFirst = true;
			for (Label label : getLabels()) {
				if (!(label instanceof Identifier)) {
					if (isFirst) {
						isFirst = false;
					} else {
						str.append(", ");
					}
					str.append(label);
				}
				str.append("]");
			}
		}
		return (str.toString());
	}
}
