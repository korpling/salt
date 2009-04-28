/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt;

import de.corpling.salt.model.saltCore.SCoreProject;
import de.corpling.salt.model.saltCore.SStereotype;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SProject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.SProject#getSCorpusGraphs <em>SCorpus Graphs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSProject()
 * @model
 * @generated
 */
public interface SProject extends SCoreProject {

	/**
	 * Returns the value of the '<em><b>SCorpus Graphs</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.salt.SCorpusGraph}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Graphs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Graphs</em>' containment reference list.
	 * @see de.corpling.salt.model.salt.SaltPackage#getSProject_SCorpusGraphs()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SCorpusGraph> getSCorpusGraphs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SStereotype getSStereotypeByEnum(SSTEREOTYPES sStereotypeEnum);

} // SProject
