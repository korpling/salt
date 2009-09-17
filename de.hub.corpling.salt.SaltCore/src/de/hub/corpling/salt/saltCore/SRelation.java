/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import de.hub.corpling.graph.Edge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SRelation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SRelation#getSSource <em>SSource</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SRelation#getSTarget <em>STarget</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSRelation()
 * @model
 * @generated
 */
public interface SRelation extends Edge, SAnnotatableElement, SNamedElement, SIdentifiableElement, SProcessingAnnotatableElement, SFeaturableElement {
	/**
	 * Returns the value of the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSource</em>' reference.
	 * @see #setSSource(SNode)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSRelation_SSource()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SNode getSSource();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SRelation#getSSource <em>SSource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSource</em>' reference.
	 * @see #getSSource()
	 * @generated
	 */
	void setSSource(SNode value);

	/**
	 * Returns the value of the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STarget</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STarget</em>' reference.
	 * @see #setSTarget(SNode)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSRelation_STarget()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SNode getSTarget();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SRelation#getSTarget <em>STarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>STarget</em>' reference.
	 * @see #getSTarget()
	 * @generated
	 */
	void setSTarget(SNode value);

	/**
	 * Returns the value of the '<em><b>SGraph</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SGraph#getSRelations <em>SRelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SGraph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SGraph</em>' reference.
	 * @see #setSGraph(SGraph)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSRelation_SGraph()
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSRelations
	 * @model opposite="sRelations" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SGraph getSGraph();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SGraph</em>' reference.
	 * @see #getSGraph()
	 * @generated
	 */
	void setSGraph(SGraph value);

} // SRelation
