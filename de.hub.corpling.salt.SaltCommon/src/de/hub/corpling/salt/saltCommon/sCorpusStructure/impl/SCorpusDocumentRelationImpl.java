/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.impl;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;

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
 * An implementation of the model object '<em><b>SCorpus Document Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl#getSCorpus <em>SCorpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl#getSDocument <em>SDocument</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCorpusDocumentRelationImpl extends SRelationImpl implements SCorpusDocumentRelation {
	/**
	 * The cached value of the '{@link #getSCorpus() <em>SCorpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSCorpus()
	 * @generated
	 * @ordered
	 */
	protected SCorpus sCorpus;

	/**
	 * The cached value of the '{@link #getSDocument() <em>SDocument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSDocument()
	 * @generated
	 * @ordered
	 */
	protected SDocument sDocument;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusDocumentRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SCorpusStructurePackage.Literals.SCORPUS_DOCUMENT_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpus getSCorpus() {
		if (sCorpus != null && sCorpus.eIsProxy()) {
			InternalEObject oldSCorpus = (InternalEObject)sCorpus;
			sCorpus = (SCorpus)eResolveProxy(oldSCorpus);
			if (sCorpus != oldSCorpus) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS, oldSCorpus, sCorpus));
			}
		}
		return sCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpus basicGetSCorpus() {
		return sCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSCorpus(SCorpus newSCorpus) {
		SCorpus oldSCorpus = sCorpus;
		sCorpus = newSCorpus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS, oldSCorpus, sCorpus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocument getSDocument() {
		if (sDocument != null && sDocument.eIsProxy()) {
			InternalEObject oldSDocument = (InternalEObject)sDocument;
			sDocument = (SDocument)eResolveProxy(oldSDocument);
			if (sDocument != oldSDocument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SDOCUMENT, oldSDocument, sDocument));
			}
		}
		return sDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocument basicGetSDocument() {
		return sDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSDocument(SDocument newSDocument) {
		SDocument oldSDocument = sDocument;
		sDocument = newSDocument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SDOCUMENT, oldSDocument, sDocument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusGraph getSCorpusGraph() {
		if (eContainerFeatureID() != SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH) return null;
		return (SCorpusGraph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSCorpusGraph(SCorpusGraph newSCorpusGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSCorpusGraph, SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSCorpusGraph(SCorpusGraph newSCorpusGraph) {
		if (newSCorpusGraph != eInternalContainer() || (eContainerFeatureID() != SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH && newSCorpusGraph != null)) {
			if (EcoreUtil.isAncestor(this, newSCorpusGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSCorpusGraph != null)
				msgs = ((InternalEObject)newSCorpusGraph).eInverseAdd(this, SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS, SCorpusGraph.class, msgs);
			msgs = basicSetSCorpusGraph(newSCorpusGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH, newSCorpusGraph, newSCorpusGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH:
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
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH:
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
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH:
				return eInternalContainer().eInverseRemove(this, SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS, SCorpusGraph.class, msgs);
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
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS:
				if (resolve) return getSCorpus();
				return basicGetSCorpus();
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SDOCUMENT:
				if (resolve) return getSDocument();
				return basicGetSDocument();
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH:
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
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS:
				setSCorpus((SCorpus)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SDOCUMENT:
				setSDocument((SDocument)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH:
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
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS:
				setSCorpus((SCorpus)null);
				return;
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SDOCUMENT:
				setSDocument((SDocument)null);
				return;
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH:
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
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS:
				return sCorpus != null;
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SDOCUMENT:
				return sDocument != null;
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH:
				return getSCorpusGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SCorpusDocumentRelationImpl
