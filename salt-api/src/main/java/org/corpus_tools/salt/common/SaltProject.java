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
package org.corpus_tools.salt.common;

import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * The salt project is a kind of a super container for a Salt model. It contains
 * a set of corpus structures, which could contain a set of document structures
 * each. This makes the {@link SaltProject} object the entry point for a salt
 * model. In case you have more than one salt project, you can name it by
 * {@link #setName(String)}
 * 
 * @author florian
 */
public interface SaltProject {
	/**
	 * Returns all corpus structures contained in this project.
	 * 
	 * @return all contained corpus structures
	 */
	public List<SCorpusGraph> getCorpusGraphs();

	/**
	 * Adds the passed {@link SCorpusGraph} object to the list of corpus graphs.
	 * 
	 * @param corpusGraph
	 *            new corpus graph object
	 */
	public void addCorpusGraph(SCorpusGraph corpusGraph);

	/**
	 * Removes the passed {@link SCorpusGraph} object to the list of corpus
	 * graphs.
	 * 
	 * @param corpusGraph
	 *            new corpus graph object
	 */
	public void removeCorpusGraph(SCorpusGraph corpusGraph);

	/**
	 * Returns the name of this salt project. A name is optional.
	 * 
	 * @return name of the project
	 */
	public String getName();

	/**
	 * Sets the name of this salt project. A name is optional.
	 * 
	 * @param name
	 *            of the project
	 */
	public void setName(String name);

	/**
	 * Persists this {@link SaltProject} object to the location given by the
	 * passed {@link URI} object as SaltXML.
	 * 
	 * @param saltProjectURI
	 *            the {@link URI} to the location to persist the project
	 */
	void saveSaltProject(URI saltProjectURI);

	/**
	 * Loads data from URI into this SaltProject object. Data in location
	 * saltProjectURI must be conform to SaltXML format.
	 * <p>
	 * This will load all document graphs into memory as well. If you only
	 * intend to load the corpus structure call {@link #loadCorpusStructure(org.eclipse.emf.common.util.URI) }
	 * instead. Then you can load the single document graphs you are interested in
	 * with {@link SDocument#loadDocumentGraph() }.
	 * </p>
	 * @param saltProjectURI
	 *            the {@link URI} to the location to load the project
	 */
	public void loadSaltProject(URI saltProjectURI);

	// /**
	// * Computes differences between this object and the given one and returns
	// * all differences in a list as textual descriptions. This method uses the
	// * equals method, to check for differences and can be seen as an inverse
	// * function to equals().
	// *
	// * @return a list of differences between this object and the given one, if
	// * exist, null otherise
	// * @model
	// * @generated
	// */
	// EList<String> differences(Object obj);

	// /**
	// * <!-- begin-user-doc --> <!-- end-user-doc -->
	// *
	// * @model
	// *
	// uriDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	// * @generated
	// */
	// void saveSCorpusGraph_DOT(URI uri, SElementId sElementID);
	//
	// /**
	// * <!-- begin-user-doc --> <!-- end-user-doc -->
	// *
	// * @model
	// *
	// uriDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	// * @generated
	// */
	// void saveSaltProject_DOT(URI uri);
	//
	// /**
	// * <!-- begin-user-doc --> <!-- end-user-doc -->
	// *
	// * @model
	// *
	// uriDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	// * @generated
	// */
	// void saveSDocumentGraph_DOT(URI uri, SElementId sElementID);

	/**
	 * Reads a saltProject.salt file and imports the contained corpus structure,
	 * without importing the document structure corresponding to the imported
	 * {@link SDocument} nodes.
	 * 
	 * @param saltProjectURI
	 *            the uri to the location of the folder containing the
	 *            saltProject.salt file.
	 */
	public void loadCorpusStructure(URI saltProjectURI);

	/**
	 * Creates a new corpus graph and adds it to the Salt project.
	 * @return the new created Salt project
	 */
	public SCorpusGraph createCorpusGraph();

} // SaltProject
