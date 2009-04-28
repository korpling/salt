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
 * A representation of the model object '<em><b>SCorpus Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.SCorpusRelation#getSSuperCorpus <em>SSuper Corpus</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SCorpusRelation#getSSubCorpus <em>SSub Corpus</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSCorpusRelation()
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
	 * @see de.corpling.salt.model.salt.SaltPackage#getSCorpusRelation_SSuperCorpus()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SCorpus getSSuperCorpus();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SCorpusRelation#getSSuperCorpus <em>SSuper Corpus</em>}' reference.
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
	 * @see de.corpling.salt.model.salt.SaltPackage#getSCorpusRelation_SSubCorpus()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SCorpus getSSubCorpus();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SCorpusRelation#getSSubCorpus <em>SSub Corpus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSub Corpus</em>' reference.
	 * @see #getSSubCorpus()
	 * @generated
	 */
	void setSSubCorpus(SCorpus value);

} // SCorpusRelation
