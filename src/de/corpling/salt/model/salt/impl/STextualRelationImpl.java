/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;


import de.corpling.salt.model.saltCore.SaltCoreFactory;
import de.corpling.salt.model.saltCore.SFeature;
import de.corpling.salt.model.saltCore.impl.SRelationImpl;
import de.corpling.salt.model.salt.SDocumentGraph;
import de.corpling.salt.model.salt.STextualDataSource;
import de.corpling.salt.model.salt.STextualRelation;
import de.corpling.salt.model.salt.SToken;
import de.corpling.salt.model.salt.SaltPackage;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STextual Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.STextualRelationImpl#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.STextualRelationImpl#getSTextualDataSource <em>STextual Data Source</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.STextualRelationImpl#getSLeftPos <em>SLeft Pos</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.STextualRelationImpl#getSRightPos <em>SRight Pos</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.STextualRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STextualRelationImpl extends SRelationImpl implements STextualRelation 
{
	
	private static final String MSG_ERR=	"Error("+STextualRelationImpl.class+"): ";
	/**
	 * The default value of the '{@link #getSLeftPos() <em>SLeft Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSLeftPos()
	 * @generated
	 * @ordered
	 */
	protected static final Long SLEFT_POS_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getSRightPos() <em>SRight Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRightPos()
	 * @generated
	 * @ordered
	 */
	protected static final Long SRIGHT_POS_EDEFAULT = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STextualRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.STEXTUAL_RELATION;
	}

	//---------------- Start Handling features	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SToken getSToken() {
		SToken sToken = basicGetSToken();
		return sToken != null && sToken.eIsProxy() ? (SToken)eResolveProxy((InternalEObject)sToken) : sToken;
	}

	private static final String FEAT_TOKEN= "token";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SToken basicGetSToken() 
	{
		SFeature feature= super.getSFeature(FEAT_TOKEN);
		if (feature!= null)
			return((SToken)feature.getValue());
		else return(null);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSToken(SToken newSToken) 
	{
		if (newSToken== null)
			throw new NullPointerException(MSG_ERR+ "Cannot set a null object as sToken.");
		SFeature feature= super.getSFeature(FEAT_TOKEN);
		if (feature== null)
		{
			feature= SaltCoreFactory.eINSTANCE.createSFeature();
			feature.setFullName(FEAT_TOKEN);
			super.addSFeature(feature);
		}
		feature.setValue(newSToken);
		
		//TODO muss mit feature abgeglichen werden, sonst dopplung des Datums
		super.setSSourceElement(newSToken);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextualDataSource getSTextualDataSource() {
		STextualDataSource sTextualDataSource = basicGetSTextualDataSource();
		return sTextualDataSource != null && sTextualDataSource.eIsProxy() ? (STextualDataSource)eResolveProxy((InternalEObject)sTextualDataSource) : sTextualDataSource;
	}

	private static final String FEAT_TEXTDS= "textDS";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public STextualDataSource basicGetSTextualDataSource() 
	{
		SFeature feature= super.getSFeature(FEAT_TEXTDS);
		if (feature!= null)
			return((STextualDataSource)feature.getValue());
		else return(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSTextualDataSource(STextualDataSource newSTextualDataSource) 
	{
		if (newSTextualDataSource== null)
			throw new NullPointerException(MSG_ERR+ "Cannot set a null object as STextualDataSource.");
		SFeature feature= super.getSFeature(FEAT_TEXTDS);
		if (feature== null)
		{
			feature= SaltCoreFactory.eINSTANCE.createSFeature();
			feature.setFullName(FEAT_TEXTDS);
			super.addSFeature(feature);
		}
		feature.setValue(newSTextualDataSource);
		
		//TODO muss mit feature abgeglichen werden, sonst dopplung des Datums
		super.setSDestinationElement(newSTextualDataSource);
	}
	
	private static final String FEAT_LEFT= "left";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Long getSLeftPos() 
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
	public void setSLeftPos(Long newLeft) 
	{
		if ((this.getSRightPos()!= null) && (this.getSRightPos()< newLeft))
			throw new NullPointerException(MSG_ERR+ "Cannot set the given value for left, because right is smaller(left: "+newLeft+", right: "+this.getSRightPos()+")");
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
	public Long getSRightPos() 
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
	public void setSRightPos(Long newRight) 
	{
		if ((this.getSRightPos()!= null) && (this.getSLeftPos()> newRight))
			throw new NullPointerException(MSG_ERR+ "Cannot set the given value for left, because right is smaller(left: "+this.getSLeftPos()+", right: "+newRight+")");
		SFeature feature= super.getSFeature(FEAT_RIGHT);
		if (feature== null)
		{
			feature= SaltCoreFactory.eINSTANCE.createSFeature();
			feature.setFullName(FEAT_RIGHT);
			super.addSFeature(feature);
		}
		feature.setValue(newRight);
	}

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
			case SaltPackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS, SDocumentGraph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	//---------------- End Handling features

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltPackage.STEXTUAL_RELATION__STOKEN:
				if (resolve) return getSToken();
				return basicGetSToken();
			case SaltPackage.STEXTUAL_RELATION__STEXTUAL_DATA_SOURCE:
				if (resolve) return getSTextualDataSource();
				return basicGetSTextualDataSource();
			case SaltPackage.STEXTUAL_RELATION__SLEFT_POS:
				return getSLeftPos();
			case SaltPackage.STEXTUAL_RELATION__SRIGHT_POS:
				return getSRightPos();
			case SaltPackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
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
			case SaltPackage.STEXTUAL_RELATION__STOKEN:
				setSToken((SToken)newValue);
				return;
			case SaltPackage.STEXTUAL_RELATION__STEXTUAL_DATA_SOURCE:
				setSTextualDataSource((STextualDataSource)newValue);
				return;
			case SaltPackage.STEXTUAL_RELATION__SLEFT_POS:
				setSLeftPos((Long)newValue);
				return;
			case SaltPackage.STEXTUAL_RELATION__SRIGHT_POS:
				setSRightPos((Long)newValue);
				return;
			case SaltPackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
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
			case SaltPackage.STEXTUAL_RELATION__STOKEN:
				setSToken((SToken)null);
				return;
			case SaltPackage.STEXTUAL_RELATION__STEXTUAL_DATA_SOURCE:
				setSTextualDataSource((STextualDataSource)null);
				return;
			case SaltPackage.STEXTUAL_RELATION__SLEFT_POS:
				setSLeftPos(SLEFT_POS_EDEFAULT);
				return;
			case SaltPackage.STEXTUAL_RELATION__SRIGHT_POS:
				setSRightPos(SRIGHT_POS_EDEFAULT);
				return;
			case SaltPackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
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
			case SaltPackage.STEXTUAL_RELATION__STOKEN:
				return basicGetSToken() != null;
			case SaltPackage.STEXTUAL_RELATION__STEXTUAL_DATA_SOURCE:
				return basicGetSTextualDataSource() != null;
			case SaltPackage.STEXTUAL_RELATION__SLEFT_POS:
				return SLEFT_POS_EDEFAULT == null ? getSLeftPos() != null : !SLEFT_POS_EDEFAULT.equals(getSLeftPos());
			case SaltPackage.STEXTUAL_RELATION__SRIGHT_POS:
				return SRIGHT_POS_EDEFAULT == null ? getSRightPos() != null : !SRIGHT_POS_EDEFAULT.equals(getSRightPos());
			case SaltPackage.STEXTUAL_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //STextualRelationImpl
