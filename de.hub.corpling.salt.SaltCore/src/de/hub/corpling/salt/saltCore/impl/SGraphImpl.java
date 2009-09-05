/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SGraph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SGraphImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SGraphImpl#getSElementId <em>SElement Id</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SGraphImpl#getSRelations <em>SRelations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SGraphImpl#getSNodes <em>SNodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SGraphImpl extends SNamedElementImpl implements SGraph {
	/**
	 * The cached value of the '{@link #getSAnnotations() <em>SAnnotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<SAnnotation> sAnnotations;

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
	 * The cached value of the '{@link #getSRelations() <em>SRelations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<SRelation> sRelations;

	/**
	 * The cached value of the '{@link #getSNodes() <em>SNodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<SNode> sNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SGRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SAnnotation> getSAnnotations() {
		if (sAnnotations == null) {
			sAnnotations = new EObjectContainmentWithInverseEList<SAnnotation>(SAnnotation.class, this, SaltCorePackage.SGRAPH__SANNOTATIONS, SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT);
		}
		return sAnnotations;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SGRAPH__SELEMENT_ID, oldSElementId, newSElementId);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SGRAPH__SELEMENT_ID, newSElementId, newSElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SRelation> getSRelations() {
		if (sRelations == null) {
			sRelations = new EObjectContainmentWithInverseEList<SRelation>(SRelation.class, this, SaltCorePackage.SGRAPH__SRELATIONS, SaltCorePackage.SRELATION__SGRAPH);
		}
		return sRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SNode> getSNodes() {
		if (sNodes == null) {
			sNodes = new EObjectContainmentWithInverseEList<SNode>(SNode.class, this, SaltCorePackage.SGRAPH__SNODES, SaltCorePackage.SNODE__SGRAPH);
		}
		return sNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSAnnotations()).basicAdd(otherEnd, msgs);
			case SaltCorePackage.SGRAPH__SELEMENT_ID:
				if (sElementId != null)
					msgs = ((InternalEObject)sElementId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SGRAPH__SELEMENT_ID, null, msgs);
				return basicSetSElementId((SElementId)otherEnd, msgs);
			case SaltCorePackage.SGRAPH__SRELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSRelations()).basicAdd(otherEnd, msgs);
			case SaltCorePackage.SGRAPH__SNODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSNodes()).basicAdd(otherEnd, msgs);
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
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SGRAPH__SELEMENT_ID:
				return basicSetSElementId(null, msgs);
			case SaltCorePackage.SGRAPH__SRELATIONS:
				return ((InternalEList<?>)getSRelations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SGRAPH__SNODES:
				return ((InternalEList<?>)getSNodes()).basicRemove(otherEnd, msgs);
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
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				return getSAnnotations();
			case SaltCorePackage.SGRAPH__SELEMENT_ID:
				return getSElementId();
			case SaltCorePackage.SGRAPH__SRELATIONS:
				return getSRelations();
			case SaltCorePackage.SGRAPH__SNODES:
				return getSNodes();
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
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SaltCorePackage.SGRAPH__SELEMENT_ID:
				setSElementId((SElementId)newValue);
				return;
			case SaltCorePackage.SGRAPH__SRELATIONS:
				getSRelations().clear();
				getSRelations().addAll((Collection<? extends SRelation>)newValue);
				return;
			case SaltCorePackage.SGRAPH__SNODES:
				getSNodes().clear();
				getSNodes().addAll((Collection<? extends SNode>)newValue);
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
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SaltCorePackage.SGRAPH__SELEMENT_ID:
				setSElementId((SElementId)null);
				return;
			case SaltCorePackage.SGRAPH__SRELATIONS:
				getSRelations().clear();
				return;
			case SaltCorePackage.SGRAPH__SNODES:
				getSNodes().clear();
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
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				return sAnnotations != null && !sAnnotations.isEmpty();
			case SaltCorePackage.SGRAPH__SELEMENT_ID:
				return sElementId != null;
			case SaltCorePackage.SGRAPH__SRELATIONS:
				return sRelations != null && !sRelations.isEmpty();
			case SaltCorePackage.SGRAPH__SNODES:
				return sNodes != null && !sNodes.isEmpty();
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
		if (baseClass == SAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SGRAPH__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SGRAPH__SELEMENT_ID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID;
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
		if (baseClass == SAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SaltCorePackage.SGRAPH__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID: return SaltCorePackage.SGRAPH__SELEMENT_ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SGraphImpl
