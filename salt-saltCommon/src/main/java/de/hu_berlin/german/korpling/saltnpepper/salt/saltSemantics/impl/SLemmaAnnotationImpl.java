/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl;

import org.eclipse.emf.ecore.EClass;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltSemanticsException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAnnotationImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsPackage;

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
