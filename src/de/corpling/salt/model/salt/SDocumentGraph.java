/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt;

import de.corpling.salt.model.saltCore.SGraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.SDocumentGraph#getSTokens <em>STokens</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SDocumentGraph#getSTextualRelations <em>STextual Relations</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SDocumentGraph#getSTextualDataSources <em>STextual Data Sources</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SDocumentGraph#getSStructures <em>SStructures</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SDocumentGraph#getSpanRelations <em>Span Relations</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SDocumentGraph#getSDocument <em>SDocument</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSDocumentGraph()
 * @model
 * @generated
 */
public interface SDocumentGraph extends SGraph {
	/**
	 * Returns the value of the '<em><b>STokens</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.salt.SToken}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SToken#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STokens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STokens</em>' containment reference list.
	 * @see de.corpling.salt.model.salt.SaltPackage#getSDocumentGraph_STokens()
	 * @see de.corpling.salt.model.salt.SToken#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SToken> getSTokens();

	/**
	 * Returns the value of the '<em><b>STextual Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.salt.STextualRelation}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.STextualRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STextual Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STextual Relations</em>' containment reference list.
	 * @see de.corpling.salt.model.salt.SaltPackage#getSDocumentGraph_STextualRelations()
	 * @see de.corpling.salt.model.salt.STextualRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<STextualRelation> getSTextualRelations();

	/**
	 * Returns the value of the '<em><b>STextual Data Sources</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.salt.STextualDataSource}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.STextualDataSource#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STextual Data Sources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STextual Data Sources</em>' containment reference list.
	 * @see de.corpling.salt.model.salt.SaltPackage#getSDocumentGraph_STextualDataSources()
	 * @see de.corpling.salt.model.salt.STextualDataSource#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<STextualDataSource> getSTextualDataSources();

	/**
	 * Returns the value of the '<em><b>SStructures</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.salt.SStructure}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SStructure#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStructures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStructures</em>' containment reference list.
	 * @see de.corpling.salt.model.salt.SaltPackage#getSDocumentGraph_SStructures()
	 * @see de.corpling.salt.model.salt.SStructure#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SStructure> getSStructures();

	/**
	 * Returns the value of the '<em><b>Span Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.salt.SSpanRelation}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SSpanRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Span Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Span Relations</em>' containment reference list.
	 * @see de.corpling.salt.model.salt.SaltPackage#getSDocumentGraph_SpanRelations()
	 * @see de.corpling.salt.model.salt.SSpanRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SSpanRelation> getSpanRelations();

	/**
	 * Returns the value of the '<em><b>SDocument</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SDocument#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument</em>' container reference.
	 * @see #setSDocument(SDocument)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSDocumentGraph_SDocument()
	 * @see de.corpling.salt.model.salt.SDocument#getSDocumentGraph
	 * @model opposite="sDocumentGraph" transient="false"
	 * @generated
	 */
	SDocument getSDocument();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SDocumentGraph#getSDocument <em>SDocument</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument</em>' container reference.
	 * @see #getSDocument()
	 * @generated
	 */
	void setSDocument(SDocument value);

} // SDocumentGraph
