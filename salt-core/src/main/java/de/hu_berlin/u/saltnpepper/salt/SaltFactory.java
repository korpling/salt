package de.hu_berlin.u.saltnpepper.salt;

import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.impl.SaltFactoryImpl;

public class SaltFactory {
	/** Internal factory Impl<Node, Relation<Node, Node>>()which is used to create objects. **/
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
	// ===============================< document structure
}