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
 * A representation of the model object '<em><b>SCorpus Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.SCorpusGraph#getSCorpora <em>SCorpora</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SCorpusGraph#getSDocuments <em>SDocuments</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SCorpusGraph#getSCorpusRelations <em>SCorpus Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSCorpusGraph()
 * @model
 * @generated
 */
public interface SCorpusGraph extends SGraph {
	/**
	 * Returns the value of the '<em><b>SCorpora</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.salt.SCorpus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpora</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpora</em>' containment reference list.
	 * @see de.corpling.salt.model.salt.SaltPackage#getSCorpusGraph_SCorpora()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SCorpus> getSCorpora();

	/**
	 * Returns the value of the '<em><b>SDocuments</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.salt.SDocument}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SDocument#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocuments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocuments</em>' containment reference list.
	 * @see de.corpling.salt.model.salt.SaltPackage#getSCorpusGraph_SDocuments()
	 * @see de.corpling.salt.model.salt.SDocument#getSCorpusGraph
	 * @model opposite="sCorpusGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SDocument> getSDocuments();

	/**
	 * Returns the value of the '<em><b>SCorpus Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.salt.SCorpusRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Relations</em>' containment reference list.
	 * @see de.corpling.salt.model.salt.SaltPackage#getSCorpusGraph_SCorpusRelations()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SCorpusRelation> getSCorpusRelations();

} // SCorpusGraph
