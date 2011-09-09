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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument <em>SDocument</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs <em>STextual DSs</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations <em>STextual Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens <em>STokens</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline <em>STimeline</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations <em>STimeline Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations <em>SSpanning Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans <em>SSpans</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructures <em>SStructures</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations <em>SDominance Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSPointingRelations <em>SPointing Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph()
 * @model
 * @generated
 */
public interface SDocumentGraph extends SGraph {
	/**
	 * Returns the value of the '<em><b>SDocument</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDocument</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDocument</em>' reference.
	 * @see #setSDocument(SDocument)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SDocument()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph
	 * @model opposite="sDocumentGraph"
	 * @generated
	 */
	SDocument getSDocument();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument <em>SDocument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDocument</em>' reference.
	 * @see #getSDocument()
	 * @generated
	 */
	void setSDocument(SDocument value);

	/**
	 * Returns the value of the '<em><b>STextual DSs</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STextual DSs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STextual DSs</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STextualDSs()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<STextualDS> getSTextualDSs();

	/**
	 * Returns the value of the '<em><b>STextual Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STextual Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STextual Relations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STextualRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<STextualRelation> getSTextualRelations();

	/**
	 * Returns the value of the '<em><b>STokens</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STokens</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STokens</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STokens()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SToken> getSTokens();

	/**
	 * Returns the value of the '<em><b>STimeline</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STimeline</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STimeline</em>' reference.
	 * @see #setSTimeline(STimeline)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STimeline()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph
	 * @model opposite="sDocumentGraph" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	STimeline getSTimeline();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline <em>STimeline</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>STimeline</em>' reference.
	 * @see #getSTimeline()
	 * @generated
	 */
	void setSTimeline(STimeline value);

	/**
	 * Returns the value of the '<em><b>STimeline Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STimeline Relations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STimeline Relations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STimelineRelations()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<STimelineRelation> getSTimelineRelations();

	/**
	 * Returns the value of the '<em><b>SSpanning Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSpanning Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSpanning Relations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SSpanningRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SSpanningRelation> getSSpanningRelations();

	/**
	 * Returns the value of the '<em><b>SSpans</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSpans</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSpans</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SSpans()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SSpan> getSSpans();

	/**
	 * Returns the value of the '<em><b>SStructures</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStructures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStructures</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SStructures()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SStructure> getSStructures();

	/**
	 * Returns the value of the '<em><b>SDominance Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDominance Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDominance Relations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SDominanceRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SDominanceRelation> getSDominanceRelations();

	/**
	 * Returns the value of the '<em><b>SPointing Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SPointing Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SPointing Relations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SPointingRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true"
	 * @generated
	 */
	EList<SPointingRelation> getSPointingRelations();

	/**
	 * Creates and returns a '<em><b>SRelation</b></em>' of the type given by sRelationType between sourceSNode and targetSNode.
	 * Note that the sourceSNode is required to be in the SDocumentGraph already and that the sRelationType may
	 * only be one of STEXTUAL_RELATION, SSPANNING_RELATION, SDOMINANCE_RELATION and SPOINTING_RELATION.
 	 * 
	 * @param de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode 
	 * @param de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode
	 * @param STYPE_NAME
	 * @return de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation
	 * @model
	 * @generated
	 */
	SRelation addSNode(SNode sourceSNode, SNode targetSNode, STYPE_NAME sRelationType);

	void basicSetSElementId(); 
	
	
	
	
	
} // SDocumentGraph
