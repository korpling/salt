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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource.GRAF_MAPPING_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;

import java.util.Map;
import java.util.Properties;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Salt Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSCorpusGraphs <em>SCorpus Graphs</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSName <em>SName</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage#getSaltProject()
 * @model
 * @generated
 */
public interface SaltProject extends EObject {
	/**
	 * Returns the value of the '<em><b>SCorpus Graphs</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject <em>Salt Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Graphs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Graphs</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage#getSaltProject_SCorpusGraphs()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject
	 * @model opposite="saltProject" containment="true"
	 * @generated
	 */
	EList<SCorpusGraph> getSCorpusGraphs();

	/**
	 * Returns the value of the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SName</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SName</em>' attribute.
	 * @see #setSName(String)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage#getSaltProject_SName()
	 * @model
	 * @generated
	 */
	String getSName();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSName <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SName</em>' attribute.
	 * @see #getSName()
	 * @generated
	 */
	void setSName(String value);

	/**
	 * Persists this {@link SaltProject} object to the location given by the passed {@link URI} object as SaltXML. 
	 * @model saltProjectURIDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void saveSaltProject(URI saltProjectURI);

	/**
	 * Loads data from URI into this SaltProject object. Data in location saltProjectURI must be conform to saltXML format. 
	 * @model saltProjectURIDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void loadSaltProject(URI saltProjectURI);

	/**
	 * Loads a corpus structure from a given uri, using the GrAF format. 
	 * Possible values for properties:
	 * <ul>
	 * 	<li>{@link GrAFResource#PROP_GRAF_HEADER_FILE_ENDING} the file ending of the GrAF header file</li>
	 * <li>{@link GrAFResource#PROP_GRAF_LAYER_TO_TYPE}.type A description, how the data concerning to the layer type shall be matched, possible values are: {@link GRAF_MAPPING_TYPE}</li>
	 * </ul>
	 * @param saltProjectUri the uri of the root folder which contains the GrAF corpus. 
	 * @param properties a {@link Properties}} object which contains a utilization for the load process 
	 * @model saltProjectUriDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI" propertiesDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.Properties"
	 * @generated
	 */
	void loadSaltProject_GrAF(URI saltProjectUri, Properties properties);

	/**
	 * Computes differences between this object and the given one and returns all differences in a list as textual descriptions. This
	 * method uses the equals method, to check for differences and can be seen as an inverse function to equals().
	 * 
	 * @return a list of differences between this object and the given one, if exist, null otherise
	 * @model
	 * @generated
	 */
	EList<String> differences(Object obj);

	/**
	 * Loads an object of type {@link SCorpusGraph} from given URI in GrAF format into this object. The {@link SDocumentGraph} objects
	 * will not be loaded, but a map containing created {@link SDocument} objects and corresponding files will be returned.
	 * Possible values for properties:
	 * <ul>
	 * 	<li>{@link GrAFResource#PROP_GRAF_HEADER_FILE_ENDING} the file ending of the GrAF header file</li>
	 * <li>{@link GrAFResource#PROP_GRAF_LAYER_TO_TYPE}.type A description, how the data concerning to the layer type shall be matched, possible values are: {@link GRAF_MAPPING_TYPE}</li>
	 * </ul>
	 * @param sCorpusGraphURI the uri where the resource is located
	 * @param properties properties to utilize the loading
	 * @return  map containing created {@link SDocument} objects and corresponding files will be returned.
	 * @model
	 * @generated
	 */
	Map loadSCorpusGraph_GrAF(URI sCorpusGraphURI, Properties properties);

	/**
	 * Loads an {@link SDocumentGraph} object from given uri (in GrAF format) and adds it to the given {@link SDocument} object.
	 * Possible values for properties:
	 * <ul>
	 * 	<li>{@link GrAFResource#PROP_GRAF_HEADER_FILE_ENDING} the file ending of the GrAF header file</li>
	 * <li>{@link GrAFResource#PROP_GRAF_LAYER_TO_TYPE}.type A description, how the data concerning to the layer type shall be matched, possible values are: {@link GRAF_MAPPING_TYPE}</li>
	 * </ul>
	 * @param sDocumentGraphURI the uri where the resource is located
	 * @param sDocument the document to which the graph shall be set 
	 * @param properties properties to utilize the loading
	 * @model
	 * @generated
	 */
	void loadSDocumentGraph_GrAF(URI sDocumentGraphURI, SDocument sDocument, Properties properties);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model uriDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void saveSCorpusGraph_DOT(URI uri, SElementId sElementID);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model uriDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void saveSaltProject_DOT(URI uri);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model uriDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void saveSDocumentGraph_DOT(URI uri, SElementId sElementID);

	/**
	 * Reads a saltProject.salt file and imports the contained corpus structure, without importing the document-structure
	 * corresponding to the imported {@link SDocument} nodes.
	 * @param saltProjectURI the uri to the location of the folder containing the saltProject.salt file.
	 * @model saltProjectURIDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void loadSCorpusStructure(URI saltProjectURI);

	/**
	 * This method extracts the location of all {@link SDocumentGraph} objects, which are persist in a file
	 * and are currently not loaded as model into main memory. The returned value is a map, containing the
	 * {@link SElementId} as an identifier and the location of the {@link SDocumentGraph} object as an {@link URI}.
	 * To extract the locations, the method runs through all {@link SDocument} objects (being contained in the 
	 * current {@link SaltProject}) containing the {@link SDocumentGraph} objects and checks if the {@link SDocumentGraph} 
	 * object is loaded or peristed.
	 * @return a map of {@link SElementId} of {@link SDocument} objects and the corresponding location as {@link URI}, an empty {@link Map}, if no {@link SDocumentGraph} object is persisted
	 * @model kind="operation"
	 */
	Map<SElementId, URI> getSDocumentGraphLocations();

} // SaltProject
