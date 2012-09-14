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

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;
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
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SimpleIndexImpl#getIdxTable <em>Idx Table</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleIndexImpl extends IdentifiableElementImpl implements SimpleIndex 
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

	protected Map<Object, Object> idxTable;
	
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
		this.idxTable= new Hashtable<Object, Object>();
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
	public Long getNumOfElements() 
	{
		return(new Long(this.getIdxTable().size()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Map<Object, Object> getIdxTable() {
		return idxTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Object getElement(Object elementId) 
	{
		if (elementId== null)
			throw new GraphException("Cannot search for elementId in index, because it is null.");
		return(this.getIdxTable().get(elementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public long getNumOfEntries() 
	{
		return(this.getIdxTable().size());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addElement(Object elementId, Object element) 
	{
		this.getIdxTable().put(elementId, element);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean hasElement(Object elementId) 
	{
		if (elementId== null)
			throw new GraphException("Cannot search for an empty element.");
		if(this.idxTable.get(elementId)!= null)
			return(true);
		else return(false);
	}

	/**
	 * Removes the given element from this index.
	 * @param element - the element which shall be removed
	 * @return true, if removing was successful 
	 * @model
	 */
	public Boolean removeElement(Object element) 
	{
		if (element== null)
			throw new GraphException("Cannot remove element from index '"+this.getId()+"', because element is null.");
		boolean retVal= false;
		long numOfElem= this.getNumOfElements();
		//TODO is contains check necessary?
		//searching for element to remove
		Set<Object> keys= this.getIdxTable().keySet();
		Object foundKey= null;
		for (Object key: keys)
		{
			if (this.getIdxTable().get(key).equals(element))
			{	
				foundKey= key;
				break;
			}
		}
		if (foundKey!= null)
			this.getIdxTable().remove(foundKey);
		
		if (this.getNumOfElements()== numOfElem -1)
			retVal= true;
		else retVal= false;
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean removeAll() 
	{
		this.setIdxTable(new Hashtable<Object, Object>());
		return(this.getIdxTable().size()== 0);
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean removeElementById(Object elementId) 
	{
		Boolean retVal= false;
		int oldLength= this.getIdxTable().size();
		this.getIdxTable().remove(elementId);
		retVal= !(oldLength== this.getIdxTable().size());
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setIdxTable(Map<Object, Object> newIdxTable) 
	{
		this.idxTable= newIdxTable;
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
			case IndexPackage.SIMPLE_INDEX__IDX_TABLE:
				return getIdxTable();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case IndexPackage.SIMPLE_INDEX__IDX_TABLE:
				return getIdxTable() != null;
		}
		return super.eIsSet(featureID);
	}

} //SimpleIndexImpl
