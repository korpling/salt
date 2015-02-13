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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltValidateException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SData Source Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDataSourceSequenceImpl#getSStart <em>SStart</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDataSourceSequenceImpl#getSEnd <em>SEnd</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDataSourceSequenceImpl#getSSequentialDS <em>SSequential DS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDataSourceSequenceImpl extends EObjectImpl implements SDataSourceSequence {
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
	 * The cached value of the '{@link #getSStart() <em>SStart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSStart()
	 * @generated
	 * @ordered
	 */
	protected Integer sStart = SSTART_EDEFAULT;

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
	 * The cached value of the '{@link #getSEnd() <em>SEnd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSEnd()
	 * @generated
	 * @ordered
	 */
	protected Integer sEnd = SEND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSSequentialDS() <em>SSequential DS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSequentialDS()
	 * @generated
	 * @ordered
	 */
	protected SSequentialDS sSequentialDS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDataSourceSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SDATA_SOURCE_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getSStart() {
		return sStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSStart(Integer newSStart) {
		Integer oldSStart = sStart;
		sStart = newSStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSTART, oldSStart, sStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getSEnd() {
		return sEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSEnd(Integer newSEnd) {
		Integer oldSEnd = sEnd;
		sEnd = newSEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SEND, oldSEnd, sEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSequentialDS getSSequentialDS() {
		if (sSequentialDS != null && sSequentialDS.eIsProxy()) {
			InternalEObject oldSSequentialDS = (InternalEObject)sSequentialDS;
			sSequentialDS = (SSequentialDS)eResolveProxy(oldSSequentialDS);
			if (sSequentialDS != oldSSequentialDS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSEQUENTIAL_DS, oldSSequentialDS, sSequentialDS));
			}
		}
		return sSequentialDS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSequentialDS basicGetSSequentialDS() {
		return sSequentialDS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSequentialDS(SSequentialDS newSSequentialDS) {
		SSequentialDS oldSSequentialDS = sSequentialDS;
		sSequentialDS = newSSequentialDS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSEQUENTIAL_DS, oldSSequentialDS, sSequentialDS));
	}

	/**
	 * {@inheritDoc SDataSourceSequence#validate()}
	 */
	public Boolean validate() 
	{
		if (this.getSSequentialDS()== null)
			throw new SaltValidateException("The object '"+this.toString()+"' is not valid, because no data source is given.");
		if (this.getSStart()== null)
			throw new SaltValidateException("The object '"+this.toString()+"' is not valid, because the value 'sStart' is not set.");
		if (this.getSEnd()== null)
			throw new SaltValidateException("The object '"+this.toString()+"' is not valid, because the value 'sEnd' is not set.");
		
		if (this.getSSequentialDS().getSData()== null)
			throw new SaltValidateException("The object '"+this.toString()+"' is not valid, because the given data source does not contain a 'sData' value.");
		if (this.getSSequentialDS().getSData() instanceof String)
		{
			if (this.getSStart()> ((String)this.getSSequentialDS().getSData()).length())
				throw new SaltValidateException("The object '"+this.toString()+"' is not valid, because the 'sStart' value is bigger than the length of the 'sData' value.");
			if (this.getSEnd()> ((String)this.getSSequentialDS().getSData()).length())
				throw new SaltValidateException("The object '"+this.toString()+"' is not valid, because the 'sEnd' value is bigger than the length of the 'sData' value.");
		}
		return(true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSTART:
				return getSStart();
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SEND:
				return getSEnd();
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSEQUENTIAL_DS:
				if (resolve) return getSSequentialDS();
				return basicGetSSequentialDS();
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
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSTART:
				setSStart((Integer)newValue);
				return;
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SEND:
				setSEnd((Integer)newValue);
				return;
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSEQUENTIAL_DS:
				setSSequentialDS((SSequentialDS)newValue);
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
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSTART:
				setSStart(SSTART_EDEFAULT);
				return;
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SEND:
				setSEnd(SEND_EDEFAULT);
				return;
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSEQUENTIAL_DS:
				setSSequentialDS((SSequentialDS)null);
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
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSTART:
				return SSTART_EDEFAULT == null ? sStart != null : !SSTART_EDEFAULT.equals(sStart);
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SEND:
				return SEND_EDEFAULT == null ? sEnd != null : !SEND_EDEFAULT.equals(sEnd);
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE__SSEQUENTIAL_DS:
				return sSequentialDS != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sStart: ");
		result.append(sStart);
		result.append(", sEnd: ");
		result.append(sEnd);
		result.append(')');
		return result.toString();
	}

} //SDataSourceSequenceImpl
