/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.util.graph.impl.LabelableElementImpl;
import de.util.graph.Label;

import de.corpling.salt.model.saltCore.SFeature;
import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.SStereotypeableElement;
import de.corpling.salt.model.saltCore.SaltCoreFactory;
import de.corpling.salt.model.saltCore.SaltCorePackage;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SStereotypeable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SStereotypeableElementImpl#getSStereotype <em>SStereotype</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SStereotypeableElementImpl#getSFeatures <em>SFeatures</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SStereotypeableElementImpl extends LabelableElementImpl implements SStereotypeableElement 
{
	private static final String MSG_ERR=		"Error("+SStereotypeableElementImpl.class+"): ";
	/**
	 * The cached value of the '{@link #getSStereotype() <em>SStereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSStereotype()
	 * @generated
	 * @ordered
	 */
	protected SStereotype sStereotype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SStereotypeableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SSTEREOTYPEABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotype getSStereotype() {
		if (sStereotype != null && sStereotype.eIsProxy()) {
			InternalEObject oldSStereotype = (InternalEObject)sStereotype;
			sStereotype = (SStereotype)eResolveProxy(oldSStereotype);
			if (sStereotype != oldSStereotype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE, oldSStereotype, sStereotype));
			}
		}
		return sStereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotype basicGetSStereotype() {
		return sStereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSStereotype(SStereotype newSStereotype) {
		SStereotype oldSStereotype = sStereotype;
		sStereotype = newSStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE, oldSStereotype, sStereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SFeature> getSFeatures() 
	{
		return(((EList<SFeature>)(EList<? extends Label>)this.getLabels()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSFeature(String featureName, Object featureValue) 
	{
		if (this.getSFeature(featureName)!= null)
				throw new NullPointerException(MSG_ERR+ "Cannot add this feature, because a feature with this name already exists: "+ featureName);
		SFeature feature= SaltCoreFactory.eINSTANCE.createSFeature();
		feature.setFullName(featureName);
		feature.setValue(featureValue);
		super.addLabel(feature);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeature getSFeature(String featureName) 
	{
		return((SFeature)super.getLabel(featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public boolean removeSFeature(String featureName) 
	{
		return(super.removeLabel(featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSFeature(SFeature feature) 
	{
		super.addLabel(feature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SFEATURES:
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
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE:
				if (resolve) return getSStereotype();
				return basicGetSStereotype();
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SFEATURES:
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
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE:
				setSStereotype((SStereotype)newValue);
				return;
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SFEATURES:
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
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE:
				setSStereotype((SStereotype)null);
				return;
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SFEATURES:
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
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE:
				return sStereotype != null;
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SFEATURES:
				return !getSFeatures().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SStereotypeableElementImpl
