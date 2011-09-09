/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltImproperSTypeException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SSpanning Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSSpan <em>SSpan</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSpanningRelation()
 * @model
 * @generated
 */
public interface SSpanningRelation extends SRelation, STextOverlappingRelation, STimeOverlappingRelation {
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
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSpanningRelation_SToken()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SToken getSToken();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSToken <em>SToken</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SToken</em>' reference.
	 * @see #getSToken()
	 * @generated
	 */
	void setSToken(SToken value);

	/**
	 * Checks if the given parameter is an instance of SSpan. If so, {@link #setSSpan(SSpan)} is called, otherwise an exception is thrown.
	 * @throws SaltImproperSTypeException
	 * @param SNode the source Node (must be SSpan)
	 */
	@Override
	void setSSource(SNode sSource);
	
	/**
	 * Checks if the given parameter is an instance of SToken. If so, {@link #setSToken(SToken)} is called, otherwise an exception is thrown.
	 * @throws SaltImproperSTypeException
	 * @param SNode the target Node (must be SToken)
	 */
	@Override
	void setSTarget(SNode sTarget);
	
	/**
	 * Returns the value of the '<em><b>SSpan</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSpan</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSpan</em>' reference.
	 * @see #setSSpan(SSpan)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSpanningRelation_SSpan()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SSpan getSSpan();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSSpan <em>SSpan</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSpan</em>' reference.
	 * @see #getSSpan()
	 * @generated
	 */
	void setSSpan(SSpan value);

	/**
	 * Returns the value of the '<em><b>SDocument Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations <em>SSpanning Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument Graph</em>' container reference.
	 * @see #setSDocumentGraph(SDocumentGraph)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSSpanningRelation_SDocumentGraph()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations
	 * @model opposite="sSpanningRelations" volatile="true"
	 * @generated
	 */
	SDocumentGraph getSDocumentGraph();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph <em>SDocument Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument Graph</em>' container reference.
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	void setSDocumentGraph(SDocumentGraph value);

} // SSpanningRelation
