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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Labelable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabels <em>Labels</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getLabelableElement()
 * @model
 * @generated
 */
public interface LabelableElement extends EObject 
{
	/**
     * Returns the value of the '<em><b>Labels</b></em>' containment reference list.
     * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label}.
     * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getLabelableElement <em>Labelable Element</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Labels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Labels</em>' containment reference list.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getLabelableElement_Labels()
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getLabelableElement
     * @model opposite="labelableElement" containment="true"
     * @generated
     */
	EList<Label> getLabels();

	/**
	 * Finds all differences between this and the given object.
	 * Note that this method is not part of the EMF specification, please use instead either {@link LabelableElement#differences(Object)}} to compute differences or
	 * {@link LabelableElement#equals(Object)}} to check equality.  
	 * @param differences if given parameter is not null all differences will be written in that list
	 * @param obj the object to compare
	 * @return true, if objects are equal, false otherwise
	 */
	public boolean equals(EList<String> differences, Object obj);
	
	/**
	 * Adds the given Label object to the list of labels.
	 * @param label the Label object to be added 
	 * @model
	 * @generated
	 */
	void addLabel(Label label);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model
     * @generated
     */
	Label getLabel(String ns, String name);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model
     * @generated
     */
	Label getLabel(String fullName);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model
     * @generated
     */
	Boolean removeLabel(String fullName);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
	int getNumOfLabels();

	/**
	 * Removes all Label objects.
	 * @return true, if removing was successfull
	 * @model
	 * @generated
	 */
	Boolean removeAll();

	/**
	 * Returns a list containing all Label objects having the given namespace.
	 * @param ns the namespace of Label objects to be looked for.
	 * @return a list of Label objects if this object conatins Label objects having the given namespace, null otherwise.
	 * @model
	 * @generated
	 */
	EList<Label> getLabelsByNamespace(String ns);

	/**
	 * Checks if this object has a Label object in its list having the given fullname.
	 * @param fullName the full qualified name of the label to be looked for
	 * @return true, if this object contains such a Label object, false otherwise 
	 * @model
	 * @generated
	 */
	boolean hasLabel(String fullName);

	/**
	 * Removes a Label object from the list of labels of this object. The Label object to be removed is identified by given namespace and name.
	 * @param namespace the namespace of the object to be removed
	 * @param name the name of the object to be removed
	 * @return true, if Label object was removed successfull
	 * @model
	 * @generated
	 */
	Boolean removeLabel(String namespace, String name);
	
	/**
	 * Returns all the differences between this object and the given one as a list of strings. This method uses the same
	 * comparisons as the equals method. 
	 * @param obj object to compare with
	 * @return a list of differences, null if both objects are equal
	 * @model
	 * @generated
	 */
	EList<String> differences(Object obj);
	
} // LabelableElement
