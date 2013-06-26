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
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node#getGraph <em>Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node#getLayers <em>Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends IdentifiableElement {

	/**
         * Returns the value of the '<em><b>Graph</b></em>' container reference.
         * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNodes <em>Nodes</em>}'.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Graph</em>' container reference.
         * @see #setGraph(Graph)
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getNode_Graph()
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNodes
         * @model opposite="nodes" unsettable="true" transient="false"
         * @generated
         */
	Graph getGraph();

	/**
         * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node#getGraph <em>Graph</em>}' container reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Graph</em>' container reference.
         * @see #getGraph()
         * @generated
         */
	void setGraph(Graph value);

	/**
         * Returns the value of the '<em><b>Layers</b></em>' reference list.
         * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer}.
         * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getNodes <em>Nodes</em>}'.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Layers</em>' reference list.
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getNode_Layers()
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getNodes
         * @model opposite="nodes"
         * @generated
         */
	EList<Layer> getLayers();

	/**
	 * Returns a new object of type {@link SNode}, which has the same properties like this. That means, all labels will also be cloned and
	 * the clones will be added to the new object, except an identifier.
	 * @generated
	 */
	Object clone();
} // Node
