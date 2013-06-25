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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getIdentifiableElement <em>Identifiable Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getIdentifier()
 * @model
 * @generated
 */
public interface Identifier extends Label 
{
	/**
	 * default name for of derived namespace-attribute
	 */
	public static final String NAMESPACE_DEFAULT=GraphPackage.eNAME;
	
	/**
	 * default name for of derived name-attribute
	 */
	public static final String NAME_DEFAULT="id";
	/**
         * Returns the value of the '<em><b>Id</b></em>' attribute.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Id</em>' attribute.
         * @see #setId(String)
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getIdentifier_Id()
         * @model transient="true" volatile="true" derived="true"
         * @generated
         */
	String getId();

	/**
         * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getId <em>Id</em>}' attribute.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Id</em>' attribute.
         * @see #getId()
         * @generated
         */
	void setId(String value);

	/**
         * Returns the value of the '<em><b>Identifiable Element</b></em>' reference.
         * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getIdentifier <em>Identifier</em>}'.
         * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifiable Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
         * @return the value of the '<em>Identifiable Element</em>' reference.
         * @see #setIdentifiableElement(IdentifiableElement)
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getIdentifier_IdentifiableElement()
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getIdentifier
         * @model opposite="identifier" transient="true" volatile="true"
         * @generated
         */
	IdentifiableElement getIdentifiableElement();

	/**
         * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getIdentifiableElement <em>Identifiable Element</em>}' reference.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param value the new value of the '<em>Identifiable Element</em>' reference.
         * @see #getIdentifiableElement()
         * @generated
         */
	void setIdentifiableElement(IdentifiableElement value);

} // Identifier
