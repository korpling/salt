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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SIdentifiableElementAccessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SIdentifiable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SIdentifiableElementImpl#getSElementId <em>SElement Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SIdentifiableElementImpl#getSId <em>SId</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SIdentifiableElementImpl#getSElementPath <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SIdentifiableElementImpl extends IdentifiableElementImpl implements SIdentifiableElement {
	/**
	 * The default value of the '{@link #getSId() <em>SId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSId()
	 * @generated
	 * @ordered
	 */
	protected static final String SID_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getSElementPath() <em>SElement Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSElementPath()
	 * @generated
	 * @ordered
	 */
	protected static final URI SELEMENT_PATH_EDEFAULT = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SIdentifiableElementImpl() {
		init();
	}
	
	private void init()
	{
		this.sIdentAccessor= new SIdentifiableElementAccessor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SIDENTIFIABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SElementId getSElementId() {
		SElementId sElementId = basicGetSElementId();
		return sElementId != null && sElementId.eIsProxy() ? (SElementId)eResolveProxy((InternalEObject)sElementId) : sElementId;
	}

		/**
	 * Delegatee for SIdentifiableElement
	 */
	private SIdentifiableElementAccessor sIdentAccessor= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SElementId basicGetSElementId() 
	{
		return(sIdentAccessor.getSElementId(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSElementId(SElementId newSElementId) 
	{
		sIdentAccessor.setSElementId(this, newSElementId);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSId() 
	{
		return(this.sIdentAccessor.getSId(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSId(String newSId) 
	{
		this.sIdentAccessor.setSId(this, newSId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public URI getSElementPath() 
	{
		return(this.sIdentAccessor.getSElementPath(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSElementPath(URI newSElementPath) 
	{
		this.sIdentAccessor.setSElementPath(this, newSElementPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID:
				if (resolve) return getSElementId();
				return basicGetSElementId();
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID:
				return getSId();
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH:
				return getSElementPath();
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID:
				setSElementId((SElementId)newValue);
				return;
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID:
				setSId((String)newValue);
				return;
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH:
				setSElementPath((URI)newValue);
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID:
				setSElementId((SElementId)null);
				return;
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID:
				setSId(SID_EDEFAULT);
				return;
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH:
				setSElementPath(SELEMENT_PATH_EDEFAULT);
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID:
				return basicGetSElementId() != null;
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID:
				return SID_EDEFAULT == null ? getSId() != null : !SID_EDEFAULT.equals(getSId());
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH:
				return SELEMENT_PATH_EDEFAULT == null ? getSElementPath() != null : !SELEMENT_PATH_EDEFAULT.equals(getSElementPath());
		}
		return super.eIsSet(featureID);
	}

} //SIdentifiableElementImpl
