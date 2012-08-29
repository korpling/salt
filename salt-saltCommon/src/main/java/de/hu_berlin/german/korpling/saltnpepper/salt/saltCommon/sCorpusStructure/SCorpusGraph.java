/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

/**
 * In Salt it is possible to create a treelike corpus structure to create hierarchies between corpora. A hierarchie means that one corpus 
 * can contain other corpora. The contained corpora are called subcorpora for the containing corpus and the containing corpus is the super
 * corpus of the contained ones. If a corpus does not have a super corpus it is called the root corpus, if a corpus does not have sub corpora it 
 * is called a leaf corpus.<br/> 
 * In Salt such a treelike structure is represented by an object of type {@link SCorpusGraph}. A corpus is represented
 * by an object of type {@link SCorpus} and can be added to a {@link SCorpusGraph} object. To create a hierarchical relation
 * between to corpora we used the object {@link SCorpusRelation} to connect to objects of type {@link SCorpus}, where the super corpus
 * is the source of that relation and the sub corpus is the target of that relation. A corpus can have an unbound number of sub corpora.
 * To create such an relation in the {@link SCorpusGraph}, you first have to add the super corpus (for instance by calling {@link SCorpusGraph#addSNode(SNode)}) 
 * and second you can add the sub corpus by calling {@link SCorpusGraph#addSSubCorpus(SCorpus, SCorpus)}. This will automatically create the 
 * relation between both corpora and returns a pointer to the relation. Another way to do this is to add both corpora by calling {@link SCorpusGraph#addSSubCorpus(SCorpus, SCorpus)}, creating
 * a relation of type {@link SCorpusRelation}, setting its source to the super corpus, setting its target to the sub corpus and adding the
 * relation to the {@link SCorpusGraph} object by calling {@link SCorpusGraph#addSRelation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation)}.
 * But note, that first the second way contains more handwork and second it is recommended to use the first appoach, because the {@link SElementId} object
 * belonging to the sub corpus can only represent the hierarchy, when the {@link SCorpusGraph} knows about it, when adding the sub corpus.
 * </br>
 * The 'real' linguistic data containing primary data, tokens, structures, annotations and so on are contained in lets say a container-object
 * called document. Such a document is represented by the type {@link SDocument}. A document always belongs to a corpus (if this corpus
 * is a super or a sub corpus makes no difference). Parallel to a corpus, a document is a specialization of a node (in Salt of type {@link SNode}) 
 * as well. Such a containment between a corpus and a document is represented by the type {@link SCorpusDocumentRelation}, where the source
 * of this relation is the corpus and the target of this relation is the document. To add such a {@link SDocument} object to the {@link SCorpusGraph}
 * use the method {@link SCorpusGraph#addSDocument(SCorpus, SDocument)}. This method will automatically create the relation between them.
 * Like with adding a sub corpus, here you can also do this by hand hand, but note that even here it is recommended using the method {@link SCorpusGraph#addSDocument(SCorpus, SDocument)}
 * because of the {@link SElementId} object belonging to the {@link SDocument} object.</br>
 * In Salt the 'real' linguistic data are also stored in a graph called document-graph which is represented by the type {@link SDocumentGraph}. An 
 * object of this type is contained in a {@link SDocument} object and can be set and get by calling {@link SDocument#setSDocumentGraph(SDocumentGraph)} and 
 * {@link SDocument#getSDocumentGraph()}. A closer documentation of a document graph, you can find in {@link SDocumentGraph}.
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments <em>SDocuments</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject <em>Salt Project</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora <em>SCorpora</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations <em>SCorpus Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations <em>SCorpus Document Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph()
 * @model
 * @generated
 */
public interface SCorpusGraph extends SGraph {
	/**
	 * Returns the value of the '<em><b>SDocuments</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocuments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocuments</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph_SDocuments()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph
	 * @model opposite="sCorpusGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SDocument> getSDocuments();

	/**
	 * Returns the value of the '<em><b>Salt Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSCorpusGraphs <em>SCorpus Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Salt Project</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salt Project</em>' container reference.
	 * @see #setSaltProject(SaltProject)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph_SaltProject()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSCorpusGraphs
	 * @model opposite="sCorpusGraphs" transient="false"
	 * @generated
	 */
	SaltProject getSaltProject();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject <em>Salt Project</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Salt Project</em>' container reference.
	 * @see #getSaltProject()
	 * @generated
	 */
	void setSaltProject(SaltProject value);

	/**
	 * Returns the value of the '<em><b>SCorpora</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpora</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpora</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph_SCorpora()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph
	 * @model opposite="sCorpusGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SCorpus> getSCorpora();

	/**
	 * Returns the value of the '<em><b>SCorpus Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Relations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph_SCorpusRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph
	 * @model opposite="sCorpusGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SCorpusRelation> getSCorpusRelations();

	/**
	 * Returns the value of the '<em><b>SCorpus Document Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Document Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Document Relations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph_SCorpusDocumentRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph
	 * @model opposite="sCorpusGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SCorpusDocumentRelation> getSCorpusDocumentRelations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SCorpus getSCorpus(SElementId sCorpusId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SDocument getSDocument(SElementId sDocumentId);

	/**
	 * Adds the given sSubCorpus to the SCorpusGraph object and creates an SCorpusRelation between the given sSuperCorpus
	 * and the sSubCorpus, if and only if the sSuperCorpus is already added to this object. Otherwise an exception will
	 * be thrown. The method returns the SElementId for the generated SCorpusRelation object.
	 * @param sSuperCorpus corpus which already has to be added
	 * @param sSubCorpus corpus to add
	 * @return the SElementId for the generated SCorpusRelation object.
	 * @model
	 * @generated
	 */
	SElementId addSSubCorpus(SCorpus sSuperCorpus, SCorpus sSubCorpus);

	/**
	 * Adds the given sDocument to the SCorpusGraph object and creates an SCorpusDocumentRelation between the given 
	 * sCorpus and the sDocument, if and only if the sCorpus is already added to this object. Otherwise an exception will
	 * be thrown. The method returns the SElementId for the generated SCorpusDocumentRelation object.
	 * @param sCorpus corpus to which the document has to be added
	 * @param sDocument document to add
	 * @return the SElementId for the generated SCorpusDocumentRelation object
	 * @model
	 * @generated
	 */
	SElementId addSDocument(SCorpus sCorpus, SDocument sDocument);

	/**
	 * Returns the SCorpus object, which contains the given SDocument object (means the SCorpus object and the given 
	 * SDocument object must be connected via a SCorpusDocumentRelation object).  
	 * @param sDocument the SDocument object beyond the SCorpus object to be returned
	 * @return the SCorpus object containing sDocument
	 * @model
	 * @generated
	 */
	SCorpus getSCorpus(SDocument sDocument);

	/**
	 * Returns a list of SCorpus object being the root corpora of this SCorpusGraph object. 
	 * @model kind="operation"
	 * @return a list of corpus objects being root corpora
	 * @generated
	 */
	EList<SCorpus> getSRootCorpus();

	/**
	 * Loads the content of this object by reading the SaltXML file located by the given {@link URI}. 
	 * The SaltXML file can either contain a {@link SaltProject}, than the first {@link SCorpusGraph} 
	 * object is loaded or just a {@link SCorpusGraph} object.
	 * @param sCorpusGraphUri loaction of the SaltXML file
	 * @model sCorpusGraphUriDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void load(URI sCorpusGraphUri);

} // SCorpusGraph
