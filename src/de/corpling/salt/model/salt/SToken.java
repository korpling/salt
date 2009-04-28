/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt;

import de.corpling.salt.model.saltCore.SElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SToken</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.SToken#getSLeft <em>SLeft</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SToken#getSRight <em>SRight</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SToken#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSToken()
 * @model
 * @generated
 */
public interface SToken extends SElement {
	/**
	 * Returns the value of the '<em><b>SLeft</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SLeft</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SLeft</em>' attribute.
	 * @see #setSLeft(Long)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSToken_SLeft()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Long getSLeft();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SToken#getSLeft <em>SLeft</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SLeft</em>' attribute.
	 * @see #getSLeft()
	 * @generated
	 */
	void setSLeft(Long value);

	/**
	 * Returns the value of the '<em><b>SRight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SRight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SRight</em>' attribute.
	 * @see #setSRight(Long)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSToken_SRight()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Long getSRight();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SToken#getSRight <em>SRight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SRight</em>' attribute.
	 * @see #getSRight()
	 * @generated
	 */
	void setSRight(Long value);

	/**
	 * Returns the value of the '<em><b>SDocument Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SDocumentGraph#getSTokens <em>STokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument Graph</em>' container reference.
	 * @see #setSDocumentGraph(SDocumentGraph)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSToken_SDocumentGraph()
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSTokens
	 * @model opposite="sTokens" required="true" volatile="true" derived="true"
	 * @generated
	 */
	SDocumentGraph getSDocumentGraph();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SToken#getSDocumentGraph <em>SDocument Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument Graph</em>' container reference.
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	void setSDocumentGraph(SDocumentGraph value);

} // SToken
