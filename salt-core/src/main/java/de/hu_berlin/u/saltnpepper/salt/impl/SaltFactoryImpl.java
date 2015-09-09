package de.hu_berlin.u.saltnpepper.salt.impl;

import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactoryImpl;
import de.hu_berlin.u.saltnpepper.salt.ISaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
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
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimeline;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimelineRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SDocumentGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SDominanceRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SMedialDSImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SMedialRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SOrderRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SPointingRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SSpanImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SSpanningRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SStructureImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.STextualDSImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.STextualRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.STimelineImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.STimelineRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.STokenImpl;
import de.hu_berlin.u.saltnpepper.salt.common.impl.SaltProjectImpl;
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
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.SCatAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.SLemmaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.SPOSAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.SSentenceAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.STypeAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.SWordAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.impl.SCatAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.impl.SLemmaAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.impl.SPOSAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.impl.SSentenceAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.impl.STypeAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.impl.SWordAnnotationImpl;

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
	 * Creates a new {@link SaltProject}.
	 * 
	 * @return new {@link SaltProject} object
	 */
	public SaltProject createSaltProject() {
		return (new SaltProjectImpl());
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

	/**
	 * Creates a new {@link SDominanceRelation} object.
	 * 
	 * @return new {@link SDominanceRelation} object
	 */
	public SDominanceRelation createSDominanceRelation() {
		return (new SDominanceRelationImpl());
	}

	/**
	 * Creates a new {@link SPointingRelation} object.
	 * 
	 * @return new {@link SPointingRelation} object
	 */
	public SPointingRelation createSPointingRelation() {
		return (new SPointingRelationImpl());
	}

	/**
	 * Creates a new {@link SOrderRelation} object.
	 * 
	 * @return new {@link SOrderRelation} object
	 */
	public SOrderRelation createSOrderRelation() {
		return (new SOrderRelationImpl());
	}

	/**
	 * Creates a new {@link STextualRelation} object.
	 * 
	 * @return new {@link STextualRelation} object
	 */
	public STextualRelation createSTextualRelation() {
		return (new STextualRelationImpl());
	}

	/**
	 * Creates a new {@link STimelineRelation} object.
	 * 
	 * @return new {@link STimelineRelation} object
	 */
	public STimelineRelation createSTimelineRelation() {
		return (new STimelineRelationImpl());
	}

	/**
	 * Creates a new {@link SMedialRelation} object.
	 * 
	 * @return new {@link SMedialRelation} object
	 */
	public SMedialRelation createSMedialRelation() {
		return (new SMedialRelationImpl());
	}

	/**
	 * Creates a new {@link SSpan} object.
	 * 
	 * @return new {@link SSpan} object
	 */
	public SSpan createSSpan() {
		return (new SSpanImpl());
	}

	/**
	 * Creates a new {@link SStructure} object.
	 * 
	 * @return new {@link SStructure} object
	 */
	public SStructure createSStructure() {
		return (new SStructureImpl());
	}

	/**
	 * Creates a new {@link STextualDS} object.
	 * 
	 * @return new {@link STextualDS} object
	 */
	public STextualDS createSTextualDS() {
		return (new STextualDSImpl());
	}

	/**
	 * Creates a new {@link SMedialDS} object.
	 * 
	 * @return new {@link SMedialDS} object
	 */
	public SMedialDS createSMedialDS() {
		return (new SMedialDSImpl());
	}

	/**
	 * Creates a new {@link STimeline} object.
	 * 
	 * @return new {@link STimeline} object
	 */
	public STimeline createSTimeline() {
		return (new STimelineImpl());
	}

	/**
	 * Creates a new {@link SToken} object.
	 * 
	 * @return new {@link SToken} object
	 */
	public SToken createSToken() {
		return (new STokenImpl());
	}

	// ===============================< document structure
	// ===============================> semantics
	/**
	 * Creates a new {@link SCatAnnotation} object.
	 * 
	 * @return new {@link SCatAnnotation} object
	 */
	public SCatAnnotation createSCatAnnotation() {
		return (new SCatAnnotationImpl());
	}

	/**
	 * Creates a new {@link SPOSAnnotation} object.
	 * 
	 * @return new {@link SPOSAnnotation} object
	 */
	public SPOSAnnotation createSPOSAnnotation() {
		return (new SPOSAnnotationImpl());
	}

	/**
	 * Creates a new {@link SLemmaAnnotation} object.
	 * 
	 * @return new {@link SLemmaAnnotation} object
	 */
	public SLemmaAnnotation createSLemmaAnnotation() {
		return (new SLemmaAnnotationImpl());
	}

	/**
	 * Creates a new {@link STypeAnnotation} object.
	 * 
	 * @return new {@link STypeAnnotation} object
	 */
	public STypeAnnotation createSTypeAnnotation() {
		return (new STypeAnnotationImpl());
	}

	/**
	 * Creates a new {@link SWordAnnotation} object.
	 * 
	 * @return new {@link SWordAnnotation} object
	 */
	public SWordAnnotation createSWordAnnotation() {
		return (new SWordAnnotationImpl());
	}

	/**
	 * Creates a new {@link SSentenceAnnotation} object.
	 * 
	 * @return new {@link SSentenceAnnotation} object
	 */
	public SSentenceAnnotation createSSentenceAnnotation() {
		return (new SSentenceAnnotationImpl());
	}
	// ===============================< semantics
}