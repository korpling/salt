/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import org.eclipse.emf.ecore.EClass;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.accessors.STextOverlappingRelationAccessor;
import de.hub.corpling.salt.saltCore.impl.SRelationImpl;

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
