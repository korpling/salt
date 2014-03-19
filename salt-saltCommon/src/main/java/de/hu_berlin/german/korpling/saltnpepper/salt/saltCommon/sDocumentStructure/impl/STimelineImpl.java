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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STimeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineImpl#getSPointsOfTime <em>SPoints Of Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STimelineImpl extends SSequentialDSImpl implements STimeline {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3777842318169430019L;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STimelineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.STIMELINE;
	}

	public String timeLineSeperator= "#";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getSPointsOfTime()  
	{
		EList<String> retVal= null;
		String timelineStr= (String) super.getSData();
		if (timelineStr!= null)
		{	
			String[] timelineStrArr= timelineStr.split("#");
				
			
			retVal= new EcoreEList.UnmodifiableEList(this,
					SaltCorePackage.eINSTANCE.getSFeaturableElement_SFeatures(),
					timelineStrArr.length, timelineStrArr);
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraph getSDocumentGraph() {
		SDocumentGraph sDocumentGraph = basicGetSDocumentGraph();
		return sDocumentGraph != null && sDocumentGraph.eIsProxy() ? (SDocumentGraph)eResolveProxy((InternalEObject)sDocumentGraph) : sDocumentGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocumentGraph basicGetSDocumentGraph() 
	{
		SDocumentGraph retVal= null;
		if (super.getSGraph() instanceof SDocumentGraph)
			retVal= (SDocumentGraph) super.getSGraph();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSDocumentGraph(SDocumentGraph newSDocumentGraph) 
	{
		super.setSGraph(newSDocumentGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSPointOfTime(String sPointOfTime) 
	{
		if (sPointOfTime== null)
			throw new SaltException("Cannot add an empty point of time.");
		String timeline= (String) super.getSData();
		if (timeline== null)
		{	
			String pot= null;
			if (sPointOfTime.isEmpty())
				pot= "0";
			else pot= sPointOfTime;
			
			timeline= pot;
		}	
		else
		{
			String pot= null;
			if (sPointOfTime.isEmpty())
			{
				pot= this.getSPointsOfTime().size()+ "";
			}
			else pot= sPointOfTime;
			
			timeline= timeline+ timeLineSeperator + pot;
		}
		super.setSData(timeline);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDocumentStructurePackage.STIMELINE__SDOCUMENT_GRAPH:
				if (resolve) return getSDocumentGraph();
				return basicGetSDocumentGraph();
			case SDocumentStructurePackage.STIMELINE__SPOINTS_OF_TIME:
				return getSPointsOfTime();
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
			case SDocumentStructurePackage.STIMELINE__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)newValue);
				return;
			case SDocumentStructurePackage.STIMELINE__SPOINTS_OF_TIME:
				getSPointsOfTime().clear();
				getSPointsOfTime().addAll((Collection<? extends String>)newValue);
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
			case SDocumentStructurePackage.STIMELINE__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)null);
				return;
			case SDocumentStructurePackage.STIMELINE__SPOINTS_OF_TIME:
				getSPointsOfTime().clear();
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
			case SDocumentStructurePackage.STIMELINE__SDOCUMENT_GRAPH:
				return basicGetSDocumentGraph() != null;
			case SDocumentStructurePackage.STIMELINE__SPOINTS_OF_TIME:
				return !getSPointsOfTime().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //STimelineImpl
