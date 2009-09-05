/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.impl;

import de.hub.corpling.salt.saltCommon.SaltCommonPackage;
import de.hub.corpling.salt.saltCommon.SaltProject;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;

import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.impl.SGraphImpl;

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
 * An implementation of the model object '<em><b>SCorpus Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSDocuments <em>SDocuments</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSaltProject <em>Salt Project</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSCorpora <em>SCorpora</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSCorpusRelations <em>SCorpus Relations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSCorpusDocumentRelations <em>SCorpus Document Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCorpusGraphImpl extends SGraphImpl implements SCorpusGraph {
	/**
	 * The cached value of the '{@link #getSDocuments() <em>SDocuments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSDocuments()
	 * @generated
	 * @ordered
	 */
	protected EList<SDocument> sDocuments;

	/**
	 * The cached value of the '{@link #getSCorpora() <em>SCorpora</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSCorpora()
	 * @generated
	 * @ordered
	 */
	protected EList<SCorpus> sCorpora;
	/**
	 * The cached value of the '{@link #getSCorpusRelations() <em>SCorpus Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSCorpusRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<SCorpusRelation> sCorpusRelations;
	/**
	 * The cached value of the '{@link #getSCorpusDocumentRelations() <em>SCorpus Document Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSCorpusDocumentRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<SCorpusDocumentRelation> sCorpusDocumentRelations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SCorpusStructurePackage.Literals.SCORPUS_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SDocument> getSDocuments() {
		if (sDocuments == null) {
			sDocuments = new EObjectContainmentWithInverseEList<SDocument>(SDocument.class, this, SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS, SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH);
		}
		return sDocuments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltProject getSaltProject() {
		if (eContainerFeatureID() != SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT) return null;
		return (SaltProject)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSaltProject(SaltProject newSaltProject, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSaltProject, SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSaltProject(SaltProject newSaltProject) {
		if (newSaltProject != eInternalContainer() || (eContainerFeatureID() != SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT && newSaltProject != null)) {
			if (EcoreUtil.isAncestor(this, newSaltProject))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSaltProject != null)
				msgs = ((InternalEObject)newSaltProject).eInverseAdd(this, SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS, SaltProject.class, msgs);
			msgs = basicSetSaltProject(newSaltProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT, newSaltProject, newSaltProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SCorpus> getSCorpora() {
		if (sCorpora == null) {
			sCorpora = new EObjectContainmentWithInverseEList<SCorpus>(SCorpus.class, this, SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA, SCorpusStructurePackage.SCORPUS__SCORPUS_GRAPH);
		}
		return sCorpora;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SCorpusRelation> getSCorpusRelations() {
		if (sCorpusRelations == null) {
			sCorpusRelations = new EObjectContainmentWithInverseEList<SCorpusRelation>(SCorpusRelation.class, this, SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS, SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH);
		}
		return sCorpusRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SCorpusDocumentRelation> getSCorpusDocumentRelations() {
		if (sCorpusDocumentRelations == null) {
			sCorpusDocumentRelations = new EObjectContainmentWithInverseEList<SCorpusDocumentRelation>(SCorpusDocumentRelation.class, this, SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS, SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH);
		}
		return sCorpusDocumentRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpus getSCorpus(SElementId sCorpusId) 
	{
		SCorpus retVal= null;
		
		for (SCorpus sCorpus: this.getSCorpora())
		{
			if (sCorpus.getSElementId()== sCorpusId)
			{
				retVal= sCorpus;
				break;
			}
		}
		return retVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocument getSDocument(SElementId sDocumentId) 
	{
		SDocument retVal= null;
		
		for (SDocument sDocument: this.getSDocuments())
		{
			if (sDocument.getSElementId()== sDocumentId)
			{
				retVal= sDocument;
				break;
			}
		}
		return retVal;
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSDocuments()).basicAdd(otherEnd, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSaltProject((SaltProject)otherEnd, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSCorpora()).basicAdd(otherEnd, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSCorpusRelations()).basicAdd(otherEnd, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSCorpusDocumentRelations()).basicAdd(otherEnd, msgs);
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				return ((InternalEList<?>)getSDocuments()).basicRemove(otherEnd, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				return basicSetSaltProject(null, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				return ((InternalEList<?>)getSCorpora()).basicRemove(otherEnd, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				return ((InternalEList<?>)getSCorpusRelations()).basicRemove(otherEnd, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				return ((InternalEList<?>)getSCorpusDocumentRelations()).basicRemove(otherEnd, msgs);
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				return eInternalContainer().eInverseRemove(this, SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS, SaltProject.class, msgs);
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				return getSDocuments();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				return getSaltProject();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				return getSCorpora();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				return getSCorpusRelations();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				return getSCorpusDocumentRelations();
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				getSDocuments().clear();
				getSDocuments().addAll((Collection<? extends SDocument>)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				setSaltProject((SaltProject)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				getSCorpora().clear();
				getSCorpora().addAll((Collection<? extends SCorpus>)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				getSCorpusRelations().clear();
				getSCorpusRelations().addAll((Collection<? extends SCorpusRelation>)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				getSCorpusDocumentRelations().clear();
				getSCorpusDocumentRelations().addAll((Collection<? extends SCorpusDocumentRelation>)newValue);
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				getSDocuments().clear();
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				setSaltProject((SaltProject)null);
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				getSCorpora().clear();
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				getSCorpusRelations().clear();
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				getSCorpusDocumentRelations().clear();
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				return sDocuments != null && !sDocuments.isEmpty();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				return getSaltProject() != null;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				return sCorpora != null && !sCorpora.isEmpty();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				return sCorpusRelations != null && !sCorpusRelations.isEmpty();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				return sCorpusDocumentRelations != null && !sCorpusDocumentRelations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SCorpusGraphImpl
