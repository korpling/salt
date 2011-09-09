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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SFeature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SFeatureImpl#getSFeaturableElement <em>SFeaturable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SFeatureImpl extends SAbstractAnnotationImpl implements SFeature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SFEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeaturableElement getSFeaturableElement() 
	{
		SFeaturableElement retVal= null;
		LabelableElement labelableElement= super.getLabelableElement();
		if (labelableElement instanceof SFeaturableElement)
			retVal= (SFeaturableElement) labelableElement;
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSFeaturableElement(SFeaturableElement newSFeaturableElement) 
	{
		super.setLabelableElement(newSFeaturableElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SaltCorePackage.SFEATURE__SFEATURABLE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES, SFeaturableElement.class, msgs);
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
			case SaltCorePackage.SFEATURE__SFEATURABLE_ELEMENT:
				return getSFeaturableElement();
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
			case SaltCorePackage.SFEATURE__SFEATURABLE_ELEMENT:
				setSFeaturableElement((SFeaturableElement)newValue);
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
			case SaltCorePackage.SFEATURE__SFEATURABLE_ELEMENT:
				setSFeaturableElement((SFeaturableElement)null);
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
			case SaltCorePackage.SFEATURE__SFEATURABLE_ELEMENT:
				return getSFeaturableElement() != null;
		}
		return super.eIsSet(featureID);
	}

} //SFeatureImpl
