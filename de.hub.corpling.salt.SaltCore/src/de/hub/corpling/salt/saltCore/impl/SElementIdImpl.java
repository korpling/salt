/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.hub.corpling.graph.IdentifiableElement;
import de.hub.corpling.graph.impl.IdentifierImpl;
import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SElement Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SElementIdImpl#getSIdentifiableElement <em>SIdentifiable Element</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SElementIdImpl#getSId <em>SId</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SElementIdImpl#getSElementPath <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SElementIdImpl extends IdentifierImpl implements SElementId {
	/**
	 * The default value of the '{@link #getSId() <em>SId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSId()
	 * @generated
	 * @ordered
	 */
	protected static final String SID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSElementPath() <em>SElement Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSElementPath()
	 * @generated
	 * @ordered
	 */
	protected static final URI SELEMENT_PATH_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SElementIdImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SELEMENT_ID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SIdentifiableElement getSIdentifiableElement() 
	{
		SIdentifiableElement sIdentifiableElement = basicGetSIdentifiableElement();
		return sIdentifiableElement != null && sIdentifiableElement.eIsProxy() ? (SIdentifiableElement)eResolveProxy((InternalEObject)sIdentifiableElement) : sIdentifiableElement;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SIdentifiableElement basicGetSIdentifiableElement() 
	{
		SIdentifiableElement retVal= null;
		IdentifiableElement identElem= super.getIdentifiableElement();
		if (identElem instanceof SIdentifiableElement)
			retVal= (SIdentifiableElement) identElem;
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSIdentifiableElement(SIdentifiableElement newSIdentifiableElement) 
	{
		super.setIdentifiableElement(newSIdentifiableElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSId() 
	{
		return(super.getId());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSId(String newSId) 
	{
		super.setId(newSId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public URI getSElementPath() 
	{
		URI retVal= null;
		String id= this.getSId();
		retVal= URI.createURI(id);
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSElementPath(URI newSElementPath) 
	{
		super.setId(newSElementPath.toString());
	}
	
	/**
	 * Checks if a given SElementId has the same entries as this SElementId-object. 
	 * @return if all values are equal.
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean retVal= false;
		if (obj instanceof SElementId)
		{	
			SElementId sElementId2= (SElementId) obj;
			if (this.getSId()!= null)
			{
				if (this.getSId().equalsIgnoreCase(sElementId2.getSId()))
					retVal= true;
				else return(false);
			}
			else
			{
				if (sElementId2== null)
					retVal= true;
				else return(false);
			}
		}
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				if (resolve) return getSIdentifiableElement();
				return basicGetSIdentifiableElement();
			case SaltCorePackage.SELEMENT_ID__SID:
				return getSId();
			case SaltCorePackage.SELEMENT_ID__SELEMENT_PATH:
				return getSElementPath();
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
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				setSIdentifiableElement((SIdentifiableElement)newValue);
				return;
			case SaltCorePackage.SELEMENT_ID__SID:
				setSId((String)newValue);
				return;
			case SaltCorePackage.SELEMENT_ID__SELEMENT_PATH:
				setSElementPath((URI)newValue);
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
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				setSIdentifiableElement((SIdentifiableElement)null);
				return;
			case SaltCorePackage.SELEMENT_ID__SID:
				setSId(SID_EDEFAULT);
				return;
			case SaltCorePackage.SELEMENT_ID__SELEMENT_PATH:
				setSElementPath(SELEMENT_PATH_EDEFAULT);
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
			case SaltCorePackage.SELEMENT_ID__SIDENTIFIABLE_ELEMENT:
				return basicGetSIdentifiableElement() != null;
			case SaltCorePackage.SELEMENT_ID__SID:
				return SID_EDEFAULT == null ? getSId() != null : !SID_EDEFAULT.equals(getSId());
			case SaltCorePackage.SELEMENT_ID__SELEMENT_PATH:
				return SELEMENT_PATH_EDEFAULT == null ? getSElementPath() != null : !SELEMENT_PATH_EDEFAULT.equals(getSElementPath());
		}
		return super.eIsSet(featureID);
	}

} //SElementIdImpl
