/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure;

import de.hub.corpling.salt.saltCore.SRelation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCorpus Document Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus <em>SCorpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument <em>SDocument</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusDocumentRelation()
 * @model
 * @generated
 */
public interface SCorpusDocumentRelation extends SRelation {
	/**
	 * Returns the value of the '<em><b>SCorpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus</em>' reference.
	 * @see #setSCorpus(SCorpus)
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusDocumentRelation_SCorpus()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SCorpus getSCorpus();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus <em>SCorpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SCorpus</em>' reference.
	 * @see #getSCorpus()
	 * @generated
	 */
	void setSCorpus(SCorpus value);

	/**
	 * Returns the value of the '<em><b>SDocument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument</em>' reference.
	 * @see #setSDocument(SDocument)
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusDocumentRelation_SDocument()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SDocument getSDocument();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument <em>SDocument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument</em>' reference.
	 * @see #getSDocument()
	 * @generated
	 */
	void setSDocument(SDocument value);

	/**
	 * Returns the value of the '<em><b>SCorpus Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations <em>SCorpus Document Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Graph</em>' container reference.
	 * @see #setSCorpusGraph(SCorpusGraph)
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusDocumentRelation_SCorpusGraph()
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations
	 * @model opposite="sCorpusDocumentRelations" volatile="true" derived="true"
	 * @generated
	 */
	SCorpusGraph getSCorpusGraph();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph <em>SCorpus Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SCorpus Graph</em>' container reference.
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	void setSCorpusGraph(SCorpusGraph value);

} // SCorpusDocumentRelation
