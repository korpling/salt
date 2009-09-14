/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import de.hub.corpling.graph.Node;

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
public interface SNode extends Node, SAnnotatableElement, SNamedElement, SIdentifiableElement, SProcessingAnnotatableElement {
	/**
	 * Returns the value of the '<em><b>SGraph</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SGraph#getSNodes <em>SNodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SGraph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SGraph</em>' reference.
	 * @see #setSGraph(SGraph)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSNode_SGraph()
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSNodes
	 * @model opposite="sNodes" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SGraph getSGraph();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SNode#getSGraph <em>SGraph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SGraph</em>' reference.
	 * @see #getSGraph()
	 * @generated
	 */
	void setSGraph(SGraph value);
} // SNode
