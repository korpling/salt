package de.hu_berlin.u.saltnpepper.salt.core.impl;

import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.impl.NodeImpl;
import de.hu_berlin.u.saltnpepper.salt.SDATATYPE;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.util.SAnnotatableElementHelper;

@SuppressWarnings("serial")
public class SNodeImpl extends NodeImpl implements SNode {

	@Override
	public <A extends SAnnotation> Set<A> getAnnotations() {
		return(SAnnotatableElementHelper.getAnnotations(this));
	}

	@Override
	public void addSAnnotation(SAnnotation annotation) {
		SAnnotatableElementHelper.addSAnnotation(this, annotation);
	}

	/** {@inheritDoc} **/
	@Override
	public SAnnotation getAnnotation(String qName) {
		return(SAnnotatableElementHelper.getSAnnotation(this, qName));
	}

	@Override
	public SAnnotation createAnnotation(String namespace, String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SAnnotation createAnnotation(String namespace, String name, String valueString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<SAnnotation> createAnnotations(String annotationString) {
		return(SAnnotatableElementHelper.createAnnotations(this, annotationString));
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
}
