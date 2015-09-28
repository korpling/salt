package de.hu_berlin.u.saltnpepper.salt;

import de.hu_berlin.u.saltnpepper.graph.IGraphFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
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
import de.hu_berlin.u.saltnpepper.salt.semantics.SCatAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SLemmaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SPOSAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SSentenceAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.STypeAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SWordAnnotation;

public interface ISaltFactory extends IGraphFactory {
	/**
	 * Creates a new {@link SGraph} object of type {@link SGraphImpl}.
	 * 
	 * @return new {@link SGraph} object
	 */
	public SGraph createSGraph();

	/**
	 * Creates a new {@link SNode} object of type {@link SNodeImpl}.
	 * 
	 * @return new {@link SNode} object
	 */
	public SNode createSNode();

	/**
	 * Creates a new {@link SRelation} object of type {@link SRelationImpl}.
	 * 
	 * @return new {@link SRelation} object
	 */
	public SRelation<SNode, SNode> createSRelation();

	/**
	 * Creates a new {@link SAnnotation} object of type {@link SAnnotationImpl}.
	 * 
	 * @return new {@link SAnnotation} object
	 */
	public SAnnotation createSAnnotation();

	/**
	 * Creates a new {@link SMetaAnnotation} object of type
	 * {@link SMetaAnnotationImpl}.
	 * 
	 * @return new {@link SMetaAnnotation} object
	 */
	public SMetaAnnotation createSMetaAnnotation();

	/**
	 * Creates a new {@link SProcessingAnnotation} object of type
	 * {@link SProcessingAnnotationImpl}.
	 * 
	 * @return new {@link SProcessingAnnotation} object
	 */
	public SProcessingAnnotation createSProcessingAnnotation();

	/**
	 * Creates a new {@link SFeature} object of type {@link SFeatureImpl}.
	 * 
	 * @return new {@link SFeature} object
	 */
	public SFeature createSFeature();

	/**
	 * Creates a new {@link SLayer} object of type {@link SLayerImpl}.
	 * 
	 * @return new {@link SLayer} object
	 */
	public SLayer createSLayer();

	/**
	 * Creates a new {@link SaltProject}.
	 * 
	 * @return new {@link SaltProject} object
	 */
	public SaltProject createSaltProject();

	// ===============================> corpus structure
	/**
	 * Creates a new {@link SCorpus} object.
	 * 
	 * @return new {@link SCorpus} object
	 */
	public SCorpus createSCorpus();

	/**
	 * Creates a new {@link SDocument} object.
	 * 
	 * @return new {@link SDocument} object
	 */
	public SDocument createSDocument();

	/**
	 * Creates a new {@link SCorpusRelation} object.
	 * 
	 * @return new {@link SCorpusRelation} object
	 */
	public SCorpusRelation createSCorpusRelation();

	/**
	 * Creates a new {@link SCorpusDocumentRelation} object.
	 * 
	 * @return new {@link SCorpusDocumentRelation} object
	 */
	public SCorpusDocumentRelation createSCorpusDocumentRelation();

	/**
	 * Creates a new {@link SCorpusGraph} object.
	 * 
	 * @return new {@link SCorpusGraph} object
	 */
	public SCorpusGraph createSCorpusGraph();

	// ===============================< corpus structure
	// ===============================> document structure
	/**
	 * Creates a new {@link SDocumentGraph} object.
	 * 
	 * @return new {@link SDocumentGraph} object
	 */
	public SDocumentGraph createSDocumentGraph();

	/**
	 * Creates a new {@link SSpanningRelation} object.
	 * 
	 * @return new {@link SSpanningRelation} object
	 */
	public SSpanningRelation createSSpanningRelation();

	/**
	 * Creates a new {@link SDominanceRelation} object.
	 * 
	 * @return new {@link SDominanceRelation} object
	 */
	public SDominanceRelation createSDominanceRelation();

	/**
	 * Creates a new {@link SPointingRelation} object.
	 * 
	 * @return new {@link SPointingRelation} object
	 */
	public SPointingRelation createSPointingRelation();

	/**
	 * Creates a new {@link SOrderRelation} object.
	 * 
	 * @return new {@link SOrderRelation} object
	 */
	public SOrderRelation createSOrderRelation();

	/**
	 * Creates a new {@link STextualRelation} object.
	 * 
	 * @return new {@link STextualRelation} object
	 */
	public STextualRelation createSTextualRelation();

	/**
	 * Creates a new {@link STimelineRelation} object.
	 * 
	 * @return new {@link STimelineRelation} object
	 */
	public STimelineRelation createSTimelineRelation();

	/**
	 * Creates a new {@link SMedialRelation} object.
	 * 
	 * @return new {@link SMedialRelation} object
	 */
	public SMedialRelation createSMedialRelation();

	/**
	 * Creates a new {@link SSpan} object.
	 * 
	 * @return new {@link SSpan} object
	 */
	public SSpan createSSpan();

	/**
	 * Creates a new {@link SStructure} object.
	 * 
	 * @return new {@link SStructure} object
	 */
	public SStructure createSStructure();

	/**
	 * Creates a new {@link STextualDS} object.
	 * 
	 * @return new {@link STextualDS} object
	 */
	public STextualDS createSTextualDS();

	/**
	 * Creates a new {@link SMedialDS} object.
	 * 
	 * @return new {@link SMedialDS} object
	 */
	public SMedialDS createSMedialDS();

	/**
	 * Creates a new {@link STimeline} object.
	 * 
	 * @return new {@link STimeline} object
	 */
	public STimeline createSTimeline();

	/**
	 * Creates a new {@link SToken} object.
	 * 
	 * @return new {@link SToken} object
	 */
	public SToken createSToken();

	// ===============================< document structure
	// ===============================> semantics
	/**
	 * Creates a new {@link SCatAnnotation} object.
	 * 
	 * @return new {@link SCatAnnotation} object
	 */
	public SCatAnnotation createSCatAnnotation();

	/**
	 * Creates a new {@link SPOSAnnotation} object.
	 * 
	 * @return new {@link SPOSAnnotation} object
	 */
	public SPOSAnnotation createSPOSAnnotation();

	/**
	 * Creates a new {@link SLemmaAnnotation} object.
	 * 
	 * @return new {@link SLemmaAnnotation} object
	 */
	public SLemmaAnnotation createSLemmaAnnotation();

	/**
	 * Creates a new {@link STypeAnnotation} object.
	 * 
	 * @return new {@link STypeAnnotation} object
	 */
	public STypeAnnotation createSTypeAnnotation();

	/**
	 * Creates a new {@link SWordAnnotation} object.
	 * 
	 * @return new {@link SWordAnnotation} object
	 */
	public SWordAnnotation createSWordAnnotation();

	/**
	 * Creates a new {@link SSentenceAnnotation} object.
	 * 
	 * @return new {@link SSentenceAnnotation} object
	 */
	public SSentenceAnnotation createSSentenceAnnotation();
	// ===============================< semantics
}