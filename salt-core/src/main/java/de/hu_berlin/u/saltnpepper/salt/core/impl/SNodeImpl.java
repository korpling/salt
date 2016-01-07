package de.hu_berlin.u.saltnpepper.salt.core.impl;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.graph.impl.NodeImpl;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInvalidModelException;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;
import de.hu_berlin.u.saltnpepper.salt.util.internal.SAnnotationContainerHelper;

import java.util.Collections;
import java.util.HashSet;

@SuppressWarnings("serial")
public class SNodeImpl extends NodeImpl implements SNode {

	public SNodeImpl() {
	}
	/**
	 * Initializes an object of type {@link SNode}. If {@link #delegate} is not
	 * null, all functions of this method are delegated to the delegate object.
	 * Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SNodeImpl(Node delegate) {
		super(delegate);
	}
	
	/**
	 * {@inheritDoc SNode#getOutgoingSRelations()}
	 */
	@Override
	public List<SRelation> getOutRelations() {
		if (getGraph() == null) {
			return null;
		}
		List<SRelation<SNode, SNode>> outRelations = getGraph().getOutRelations(getId());
		if (outRelations != null) {
			List<SRelation> sOutRelList = new ArrayList<>();
			for (SRelation rel : outRelations) {
				sOutRelList.add((SRelation) rel);
			}
			return sOutRelList;
		}
		return null;
	}

	/**
	 * {@inheritDoc SNode#getIncomingSRelations()}
	 */
	@Override
	public List<SRelation> getInRelations() {
		if (getGraph() == null) {
			return null;
		}
		List<SRelation<SNode,SNode>> inRelations = getGraph().getInRelations(getId());
		if (inRelations != null) {
			List<SRelation> sInRelList = new ArrayList<>();
			for (SRelation rel : inRelations) {
				sInRelList.add((SRelation) rel);
			}
			return sInRelList;
		}
		return null;
	}

	@Override
	public Set<SLayer> getLayers() {
	Set<SLayer> layers = new HashSet<>();
		if (getGraph() != null) {
			Set<SLayer> allLayers = getGraph().getLayers();
			if ((allLayers != null) && (allLayers.size() > 0)) {
				for (SLayer layer : allLayers) {
					if (layer.getNodes().contains(this)) {
						layers.add(layer);
					}
				}
			}
		}
		return (Collections.unmodifiableSet(layers));
	}
	
	

	// =======================================> SAnnotation
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
	public void addAnnotation(SAnnotation annotation) {
		SAnnotationContainerHelper.addAnnotation(this, annotation);
	}

	/** {@inheritDoc} **/
	@Override
	public <A extends SAnnotation> Set<A> getAnnotations() {
		return (SAnnotationContainerHelper.getAnnotations(this));
	}

	/** {@inheritDoc} **/
	@Override
	public SAnnotation getAnnotation(String qName) {
		return (SAnnotationContainerHelper.getAnnotation(this, qName));
	}

	/** {@inheritDoc} **/
	@Override
	public Iterator<SAnnotation> iterator_SAnnotation() {
		return (SAnnotationContainerHelper.iterator_SAnnotation(this));
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

	@Override
	public Iterator<SMetaAnnotation> iterator_SMetaAnnotation() {
		return (SAnnotationContainerHelper.iterator_SMetaAnnotation(this));
	}

	// =======================================< SMetaAnnotation
	// =======================================> SProcessingAnnotation
	/** {@inheritDoc} **/
	@Override
	public SProcessingAnnotation createProcessingAnnotation(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createProcessingAnnotation(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SProcessingAnnotation> createProcessingAnnotations(String annotationString) {
		return (SAnnotationContainerHelper.createProcessingAnnotations(this, annotationString));
	}

	/** {@inheritDoc} **/
	@Override
	public void addProcessingAnnotation(SProcessingAnnotation annotation) {
		SAnnotationContainerHelper.addProcessingAnnotation(this, annotation);
	}

	/** {@inheritDoc} **/
	@Override
	public <A extends SProcessingAnnotation> Set<A> getProcessingAnnotations() {
		return (SAnnotationContainerHelper.getProcessingAnnotations(this));
	}

	/** {@inheritDoc} **/
	@Override
	public SProcessingAnnotation getProcessingAnnotation(String qName) {
		return (SAnnotationContainerHelper.getProcessingAnnotation(this, qName));
	}

	/** {@inheritDoc} **/
	@Override
	public Iterator<SProcessingAnnotation> iterator_SProcessingAnnotation() {
		return (SAnnotationContainerHelper.iterator_SProcessingAnnotation(this));
	}

	// =======================================< SProcessingAnnotation
	// =======================================> SFeature
	/** {@inheritDoc} **/
	@Override
	public SFeature createFeature(String namespace, String name, Object value) {
		return (SAnnotationContainerHelper.createFeature(this, namespace, name, value));
	}

	/** {@inheritDoc} **/
	@Override
	public Set<SFeature> createFeatures(String featureString) {
		return (SAnnotationContainerHelper.createFeatures(this, featureString));
	}

	/** {@inheritDoc} **/
	@Override
	public void addFeature(SFeature feature) {
		SAnnotationContainerHelper.addFeature(this, feature);
	}

	/** {@inheritDoc} **/
	@Override
	public <A extends SFeature> Set<A> getFeatures() {
		return (SAnnotationContainerHelper.getFeatures(this));
	}

	/** {@inheritDoc} **/
	@Override
	public SFeature getFeature(String qName) {
		return (SAnnotationContainerHelper.getFeature(this, qName));
	}

	/** {@inheritDoc} **/
	@Override
	public Iterator<SFeature> iterator_SFeature() {
		return (SAnnotationContainerHelper.iterator_SFeature(this));
	}

	// =======================================< SFeature

	// =======================================> SNamedElement
	@Override
	public void removeLabel(String qName) {
		if (SaltUtil.FEAT_NAME_QNAME.equals(qName)) {
			name = null;
		}
		super.removeLabel(qName);
	}

	/** The feature object containing the name of the node **/
	protected SFeature name = null;

	/** {@inheritDoc} **/
	@Override
	public String getName() {
		if (name == null) {
			SFeature feature = getFeature(SaltUtil.FEAT_NAME_QNAME);
			if (feature != null) {
				name = feature;
			}
			if (name == null) {
				return (null);
			}
		}
		return (name.getValue_STEXT());
	}

	/** {@inheritDoc} **/
	@Override
	public void setName(String name) {
		if (this.name == null) {
			this.name = createFeature(SaltUtil.SALT_NAMESPACE, SaltUtil.FEAT_NAME, null);
		}
		this.name.setValue(name);
	}

	// =======================================< SNamedElement

	// =======================================> SPathElement
	/** {@inheritDoc} **/
	@Override
	public URI getPath() {
		return (SaltUtil.createSaltURI(getId()));
	}
	// =======================================< SPathElement

	@Override
	public SGraph getGraph() {
		Graph superGraph = super.getGraph();
		
		if(superGraph == null) {
			return null;
		}
		
		if(superGraph instanceof SGraph) {
			return (SGraph) superGraph;
		}
		throw new SaltInvalidModelException("Graph implementation is not of type SGraph (actual type is " 
				+ superGraph.getClass().getName() + ")");
	}
	
	
}
