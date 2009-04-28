/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.util.graph.impl.LabelableElementImpl;
import de.util.graph.Label;
import de.corpling.salt.model.saltCore.SProcessingAnnotatableElement;
import de.corpling.salt.model.saltCore.SProcessingAnnotation;
import de.corpling.salt.model.saltCore.SaltCorePackage;


import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SProcessing Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SProcessingAnnotatableElementImpl#getSProcessingAnnotations <em>SProcessing Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SProcessingAnnotatableElementImpl extends LabelableElementImpl implements SProcessingAnnotatableElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SProcessingAnnotatableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SPROCESSING_ANNOTATABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SProcessingAnnotation> getSProcessingAnnotations() 
	{
		EList<SProcessingAnnotation> sProcessingAnnotations= (EList<SProcessingAnnotation>) (EList<? extends Label>)super.getLabels();
		return(sProcessingAnnotations);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSProcessingAnnotation(SProcessingAnnotation sProcessingAnnotation) 
	{
		super.addLabel(sProcessingAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SProcessingAnnotation getSProcessingAnnotation(String fullName) 
	{
		return((SProcessingAnnotation)super.getLabel(fullName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS:
				return ((InternalEList<?>)getSProcessingAnnotations()).basicRemove(otherEnd, msgs);
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
			case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS:
				return getSProcessingAnnotations();
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
			case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS:
				getSProcessingAnnotations().clear();
				getSProcessingAnnotations().addAll((Collection<? extends SProcessingAnnotation>)newValue);
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
			case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS:
				getSProcessingAnnotations().clear();
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
			case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS:
				return !getSProcessingAnnotations().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SProcessingAnnotatableElementImpl
