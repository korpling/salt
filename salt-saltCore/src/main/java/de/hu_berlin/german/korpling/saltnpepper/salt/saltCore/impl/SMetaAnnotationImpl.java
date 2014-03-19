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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SMeta Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SMetaAnnotationImpl#getSMetaAnnotatableElement <em>SMeta Annotatable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SMetaAnnotationImpl extends SAbstractAnnotationImpl implements SMetaAnnotation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6881951586240249518L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SMetaAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SMETA_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SMetaAnnotatableElement getSMetaAnnotatableElement() 
	{
		SMetaAnnotatableElement retVal= null;
		LabelableElement labelableElement= super.getLabelableElement();
		if (labelableElement instanceof SMetaAnnotatableElement)
			retVal= (SMetaAnnotatableElement) labelableElement;
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSMetaAnnotatableElement(SMetaAnnotatableElement newSMetaAnnotatableElement) 
	{
		super.setLabelableElement(newSMetaAnnotatableElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SaltCorePackage.SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS, SMetaAnnotatableElement.class, msgs);
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
			case SaltCorePackage.SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT:
				return getSMetaAnnotatableElement();
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
			case SaltCorePackage.SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT:
				setSMetaAnnotatableElement((SMetaAnnotatableElement)newValue);
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
			case SaltCorePackage.SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT:
				setSMetaAnnotatableElement((SMetaAnnotatableElement)null);
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
			case SaltCorePackage.SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT:
				return getSMetaAnnotatableElement() != null;
		}
		return super.eIsSet(featureID);
	}

} //SMetaAnnotationImpl
