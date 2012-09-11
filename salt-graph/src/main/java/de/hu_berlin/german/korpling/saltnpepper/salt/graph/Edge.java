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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getGraph <em>Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getTarget <em>Target</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getLayers <em>Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends IdentifiableElement {

	/**
     * Returns the value of the '<em><b>Graph</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdges <em>Edges</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Graph</em>' container reference.
     * @see #setGraph(Graph)
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getEdge_Graph()
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdges
     * @model opposite="edges" transient="false"
     * @generated
     */
	Graph getGraph();

	/**
     * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getGraph <em>Graph</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Graph</em>' container reference.
     * @see #getGraph()
     * @generated
     */
	void setGraph(Graph value);

	/**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(Node)
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getEdge_Source()
     * @model
     * @generated
     */
	Node getSource();

	/**
     * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
	void setSource(Node value);

	/**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(Node)
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getEdge_Target()
     * @model
     * @generated
     */
	Node getTarget();

	/**
     * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
	void setTarget(Node value);

	/**
     * Returns the value of the '<em><b>Layers</b></em>' reference list.
     * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer}.
     * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getEdges <em>Edges</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Layers</em>' reference list.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getEdge_Layers()
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getEdges
     * @model opposite="edges"
     * @generated
     */
	EList<Layer> getLayers();
} // Edge
