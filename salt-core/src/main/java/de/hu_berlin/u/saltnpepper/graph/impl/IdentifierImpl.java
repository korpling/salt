package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;

public class IdentifierImpl extends LabelImpl<String> implements Identifier{

	/** {@inheritDoc Identifier#getId()}**/
	@Override
	public String getId() {
		return(getValue());
	}
	/** {@inheritDoc Identifier#setId(String)}**/
	@Override
	public void setId(String value) {
		setValue(value);
	}
	
	private IdentifiableElement container= null;
	/** {@inheritDoc Identifier#getIdentifiableElement()}**/
	@Override
	public IdentifiableElement getIdentifiableElement() {
		return(container);
	}
	/** {@inheritDoc Identifier#setIdentifiableElement(IdentifiableElement))}**/
	@Override
	public void setIdentifiableElement(IdentifiableElement container) {
		this.container= container;
	}
}
