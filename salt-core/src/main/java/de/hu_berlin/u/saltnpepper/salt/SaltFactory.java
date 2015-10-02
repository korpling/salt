package de.hu_berlin.u.saltnpepper.salt;

import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.impl.IdentifierImpl;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SMedialDS;
import de.hu_berlin.u.saltnpepper.salt.common.SMedialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.STimeline;
import de.hu_berlin.u.saltnpepper.salt.common.STimelineRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SToken;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.impl.SaltFactoryImpl;
import de.hu_berlin.u.saltnpepper.salt.semantics.SCatAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SLemmaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SPOSAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SSentenceAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.STypeAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SWordAnnotation;

public class SaltFactory {
	/**
	 * Internal factory Impl<Node, Relation<Node, Node>>()which is used to
	 * create objects.
	 **/
	private static ISaltFactory factory = new SaltFactoryImpl();

	/**
	 * Sets the internal factory to create Salt objects. You can inject an own
	 * factory with this method.
	 * 
	 * @return the internal factory.
	 */
	public static ISaltFactory getFactory() {
		return factory;
	}

	/**
	 * Returns the internal factory to create Salt objects.
	 * 
	 * @param factory
	 *            internal factory
	 */
	public static void setFactory(ISaltFactory factory) {
		SaltFactory.factory = factory;
	}
	// ===============================> graph
	/**
	 * Creates a new {@link Identifier} object of type {@link IdentifierImpl}.
	 * Its {@link IdentifiableElement} is set to the passed container and its id
	 * value is set to passed id.
	 * 
	 * @param container
	 *            {@link IdentifiableElement} which contains this
	 *            {@link Identifier}
	 * @param id
	 *            the id value of the {@link Identifier}
	 * @return new {@link Identifier} object
	 */
	public static Identifier createIdentifier(IdentifiableElement container, String id){
		return (factory.createIdentifier(container, id));
	}
	// ===============================< graph
	// ===============================> salt core
	/**
	 * Creates a new {@link SGraph} object of type {@link SGraph}.
	 * 
	 * @return new {@link SGraph} object
	 */
	public static SGraph createSGraph() {
		return (factory.createSGraph());
	}

	/**
	 * Creates a new {@link SNode} object of type {@link SNode}.
	 * 
	 * @return new {@link SNode} object
	 */
	public static SNode createSNode() {
		return (factory.createSNode());
	}

	/**
	 * Creates a new {@link SRelation} object of type {@link SRelation}.
	 * 
	 * @return new {@link SRelation} object
	 */
	public static SRelation<SNode, SNode> createSRelation() {
		return (factory.createSRelation());
	}

	/**
	 * Creates a new {@link SAnnotation} object of type {@link SAnnotation}.
	 * 
	 * @return new {@link SAnnotation} object
	 */
	public static SAnnotation createSAnnotation() {
		return (factory.createSAnnotation());
	}

	/**
	 * Creates a new {@link SMetaAnnotation} object of type
	 * {@link SMetaAnnotation}.
	 * 
	 * @return new {@link SMetaAnnotation} object
	 */
	public static SMetaAnnotation createSMetaAnnotation() {
		return (factory.createSMetaAnnotation());
	}

	/**
	 * Creates a new {@link SProcessingAnnotation} object of type
	 * {@link SProcessingAnnotation}.
	 * 
	 * @return new {@link SProcessingAnnotation} object
	 */
	public static SProcessingAnnotation createSProcessingAnnotation() {
		return (factory.createSProcessingAnnotation());
	}

	/**
	 * Creates a new {@link SFeature} object of type {@link SFeature}.
	 * 
	 * @return new {@link SFeature} object
	 */
	public static SFeature createSFeature() {
		return (factory.createSFeature());
	}

	/**
	 * Creates a new {@link SLayer} object of type {@link SLayer}.
	 * 
	 * @return new {@link SLayer} object
	 */
	public static SLayer createSLayer() {
		return (factory.createSLayer());
	}

	// ===============================< salt core

	/**
	 * Creates a new {@link SaltProject}.
	 * 
	 * @return new {@link SaltProject} object
	 */
	public static SaltProject createSaltProject() {
		return (factory.createSaltProject());
	}

	// ===============================> corpus structure
	/**
	 * Creates a new {@link SCorpus} object.
	 * 
	 * @return new {@link SCorpus} object
	 */
	public static SCorpus createSCorpus() {
		return (factory.createSCorpus());
	}

	/**
	 * Creates a new {@link SDocument} object.
	 * 
	 * @return new {@link SDocument} object
	 */
	public static SDocument createSDocument() {
		return (factory.createSDocument());
	}

	/**
	 * Creates a new {@link SCorpusRelation} object.
	 * 
	 * @return new {@link SCorpusRelation} object
	 */
	public static SCorpusRelation createSCorpusRelation() {
		return (factory.createSCorpusRelation());
	}

	/**
	 * Creates a new {@link SCorpusDocumentRelation} object.
	 * 
	 * @return new {@link SCorpusDocumentRelation} object
	 */
	public static SCorpusDocumentRelation createSCorpusDocumentRelation() {
		return (factory.createSCorpusDocumentRelation());
	}

