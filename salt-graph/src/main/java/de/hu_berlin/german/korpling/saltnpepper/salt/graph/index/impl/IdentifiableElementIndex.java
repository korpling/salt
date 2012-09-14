package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl;

import java.util.Hashtable;
import java.util.Map;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;

public class IdentifiableElementIndex<V extends IdentifiableElement> extends SimpleIndexImpl 
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected IdentifiableElementIndex() {
		super();
		this.init();
	}

	@SuppressWarnings("unchecked")
	private void init()
	{
		this.setIdxTable((Map<Object, Object>) (Map<? extends Object, ? extends Object>) new Hashtable<String, IdentifiableElement>());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public Map<String, V> getIdxTable_V() {
		return (Map<String, V>)(Map<? extends Object, ? extends Object>) idxTable;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public V getElement(String elementId) 
	{
		if (elementId== null)
			throw new GraphException("Cannot search for elementId in index, because it is null.");
		return(this.getIdxTable_V().get(elementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addElement(String elementId, V element) 
	{
		this.getIdxTable().put(elementId, element);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addElement(V element) 
	{
		this.getIdxTable().put(element.getId(), element);
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
	public Boolean removeElement(V element) 
	{
		return(this.removeElementById(element.getId()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Boolean removeAll() 
	{
		this.setIdxTable((Map<Object, Object>) (Map<? extends Object, ? extends Object>) new Hashtable<String, IdentifiableElement>());
		return(this.getIdxTable().size()== 0);
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean removeElementById(String elementId) 
	{
		if (elementId== null)
			throw new GraphException("Cannot remove element from index '"+this.getId()+"', because its elementId is null.");

		return(this.getIdxTable_V().remove(elementId)!= null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setIdxTable(Map<Object, Object> newIdxTable) 
	{
		this.idxTable= newIdxTable;
	}
}
