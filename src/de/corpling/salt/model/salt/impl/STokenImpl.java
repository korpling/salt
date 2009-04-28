/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;

import de.corpling.salt.model.saltCore.SFeature;
import de.corpling.salt.model.saltCore.SaltCoreFactory;
import de.corpling.salt.model.saltCore.impl.SElementImpl;
import de.corpling.salt.model.salt.SDocumentGraph;
import de.corpling.salt.model.salt.SToken;
import de.corpling.salt.model.salt.SaltPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SToken</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.STokenImpl#getSLeft <em>SLeft</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.STokenImpl#getSRight <em>SRight</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.STokenImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STokenImpl extends SElementImpl implements SToken 
{
	
	/**
	 * The default value of the '{@link #getSLeft() <em>SLeft</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSLeft()
	 * @generated
	 * @ordered
	 */
	protected static final Long SLEFT_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getSRight() <em>SRight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRight()
	 * @generated
	 * @ordered
	 */
	protected static final Long SRIGHT_EDEFAULT = null;
	private static final String MSG_ERR=	"Error("+STokenImpl.class+"): ";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STokenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.STOKEN;
	}

	//---------------- Start Handling features	
	private static final String FEAT_LEFT= "left";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Long getSLeft() 
	{
		SFeature feature= super.getSFeature(FEAT_LEFT);
		if (feature!= null)
			return((Long)feature.getValue());
		else return(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSLeft(Long newLeft) 
	{
		if ((this.getSRight()!= null) && (this.getSRight()< newLeft))
			throw new NullPointerException(MSG_ERR+ "Cannot set the given value for left, because right is smaller(left: "+newLeft+", right: "+this.getSRight()+")");
		SFeature feature= super.getSFeature(FEAT_LEFT);
		if (feature== null)
		{
			feature= SaltCoreFactory.eINSTANCE.createSFeature();
			feature.setFullName(FEAT_LEFT);
			super.addSFeature(feature);
		}
		feature.setValue(newLeft);
	}

	private static final String FEAT_RIGHT= "right";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Long getSRight() 
	{
		SFeature feature= super.getSFeature(FEAT_RIGHT);
		if (feature!= null)
			return((Long)feature.getValue());
		else return(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSRight(Long newRight) 
	{
		if ((this.getSRight()!= null) && (this.getSLeft()> newRight))
			throw new NullPointerException(MSG_ERR+ "Cannot set the given value for left, because right is smaller(left: "+this.getSLeft()+", right: "+newRight+")");
		SFeature feature= super.getSFeature(FEAT_LEFT);
		if (feature== null)
		{
			feature= SaltCoreFactory.eINSTANCE.createSFeature();
			feature.setFullName(FEAT_RIGHT);
			super.addSFeature(feature);
		}
		feature.setValue(newRight);
	}

	//---------------- End Handling features
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocumentGraph getSDocumentGraph() 
	{
		return((SDocumentGraph) super.getSGraph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSDocumentGraph(SDocumentGraph newSDocumentGraph) 
	{
		super.setSGraph(newSDocumentGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case SaltPackage.STOKEN__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SaltPackage.SDOCUMENT_GRAPH__STOKENS, SDocumentGraph.class, msgs);
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
			case SaltPackage.STOKEN__SLEFT:
				return getSLeft();
			case SaltPackage.STOKEN__SRIGHT:
				return getSRight();
			case SaltPackage.STOKEN__SDOCUMENT_GRAPH:
				return getSDocumentGraph();
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
			case SaltPackage.STOKEN__SLEFT:
				setSLeft((Long)newValue);
				return;
			case SaltPackage.STOKEN__SRIGHT:
				setSRight((Long)newValue);
				return;
			case SaltPackage.STOKEN__SDOCUMENT_GRAPH:
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
			case SaltPackage.STOKEN__SLEFT:
				setSLeft(SLEFT_EDEFAULT);
				return;
			case SaltPackage.STOKEN__SRIGHT:
				setSRight(SRIGHT_EDEFAULT);
				return;
			case SaltPackage.STOKEN__SDOCUMENT_GRAPH:
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
			case SaltPackage.STOKEN__SLEFT:
				return SLEFT_EDEFAULT == null ? getSLeft() != null : !SLEFT_EDEFAULT.equals(getSLeft());
			case SaltPackage.STOKEN__SRIGHT:
				return SRIGHT_EDEFAULT == null ? getSRight() != null : !SRIGHT_EDEFAULT.equals(getSRight());
			case SaltPackage.STOKEN__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //STokenImpl
