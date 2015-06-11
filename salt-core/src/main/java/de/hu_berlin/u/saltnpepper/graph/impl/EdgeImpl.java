package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.Edge;


public class EdgeImpl extends IdentifiableElementImpl implements Edge, NamedElement{
	private NodeImpl source=null;
	public NodeImpl getSource() {
		return source;
	}
	public void setSource(NodeImpl source) {
		this.source = source;
	}
	private NodeImpl target=null;
	public NodeImpl getTarget() {
		return target;
	}
	public void setTarget(NodeImpl target) {
		this.target = target;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
}
