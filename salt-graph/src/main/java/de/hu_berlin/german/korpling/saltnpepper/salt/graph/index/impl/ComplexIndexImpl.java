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
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.ComplexIndexImpl#getNumOfElements <em>Num Of Elements</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.ComplexIndexImpl#getNumOfSlots <em>Num Of Slots</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.ComplexIndexImpl#getIdxTable <em>Idx Table</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.ComplexIndexImpl#isSortable <em>Sortable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexIndexImpl extends IdentifiableElementImpl implements ComplexIndex {
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
	 * The default value of the '{@link #getNumOfSlots() <em>Num Of Slots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfSlots()
	 * @generated
	 * @ordered
	 */
	protected static final Long NUM_OF_SLOTS_EDEFAULT = null;

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
		return IndexPackage.Literals.COMPLEX_INDEX;
	}
	
	protected ComplexIndexImpl() {
		super();
		this.init();
	}
	
	private void init()
	{
		this.setIdxTable(new Hashtable<Object, EList<Object>>());
		//this is not necessary here, it is already done in setIdxTable() 
		//this.setIdxTableObjSet(new Hashtable<Object, HashSet<Object>>());
		//this.setAllElements(new Hashtable<Object,Integer>());
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
	//----------------------------------------------------------------------
	
	protected Map<Object, EList<Object>>   idxTable;
	protected Map<Object, EList<Object>>   invIdxTable;
	protected Map<Object, HashSet<Object>> idxSet;
	
	protected Map<Object, HashSet<Object>> getIdxSet() {
		return idxSet;
	}

	protected void setIdxSet(Map<Object, HashSet<Object>> idxTableObjSet) {
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
		return(new Long(this.getIdxTable().size()));
	}

	public Map<Object, EList<Object>> getIdxTable() 
	{
		return(this.idxTable);
	}

	public void setIdxTable(Map<Object, EList<Object>> newIdxTable) 
	{
		//in this method, idxSet and invIdxTable are built according to newIdxTable
		//the addElement method must not be called from this method!
		this.idxTable= newIdxTable;

		//update index set, inverse index table and set new number of elements
		this.setIdxSet(new Hashtable<Object, HashSet<Object>>());
		this.setInvIdxTable(new HashMap<Object,EList<Object>>());
		
		long elementCount= 0;

		for (Object id : this.getIdxTable().keySet().toArray()) {
			EList<Object> slotList = this.getIdxTable().get(id);
			
			if (this.getIdxSet().containsKey(id)) {
				throw new GraphException("Index table illegaly contains duplicate index");
			}
			else {
				HashSet<Object> slotSet = this.getIdxSet().put(id, new HashSet<Object>());				
				for (Object element : slotList) {
					if (slotSet.contains(element)) {
						throw new GraphException("Index table illegaly contains duplicate element");
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
    public boolean isSortable()
    {
		return sortable;
	}

    //============================================================================================================
	// ADD
	//============================================================================================================
	
	/**
	 * This method adds an element to slot with given id. If no slot exists it will
	 * be created. No element will ever be inserted into the same slot more than once.
	 * @param id Object - identifier for slot
	 * @param element Object - adding element  
	 */
	public void addElement(Object id, Object element)
	{
		if (id== null) {
			throw new GraphException("Cannot add the given entry, because the given id is empty.");
		}
		
		if (element== null) {
			throw new GraphException("Cannot add the given entry, because the given element is empty.");
		}
		
		//update index table and index set
		if (!this.getIdxTable().containsKey(id)) {
			EList<Object>   slotList = new BasicEList<Object>();
			HashSet<Object> slotSet  = new HashSet<Object>();
			this.getIdxTable().put(id, slotList);
			this.getIdxSet().put(id, slotSet);
			slotList.add(element);
			slotSet.add(element);
		}
		else if (this.getIdxSet().get(id).contains(element))	{
			throw new GraphException("Slot may not contain element more than once.");
		}
		else {
			this.getIdxTable().get(id).add(element);
			this.getIdxSet().get(id).add(element);
		}
		
		//update inverse index table
		if (!this.getInvIdxTable().containsKey(element)) {
			EList<Object> idList = new BasicEList<Object>();
			this.getInvIdxTable().put(element, idList);
			idList.add(id);
		}
		else {
			this.getInvIdxTable().get(element).add(id);
		}
		this.setNumOfElements(this.getNumOfElements()+1);
	}

	//============================================================================================================
	// REMOVE
	//============================================================================================================

	/**
	 * This method removes a slot matching to the given id.
	 * @param id Object - identifier for slot
	 * @return true, if slot is removed, false else
	 */
	public Boolean removeSlot(Object id)
	{
		if (id== null) {
			throw new GraphException("Cannot remove the given entry, because the given id is empty.");
		}
			
		if (!this.getIdxTable().containsKey(id)) {
			return false; 
		}
		
		long numOfElementsInSlot = this.getIdxTable().get(id).size();  
		
		for (Object element : this.getIdxTable().get(id)) {
			EList<Object> idList = this.getInvIdxTable().get(element);
			idList.remove(id);
			if (idList.isEmpty()) {
				this.getInvIdxTable().remove(element);
			}
		}
		this.getIdxSet().remove(id);
		this.getIdxTable().remove(id);
		this.setNumOfElements(this.getNumOfElements()-numOfElementsInSlot);
		return true;
	}

		
	
	/**
	 * This method searches the given element and removes it from index.
	 * @param element the element which shall be searches
	 * @return true, if removing was successful
	 */
	public Boolean removeElement(Object element)
	{
		if (element== null) {
			throw new GraphException("Cannot search for the given entry, because an empty element was given.");
		}

		EList<Object> idList = this.getInvIdxTable().get(element);
		
		if (idList==null) {
			return false;
		}

		for (Object id : idList) {
			EList<Object>   entryList = this.getIdxTable().get(id); 
			HashSet<Object> entrySet  = this.getIdxSet().get(id);			
			entryList.remove(element);
			entrySet.remove(element);
			if (entryList.isEmpty()) {
				this.getIdxTable().remove(id);
				this.getIdxSet().remove(id);
			}
		}
		this.setNumOfElements(this.getNumOfElements()-this.getInvIdxTable().get(element).size());
		this.getInvIdxTable().remove(element);
		return true;
	}

	
	
	
	//============================================================================================================
	// HAS
	//============================================================================================================
	/**
	 * This method returns if index has a slot with the given id.
	 * @param id Object - identifier for slot
	 * @return true, if there exists a slot with given id
	 * @throws Exception
	 */
	public Boolean hasSlot(Object id) 
	{
		return (this.getIdxTable().containsKey(id));
	}
	
	/**
	 * This method returns if the given element exists in this index. 
	 * @param element Object - element which shall be searched
	 * @return true, if value exists in index
	 */
	public Boolean hasElement(Object element)
	{
		if (element== null) {
			throw new GraphException("Cannot search for the given element, because it is empty.");
		}
		return this.getInvIdxTable().containsKey(element);
	}

	/**
	 * This method returns a slot matching to the given id. If id does not exists in
	 * index returnd list is empty.
	 * @return matching slot
	 */
	public EList<Object> getSlot(Object id)
	{
		return this.getIdxTable().get(id);	
	}

	/**
	 * Returns a list of all IDs which are related to a slot.  
	 * @return a list of all IDs which are related to a slot.
	 */
	public EList<Object> getSlotIds()
	{
		return new BasicEList<Object>(this.getIdxTable().keySet());
	}

	/**
	 * This method resets this index, it removes all elements and all slots.
	 * @return true, if removing was successful
	 */
	public Boolean removeAll()
	{
		this.init();
		return(true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IndexPackage.COMPLEX_INDEX__NUM_OF_ELEMENTS:
				return getNumOfElements();
			case IndexPackage.COMPLEX_INDEX__NUM_OF_SLOTS:
				return getNumOfSlots();
			case IndexPackage.COMPLEX_INDEX__IDX_TABLE:
				return getIdxTable();
			case IndexPackage.COMPLEX_INDEX__SORTABLE:
				return isSortable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IndexPackage.COMPLEX_INDEX__IDX_TABLE:
				setIdxTable((Map<Object, EList<Object>>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IndexPackage.COMPLEX_INDEX__IDX_TABLE:
				setIdxTable((Map<Object, EList<Object>>)null);
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
			case IndexPackage.COMPLEX_INDEX__NUM_OF_ELEMENTS:
				return NUM_OF_ELEMENTS_EDEFAULT == null ? getNumOfElements() != null : !NUM_OF_ELEMENTS_EDEFAULT.equals(getNumOfElements());
			case IndexPackage.COMPLEX_INDEX__NUM_OF_SLOTS:
				return NUM_OF_SLOTS_EDEFAULT == null ? getNumOfSlots() != null : !NUM_OF_SLOTS_EDEFAULT.equals(getNumOfSlots());
			case IndexPackage.COMPLEX_INDEX__IDX_TABLE:
				return getIdxTable() != null;
			case IndexPackage.COMPLEX_INDEX__SORTABLE:
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
		result.append(" (sortable: ");
		result.append(sortable);
		result.append(')');
		return result.toString();
	}
    
    
} //ComplexIndexImpl
