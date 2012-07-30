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
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SFEATURE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import org.eclipse.emf.common.util.URI;


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
	
	/**
	 * Returns the value of the '<em><b>SDocument Graph Location</b></em>' attribute.
	 * Returns the location of the contained {@link SDocumentGraph} object, in case it is persisted.
	 *  The location is stored via a {@link SFeature} object having the namespace 
	 * {@value SaltFactory#NAMESPACE_SALT} and the name {@value SFEATURE_NAME#SDOCUMENT_GRAPH_LOCATION}.
	 * @return location of persisted {@link SDocumentGraph} object as {@link URI}
	 * @see #setSDocumentGraphLocation(URI)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSDocument_SDocumentGraphLocation()
	 * @model dataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	URI getSDocumentGraphLocation();

	/**
	 * Sets the location as {@link URI}, of where the contained {@link SDocumentGraph} object is persisted.
	 * The location is stored as {@link SFeature} having the namespace
	 * {@value SaltFactory#NAMESPACE_SALT} and the name {@value SFEATURE_NAME#SDOCUMENT_GRAPH_LOCATION}.
	 * @param newSDocumentGraphLocation location as {@link URI} 
	 * @see #getSDocumentGraphLocation()
	 * @generated
	 */
	void setSDocumentGraphLocation(URI value);

	/**
	 * Persists the {@link SDocumentGraph} object contained by this object as SaltXML file at the 
	 * location given by the passed {@link URI} object.
	 * The {@link URI} is stored as {@link SFeature} by calling {@link #setSDocumentGraphLocation(URI)}. 
	 * The containment relation of {@link SDocument} and given {@link SDocumentGraph} will be removed. 
	 * @param sDocumentGraphLocation location of where to persist object as {@link URI}
	 * @model sDocumentGraphLocationDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void saveSDocumentGraph(URI sDocumentGraphLocation);

	/**
	 * Loads a {@link SDocumentGraph} object and sets it to the contained {@link SDocumentGraph} object. The
	 * location of where to find the SaltXML containing the {@link SDocumentGraph} object must be given as 
	 * {@link SFeature}. It will be read via calling {@link #getSDocumentGraphLocation()}. 
	 * After loading, the feature accessible via {@link #getSDocumentGraphLocation()} will be removed.
	 * @model
	 * @generated
	 */
	void loadSDocumentGraph();

	/**
	 * Loads a {@link SDocumentGraph} object and sets it to the contained {@link SDocumentGraph} object. The
	 * location of where to find the SaltXML containing the {@link SDocumentGraph} object is given by the
	 * passed {@link URI} object.
	 * After loading, the feature accessible via {@link #getSDocumentGraphLocation()} if exist will be removed.
	 * @param sDocumentGraphLocation location of SaltXML to load {@link SDocumentGraph} object.
	 * @model sDocumentGraphLocationDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void loadSDocumentGraph(URI sDocumentGraphLocation);

	/**
	 * Returns a {@link SDocument} object having the same properties like this. This means, all labels (annotations, meta-annotations and so on)
	 * will also be cloned. These clones will be set to the cloned {@link SDocument} object.   
	 * @return {@link SDocument} object as copy of this 
	 */
	Object clone(); 
	
	/**
	 * This method returns the given object. It adds all properties of this to the given object.
	 * @param clone the clone to which all properties of this shall be copied to
	 * @return the extended given object
	 */
	Object clone(SDocument clone);

} // SDocument
