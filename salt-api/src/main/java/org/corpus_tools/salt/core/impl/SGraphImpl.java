/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.SALT_TYPE;
import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SMetaAnnotation;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SProcessingAnnotation;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.graph.impl.GraphImpl;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.TraverseFluent;
import org.corpus_tools.salt.util.internal.SAnnotationContainerHelper;
import org.eclipse.emf.common.util.URI;

@SuppressWarnings("serial")
public class SGraphImpl extends GraphImpl<SNode, SRelation<SNode, SNode>, SLayer> implements SGraph {
	/** Initializes an object of type {@link SGraphImpl}. **/
	public SGraphImpl() {
		super();
	}

	/**
	 * Initializes an object of type {@link SGraphImpl}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SGraphImpl(Graph delegate) {
		super(delegate);
	}

	/** {@inheritDoc} **/
	@Override
	public void addLayer(SLayer layer) {
		if (layer.getName() == null) {
			layer.setName("l" + getLayers().size());
		}
		super.addLayer(layer);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SNode> getNodesByName(String nodeName) {
		if ((nodeName == null) || (nodeName.isEmpty())) {
			return (null);
		}
		List<SNode> result = new ArrayList<>();
		for (SNode n : getNodes()) {
			if ((n.getName() == null) || (n.getName().isEmpty())) {
				break;
			}
			if (nodeName.equals(n.getName())) {
				result.add(n);
			}
		}
		return result;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SRelation> getRelationsByName(String relationName) {
		if ((relationName == null) || (relationName.isEmpty())) {
			return (null);
		}

		List<SRelation> result = new ArrayList<>();
		for (SRelation r : getRelations()) {
			if ((r.getName() == null) || (r.getName().isEmpty())) {
				break;
			}
			if (relationName.equals(r.getName())) {
				result.add(r);
			}
		}
		return result;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SLayer> getLayerByName(String layerName) {
		if ((layerName == null) || (layerName.isEmpty())) {
			return (null);
		}

		List<SLayer> result = new ArrayList<>();
		for (SLayer l : getLayers()) {
			if ((l.getName() == null) || (l.getName().isEmpty())) {
				break;
			}
			if (layerName.equals(l.getName())) {
				result.add(l);
			}
		}
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public List<SNode> getRoots() {
		List<SNode> retList = new ArrayList<>();
		if (this.getNodes().size() == 1) {
			// if corpusGraph only contains one corpus it shall not need to be
			// traversed
			retList.add(this.getNodes().get(0));
		} else {
			for (SNode node : Collections.synchronizedCollection(this.getNodes())) {
				// checking if node has incoming edges
				List<SRelation<SNode, SNode>> inEdges = getInRelations(node.getId());
				if ((inEdges == null) || (inEdges.size() == 0)) {
					retList.add(node);
				}
			}
		}
		if (retList.size() == 0)
			retList = null;
		return (retList);
	}

	/** {@inheritDoc} */
	@Override
	public List<SNode> getLeafs() {
		List<SNode> retList = new ArrayList<>();
		if (this.getNodes().size() == 1) {
			// if corpusGraph only contains one corpus it shall not need to
			// be traversed
			retList.add(this.getNodes().get(0));
		} else {
			for (SNode node : Collections.synchronizedCollection(this.getNodes())) {
				// checking if node has outgoing edges
				List<SRelation<SNode, SNode>> outEdges = getOutRelations(node.getId());
				if ((outEdges == null) || (outEdges.size() == 0)) {
					retList.add(node);
				}
			}
		}
		if (retList.size() == 0)
			retList = null;
		return (retList);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SNode> getChildren(SNode parent, SALT_TYPE relationType) {
		List<SNode> children = new ArrayList<>();
		List<SRelation> relations = parent.getOutRelations();
		if (relations != null) {
			for (SRelation<? extends SNode, ? extends SNode> relation : relations) {
				if (relationType == null || SALT_TYPE.class2SaltType(relation.getClass()).contains(relationType)) {
					SNode child = relation.getTarget();
					children.add(child);
				}
			}
		}
		return children;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <pre>
	 * for all incoming relations of first child node
	 * 		add targets to sharedparents
	 * for each child in children
	 * 		for each incomming relation of child
	 * 			add source node of incomming relation to parent
	 * 		sharedparents= sharedparents ⋂ parents
	 * </pre>
	 **/
	@Override
	public List<SNode> getSharedParent(List<SNode> children, SALT_TYPE nodeType) {
		ArrayList<SNode> sharedParents = new ArrayList<>();
		if ((children.size() > 0) && (children.get(0) != null)) {
			List<SRelation> rels = children.get(0).getInRelations();
			if ((rels != null) && (rels.size() > 0)) {
				// a shared parent has to be connected to every child node
				for (SRelation<? extends SNode, ? extends SNode> baseRelation : rels) {
					if (SALT_TYPE.class2SaltType(baseRelation.getSource().getClass()).contains(nodeType)) {
						sharedParents.add(baseRelation.getSource());
					}
				}
				Iterator<SNode> it = children.iterator();
				it.next(); // skip first child
				while (it.hasNext()) {
					SNode child = it.next();
					ArrayList<SNode> parents = new ArrayList<>();
					for (SRelation<? extends SNode, ? extends SNode> sRelation : child.getInRelations()) {
						SNode parent = sRelation.getSource();
						if (SALT_TYPE.class2SaltType(parent.getClass()).contains(nodeType)) {
							parents.add(parent);
						}
					}
					sharedParents.retainAll(parents);
				}
			}
		}
		return sharedParents;
	}

	/** {@inheritDoc} */
	@Override
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler) {
		this.traverse(startNodes, traverseType, traverseId, traverseHandler, true);
	}

	/** {@inheritDoc} */
	@Override
	public void traverse(List<? extends SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler, boolean isCycleSafe) {
		GraphTraverserModule traverserModule = new GraphTraverserModule();
		traverserModule.setGraph(this);
		traverserModule.traverse(startNodes, traverseType, traverseId, traverseHandler, isCycleSafe);
	}

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
	public SFeature getFeature(String namespace, String name) {
		return (SAnnotationContainerHelper.getFeature(this, SaltUtil.createQName(namespace, name)));
	}

	/** {@inheritDoc} **/
	@Override
	public Iterator<SFeature> iterator_SFeature() {
		return (SAnnotationContainerHelper.iterator_SFeature(this));
	}

	// =======================================< SFeature
	// =======================================> SPathElement
	/** {@inheritDoc} **/
	@Override
	public URI getPath() {
		return (SaltUtil.createSaltURI(getId()));
	}
	// =======================================< SPathElement
}