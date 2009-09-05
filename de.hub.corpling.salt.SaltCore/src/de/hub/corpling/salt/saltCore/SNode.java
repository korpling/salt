/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SNode#getSGraph <em>SGraph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSNode()
 * @model
 * @generated
 */
public interface SNode extends SAnnotatableElement, SNamedElement, SIdentifiableElement {

	/**
	 * Returns the value of the '<em><b>SGraph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SGraph#getSNodes <em>SNodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SGraph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SGraph</em>' container reference.
	 * @see #setSGraph(SGraph)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSNode_SGraph()
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSNodes
	 * @model opposite="sNodes" transient="false"
	 * @generated
	 */
	SGraph getSGraph();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SNode#getSGraph <em>SGraph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SGraph</em>' container reference.
	 * @see #getSGraph()
	 * @generated
	 */
	void setSGraph(SGraph value);
} // SNode
