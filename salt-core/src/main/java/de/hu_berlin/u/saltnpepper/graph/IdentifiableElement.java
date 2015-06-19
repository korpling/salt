package de.hu_berlin.u.saltnpepper.graph;

public interface IdentifiableElement extends LabelableElement{
	public Identifier getIdentifier();
	
	public void setIdentifier(Identifier identifier);
}
