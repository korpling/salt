/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SSequential DS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData <em>SData</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSStart <em>SStart</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSEnd <em>SEnd</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSequentialDS()
 * @model abstract="true"
 * @generated
 */
public interface SSequentialDS extends SNode {
	/**
	 * Returns the value of the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SData</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SData</em>' attribute.
	 * @see #setSData(Object)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSequentialDS_SData()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Object getSData();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData <em>SData</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SData</em>' attribute.
	 * @see #getSData()
	 * @generated
	 */
	void setSData(Object value);

	/**
	 * Returns the value of the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This value represents the  first position of where the data starts. In general this value is 0. In case of the {@link SSequentialDS} is a {@link STextualDS}, this value determines the position where the text starts. This value is null if the value {@link #SData} is null.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>SStart</em>' attribute.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSequentialDS_SStart()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Integer getSStart();

	/**
	 * Returns the value of the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This value represents the  last position of where the data ends. In case of the {@link SSequentialDS} is a {@link STextualDS}, this value determines the position of the last character of the text. This value is null if the value {@link #SData} is null.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>SEnd</em>' attribute.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSequentialDS_SEnd()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Integer getSEnd();

} // SSequentialDS
