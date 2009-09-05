/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.impl;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;

import de.hub.corpling.salt.saltCore.impl.SRelationImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCorpus Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl#getSSuperCorpus <em>SSuper Corpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl#getSSubCorpus <em>SSub Corpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCorpusRelationImpl extends SRelationImpl implements SCorpusRelation {
	/**
	 * The cached value of the '{@link #getSSuperCorpus() <em>SSuper Corpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSuperCorpus()
	 * @generated
	 * @ordered
	 */
	protected SCorpus sSuperCorpus;

	/**
	 * The cached value of the '{@link #getSSubCorpus() <em>SSub Corpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSubCorpus()
	 * @generated
	 * @ordered
	 */
	protected SCorpus sSubCorpus;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SCorpusStructurePackage.Literals.SCORPUS_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpus getSSuperCorpus() {
		if (sSuperCorpus != null && sSuperCorpus.eIsProxy()) {
			InternalEObject oldSSuperCorpus = (InternalEObject)sSuperCorpus;
			sSuperCorpus = (SCorpus)eResolveProxy(oldSSuperCorpus);
			if (sSuperCorpus != oldSSuperCorpus) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SCorpusStructurePackage.SCORPUS_RELATION__SSUPER_CORPUS, oldSSuperCorpus, sSuperCorpus));
			}
		}
		return sSuperCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpus basicGetSSuperCorpus() {
		return sSuperCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSuperCorpus(SCorpus newSSuperCorpus) {
		SCorpus oldSSuperCorpus = sSuperCorpus;
		sSuperCorpus = newSSuperCorpus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SCORPUS_RELATION__SSUPER_CORPUS, oldSSuperCorpus, sSuperCorpus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpus getSSubCorpus() {
		if (sSubCorpus != null && sSubCorpus.eIsProxy()) {
			InternalEObject oldSSubCorpus = (InternalEObject)sSubCorpus;
			sSubCorpus = (SCorpus)eResolveProxy(oldSSubCorpus);
			if (sSubCorpus != oldSSubCorpus) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SCorpusStructurePackage.SCORPUS_RELATION__SSUB_CORPUS, oldSSubCorpus, sSubCorpus));
			}
		}
		return sSubCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpus basicGetSSubCorpus() {
		return sSubCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSubCorpus(SCorpus newSSubCorpus) {
		SCorpus oldSSubCorpus = sSubCorpus;
		sSubCorpus = newSSubCorpus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SCORPUS_RELATION__SSUB_CORPUS, oldSSubCorpus, sSubCorpus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusGraph getSCorpusGraph() {
		if (eContainerFeatureID() != SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH) return null;
		return (SCorpusGraph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSCorpusGraph(SCorpusGraph newSCorpusGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSCorpusGraph, SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSCorpusGraph(SCorpusGraph newSCorpusGraph) {
		if (newSCorpusGraph != eInternalContainer() || (eContainerFeatureID() != SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH && newSCorpusGraph != null)) {
			if (EcoreUtil.isAncestor(this, newSCorpusGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSCorpusGraph != null)
				msgs = ((InternalEObject)newSCorpusGraph).eInverseAdd(this, SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS, SCorpusGraph.class, msgs);
			msgs = basicSetSCorpusGraph(newSCorpusGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH, newSCorpusGraph, newSCorpusGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSCorpusGraph((SCorpusGraph)otherEnd, msgs);
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
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				return basicSetSCorpusGraph(null, msgs);
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
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				return eInternalContainer().eInverseRemove(this, SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS, SCorpusGraph.class, msgs);
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
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUPER_CORPUS:
				if (resolve) return getSSuperCorpus();
				return basicGetSSuperCorpus();
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUB_CORPUS:
				if (resolve) return getSSubCorpus();
				return basicGetSSubCorpus();
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				return getSCorpusGraph();
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
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUPER_CORPUS:
				setSSuperCorpus((SCorpus)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUB_CORPUS:
				setSSubCorpus((SCorpus)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				setSCorpusGraph((SCorpusGraph)newValue);
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
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUPER_CORPUS:
				setSSuperCorpus((SCorpus)null);
				return;
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUB_CORPUS:
				setSSubCorpus((SCorpus)null);
				return;
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				setSCorpusGraph((SCorpusGraph)null);
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
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUPER_CORPUS:
				return sSuperCorpus != null;
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUB_CORPUS:
				return sSubCorpus != null;
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				return getSCorpusGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SCorpusRelationImpl
