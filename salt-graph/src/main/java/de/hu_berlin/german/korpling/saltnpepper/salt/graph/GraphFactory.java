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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage
 * @generated
 */
public interface GraphFactory extends EFactory {
	/**
         * The singleton instance of the factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	GraphFactory eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphFactoryImpl.init();

	/**
         * Returns a new object of class '<em>Node</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Node</em>'.
         * @generated
         */
	Node createNode();

	/**
         * Returns a new object of class '<em>Labelable Element</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Labelable Element</em>'.
         * @generated
         */
	LabelableElement createLabelableElement();

	/**
         * Returns a new object of class '<em>Edge</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Edge</em>'.
         * @generated
         */
	Edge createEdge();

	/**
         * Returns a new object of class '<em>Identifiable Element</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Identifiable Element</em>'.
         * @generated
         */
	IdentifiableElement createIdentifiableElement();

	/**
         * Returns a new object of class '<em>Label</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Label</em>'.
         * @generated
         */
	Label createLabel();

	/**
         * Returns a new object of class '<em>Graph</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Graph</em>'.
         * @generated
         */
	Graph createGraph();

	/**
         * Returns a new object of class '<em>Identifier</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Identifier</em>'.
         * @generated
         */
	Identifier createIdentifier();

	/**
         * Returns a new object of class '<em>Layer</em>'.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return a new object of class '<em>Layer</em>'.
         * @generated
         */
	Layer createLayer();

	/**
         * Returns the package supported by this factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return the package supported by this factory.
         * @generated
         */
	GraphPackage getGraphPackage();

} //GraphFactory
