/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAbstract Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAbstractAnnotationImpl#getSNS <em>SNS</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAbstractAnnotationImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAbstractAnnotationImpl#getSValue <em>SValue</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAbstractAnnotationImpl#getSValueType <em>SValue Type</em>}</li>
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
	 * {@link Inherited SAbstractAnnotation#getSValue()}
	 */
	public Object getSValue() 
	{
		return(super.getValue());
	}

	/**
	 * {@inheritDoc SAbstractAnnotation#setSValue(Object)}}
	 */
	public void setSValue(Object newSValue) 
	{
		super.setValue(newSValue);
//		{//setting sValueType
//			if (newSValue == null)
//				this.setSValueType(SDATATYPE.SOBJECT);
//			else if (newSValue instanceof String)
//				this.setSValueType(SDATATYPE.STEXT);
//			else if (newSValue instanceof Boolean)
//				this.setSValueType(SDATATYPE.SBOOLEAN);
//			else if (newSValue instanceof Integer)
//				this.setSValueType(SDATATYPE.SNUMERIC);
//			else if (newSValue instanceof Long)
//				this.setSValueType(SDATATYPE.SNUMERIC);
//			else if (newSValue instanceof Float)
//				this.setSValueType(SDATATYPE.SFLOAT);
//			else if (newSValue instanceof Double)
//				this.setSValueType(SDATATYPE.SFLOAT);
//			else if (newSValue instanceof URI)
//				this.setSValueType(SDATATYPE.SURI);
//			else this.setSValueType(SDATATYPE.SOBJECT);
//		}//setting sValueType
	}

// ============================= start: SValueType	
	private SDATATYPE computeSValueType()
	{
	    if (this.getValue() == null)
            return(SDATATYPE.SOBJECT);
        else if (this.getValue() instanceof String)
            return(SDATATYPE.STEXT);
        else if (this.getValue() instanceof Boolean)
            return(SDATATYPE.SBOOLEAN);
        else if (this.getValue() instanceof Integer)
            return(SDATATYPE.SNUMERIC);
        else if (this.getValue() instanceof Long)
            return(SDATATYPE.SNUMERIC);
        else if (this.getValue() instanceof Float)
            return(SDATATYPE.SFLOAT);
        else if (this.getValue() instanceof Double)
            return(SDATATYPE.SFLOAT);
        else if (this.getValue() instanceof URI)
            return(SDATATYPE.SURI);
        else return(SDATATYPE.SOBJECT);
	}
	
	/**
	 * {@link Inherited SAbstractAnnotation#getSValueType()}
	 */
	public SDATATYPE getSValueType() 
	{
		SDATATYPE retVal= null;
		
		Label label= super.getLabel(KW_SVAL_TYPE);
		if (label!= null)
		{
		    if (  (label.getValue()== null)&&
		            (this.getSValue()!= null))
		    { 
		      label.setValue(computeSValueType());  
		    }
	        retVal= SDATATYPE.valueOf(label.getValueString()); 
		}
		else
		{//compute value type
		    retVal= computeSValueType();
			
		}//compute value type 	
		return(retVal);
	}

	/**
	 * {@inheritDoc SAbstractAnnotation#setSValueType(SDATATYPE)}
	 */
	public void setSValueType(SDATATYPE newSValueType) 
	{
		Label label= super.getLabel(KW_SVAL_TYPE);
		if (label== null)
		{	
			label= GraphFactory.eINSTANCE.createLabel();
			label.setQName(KW_SVAL_TYPE);
			this.addLabel(label);
		}
		if (newSValueType== null)
		    label.setValueString(null);
		else label.setValueString(newSValueType.toString());
	}
	
	/**
	 * {@link Inherited SAbstractAnnotation#getSValueSTEXT()}
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
	 * {@link Inherited SAbstractAnnotation#getSValueSBOOLEAN()}
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
	 * {@link Inherited SAbstractAnnotation#getSValueSNUMERIC()}
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
	 * {@link Inherited SAbstractAnnotation#getSValueSFLOAT()}
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
	 * {@link Inherited SAbstractAnnotation#getSValueSURI()}
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
	 *{@link Inherited SAbstractAnnotation#getSValueSOBJECT()}
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
			case SaltCorePackage.SABSTRACT_ANNOTATION__SVALUE_TYPE:
				setSValueType((SDATATYPE)newValue);
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
			case SaltCorePackage.SABSTRACT_ANNOTATION__SVALUE_TYPE:
				setSValueType(SVALUE_TYPE_EDEFAULT);
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
