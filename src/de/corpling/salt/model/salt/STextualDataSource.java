/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>STextual Data Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.STextualDataSource#getSText <em>SText</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.STextualDataSource#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSTextualDataSource()
 * @model
 * @generated
 */
public interface STextualDataSource extends SDataSource {
	/**
	 * Returns the value of the '<em><b>SText</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SText</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SText</em>' attribute.
	 * @see #setSText(String)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSTextualDataSource_SText()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getSText();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.STextualDataSource#getSText <em>SText</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SText</em>' attribute.
	 * @see #getSText()
	 * @generated
	 */
	void setSText(String value);

	/**
	 * Returns the value of the '<em><b>SDocument Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.salt.SDocumentGraph#getSTextualDataSources <em>STextual Data Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument Graph</em>' container reference.
	 * @see #setSDocumentGraph(SDocumentGraph)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSTextualDataSource_SDocumentGraph()
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSTextualDataSources
	 * @model opposite="sTextualDataSources" volatile="true" derived="true"
	 * @generated
	 */
	SDocumentGraph getSDocumentGraph();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.STextualDataSource#getSDocumentGraph <em>SDocument Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument Graph</em>' container reference.
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	void setSDocumentGraph(SDocumentGraph value);

} // STextualDataSource
