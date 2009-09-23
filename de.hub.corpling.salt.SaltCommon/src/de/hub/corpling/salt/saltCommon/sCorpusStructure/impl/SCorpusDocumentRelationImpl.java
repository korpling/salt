/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCore.impl.SRelationImpl;

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
		SCorpus sCorpus = basicGetSCorpus();
		return sCorpus != null && sCorpus.eIsProxy() ? (SCorpus)eResolveProxy((InternalEObject)sCorpus) : sCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpus basicGetSCorpus() 
	{
		SCorpus retVal= null;
		if (super.getSSource() instanceof SCorpus)
			retVal= (SCorpus) super.getSource();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSCorpus(SCorpus newSCorpus) 
	{
		super.setSSource(newSCorpus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocument getSDocument() {
		SDocument sDocument = basicGetSDocument();
		return sDocument != null && sDocument.eIsProxy() ? (SDocument)eResolveProxy((InternalEObject)sDocument) : sDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocument basicGetSDocument() 
	{
		SDocument retVal= null;
		if (super.getSTarget() instanceof SDocument)
			retVal= (SDocument) super.getTarget();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSDocument(SDocument newSDocument) 
	{
		super.setSTarget(newSDocument);
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
				return basicGetSCorpus() != null;
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SDOCUMENT:
				return basicGetSDocument() != null;
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH:
				return getSCorpusGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SCorpusDocumentRelationImpl
