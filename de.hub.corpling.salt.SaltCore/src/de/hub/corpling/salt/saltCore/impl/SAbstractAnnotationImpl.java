/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import org.eclipse.emf.ecore.EClass;

import de.hub.corpling.graph.GraphFactory;
import de.hub.corpling.graph.Label;
import de.hub.corpling.graph.impl.LabelImpl;
import de.hub.corpling.salt.saltCore.SAbstractAnnotation;
import de.hub.corpling.salt.saltCore.SDATATYPE;
import de.hub.corpling.salt.saltCore.SaltCorePackage;
import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAbstract Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SAbstractAnnotationImpl#getSNS <em>SNS</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SAbstractAnnotationImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SAbstractAnnotationImpl#getSValue <em>SValue</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SAbstractAnnotationImpl#getSValueType <em>SValue Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SAbstractAnnotationImpl extends LabelImpl implements SAbstractAnnotation {
	/**
	 * The default value of the '{@link #getSNS() <em>SNS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSNS()
	 * @generated
	 * @ordered
	 */
	protected static final String SNS_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSName() <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSName()
	 * @generated
	 * @ordered
	 */
	protected static final String SNAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSValue() <em>SValue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object SVALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSValueType() <em>SValue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSValueType()
	 * @generated
	 * @ordered
	 */
	protected static final SDATATYPE SVALUE_TYPE_EDEFAULT = SDATATYPE.STEXT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAbstractAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SABSTRACT_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSNS() 
	{
		return(super.getNamespace());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSNS(String newSNS) 
	{
		super.setNamespace(newSNS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSName() 
	{
		return(super.getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSName(String newSName) 
	{
		super.setName(newSName);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Object getSValue() 
	{
		return(super.getValue());
	}

	/**
	 * Sets the value of the sValue attribute.
	 * This method also sets the sValueType attribute to one of the supported Datatypes in SDATATYPE.
	 * null--> SOBJECT
	 * String --> STEXT
	 * Boolean --> SBOOLEAN
	 * Integer --> SNUMERIC
	 * Long --> SNUMERIC
	 * Double --> SFLOAT
	 * Float --> SFLOAT
	 * URI --> SURI
	 * else --> SOBJECT
	 */
	public void setSValue(Object newSValue) 
	{
		super.setValue(newSValue);
		{//setting sValueType
			if (newSValue == null)
				this.setSValueType(SDATATYPE.SOBJECT);
			else if (newSValue instanceof String)
				this.setSValueType(SDATATYPE.STEXT);
			else if (newSValue instanceof Boolean)
				this.setSValueType(SDATATYPE.SBOOLEAN);
			else if (newSValue instanceof Integer)
				this.setSValueType(SDATATYPE.SNUMERIC);
			else if (newSValue instanceof Long)
				this.setSValueType(SDATATYPE.SNUMERIC);
			else if (newSValue instanceof Float)
				this.setSValueType(SDATATYPE.SFLOAT);
			else if (newSValue instanceof Double)
				this.setSValueType(SDATATYPE.SFLOAT);
			else if (newSValue instanceof URI)
				this.setSValueType(SDATATYPE.SURI);
			else this.setSValueType(SDATATYPE.SOBJECT);
		}//setting sValueType
	}

// ============================= start: SValueType	
	private static final String KW_SVAL_TYPE="SVAL_TYPE";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDATATYPE getSValueType() 
	{
		SDATATYPE retVal= null;
		
		Label label= super.getLabel(KW_SVAL_TYPE);
		if (label!= null)
		{
			retVal= SDATATYPE.valueOf(label.getValueString()); 
		}
//		else retVal= SVALUE_TYPE_EDEFAULT;
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	private void setSValueType(SDATATYPE newSValueType) 
	{
		Label label= super.getLabel(KW_SVAL_TYPE);
		if (label== null)
		{	
			label= GraphFactory.eINSTANCE.createLabel();
			label.setQName(KW_SVAL_TYPE);
			this.addLabel(label);
		}
		label.setValueString(newSValueType.toString());
	}
	
	/**
	 * Returns the sValue attribute of this object as String representation. If the sValue is of
	 * type String it will be returned, else the toString()-method will be called. If no value is given,
	 * null will be returned.
	 * @return String representation of the sValue attribute.  
	 */
	public String getSValueSTEXT() 
	{
		String retVal= null;
		if (this.getSValue()!= null)
		{	
			if (this.getSValue() instanceof String)
				retVal= (String) this.getSValue();
			else retVal= this.getSValue().toString();
		}
		return(retVal);
	}

	/**
	 * Returns the sValue attribute of this object as Boolean if possible. If the value is
	 * not of type Boolean or is empty, null will be returned.
	 * @return Boolean representation of the sValue attribute. 
	 */
	public Boolean getSValueSBOOLEAN() 
	{
		Boolean retVal= null;
		if (this.getSValueType()== SDATATYPE.SBOOLEAN)
		{
			if (this.getSValue() instanceof Boolean)
				retVal= (Boolean) this.getSValue();
		}
		return(retVal);
	}

	/**
	 * Returns the sValue attribute of this object as Long if possible. If the value is
	 * not of type Long or is empty, null will be returned.
	 * Attention: If value was of type Integer, than not the original 
	 * value will be returned. Instead a casted value will be returned.
	 * @return Long representation of the sValue attribute. 
	 */
	public Long getSValueSNUMERIC() 
	{
		Long retVal= null;
		if (this.getSValueType()== SDATATYPE.SNUMERIC)
		{
			if (this.getSValue() instanceof Integer)
				retVal= (Long) ((Integer)this.getSValue()).longValue();
			else if (this.getSValue() instanceof Long)
				retVal= (Long) this.getSValue();
		}
		return(retVal);
	}

	/**
	 * Returns the sValue attribute of this object as Float if possible. If the value is
	 * not of type Float or is empty, null will be returned.
	 * Attention: If value was of type Float, than not the original 
	 * value will be returned. Instead a casted value will be returned.
	 * @return Float representation of the sValue attribute. 
	 */
	public Double getSValueSFLOAT() 
	{
		Double retVal= null;
		if (this.getSValueType()== SDATATYPE.SFLOAT)
		{
			if (this.getSValue() instanceof Double)
			{
				retVal= (Double) this.getSValue();
			}
			else if (this.getSValue() instanceof Float) 
			{
				retVal= ((Float) this.getSValue()).doubleValue();
			}
		}
		return(retVal);
	}

	/**
	 * Returns the sValue attribute of this object as URI if possible. If the value is
	 * not of type URI or is empty, null will be returned.
	 * @return URI representation of the sValue attribute. 
	 */
	public URI getSValueSURI() 
	{
		URI retVal= null;
		if (this.getSValueType()== SDATATYPE.SURI)
		{
			if (this.getSValue() instanceof URI)
				retVal= (URI) this.getSValue();
		}
		return(retVal);
	}

	/**
	 * Returns the the sValue attribute of this object as the original object. This will always work
	 * as long as sValue is not empty. If the sValue attribute is empty null will be returned. 
	 * @return Object representation of the sValue attribute
	 */
	public Object getSValueSOBJECT() 
	{
		return(this.getSValue());
	}

	// ============================= end: SValueType
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltCorePackage.SABSTRACT_ANNOTATION__SNS:
				return getSNS();
			case SaltCorePackage.SABSTRACT_ANNOTATION__SNAME:
				return getSName();
			case SaltCorePackage.SABSTRACT_ANNOTATION__SVALUE:
				return getSValue();
			case SaltCorePackage.SABSTRACT_ANNOTATION__SVALUE_TYPE:
				return getSValueType();
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
			case SaltCorePackage.SABSTRACT_ANNOTATION__SNS:
				setSNS((String)newValue);
				return;
			case SaltCorePackage.SABSTRACT_ANNOTATION__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SABSTRACT_ANNOTATION__SVALUE:
				setSValue(newValue);
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
			case SaltCorePackage.SABSTRACT_ANNOTATION__SNS:
				setSNS(SNS_EDEFAULT);
				return;
			case SaltCorePackage.SABSTRACT_ANNOTATION__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SABSTRACT_ANNOTATION__SVALUE:
				setSValue(SVALUE_EDEFAULT);
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
			case SaltCorePackage.SABSTRACT_ANNOTATION__SNS:
				return SNS_EDEFAULT == null ? getSNS() != null : !SNS_EDEFAULT.equals(getSNS());
			case SaltCorePackage.SABSTRACT_ANNOTATION__SNAME:
				return SNAME_EDEFAULT == null ? getSName() != null : !SNAME_EDEFAULT.equals(getSName());
			case SaltCorePackage.SABSTRACT_ANNOTATION__SVALUE:
				return SVALUE_EDEFAULT == null ? getSValue() != null : !SVALUE_EDEFAULT.equals(getSValue());
			case SaltCorePackage.SABSTRACT_ANNOTATION__SVALUE_TYPE:
				return getSValueType() != SVALUE_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //SAbstractAnnotationImpl
