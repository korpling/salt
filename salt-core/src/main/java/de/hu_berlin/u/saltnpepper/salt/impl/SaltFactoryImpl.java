package de.hu_berlin.u.saltnpepper.salt.impl;

import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactoryImpl;
import de.hu_berlin.u.saltnpepper.salt.ISaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.impl.SCorpusDocumentRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.impl.SCorpusGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.impl.SCorpusImpl;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.impl.SCorpusRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.impl.SDocumentImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SDocumentGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SSpanningRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SFeatureImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SLayerImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SMetaAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SNodeImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SProcessingAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SRelationImpl;

public class SaltFactoryImpl extends GraphFactoryImpl implements ISaltFactory {
	/**
	 * Creates a new {@link SGraph} object of type {@link SGraphImpl}.
	 * 
	 * @return new {@link SGraph} object
	 */
	@Override
	public SGraph createSGraph() {
		return (new SGraphImpl());
	}

	/**
	 * Creates a new {@link SNode} object of type {@link SNodeImpl}.
	 * 
	 * @return new {@link SNode} object
	 */
	@Override
	public SNode createSNode() {
		return (new SNodeImpl());
	}

	/**
	 * Creates a new {@link SRelation} object of type {@link SRelationImpl}.
	 * 
	 * @return new {@link SRelation} object
	 */
	@Override
	public SRelation<SNode, SNode> createSRelation() {
		return (new SRelationImpl<SNode, SNode>());
	}

	/**
	 * Creates a new {@link SAnnotation} object of type {@link SAnnotationImpl}.
	 * 
	 * @return new {@link SAnnotation} object
	 */
	@Override
	public SAnnotation createSAnnotation() {
		return (new SAnnotationImpl());
	}

	/**
	 * Creates a new {@link SMetaAnnotation} object of type
	 * {@link SMetaAnnotationImpl}.
	 * 
	 * @return new {@link SMetaAnnotation} object
	 */
	@Override
	public SMetaAnnotation createSMetaAnnotation() {
		return (new SMetaAnnotationImpl());
	}

	/**
	 * Creates a new {@link SProcessingAnnotation} object of type
	 * {@link SProcessingAnnotationImpl}.
	 * 
	 * @return new {@link SProcessingAnnotation} object
	 */
	@Override
	public SProcessingAnnotation createSProcessingAnnotation() {
		return (new SProcessingAnnotationImpl());
	}

	/**
	 * Creates a new {@link SFeature} object of type {@link SFeatureImpl}.
	 * 
	 * @return new {@link SFeature} object
	 */
	@Override
	public SFeature createSFeature() {
		return (new SFeatureImpl());
	}

	/**
	 * Creates a new {@link SLayer} object of type {@link SLayerImpl}.
	 * 
	 * @return new {@link SLayer} object
	 */
	@Override
	public SLayer createSLayer() {
		return (new SLayerImpl());
	}

	/**
	 * Creates a new {@link SSpanningRelation} object of type
	 * {@link SSpanningRelationImpl}.
	 * 
	 * @return new {@link SSpanningRelation} object
	 */
	@Override
	public SSpanningRelation createSSpanningRelation() {
		return (new SSpanningRelationImpl());
	}

	// ===============================> corpus structure
	/**
	 * Creates a new {@link SCorpus} object.
	 * 
	 * @return new {@link SCorpus} object
	 */
	public SCorpus createSCorpus() {
		return (new SCorpusImpl());
	}

	/**
	 * Creates a new {@link SDocument} object.
	 * 
	 * @return new {@link SDocument} object
	 */
	public SDocument createSDocument() {
		return (new SDocumentImpl());
	}

	/**
	 * Creates a new {@link SCorpusRelation} object.
	 * 
	 * @return new {@link SCorpusRelation} object
	 */
	public SCorpusRelation createSCorpusRelation() {
		return (new SCorpusRelationImpl());
	}

	/**
	 * Creates a new {@link SCorpusDocumentRelation} object.
	 * 
	 * @return new {@link SCorpusDocumentRelation} object
	 */
	public SCorpusDocumentRelation createSCorpusDocumentRelation() {
		return (new SCorpusDocumentRelationImpl());
	}
	/**
	 * Creates a new {@link SCorpusGraph} object.
	 * 
	 * @return new {@link SCorpusGraph} object
	 */
	public SCorpusGraph createSCorpusGraph() {
		return (new SCorpusGraphImpl());
	}

	// ===============================< corpus structure

	// ===============================> document structure
	/**
	 * Creates a new {@link SDocumentGraph} object.
	 * 
	 * @return new {@link SDocumentGraph} object
	 */
	public SDocumentGraph createSDocumentGraph() {
		return (new SDocumentGraphImpl());
	}
	// ===============================< document structure
}