/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SIdentifiable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SIdentifiableElementImpl#getSElementId <em>SElement Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SIdentifiableElementImpl extends EObjectImpl implements SIdentifiableElement {
	/**
	 * The cached value of the '{@link #getSElementId() <em>SElement Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSElementId()
	 * @generated
	 * @ordered
	 */
	protected SElementId sElementId;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SIdentifiableElementImpl() {
		super();
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
		return sElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSElementId(SElementId newSElementId, NotificationChain msgs) {
		SElementId oldSElementId = sElementId;
		sElementId = newSElementId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID, oldSElementId, newSElementId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSElementId(SElementId newSElementId) {
		if (newSElementId != sElementId) {
			NotificationChain msgs = null;
			if (sElementId != null)
				msgs = ((InternalEObject)sElementId).eInverseRemove(this, SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT, SElementId.class, msgs);
			if (newSElementId != null)
				msgs = ((InternalEObject)newSElementId).eInverseAdd(this, SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT, SElementId.class, msgs);
			msgs = basicSetSElementId(newSElementId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID, newSElementId, newSElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID:
				if (sElementId != null)
					msgs = ((InternalEObject)sElementId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID, null, msgs);
				return basicSetSElementId((SElementId)otherEnd, msgs);
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID:
				return basicSetSElementId(null, msgs);
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID:
				return getSElementId();
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
				return sElementId != null;
		}
		return super.eIsSet(featureID);
	}

} //SIdentifiableElementImpl
