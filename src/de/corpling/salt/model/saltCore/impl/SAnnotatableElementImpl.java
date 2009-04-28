/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.corpling.salt.model.saltCore.SAnnotatableElement;
import de.corpling.salt.model.saltCore.SAnnotation;
import de.corpling.salt.model.saltCore.SaltCorePackage;
import de.util.graph.impl.LabelableElementImpl;
import de.util.graph.Label;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAnnotatable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SAnnotatableElementImpl#getSAnnotations <em>SAnnotations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAnnotatableElementImpl extends LabelableElementImpl implements SAnnotatableElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAnnotatableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SANNOTATABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SAnnotation> getSAnnotations() 
	{
		EList<SAnnotation> sProcessingAnnotations= (EList<SAnnotation>) (EList<? extends Label>)super.getLabels();
		return(sProcessingAnnotations);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSAnnotation(SAnnotation sProcessingAnnotation) 
	{
		super.addLabel(sProcessingAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAnnotation getSAnnotation(String fullName) 
	{
		return((SAnnotation)super.getLabel(fullName));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
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
			case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS:
				return getSAnnotations();
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
			case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
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
			case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS:
				getSAnnotations().clear();
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
			case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS:
				return !getSAnnotations().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SAnnotatableElementImpl
