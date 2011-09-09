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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;


/**
 * In Salt a document is represented by this class. An object of this class can contain an object of type {@link SDocumentGraph} which contains
 * the 'real' linguistic data. An object of type {@link SDocumentGraph} can be set and get by calling {@link SDocument#setSDocumentGraph(SDocumentGraph)} and 
 * {@link SDocument#getSDocumentGraph()}. A closer documentation of a document graph, you can find in {@link SDocumentGraph}. A document must always be contained in a corpus (object of type {@link SCorpus}). Such a containment relation
 * in Salt is represented by an object of type {@link SCorpusRelation}. How to add a {@link SDocument} object to a {@link SCorpusGraph} object
 * please see the documentation of {@link SCorpusGraph}. 
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSDocument()
 * @model
 * @generated
 */
public interface SDocument extends SNode {
	/**
	 * Returns the value of the '<em><b>SCorpus Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments <em>SDocuments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Graph</em>' container reference.
	 * @see #setSCorpusGraph(SCorpusGraph)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSDocument_SCorpusGraph()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments
	 * @model opposite="sDocuments" volatile="true" derived="true"
	 * @generated
	 */
	SCorpusGraph getSCorpusGraph();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph <em>SCorpus Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SCorpus Graph</em>' container reference.
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	void setSCorpusGraph(SCorpusGraph value);

	/**
	 * Returns the value of the '<em><b>SDocument Graph</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument Graph</em>' reference.
	 * @see #setSDocumentGraph(SDocumentGraph)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSDocument_SDocumentGraph()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument
	 * @model opposite="sDocument"
	 * @generated
	 */
	SDocumentGraph getSDocumentGraph();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph <em>SDocument Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument Graph</em>' reference.
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	void setSDocumentGraph(SDocumentGraph value);

} // SDocument
