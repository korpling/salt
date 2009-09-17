/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure;

import de.hub.corpling.salt.saltCore.SNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SToken</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSToken()
 * @model
 * @generated
 */
public interface SToken extends SNode {
	/**
	 * Returns the value of the '<em><b>SDocument Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens <em>STokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument Graph</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument Graph</em>' container reference.
	 * @see #setSDocumentGraph(SDocumentGraph)
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSToken_SDocumentGraph()
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens
	 * @model opposite="sTokens" volatile="true" derived="true"
	 * @generated
	 */
	SDocumentGraph getSDocumentGraph();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph <em>SDocument Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument Graph</em>' container reference.
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	void setSDocumentGraph(SDocumentGraph value);

} // SToken
