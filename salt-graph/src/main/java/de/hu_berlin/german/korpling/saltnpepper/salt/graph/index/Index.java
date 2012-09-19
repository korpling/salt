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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A class implementing this interface provides an index for a faster access on indexed objects. An {@link Index} object indexes a single object (so called value or element) or a set of objects (so called values or elements) by using a unique key (also called elementId) for indexing them. In case of the {@link Index} object is of type  {@link SimpleIndex}, each key has exactly one value in case of the {@link Index} object is of type {@link ComplexIndex}, each key has a list of values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getNumOfElements <em>Num Of Elements</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getNumOfElementIds <em>Num Of Element Ids</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getIndexMap <em>Index Map</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getEstimatedCapacity <em>Estimated Capacity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getIndex()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Index<K, V> extends IdentifiableElement {

	/**
	 * Returns the value of the '<em><b>Num Of Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Of Elements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Elements</em>' attribute.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getIndex_NumOfElements()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getNumOfElements();

	/**
	 * Returns the value of the '<em><b>Num Of Element Ids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Of Element Ids</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Element Ids</em>' attribute.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getIndex_NumOfElementIds()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Long getNumOfElementIds();

	/**
	 * Returns the value of the '<em><b>Index Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Map</em>' attribute.
	 * @see #setIndexMap(Map)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getIndex_IndexMap()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	Map<K, V> getIndexMap();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getIndexMap <em>Index Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Map</em>' attribute.
	 * @see #getIndexMap()
	 * @generated
	 */
	void setIndexMap(Map<K, V> value);

	/**
	 * Returns the value of the '<em><b>Estimated Capacity</b></em>' attribute.
	 * The default value is <code>"10000"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines the estimated size of this index. For instance this value can be used by implemnting calsses as inital cpacity for e.g. {@link HashMap} objects etc.. The default value is set to {@value #ESTIMATED_CAPACITY_EDEFAULT}. A reset currently is ineffective.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Estimated Capacity</em>' attribute.
	 * @see #setEstimatedCapacity(Integer)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#getIndex_EstimatedCapacity()
	 * @model default="10000"
	 * @generated
	 */
	Integer getEstimatedCapacity();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getEstimatedCapacity <em>Estimated Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimated Capacity</em>' attribute.
	 * @see #getEstimatedCapacity()
	 * @generated
	 */
	void setEstimatedCapacity(Integer value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method adds an element to slot with given id. If no slot exists it will be created. No element will ever be inserted into the same slot more than once.
	 * @param id Object - identifier for slot
	 * @param element Object - adding element  
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void addElement(K elementId, V element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean hasElement(K elementId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Removes the given element from this index.
	 * @param element - the element which shall be removed
	 * @return true, if removing was successful 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeElement(V element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean removeAll();
} // Index
