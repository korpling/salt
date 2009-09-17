/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;

import de.hub.corpling.salt.saltCore.SGraph;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument <em>SDocument</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs <em>STextual DSs</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations <em>STextual Relations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens <em>STokens</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline <em>STimeline</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph()
 * @model
 * @generated
 */
public interface SDocumentGraph extends SGraph {
	/**
	 * Returns the value of the '<em><b>SDocument</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument</em>' reference.
	 * @see #setSDocument(SDocument)
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SDocument()
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph
	 * @model opposite="sDocumentGraph"
	 * @generated
	 */
	SDocument getSDocument();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument <em>SDocument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument</em>' reference.
	 * @see #getSDocument()
	 * @generated
	 */
	void setSDocument(SDocument value);

	/**
	 * Returns the value of the '<em><b>STextual DSs</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STextual DSs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STextual DSs</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STextualDSs()
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<STextualDS> getSTextualDSs();

	/**
	 * Returns the value of the '<em><b>STextual Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STextual Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STextual Relations</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STextualRelations()
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<STextualRelation> getSTextualRelations();

	/**
	 * Returns the value of the '<em><b>STokens</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STokens</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STokens</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STokens()
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SToken> getSTokens();

	/**
	 * Returns the value of the '<em><b>STimeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STimeline</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STimeline</em>' reference.
	 * @see #setSTimeline(STimeline)
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STimeline()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	STimeline getSTimeline();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline <em>STimeline</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>STimeline</em>' reference.
	 * @see #getSTimeline()
	 * @generated
	 */
	void setSTimeline(STimeline value);

} // SDocumentGraph
