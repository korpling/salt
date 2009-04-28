/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW.impl;

import de.corpling.salt.saltFW.SaltFWPackage;
import de.corpling.salt.saltFW.SaltModule;
import de.corpling.salt.saltFW.SaltProject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.saltFW.impl.SaltModuleImpl#getSaltProject <em>Salt Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaltModuleImpl extends EObjectImpl implements SaltModule {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltFWPackage.Literals.SALT_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltProject getSaltProject() {
		if (eContainerFeatureID != SaltFWPackage.SALT_MODULE__SALT_PROJECT) return null;
		return (SaltProject)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSaltProject(SaltProject newSaltProject, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSaltProject, SaltFWPackage.SALT_MODULE__SALT_PROJECT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSaltProject(SaltProject newSaltProject) {
		if (newSaltProject != eInternalContainer() || (eContainerFeatureID != SaltFWPackage.SALT_MODULE__SALT_PROJECT && newSaltProject != null)) {
			if (EcoreUtil.isAncestor(this, newSaltProject))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSaltProject != null)
				msgs = ((InternalEObject)newSaltProject).eInverseAdd(this, SaltFWPackage.SALT_PROJECT__SMODULES, SaltProject.class, msgs);
			msgs = basicSetSaltProject(newSaltProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltFWPackage.SALT_MODULE__SALT_PROJECT, newSaltProject, newSaltProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltFWPackage.SALT_MODULE__SALT_PROJECT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSaltProject((SaltProject)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltFWPackage.SALT_MODULE__SALT_PROJECT:
				return basicSetSaltProject(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case SaltFWPackage.SALT_MODULE__SALT_PROJECT:
				return eInternalContainer().eInverseRemove(this, SaltFWPackage.SALT_PROJECT__SMODULES, SaltProject.class, msgs);
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
			case SaltFWPackage.SALT_MODULE__SALT_PROJECT:
				return getSaltProject();
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
			case SaltFWPackage.SALT_MODULE__SALT_PROJECT:
				setSaltProject((SaltProject)newValue);
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
			case SaltFWPackage.SALT_MODULE__SALT_PROJECT:
				setSaltProject((SaltProject)null);
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
			case SaltFWPackage.SALT_MODULE__SALT_PROJECT:
				return getSaltProject() != null;
		}
		return super.eIsSet(featureID);
	}

} //SaltModuleImpl
