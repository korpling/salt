package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;

public class IdentifiableElementImpl extends LabelableElementImpl implements IdentifiableElement {
	
	/** internal ref to the {@link Identifier} label **/
	private Identifier identifier= null;
	/** {@inheritDoc IdentifiableElement#getIdentifier()}**/
	@Override
	public Identifier getIdentifier() {
		return(identifier);
	}

	@Override
	public void setIdentifier(Identifier value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(String value) {
		// TODO Auto-generated method stub
		
	}

	

}
