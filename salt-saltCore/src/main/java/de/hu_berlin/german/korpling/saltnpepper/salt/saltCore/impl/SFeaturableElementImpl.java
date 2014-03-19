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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelableElementImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SFeaturableElementAccessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SFeaturable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SFeaturableElementImpl#getSFeatures <em>SFeatures</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SFeaturableElementImpl extends LabelableElementImpl implements SFeaturableElement {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6746026018411798230L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SFeaturableElementImpl() {
		super();
		init();
	}
	
	private void init()
	{
		this.sFeatAccessor= new SFeaturableElementAccessor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SFEATURABLE_ELEMENT;
	}

	/**
	 * Delegatee for SFeaturableElementAccessor
	 */
	private SFeaturableElementAccessor sFeatAccessor= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SFeature> getSFeatures() 
	{
		return(this.sFeatAccessor.getSFeatures(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSFeature(SFeature sFeature) 
	{
		this.sFeatAccessor.addSFeature(this, sFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeature getSFeature(String sFeatureId) 
	{
		return(this.sFeatAccessor.getSFeature(this, sFeatureId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeature getSFeature(String sNamespace, String sFeatureName) 
	{
		return(this.sFeatAccessor.getSFeature(this, sNamespace, sFeatureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	/* TODO
	 * There is no public method to set the SValueType of a SFeature, so the SDATATYPE argument is useless at this time.
	 * When SAbstractAnnotationImpl.setSValue(Object) is called, it will check the type of the argument and call it´s private
	 * method setSValueType(SDATATYPE).
	 * Remove this comment when setSValueType becomes public and this method uses sValueType.
	 * -- hildebax
	 */
	public SFeature createSFeature(String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		return (this.sFeatAccessor.createSFeature(this, sNS, sName, sValue, sValueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeature createSFeature(String sNS, String sName, String sValueString) {
		return this.createSFeature(sNS, sName, sValueString, SDATATYPE.STEXT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES:
				return ((InternalEList<?>)getSFeatures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES:
				return getSFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES:
				getSFeatures().clear();
				getSFeatures().addAll((Collection<? extends SFeature>)newValue);
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
			case SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES:
				getSFeatures().clear();
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
			case SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES:
				return !getSFeatures().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SFeaturableElementImpl
