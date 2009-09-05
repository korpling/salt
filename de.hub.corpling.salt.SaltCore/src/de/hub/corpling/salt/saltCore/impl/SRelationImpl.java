/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SNamedElement;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SRelation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSElementId <em>SElement Id</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSourceSNode <em>Source SNode</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getTargetSNode <em>Target SNode</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSGraph <em>SGraph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SRelationImpl extends SAnnotatableElementImpl implements SRelation {
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
	 * The cached value of the '{@link #getSElementId() <em>SElement Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSElementId()
	 * @generated
	 * @ordered
	 */
	protected SElementId sElementId;

	/**
	 * The cached value of the '{@link #getSourceSNode() <em>Source SNode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceSNode()
	 * @generated
	 * @ordered
	 */
	protected SNode sourceSNode;

	/**
	 * The cached value of the '{@link #getTargetSNode() <em>Target SNode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetSNode()
	 * @generated
	 * @ordered
	 */
	protected SNode targetSNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SRELATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SELEMENT_ID, oldSElementId, newSElementId);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SELEMENT_ID, newSElementId, newSElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNode getSourceSNode() {
		if (sourceSNode != null && sourceSNode.eIsProxy()) {
			InternalEObject oldSourceSNode = (InternalEObject)sourceSNode;
			sourceSNode = (SNode)eResolveProxy(oldSourceSNode);
			if (sourceSNode != oldSourceSNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SaltCorePackage.SRELATION__SOURCE_SNODE, oldSourceSNode, sourceSNode));
			}
		}
		return sourceSNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNode basicGetSourceSNode() {
		return sourceSNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceSNode(SNode newSourceSNode) {
		SNode oldSourceSNode = sourceSNode;
		sourceSNode = newSourceSNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SOURCE_SNODE, oldSourceSNode, sourceSNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNode getTargetSNode() {
		if (targetSNode != null && targetSNode.eIsProxy()) {
			InternalEObject oldTargetSNode = (InternalEObject)targetSNode;
			targetSNode = (SNode)eResolveProxy(oldTargetSNode);
			if (targetSNode != oldTargetSNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SaltCorePackage.SRELATION__TARGET_SNODE, oldTargetSNode, targetSNode));
			}
		}
		return targetSNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNode basicGetTargetSNode() {
		return targetSNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetSNode(SNode newTargetSNode) {
		SNode oldTargetSNode = targetSNode;
		targetSNode = newTargetSNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__TARGET_SNODE, oldTargetSNode, targetSNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SGraph getSGraph() {
		if (eContainerFeatureID() != SaltCorePackage.SRELATION__SGRAPH) return null;
		return (SGraph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSGraph(SGraph newSGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSGraph, SaltCorePackage.SRELATION__SGRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSGraph(SGraph newSGraph) {
		if (newSGraph != eInternalContainer() || (eContainerFeatureID() != SaltCorePackage.SRELATION__SGRAPH && newSGraph != null)) {
			if (EcoreUtil.isAncestor(this, newSGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSGraph != null)
				msgs = ((InternalEObject)newSGraph).eInverseAdd(this, SaltCorePackage.SGRAPH__SRELATIONS, SGraph.class, msgs);
			msgs = basicSetSGraph(newSGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SGRAPH, newSGraph, newSGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SRELATION__SELEMENT_ID:
				if (sElementId != null)
					msgs = ((InternalEObject)sElementId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SRELATION__SELEMENT_ID, null, msgs);
				return basicSetSElementId((SElementId)otherEnd, msgs);
			case SaltCorePackage.SRELATION__SGRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSGraph((SGraph)otherEnd, msgs);
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
			case SaltCorePackage.SRELATION__SELEMENT_ID:
				return basicSetSElementId(null, msgs);
			case SaltCorePackage.SRELATION__SGRAPH:
				return basicSetSGraph(null, msgs);
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
			case SaltCorePackage.SRELATION__SGRAPH:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SGRAPH__SRELATIONS, SGraph.class, msgs);
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
			case SaltCorePackage.SRELATION__NAME:
				return getName();
			case SaltCorePackage.SRELATION__SELEMENT_ID:
				return getSElementId();
			case SaltCorePackage.SRELATION__SOURCE_SNODE:
				if (resolve) return getSourceSNode();
				return basicGetSourceSNode();
			case SaltCorePackage.SRELATION__TARGET_SNODE:
				if (resolve) return getTargetSNode();
				return basicGetTargetSNode();
			case SaltCorePackage.SRELATION__SGRAPH:
				return getSGraph();
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
			case SaltCorePackage.SRELATION__NAME:
				setName((String)newValue);
				return;
			case SaltCorePackage.SRELATION__SELEMENT_ID:
				setSElementId((SElementId)newValue);
				return;
			case SaltCorePackage.SRELATION__SOURCE_SNODE:
				setSourceSNode((SNode)newValue);
				return;
			case SaltCorePackage.SRELATION__TARGET_SNODE:
				setTargetSNode((SNode)newValue);
				return;
			case SaltCorePackage.SRELATION__SGRAPH:
				setSGraph((SGraph)newValue);
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
			case SaltCorePackage.SRELATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SaltCorePackage.SRELATION__SELEMENT_ID:
				setSElementId((SElementId)null);
				return;
			case SaltCorePackage.SRELATION__SOURCE_SNODE:
				setSourceSNode((SNode)null);
				return;
			case SaltCorePackage.SRELATION__TARGET_SNODE:
				setTargetSNode((SNode)null);
				return;
			case SaltCorePackage.SRELATION__SGRAPH:
				setSGraph((SGraph)null);
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
			case SaltCorePackage.SRELATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SaltCorePackage.SRELATION__SELEMENT_ID:
				return sElementId != null;
			case SaltCorePackage.SRELATION__SOURCE_SNODE:
				return sourceSNode != null;
			case SaltCorePackage.SRELATION__TARGET_SNODE:
				return targetSNode != null;
			case SaltCorePackage.SRELATION__SGRAPH:
				return getSGraph() != null;
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
		if (baseClass == SNamedElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__NAME: return SaltCorePackage.SNAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SELEMENT_ID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID;
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
		if (baseClass == SNamedElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SNAMED_ELEMENT__NAME: return SaltCorePackage.SRELATION__NAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID: return SaltCorePackage.SRELATION__SELEMENT_ID;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SRelationImpl
