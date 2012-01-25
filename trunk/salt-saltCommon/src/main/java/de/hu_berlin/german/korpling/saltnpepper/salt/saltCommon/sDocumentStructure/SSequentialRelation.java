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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SSequential Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart <em>SStart</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd <em>SEnd</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSequentialRelation()
 * @model abstract="true"
 * @generated
 */
public interface SSequentialRelation extends SRelation {
	/**
	 * Returns the value of the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStart</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStart</em>' attribute.
	 * @see #setSStart(Integer)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSequentialRelation_SStart()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Integer getSStart();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart <em>SStart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SStart</em>' attribute.
	 * @see #getSStart()
	 * @generated
	 */
	void setSStart(Integer value);

	/**
	 * Returns the value of the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SEnd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SEnd</em>' attribute.
	 * @see #setSEnd(Integer)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSequentialRelation_SEnd()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Integer getSEnd();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd <em>SEnd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SEnd</em>' attribute.
	 * @see #getSEnd()
	 * @generated
	 */
	void setSEnd(Integer value);

} // SSequentialRelation
