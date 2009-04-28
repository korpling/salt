/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt;

import de.corpling.salt.model.saltCore.SRelation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCoverage Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.SSpanRelation#getSDocumentGraph <em>SDocument Graph</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SSpanRelation#getSStructure <em>SStructure</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SSpanRelation#getSToken <em>SToken</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSSpanRelation()
 * @model
 * @generated
 */
public interface SSpanRelation extends SRelation {
	/**
	 * Returns the value of the '<em><b>SDocument Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SDocumentGraph#getSpanRelations <em>Span Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument Graph</em>' container reference.
	 * @see #setSDocumentGraph(SDocumentGraph)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSSpanRelation_SDocumentGraph()
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSpanRelations
	 * @model opposite="SpanRelations" volatile="true" derived="true"
	 * @generated
	 */
	SDocumentGraph getSDocumentGraph();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SSpanRelation#getSDocumentGraph <em>SDocument Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument Graph</em>' container reference.
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	void setSDocumentGraph(SDocumentGraph value);

	/**
	 * Returns the value of the '<em><b>SStructure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStructure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStructure</em>' reference.
	 * @see #setSStructure(SStructure)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSSpanRelation_SStructure()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SStructure getSStructure();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SSpanRelation#getSStructure <em>SStructure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SStructure</em>' reference.
	 * @see #getSStructure()
	 * @generated
	 */
	void setSStructure(SStructure value);

	/**
	 * Returns the value of the '<em><b>SToken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SToken</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SToken</em>' reference.
	 * @see #setSToken(SToken)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSSpanRelation_SToken()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SToken getSToken();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SSpanRelation#getSToken <em>SToken</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SToken</em>' reference.
	 * @see #getSToken()
	 * @generated
	 */
	void setSToken(SToken value);

} // SCoverageRelation
