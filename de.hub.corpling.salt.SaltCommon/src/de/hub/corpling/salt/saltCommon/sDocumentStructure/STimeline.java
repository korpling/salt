/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>STimeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSPointsOfTime <em>SPoints Of Time</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSTimeline()
 * @model
 * @generated
 */
public interface STimeline extends SSequentialDS {
	/**
	 * Returns the value of the '<em><b>SPoints Of Time</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SPoints Of Time</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SPoints Of Time</em>' attribute list.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSTimeline_SPointsOfTime()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<String> getSPointsOfTime();

	/**
	 * Returns the value of the '<em><b>SDocument Graph</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline <em>STimeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument Graph</em>' reference.
	 * @see #setSDocumentGraph(SDocumentGraph)
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSTimeline_SDocumentGraph()
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline
	 * @model opposite="sTimeline" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SDocumentGraph getSDocumentGraph();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph <em>SDocument Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument Graph</em>' reference.
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	void setSDocumentGraph(SDocumentGraph value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSPointOfTime(String sPointOfTime);

} // STimeline
