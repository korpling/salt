package org.corpus_tools.salt.impl;

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
import org.corpus_tools.salt.common.SaltProject;
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
import org.corpus_tools.salt.common.impl.SaltProjectImpl;
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
import org.corpus_tools.salt.graph.impl.GraphFactoryImpl;
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