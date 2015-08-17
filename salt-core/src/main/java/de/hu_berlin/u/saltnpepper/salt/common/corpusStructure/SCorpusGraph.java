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
package de.hu_berlin.u.saltnpepper.salt.common.corpusStructure;

import java.util.List;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;

/**
 * In Salt it is possible to create a treelike corpus structure to create
 * hierarchies between corpora. A hierarchie means that one corpus can contain
 * other corpora. The contained corpora are called subcorpora for the containing
 * corpus and the containing corpus is the super corpus of the contained ones.
 * If a corpus does not have a super corpus it is called the root corpus, if a
 * corpus does not have sub corpora it is called a leaf corpus.<br/>
 * In Salt such a treelike structure is represented by an object of type
 * {@link SCorpusGraph}. A corpus is represented by an object of type
 * {@link SCorpus} and can be added to a {@link SCorpusGraph} object. To create
 * a hierarchical relation between to corpora we used the object
 * {@link SCorpusRelation} to connect to objects of type {@link SCorpus}, where
 * the super corpus is the source of that relation and the sub corpus is the
 * target of that relation. A corpus can have an unbound number of sub corpora.
 * To create such an relation in the {@link SCorpusGraph}, you first have to add
 * the super corpus (for instance by calling
 * {@link SCorpusGraph#addSNode(SNode)}) and second you can add the sub corpus
 * by calling {@link SCorpusGraph#addSSubCorpus(SCorpus, SCorpus)}. This will
 * automatically create the relation between both corpora and returns a pointer
 * to the relation. Another way to do this is to add both corpora by calling
 * {@link SCorpusGraph#addSSubCorpus(SCorpus, SCorpus)}, creating a relation of
 * type {@link SCorpusRelation}, setting its source to the super corpus, setting
 * its target to the sub corpus and adding the relation to the
 * {@link SCorpusGraph} object by calling
 * {@link SCorpusGraph#addSRelation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation)}
 * . But note, that first the second way contains more handwork and second it is
 * recommended to use the first appoach, because the {@link SElementId} object
 * belonging to the sub corpus can only represent the hierarchy, when the
 * {@link SCorpusGraph} knows about it, when adding the sub corpus. </br> The
 * 'real' linguistic data containing primary data, tokens, structures,
 * annotations and so on are contained in lets say a container-object called
 * document. Such a document is represented by the type {@link SDocument}. A
 * document always belongs to a corpus (if this corpus is a super or a sub
 * corpus makes no difference). Parallel to a corpus, a document is a
 * specialization of a node (in Salt of type {@link SNode}) as well. Such a
 * containment between a corpus and a document is represented by the type
 * {@link SCorpusDocumentRelation}, where the source of this relation is the
 * corpus and the target of this relation is the document. To add such a
 * {@link SDocument} object to the {@link SCorpusGraph} use the method
 * {@link SCorpusGraph#addDocument(SCorpus, SDocument)}. This method will
 * automatically create the relation between them. Like with adding a sub
 * corpus, here you can also do this by hand hand, but note that even here it is
 * recommended using the method
 * {@link SCorpusGraph#addDocument(SCorpus, SDocument)} because of the
 * {@link SElementId} object belonging to the {@link SDocument} object.</br> In
 * Salt the 'real' linguistic data are also stored in a graph called
 * document-graph which is represented by the type {@link SDocumentGraph}. An
 * object of this type is contained in a {@link SDocument} object and can be set
 * and get by calling {@link SDocument#setSDocumentGraph(SDocumentGraph)} and
 * {@link SDocument#getDocumentGraph()}. A closer documentation of a document
 * graph, you can find in {@link SDocumentGraph}.
 * 
 * @author florian
 */
public interface SCorpusGraph extends SGraph {
	/**
	 * Returns the salt project, to which this corpus structure belongs to.
	 * 
	 * @return salt project containing this corpus structure
	 */
	public SaltProject getSaltProject();

	/**
	 * Sets the salt project, to which this corpus structure belongs to.
	 * 
	 * @param saltProject
	 *            salt project containing this corpus structure
	 */
	public void setSaltProject(SaltProject saltProject);

	/**
	 * Returns all documents objects contained in this corpus structure.
	 * 
	 * @return all contained documents
	 */
	public List<SDocument> getDocuments();

	/**
	 * Returns all corpora contained in this corpus structure.
	 * 
	 * @return all contained corpora
	 */
	public List<SCorpus> getCorpora();

	/**
	 * Returns all corpus-corpus relations contained in this corpus structure.
	 * 
	 * @return all contained corpus-corpus relations
	 */
	public List<SCorpusRelation> getCorpusRelations();

	/**
	 * Returns all corpus-document relations contained in this corpus structure.
	 * 
	 * @return all contained corpus-document relations
	 */
	public List<SCorpusDocumentRelation> getCorpusDocumentRelations();

