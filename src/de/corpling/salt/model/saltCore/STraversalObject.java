/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>STraversal Object</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSTraversalObject()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface STraversalObject extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void sElementReached(STRAVERSAL_MODE traversalMode, SElement currSElement, SRelation sRelation, SElement fromSElement, long order);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void sElementLeft(STRAVERSAL_MODE traversalMode, SElement currSElement, SRelation sRelation, SElement fromSElement, long order);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean checkConstraint(STRAVERSAL_MODE traversalMode, SRelation sRelation, SElement currSElement, long order);

} // STraversalObject
