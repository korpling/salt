/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure;

import de.hub.corpling.salt.saltCommon.SaltProject;

import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SGraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCorpus Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments <em>SDocuments</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject <em>Salt Project</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora <em>SCorpora</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations <em>SCorpus Relations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations <em>SCorpus Document Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph()
 * @model
 * @generated
 */
public interface SCorpusGraph extends SGraph {
	/**
	 * Returns the value of the '<em><b>SDocuments</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocuments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocuments</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph_SDocuments()
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph
	 * @model opposite="sCorpusGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SDocument> getSDocuments();

	/**
	 * Returns the value of the '<em><b>Salt Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.SaltProject#getSCorpusGraphs <em>SCorpus Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Salt Project</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salt Project</em>' container reference.
	 * @see #setSaltProject(SaltProject)
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph_SaltProject()
	 * @see de.hub.corpling.salt.saltCommon.SaltProject#getSCorpusGraphs
	 * @model opposite="sCorpusGraphs" transient="false"
	 * @generated
	 */
	SaltProject getSaltProject();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject <em>Salt Project</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Salt Project</em>' container reference.
	 * @see #getSaltProject()
	 * @generated
	 */
	void setSaltProject(SaltProject value);

	/**
	 * Returns the value of the '<em><b>SCorpora</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpora</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpora</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph_SCorpora()
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph
	 * @model opposite="sCorpusGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SCorpus> getSCorpora();

	/**
	 * Returns the value of the '<em><b>SCorpus Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Relations</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph_SCorpusRelations()
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph
	 * @model opposite="sCorpusGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SCorpusRelation> getSCorpusRelations();

	/**
	 * Returns the value of the '<em><b>SCorpus Document Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Document Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Document Relations</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusGraph_SCorpusDocumentRelations()
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph
	 * @model opposite="sCorpusGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SCorpusDocumentRelation> getSCorpusDocumentRelations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SCorpus getSCorpus(SElementId sCorpusId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SDocument getSDocument(SElementId sDocumentId);

} // SCorpusGraph
