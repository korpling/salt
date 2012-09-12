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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mgr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getNumOfIndexes <em>Num Of Indexes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getGraph <em>Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getIndexMgr()
 * @model
 * @generated
 */
public interface IndexMgr extends EObject {
	/**
	 * Returns the value of the '<em><b>Indexes</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexes</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getIndexMgr_Indexes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Index> getIndexes();

	/**
	 * Returns the value of the '<em><b>Num Of Indexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Of Indexes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Indexes</em>' attribute.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getIndexMgr_NumOfIndexes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getNumOfIndexes();

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getIndexMgr <em>Index Mgr</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' reference.
	 * @see #setGraph(Graph)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getIndexMgr_Graph()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getIndexMgr
	 * @model opposite="indexMgr" transient="true" volatile="true"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getGraph <em>Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addIndex(Index index);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean hasIndex(Object indexId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Index getIndex(Object indexId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeIndex(Object indexId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeAll();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeElement(Object elementId);

} // IndexMgr
