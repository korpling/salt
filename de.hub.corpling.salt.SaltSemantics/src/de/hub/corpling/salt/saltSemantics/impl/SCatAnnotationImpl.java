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
import de.hub.corpling.salt.saltSemantics.SCatAnnotation;
import de.hub.corpling.salt.saltSemantics.SaltSemanticsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCat Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SCatAnnotationImpl extends SAnnotationImpl implements SCatAnnotation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SCatAnnotationImpl() {
		super();
		init();
	}
	
	private void init()
	{
		//initializing ns
		super.setNamespace(SaltSemanticsPackage.eNS_PREFIX);
		//initializing name
		this.basicSetSName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltSemanticsPackage.Literals.SCAT_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean isSCatAnnotation(SAnnotation sAnnotation) 
	{
		Boolean retVal= false;
		if (	(sAnnotation.getName().equalsIgnoreCase(this.getSName()))&&
				(sAnnotation.getSNS().equalsIgnoreCase(SaltSemanticsPackage.eNS_PREFIX)))
			retVal= true;
		return(retVal);
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
	 * Cannot set a new annotation name, it is alwas the same. 
	 */
	public void basicSetSName() 
	{
		super.setName(SALT_SEMANTIC_NAMES.CAT.toString());
	}
	
	/**
	 *Cannot set a new annotation name, it is alwas the same. 
	 */
	public void setSName(String newSName) 
	{
		throw new SaltSemanticsException("Cannot reset the name for "+this.getClass().getName()+ ". The name is fix with '"+this.getSName()+"'.");
	}
	
	/**
	 *Cannot set a new annotation name, it is alwas the same. 
	 */
	public void setSNS(String newSNS) 
	{
		throw new SaltSemanticsException("Cannot reset the the namespace for "+this.getClass().getName()+ ". The name is fix with '"+this.getSNS()+"'.");
	}
} //SCatAnnotationImpl
