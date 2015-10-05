package org.corpus_tools.salt.graph.impl;

import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.IdentifiableElement;
import org.corpus_tools.salt.graph.Identifier;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.util.SaltUtil;

@SuppressWarnings("serial")
public abstract class IdentifiableElementImpl extends LabelableElementImpl implements IdentifiableElement {

	/** internal ref to the {@link Identifier} label **/
	private Identifier identifier = null;

	/** {@inheritDoc IdentifiableElement#getIdentifier()} **/
	@Override
	public Identifier getIdentifier() {
		return (identifier);
	}

	/** {@inheritDoc IdentifiableElement#setIdentifier(Identifier)} **/
	@Override
	public void setIdentifier(Identifier identifier) {
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
		if (SaltUtil.LABEL_ID_QNAME.equals(qName)) {
			identifier = null;
		}
		super.removeLabel(qName);
	}

	/** {@inheritDoc IdentifiableElement#getId()} **/
	@Override
	public String getId() {
		if (getIdentifier() != null) {
			return (getIdentifier().getId());
		} else {
			return (null);
		}
	}

	/** {@inheritDoc IdentifiableElement#setId(String)} **/
	@Override
	public void setId(String id) {
		if ((id != null) && (!id.isEmpty())) {
			GraphFactory.createIdentifier(this, id);
		}
	}

	@Override
	public String toString() {
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
