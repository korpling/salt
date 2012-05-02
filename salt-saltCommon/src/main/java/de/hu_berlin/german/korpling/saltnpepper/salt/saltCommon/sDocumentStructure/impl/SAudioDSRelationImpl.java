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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAudio DS Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDSRelationImpl#getSStart <em>SStart</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDSRelationImpl#getSEnd <em>SEnd</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDSRelationImpl#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDSRelationImpl#getSAudioDS <em>SAudio DS</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDSRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAudioDSRelationImpl extends SRelationImpl implements SAudioDSRelation {
	/**
	 * The default value of the '{@link #getSStart() <em>SStart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSStart()
	 * @generated
	 * @ordered
	 */
	protected static final Double SSTART_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSEnd() <em>SEnd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSEnd()
	 * @generated
	 * @ordered
	 */
	protected static final Double SEND_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAudioDSRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SAUDIO_DS_RELATION;
	}

	/**
	 * {@inheritDoc SAudioDSRelation#getSStart()}
	 */
	public Double getSStart() 
	{
		Double retVal= null;
		String name= SaltCommonPackage.eNS_PREFIX + "::" + SSequentialRelation.FEAT_SSTART;
		SFeature sFeature= this.getSFeature(name);
		if (	(sFeature!= null)&&
				(sFeature.getSValue()!= null))
		{
			retVal= Double.valueOf(sFeature.getSValue().toString());
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc SAudioDSRelation#setSStart(Integer)}
	 */
	public void setSStart(Double newSStart) 
	{
		String name= SaltCommonPackage.eNS_PREFIX + "::" + SSequentialRelation.FEAT_SSTART; 
		SFeature sFeature= this.getSFeature(name);
		if (sFeature== null)
		{//create a new sFeature
			sFeature= SaltCommonFactory.eINSTANCE.createSFeature();
			sFeature.setSNS(SaltCommonPackage.eNS_PREFIX);
			sFeature.setSName(SSequentialRelation.FEAT_SSTART);
			this.addSFeature(sFeature);
		}	
		sFeature.setSValue(newSStart);
	}

	/**
	 * {@inheritDoc SAudioDSRelation#getSEnd()}
	 */
	public Double getSEnd() 
	{
		Double retVal= null;
		String name= SaltCommonPackage.eNS_PREFIX + "::" + SSequentialRelation.FEAT_SEND;
		SFeature sFeature= this.getSFeature(name);
		if (	(sFeature!= null)&&
				(sFeature.getSValue()!= null))
		{
			retVal= Double.valueOf(sFeature.getSValue().toString());
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc SAudioDSRelation#setSEnd(Integer)}
	 */
	public void setSEnd(Double newSEnd) 
	{
		String name= SaltCommonPackage.eNS_PREFIX + "::" + SSequentialRelation.FEAT_SEND; 
		SFeature sFeature= this.getSFeature(name);
		if (sFeature== null)
		{//create a new sFeature
			sFeature= SaltCommonFactory.eINSTANCE.createSFeature();
			sFeature.setSNS(SaltCommonPackage.eNS_PREFIX);
			sFeature.setSName(SSequentialRelation.FEAT_SEND);
			this.addSFeature(sFeature);
		}	
		sFeature.setSValue(newSEnd);
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
	 * {@inheritDoc SAudioDSRelation#setSToken(SToken)}
	 */ 
	public void setSToken(SToken newSToken) 
	{
		super.setSSource(newSToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SAudioDataSource getSAudioDS() {
		SAudioDataSource sAudioDS = basicGetSAudioDS();
		return sAudioDS != null && sAudioDS.eIsProxy() ? (SAudioDataSource)eResolveProxy((InternalEObject)sAudioDS) : sAudioDS;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAudioDataSource basicGetSAudioDS() {
		SAudioDataSource retVal= null;
		if (super.getSTarget() instanceof SAudioDataSource)
			retVal= (SAudioDataSource) super.getSTarget();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSAudioDS(SAudioDataSource newSAudioDS) {
		super.setSTarget(newSAudioDS);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SAUDIO_DS_RELATIONS, SDocumentGraph.class, msgs);
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
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SSTART:
				return getSStart();
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SEND:
				return getSEnd();
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__STOKEN:
				if (resolve) return getSToken();
				return basicGetSToken();
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SAUDIO_DS:
				if (resolve) return getSAudioDS();
				return basicGetSAudioDS();
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SSTART:
				setSStart((Double)newValue);
				return;
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SEND:
				setSEnd((Double)newValue);
				return;
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__STOKEN:
				setSToken((SToken)newValue);
				return;
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SAUDIO_DS:
				setSAudioDS((SAudioDataSource)newValue);
				return;
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SSTART:
				setSStart(SSTART_EDEFAULT);
				return;
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SEND:
				setSEnd(SEND_EDEFAULT);
				return;
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__STOKEN:
				setSToken((SToken)null);
				return;
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SAUDIO_DS:
				setSAudioDS((SAudioDataSource)null);
				return;
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SSTART:
				return SSTART_EDEFAULT == null ? getSStart() != null : !SSTART_EDEFAULT.equals(getSStart());
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SEND:
				return SEND_EDEFAULT == null ? getSEnd() != null : !SEND_EDEFAULT.equals(getSEnd());
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__STOKEN:
				return basicGetSToken() != null;
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SAUDIO_DS:
				return basicGetSAudioDS() != null;
			case SDocumentStructurePackage.SAUDIO_DS_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SAudioDSRelationImpl
