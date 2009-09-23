/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SDominance Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructure <em>SStructure</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructuredTarget <em>SStructured Target</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDominanceRelation()
 * @model
 * @generated
 */
public interface SDominanceRelation extends STextOverlappingRelation, STimeOverlappingRelation {
	/**
	 * Returns the value of the '<em><b>SStructure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStructure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStructure</em>' reference.
	 * @see #setSStructure(SStructure)
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDominanceRelation_SStructure()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SStructure getSStructure();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructure <em>SStructure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SStructure</em>' reference.
	 * @see #getSStructure()
	 * @generated
	 */
	void setSStructure(SStructure value);

	/**
	 * Returns the value of the '<em><b>SStructured Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStructured Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStructured Target</em>' reference.
	 * @see #setSStructuredTarget(SStructuredNode)
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDominanceRelation_SStructuredTarget()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SStructuredNode getSStructuredTarget();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructuredTarget <em>SStructured Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SStructured Target</em>' reference.
	 * @see #getSStructuredTarget()
	 * @generated
	 */
	void setSStructuredTarget(SStructuredNode value);

	/**
	 * Returns the value of the '<em><b>SDocument Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations <em>SDominance Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument Graph</em>' container reference.
	 * @see #setSDocumentGraph(SDocumentGraph)
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDominanceRelation_SDocumentGraph()
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations
	 * @model opposite="sDominanceRelations" volatile="true" derived="true"
	 * @generated
	 */
	SDocumentGraph getSDocumentGraph();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph <em>SDocument Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument Graph</em>' container reference.
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	void setSDocumentGraph(SDocumentGraph value);

} // SDominanceRelation
