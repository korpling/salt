/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;


import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.model.saltCore.impl.SElementImpl;
import de.corpling.salt.model.salt.SCorpusGraph;
import de.corpling.salt.model.salt.SDocument;
import de.corpling.salt.model.salt.SDocumentGraph;
import de.corpling.salt.model.salt.SaltPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SDocument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.SDocumentImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SDocumentImpl#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDocumentImpl extends SElementImpl implements SDocument 
{
	private static String MSG_ERR=	"Error("+SDocumentImpl.class+"): ";	
	/**
	 * The cached value of the '{@link #getSDocumentGraph() <em>SDocument Graph</em>}' containment reference.
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
	 */
	protected SDocumentImpl() {
		super();
		this.init();
	}
	
	/**
	 * Initializes this object
	 */
	private void init()
	{
		// old since 13.3.09
		//this.setSDocumentGraph(SaltConcreteFactory.eINSTANCE.createSDocumentGraph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.SDOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocumentGraph getSDocumentGraph() 
	{
		if (sDocumentGraph.getSCoreProject()== null)
		{
			if (this.getSCorpusGraph()!= null)
			{
				/* old since 13.3.09
				if (this.getSCorpusGraph().getSCoreProject()!= null)
				{
					System.out.println("getDocGraph(before): "+ this.sDocumentGraph);
					//this.sDocumentGraph.setSCoreProject(getSCorpusGraph().getSCoreProject());
					System.out.println("getDocGraph(after): "+ this.sDocumentGraph);
				}
				else throw new NullPointerException(MSG_ERR + "Cannot return a document graph, because salt project isn´t set for corpus graph.");
				*/
				//new since 13.03.09
				throw new NullPointerException(MSG_ERR + "Cannot return a document graph, because salt project isn´t set for corpus graph.");
					
			}
			else throw new NullPointerException(MSG_ERR + "Cannot return a document graph, before corpus graph isn´t set.");
		}	
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH, oldSDocumentGraph, newSDocumentGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSDocumentGraph(SDocumentGraph newSDocumentGraph) 
	{
		if (newSDocumentGraph != sDocumentGraph) {
			NotificationChain msgs = null;
			if (sDocumentGraph != null)
				msgs = ((InternalEObject)sDocumentGraph).eInverseRemove(this, SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT, SDocumentGraph.class, msgs);
			if (newSDocumentGraph != null)
				msgs = ((InternalEObject)newSDocumentGraph).eInverseAdd(this, SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT, SDocumentGraph.class, msgs);
			msgs = basicSetSDocumentGraph(newSDocumentGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH, newSDocumentGraph, newSDocumentGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpusGraph getSCorpusGraph() 
	{
		return((SCorpusGraph)super.getSGraph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSCorpusGraph(SCorpusGraph newSCorpusGraph) 
	{
		this.setSGraph(newSCorpusGraph);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH:
				if (sDocumentGraph != null)
					msgs = ((InternalEObject)sDocumentGraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH, null, msgs);
				return basicSetSDocumentGraph((SDocumentGraph)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * Just overrides method, to control new constraints.
	 */
	public void setSGraph(SGraph newSGraph) 
	{
		if (!SCorpusGraph.class.isInstance(newSGraph))
			throw new NullPointerException(MSG_ERR + "Cannot set the given graph, because it is not of type: "+SCorpusGraph.class);

		super.setSGraph(newSGraph);
		this.sDocumentGraph.setSCoreProject(this.getSGraph().getSCoreProject());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH:
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
		switch (eContainerFeatureID) {
			case SaltPackage.SDOCUMENT__SCORPUS_GRAPH:
				return eInternalContainer().eInverseRemove(this, SaltPackage.SCORPUS_GRAPH__SDOCUMENTS, SCorpusGraph.class, msgs);
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
			case SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH:
				return getSDocumentGraph();
			case SaltPackage.SDOCUMENT__SCORPUS_GRAPH:
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
			case SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)newValue);
				return;
			case SaltPackage.SDOCUMENT__SCORPUS_GRAPH:
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
			case SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)null);
				return;
			case SaltPackage.SDOCUMENT__SCORPUS_GRAPH:
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
			case SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH:
				return sDocumentGraph != null;
			case SaltPackage.SDOCUMENT__SCORPUS_GRAPH:
				return getSCorpusGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SDocumentImpl
