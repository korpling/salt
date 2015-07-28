package de.hu_berlin.u.saltnpepper.salt.core.impl;

import java.util.Iterator;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.impl.NodeImpl;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotationContainer;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.util.SAnnotationContainerHelper;

@SuppressWarnings("serial")
public class SNodeImpl extends NodeImpl implements SNode {
	// =======================================> SAnnotation
	/** {@inheritDoc} **/
	@Override
	public <A extends SAnnotation> Set<A> getAnnotations() {
		return (SAnnotationContainerHelper.getAnnotations(this));
	}

	/** {@inheritDoc} **/
	@Override
	public void addAnnotation(SAnnotation annotation) {
		SAnnotationContainerHelper.addAnnotation(this, annotation);
	}

	/** {@inheritDoc} **/
	@Override
	public SAnnotation getAnnotation(String qName) {
		return (SAnnotationContainerHelper.getAnnotation(this, qName));
	}

	/** {@inheritDoc} **/
	@Override
	public SAnnotation createAnnotation(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createAnnotation(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SAnnotation> createAnnotations(String annotationString) {
		return (SAnnotationContainerHelper.createAnnotations(this, annotationString));
	}
	
	/** {@inheritDoc} **/
	@Override
	public Iterator<SAnnotation> iterator_SAnnotation(){
		return(SAnnotationContainerHelper.iterator_SAnnotation(this));
	}

	// =======================================< SAnnotation

	// =======================================> SMetaAnnotation
	/** {@inheritDoc} **/
	@Override
	public void addMetaAnnotation(SMetaAnnotation metaAnnotation) {
		SAnnotationContainerHelper.addMetaAnnotation(this, metaAnnotation);
	}

	/** {@inheritDoc} **/
	@Override
	public SMetaAnnotation createMetaAnnotation(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createMetaAnnotation(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SMetaAnnotation> createMetaAnnotations(String annotationString) {
		return (SAnnotationContainerHelper.createMetaAnnotations(this, annotationString));
	}

	@Override
	public <A extends SMetaAnnotation> Set<A> getMetaAnnotations() {
		return (SAnnotationContainerHelper.getMetaAnnotations(this));
	}

	@Override
	public SMetaAnnotation getMetaAnnotation(String qName) {
		return (SAnnotationContainerHelper.getMetaAnnotation(this, qName));
	}

	// =======================================< SMetaAnnotation
	/** {@inheritDoc} **/
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}
}
