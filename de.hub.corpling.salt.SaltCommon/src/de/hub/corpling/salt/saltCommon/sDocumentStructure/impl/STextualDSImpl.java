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
 * An implementation of the model object '<em><b>STextual DS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl#getSElementId <em>SElement Id</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl#getSGraph <em>SGraph</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl#getSText <em>SText</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STextualDSImpl extends SSequentialDSImpl implements STextualDS {
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
	 * The default value of the '{@link #getSText() <em>SText</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSText()
	 * @generated
	 * @ordered
	 */
	protected static final String STEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSText() <em>SText</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSText()
	 * @generated
	 * @ordered
	 */
	protected String sText = STEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STextualDSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.STEXTUAL_DS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SAnnotation> getSAnnotations() {
		if (sAnnotations == null) {
			sAnnotations = new EObjectContainmentWithInverseEList<SAnnotation>(SAnnotation.class, this, SDocumentStructurePackage.STEXTUAL_DS__SANNOTATIONS, SaltCorePackage.SANNOTATION__SANNOTATBALE_ELEMENT);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_DS__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID, oldSElementId, newSElementId);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID, newSElementId, newSElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SGraph getSGraph() {
		if (eContainerFeatureID() != SDocumentStructurePackage.STEXTUAL_DS__SGRAPH) return null;
		return (SGraph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSGraph(SGraph newSGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSGraph, SDocumentStructurePackage.STEXTUAL_DS__SGRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSGraph(SGraph newSGraph) {
		if (newSGraph != eInternalContainer() || (eContainerFeatureID() != SDocumentStructurePackage.STEXTUAL_DS__SGRAPH && newSGraph != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_DS__SGRAPH, newSGraph, newSGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSText() {
		return sText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSText(String newSText) {
		String oldSText = sText;
		sText = newSText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_DS__STEXT, oldSText, sText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraph getSDocumentGraph() {
		if (eContainerFeatureID() != SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH) return null;
		return (SDocumentGraph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSDocumentGraph(SDocumentGraph newSDocumentGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSDocumentGraph, SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSDocumentGraph(SDocumentGraph newSDocumentGraph) {
		if (newSDocumentGraph != eInternalContainer() || (eContainerFeatureID() != SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH && newSDocumentGraph != null)) {
			if (EcoreUtil.isAncestor(this, newSDocumentGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSDocumentGraph != null)
				msgs = ((InternalEObject)newSDocumentGraph).eInverseAdd(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_DSS, SDocumentGraph.class, msgs);
			msgs = basicSetSDocumentGraph(newSDocumentGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH, newSDocumentGraph, newSDocumentGraph));
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
			case SDocumentStructurePackage.STEXTUAL_DS__SANNOTATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSAnnotations()).basicAdd(otherEnd, msgs);
			case SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID:
				if (sElementId != null)
					msgs = ((InternalEObject)sElementId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID, null, msgs);
				return basicSetSElementId((SElementId)otherEnd, msgs);
			case SDocumentStructurePackage.STEXTUAL_DS__SGRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSGraph((SGraph)otherEnd, msgs);
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_DS__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID:
				return basicSetSElementId(null, msgs);
			case SDocumentStructurePackage.STEXTUAL_DS__SGRAPH:
				return basicSetSGraph(null, msgs);
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_DS__SGRAPH:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SGRAPH__SNODES, SGraph.class, msgs);
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_DSS, SDocumentGraph.class, msgs);
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
			case SDocumentStructurePackage.STEXTUAL_DS__SANNOTATIONS:
				return getSAnnotations();
			case SDocumentStructurePackage.STEXTUAL_DS__NAME:
				return getName();
			case SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID:
				return getSElementId();
			case SDocumentStructurePackage.STEXTUAL_DS__SGRAPH:
				return getSGraph();
			case SDocumentStructurePackage.STEXTUAL_DS__STEXT:
				return getSText();
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_DS__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__NAME:
				setName((String)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID:
				setSElementId((SElementId)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__SGRAPH:
				setSGraph((SGraph)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__STEXT:
				setSText((String)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_DS__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID:
				setSElementId((SElementId)null);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__SGRAPH:
				setSGraph((SGraph)null);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__STEXT:
				setSText(STEXT_EDEFAULT);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_DS__SANNOTATIONS:
				return sAnnotations != null && !sAnnotations.isEmpty();
			case SDocumentStructurePackage.STEXTUAL_DS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID:
				return sElementId != null;
			case SDocumentStructurePackage.STEXTUAL_DS__SGRAPH:
				return getSGraph() != null;
			case SDocumentStructurePackage.STEXTUAL_DS__STEXT:
				return STEXT_EDEFAULT == null ? sText != null : !STEXT_EDEFAULT.equals(sText);
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
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
				case SDocumentStructurePackage.STEXTUAL_DS__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (derivedFeatureID) {
				case SDocumentStructurePackage.STEXTUAL_DS__NAME: return SaltCorePackage.SNAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID;
				default: return -1;
			}
		}
		if (baseClass == SNode.class) {
			switch (derivedFeatureID) {
				case SDocumentStructurePackage.STEXTUAL_DS__SGRAPH: return SaltCorePackage.SNODE__SGRAPH;
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
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SDocumentStructurePackage.STEXTUAL_DS__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SNAMED_ELEMENT__NAME: return SDocumentStructurePackage.STEXTUAL_DS__NAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID: return SDocumentStructurePackage.STEXTUAL_DS__SELEMENT_ID;
				default: return -1;
			}
		}
		if (baseClass == SNode.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SNODE__SGRAPH: return SDocumentStructurePackage.STEXTUAL_DS__SGRAPH;
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
		result.append(", sText: ");
		result.append(sText);
		result.append(')');
		return result.toString();
	}

} //STextualDSImpl
