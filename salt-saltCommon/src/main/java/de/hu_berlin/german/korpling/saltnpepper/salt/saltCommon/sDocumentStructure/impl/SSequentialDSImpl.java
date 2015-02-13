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

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl;
import org.eclipse.emf.common.notify.Notification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SSequential DS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl#getSData <em>SData</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl#getSStart <em>SStart</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl#getSEnd <em>SEnd</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SSequentialDSImpl extends SNodeImpl implements SSequentialDS {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1878043916316208616L;

	/**
	 * The default value of the '{@link #getSData() <em>SData</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSData()
	 * @generated
	 * @ordered
	 */
	protected static final Object SDATA_EDEFAULT = null;

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
	protected SSequentialDSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SSEQUENTIAL_DS;
	}

	public String KW_SDATA= "SDATA";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Object getSData() 
	{
		Object retVal= null;
		String name= SaltCommonPackage.eNS_PREFIX + "::" + KW_SDATA;
		SFeature sFeature= this.getSFeature(name);
		if (sFeature!= null)
		{
			retVal= sFeature.getSValue();
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSData(Object newSData) 
	{
		String name= SaltCommonPackage.eNS_PREFIX + "::" + KW_SDATA; 
		SFeature sFeature= this.getSFeature(name);
		if (sFeature== null)
		{//create a new sFeature
			sFeature= SaltCommonFactory.eINSTANCE.createSFeature();
			sFeature.setSNS(SaltCommonPackage.eNS_PREFIX);
			sFeature.setSName(KW_SDATA);
			this.addSFeature(sFeature);
		}	
		sFeature.setSValue(newSData);
	}

	/**
	 * {@inheritDoc SSequentialDS#getSStart()}. This method throws an exception, and has to be overridden by 
	 * derived classes.
	 */
	public Integer getSStart() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc SSequentialDS#getSEnd()}. This method throws an exception, and has to be overridden by 
	 * 
	 */
	public Integer getSEnd() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SDATA:
				return getSData();
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SSTART:
				return getSStart();
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SEND:
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
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SDATA:
				setSData(newValue);
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
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SDATA:
				setSData(SDATA_EDEFAULT);
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
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SDATA:
				return SDATA_EDEFAULT == null ? getSData() != null : !SDATA_EDEFAULT.equals(getSData());
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SSTART:
				return SSTART_EDEFAULT == null ? getSStart() != null : !SSTART_EDEFAULT.equals(getSStart());
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SEND:
				return SEND_EDEFAULT == null ? getSEnd() != null : !SEND_EDEFAULT.equals(getSEnd());
		}
		return super.eIsSet(featureID);
	}

} //SSequentialDSImpl
