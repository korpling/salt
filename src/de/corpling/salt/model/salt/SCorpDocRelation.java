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
 * A representation of the model object '<em><b>SCorp Doc Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.SCorpDocRelation#getSCorpus <em>SCorpus</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.SCorpDocRelation#getSDocument <em>SDocument</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSCorpDocRelation()
 * @model
 * @generated
 */
public interface SCorpDocRelation extends SRelation {
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
	 * @see de.corpling.salt.model.salt.SaltPackage#getSCorpDocRelation_SCorpus()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SCorpus getSCorpus();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SCorpDocRelation#getSCorpus <em>SCorpus</em>}' reference.
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
	 * @see de.corpling.salt.model.salt.SaltPackage#getSCorpDocRelation_SDocument()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SDocument getSDocument();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SCorpDocRelation#getSDocument <em>SDocument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument</em>' reference.
	 * @see #getSDocument()
	 * @generated
	 */
	void setSDocument(SDocument value);

} // SCorpDocRelation
