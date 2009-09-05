/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Salt Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.SaltProject#getSCorpusGraphs <em>SCorpus Graphs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCommon.SaltCommonPackage#getSaltProject()
 * @model
 * @generated
 */
public interface SaltProject extends EObject {
	/**
	 * Returns the value of the '<em><b>SCorpus Graphs</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject <em>Salt Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Graphs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Graphs</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCommon.SaltCommonPackage#getSaltProject_SCorpusGraphs()
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject
	 * @model opposite="saltProject" containment="true"
	 * @generated
	 */
	EList<SCorpusGraph> getSCorpusGraphs();

} // SaltProject
