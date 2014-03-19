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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphIndexException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SimpleIndexImpl#getNumOfElements <em>Num Of Elements</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SimpleIndexImpl#getNumOfElementIds <em>Num Of Element Ids</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SimpleIndexImpl#getIndexMap <em>Index Map</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SimpleIndexImpl#getEstimatedCapacity <em>Estimated Capacity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleIndexImpl<K, V> extends IdentifiableElementImpl implements SimpleIndex<K, V> 
{	
	/**
	 * The default value of the '{@link #getNumOfElements() <em>Num Of Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfElements()
	 * @generated
	 * @ordered
	 */
	protected static final Long NUM_OF_ELEMENTS_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getNumOfElementIds() <em>Num Of Element Ids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfElementIds()
	 * @generated
	 * @ordered
	 */
	protected static final Long NUM_OF_ELEMENT_IDS_EDEFAULT = null;
	
	/**
	 * The default value of the '{@link #getEstimatedCapacity() <em>Estimated Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimatedCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final Integer ESTIMATED_CAPACITY_EDEFAULT = new Integer(10000);

	/**
	 * The cached value of the '{@link #getEstimatedCapacity() <em>Estimated Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimatedCapacity()
	 * @generated
	 * @ordered
	 */
	protected Integer estimatedCapacity = ESTIMATED_CAPACITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SimpleIndexImpl() {
		super();
		this.init();
	}

	private void init()
	{
		this.setIndexMap(new HashMap<K, V>(this.getEstimatedCapacity()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IndexPackage.Literals.SIMPLE_INDEX;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Long getNumOfElements() 
	{
		return(new Long(this.getIndexMap().size()));
	}

	/**
	 * {@inheritDoc Index#getNumOfElementIds()}
	 */
	@Override
	public Long getNumOfElementIds() {
		return(Long.valueOf(this.getIndexMap().size()));
	}

	/**
	 * Map to store the index, this object is the core of tis class.
	 */
	protected Map<K, V> indexMap=null;
	
	/**
	 *{@inheritDoc Index#getIndexMap()}
	 */
	@Override
	public Map<K, V> getIndexMap() {
		return(this.indexMap);
	}

	/**
	 * {@inheritDoc Index#setIndexMap(Map)}
	 */
	public void setIndexMap(Map<K, V> newIndexMap) {
		this.indexMap= newIndexMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getEstimatedCapacity() {
		return estimatedCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstimatedCapacity(Integer newEstimatedCapacity) {
		Integer oldEstimatedCapacity = estimatedCapacity;
		estimatedCapacity = newEstimatedCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IndexPackage.SIMPLE_INDEX__ESTIMATED_CAPACITY, oldEstimatedCapacity, estimatedCapacity));
	}

	/**
	 * {@inheritDoc SimpleIndex#getElement(Object)}
	 */
	@Override
	public V getElement(K elementId) {
		if (elementId== null)
			throw new GraphIndexException("Cannot search for elementId in index, because it is null.");
		return(this.getIndexMap().get(elementId));
	}

	/**
	 *{@inheritDoc SimpleIndex#removeElementById(Object)}
	 */
	@Override
	public Boolean removeElementById(K elementId) {
		Boolean retVal= false;
		int oldLength= this.getIndexMap().size();
		this.getIndexMap().remove(elementId);
		retVal= !(oldLength== this.getIndexMap().size());
		return(retVal);
	}

	/**
	 * {@inheritDoc Index#addElement(Object, Object)}
	 */
	@Override
	public void addElement(K elementId, V element) {
		this.getIndexMap().put(elementId, element);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Boolean hasKey(K elementId) {
		if (elementId== null)
			throw new GraphIndexException("Cannot search for an empty element.");
		return this.getIndexMap().containsKey(elementId);
	}

	/**
	 * {@inheritDoc Index#removeElement(Object)}
	 */
	@Override
	public Boolean removeElement(V element) {
		if (element== null)
			throw new GraphIndexException("Cannot remove element from index '"+this.getId()+"', because element is null.");
		boolean retVal= false;
		long numOfElem= this.getNumOfElements();
		//searching for element to remove
		Set<K> keys= this.getIndexMap().keySet();
		Object foundKey= null;
		for (Object key: keys)
		{
			if (this.getIndexMap().get(key).equals(element))
			{	
				foundKey= key;
				break;
			}
		}
		if (foundKey!= null)
			this.getIndexMap().remove(foundKey);
		
		if (this.getNumOfElements()== numOfElem -1)
			retVal= true;
		else retVal= false;
		return(retVal);
	}

	/**
	 * {@inheritDoc Index#removeAll()}
	 */
	@Override
	public Boolean removeAll() 
	{
		this.init();
		return(this.getIndexMap().size()== 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IndexPackage.SIMPLE_INDEX__NUM_OF_ELEMENTS:
				return getNumOfElements();
			case IndexPackage.SIMPLE_INDEX__NUM_OF_ELEMENT_IDS:
				return getNumOfElementIds();
			case IndexPackage.SIMPLE_INDEX__INDEX_MAP:
				return getIndexMap();
			case IndexPackage.SIMPLE_INDEX__ESTIMATED_CAPACITY:
				return getEstimatedCapacity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IndexPackage.SIMPLE_INDEX__INDEX_MAP:
				setIndexMap((Map<K, V>)newValue);
				return;
			case IndexPackage.SIMPLE_INDEX__ESTIMATED_CAPACITY:
				setEstimatedCapacity((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IndexPackage.SIMPLE_INDEX__INDEX_MAP:
				setIndexMap((Map<K, V>)null);
				return;
			case IndexPackage.SIMPLE_INDEX__ESTIMATED_CAPACITY:
				setEstimatedCapacity(ESTIMATED_CAPACITY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IndexPackage.SIMPLE_INDEX__NUM_OF_ELEMENTS:
				return NUM_OF_ELEMENTS_EDEFAULT == null ? getNumOfElements() != null : !NUM_OF_ELEMENTS_EDEFAULT.equals(getNumOfElements());
			case IndexPackage.SIMPLE_INDEX__NUM_OF_ELEMENT_IDS:
				return NUM_OF_ELEMENT_IDS_EDEFAULT == null ? getNumOfElementIds() != null : !NUM_OF_ELEMENT_IDS_EDEFAULT.equals(getNumOfElementIds());
			case IndexPackage.SIMPLE_INDEX__INDEX_MAP:
				return getIndexMap() != null;
			case IndexPackage.SIMPLE_INDEX__ESTIMATED_CAPACITY:
				return ESTIMATED_CAPACITY_EDEFAULT == null ? estimatedCapacity != null : !ESTIMATED_CAPACITY_EDEFAULT.equals(estimatedCapacity);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (estimatedCapacity: ");
		result.append(estimatedCapacity);
		result.append(')');
		return result.toString();
	}

} //SimpleIndexImpl
