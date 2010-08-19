/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.SaltCommonPackage;
import de.hub.corpling.salt.saltCommon.SaltProject;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Salt Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.impl.SaltProjectImpl#getSCorpusGraphs <em>SCorpus Graphs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaltProjectImpl extends EObjectImpl implements SaltProject {
	/**
	 * The cached value of the '{@link #getSCorpusGraphs() <em>SCorpus Graphs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSCorpusGraphs()
	 * @generated
	 * @ordered
	 */
	protected EList<SCorpusGraph> sCorpusGraphs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCommonPackage.Literals.SALT_PROJECT;
	}

	private static final String KW_SCORPUS_GRAPH_ID="corpusGraph";
	private int numOfSCorpusGraphs= 0;
	@Override
	public void eNotify(Notification notification) 
	{
		super.eNotify(notification);		
		if (notification.getFeature() instanceof EReference) 
		{
			switch (notification.getEventType()) {
			case Notification.ADD:
				if (notification.getNewValue() instanceof SCorpusGraph)
				{
					SCorpusGraph sCorpusGraph= (SCorpusGraph)notification.getNewValue();
					if (sCorpusGraph.getSElementId()== null)
						sCorpusGraph.setSElementId(SaltCommonFactory.eINSTANCE.createSElementId());
					if (	(sCorpusGraph.getSId()== null)||
							(sCorpusGraph.getSId().equalsIgnoreCase("")))
					{
						this.numOfSCorpusGraphs++;
						sCorpusGraph.setSId(KW_SCORPUS_GRAPH_ID + numOfSCorpusGraphs);
					}
				}
			}
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SCorpusGraph> getSCorpusGraphs() 
	{
		if (sCorpusGraphs == null) {
			sCorpusGraphs = new EObjectContainmentWithInverseEList<SCorpusGraph>(SCorpusGraph.class, this, SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS, SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT);
		}
		return sCorpusGraphs;
	}
	
	@Override
	public boolean eNotificationRequired() {
		return true;
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
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSCorpusGraphs()).basicAdd(otherEnd, msgs);
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
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				return ((InternalEList<?>)getSCorpusGraphs()).basicRemove(otherEnd, msgs);
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
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				return getSCorpusGraphs();
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
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				getSCorpusGraphs().clear();
				getSCorpusGraphs().addAll((Collection<? extends SCorpusGraph>)newValue);
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
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				getSCorpusGraphs().clear();
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
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				return sCorpusGraphs != null && !sCorpusGraphs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SaltProjectImpl
