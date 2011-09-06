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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;

import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SIdentifiable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementId <em>SElement Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSId <em>SId</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementPath <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSIdentifiableElement()
 * @model
 * @generated
 */
public interface SIdentifiableElement extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>SElement Id</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SElement Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SElement Id</em>' reference.
	 * @see #setSElementId(SElementId)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSIdentifiableElement_SElementId()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSIdentifiableElement
	 * @model opposite="sIdentifiableElement" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SElementId getSElementId();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementId <em>SElement Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SElement Id</em>' reference.
	 * @see #getSElementId()
	 * @generated
	 */
	void setSElementId(SElementId value);

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
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSIdentifiableElement_SId()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getSId();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSId <em>SId</em>}' attribute.
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
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSIdentifiableElement_SElementPath()
	 * @model dataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	URI getSElementPath();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementPath <em>SElement Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SElement Path</em>' attribute.
	 * @see #getSElementPath()
	 * @generated
	 */
	void setSElementPath(URI value);

} // SIdentifiableElement
