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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCorpus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusImpl#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCorpusImpl extends SNodeImpl implements SCorpus {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SCorpusStructurePackage.Literals.SCORPUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpusGraph getSCorpusGraph() 
	{
		SCorpusGraph retVal= null;
		if (super.getSGraph() instanceof SCorpusGraph)
			retVal= (SCorpusGraph) super.getSGraph();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSCorpusGraph(SCorpusGraph newSCorpusGraph) 
	{
		super.setSGraph(newSCorpusGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SCorpusStructurePackage.SCORPUS__SCORPUS_GRAPH:
				return eInternalContainer().eInverseRemove(this, SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA, SCorpusGraph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SCorpusStructurePackage.SCORPUS__SCORPUS_GRAPH:
				return getSCorpusGraph();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SCorpusStructurePackage.SCORPUS__SCORPUS_GRAPH:
				setSCorpusGraph((SCorpusGraph)newValue);
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
			case SCorpusStructurePackage.SCORPUS__SCORPUS_GRAPH:
				setSCorpusGraph((SCorpusGraph)null);
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
			case SCorpusStructurePackage.SCORPUS__SCORPUS_GRAPH:
				return getSCorpusGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SCorpusImpl
