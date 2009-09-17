/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure;

import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.SNode;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SSequential Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart <em>SStart</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd <em>SEnd</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSequentialRelation()
 * @model
 * @generated
 */
public interface SSequentialRelation extends SRelation {
	/**
	 * Returns the value of the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStart</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStart</em>' attribute.
	 * @see #setSStart(Integer)
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSequentialRelation_SStart()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Integer getSStart();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart <em>SStart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SStart</em>' attribute.
	 * @see #getSStart()
	 * @generated
	 */
	void setSStart(Integer value);

	/**
	 * Returns the value of the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SEnd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SEnd</em>' attribute.
	 * @see #setSEnd(Integer)
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSequentialRelation_SEnd()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Integer getSEnd();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd <em>SEnd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SEnd</em>' attribute.
	 * @see #getSEnd()
	 * @generated
	 */
	void setSEnd(Integer value);

} // SSequentialRelation
