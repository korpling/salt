package de.hu_berlin.u.saltnpepper.graph.impl;

import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.NamedElement;

public class LayerImpl extends IdentifiableElementImpl implements Layer, NamedElement{
	private List<NodeImpl> nodes= null;
	private List<EdgeImpl> edges= null;
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
}
