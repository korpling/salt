/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAnnotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SAnnotationImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SAnnotationImpl#getSValue <em>SValue</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SAnnotationImpl#getSAnnotatbaleElement <em>SAnnotatbale Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAnnotationImpl extends EObjectImpl implements SAnnotation {
	/**
	 * The default value of the '{@link #getSName() <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSName()
	 * @generated
	 * @ordered
	 */
	protected static final String SNAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSName() <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSName()
	 * @generated
	 * @ordered
	 */
	protected String sName = SNAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getSValue() <em>SValue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSValue()
	 * @generated
	 * @ordered
	 */
	protected static final String SVALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSValue() <em>SValue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSValue()
	 * @generated
	 * @ordered
	 */
	protected String sValue = SVALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSName(String newSName) {
		String oldSName = sName;
		sName = newSName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SANNOTATION__SNAME, oldSName, sName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSValue() {
		return sValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSValue(String newSValue) {
		String oldSValue = sValue;
		sValue = newSValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SANNOTATION__SVALUE, oldSValue, sValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SAnnotatableElement getSAnnotatbaleElement() {
		if (eContainerFeatureID() != SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT) return null;
		return (SAnnotatableElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSAnnotatbaleElement(SAnnotatableElement newSAnnotatbaleElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSAnnotatbaleElement, SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSAnnotatbaleElement(SAnnotatableElement newSAnnotatbaleElement) {
		if (newSAnnotatbaleElement != eInternalContainer() || (eContainerFeatureID() != SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT && newSAnnotatbaleElement != null)) {
			if (EcoreUtil.isAncestor(this, newSAnnotatbaleElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSAnnotatbaleElement != null)
				msgs = ((InternalEObject)newSAnnotatbaleElement).eInverseAdd(this, SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS, SAnnotatableElement.class, msgs);
			msgs = basicSetSAnnotatbaleElement(newSAnnotatbaleElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT, newSAnnotatbaleElement, newSAnnotatbaleElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSAnnotatbaleElement((SAnnotatableElement)otherEnd, msgs);
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
			case SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT:
				return basicSetSAnnotatbaleElement(null, msgs);
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
		switch (eContainerFeatureID()) {
			case SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS, SAnnotatableElement.class, msgs);
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
			case SaltCorePackage.SANNOTATION__SNAME:
				return getSName();
			case SaltCorePackage.SANNOTATION__SVALUE:
				return getSValue();
			case SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT:
				return getSAnnotatbaleElement();
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
			case SaltCorePackage.SANNOTATION__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SANNOTATION__SVALUE:
				setSValue((String)newValue);
				return;
			case SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT:
				setSAnnotatbaleElement((SAnnotatableElement)newValue);
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
			case SaltCorePackage.SANNOTATION__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SANNOTATION__SVALUE:
				setSValue(SVALUE_EDEFAULT);
				return;
			case SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT:
				setSAnnotatbaleElement((SAnnotatableElement)null);
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
			case SaltCorePackage.SANNOTATION__SNAME:
				return SNAME_EDEFAULT == null ? sName != null : !SNAME_EDEFAULT.equals(sName);
			case SaltCorePackage.SANNOTATION__SVALUE:
				return SVALUE_EDEFAULT == null ? sValue != null : !SVALUE_EDEFAULT.equals(sValue);
			case SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT:
				return getSAnnotatbaleElement() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (SName: ");
		result.append(sName);
		result.append(", SValue: ");
		result.append(sValue);
		result.append(')');
		return result.toString();
	}

} //SAnnotationImpl
