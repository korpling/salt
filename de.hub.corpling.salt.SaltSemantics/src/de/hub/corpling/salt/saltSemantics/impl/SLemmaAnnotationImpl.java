/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltSemantics.impl;

import de.hub.corpling.salt.saltCore.SAnnotation;

import de.hub.corpling.salt.saltCore.impl.SAnnotationImpl;
import de.hub.corpling.salt.saltExceptions.SaltSemanticsException;

import de.hub.corpling.salt.saltSemantics.SALT_SEMANTIC_NAMES;
import de.hub.corpling.salt.saltSemantics.SLemmaAnnotation;
import de.hub.corpling.salt.saltSemantics.SaltSemanticsPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SLemma Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SLemmaAnnotationImpl extends SAnnotationImpl implements SLemmaAnnotation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SLemmaAnnotationImpl() 
	{
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
		return SaltSemanticsPackage.Literals.SLEMMA_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean isSLemmaAnnotation(SAnnotation sAnnotation) 
	{
		Boolean retVal= false;
		if (	(sAnnotation != null) &&
				(sAnnotation.getSName()!= null) &&
				(sAnnotation.getNamespace()!= null) &&
				(sAnnotation.getName().equalsIgnoreCase(this.getSName()))&&
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
		super.setName(SALT_SEMANTIC_NAMES.LEMMA.toString());
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

} //SLemmaAnnotationImpl
