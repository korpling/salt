package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public abstract class IdentifiableElementImpl extends LabelableElementImpl implements IdentifiableElement {

	public IdentifiableElementImpl() {
		super();
	}

	public IdentifiableElementImpl(IdentifiableElement delegatee) {
		super(delegatee);
	}

	/** {@inheritDoc} **/
	@Override
	protected IdentifiableElement getDelegate() {
		return ((IdentifiableElement) delegate);
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
		if (getDelegate() != null) {
			getDelegate().setIdentifier(identifier);
		} else {
			if (identifier != null) {
				// if element already has an identifier, remove old identifier
				if (getIdentifier() != null) {
					removeLabel(SaltUtil.SALT_NAMESPACE, SaltUtil.LABEL_ID);
				}
				this.identifier = identifier;
				addLabel(identifier);
			}
		}
	}

	/**
	 * {@inheritDoc} In case the passed qualified name is equal to
	 * {@link SaltUtil#LABEL_ID_QNAME} the internal reference to
	 * {@link #identifier} is set to null.
	 **/
	@Override
	public void removeLabel(String qName) {
		if (getDelegate() != null) {
			getDelegate().setIdentifier(identifier);
		} else {
			if (SaltUtil.LABEL_ID_QNAME.equals(qName)) {
				identifier = null;
			}
			super.removeLabel(qName);
		}
	}

	/** {@inheritDoc IdentifiableElement#getId()} **/
	@Override
	public String getId() {
		if (getDelegate() != null) {
			return (getDelegate().getId());
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
		if (getDelegate() != null) {
			getDelegate().setId(id);
		} else {
			if ((id != null) && (!id.isEmpty())) {
				// creates a new identifier and adds it to this objects
				GraphFactory.createIdentifier(this, id);
			}
		}
	}

	@Override
	public String toString() {
		if (getDelegate() != null) {
			return (delegate.toString());
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
