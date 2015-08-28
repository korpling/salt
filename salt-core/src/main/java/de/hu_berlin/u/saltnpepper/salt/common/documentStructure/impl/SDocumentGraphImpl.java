package de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructuredNode;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimeline;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimelineRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.common.tokenizer.Tokenizer;
import de.hu_berlin.u.saltnpepper.salt.core.GraphTraverseHandler;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.index.IndexMgr;
import de.hu_berlin.u.saltnpepper.salt.util.DataSourceSequence;
import de.hu_berlin.u.saltnpepper.salt.util.SALT_TYPE;

public class SDocumentGraphImpl implements SDocumentGraph {

	public SDocumentGraphImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SNode> getRoots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SNode> getLeafs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler, boolean isCycleSafe) {
		// TODO Auto-generated method stub

	}

	@Override
	public IndexMgr getIndexMgr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SRelation<SNode, SNode>> getRelations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SRelation<SNode, SNode> getRelation(String relationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SRelation<SNode, SNode>> getRelations(String sourceNodeId, String targetNodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SRelation<SNode, SNode>> getInRelations(String nodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SRelation<SNode, SNode>> getOutRelations(String nodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRelation(Relation<? extends Node, ? extends Node> relation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRelation(SRelation<SNode, SNode> relation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRelations() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsRelation(String relationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SNode> getNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SNode getNode(String nodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNode(SNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNode(SNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsNode(String nodeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Layer<SNode, SRelation<SNode, SNode>> getLayer(String layerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Layer<SNode, SRelation<SNode, SNode>>> getLayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLayer(Layer<SNode, SRelation<SNode, SNode>> layer) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsLayer(String layerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeLayer(Layer<SNode, SRelation<SNode, SNode>> layer) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Identifier getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdentifier(Identifier identifier) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Label> getLabels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLabel(Label label) {
		// TODO Auto-generated method stub

	}

	@Override
	public Label getLabel(String namespace, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Label getLabel(String qName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLabel(String qName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLabel(String namespace, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Label> getLabelsByNamespace(String namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsLabel(String qName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer sizeLabels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SAnnotation createAnnotation(String namespace, String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A extends SAnnotation> Set<A> createAnnotations(String annotationString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A extends SAnnotation> Set<A> getAnnotations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAnnotation(SAnnotation annotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public SAnnotation getAnnotation(String qName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<SAnnotation> iterator_SAnnotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SMetaAnnotation createMetaAnnotation(String namespace, String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A extends SMetaAnnotation> Set<A> createMetaAnnotations(String metaAnnotationString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A extends SMetaAnnotation> Set<A> getMetaAnnotations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMetaAnnotation(SMetaAnnotation metaAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public SMetaAnnotation getMetaAnnotation(String qName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<SMetaAnnotation> iterator_SMetaAnnotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SProcessingAnnotation createProcessingAnnotation(String namespace, String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A extends SProcessingAnnotation> Set<A> createProcessingAnnotations(String annotationString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A extends SProcessingAnnotation> Set<A> getProcessingAnnotations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProcessingAnnotation(SProcessingAnnotation processingAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public SProcessingAnnotation getProcessingAnnotation(String qName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<SProcessingAnnotation> iterator_SProcessingAnnotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SFeature createFeature(String namespace, String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A extends SFeature> Set<A> createFeatures(String featureString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A extends SFeature> Set<A> getFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFeature(SFeature feature) {
		// TODO Auto-generated method stub

	}

	@Override
	public SFeature getFeature(String qName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<SFeature> iterator_SFeature() {
		// TODO Auto-generated method stub
		return null;
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
	public SDocument getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDocument(SDocument document) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<STextualDS> getTextualDSs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<STextualRelation> getTextualRelations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SToken> getTokens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public STimeline getTimeline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTimeline(STimeline value) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<STimelineRelation> getTimelineRelations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SSpanningRelation> getSpanningRelations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SSpan> getSpans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SStructure> getStructures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SDominanceRelation> getDominanceRelations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SPointingRelation> getPointingRelations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SMedialRelation> getMedialRelations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SMedialDS> getMediaDSs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SOrderRelation> getOrderRelations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SRelation addNode(SNode sourceSNode, SNode targetSNode, SALT_TYPE sRelationType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public STextualDS createSTextualDS(String sText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SToken createSToken(List<DataSourceSequence> sDSSequences) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SToken createSToken(DataSourceSequence sDSSequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SSpan createSSpan(SToken sourceSToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SSpan createSSpan(List<SToken> sTokens) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SStructure createSStructure(SStructuredNode sourceSNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SStructure createSStructure(List<SStructuredNode> sStructures) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public STimeline createSTimeline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SToken> getTokensBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SSpan> getSpansBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SStructure> getStructuresBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SNode> getNodesBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataSourceSequence> getOverlappedDSSequences(SNode node, List<SALT_TYPE> relationTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataSourceSequence> getOverlappedDSSequences(List<SNode> sNode, List<SALT_TYPE> relationTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isContinuousByText(List<SNode> subNodeList, List<SNode> fullNodeList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isContinuousByText(List<SNode> subNodeList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SToken> getSortedSTokenByText(List<SToken> tokens2sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SToken> getSortedTokenByText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sortTokenByText() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SNode> getRootsByRelation(SALT_TYPE type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<SNode>> getRootsBySRelationSType(SALT_TYPE type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SToken createSToken(SSequentialDS sequentialDS, Integer start, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SToken> tokenize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tokenizer createTokenizer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SToken insertSTokenAt(STextualDS sTextualDS, Integer posInText, String text, Boolean insertSpace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SToken> insertSTokensAt(STextualDS sTextualDS, Integer posInText, List<String> texts, Boolean insertSpace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SRelation createSRelation(SNode sSource, SNode sTarget, SALT_TYPE sRelationType, String sAnnotations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SToken> getOverlappedSTokens(SNode overlappingNode, List<SALT_TYPE> overlappingRelationTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSText(SNode sNode) {
		// TODO Auto-generated method stub
		return null;
	}

}
