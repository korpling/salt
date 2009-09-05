/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;

import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SNamedElement;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SaltCorePackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STextual Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl#getSElementId <em>SElement Id</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl#getSGraph <em>SGraph</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl#getSTextualDS <em>STextual DS</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STextualRelationImpl extends SSequentialRelationImpl implements STextualRelation {
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
	 * The cached value of the '{@link #getSToken() <em>SToken</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSToken()
	 * @generated
	 * @ordered
	 */
	protected SToken sToken;

	/**
	 * The cached value of the '{@link #getSTextualDS() <em>STextual DS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTextualDS()
	 * @generated
	 * @ordered
	 */
	protected STextualDS sTextualDS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STextualRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.STEXTUAL_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SAnnotation> getSAnnotations() {
		if (sAnnotations == null) {
			sAnnotations = new EObjectContainmentWithInverseEList<SAnnotation>(SAnnotation.class, this, SDocumentStructurePackage.STEXTUAL_RELATION__SANNOTATIONS, SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT);
		}
		return sAnnotations;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_RELATION__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID, oldSElementId, newSElementId);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID, newSElementId, newSElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SGraph getSGraph() {
		if (eContainerFeatureID() != SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH) return null;
		return (SGraph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSGraph(SGraph newSGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSGraph, SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSGraph(SGraph newSGraph) {
		if (newSGraph != eInternalContainer() || (eContainerFeatureID() != SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH && newSGraph != null)) {
			if (EcoreUtil.isAncestor(this, newSGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSGraph != null)
				msgs = ((InternalEObject)newSGraph).eInverseAdd(this, SaltCorePackage.SGRAPH__SNODES, SGraph.class, msgs);
			msgs = basicSetSGraph(newSGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH, newSGraph, newSGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SToken getSToken() {
		if (sToken != null && sToken.eIsProxy()) {
			InternalEObject oldSToken = (InternalEObject)sToken;
			sToken = (SToken)eResolveProxy(oldSToken);
			if (sToken != oldSToken) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDocumentStructurePackage.STEXTUAL_RELATION__STOKEN, oldSToken, sToken));
			}
		}
		return sToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SToken basicGetSToken() {
		return sToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSToken(SToken newSToken) {
		SToken oldSToken = sToken;
		sToken = newSToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_RELATION__STOKEN, oldSToken, sToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextualDS getSTextualDS() {
		if (sTextualDS != null && sTextualDS.eIsProxy()) {
			InternalEObject oldSTextualDS = (InternalEObject)sTextualDS;
			sTextualDS = (STextualDS)eResolveProxy(oldSTextualDS);
			if (sTextualDS != oldSTextualDS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDocumentStructurePackage.STEXTUAL_RELATION__STEXTUAL_DS, oldSTextualDS, sTextualDS));
			}
		}
		return sTextualDS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextualDS basicGetSTextualDS() {
		return sTextualDS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSTextualDS(STextualDS newSTextualDS) {
		STextualDS oldSTextualDS = sTextualDS;
		sTextualDS = newSTextualDS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_RELATION__STEXTUAL_DS, oldSTextualDS, sTextualDS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraph getSDocumentGraph() {
		if (eContainerFeatureID() != SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH) return null;
		return (SDocumentGraph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSDocumentGraph(SDocumentGraph newSDocumentGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSDocumentGraph, SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSDocumentGraph(SDocumentGraph newSDocumentGraph) {
		if (newSDocumentGraph != eInternalContainer() || (eContainerFeatureID() != SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH && newSDocumentGraph != null)) {
			if (EcoreUtil.isAncestor(this, newSDocumentGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSDocumentGraph != null)
				msgs = ((InternalEObject)newSDocumentGraph).eInverseAdd(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS, SDocumentGraph.class, msgs);
			msgs = basicSetSDocumentGraph(newSDocumentGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH, newSDocumentGraph, newSDocumentGraph));
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__SANNOTATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSAnnotations()).basicAdd(otherEnd, msgs);
			case SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID:
				if (sElementId != null)
					msgs = ((InternalEObject)sElementId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID, null, msgs);
				return basicSetSElementId((SElementId)otherEnd, msgs);
			case SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSGraph((SGraph)otherEnd, msgs);
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSDocumentGraph((SDocumentGraph)otherEnd, msgs);
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID:
				return basicSetSElementId(null, msgs);
			case SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH:
				return basicSetSGraph(null, msgs);
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				return basicSetSDocumentGraph(null, msgs);
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SGRAPH__SNODES, SGraph.class, msgs);
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS, SDocumentGraph.class, msgs);
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__SANNOTATIONS:
				return getSAnnotations();
			case SDocumentStructurePackage.STEXTUAL_RELATION__NAME:
				return getName();
			case SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID:
				return getSElementId();
			case SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH:
				return getSGraph();
			case SDocumentStructurePackage.STEXTUAL_RELATION__STOKEN:
				if (resolve) return getSToken();
				return basicGetSToken();
			case SDocumentStructurePackage.STEXTUAL_RELATION__STEXTUAL_DS:
				if (resolve) return getSTextualDS();
				return basicGetSTextualDS();
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph();
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__NAME:
				setName((String)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID:
				setSElementId((SElementId)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH:
				setSGraph((SGraph)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__STOKEN:
				setSToken((SToken)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__STEXTUAL_DS:
				setSTextualDS((STextualDS)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)newValue);
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID:
				setSElementId((SElementId)null);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH:
				setSGraph((SGraph)null);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__STOKEN:
				setSToken((SToken)null);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__STEXTUAL_DS:
				setSTextualDS((STextualDS)null);
				return;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)null);
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
			case SDocumentStructurePackage.STEXTUAL_RELATION__SANNOTATIONS:
				return sAnnotations != null && !sAnnotations.isEmpty();
			case SDocumentStructurePackage.STEXTUAL_RELATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID:
				return sElementId != null;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH:
				return getSGraph() != null;
			case SDocumentStructurePackage.STEXTUAL_RELATION__STOKEN:
				return sToken != null;
			case SDocumentStructurePackage.STEXTUAL_RELATION__STEXTUAL_DS:
				return sTextualDS != null;
			case SDocumentStructurePackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
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
				case SDocumentStructurePackage.STEXTUAL_RELATION__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (derivedFeatureID) {
				case SDocumentStructurePackage.STEXTUAL_RELATION__NAME: return SaltCorePackage.SNAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID;
				default: return -1;
			}
		}
		if (baseClass == SNode.class) {
			switch (derivedFeatureID) {
				case SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH: return SaltCorePackage.SNODE__SGRAPH;
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
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SDocumentStructurePackage.STEXTUAL_RELATION__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SNAMED_ELEMENT__NAME: return SDocumentStructurePackage.STEXTUAL_RELATION__NAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID: return SDocumentStructurePackage.STEXTUAL_RELATION__SELEMENT_ID;
				default: return -1;
			}
		}
		if (baseClass == SNode.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SNODE__SGRAPH: return SDocumentStructurePackage.STEXTUAL_RELATION__SGRAPH;
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

} //STextualRelationImpl
