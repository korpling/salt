package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.util.GraphUtil;

public abstract class IdentifiableElementImpl extends LabelableElementImpl implements IdentifiableElement {

	private static final long serialVersionUID = 376684011595531725L;
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
			if (this.identifier != null) {
				removeLabel(GraphUtil.IDENTIFIER_NAME, GraphUtil.IDENTIFIER_NAMESPACE);
			}
			this.identifier = identifier;
			addLabel(identifier);
		}

	}

	/** {@inheritDoc IdentifiableElement#getId()} **/
	@Override
	public String getId() {
		return (getIdentifier().getId());
	}

	/** {@inheritDoc IdentifiableElement#setId(String)} **/
	@Override
	public void setId(String id) {
		if ((id != null) && (!id.isEmpty())) {
			Identifier identifier = GraphFactory.createIdentifier(this, id);
			setIdentifier(identifier);
		}
	}
}