	/**
	 * Creates a new {@link SCorpusGraph} object.
	 * 
	 * @return new {@link SCorpusGraph} object
	 */
	public static SCorpusGraph createSCorpusGraph() {
		return (factory.createSCorpusGraph());
	}

	// ===============================< corpus structure

	// ===============================> document structure
	/**
	 * Creates a new {@link SDocumentGraph} object.
	 * 
	 * @return new {@link SDocumentGraph} object
	 */
	public static SDocumentGraph createSDocumentGraph() {
		return (factory.createSDocumentGraph());
	}

	/**
	 * Creates a new {@link SSpanningRelation} object.
	 * 
	 * @return new {@link SSpanningRelation} object
	 */
	public static SSpanningRelation createSSpanningRelation() {
		return (factory.createSSpanningRelation());
	}

	/**
	 * Creates a new {@link SDominanceRelation} object.
	 * 
	 * @return new {@link SDominanceRelation} object
	 */
	public static SDominanceRelation createSDominanceRelation() {
		return (factory.createSDominanceRelation());
	}

	/**
	 * Creates a new {@link SPointingRelation} object.
	 * 
	 * @return new {@link SPointingRelation} object
	 */
	public static SPointingRelation createSPointingRelation() {
		return (factory.createSPointingRelation());
	}

	/**
	 * Creates a new {@link SOrderRelation} object.
	 * 
	 * @return new {@link SOrderRelation} object
	 */
	public static SOrderRelation createSOrderRelation() {
		return (factory.createSOrderRelation());
	}

	/**
	 * Creates a new {@link STextualRelation} object.
	 * 
	 * @return new {@link STextualRelation} object
	 */
	public static STextualRelation createSTextualRelation() {
		return (factory.createSTextualRelation());
	}

	/**
	 * Creates a new {@link STimelineRelation} object.
	 * 
	 * @return new {@link STimelineRelation} object
	 */
	public static STimelineRelation createSTimelineRelation() {
		return (factory.createSTimelineRelation());
	}

	/**
	 * Creates a new {@link SMedialRelation} object.
	 * 
	 * @return new {@link SMedialRelation} object
	 */
	public static SMedialRelation createSMedialRelation() {
		return (factory.createSMedialRelation());
	}

	/**
	 * Creates a new {@link SSpan} object.
	 * 
	 * @return new {@link SSpan} object
	 */
	public static SSpan createSSpan() {
		return (factory.createSSpan());
	}

	/**
	 * Creates a new {@link SStructure} object.
	 * 
	 * @return new {@link SStructure} object
	 */
	public static SStructure createSStructure() {
		return (factory.createSStructure());
	}

	/**
	 * Creates a new {@link STextualDS} object.
	 * 
	 * @return new {@link STextualDS} object
	 */
	public static STextualDS createSTextualDS() {
		return (factory.createSTextualDS());
	}

	/**
	 * Creates a new {@link SMedialDS} object.
	 * 
	 * @return new {@link SMedialDS} object
	 */
	public static SMedialDS createSMedialDS() {
		return (factory.createSMedialDS());
	}

	/**
	 * Creates a new {@link STimeline} object.
	 * 
	 * @return new {@link STimeline} object
	 */
	public static STimeline createSTimeline() {
		return (factory.createSTimeline());
	}

	/**
	 * Creates a new {@link SToken} object.
	 * 
	 * @return new {@link SToken} object
	 */
	public static SToken createSToken() {
		return (factory.createSToken());
	}

	// ===============================< document structure
	// ===============================> semantics
	/**
	 * Creates a new {@link SCatAnnotation} object.
	 * 
	 * @return new {@link SCatAnnotation} object
	 */
	public static SCatAnnotation createSCatAnnotation() {
		return (factory.createSCatAnnotation());
	}

	/**
	 * Creates a new {@link SPOSAnnotation} object.
	 * 
	 * @return new {@link SPOSAnnotation} object
	 */
	public static SPOSAnnotation createSPOSAnnotation() {
		return (factory.createSPOSAnnotation());
	}

	/**
	 * Creates a new {@link SLemmaAnnotation} object.
	 * 
	 * @return new {@link SLemmaAnnotation} object
	 */
	public static SLemmaAnnotation createSLemmaAnnotation() {
		return (factory.createSLemmaAnnotation());
	}

	/**
	 * Creates a new {@link STypeAnnotation} object.
	 * 
	 * @return new {@link STypeAnnotation} object
	 */
	public static STypeAnnotation createSTypeAnnotation() {
		return (factory.createSTypeAnnotation());
	}

	/**
	 * Creates a new {@link SWordAnnotation} object.
	 * 
	 * @return new {@link SWordAnnotation} object
	 */
	public static SWordAnnotation createSWordAnnotation() {
		return (factory.createSWordAnnotation());
	}

	/**
	 * Creates a new {@link SSentenceAnnotation} object.
	 * 
	 * @return new {@link SSentenceAnnotation} object
	 */
	public static SSentenceAnnotation createSSentenceAnnotation() {
		return (factory.createSSentenceAnnotation());
	}
	// ===============================< semantics
}