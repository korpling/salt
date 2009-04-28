/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;


import de.corpling.salt.model.saltCore.SELEMENT_TYPE;
import de.corpling.salt.model.saltCore.SElementPath;
import de.corpling.salt.model.saltCore.SIdentifiableElement;
import de.corpling.salt.model.saltCore.SaltCorePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SElement Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementPathImpl#getParentPath <em>Parent Path</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementPathImpl#getSElement <em>SElement</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementPathImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementPathImpl#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SElementPathImpl extends EObjectImpl implements SElementPath 
{
	private static final String MSG_ERR=	"Error("+SElementPathImpl.class+"): ";
	/**
	 * The default value of the '{@link #getParentPath() <em>Parent Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentPath() <em>Parent Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentPath()
	 * @generated
	 * @ordered
	 */
	protected String parentPath = PARENT_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getElementType() <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected static final SELEMENT_TYPE ELEMENT_TYPE_EDEFAULT = SELEMENT_TYPE.CORPUS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SElementPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SELEMENT_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParentPath() {
		return parentPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentPath(String newParentPath) {
		String oldParentPath = parentPath;
		parentPath = newParentPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT_PATH__PARENT_PATH, oldParentPath, parentPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIdentifiableElement getSElement() {
		if (eContainerFeatureID != SaltCorePackage.SELEMENT_PATH__SELEMENT) return null;
		return (SIdentifiableElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSElement(SIdentifiableElement newSElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSElement, SaltCorePackage.SELEMENT_PATH__SELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSElement(SIdentifiableElement newSElement) {
		if (newSElement != eInternalContainer() || (eContainerFeatureID != SaltCorePackage.SELEMENT_PATH__SELEMENT && newSElement != null)) {
			if (EcoreUtil.isAncestor(this, newSElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSElement != null)
				msgs = ((InternalEObject)newSElement).eInverseAdd(this, SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH, SIdentifiableElement.class, msgs);
			msgs = basicSetSElement(newSElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT_PATH__SELEMENT, newSElement, newSElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getName() 
	{
		String retVal= null;
		if (this.getSElement()!= null)
			retVal= this.getSElement().getName();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setName(String newName) 
	{
		if (this.getSElement()!= null)
			throw new NullPointerException(MSG_ERR + "Cannot set a new name, because no element on which this path referes is given.");
		this.getSElement().setName(newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SELEMENT_TYPE getElementType() 
	{
		SELEMENT_TYPE retVal= null;
		if (this.getSElement()!= null)
			retVal= this.getSElement().getType();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setElementType(SELEMENT_TYPE newElementType) 
	{
		if (this.getSElement()!= null)
			throw new NullPointerException(MSG_ERR + "Cannot set a new type, because no element on which this path referes is given.");
		this.getSElement().setType(newElementType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SELEMENT_PATH__SELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSElement((SIdentifiableElement)otherEnd, msgs);
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
			case SaltCorePackage.SELEMENT_PATH__SELEMENT:
				return basicSetSElement(null, msgs);
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
			case SaltCorePackage.SELEMENT_PATH__SELEMENT:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH, SIdentifiableElement.class, msgs);
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
			case SaltCorePackage.SELEMENT_PATH__PARENT_PATH:
				return getParentPath();
			case SaltCorePackage.SELEMENT_PATH__SELEMENT:
				return getSElement();
			case SaltCorePackage.SELEMENT_PATH__NAME:
				return getName();
			case SaltCorePackage.SELEMENT_PATH__ELEMENT_TYPE:
				return getElementType();
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
			case SaltCorePackage.SELEMENT_PATH__PARENT_PATH:
				setParentPath((String)newValue);
				return;
			case SaltCorePackage.SELEMENT_PATH__SELEMENT:
				setSElement((SIdentifiableElement)newValue);
				return;
			case SaltCorePackage.SELEMENT_PATH__NAME:
				setName((String)newValue);
				return;
			case SaltCorePackage.SELEMENT_PATH__ELEMENT_TYPE:
				setElementType((SELEMENT_TYPE)newValue);
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
			case SaltCorePackage.SELEMENT_PATH__PARENT_PATH:
				setParentPath(PARENT_PATH_EDEFAULT);
				return;
			case SaltCorePackage.SELEMENT_PATH__SELEMENT:
				setSElement((SIdentifiableElement)null);
				return;
			case SaltCorePackage.SELEMENT_PATH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SaltCorePackage.SELEMENT_PATH__ELEMENT_TYPE:
				setElementType(ELEMENT_TYPE_EDEFAULT);
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
			case SaltCorePackage.SELEMENT_PATH__PARENT_PATH:
				return PARENT_PATH_EDEFAULT == null ? parentPath != null : !PARENT_PATH_EDEFAULT.equals(parentPath);
			case SaltCorePackage.SELEMENT_PATH__SELEMENT:
				return getSElement() != null;
			case SaltCorePackage.SELEMENT_PATH__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case SaltCorePackage.SELEMENT_PATH__ELEMENT_TYPE:
				return getElementType() != ELEMENT_TYPE_EDEFAULT;
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
		result.append(" (parentPath: ");
		result.append(parentPath);
		result.append(')');
		return result.toString();
	}

} //SElementPathImpl
