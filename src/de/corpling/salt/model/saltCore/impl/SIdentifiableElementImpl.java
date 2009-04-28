/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.util.graph.GraphPackage;
import de.util.graph.IdentifiableElement;
import de.corpling.salt.model.saltCore.SELEMENT_TYPE;
import de.corpling.salt.model.saltCore.SElementPath;
import de.corpling.salt.model.saltCore.SIdentifiableElement;
import de.corpling.salt.model.saltCore.STypedElement;
import de.corpling.salt.model.saltCore.SaltCorePackage;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SIdentifiable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SIdentifiableElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SIdentifiableElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SIdentifiableElementImpl#getSElementPath <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SIdentifiableElementImpl extends SNamedElementImpl implements SIdentifiableElement 
{
	private static final String MSG_ERR=	"Error("+SIdentifiableElementImpl.class+"): ";
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final SELEMENT_TYPE TYPE_EDEFAULT = SELEMENT_TYPE.CORPUS;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SELEMENT_TYPE type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Object ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Object id = ID_EDEFAULT;
	/**
	 * The cached value of the '{@link #getSElementPath() <em>SElement Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSElementPath()
	 * @generated
	 * @ordered
	 */
	protected SElementPath sElementPath;

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
	public SElementPath getSElementPath() {
		return sElementPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSElementPath(SElementPath newSElementPath, NotificationChain msgs) {
		SElementPath oldSElementPath = sElementPath;
		sElementPath = newSElementPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH, oldSElementPath, newSElementPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSElementPath(SElementPath newSElementPath) 
	{
		if (newSElementPath== null)
			throw new NullPointerException(MSG_ERR + "Cannot set an empty element path object.");
		if (newSElementPath != sElementPath) {
			NotificationChain msgs = null;
			if (sElementPath != null)
				msgs = ((InternalEObject)sElementPath).eInverseRemove(this, SaltCorePackage.SELEMENT_PATH__SELEMENT, SElementPath.class, msgs);
			if (newSElementPath != null)
				msgs = ((InternalEObject)newSElementPath).eInverseAdd(this, SaltCorePackage.SELEMENT_PATH__SELEMENT, SElementPath.class, msgs);
			msgs = basicSetSElementPath(newSElementPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH, newSElementPath, newSElementPath));
	}

// ---------------------------------Start: overriding id handling
	/**
	 * Delegation to getSElementPath()
	 */
	public Object getId_old() 
	{
		return(this.getSElementPath());
	}

	/**
	 * Delegation to setSElementPath()
	 */
	public void setId_old(Object newId) 
	{
		if (!SElementPath.class.isInstance(newId))
			throw new ClassCastException(MSG_ERR + "Cannot cast given id to "+SElementPath.class+", only id of this type can bes set.");
		this.setSElementPath((SElementPath)newId);
	}
// ---------------------------------End: overriding id handling

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SELEMENT_TYPE getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SELEMENT_TYPE newType) {
		SELEMENT_TYPE oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SIDENTIFIABLE_ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Object newId) {
		Object oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SIDENTIFIABLE_ELEMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH:
				if (sElementPath != null)
					msgs = ((InternalEObject)sElementPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH, null, msgs);
				return basicSetSElementPath((SElementPath)otherEnd, msgs);
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH:
				return basicSetSElementPath(null, msgs);
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__TYPE:
				return getType();
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__ID:
				return getId();
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH:
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__TYPE:
				setType((SELEMENT_TYPE)newValue);
				return;
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__ID:
				setId(newValue);
				return;
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH:
				setSElementPath((SElementPath)newValue);
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH:
				setSElementPath((SElementPath)null);
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__TYPE:
				return type != TYPE_EDEFAULT;
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH:
				return sElementPath != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == STypedElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__TYPE: return SaltCorePackage.STYPED_ELEMENT__TYPE;
				default: return -1;
			}
		}
		if (baseClass == IdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__ID: return GraphPackage.IDENTIFIABLE_ELEMENT__ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == STypedElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.STYPED_ELEMENT__TYPE: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__TYPE;
				default: return -1;
			}
		}
		if (baseClass == IdentifiableElement.class) {
			switch (baseFeatureID) {
				case GraphPackage.IDENTIFIABLE_ELEMENT__ID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //SIdentifiableElementImpl
