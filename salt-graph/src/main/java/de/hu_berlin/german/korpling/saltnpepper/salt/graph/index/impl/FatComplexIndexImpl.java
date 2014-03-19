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
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphIndexException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.FatComplexIndex;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.FatComplexIndexImpl#getNumOfElements <em>Num Of Elements</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.FatComplexIndexImpl#getNumOfElementIds <em>Num Of Element Ids</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.FatComplexIndexImpl#getIndexMap <em>Index Map</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.FatComplexIndexImpl#getEstimatedCapacity <em>Estimated Capacity</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.FatComplexIndexImpl#isSortable <em>Sortable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FatComplexIndexImpl<K, V> extends IdentifiableElementImpl implements FatComplexIndex<K, V> {
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
     * @ordered
     */
    protected static final boolean SORTABLE_EDEFAULT = true;

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
		return IndexPackage.Literals.FAT_COMPLEX_INDEX;
	}
	
	protected FatComplexIndexImpl() {
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
	 * {@inheritDoc ComplexIndex#getNumOfElementIds()}
	 */
	public Long getNumOfElementIds() {
		return(Long.valueOf(this.getIndexMap_Complex().size()));
	}

	/**
	 * {@inheritDoc ComplexIndex#getIndexMap()}
	 */
	@SuppressWarnings("unchecked")
	public Map<K, V> getIndexMap() {
		return((Map<K, V>)indexMap);
	}
	
	/**
	 * returns the real index map, without casting stuff.
	 */
	public Map<K, EList<V>> getIndexMap_Complex() {
		return(indexMap);
	}

	/**
	 * {@inheritDoc ComplexIndex#setIndexMap(Map)}
	 */
	@SuppressWarnings("unchecked")
	public void setIndexMap(Map<K, V> newIndexMap) {
		//in this method, idxSet and invIdxTable are built according to newIdxTable
		//the addElement method must not be called from this method!
		this.indexMap= (Map<K, EList<V>>) newIndexMap;

		//update index set, inverse index table and set new number of elements
		this.setIdxSet(new HashMap<K, HashSet<V>>());
		this.setInvIdxTable(new HashMap<Object,EList<Object>>());
		
		long elementCount= 0;

		for (Object id : this.getIndexMap_Complex().keySet().toArray()) {
			EList<V> slotList = this.getIndexMap_Complex().get(id);
			
			if (this.getIdxSet().containsKey(id)) {
				throw new GraphIndexException("Index table illegaly contains duplicate index");
			}
			else {
				HashSet<V> slotSet = this.getIdxSet().put((K)id, new HashSet<V>());				
				for (V element : slotList) {
					if (slotSet.contains(element)) {
						throw new GraphIndexException("Index table illegaly contains duplicate element");
					}
					else {
						slotSet.add(element);
						EList<Object> idList = new BasicEList<Object>();
						this.getInvIdxTable().put(element, idList);
						idList.add(id);
					}
				}
			}
			elementCount= elementCount + slotList.size();
		}
		this.setNumOfElements(elementCount);
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
			eNotify(new ENotificationImpl(this, Notification.SET, IndexPackage.FAT_COMPLEX_INDEX__ESTIMATED_CAPACITY, oldEstimatedCapacity, estimatedCapacity));
	}

	//----------------------------------------------------------------------
	/**
	 * Real index storing ids and the corresponding set of values.
	 */
	protected Map<K, EList<V>>   indexMap;
	protected Map<Object, EList<Object>>   invIdxTable;
	protected Map<K, HashSet<V>> idxSet;
	
	protected Map<K, HashSet<V>> getIdxSet() {
		return idxSet;
	}

	protected void setIdxSet(Map<K, HashSet<V>> idxTableObjSet) {
		this.idxSet = idxTableObjSet;
	}

	protected Map<Object, EList<Object>> getInvIdxTable() {
		return invIdxTable;
	}

	protected void setInvIdxTable(HashMap<Object, EList<Object>> InvIdxTable) {
		this.invIdxTable = InvIdxTable;
	}
	
	

	public Long getNumOfSlots() 
	{
		return(Long.valueOf(this.getIndexMap_Complex().size()));
	}
	
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean isSortable()
    {
		return sortable;
	}

	//============================================================================================================
	// ADD
	//============================================================================================================
	
    /**
	 * {@inheritDoc Index#addElement(Object, Object)}
	 */
	public void addElement(K elementId, V element) {
		if (elementId== null) {
			throw new GraphIndexException("Cannot add the given entry, because the given id is empty.");
		}
		
		if (element== null) {
			throw new GraphIndexException("Cannot add the given entry, because the given element is empty.");
		}
		
		//update index table and index set
		if (!this.getIndexMap().containsKey(elementId)) {
			EList<V>   slotList = new BasicEList<V>();
			HashSet<V> slotSet  = new HashSet<V>();
			this.getIndexMap_Complex().put(elementId, slotList);
			this.getIdxSet().put(elementId, slotSet);
			slotList.add(element);
			slotSet.add(element);
		}
		else if (this.getIdxSet().get(elementId).contains(element))	{
			throw new GraphIndexException("Slot may not contain element more than once.");
		}
		else {
			this.getIndexMap_Complex().get(elementId).add(element);
			this.getIdxSet().get(elementId).add(element);
		}
		
		//update inverse index table
		if (!this.getInvIdxTable().containsKey(element)) {
			EList<Object> idList = new BasicEList<Object>();
			this.getInvIdxTable().put(element, idList);
			idList.add(elementId);
		}
		else {
			this.getInvIdxTable().get(element).add(elementId);
		}
		this.setNumOfElements(this.getNumOfElements()+1);
	}

	//============================================================================================================
	// REMOVE
	//============================================================================================================

	/**
	 * {@inheritDoc FatComplexIndex#removeSlot(Object)}
	 */
	public Boolean removeSlot(K elementId) {
			if (elementId== null) {
			throw new GraphIndexException("Cannot remove the given entry, because the given id is empty.");
		}
			
		if (!this.getIndexMap_Complex().containsKey(elementId)) {
			return false; 
		}
		
		long numOfElementsInSlot = this.getIndexMap_Complex().get(elementId).size();  
		
		for (Object element : this.getIndexMap_Complex().get(elementId)) {
			EList<Object> idList = this.getInvIdxTable().get(element);
			idList.remove(elementId);
			if (idList.isEmpty()) {
				this.getInvIdxTable().remove(element);
			}
		}
		this.getIdxSet().remove(elementId);
		this.getIndexMap_Complex().remove(elementId);
		this.setNumOfElements(this.getNumOfElements()-numOfElementsInSlot);
		return true;
	}
	/**
	 * {@inheritDoc Index##removeElement(Object)}
	 */
	public Boolean removeElement(V element) {
		if (element== null) {
			throw new GraphIndexException("Cannot search for the given entry, because an empty element was given.");
		}

		EList<Object> idList = this.getInvIdxTable().get(element);
		
		if (idList==null) {
			return false;
		}

		for (Object id : idList) {
			EList<V>   entryList = this.getIndexMap_Complex().get(id); 
			HashSet<V> entrySet  = this.getIdxSet().get(id);			
			entryList.remove(element);
			entrySet.remove(element);
			if (entryList.isEmpty()) {
				this.getIndexMap_Complex().remove(id);
				this.getIdxSet().remove(id);
			}
		}
		this.setNumOfElements(this.getNumOfElements()-this.getInvIdxTable().get(element).size());
		this.getInvIdxTable().remove(element);
		return true;
	}
	
	/**
	 * {@inheritDoc ComplexIndex#removeAll()}
	 */
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
	 */
	@Override
	public Boolean hasSlot(K elementId) 
	{
		return (this.getIndexMap_Complex().containsKey(elementId));
	}
	
	/**
	 * {@inheritDoc Index#hasKey(Object)}
	 */
	@Override
	public Boolean hasKey(K elementId) {
		if (elementId== null) {
			throw new GraphIndexException("Cannot search for the given element, because it is empty.");
		}
		return this.getIdxSet().containsKey(elementId);
	}

	/**
	 * {@inheritDoc ComplexIndex#getSlot(Object)}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<V> getSlot(K elementid)
	{
		return (EList<V>) this.getIndexMap().get(elementid);	
	}

	/**
	 * Returns a list of all IDs which are related to a slot.  
	 * @return a list of all IDs which are related to a slot.
	 */
	@Override
	public EList<K> getSlotIds()
	{
		return new BasicEList<K>(this.getIndexMap_Complex().keySet());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IndexPackage.FAT_COMPLEX_INDEX__NUM_OF_ELEMENTS:
				return getNumOfElements();
			case IndexPackage.FAT_COMPLEX_INDEX__NUM_OF_ELEMENT_IDS:
				return getNumOfElementIds();
			case IndexPackage.FAT_COMPLEX_INDEX__INDEX_MAP:
				return getIndexMap();
			case IndexPackage.FAT_COMPLEX_INDEX__ESTIMATED_CAPACITY:
				return getEstimatedCapacity();
			case IndexPackage.FAT_COMPLEX_INDEX__SORTABLE:
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
			case IndexPackage.FAT_COMPLEX_INDEX__INDEX_MAP:
				setIndexMap((Map<K, V>)newValue);
				return;
			case IndexPackage.FAT_COMPLEX_INDEX__ESTIMATED_CAPACITY:
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
			case IndexPackage.FAT_COMPLEX_INDEX__INDEX_MAP:
				setIndexMap((Map<K, V>)null);
				return;
			case IndexPackage.FAT_COMPLEX_INDEX__ESTIMATED_CAPACITY:
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
			case IndexPackage.FAT_COMPLEX_INDEX__NUM_OF_ELEMENTS:
				return NUM_OF_ELEMENTS_EDEFAULT == null ? getNumOfElements() != null : !NUM_OF_ELEMENTS_EDEFAULT.equals(getNumOfElements());
			case IndexPackage.FAT_COMPLEX_INDEX__NUM_OF_ELEMENT_IDS:
				return NUM_OF_ELEMENT_IDS_EDEFAULT == null ? getNumOfElementIds() != null : !NUM_OF_ELEMENT_IDS_EDEFAULT.equals(getNumOfElementIds());
			case IndexPackage.FAT_COMPLEX_INDEX__INDEX_MAP:
				return getIndexMap() != null;
			case IndexPackage.FAT_COMPLEX_INDEX__ESTIMATED_CAPACITY:
				return ESTIMATED_CAPACITY_EDEFAULT == null ? estimatedCapacity != null : !ESTIMATED_CAPACITY_EDEFAULT.equals(estimatedCapacity);
			case IndexPackage.FAT_COMPLEX_INDEX__SORTABLE:
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
    public String toString()
    {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (estimatedCapacity: ");
		result.append(estimatedCapacity);
		result.append(", sortable: ");
		result.append(sortable);
		result.append(')');
		return result.toString();
	}
    
    
} //ComplexIndexImpl
