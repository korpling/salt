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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mgr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexMgrImpl#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexMgrImpl#getNumOfIndexes <em>Num Of Indexes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexMgrImpl#getGraph <em>Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexMgrImpl extends EObjectImpl implements IndexMgr {
	/**
	 * The cached value of the '{@link #getIndexes() <em>Indexes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexes()
	 * @generated
	 * @ordered
	 */
	protected EList<Index> indexes;

	/**
	 * The default value of the '{@link #getNumOfIndexes() <em>Num Of Indexes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfIndexes()
	 * @generated
	 * @ordered
	 */
	protected static final Long NUM_OF_INDEXES_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexMgrImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IndexPackage.Literals.INDEX_MGR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Index> getIndexes() {
		if (indexes == null) {
			indexes = new EObjectContainmentEList<Index>(Index.class, this, IndexPackage.INDEX_MGR__INDEXES);
		}
		return indexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Long getNumOfIndexes() 
	{
		return(new Long(this.getIndexes().size()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		Graph graph = basicGetGraph();
		return graph != null && graph.eIsProxy() ? (Graph)eResolveProxy((InternalEObject)graph) : graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Graph basicGetGraph() 
	{
		return(this.graph);
	}

	/**
	 * Graph for which this MGr is the index manager.
	 */
	private Graph graph= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setGraph(Graph newGraph) 
	{
		this.graph= newGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addIndex(Index index) 
	{
		if (this.hasIndex(index.getId()))
			throw new GraphException("Cannot add the given index, because an index with this id already exists: "+ index.getId());
		this.getIndexes().add(index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean hasIndex(Object indexId) 
	{
		return(this.getIndex(indexId)!= null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Index getIndex(Object indexId) 
	{
		Index retVal= null;
		for (Index index: this.getIndexes())
		{
			if (index.getId().equals(indexId))
			{
				retVal= index;
				break;
			}
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean removeIndex(Object indexId) 
	{
		long numOfIndexes= this.getNumOfIndexes();
		Index index= this.getIndex(indexId);
		this.getIndexes().remove(index);
		
		return(this.getNumOfIndexes()== numOfIndexes-1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean removeAll() 
	{
		this.getIndexes().clear();
		return(this.getNumOfIndexes()== 0);
	}

	/**
	 * Removes the given element from this index.
	 * @param element - the element which shall be removed
	 * @return true, if removing was successful 
	 * @model
	 */
	public Boolean removeElement(Object element) 
	{
		for (Index index: this.getIndexes())
		{
			index.removeElement(element);
		}
		return(true);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IndexPackage.INDEX_MGR__INDEXES:
				return ((InternalEList<?>)getIndexes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IndexPackage.INDEX_MGR__INDEXES:
				return getIndexes();
			case IndexPackage.INDEX_MGR__NUM_OF_INDEXES:
				return getNumOfIndexes();
			case IndexPackage.INDEX_MGR__GRAPH:
				if (resolve) return getGraph();
				return basicGetGraph();
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
			case IndexPackage.INDEX_MGR__INDEXES:
				getIndexes().clear();
				getIndexes().addAll((Collection<? extends Index>)newValue);
				return;
			case IndexPackage.INDEX_MGR__GRAPH:
				setGraph((Graph)newValue);
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
			case IndexPackage.INDEX_MGR__INDEXES:
				getIndexes().clear();
				return;
			case IndexPackage.INDEX_MGR__GRAPH:
				setGraph((Graph)null);
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
			case IndexPackage.INDEX_MGR__INDEXES:
				return indexes != null && !indexes.isEmpty();
			case IndexPackage.INDEX_MGR__NUM_OF_INDEXES:
				return NUM_OF_INDEXES_EDEFAULT == null ? getNumOfIndexes() != null : !NUM_OF_INDEXES_EDEFAULT.equals(getNumOfIndexes());
			case IndexPackage.INDEX_MGR__GRAPH:
				return basicGetGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //IndexMgrImpl
