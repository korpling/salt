/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltSemantics.impl;

import org.eclipse.emf.ecore.EClass;

import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.impl.SAnnotationImpl;
import de.hub.corpling.salt.saltExceptions.SaltSemanticsException;
import de.hub.corpling.salt.saltSemantics.SALT_SEMANTIC_NAMES;
import de.hub.corpling.salt.saltSemantics.SWordAnnotation;
import de.hub.corpling.salt.saltSemantics.SaltSemanticsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SWord Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SWordAnnotationImpl extends SAnnotationImpl implements SWordAnnotation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SWordAnnotationImpl() {
		super();
		init();
	}
	
	private void init()
	{
		//initializing ns
		super.setNamespace(SaltSemanticsPackage.eNS_PREFIX);
		//initializing name
		this.basicSetSName();
		//initializing value
		super.setSValue(SALT_SEMANTIC_NAMES.TEXT_UNIT_WORD.toString());
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltSemanticsPackage.Literals.SWORD_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean isSWordAnnotation(SAnnotation sAnnotation) 
	{
		Boolean retVal= false;
		if (	(sAnnotation.getName().equalsIgnoreCase(this.getSName()))&&
				(sAnnotation.getSNS().equalsIgnoreCase(SaltSemanticsPackage.eNS_PREFIX)) &&
				(sAnnotation.getSValue().equals(this.getSValue())))
			retVal= true;
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getSName() 
	{
		return(super.getName());
	}

	/**
	 * Cannot set a new annotation name, it is alwas the same. 
	 */
	public void basicSetSName() 
	{
		super.setName(SALT_SEMANTIC_NAMES.TEXT_UNIT.toString());
	}
	
	/**
	 *Cannot set a new annotation name, it is alwas the same. 
	 */
	@Override
	public void setSName(String newSName) 
	{
		throw new SaltSemanticsException("Cannot reset the name for "+this.getClass().getName()+ ". The name is fix with '"+this.getSName()+"'.");
	}
	
	/**
	 *Cannot set a new annotation name, it is alwas the same. 
	 */
	@Override
	public void setSNS(String newSNS) 
	{
		throw new SaltSemanticsException("Cannot reset the the namespace for "+this.getClass().getName()+ ". The name is fix with '"+this.getSNS()+"'.");
	}
	
	/**
	 *Cannot set a new annotation name, it is alwas the same. 
	 */
	@Override
	public void setSValue(Object newSName) 
	{
		throw new SaltSemanticsException("Cannot reset the value for "+this.getClass().getName()+ ". The name is fix with '"+this.getSValue()+"'.");
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Object getSValue() 
	{
		return(super.getSValue());
	}
} //SWordAnnotationImpl
