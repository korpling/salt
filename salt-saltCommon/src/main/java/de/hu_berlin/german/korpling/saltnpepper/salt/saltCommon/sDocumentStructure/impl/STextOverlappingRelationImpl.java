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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl;

import org.eclipse.emf.ecore.EClass;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.accessors.STextOverlappingRelationAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SText Overlapping Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class STextOverlappingRelationImpl extends SRelationImpl implements STextOverlappingRelation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4612076432814368802L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected STextOverlappingRelationImpl() {
		super();
		init();
	}

	private void init()
	{
		this.sTextOverlappingRelAccessor= new STextOverlappingRelationAccessor();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.STEXT_OVERLAPPING_RELATION;
	}

	// ======================= start: delegating for feature textOverlapping	
	/**
	 * delegatee for textoverlapping
	 */
	private STextOverlappingRelationAccessor sTextOverlappingRelAccessor= null; 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean isSTextOverlapping() 
	{
		return(this.sTextOverlappingRelAccessor.isSTextOverlapping(this));
	}
// ======================= end: delegating for feature textOverlapping

} //STextOverlappingRelationImpl
