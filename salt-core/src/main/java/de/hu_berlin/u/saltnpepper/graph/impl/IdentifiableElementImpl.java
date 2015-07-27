package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

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
				removeLabel(SaltUtil.IDENTIFIER_NAMESPACE, SaltUtil.IDENTIFIER_NAME);
			}
			this.identifier = identifier;
			addLabel(identifier);
		}
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
			Identifier identifier = GraphFactory.createIdentifier(this, id);
			setIdentifier(identifier);
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
			for (Label<?> label : getLabels()) {
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
