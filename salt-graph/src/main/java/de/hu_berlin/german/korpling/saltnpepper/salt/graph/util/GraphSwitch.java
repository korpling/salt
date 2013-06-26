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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.util;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage
 * @generated
 */
public class GraphSwitch<T> extends Switch<T> {
	/**
         * The cached model package
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected static GraphPackage modelPackage;

	/**
         * Creates an instance of the switch.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public GraphSwitch() {
                if (modelPackage == null) {
                        modelPackage = GraphPackage.eINSTANCE;
                }
        }

	/**
         * Checks whether this is a switch for the given package.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @parameter ePackage the package in question.
         * @return whether this is a switch for the given package.
         * @generated
         */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
                return ePackage == modelPackage;
        }

	/**
         * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return the first non-null result returned by a <code>caseXXX</code> call.
         * @generated
         */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
                switch (classifierID) {
                        case GraphPackage.NODE: {
                                Node node = (Node)theEObject;
                                T result = caseNode(node);
                                if (result == null) result = caseIdentifiableElement(node);
                                if (result == null) result = caseLabelableElement(node);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case GraphPackage.LABELABLE_ELEMENT: {
                                LabelableElement labelableElement = (LabelableElement)theEObject;
                                T result = caseLabelableElement(labelableElement);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case GraphPackage.EDGE: {
                                Edge edge = (Edge)theEObject;
                                T result = caseEdge(edge);
                                if (result == null) result = caseIdentifiableElement(edge);
                                if (result == null) result = caseLabelableElement(edge);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case GraphPackage.IDENTIFIABLE_ELEMENT: {
                                IdentifiableElement identifiableElement = (IdentifiableElement)theEObject;
                                T result = caseIdentifiableElement(identifiableElement);
                                if (result == null) result = caseLabelableElement(identifiableElement);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case GraphPackage.LABEL: {
                                Label label = (Label)theEObject;
                                T result = caseLabel(label);
                                if (result == null) result = caseLabelableElement(label);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case GraphPackage.GRAPH: {
                                Graph graph = (Graph)theEObject;
                                T result = caseGraph(graph);
                                if (result == null) result = caseIdentifiableElement(graph);
                                if (result == null) result = caseLabelableElement(graph);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case GraphPackage.IDENTIFIER: {
                                Identifier identifier = (Identifier)theEObject;
                                T result = caseIdentifier(identifier);
                                if (result == null) result = caseLabel(identifier);
                                if (result == null) result = caseLabelableElement(identifier);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        case GraphPackage.LAYER: {
                                Layer layer = (Layer)theEObject;
                                T result = caseLayer(layer);
                                if (result == null) result = caseIdentifiableElement(layer);
                                if (result == null) result = caseLabelableElement(layer);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        default: return defaultCase(theEObject);
                }
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Node</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseNode(Node object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Labelable Element</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Labelable Element</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseLabelableElement(LabelableElement object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseEdge(Edge object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Identifiable Element</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Identifiable Element</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseIdentifiableElement(IdentifiableElement object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Label</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseLabel(Label object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Graph</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Graph</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseGraph(Graph object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseIdentifier(Identifier object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Layer</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Layer</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseLayer(Layer object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject)
         * @generated
         */
	@Override
	public T defaultCase(EObject object) {
                return null;
        }

} //GraphSwitch
