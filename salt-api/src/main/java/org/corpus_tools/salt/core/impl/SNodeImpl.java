/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.corpus_tools.salt.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.core.AnnotationFinder;
import org.corpus_tools.salt.core.SAbstractAnnotation;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SMetaAnnotation;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SProcessingAnnotation;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.impl.NodeImpl;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.internal.SAnnotationContainerHelper;
import org.eclipse.emf.common.util.URI;

@SuppressWarnings("serial")
public class SNodeImpl extends NodeImpl implements SNode {
	/** Initializes an object of type {@link SNodeImpl}. **/
	public SNodeImpl() {
	}

	/**
	 * Initializes an object of type {@link SNodeImpl}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SNodeImpl(Node delegate) {
		super(delegate);
	}

	@Override
	protected void basicSetGraph(Graph<? extends Node, ?, ?> graph) {
		if (graph != null && getDelegate() == null && !(graph instanceof SGraph)) {
			throw new SaltParameterException("graph", "basicSetGraph", getClass(), "Must be of type SGraph.");
		}
		super.basicSetGraph(graph);
	}

	/**
	 * {@inheritDoc SNode#getOutgoingSRelations()}
	 */
	@Override
	public List<SRelation<? extends SNode, ? extends SNode>> getOutRelations() {
		if (getGraph() == null) {
			return null;
		}
		List<SRelation<?, ?>> outRelations = getGraph().getOutRelations(getId());
		if (outRelations != null) {
			// TODO: do we really have to do a copy here any longer?
			List<SRelation<?, ?>> sOutRelList = new ArrayList<>();
			for (SRelation<?, ?> rel : outRelations) {
				sOutRelList.add(rel);
			}
			return sOutRelList;
		}
		return null;
	}

	/**
	 * {@inheritDoc SNode#getIncomingSRelations()}
	 */
	@Override
	public List<SRelation<? extends SNode, ? extends SNode>> getInRelations() {
		if (getGraph() == null) {
			return null;
		}
		List<SRelation<?, ?>> inRelations = getGraph().getInRelations(getId());
		if (inRelations != null) {
			// TODO: do we really have to do a copy here any longer?
			List<SRelation<?, ?>> sInRelList = new ArrayList<>();
			for (SRelation<?, ?> rel : inRelations) {
				sInRelList.add(rel);
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
	public SAnnotation getAnnotation(String namespace, String name) {
		return (SAnnotationContainerHelper.getAnnotation(this, SaltUtil.createQName(namespace, name)));
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

	/** {@inheritDoc} **/
	@Override
	public <A extends SMetaAnnotation> Set<A> getMetaAnnotations() {
		return (SAnnotationContainerHelper.getMetaAnnotations(this));
	}

	/** {@inheritDoc} **/
	@Override
	public SMetaAnnotation getMetaAnnotation(String qName) {
		return (SAnnotationContainerHelper.getMetaAnnotation(this, qName));
	}

	/** {@inheritDoc} **/
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
	public SFeature getFeature(String namespace, String name) {
		return (SAnnotationContainerHelper.getFeature(this, SaltUtil.createQName(namespace, name)));
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
	/** {@inheritDoc} **/
	@Override
	public SGraph getGraph() {
		Graph<?, ?, ?> superGraph = super.getGraph();
		if (superGraph == null) {
			return null;
		}

		if (superGraph instanceof SGraph) {
			return (SGraph) superGraph;
		}
		throw new SaltInvalidModelException(
				"Graph implementation is not of type SGraph (actual type is " + superGraph.getClass().getName() + ")");
	}

	@Override
	public <T extends SAbstractAnnotation> AnnotationFinder<T> find(Class<T> resultType) {
		return new AnnotationFinder<>(resultType, this);
	}
}
