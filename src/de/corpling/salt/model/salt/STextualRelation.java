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
 * A representation of the model object '<em><b>STextual Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.STextualRelation#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.STextualRelation#getSTextualDataSource <em>STextual Data Source</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.STextualRelation#getSLeftPos <em>SLeft Pos</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.STextualRelation#getSRightPos <em>SRight Pos</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.STextualRelation#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSTextualRelation()
 * @model
 * @generated
 */
public interface STextualRelation extends SRelation {
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
	 * @see de.corpling.salt.model.salt.SaltPackage#getSTextualRelation_SToken()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SToken getSToken();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.STextualRelation#getSToken <em>SToken</em>}' reference.
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
	 * @see de.corpling.salt.model.salt.SaltPackage#getSTextualRelation_STextualDataSource()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	STextualDataSource getSTextualDataSource();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.STextualRelation#getSTextualDataSource <em>STextual Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>STextual Data Source</em>' reference.
	 * @see #getSTextualDataSource()
	 * @generated
	 */
	void setSTextualDataSource(STextualDataSource value);

	/**
	 * Returns the value of the '<em><b>SLeft Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SLeft Pos</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SLeft Pos</em>' attribute.
	 * @see #setSLeftPos(Long)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSTextualRelation_SLeftPos()
	 * @model volatile="true" derived="true"
	 * @generated
	 */
	Long getSLeftPos();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.STextualRelation#getSLeftPos <em>SLeft Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SLeft Pos</em>' attribute.
	 * @see #getSLeftPos()
	 * @generated
	 */
	void setSLeftPos(Long value);

	/**
	 * Returns the value of the '<em><b>SRight Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SRight Pos</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SRight Pos</em>' attribute.
	 * @see #setSRightPos(Long)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSTextualRelation_SRightPos()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Long getSRightPos();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.STextualRelation#getSRightPos <em>SRight Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SRight Pos</em>' attribute.
	 * @see #getSRightPos()
	 * @generated
	 */
	void setSRightPos(Long value);

	/**
	 * Returns the value of the '<em><b>SDocument Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SDocumentGraph#getSTextualRelations <em>STextual Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument Graph</em>' container reference.
	 * @see #setSDocumentGraph(SDocumentGraph)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSTextualRelation_SDocumentGraph()
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSTextualRelations
	 * @model opposite="sTextualRelations" volatile="true" derived="true"
	 * @generated
	 */
	SDocumentGraph getSDocumentGraph();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.STextualRelation#getSDocumentGraph <em>SDocument Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument Graph</em>' container reference.
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	void setSDocumentGraph(SDocumentGraph value);

} // STextualRelation
