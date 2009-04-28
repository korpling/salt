/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;


import de.corpling.salt.model.saltCore.SCoreProject;
import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.model.saltCore.SStereotypeContainer;
import de.corpling.salt.model.saltCore.SaltCorePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCore Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SCoreProjectImpl#getSGraphs <em>SGraphs</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SCoreProjectImpl#getSStereotypeContainer <em>SStereotype Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCoreProjectImpl extends SStereotypeContainerImpl implements SCoreProject {
	/**
	 * The cached value of the '{@link #getSGraphs() <em>SGraphs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSGraphs()
	 * @generated
	 * @ordered
	 */
	protected EList<SGraph> sGraphs;

	/**
	 * The cached value of the '{@link #getSStereotypeContainer() <em>SStereotype Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSStereotypeContainer()
	 * @generated
	 * @ordered
	 */
	protected SStereotypeContainer sStereotypeContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCoreProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SCORE_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SGraph> getSGraphs() {
		if (sGraphs == null) {
			sGraphs = new EObjectContainmentWithInverseEList<SGraph>(SGraph.class, this, SaltCorePackage.SCORE_PROJECT__SGRAPHS, SaltCorePackage.SGRAPH__SCORE_PROJECT);
		}
		return sGraphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotypeContainer getSStereotypeContainer() {
		return sStereotypeContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSStereotypeContainer(SStereotypeContainer newSStereotypeContainer, NotificationChain msgs) {
		SStereotypeContainer oldSStereotypeContainer = sStereotypeContainer;
		sStereotypeContainer = newSStereotypeContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SCORE_PROJECT__SSTEREOTYPE_CONTAINER, oldSStereotypeContainer, newSStereotypeContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSStereotypeContainer(SStereotypeContainer newSStereotypeContainer) {
		if (newSStereotypeContainer != sStereotypeContainer) {
			NotificationChain msgs = null;
			if (sStereotypeContainer != null)
				msgs = ((InternalEObject)sStereotypeContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SCORE_PROJECT__SSTEREOTYPE_CONTAINER, null, msgs);
			if (newSStereotypeContainer != null)
				msgs = ((InternalEObject)newSStereotypeContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SCORE_PROJECT__SSTEREOTYPE_CONTAINER, null, msgs);
			msgs = basicSetSStereotypeContainer(newSStereotypeContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SCORE_PROJECT__SSTEREOTYPE_CONTAINER, newSStereotypeContainer, newSStereotypeContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSGraph(SGraph sGraph) 
	{
		this.getSGraphs().add(sGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SGraph getSGraphById(Object sGraphId) 
	{
		SGraph retVal= null;
		for (SGraph sGraph: this.getSGraphs())
		{	
			if (sGraph.getId().equals(sGraphId))
			{	
				retVal=sGraph;
				break;
			}
		}
		return(retVal);
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
			case SaltCorePackage.SCORE_PROJECT__SGRAPHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSGraphs()).basicAdd(otherEnd, msgs);
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
			case SaltCorePackage.SCORE_PROJECT__SGRAPHS:
				return ((InternalEList<?>)getSGraphs()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SCORE_PROJECT__SSTEREOTYPE_CONTAINER:
				return basicSetSStereotypeContainer(null, msgs);
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
			case SaltCorePackage.SCORE_PROJECT__SGRAPHS:
				return getSGraphs();
			case SaltCorePackage.SCORE_PROJECT__SSTEREOTYPE_CONTAINER:
				return getSStereotypeContainer();
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
			case SaltCorePackage.SCORE_PROJECT__SGRAPHS:
				getSGraphs().clear();
				getSGraphs().addAll((Collection<? extends SGraph>)newValue);
				return;
			case SaltCorePackage.SCORE_PROJECT__SSTEREOTYPE_CONTAINER:
				setSStereotypeContainer((SStereotypeContainer)newValue);
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
			case SaltCorePackage.SCORE_PROJECT__SGRAPHS:
				getSGraphs().clear();
				return;
			case SaltCorePackage.SCORE_PROJECT__SSTEREOTYPE_CONTAINER:
				setSStereotypeContainer((SStereotypeContainer)null);
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
			case SaltCorePackage.SCORE_PROJECT__SGRAPHS:
				return sGraphs != null && !sGraphs.isEmpty();
			case SaltCorePackage.SCORE_PROJECT__SSTEREOTYPE_CONTAINER:
				return sStereotypeContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //SCoreProjectImpl
