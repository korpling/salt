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
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SMetaAnnotatableElementAccessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SMeta Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SMetaAnnotatableElementImpl#getSMetaAnnotations <em>SMeta Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SMetaAnnotatableElementImpl extends LabelableElementImpl implements SMetaAnnotatableElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SMetaAnnotatableElementImpl() {
		super();
		init();
	}
	
	private void init()
	{
		this.sMetaAnnoAccessor= new SMetaAnnotatableElementAccessor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SMETA_ANNOTATABLE_ELEMENT;
	}

//=================== start: handling SMetaAnnotatableElement	
	/**
	 * Delegatee for SMetaAnnotatableElement
	 */
	private SMetaAnnotatableElementAccessor sMetaAnnoAccessor= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SMetaAnnotation> getSMetaAnnotations() 
	{
		return(this.sMetaAnnoAccessor.getSMetaAnnotations(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSMetaAnnotation(SMetaAnnotation SMetaAnnotation) 
	{
		this.sMetaAnnoAccessor.addSMetaAnnotation(this, SMetaAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SMetaAnnotation getSMetaAnnotation(String qName) 
	{
		return(this.sMetaAnnoAccessor.getSMetaAnnotation(this, qName));
	}
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	/* TODO
	 * There is no public method to set the SValueType of a SMetaAnnotation, so the SDATATYPE argument is useless at this time.
	 * When SAbstractAnnotationImpl.setSValue(Object) is called, it will check the type of the argument and call it´s private
	 * method setSValueType(SDATATYPE).
	 * Remove this comment when setSValueType becomes public and this method uses sValueType.
	 * -- hildebax
	 */
	public SMetaAnnotation createSMetaAnnotation(String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		return(this.sMetaAnnoAccessor.createSMetaAnnotation(this, sNS, sName, sValue, sValueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SMetaAnnotation createSMetaAnnotation(String sNS, String sName, String sValueString) {
		return this.createSMetaAnnotation(sNS, sName, sValueString, SDATATYPE.STEXT);
	}

	//=================== end: handling SMetaAnnotatableElement

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS:
				return ((InternalEList<?>)getSMetaAnnotations()).basicRemove(otherEnd, msgs);
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
			case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS:
				return getSMetaAnnotations();
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
			case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS:
				getSMetaAnnotations().clear();
				getSMetaAnnotations().addAll((Collection<? extends SMetaAnnotation>)newValue);
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
			case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS:
				getSMetaAnnotations().clear();
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
			case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS:
				return !getSMetaAnnotations().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SMetaAnnotatableElementImpl
