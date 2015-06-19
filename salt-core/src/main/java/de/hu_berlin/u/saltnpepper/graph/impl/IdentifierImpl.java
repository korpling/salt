package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;

public class IdentifierImpl extends LabelImpl<String> implements Identifier{

	public IdentifierImpl(IdentifiableElement container, String id) {
		this.container= container;
		this.value= id;
	}
	
	/** {@inheritDoc Identifier#setValue(String)}**/
	@Override
	public void setValue(String value) {
		
	}
	
	/** {@inheritDoc Identifier#getId()}**/
	@Override
	public String getId() {
		return(getValue());
	}
	
	private IdentifiableElement container= null;
	/** {@inheritDoc Identifier#getIdentifiableElement()}**/
	@Override
	public IdentifiableElement getIdentifiableElement() {
		return(container);
	}
}
