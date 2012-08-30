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
import java.util.LinkedHashSet;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

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
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlimComplexIndexImpl extends IdentifiableElementImpl implements ComplexIndex {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IndexPackage.Literals.COMPLEX_INDEX;
	}
	
	protected SlimComplexIndexImpl() {
		super();
		this.init();
	}
	
	private void init()
	{
		this.setIdxTable(new HashMap<Object, EList<Object>>());
	}
	
	//----------------------------------------------------------------------
	protected Long numOfElements;
	
	protected void setNumOfElements(Long numOfElements) {
		this.numOfElements = numOfElements;
	}

	public Long getNumOfElements() {
		return numOfElements;
	}

	public Long getNumOfSlots() 
	{
		return(new Long(this.getIdxTable().size()));
	}

	//----------------------------------------------------------------------
	
	protected Map<Object, LinkedHashSet<Object>> idxTable;	
	
	public Map<Object, LinkedHashSet<Object>> getIdxTable() 
	{
		return(this.idxTable);
	}

	public void setIdxTable(Map<Object, EList<Object>> newIdxTable) 
	{

		//check duplicates in slots
		
		
		//the addElement method must not be called from this method!
		this.idxTable = new HashMap<Object, LinkedHashSet<Object>>();
		long elementCount= 0;
		for (Object id : newIdxTable.keySet())
		{
			LinkedHashSet<Object> slot = new LinkedHashSet<Object>(newIdxTable.get(id));  
			
			HashSet<Object> elementSet = new HashSet<Object>();
			for (Object element : newIdxTable.get(id))
				if (elementSet.contains(element))
					throw new GraphException("Index table illegaly contains duplicate element");
			
			idxTable.put(id, slot);
			elementCount += slot.size();
		}
		this.setNumOfElements(elementCount);
	}
	
	//============================================================================================================
	// ADD
	//============================================================================================================
	
	/**
	 * This method adds an element to slot with given id. If no slot exists it will
	 * be created. No element will ever be inserted into the same slot more than once.
	 * 
	 * Complexity: O(1)
	 * 
	 * @param id Object - identifier for slot
	 * @param element Object - adding element  
	 */
	public void addElement(Object id, Object element)
	{
		if (id==null)
			throw new GraphException("Cannot add the given entry, because the given id is empty.");
		
		if (element==null)
			throw new GraphException("Cannot add the given entry, because the given element is empty.");
		
		//update index table
		if (!this.getIdxTable().containsKey(id))
		{
			LinkedHashSet<Object> slot  = new LinkedHashSet<Object>();
			getIdxTable().put(id, slot);
			slot.add(element);
		}
		else if (this.getIdxTable().get(id).contains(element))
			throw new GraphException("Slot may not contain element more than once.");
		else
			this.getIdxTable().get(id).add(element);

		this.setNumOfElements(this.getNumOfElements()+1);
	}

	//============================================================================================================
	// REMOVE
	//============================================================================================================

	/**
	 * This method removes a slot matching to the given id.
	 * 
	 * Complexity: O(1)
	 * 
	 * @param id Object - identifier for slot
	 * @return true, if slot is removed, false else
	 */
	public Boolean removeSlot(Object id)
	{
		if (id==null)
			throw new GraphException("Cannot remove the given entry, because the given id is empty.");
			
		LinkedHashSet<Object> slot = this.getIdxTable().remove(id);
		
		if (slot==null)
			return false;
		
		setNumOfElements(getNumOfElements()-slot.size());

		return true;
	}

		
	
	/**
	 * This method searches the given element and removes it from index.
	 * 
	 * Complexity: O(idxTableSize)*O(1)
	 * 
	 * @param element the element which shall be searches
	 * @return true, if removing was successful
	 */
	public Boolean removeElement(Object element)
	{
		if (element== null)
			throw new GraphException("Cannot search for the given entry, because an empty element was given.");

		//this is the counter for the number of slots where the element was contained and will be removed
		long numOfRemovedElements = 0;
		
		//this set is used to store the ids of all slots that are emptied by removing the element
		//after iteration of index table, they will be deleted from it
		//removedIds will only be instantiated if neccessary 
		HashSet<Object> removedIds = null;
		
		for (Object id : getIdxTable().keySet())
		{
			LinkedHashSet<Object> slot = getIdxTable().get(id);
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
				getIdxTable().remove(id);

		return true;
	}

	
	
	
	//============================================================================================================
	// HAS
	//============================================================================================================
	/**
	 * This method returns if index has a slot with the given id.
	 * 
	 * Complexity: O(1) 
	 * 
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
	 * 
	 * Complexity: O(idxTableSize)*O(1)
	 *  
	 * @param element Object - element which shall be searched
	 * @return true, if value exists in index
	 */
	public Boolean hasElement(Object element)
	{
		if (element==null)
			throw new GraphException("Cannot search for the given element, because it is empty.");

		for (Object id : getIdxTable().keySet())
			if (getIdxTable().get(id).contains(element))
				return true;

		return false;
	}

	/**
	 * This method returns a slot matching to the given id. If id does not exists in
	 * index returnd list is empty.
	 * @return matching slot
	 */
	public EList<Object> getSlot(Object id)
	{
		return new BasicEList<Object>(getIdxTable().get(id));		
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
		}
		return super.eIsSet(featureID);
	}

} //ComplexIndexImpl
