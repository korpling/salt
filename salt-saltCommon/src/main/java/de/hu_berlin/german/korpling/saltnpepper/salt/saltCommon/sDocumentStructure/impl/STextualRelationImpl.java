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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltImproperSTypeException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.accessors.STextOverlappingRelationAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STextual Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl#getSTextualDS <em>STextual DS</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STextualRelationImpl extends SSequentialRelationImpl implements STextualRelation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7182563392385532812L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected STextualRelationImpl() 
	{
		super();
		init();
	}

	private void init()
	{
		this.sTextOverlappingRelAccessor= new STextOverlappingRelationAccessor();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.STEXTUAL_RELATION;
	}
	
	/**
	 * Finds all differences between this and the given object. 
	 * @param differences if given parameter is not null all differences will be written in that list
	 * @param obj 
	 * @return
	 */
	@Override
	public boolean equals(EList<String> differences, Object obj)
	{
		if (differences!= null)
		{
			super.equals(differences, obj);
		}
		else
		{
			if (!super.equals(differences, obj))
			{
				return(false);
			}
		}
		if (differences!= null)
		{//needs only to be checked if differences shall be found, because in that case, super returned with false, but method goes on
			if (obj.getClass()!= getClass())
				return(false);
		}//needs only to be checked if differences shall be found, because in that case, super returned with false, but method goes on
		
		{//checking if both relations are of type isOverlapping
			STextualRelation textRel2= (STextualRelation) obj;
			
			if (!this.isSTextOverlapping().equals(textRel2.isSTextOverlapping()))
			{
				if (differences!= null)
					differences.add("One of both relations is not of type isOverlapping, whereas the other one is.");
				else 
					return(false);
			}
		}//checking if both relations are of type isOverlapping
		
		return(true);
	}
	
	/**
	 * Checks if a given SGraph has the same entries as this SNode-object. 
	 * @return if all values are equals.
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean retVal= this.equals(null, obj); 
		return(retVal);
	}	
	//============================ start: handling source and target
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
	public void setSSource(SNode sSource) {
		if (sSource instanceof SToken) {
			this.setSToken((SToken)sSource);
		}
		else {
			throw new SaltImproperSTypeException("Parameter for STextualRelation.setSSource must be an instance of SToken.");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSTarget(SNode sTarget) {
		if (sTarget instanceof STextualDS) {
			this.setSTextualDS((STextualDS)sTarget);
		}
		else {
			throw new SaltImproperSTypeException("Parameter for STextualRelation.setSTarget must be an instance of STextualDS, but was '"+sTarget.getClass()+"'. ");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextualDS getSTextualDS() {
		STextualDS sTextualDS = basicGetSTextualDS();
		return sTextualDS != null && sTextualDS.eIsProxy() ? (STextualDS)eResolveProxy((InternalEObject)sTextualDS) : sTextualDS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public STextualDS basicGetSTextualDS() 
	{
		STextualDS retVal= null;
		if (super.getSTarget() instanceof STextualDS)
			retVal= (STextualDS) super.getSTarget();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSTextualDS(STextualDS newSTextualDS) 
	{
		super.setSTarget(newSTextualDS);
	}
//============================ end: handling source and target
	
	/**
	 * Returns the document-graph, to which this object contains.
	 * @return containing document graph 
	 */
	public SDocumentGraph getSDocumentGraph() 
	{
		SDocumentGraph retVal= null;
		if (super.getSGraph() instanceof SDocumentGraph)
			retVal= (SDocumentGraph) super.getSGraph();
		return(retVal);
	}

	/**
	 * Sets the document graph, to which this object contains.
	 * @param newSDocumentGraph the document graph
	 */
	public void setSDocumentGraph(SDocumentGraph newSDocumentGraph) 
	{
		super.setSGraph(newSDocumentGraph);
	}

// ======================= start: delegating for feature textOverlapping	
	/**
	 * delegatee for textoverlapping
	 */
	private STextOverlappingRelationAccessor sTextOverlappingRelAccessor= null; 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean isSTextOverlapping() 
	{
		return(this.sTextOverlappingRelAccessor.isSTextOverlapping(this));
	}
// ======================= end: delegating for feature textOverlapping
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS, SDocumentGraph.class, msgs);
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__STOKEN:
				if (resolve) return getSToken();
				return basicGetSToken();
			case SDocumentStructurePackage.STEXTUAL_RELATION__STEXTUAL_DS:
				if (resolve) return getSTextualDS();
				return basicGetSTextualDS();
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__STOKEN:
				setSToken((SToken)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__STEXTUAL_DS:
				setSTextualDS((STextualDS)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__STOKEN:
				setSToken((SToken)null);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__STEXTUAL_DS:
				setSTextualDS((STextualDS)null);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__STOKEN:
				return basicGetSToken() != null;
			case SDocumentStructurePackage.STEXTUAL_RELATION__STEXTUAL_DS:
				return basicGetSTextualDS() != null;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //STextualRelationImpl
