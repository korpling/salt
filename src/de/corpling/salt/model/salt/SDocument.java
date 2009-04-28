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
 * A representation of the model object '<em><b>SDocument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.SDocument#getSDocumentGraph <em>SDocument Graph</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SDocument#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSDocument()
 * @model
 * @generated
 */
public interface SDocument extends SElement {

	/**
	 * Returns the value of the '<em><b>SDocument Graph</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SDocumentGraph#getSDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument Graph</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument Graph</em>' containment reference.
	 * @see #setSDocumentGraph(SDocumentGraph)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSDocument_SDocumentGraph()
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSDocument
	 * @model opposite="sDocument" containment="true" required="true"
	 * @generated
	 */
	SDocumentGraph getSDocumentGraph();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SDocument#getSDocumentGraph <em>SDocument Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument Graph</em>' containment reference.
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	void setSDocumentGraph(SDocumentGraph value);

	/**
	 * Returns the value of the '<em><b>SCorpus Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SCorpusGraph#getSDocuments <em>SDocuments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Graph</em>' container reference.
	 * @see #setSCorpusGraph(SCorpusGraph)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSDocument_SCorpusGraph()
	 * @see de.corpling.salt.model.salt.SCorpusGraph#getSDocuments
	 * @model opposite="sDocuments" volatile="true" derived="true"
	 * @generated
	 */
	SCorpusGraph getSCorpusGraph();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SDocument#getSCorpusGraph <em>SCorpus Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SCorpus Graph</em>' container reference.
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	void setSCorpusGraph(SCorpusGraph value);
} // SDocument
