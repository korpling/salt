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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SElement Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSIdentifiableElement <em>SIdentifiable Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSId <em>SId</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSElementPath <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSElementId()
 * @model
 * @generated
 */
public interface SElementId extends Identifier {
	/**
	 * Returns the value of the '<em><b>SIdentifiable Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementId <em>SElement Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SIdentifiable Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SIdentifiable Element</em>' reference.
	 * @see #setSIdentifiableElement(SIdentifiableElement)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSElementId_SIdentifiableElement()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementId
	 * @model opposite="sElementId" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SIdentifiableElement getSIdentifiableElement();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSIdentifiableElement <em>SIdentifiable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SIdentifiable Element</em>' reference.
	 * @see #getSIdentifiableElement()
	 * @generated
	 */
	void setSIdentifiableElement(SIdentifiableElement value);

	/**
	 * Returns the value of the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SId</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SId</em>' attribute.
	 * @see #setSId(String)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSElementId_SId()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getSId();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSId <em>SId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SId</em>' attribute.
	 * @see #getSId()
	 * @generated
	 */
	void setSId(String value);

	/**
	 * Returns the value of the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SElement Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SElement Path</em>' attribute.
	 * @see #setSElementPath(URI)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSElementId_SElementPath()
	 * @model dataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	URI getSElementPath();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSElementPath <em>SElement Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SElement Path</em>' attribute.
	 * @see #getSElementPath()
	 * @generated
	 */
	void setSElementPath(URI value);

} // SElementId
