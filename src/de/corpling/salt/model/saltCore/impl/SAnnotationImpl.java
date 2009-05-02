/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.util.graph.impl.LabelImpl;
import java.net.URL;
import org.eclipse.emf.common.notify.Notification;
import de.corpling.salt.model.saltCore.SAnnotation;
import de.corpling.salt.model.saltCore.SDATATYPES;
import de.corpling.salt.model.saltCore.SaltCorePackage;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAnnotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SAnnotationImpl#getSType <em>SType</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAnnotationImpl extends LabelImpl implements SAnnotation 
{
	
	private static final String MSG_ERR=	"Error("+SAnnotation.class+")";
	/**
	 * The default value of the '{@link #getSType() <em>SType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSType()
	 * @generated
	 * @ordered
	 */
	protected static final SDATATYPES STYPE_EDEFAULT = SDATATYPES.STEXT;
	/**
	 * The cached value of the '{@link #getSType() <em>SType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSType()
	 * @generated
	 * @ordered
	 */
	protected SDATATYPES sType = STYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDATATYPES getSType() {
		return sType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSType(SDATATYPES newSType) {
		SDATATYPES oldSType = sType;
		sType = newSType == null ? STYPE_EDEFAULT : newSType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SANNOTATION__STYPE, oldSType, sType));
	}
	
	/**
	 * Checks if the datatype of the given value matches the sType attribute. If it is so,
	 * the value will be set.
	 */
	@Override
	public void setValue(Object newValue) 
	{
		if ((this.getSType()!= null) && (newValue!= null))
		{
			//SNUMBER
			if (this.getSType()== SDATATYPES.SNUMBER)
			{
				if (!Long.class.isInstance(newValue))
					throw new NullPointerException(MSG_ERR+"Cannot set the given value for SAnnotation, because it is not compatible with datatype "+SDATATYPES.SNUMBER+ ".");
			}
			//SREAL
			else if (this.getSType()== SDATATYPES.SREAL)
			{
				if (!Double.class.isInstance(newValue))
					throw new NullPointerException(MSG_ERR+"Cannot set the given value for SAnnotation, because it is not compatible with datatype "+SDATATYPES.SREAL+ ".");
			}
			//STEXT
			else if (this.getSType()== SDATATYPES.STEXT)
			{
				if (!String.class.isInstance(newValue))
					throw new NullPointerException(MSG_ERR+"Cannot set the given value for SAnnotation, because it is not compatible with datatype "+SDATATYPES.SREAL+ ".");
			}
			//SURL
			else if (this.getSType()== SDATATYPES.SURL)
			{
				if (!URL.class.isInstance(newValue))
					throw new NullPointerException(MSG_ERR+"Cannot set the given value for SAnnotation, because it is not compatible with datatype "+SDATATYPES.SREAL+ ".");
			}
			//SOBJECT
			else if (this.getSType()== SDATATYPES.SOBJECT)
			{
				if (!Object.class.isInstance(newValue))
					throw new NullPointerException(MSG_ERR+"Cannot set the given value for SAnnotation, because it is not compatible with datatype "+SDATATYPES.SREAL+ ".");
			}
		}
		super.setValue(newValue);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Long getValueSNumber() 
	{
		Long retVal= null;
		
		if (this.sType== SDATATYPES.SNUMBER)
		{
			if (this.getValue()== null)
				retVal= null;
			else if (Long.class.isInstance(this.getValue()))
				retVal= (Long)this.getValue();
			else throw new NullPointerException(MSG_ERR + "The value is not of type long, especially it is of type SNUMBER.");
		}	
		else throw new NullPointerException(MSG_ERR + "The value is not of type SNUMBER.");
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Double getValueSReal() 
	{
		Double retVal= null;
		
		if (this.sType== SDATATYPES.SREAL)
		{
			if (this.getValue()== null)
				retVal= null;
			else if (Double.class.isInstance(this.getValue()))
				retVal= (Double)this.getValue();
			else throw new NullPointerException(MSG_ERR + "The value is not of type long, especially it is of type SNUMBER.");
		}	
		else throw new NullPointerException(MSG_ERR + "The value is not of type SREAL.");
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getValueSText() 
	{
		String retVal= null;
		
		if (this.sType== SDATATYPES.STEXT)
			retVal= (String)this.getValue();
		else retVal= this.getValue().toString(); 
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public URL getValueSURL() 
	{
		URL retVal= null;
		
		if (this.sType== SDATATYPES.SURL)
		{
			if (this.getValue()== null)
				retVal= null;
			else if (URL.class.isInstance(this.getValue()))
				retVal= (URL)this.getValue();
			else throw new NullPointerException(MSG_ERR + "The value is not of type long, especially it is of type SNUMBER.");
		}	
		else throw new NullPointerException(MSG_ERR + "The value is not of type SURL.");
		return(retVal);
	}

	/**
	 * Returns the value as an Object.
	 */
	@Override
	public Object getValueSObject() 
	{
		return(this.getValue());	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltCorePackage.SANNOTATION__STYPE:
				return getSType();
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
			case SaltCorePackage.SANNOTATION__STYPE:
				setSType((SDATATYPES)newValue);
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
			case SaltCorePackage.SANNOTATION__STYPE:
				setSType(STYPE_EDEFAULT);
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
			case SaltCorePackage.SANNOTATION__STYPE:
				return sType != STYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sType: ");
		result.append(sType);
		result.append(')');
		return result.toString();
	}
} //SAnnotationImpl
