/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SSequential Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl#getSStart <em>SStart</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl#getSEnd <em>SEnd</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SSequentialRelationImpl extends SRelationImpl implements SSequentialRelation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8967668820882592451L;

	/**
	 * The default value of the '{@link #getSStart() <em>SStart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSStart()
	 * @generated
	 * @ordered
	 */
	protected static final Integer SSTART_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSEnd() <em>SEnd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSEnd()
	 * @generated
	 * @ordered
	 */
	protected static final Integer SEND_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SSequentialRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SSEQUENTIAL_RELATION;
	}

	/**
	 * {@inheritDoc SSequentialRelation#getSStart()}
	 */
	public Integer getSStart() 
	{
		Integer retVal= null;
		String name= SaltCommonPackage.eNS_PREFIX + "::" + FEAT_SSTART;
		SFeature sFeature= this.getSFeature(name);
		if (sFeature!= null)
		{
			retVal= Integer.decode(sFeature.getSValue().toString());
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc SSequentialRelation#setSStart(Integer)}
	 */
	public void setSStart(Integer newSStart) 
	{
		String name= SaltCommonPackage.eNS_PREFIX + "::" + FEAT_SSTART; 
		SFeature sFeature= this.getSFeature(name);
		if (sFeature== null)
		{//create a new sFeature
			sFeature= SaltCommonFactory.eINSTANCE.createSFeature();
			sFeature.setSNS(SaltCommonPackage.eNS_PREFIX);
			sFeature.setSName(FEAT_SSTART);
			this.addSFeature(sFeature);
		}	
		sFeature.setSValue(newSStart);
	}

	/**
	 * {@inheritDoc SSequentialRelation#getSEnd()}
	 */
	public Integer getSEnd() 
	{
		Integer retVal= null;
		String name= SaltCommonPackage.eNS_PREFIX + "::" + FEAT_SEND;
		SFeature sFeature= this.getSFeature(name);
		if (	(sFeature!= null)&&
				(sFeature.getSValue()!= null))
		{
			retVal= Integer.decode(sFeature.getSValue().toString());
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc SSequentialRelation#setSEnd(Integer)}
	 */
	public void setSEnd(Integer newSEnd) 
	{
		String name= SaltCommonPackage.eNS_PREFIX + "::" + FEAT_SEND; 
		SFeature sFeature= this.getSFeature(name);
		if (sFeature== null)
		{//create a new sFeature
			sFeature= SaltCommonFactory.eINSTANCE.createSFeature();
			sFeature.setSNS(SaltCommonPackage.eNS_PREFIX);
			sFeature.setSName(FEAT_SEND);
			this.addSFeature(sFeature);
		}	
		sFeature.setSValue(newSEnd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDocumentStructurePackage.SSEQUENTIAL_RELATION__SSTART:
				return getSStart();
			case SDocumentStructurePackage.SSEQUENTIAL_RELATION__SEND:
				return getSEnd();
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
			case SDocumentStructurePackage.SSEQUENTIAL_RELATION__SSTART:
				setSStart((Integer)newValue);
				return;
			case SDocumentStructurePackage.SSEQUENTIAL_RELATION__SEND:
				setSEnd((Integer)newValue);
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
			case SDocumentStructurePackage.SSEQUENTIAL_RELATION__SSTART:
				setSStart(SSTART_EDEFAULT);
				return;
			case SDocumentStructurePackage.SSEQUENTIAL_RELATION__SEND:
				setSEnd(SEND_EDEFAULT);
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
			case SDocumentStructurePackage.SSEQUENTIAL_RELATION__SSTART:
				return SSTART_EDEFAULT == null ? getSStart() != null : !SSTART_EDEFAULT.equals(getSStart());
			case SDocumentStructurePackage.SSEQUENTIAL_RELATION__SEND:
				return SEND_EDEFAULT == null ? getSEnd() != null : !SEND_EDEFAULT.equals(getSEnd());
		}
		return super.eIsSet(featureID);
	}

} //SSequentialRelationImpl
