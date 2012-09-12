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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index;

import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#getNumOfSlots <em>Num Of Slots</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#getIdxTable <em>Idx Table</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getComplexIndex()
 * @model
 */
public interface ComplexIndex extends Index {
	/**
	 * Returns the value of the '<em><b>Num Of Slots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Of Slots</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Slots</em>' attribute.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getComplexIndex_NumOfSlots()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getNumOfSlots();

	/**
	 * Returns the value of the '<em><b>Idx Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Idx Table</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Idx Table</em>' attribute.
	 * @see #setIdxTable(Map)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getComplexIndex_IdxTable()
	 * @model transient="true" volatile="true"
	 */
	Map getIdxTable();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#getIdxTable <em>Idx Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Idx Table</em>' attribute.
	 * @see #getIdxTable()
	 */
	void setIdxTable(Map<Object, EList<Object>> value);

	/**
	 * Returns the value of the '<em><b>Sortable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sortable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Sortable</em>' attribute.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getComplexIndex_Sortable()
	 * @model default="false" changeable="false"
	 * @generated
	 */
    boolean isSortable();

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean hasSlot(Object elementId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Object> getSlot(Object elementId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Object> getSlotIds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeSlot(Object elementId);

} // ComplexIndex
