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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphIndexException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SlimComplexIndex;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SlimComplexIndexImpl#getNumOfElements <em>Num Of Elements</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SlimComplexIndexImpl#getNumOfElementIds <em>Num Of Element Ids</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SlimComplexIndexImpl#getIndexMap <em>Index Map</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SlimComplexIndexImpl#getEstimatedCapacity <em>Estimated Capacity</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SlimComplexIndexImpl#isSortable <em>Sortable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlimComplexIndexImpl<K, V> extends IdentifiableElementImpl implements SlimComplexIndex<K, V> {

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
	 * The default value of the '{@link #isSortable() <em>Sortable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSortable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SORTABLE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isSortable() <em>Sortable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSortable()
	 * @generated
	 * @ordered
	 */
	protected boolean sortable = SORTABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IndexPackage.Literals.SLIM_COMPLEX_INDEX;
	}
	
	protected SlimComplexIndexImpl() {
		super();
		this.init();
	}
	
	private void init()
	{
		this.setIndexMap(new HashMap<K, V>(this.getEstimatedCapacity()));
		this.setNumOfElements(new Long(0));
	}
	
	//----------------------------------------------------------------------
	protected Long numOfElements = null;
	
	protected void setNumOfElements(Long numOfElements) {
		this.numOfElements = numOfElements;
	}

	public Long getNumOfElements() {
		return numOfElements;
	}
	
	/**
	 * returns the real index map, without casting stuff.
	 */	
	public Map<K, LinkedHashSet<V>> getIndexMap_SlimComplex() {
		return(idxTable);
	}
	
	/**
	 * {@inheritDoc ComplexIndex#getNumOfElementIds()}
	 */
	@Override
	public Long getNumOfElementIds() {
		return(Long.valueOf(this.getIndexMap_SlimComplex().size()));
	}

	//----------------------------------------------------------------------
	/**
	 * Real index storing ids and the corresponding set of values.
	 */
	protected Map<K, LinkedHashSet<V>> idxTable;	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<K, V> getIndexMap() {
		return((Map<K, V>)idxTable);
	}
	
	/**
	 * {@inheritDoc ComplexIndex#setIndexMap(Map)}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setIndexMap(Map<K, V> newIndexMap) {
		this.idxTable= (Map<K, LinkedHashSet<V>>)newIndexMap;
		Long elementCount= 0l;
		for (K id : newIndexMap.keySet())
		{
			elementCount += ((LinkedHashSet<V>)newIndexMap.get(id)).size();
		}
		this.setNumOfElements(elementCount);
		
//		//check duplicates in slots
//		
//		
//		//the addElement method must not be called from this method!
//		this.idxTable = new HashMap<K, LinkedHashSet<V>>();
//		long elementCount= 0;
//		for (K id : newIndexMap.keySet())
//		{
//			LinkedHashSet<V> slot = new LinkedHashSet<V>((LinkedHashSet<V>)newIndexMap.get(id));  
//			
//			HashSet<Object> elementSet = new HashSet<Object>();
//			for (V element : (LinkedHashSet<V>)newIndexMap.get(id))
//			{
//				if (elementSet.contains(element))
//					throw new GraphIndexException("Index table illegaly contains duplicate element");
//			}
//			
//			idxTable.put(id, slot);
//			elementCount += slot.size();
//		}
//		this.setNumOfElements(elementCount);
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
			eNotify(new ENotificationImpl(this, Notification.SET, IndexPackage.SLIM_COMPLEX_INDEX__ESTIMATED_CAPACITY, oldEstimatedCapacity, estimatedCapacity));
	}

	//============================================================================================================
	// ADD
	//============================================================================================================
	
	/**
	 * {@inheritDoc Index#addElement(Object, Object)}
	 * 
	 * Complexity: O(1)
	 * 
	 * @param id Object - identifier for slot
	 * @param element Object - adding element  
	 */
	@Override
	public void addElement(K id, V element)
	{
		if (id==null)
			throw new GraphIndexException("Cannot add the given entry, because the given id is empty.");
		
		if (element==null)
			throw new GraphIndexException("Cannot add the given entry, because the given element is empty.");
		
		//update index table
		if (!this.getIndexMap_SlimComplex().containsKey(id))
		{
			LinkedHashSet<V> slot  = new LinkedHashSet<V>();
			getIndexMap_SlimComplex().put(id, slot);
			slot.add(element);
		}
		else if (this.getIndexMap_SlimComplex().get(id).contains(element))
			throw new GraphIndexException("Slot may not contain element more than once.");
		else
			this.getIndexMap_SlimComplex().get(id).add(element);

		this.setNumOfElements(this.getNumOfElements()+1);
	}

	//============================================================================================================
	// REMOVE
	//============================================================================================================

	/**
	 * {@inheritDoc ComplexIndex#removeSlot(Object)}
	 * 
	 * Complexity: O(1)
	 * 
	 * @param id Object - identifier for slot
	 * @return true, if slot is removed, false else
	 */
	@Override
	public Boolean removeSlot(K id)
	{
		if (id==null)
			throw new GraphIndexException("Cannot remove the given entry, because the given id is empty.");
			
		LinkedHashSet<V> slot = this.getIndexMap_SlimComplex().remove(id);
		
		if (slot==null)
			return false;
		
		setNumOfElements(getNumOfElements()-slot.size());

		return true;
	}

		
	
	/**
	 * {@inheritDoc Index#removeElement(Object)}
	 * 
	 * Complexity: O(idxTableSize)*O(1)
	 * 
	 * @param element the element which shall be searches
	 * @return true, if removing was successful
	 */
	@Override
	public Boolean removeElement(V element)
	{
		if (element== null)
			throw new GraphIndexException("Cannot search for the given entry, because an empty element was given.");

		//this is the counter for the number of slots where the element was contained and will be removed
		long numOfRemovedElements = 0;
		
		//this set is used to store the ids of all slots that are emptied by removing the element
		//after iteration of index table, they will be deleted from it
		//removedIds will only be instantiated if neccessary 
		HashSet<Object> removedIds = null;
		
		for (Object id : getIndexMap_SlimComplex().keySet())
		{
			LinkedHashSet<V> slot = getIndexMap_SlimComplex().get(id);
			if (slot.remove(element))
			{
				numOfRemovedElements++;
				if (slot.size()==0)
				{
					if (removedIds==null)
						removedIds = new HashSet<Object>();
					removedIds.add(id);
				}
			}
		}

		//return false if element was not contained in any slot
		if (numOfRemovedElements==0)
			return false;

		//reset numOfElements
		setNumOfElements(getNumOfElements()-numOfRemovedElements);		
		
		//if any slots were emptied be removing the element, delete those from idxTable
		if (removedIds!=null)
			for (Object id : removedIds)
				getIndexMap_SlimComplex().remove(id);

		return true;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IndexPackage.SLIM_COMPLEX_INDEX__NUM_OF_ELEMENTS:
				return getNumOfElements();
			case IndexPackage.SLIM_COMPLEX_INDEX__NUM_OF_ELEMENT_IDS:
				return getNumOfElementIds();
			case IndexPackage.SLIM_COMPLEX_INDEX__INDEX_MAP:
				return getIndexMap();
			case IndexPackage.SLIM_COMPLEX_INDEX__ESTIMATED_CAPACITY:
				return getEstimatedCapacity();
			case IndexPackage.SLIM_COMPLEX_INDEX__SORTABLE:
				return isSortable();
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
			case IndexPackage.SLIM_COMPLEX_INDEX__INDEX_MAP:
				setIndexMap((Map<K, V>)newValue);
				return;
			case IndexPackage.SLIM_COMPLEX_INDEX__ESTIMATED_CAPACITY:
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
			case IndexPackage.SLIM_COMPLEX_INDEX__INDEX_MAP:
				setIndexMap((Map<K, V>)null);
				return;
			case IndexPackage.SLIM_COMPLEX_INDEX__ESTIMATED_CAPACITY:
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
			case IndexPackage.SLIM_COMPLEX_INDEX__NUM_OF_ELEMENTS:
				return NUM_OF_ELEMENTS_EDEFAULT == null ? getNumOfElements() != null : !NUM_OF_ELEMENTS_EDEFAULT.equals(getNumOfElements());
			case IndexPackage.SLIM_COMPLEX_INDEX__NUM_OF_ELEMENT_IDS:
				return NUM_OF_ELEMENT_IDS_EDEFAULT == null ? getNumOfElementIds() != null : !NUM_OF_ELEMENT_IDS_EDEFAULT.equals(getNumOfElementIds());
			case IndexPackage.SLIM_COMPLEX_INDEX__INDEX_MAP:
				return getIndexMap() != null;
			case IndexPackage.SLIM_COMPLEX_INDEX__ESTIMATED_CAPACITY:
				return ESTIMATED_CAPACITY_EDEFAULT == null ? estimatedCapacity != null : !ESTIMATED_CAPACITY_EDEFAULT.equals(estimatedCapacity);
			case IndexPackage.SLIM_COMPLEX_INDEX__SORTABLE:
				return sortable != SORTABLE_EDEFAULT;
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
		result.append(", sortable: ");
		result.append(sortable);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc ComplexIndex#removeAll()}
	 */
	@Override
	public Boolean removeAll()
	{
		this.init();
		return(true);
	}
	
	//============================================================================================================
	// HAS
	//============================================================================================================
	/**
	 * {@inheritDoc ComplexIndex#hasSlot(Object)}
	 * 
	 * Complexity: O(1) 
	 * 
	 * @param id Object - identifier for slot
	 * @return true, if there exists a slot with given id
	 * @throws Exception
	 */
	@Override
	public Boolean hasSlot(K id) 
	{
		return (this.getIndexMap_SlimComplex().containsKey(id));
	}

	/**
	 * {@inheritDoc Index#hasElement(Object)}
	 * 
	 * Complexity: O(idxTableSize)*O(1)
	 *  
	 * @param element Object - element which shall be searched
	 * @return true, if value exists in index
	 */
	@Override
	public Boolean hasKey(K elementId)
	{
		return hasSlot(elementId);
	}

	/**
	 * {@inheritDoc ComplexIndex#getSlot(Object)}
	 */
	@Override
	public EList<V> getSlot(K id)
	{
		LinkedHashSet<V> slot = getIndexMap_SlimComplex().get(id);
		if (slot==null)
			return new BasicEList<V>();
		return new BasicEList<V>(slot);
	}

	/**
	 * {@inheritDoc ComplexIndex#getSlotIds()}
	 */
	@Override
	public EList<K> getSlotIds()
	{
		return new BasicEList<K>(this.getIndexMap_SlimComplex().keySet());
	}


	/** Returns always false since a HashMap is used internally */
    @Override
    public boolean isSortable()
    {
        return false;
    }

} //ComplexIndexImpl
