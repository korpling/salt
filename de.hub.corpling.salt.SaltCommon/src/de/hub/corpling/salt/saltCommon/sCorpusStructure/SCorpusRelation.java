/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure;

import de.hub.corpling.salt.saltCore.SRelation;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCorpus Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSuperCorpus <em>SSuper Corpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSubCorpus <em>SSub Corpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusRelation()
 * @model
 * @generated
 */
public interface SCorpusRelation extends SRelation {
	/**
	 * Returns the value of the '<em><b>SSuper Corpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSuper Corpus</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSuper Corpus</em>' reference.
	 * @see #setSSuperCorpus(SCorpus)
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusRelation_SSuperCorpus()
	 * @model
	 * @generated
	 */
	SCorpus getSSuperCorpus();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSuperCorpus <em>SSuper Corpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSuper Corpus</em>' reference.
	 * @see #getSSuperCorpus()
	 * @generated
	 */
	void setSSuperCorpus(SCorpus value);

	/**
	 * Returns the value of the '<em><b>SSub Corpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSub Corpus</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSub Corpus</em>' reference.
	 * @see #setSSubCorpus(SCorpus)
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusRelation_SSubCorpus()
	 * @model
	 * @generated
	 */
	SCorpus getSSubCorpus();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSubCorpus <em>SSub Corpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSub Corpus</em>' reference.
	 * @see #getSSubCorpus()
	 * @generated
	 */
	void setSSubCorpus(SCorpus value);

	/**
	 * Returns the value of the '<em><b>SCorpus Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations <em>SCorpus Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCorpus Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCorpus Graph</em>' container reference.
	 * @see #setSCorpusGraph(SCorpusGraph)
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#getSCorpusRelation_SCorpusGraph()
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations
	 * @model opposite="sCorpusRelations" transient="false"
	 * @generated
	 */
	SCorpusGraph getSCorpusGraph();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph <em>SCorpus Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SCorpus Graph</em>' container reference.
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	void setSCorpusGraph(SCorpusGraph value);

} // SCorpusRelation
