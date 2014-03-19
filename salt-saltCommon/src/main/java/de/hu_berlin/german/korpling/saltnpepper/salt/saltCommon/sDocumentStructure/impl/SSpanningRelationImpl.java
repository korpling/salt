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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltImproperSTypeException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.accessors.STextOverlappingRelationAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.accessors.STimeOverlappingRelationAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SSpanning Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl#getSSpan <em>SSpan</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SSpanningRelationImpl extends SRelationImpl implements SSpanningRelation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4975360691977239272L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SSpanningRelationImpl() {
		super();
		init();
	}

	private void init()
	{
		this.sTextOverlappingRelAccessor= new STextOverlappingRelationAccessor();
		this.sTimeOverlappingRelAccessor= new STimeOverlappingRelationAccessor();
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SSPANNING_RELATION;
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
		if (super.getSTarget() instanceof SToken)
			retVal= (SToken) super.getTarget();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSToken(SToken newSToken) 
	{
		super.setSTarget(newSToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSpan getSSpan() {
		SSpan sSpan = basicGetSSpan();
		return sSpan != null && sSpan.eIsProxy() ? (SSpan)eResolveProxy((InternalEObject)sSpan) : sSpan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SSpan basicGetSSpan() 
	{
		SSpan retVal= null;
		if (super.getSSource() instanceof SSpan)
			retVal= (SSpan) super.getSource();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSpan(SSpan newSSpan) 
	{
		super.setSSource(newSSpan);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSource(SNode sSource) {
		if (sSource instanceof SSpan) {
			this.setSSpan((SSpan)sSource);
		}
		else {
			throw new SaltImproperSTypeException("Parameter for SSpanningRelation.setSSource must be an instance of SSpan.");
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSTarget(SNode sTarget) {
		if (sTarget instanceof SToken) {
			this.setSToken((SToken)sTarget);
		}
		else {
			throw new SaltImproperSTypeException("Parameter for SSpanningRelation.setSTarget must be an instance of '"+SToken.class+"', but is of type "+sTarget.getClass()+".");
		}
	}
	
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
	private STimeOverlappingRelationAccessor sTimeOverlappingRelAccessor= null; 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean isSTimeOverlapping() 
	{
		return(this.sTimeOverlappingRelAccessor.isSTimeOverlapping(this));
	}
// ======================= end: delegating for feature textOverlapping

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
			case SDocumentStructurePackage.SSPANNING_RELATION__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANNING_RELATIONS, SDocumentGraph.class, msgs);
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
			case SDocumentStructurePackage.SSPANNING_RELATION__STOKEN:
				if (resolve) return getSToken();
				return basicGetSToken();
			case SDocumentStructurePackage.SSPANNING_RELATION__SSPAN:
				if (resolve) return getSSpan();
				return basicGetSSpan();
			case SDocumentStructurePackage.SSPANNING_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SSPANNING_RELATION__STOKEN:
				setSToken((SToken)newValue);
				return;
			case SDocumentStructurePackage.SSPANNING_RELATION__SSPAN:
				setSSpan((SSpan)newValue);
				return;
			case SDocumentStructurePackage.SSPANNING_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SSPANNING_RELATION__STOKEN:
				setSToken((SToken)null);
				return;
			case SDocumentStructurePackage.SSPANNING_RELATION__SSPAN:
				setSSpan((SSpan)null);
				return;
			case SDocumentStructurePackage.SSPANNING_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SSPANNING_RELATION__STOKEN:
				return basicGetSToken() != null;
			case SDocumentStructurePackage.SSPANNING_RELATION__SSPAN:
				return basicGetSSpan() != null;
			case SDocumentStructurePackage.SSPANNING_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SSpanningRelationImpl
