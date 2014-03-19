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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import org.eclipse.emf.common.notify.NotificationChain;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.accessors.STimeOverlappingRelationAccessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STimeline Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl#getSTimeline <em>STimeline</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STimelineRelationImpl extends SSequentialRelationImpl implements STimelineRelation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3003719957169950864L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected STimelineRelationImpl() {
		super();
		init();
	}
	
	private void init()
	{
		this.sTimeOverlappingRelAccessor= new STimeOverlappingRelationAccessor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.STIMELINE_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STimeline getSTimeline() {
		STimeline sTimeline = basicGetSTimeline();
		return sTimeline != null && sTimeline.eIsProxy() ? (STimeline)eResolveProxy((InternalEObject)sTimeline) : sTimeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public STimeline basicGetSTimeline() 
	{
		STimeline retVal= null;
		if (super.getSTarget() instanceof STimeline)
			retVal= (STimeline) super.getSTarget();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSTimeline(STimeline newSTimeline) 
	{
		super.setSTarget(newSTimeline);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SToken getSToken() {
		SToken sToken = basicGetSToken();
		return sToken != null && sToken.eIsProxy() ? (SToken)eResolveProxy((InternalEObject)sToken) : sToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SToken basicGetSToken() 
	{
		SToken retVal= null;
		if (super.getSSource() instanceof SToken)
			retVal= (SToken) super.getSSource();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSToken(SToken newSToken) 
	{
		super.setSSource(newSToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
// ======================= start: delegating for feature textOverlapping	
	/**
	 * delegatee for textoverlapping
	 */
	private STimeOverlappingRelationAccessor sTimeOverlappingRelAccessor= null; 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean isSTimeOverlapping() 
	{
		return(this.sTimeOverlappingRelAccessor.isSTimeOverlapping(this));
	}
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SDocumentStructurePackage.STIMELINE_RELATION__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__STIMELINE_RELATIONS, SDocumentGraph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	// ======================= end: delegating for feature textOverlapping

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDocumentStructurePackage.STIMELINE_RELATION__STIMELINE:
				if (resolve) return getSTimeline();
				return basicGetSTimeline();
			case SDocumentStructurePackage.STIMELINE_RELATION__STOKEN:
				if (resolve) return getSToken();
				return basicGetSToken();
			case SDocumentStructurePackage.STIMELINE_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph();
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
			case SDocumentStructurePackage.STIMELINE_RELATION__STIMELINE:
				setSTimeline((STimeline)newValue);
				return;
			case SDocumentStructurePackage.STIMELINE_RELATION__STOKEN:
				setSToken((SToken)newValue);
				return;
			case SDocumentStructurePackage.STIMELINE_RELATION__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)newValue);
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
			case SDocumentStructurePackage.STIMELINE_RELATION__STIMELINE:
				setSTimeline((STimeline)null);
				return;
			case SDocumentStructurePackage.STIMELINE_RELATION__STOKEN:
				setSToken((SToken)null);
				return;
			case SDocumentStructurePackage.STIMELINE_RELATION__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)null);
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
			case SDocumentStructurePackage.STIMELINE_RELATION__STIMELINE:
				return basicGetSTimeline() != null;
			case SDocumentStructurePackage.STIMELINE_RELATION__STOKEN:
				return basicGetSToken() != null;
			case SDocumentStructurePackage.STIMELINE_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //STimelineRelationImpl
