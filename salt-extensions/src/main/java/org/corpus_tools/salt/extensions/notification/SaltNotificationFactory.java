/**
 * Copyright 2009 Humboldt-Universität zu Berlin
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
package org.corpus_tools.salt.extensions.notification;

import java.util.Collection;
import java.util.List;
import org.corpus_tools.salt.Beta;

import org.corpus_tools.salt.ISaltFactory;
import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusDocumentRelation;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SCorpusRelation;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SMedialDS;
import org.corpus_tools.salt.common.SMedialRelation;
import org.corpus_tools.salt.common.SOrderRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.common.STimelineRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.impl.SCorpusDocumentRelationImpl;
import org.corpus_tools.salt.common.impl.SCorpusGraphImpl;
import org.corpus_tools.salt.common.impl.SCorpusImpl;
import org.corpus_tools.salt.common.impl.SCorpusRelationImpl;
import org.corpus_tools.salt.common.impl.SDocumentGraphImpl;
import org.corpus_tools.salt.common.impl.SDocumentImpl;
import org.corpus_tools.salt.common.impl.SDominanceRelationImpl;
import org.corpus_tools.salt.common.impl.SMedialDSImpl;
import org.corpus_tools.salt.common.impl.SMedialRelationImpl;
import org.corpus_tools.salt.common.impl.SOrderRelationImpl;
import org.corpus_tools.salt.common.impl.SPointingRelationImpl;
import org.corpus_tools.salt.common.impl.SSpanImpl;
import org.corpus_tools.salt.common.impl.SSpanningRelationImpl;
import org.corpus_tools.salt.common.impl.SStructureImpl;
import org.corpus_tools.salt.common.impl.STextualDSImpl;
import org.corpus_tools.salt.common.impl.STextualRelationImpl;
import org.corpus_tools.salt.common.impl.STimelineImpl;
import org.corpus_tools.salt.common.impl.STimelineRelationImpl;
import org.corpus_tools.salt.common.impl.STokenImpl;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SMetaAnnotation;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SProcessingAnnotation;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.core.impl.SAnnotationImpl;
import org.corpus_tools.salt.core.impl.SFeatureImpl;
import org.corpus_tools.salt.core.impl.SGraphImpl;
import org.corpus_tools.salt.core.impl.SLayerImpl;
import org.corpus_tools.salt.core.impl.SMetaAnnotationImpl;
import org.corpus_tools.salt.core.impl.SNodeImpl;
import org.corpus_tools.salt.core.impl.SProcessingAnnotationImpl;
import org.corpus_tools.salt.core.impl.SRelationImpl;
import org.corpus_tools.salt.extensions.notification.graph.Notifier;
import org.corpus_tools.salt.extensions.notification.graph.impl.GraphNotifierImpl;
import org.corpus_tools.salt.extensions.notification.graph.impl.LabelNotifierImpl;
import org.corpus_tools.salt.extensions.notification.graph.impl.LayerNotifierImpl;
import org.corpus_tools.salt.extensions.notification.graph.impl.NodeNotifierImpl;
import org.corpus_tools.salt.extensions.notification.graph.impl.NotifierHelper;
import org.corpus_tools.salt.extensions.notification.graph.impl.RelationNotifierImpl;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.impl.SaltFactoryImpl;
import org.corpus_tools.salt.semantics.SCatAnnotation;
import org.corpus_tools.salt.semantics.SLemmaAnnotation;
import org.corpus_tools.salt.semantics.SPOSAnnotation;
import org.corpus_tools.salt.semantics.SSentenceAnnotation;
import org.corpus_tools.salt.semantics.STypeAnnotation;
import org.corpus_tools.salt.semantics.SWordAnnotation;
import org.corpus_tools.salt.semantics.impl.SCatAnnotationImpl;
import org.corpus_tools.salt.semantics.impl.SLemmaAnnotationImpl;
import org.corpus_tools.salt.semantics.impl.SPOSAnnotationImpl;
import org.corpus_tools.salt.semantics.impl.SSentenceAnnotationImpl;
import org.corpus_tools.salt.semantics.impl.STypeAnnotationImpl;
import org.corpus_tools.salt.semantics.impl.SWordAnnotationImpl;

@Beta
public class SaltNotificationFactory extends SaltFactoryImpl implements ISaltFactory, Notifier {

	// ==========================================> listener list
	protected static List<Listener> listenerList = null;

	/** {@inheritDoc} **/
	@Override
	public List<Listener> getListener() {
		return (NotifierHelper.getListener(listenerList));
	}

	/** {@inheritDoc} **/
	@Override
	public synchronized void addListener(Listener listener) {
		listenerList = NotifierHelper.addListener(listenerList, listener);
	}

	/** {@inheritDoc} **/
	@Override
	public void addListener(Collection<Listener> listener) {
		listenerList = NotifierHelper.addListener(listenerList, listener);
	}

	/** {@inheritDoc} **/
	@Override
	public synchronized void removeListener(Listener listener) {
		listenerList = NotifierHelper.removeListener(listenerList, listener);
	}

	// ==========================================< listener list

	// ==========================================> salt graph

	@Override
	public Node createNode() {
		NodeNotifierImpl node = new NodeNotifierImpl();
		node.addListener(getListener());
		return (node);
	}

	@Override
	public Relation<Node, Node> createRelation() {
		RelationNotifierImpl<Node, Node> relation = new RelationNotifierImpl<Node, Node>();
		relation.addListener(relation.getListener());
		return (relation);
	}

	@Override
	public Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> createGraph() {
		GraphNotifierImpl graph = new GraphNotifierImpl();
		graph.addListener(getListener());
		return (graph);
	}

	@Override
	public Label createLabel() {
		LabelNotifierImpl label = new LabelNotifierImpl();
		label.addListener(getListener());
		return (label);
	}

	@Override
	public Layer<Node, Relation<Node, Node>> createLayer() {
		LayerNotifierImpl node = new LayerNotifierImpl();
		node.addListener(getListener());
		return (node);
	}

	// ==========================================< salt graph
	// ==========================================> salt core
	@Override
	public SGraph createSGraph() {
		return (new SGraphImpl(createGraph()));
	}

	@Override
	public SNode createSNode() {
		return (new SNodeImpl(createNode()));
	}

	@Override
	public SRelation<SNode, SNode> createSRelation() {
		return (new SRelationImpl<SNode, SNode>(createRelation()));
	}

	@Override
	public SAnnotation createSAnnotation() {
		return (new SAnnotationImpl(createLabel()));
	}

	@Override
	public SMetaAnnotation createSMetaAnnotation() {
		return (new SMetaAnnotationImpl(createLabel()));
	}

	@Override
	public SProcessingAnnotation createSProcessingAnnotation() {
		return (new SProcessingAnnotationImpl(createLabel()));
	}

	@Override
	public SFeature createSFeature() {
		return (new SFeatureImpl(createLabel()));
	}

	@Override
	public SLayer createSLayer() {
		return (new SLayerImpl(createLayer()));
	}

	// ==========================================< salt core
	// ==========================================> salt common
	@Override
	public SCorpus createSCorpus() {
		return (new SCorpusImpl(createNode()));
	}

	@Override
	public SCorpusRelation createSCorpusRelation() {
		return (new SCorpusRelationImpl(createRelation()));
	}

	@Override
	public SCorpusDocumentRelation createSCorpusDocumentRelation() {
		return (new SCorpusDocumentRelationImpl(createRelation()));
	}

	@Override
	public SCorpusGraph createSCorpusGraph() {
		return (new SCorpusGraphImpl(createGraph()));
	}

	@Override
	public SDocumentGraph createSDocumentGraph() {
		return (new SDocumentGraphImpl(createGraph()));
	}

	@Override
	public SDocument createSDocument() {
		return (new SDocumentImpl(createNode()));
	}

	@Override
	public SToken createSToken() {
		return (new STokenImpl(createNode()));
	}

	@Override
	public SSpanningRelation createSSpanningRelation() {
		return (new SSpanningRelationImpl(createRelation()));
	}

	@Override
	public SDominanceRelation createSDominanceRelation() {
		return (new SDominanceRelationImpl(createRelation()));
	}

	@Override
	public SPointingRelation createSPointingRelation() {
		return (new SPointingRelationImpl(createRelation()));
	}

	@Override
	public SOrderRelation createSOrderRelation() {
		return (new SOrderRelationImpl(createRelation()));
	}

	@Override
	public STextualRelation createSTextualRelation() {
		return (new STextualRelationImpl(createRelation()));
	}

	@Override
	public STimelineRelation createSTimelineRelation() {
		return (new STimelineRelationImpl(createRelation()));
	}

	@Override
	public SMedialRelation createSMedialRelation() {
		return (new SMedialRelationImpl(createRelation()));
	}

	@Override
	public SSpan createSSpan() {
		return (new SSpanImpl(createNode()));
	}

	@Override
	public SStructure createSStructure() {
		return (new SStructureImpl(createNode()));
	}

	@Override
	public STextualDS createSTextualDS() {
		return (new STextualDSImpl(createNode()));
	}

	@Override
	public SMedialDS createSMedialDS() {
		return (new SMedialDSImpl(createNode()));
	}

	@Override
	public STimeline createSTimeline() {
		return (new STimelineImpl(createNode()));
	}

	// ==========================================< salt common
	// ==========================================> salt semantics

	@Override
	public SCatAnnotation createSCatAnnotation() {
		return (new SCatAnnotationImpl(createLabel()));
	}

	@Override
	public SPOSAnnotation createSPOSAnnotation() {
		return (new SPOSAnnotationImpl(createLabel()));
	}

	@Override
	public SLemmaAnnotation createSLemmaAnnotation() {
		return (new SLemmaAnnotationImpl(createLabel()));
	}

	@Override
	public STypeAnnotation createSTypeAnnotation() {
		return (new STypeAnnotationImpl(createLabel()));
	}

	@Override
	public SWordAnnotation createSWordAnnotation() {
		return (new SWordAnnotationImpl(createLabel()));
	}

	@Override
	public SSentenceAnnotation createSSentenceAnnotation() {
		return (new SSentenceAnnotationImpl(createLabel()));
	}
	// ==========================================< salt semantics
}