	/**
	 * Returns a corpus matching the passed identifier if such a corpus is
	 * contained in this corpus structure. If no such corpus is contained, null
	 * is returned.
	 * 
	 * @param corpusId
	 *            identifier corresponding to the corpus to be searched
	 * @return corpus matching the identifier, null if no such corpus exists
	 */
	public SCorpus getCorpus(Identifier corpusId);

	/**
	 * Returns a document matching the passed identifier if such a document is
	 * contained in this document structure. If no such document is contained,
	 * null is returned.
	 * 
	 * @param documentId
	 *            identifier corresponding to the document to be searched
	 * @return document matching the identifier, null if no such document exists
	 */
	public SDocument getDocument(Identifier documentId);

	/**
	 * Adds the given sSubCorpus to the SCorpusGraph object and creates an
	 * {@link SCorpusRelation} between the given super corpus and the sub
	 * corpus, if and only if the super corpus is already added to this object.
	 * Otherwise an exception will be thrown. The method returns the identifier
	 * for the generated {@link SCorpusRelation} object.
	 * 
	 * @param superCorpus
	 *            corpus which already has to be added
	 * @param subCorpus
	 *            corpus to add
	 * @return the identifier for the generated {@link SCorpusRelation} object.
	 * @model
	 * @generated
	 */
	public Identifier addSubCorpus(SCorpus superCorpus, SCorpus subCorpus);

	/**
	 * Adds the given document to the {@link SCorpusGraph} object and creates an
	 * {@link SCorpusDocumentRelation} between the given corpus and the
	 * document, if and only if the corpus is already added to this object.
	 * Otherwise an exception will be thrown. The method returns the
	 * {@link Identifier} for the generated {@link SCorpusDocumentRelation}
	 * object.
	 * 
	 * @param corpus
	 *            corpus to which the document has to be added
	 * @param document
	 *            document to add
	 * @return the identifier for the generated {@link SCorpusDocumentRelation}
	 *         object
	 */
	public Identifier addDocument(SCorpus corpus, SDocument document);

	/**
	 * Returns the {@link SCorpus} object, which contains the given
	 * {@link SDocument} object (means the {@link SCorpus} object and the given
	 * {@link SDocument} object must be connected via a
	 * {@link SCorpusDocumentRelation} object).
	 * 
	 * @param document
	 *            the {@link SDocument} object beyond the {@link SCorpus} object
	 *            to be returned
	 * @return the {@link SCorpus} object containing document
	 */
	public SCorpus getCorpus(SDocument document);

	// /**
	// * Returns a list of SCorpus object being the root corpora of this
	// * SCorpusGraph object.
	// *
	// * @model kind="operation"
	// * @return a list of corpus objects being root corpora
	// * @generated
	// */
	// EList<SCorpus> getRootCorpus();

	/**
	 * Loads the content of this object by reading the SaltXML file located by
	 * the given {@link URI}. The SaltXML file can either contain a
	 * {@link SaltProject}, than the first {@link SCorpusGraph} object is loaded
	 * or just a {@link SCorpusGraph} object.
	 * 
	 * @param corpusGraphUri
	 *            loaction of the SaltXML file
	 */
	public void load(URI corpusGraphUri);

	/**
	 * Creates a new {@link SCorpus} object having the name
	 * <code>corpusName</code>. The new created {@link SCorpus} object is added
	 * as a sub corpus to the passed <code>superCorpus</code>. An
	 * {@link SCorpusRelation} is created to connect them. The new created
	 * {@link SCorpus} is returned. If <code>superSCorpus</code> does not exist,
	 * a root corpus is created.
	 * 
	 * @param superCorpus
	 *            the parent {@link SCorpus} object
	 * @param corpusName
	 *            the name of the {@link SCorpus} object to be new created
	 * @return the new created {@link SCorpus} object
	 */
	public SCorpus createSCorpus(SCorpus superCorpus, String corpusName);

	/**
	 * Creates a {@link SDocument} object having the name
	 * <code>documentName</code> and is added to the given
	 * <code>parentCorpus</code> via a {@link SCorpusDocumentRelation}.
	 * 
	 * @param parentCorpus
	 *            the parent {@link SCorpus} object
	 * @param documentName
	 *            the name of the {@link SDocument} object to be new created
	 * @return the new created {@link SDocument} object <!-- end-model-doc -->
	 */
	public SDocument createSDocument(SCorpus parentCorpus, String documentName);

	/**
	 * Creates all {@link SCorpus} objects contained in the passed
	 * <code>corpusPath</code> and returns a list of all {@link SCorpus}
	 * objects.
	 * 
	 * @param corpusPath
	 *            the URI path of corpora
	 * @return all created {@link SCorpus} objects <!-- end-model-doc -->
	 */
	public List<SCorpus> createSCorpus(URI corpusPath);

	/**
	 * Creates all {@link SCorpus} objects contained in the passed corpusPath
	 * and assumes, that the last segment is a {@link SDocument} object. The
	 * created {@link SDocument} than is returned.
	 * 
	 * @param documentPath
	 *            the URI path of the document
	 * @return the created document
	 */
	public SDocument createSDocument(URI documentPath);

} // SCorpusGraph
