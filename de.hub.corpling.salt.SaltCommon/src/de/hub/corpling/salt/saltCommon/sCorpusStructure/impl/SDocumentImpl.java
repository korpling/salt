/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCore.impl.SNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SDocument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDocumentImpl extends SNodeImpl implements SDocument {
	/**
	 * The cached value of the '{@link #getSDocumentGraph() <em>SDocument Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSDocumentGraph()
	 * @generated
	 * @ordered
	 */
	protected SDocumentGraph sDocumentGraph;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SCorpusStructurePackage.Literals.SDOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpusGraph getSCorpusGraph() 
	{
		SCorpusGraph retVal= null;
		if (super.getSGraph() instanceof SCorpusGraph)
			retVal= (SCorpusGraph) super.getSGraph();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSCorpusGraph(SCorpusGraph newSCorpusGraph) 
	{
		super.setSGraph(newSCorpusGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraph getSDocumentGraph() {
		if (sDocumentGraph != null && sDocumentGraph.eIsProxy()) {
			InternalEObject oldSDocumentGraph = (InternalEObject)sDocumentGraph;
			sDocumentGraph = (SDocumentGraph)eResolveProxy(oldSDocumentGraph);
			if (sDocumentGraph != oldSDocumentGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH, oldSDocumentGraph, sDocumentGraph));
			}
		}
		return sDocumentGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraph basicGetSDocumentGraph() {
		return sDocumentGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSDocumentGraph(SDocumentGraph newSDocumentGraph, NotificationChain msgs) {
		SDocumentGraph oldSDocumentGraph = sDocumentGraph;
		sDocumentGraph = newSDocumentGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH, oldSDocumentGraph, newSDocumentGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSDocumentGraph(SDocumentGraph newSDocumentGraph) {
		if (newSDocumentGraph != sDocumentGraph) {
			NotificationChain msgs = null;
			if (sDocumentGraph != null)
				msgs = ((InternalEObject)sDocumentGraph).eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT, SDocumentGraph.class, msgs);
			if (newSDocumentGraph != null)
				msgs = ((InternalEObject)newSDocumentGraph).eInverseAdd(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT, SDocumentGraph.class, msgs);
			msgs = basicSetSDocumentGraph(newSDocumentGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH, newSDocumentGraph, newSDocumentGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
				if (sDocumentGraph != null)
					msgs = ((InternalEObject)sDocumentGraph).eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT, SDocumentGraph.class, msgs);
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
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
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
			case SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH:
				return eInternalContainer().eInverseRemove(this, SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS, SCorpusGraph.class, msgs);
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
			case SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH:
				return getSCorpusGraph();
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
				if (resolve) return getSDocumentGraph();
				return basicGetSDocumentGraph();
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
			case SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH:
				setSCorpusGraph((SCorpusGraph)newValue);
				return;
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
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
			case SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH:
				setSCorpusGraph((SCorpusGraph)null);
				return;
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
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
			case SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH:
				return getSCorpusGraph() != null;
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
				return sDocumentGraph != null;
		}
		return super.eIsSet(featureID);
	}

} //SDocumentImpl
