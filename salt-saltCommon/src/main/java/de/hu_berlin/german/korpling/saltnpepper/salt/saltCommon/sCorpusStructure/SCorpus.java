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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import org.eclipse.emf.common.util.URI;

/**
 * In Salt a corpus is represented by this class. An object of this class can be a super corpus, a sun corpus or none of them as well. 
 * The class {@link SCorpus} is a derivation of of class {@link SNode} and can be added to an object of type {@link SCorpusGraph}. To
 * know how to create a hierarchical relation between several {@link SCorpus} objects please read the documentation in {@link SCorpusGraph}}.
 * 
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpus()
 * @model
 * @generated
 */
public interface SCorpus extends SNode {
	/**
	 * Returns the value of the '<em><b>SCorpus Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora <em>SCorpora</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Graph</em>' container reference.
	 * @see #setSCorpusGraph(SCorpusGraph)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpus_SCorpusGraph()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora
	 * @model opposite="sCorpora" volatile="true" derived="true"
	 * @generated
	 */
	SCorpusGraph getSCorpusGraph();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph <em>SCorpus Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SCorpus Graph</em>' container reference.
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	void setSCorpusGraph(SCorpusGraph value);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generates an XML File that contains information about the given SCorpus and all its contents.
	 * The output will contain the count of all SNode and SRelation objects as well as their SAnnotation objects. 
	 * There will be additional counts for every SLayer. 
	 * 
	 * The XML file's schema can be found under https://korpling.german.hu-berlin.de/saltnpepper/salt/info/info-10/sCorpusInfo.xsd
	 * 
	 * Temporary XML files for every SDocument will be created in a tempFolder. This tempFolder will be created in the same place as the XML output file. 
	 * <!-- end-model-doc -->
	 * @model outputResourceDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void printInfo(URI outputResource);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generates an XML File that contains information about the given SCorpus and all its contents.
	 * The output will contain the count of all SNode and SRelation objects as well as their SAnnotation objects. 
	 * There will be additional counts for every SLayer. 
	 * 
	 * The XML file's schema can be found under https://korpling.german.hu-berlin.de/saltnpepper/salt/info/info-10/sCorpusInfo.xsd
	 * 
	 * Temporary XML files for every SDocument will be created in the tempFolder.
	 * <!-- end-model-doc -->
	 * @model outputResourceDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI" tempFolderDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 * @generated
	 */
	void printInfo(URI outputResource, URI tempFolder);

	/**
	 * Returns a {@link SCorpus} object having the same properties like this. This means, all labels (annotations, meta-annotations and so on)
	 * will also be cloned. These clones will be set to the cloned {@link SCorpus} object.   
	 * @return {@link SCorpus} object as copy of this 
	 */
	Object clone(); 
	
	/**
	 * This method returns the given object. It adds all properties of this to the given object.
	 * @param clone the clone to which all properties of this shall be copied to
	 * @return the extended given object
	 */
	Object clone(SCorpus clone);

} // SCorpus
