package de.hu_berlin.u.saltnpepper.salt.core.impl;

import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.impl.NodeImpl;
import de.hu_berlin.u.saltnpepper.salt.SDATATYPE;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;

@SuppressWarnings("serial")
public class SNodeImpl extends NodeImpl implements SNode {

	public SNodeImpl() {
		// TODO Auto-generated constructor stub
	}

	public SNodeImpl(Node delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<SAnnotation> getSAnnotations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSAnnotation(SAnnotation sAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SAnnotation getSAnnotation(String qName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SAnnotation createSAnnotation(String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SAnnotation createSAnnotation(String sNS, String sName, String sValueString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<SAnnotation> createSAnnotations(String annotationString) {
		// TODO Auto-generated method stub
		return null;
	}

}
