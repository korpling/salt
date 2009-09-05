/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import javax.annotation.Generated;

import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SaltCorePackage;
import de.hub.corpling.salt.saltExceptions.SaltException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SElement Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SElementIdImpl#getSId <em>SId</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SElementIdImpl#getSIdentifiableElement <em>SIdentifiable Element</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SElementIdImpl#getSElementPath <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SElementIdImpl extends EObjectImpl implements SElementId {
	/**
	 * The default value of the '{@link #getSId() <em>SId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSId()
	 * @generated
	 * @ordered
	 */
	protected static final String SID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSId() <em>SId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSId()
	 * @generated
	 * @ordered
	 */
	protected String sId = SID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSElementPath() <em>SElement Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSElementPath()
	 * @generated
	 * @ordered
	 */
	protected static final URI SELEMENT_PATH_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SElementIdImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SELEMENT_ID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSId() 
	{
		return sId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSId(String newSId) 
	{
		String oldSId = sId;
		sId = newSId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT_ID__SID, oldSId, sId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIdentifiableElement getSIdentifiableElement() {
		if (eContainerFeatureID() != SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT) return null;
		return (SIdentifiableElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSIdentifiableElement(SIdentifiableElement newSIdentifiableElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSIdentifiableElement, SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSIdentifiableElement(SIdentifiableElement newSIdentifiableElement) {
		if (newSIdentifiableElement != eInternalContainer() || (eContainerFeatureID() != SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT && newSIdentifiableElement != null)) {
			if (EcoreUtil.isAncestor(this, newSIdentifiableElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSIdentifiableElement != null)
				msgs = ((InternalEObject)newSIdentifiableElement).eInverseAdd(this, SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID, SIdentifiableElement.class, msgs);
			msgs = basicSetSIdentifiableElement(newSIdentifiableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT, newSIdentifiableElement, newSIdentifiableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public URI getSElementPath() 
	{
		URI uri= null;
		try
		{
			uri= URI.createURI(this.getSId());
		}
		catch (java.lang.IllegalArgumentException e) 
		{
			throw new SaltException("Cannot return id of element as element-path, because it is not convertable to an uri.", e);
		}
		return(uri);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSElementPath(URI newSElementPath) 
	{
		this.setSId(newSElementPath.toString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSIdentifiableElement((SIdentifiableElement)otherEnd, msgs);
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
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				return basicSetSIdentifiableElement(null, msgs);
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
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID, SIdentifiableElement.class, msgs);
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
			case SaltCorePackage.SELEMENT_ID__SID:
				return getSId();
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				return getSIdentifiableElement();
			case SaltCorePackage.SELEMENT_ID__SELEMENT_PATH:
				return getSElementPath();
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
			case SaltCorePackage.SELEMENT_ID__SID:
				setSId((String)newValue);
				return;
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				setSIdentifiableElement((SIdentifiableElement)newValue);
				return;
			case SaltCorePackage.SELEMENT_ID__SELEMENT_PATH:
				setSElementPath((URI)newValue);
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
			case SaltCorePackage.SELEMENT_ID__SID:
				setSId(SID_EDEFAULT);
				return;
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				setSIdentifiableElement((SIdentifiableElement)null);
				return;
			case SaltCorePackage.SELEMENT_ID__SELEMENT_PATH:
				setSElementPath(SELEMENT_PATH_EDEFAULT);
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
			case SaltCorePackage.SELEMENT_ID__SID:
				return SID_EDEFAULT == null ? sId != null : !SID_EDEFAULT.equals(sId);
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				return getSIdentifiableElement() != null;
			case SaltCorePackage.SELEMENT_ID__SELEMENT_PATH:
				return SELEMENT_PATH_EDEFAULT == null ? getSElementPath() != null : !SELEMENT_PATH_EDEFAULT.equals(getSElementPath());
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
		result.append(" (sId: ");
		result.append(sId);
		result.append(')');
		return result.toString();
	}

} //SElementIdImpl
