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
 * A representation of the model object '<em><b>Textual Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.TextualRelation#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.TextualRelation#getSTextualDataSource <em>STextual Data Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getTextualRelation()
 * @model
 * @generated
 */
public interface TextualRelation extends SRelation {
	/**
	 * Returns the value of the '<em><b>SToken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SToken</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SToken</em>' reference.
	 * @see #setSToken(SToken)
	 * @see de.corpling.salt.model.salt.SaltPackage#getTextualRelation_SToken()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SToken getSToken();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.TextualRelation#getSToken <em>SToken</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SToken</em>' reference.
	 * @see #getSToken()
	 * @generated
	 */
	void setSToken(SToken value);

	/**
	 * Returns the value of the '<em><b>STextual Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STextual Data Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STextual Data Source</em>' reference.
	 * @see #setSTextualDataSource(STextualDataSource)
	 * @see de.corpling.salt.model.salt.SaltPackage#getTextualRelation_STextualDataSource()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	STextualDataSource getSTextualDataSource();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.TextualRelation#getSTextualDataSource <em>STextual Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>STextual Data Source</em>' reference.
	 * @see #getSTextualDataSource()
	 * @generated
	 */
	void setSTextualDataSource(STextualDataSource value);

} // TextualRelation
