/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;


import de.corpling.salt.model.saltCore.SFeatureDescription;
import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.SStereotypeContainer;
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
 * An implementation of the model object '<em><b>SStereotype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SStereotypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SStereotypeImpl#getSFeatureDescriptions <em>SFeature Descriptions</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SStereotypeImpl#getSSuperStereotype <em>SSuper Stereotype</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SStereotypeImpl#getSProject <em>SProject</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SStereotypeImpl extends EObjectImpl implements SStereotype {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSFeatureDescriptions() <em>SFeature Descriptions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSFeatureDescriptions()
	 * @generated
	 * @ordered
	 */
	protected SFeatureDescription sFeatureDescriptions;

	/**
	 * The cached value of the '{@link #getSSuperStereotype() <em>SSuper Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSuperStereotype()
	 * @generated
	 * @ordered
	 */
	protected SStereotype sSuperStereotype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SStereotypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SSTEREOTYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SSTEREOTYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SFeatureDescription getSFeatureDescriptions() {
		return sFeatureDescriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSFeatureDescriptions(SFeatureDescription newSFeatureDescriptions, NotificationChain msgs) {
		SFeatureDescription oldSFeatureDescriptions = sFeatureDescriptions;
		sFeatureDescriptions = newSFeatureDescriptions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SSTEREOTYPE__SFEATURE_DESCRIPTIONS, oldSFeatureDescriptions, newSFeatureDescriptions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSFeatureDescriptions(SFeatureDescription newSFeatureDescriptions) {
		if (newSFeatureDescriptions != sFeatureDescriptions) {
			NotificationChain msgs = null;
			if (sFeatureDescriptions != null)
				msgs = ((InternalEObject)sFeatureDescriptions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SSTEREOTYPE__SFEATURE_DESCRIPTIONS, null, msgs);
			if (newSFeatureDescriptions != null)
				msgs = ((InternalEObject)newSFeatureDescriptions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SSTEREOTYPE__SFEATURE_DESCRIPTIONS, null, msgs);
			msgs = basicSetSFeatureDescriptions(newSFeatureDescriptions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SSTEREOTYPE__SFEATURE_DESCRIPTIONS, newSFeatureDescriptions, newSFeatureDescriptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotype getSSuperStereotype() {
		if (sSuperStereotype != null && sSuperStereotype.eIsProxy()) {
			InternalEObject oldSSuperStereotype = (InternalEObject)sSuperStereotype;
			sSuperStereotype = (SStereotype)eResolveProxy(oldSSuperStereotype);
			if (sSuperStereotype != oldSSuperStereotype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SaltCorePackage.SSTEREOTYPE__SSUPER_STEREOTYPE, oldSSuperStereotype, sSuperStereotype));
			}
		}
		return sSuperStereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotype basicGetSSuperStereotype() {
		return sSuperStereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSuperStereotype(SStereotype newSSuperStereotype) {
		SStereotype oldSSuperStereotype = sSuperStereotype;
		sSuperStereotype = newSSuperStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SSTEREOTYPE__SSUPER_STEREOTYPE, oldSSuperStereotype, sSuperStereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotypeContainer getSProject() {
		if (eContainerFeatureID != SaltCorePackage.SSTEREOTYPE__SPROJECT) return null;
		return (SStereotypeContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSProject(SStereotypeContainer newSProject, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSProject, SaltCorePackage.SSTEREOTYPE__SPROJECT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSProject(SStereotypeContainer newSProject) {
		if (newSProject != eInternalContainer() || (eContainerFeatureID != SaltCorePackage.SSTEREOTYPE__SPROJECT && newSProject != null)) {
			if (EcoreUtil.isAncestor(this, newSProject))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSProject != null)
				msgs = ((InternalEObject)newSProject).eInverseAdd(this, SaltCorePackage.SSTEREOTYPE_CONTAINER__SSTEREOTYPES, SStereotypeContainer.class, msgs);
			msgs = basicSetSProject(newSProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SSTEREOTYPE__SPROJECT, newSProject, newSProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SSTEREOTYPE__SPROJECT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSProject((SStereotypeContainer)otherEnd, msgs);
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
			case SaltCorePackage.SSTEREOTYPE__SFEATURE_DESCRIPTIONS:
				return basicSetSFeatureDescriptions(null, msgs);
			case SaltCorePackage.SSTEREOTYPE__SPROJECT:
				return basicSetSProject(null, msgs);
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
			case SaltCorePackage.SSTEREOTYPE__SPROJECT:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SSTEREOTYPE_CONTAINER__SSTEREOTYPES, SStereotypeContainer.class, msgs);
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
			case SaltCorePackage.SSTEREOTYPE__NAME:
				return getName();
			case SaltCorePackage.SSTEREOTYPE__SFEATURE_DESCRIPTIONS:
				return getSFeatureDescriptions();
			case SaltCorePackage.SSTEREOTYPE__SSUPER_STEREOTYPE:
				if (resolve) return getSSuperStereotype();
				return basicGetSSuperStereotype();
			case SaltCorePackage.SSTEREOTYPE__SPROJECT:
				return getSProject();
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
			case SaltCorePackage.SSTEREOTYPE__NAME:
				setName((String)newValue);
				return;
			case SaltCorePackage.SSTEREOTYPE__SFEATURE_DESCRIPTIONS:
				setSFeatureDescriptions((SFeatureDescription)newValue);
				return;
			case SaltCorePackage.SSTEREOTYPE__SSUPER_STEREOTYPE:
				setSSuperStereotype((SStereotype)newValue);
				return;
			case SaltCorePackage.SSTEREOTYPE__SPROJECT:
				setSProject((SStereotypeContainer)newValue);
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
			case SaltCorePackage.SSTEREOTYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SaltCorePackage.SSTEREOTYPE__SFEATURE_DESCRIPTIONS:
				setSFeatureDescriptions((SFeatureDescription)null);
				return;
			case SaltCorePackage.SSTEREOTYPE__SSUPER_STEREOTYPE:
				setSSuperStereotype((SStereotype)null);
				return;
			case SaltCorePackage.SSTEREOTYPE__SPROJECT:
				setSProject((SStereotypeContainer)null);
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
			case SaltCorePackage.SSTEREOTYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SaltCorePackage.SSTEREOTYPE__SFEATURE_DESCRIPTIONS:
				return sFeatureDescriptions != null;
			case SaltCorePackage.SSTEREOTYPE__SSUPER_STEREOTYPE:
				return sSuperStereotype != null;
			case SaltCorePackage.SSTEREOTYPE__SPROJECT:
				return getSProject() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SStereotypeImpl
