/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SRelation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SRelation#getSourceSNode <em>Source SNode</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SRelation#getTargetSNode <em>Target SNode</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSRelation()
 * @model
 * @generated
 */
public interface SRelation extends SAnnotatableElement, SNamedElement, SIdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Source SNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source SNode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source SNode</em>' reference.
	 * @see #setSourceSNode(SNode)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSRelation_SourceSNode()
	 * @model
	 * @generated
	 */
	SNode getSourceSNode();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SRelation#getSourceSNode <em>Source SNode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source SNode</em>' reference.
	 * @see #getSourceSNode()
	 * @generated
	 */
	void setSourceSNode(SNode value);

	/**
	 * Returns the value of the '<em><b>Target SNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target SNode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target SNode</em>' reference.
	 * @see #setTargetSNode(SNode)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSRelation_TargetSNode()
	 * @model
	 * @generated
	 */
	SNode getTargetSNode();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SRelation#getTargetSNode <em>Target SNode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target SNode</em>' reference.
	 * @see #getTargetSNode()
	 * @generated
	 */
	void setTargetSNode(SNode value);

	/**
	 * Returns the value of the '<em><b>SGraph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SGraph#getSRelations <em>SRelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SGraph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SGraph</em>' container reference.
	 * @see #setSGraph(SGraph)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSRelation_SGraph()
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSRelations
	 * @model opposite="sRelations" transient="false"
	 * @generated
	 */
	SGraph getSGraph();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SGraph</em>' container reference.
	 * @see #getSGraph()
	 * @generated
	 */
	void setSGraph(SGraph value);

} // SRelation
