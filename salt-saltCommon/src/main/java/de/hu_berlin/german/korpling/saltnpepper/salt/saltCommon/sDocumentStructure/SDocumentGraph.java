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

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SFEATURE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tokenizer.Tokenizer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

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
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDSRelations <em>SAudio DS Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDataSources <em>SAudio Data Sources</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSOrderRelations <em>SOrder Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph()
 * @model
 * @generated
 */
public interface SDocumentGraph extends SGraph {
	/**
	 * name of index for node-types
	 */
	public static final String IDX_SNODETYPE=	"idx_sNodeType";
	/**
	 * name of index for relation-types
	 */
	public static final String IDX_SRELATIONTYPE=	"idx_sRelationType";
	
	/**
	 * Returns the {@link SDocument} object containing this graph object. The {@link SDocument}
	 * object is linked via a {@link SFeature} object having the namespace {@value SaltFactory#NAMESPACE_SALT} and
	 * the name {@value SFEATURE_NAME#SDOCUMENT}.
	 * @return the value of the '<em>SDocument</em>' reference.
	 * @see #setSDocument(SDocument)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SDocument()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph
	 * @model opposite="sDocumentGraph" resolveProxies="false" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SDocument getSDocument();

	/**
	 * Sets the {@link SDocument} object as a container for this graph. The given {@link SDocument}
	 * object is linked via a {@link SFeature} object having the namespace {@value SaltFactory#NAMESPACE_SALT} and
	 * the name {@value SFEATURE_NAME#SDOCUMENT}.
	 * @param value the new value of the '<em>SDocument Graph</em>' reference.
	 * @see #getSDocumentGraph()
	 * @generated
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
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STimeline Relations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STimeline Relations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STimelineRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
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
	 * Returns the value of the '<em><b>SAudio DS Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAudio DS Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SAudio DS Relations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SAudioDSRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SAudioDSRelation> getSAudioDSRelations();

	/**
	 * Returns the value of the '<em><b>SAudio Data Sources</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAudio Data Sources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SAudio Data Sources</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SAudioDataSources()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SAudioDataSource> getSAudioDataSources();

	/**
	 * Returns the value of the '<em><b>SOrder Relations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SOrder Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SOrder Relations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SOrderRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SOrderRelation> getSOrderRelations();

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

		/**
	 * Creates and adds a new {@link STextualDS} node object and sets its text to the passed one and adds it to the graph. 
	 * @param the text which shall be the primary text and be added to the created {@link STextualDS} node
	 * @return the created {@link STextualDS} node which has been created
	 * 
	 * @model
	 */
	STextualDS createSTextualDS(String sText);

	/**
	 * Creates a new {@link SToken} object and adds it to the graph. The {@link SToken} object will be
	 * connected with the {@link SSequentialDS} object given in the passed {@link SDataSourceSequence} object.
	 * The created relations get the borders also given in the {@link SDataSourceSequence} object.
	 * @model sDSSequencesMany="true"
	 * @generated
	 */
	SToken createSToken(EList<SDataSourceSequence> sDSSequences);

	/**
	 * Creates a new {@link SToken} object and adds it to the graph. The {@link SToken} object will be
	 * connected with the {@link SSequentialDS} objects given in the passed {@link SDataSourceSequence} object.
	 * The created relations get the borders also given in the {@link SDataSourceSequence} object.
	 * @model
	 * @generated
	 */
	SToken createSToken(SDataSourceSequence sDSSequence);

	/**
	 * Creates a new {@link SSpan} object, adds it to the graph and returns the new object. Further, this method creates
	 * a {@link SSpanningRelation} object and sets its source to the created {@link SSpan} object and the target to the
	 * given source node. 
	 * @param sourceSToken source {@link SToken} node to which the {@link SSpanningRelation} relation points to
	 * @return the created {@link SSpan} node
	 * @model
	 * @generated
	 */
	SSpan createSSpan(SToken sourceSToken);

	/**
	 * Creates a {@link SSpan} object, adds it to the graph and returns the new object. Further, this method creates
	 * {@link SSpanningRelation} relations and sets their source to the created {@link SSpan} object and the targets to the
	 * given source nodes. 
	 * @param sourceSToken source {@link SToken} node to which the {@link SSpanningRelation} relation points to
	 * @return the created {@link SSpan} node
	 * @model sTokensMany="true"
	 * @generated
	 */
	SSpan createSSpan(EList<SToken> sTokens);

	/**
	 * Creates a new {@link SStructure} object, adds it to the graph and returns the new object. Further, this method creates
	 * a {@link SDominanceRelation} object and sets its source to the created {@link SStructure} object and the target to the
	 * given source node. 
	 * @param sourceSToken source {@link SStructuredNode} node to which the {@link SDominanceRelation} relation points to
	 * @return {@link SStructure} node
	 * @model
	 * @generated
	 */
	SStructure createSStructure(SStructuredNode sourceSNode);

	/**
	 * Creates a new {@link SStructure} object, adds it to the graph and returns the new object. Further, this method creates
	 * {@link SDominanceRelation} relations and sets their sources to the created {@link SStructure} object and the targets to the
	 * given source nodes. 
	 * @param sourceSToken source {@link SStructuredNode} node to which the {@link SDominanceRelation} relation points to
	 * @return {@link SStructure} node
	 * @model sStructuresMany="true"
	 * @generated
	 */
	SStructure createSStructure(EList<SStructuredNode> sStructures);
	/**
	 * Creates an {@link STimeline} object being contained in this {@link SDocumentGraph} object. The new {@link STimeline} object
	 * is filled with points of time computed out of the {@link STextualRelation} objects being contained by this {@link SDocumentGraph} object.
	 * For each {@link STextualDS} object, for each {@link STextualRelation} object one point of time would be created. If this object already contains
	 * a not empty {@link STimeline} object the already existing one would be returned.
	 * @return returns a new created and automatically filled {@link STimeline} object if no one exists yet 
	 * @model
	 * @generated
	 */
	STimeline createSTimeline();

	/**
	 * Returns all {@link SToken} objects which refer to the passed {@link SDataSourceSequence} object. The passed object
	 * determines the borders of the sequence by the values <em>sStart</em> and <em>sEnd</em> and the type of
	 * datasource by the instance <em>sSequentialDS</em>.
	 * @param sDataSourceSequence an object determing the sequence to which the returned {@link SToken} objects refer to. 
	 * @return a list of {@link SToken} objects which refer or overlap the passed sequence 
	 * @model
	 */
	EList<SToken> getSTokensBySequence(SDataSourceSequence sequence);

	/**
	 * Returns all {@link SSpan} objects which refer to the passed {@link SDataSourceSequence} object. The passed object
	 * determines the borders of the sequence by the values <em>sStart</em> and <em>sEnd</em> and the type of
	 * datasource by the instance <em>sSequentialDS</em>.
	 * @param sDataSourceSequence an object determing the sequence to which the returned {@link SSpan} objects refer to. 
	 * @return a list of {@link SSpan} objects which refer or overlap the passed sequence 
	 * @model
	 */
	EList<SSpan> getSSpanBySequence(SDataSourceSequence sequence);
	
	/**
	 * Returns all {@link SStructure} objects which refer to the passed {@link SDataSourceSequence} object. The passed object
	 * determines the borders of the sequence by the values <em>sStart</em> and <em>sEnd</em> and the type of
	 * datasource by the instance <em>sSequentialDS</em>.
	 * @param sDataSourceSequence an object determing the sequence to which the returned {@link SStructure} objects refer to. 
	 * @return a list of {@link SStructure} objects which refer or overlap the passed sequence 
	 * @model
	 */
	EList<SStructure> getSStructureBySequence(SDataSourceSequence sequence);

	/**
	 * Returns all {@link SNode} objects which refer to the passed {@link SDataSourceSequence} object. The passed object
	 * determines the borders of the sequence by the values <em>sStart</em> and <em>sEnd</em> and the type of
	 * datasource by the instance <em>sSequentialDS</em>.
	 * @param sDataSourceSequence an object determing the sequence to which the returned {@link SNode} objects refer to. 
	 * @return a list of {@link SNode} objects which refer or overlap the passed sequence 
	 * @model
	 */
	EList<SNode> getSNodeBySequence(SDataSourceSequence sequence);

	/**
	 * Returns the sequences as {@link SDataSourceSequence} which are overlapped by the given {@link SNode} node. Overlapped
	 * means, that starting from the given {@link SNode} node the {@link SSequentialDS} can reached by traversing relations
	 * of onne of the types contained in the given list of {@link STYPE_NAME}.
	 * @param sNode node to start from
	 * @param sRelationTypes a list of relation types, which are traversed
	 * @return the overlapped {@link SDataSourceSequence} objects 
	 * @model sRelationTypesMany="true"
	 * @generated
	 */
	EList<SDataSourceSequence> getOverlappedDSSequences(SNode sNode, EList<STYPE_NAME> sRelationTypes);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sNodeMany="true" sRelationTypesMany="true"
	 * @generated
	 */
	EList<SDataSourceSequence> getOverlappedDSSequences(EList<SNode> sNode, EList<STYPE_NAME> sRelationTypes);

	/**
	 * Returns true, if the given list of nodes <em>subSNodeList</em> is continuous respecting the overlapped text. A list of nodes
	 * is continuous, if there is no other node overlapping a text sequence, which is a subsequence of the
	 * sequence overlapped by the given list and is not part of the list. 
	 * @param subSNodeList list to check against fullSNodeList
	 * @param fullSNodeList list which contains all nodes in correct order
	 * @return true, if list is continuous
	 * @model subSNodeListMany="true" fullSNodeListMany="true"
	 */
	boolean isContinuousByText(EList<SNode> subSNodeList, EList<SNode> fullSNodeList);

	/**
	 * Returns true, if the given list of nodes <em>subSNodeList</em> is continuous respecting the overlapped text. A list of nodes
	 * is continuous, if there is no other node overlapping a text sequence, which is a subsequence of the
	 * sequence overlapped by the given list and is not part of the list.
	 * The fullSNodeList is given by the token list of this graph.
	 * @param subSNodeList list to check against fullSNodeList
	 * @param fullSNodeList list which contains all nodes in correct order
	 * @return true, if list is continuous
	 * @model subSNodeListMany="true"
	 * @generated
	 */
	boolean isContinuousByText(EList<SNode> subSNodeList);

	/**
	 * Returns all {@link SToken} objects being contained in the given list and sorts them by the {@link STextualRelation#getSStart()} 
	 * value of {@link SToken} object.
	 * @param sTokens2sort the list of {@link SToken} objects to sort
	 * @return list of tokens in order of left text position
	 * @model sTokens2sortMany="true"
	 * @generated
	 */
	EList<SToken> getSortedSTokenByText(EList<SToken> sTokens2sort);

	/**
	 * Returns all {@link SToken} objects being contained in the list {@link SDocumentGraph#getSTokens()} and sorts them by the {@link STextualRelation#getSStart()} 
	 * value of {@link SToken} object.
	 * @return list of tokens in order of left text position
	 * @model kind="operation"
	 * @generated
	 */
	EList<SToken> getSortedSTokenByText();

	/**
	 * Sorts all {@link SToken} and {@link STextualRelation} objects being contained in the list {@link SDocumentGraph#getSTokens()} and {@link SDocumentGraph#getSTextualRelations()} by the {@link STextualRelation#getSStart()} 
	 * value of {@link SToken} and {@link STextualRelation} object.
	 * @model
	 * @generated
	 */
	void sortSTokenByText();

	/**
	 * Returns all SNode objects which are roots for the given SRelation Subtype. Means, that all SNode-objects
	 * will be returned as roots, which have no incoming SRelation-objects of the given subtype clazz. 
	 * <br/>
	 * Attention: Only  the subtypes SPointingRelation, SSpanningRelation and SDominanceRelation 
	 * are supported yet.
	 * <br/>
	 * @param sType type, which shall be used for computing roots
	 * @return a list of SNode-objects which are roots 
	 * @model
	 * @generated
	 */
	EList<SNode> getRootsBySRelation(STYPE_NAME sType);

	/**
	 * Returns all nodes, which are roots for the given relation-class respects to the given SType of the traversed
	 * relation. The following example shows the different to the method getRootsBySRelation():
	 * Imagine the following graphFor example: node1 ->t1 node2, node2 ->t2-> node3.
	 * Also imagine, that -> is a relation of same class with sType=t1 respectivly sType=t2
	 * The returned roots will be node1 and node 2, because of node1 is the root of a subgraph for 
	 * relation.sType=t1 and node2 is the root of the subgraph for relation.sType=t2. Whereas the returned 
	 * nodes of getRootsBySRelation() is only node1. 
	 * @param sType type, which shall be used for computing roots
	 * @return a map of types, with corresponding lists of root nodes
	 * @model keyType="java.lang.String" valueType="java.lang.String"
	 */
	Map<String, EList<SNode>> getRootsBySRelationSType(STYPE_NAME sType);
	

	/**
	 * Creates a new {@link SToken} object and adds it to the graph. The {@link SToken} object will be
	 * connected with the given {@link SSequentialDS} object. The created relation get the passed positions.
	 * @model
	 * @generated
	 */
	SToken createSToken(SSequentialDS sSequentialDS, Integer sStart, Integer sEnd);

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tokenizes all {@link STextualDS} object being contained in this {@link SDocumentGraph} object. The Tokenization is similar to the tokenization made by the TreeTagger tokenizer. This method calls the method {@link #createTokenizer()} and initilizes with automatic detected values. The language will be detected automatically for each {@link STextualDS} object by use of the {@link TextCategorizer} (see: <a href="http://textcat.sourceforge.net/doc/org/knallgrau/utils/textcat/TextCategorizer.html">http://textcat.sourceforge.net/doc/org/knallgrau/utils/textcat/TextCategorizer.html</a>). If the language is one of the given ones: english, french, italian and german, abbreviations also taken from the Treetagger will be used.
	 * To customize these settings use the method {@link #createTokenizer()}.
	 * 
	 * The used Treetagger is a reimplementation in Java with permission from the original TreeTagger tokenizer in Perl by Helmut Schmid (see: <a href="http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/">http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/</a>).
	 * For each token detected in the text given by <code>sTextualDS.getSText()</code> an {@link SToken} object is created and linked with the {@link STextualDS} object via a new {@link STextualRelation} object containing the textual offset.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	EList<SToken> tokenize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates a new {@link Tokenizer} object to tokenize the set {@link STextualDS} objects being contained in this {@link SDocumentGraph} object. To customize the tokenization, set take a look to the properties of the returned {@link Tokenizer} object. This method is used by the method {@link #tokenize()}.
	 * The used Treetagger is a reimplementation in Java with permission from the original TreeTagger tokenizer in Perl by Helmut Schmid (see: <a href="http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/">http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/</a>).
	 * For each token detected in the text given by <code>sTextualDS.getSText()</code> an {@link SToken} object is created and linked with the {@link STextualDS} object via a new {@link STextualRelation} object containing the textual offset. 
	 * If the set {@link STextualDS} object is empty or if it does not belong to this {@link SDocumentGraph} object an exception is thrown. 
	 * <!-- end-model-doc -->
	 * @model dataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.Tokenizer"
	 * @generated
	 */
	Tokenizer createTokenizer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Inserts a token to the graph starting at position 
	 * <em>posInText</em> and relates them to the given {@link STextualDS} object.<br/>
	 * An example:<br/>
	 * Imagine the following sText and tokenization 
	 * <pre>
	 * tok1  tok2  tok3  tok4
	 * This  is    a     text.
	 * </pre>
	 * the call insertSTokensAt(sTextualDS, 5, "additional", true);<br/>
	 * results in <br/>
	 * <pre>
	 * tok1  tok5        tok2  tok3  tok4
	 * This  additional  is    a     text.
	 * </pre>
	 * @param sTextualDS the {@link STextualDS} object to which the new tokens should be related to. Make sure, that stextualDS is already contained in the {@link SDocumentGraph}
	 * @param posInText textual position where to add the new tokens.
	 * @param text text value, the new token should cover
	 * @param insertSpace if true, a blank after each new text is inserted
	 * @return new created token
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	SToken insertSTokenAt(STextualDS sTextualDS, Integer posInText, String text, Boolean insertSpace);

	/**
	 * Inserts n tokens (where n is the size of the given list <em>texts</em>) to the graph starting at position 
	 * <em>posInText</em> and relates them to the given {@link STextualDS} object.<br/>
	 * An example:<br/>
	 * Imagine the following sText and tokenization 
	 * <pre>
	 * tok1  tok2  tok3  tok4
	 * This  is    a     text.
	 * </pre>
	 * the call insertSTokensAt(sTextualDS, 5, {"additional" "text"}, true);<br/>
	 * results in <br/>
	 * <pre>
	 * tok1  tok5        tok6  tok2  tok3  tok4
	 * This  additional  text  is    a     text.
	 * </pre>
	 * @model textsMany="true"
	 * @param sTextualDS the {@link STextualDS} object to which the new tokens should be related to. Make sure, that stextualDS is already contained in the {@link SDocumentGraph}
	 * @param posInText textual position where to add the new tokens.
	 * @param texts text values, the new tokens should cover
	 * @param insertSpace if true, a blank after each new text is inserted
	 * @generated
	 */
	EList<SToken> insertSTokensAt(STextualDS sTextualDS, Integer posInText, EList<String> texts, Boolean insertSpace);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates a {@link SRelation} object, and sets its sSource and sTarget to the passed ones. The created {@link SRelation} is of the passed type. If annotations are not empty, even {@link SAnnotation} objects will be created. The syntax to pass annotations is:
	 * <br/> 
	 * (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)+ 
	 * <br/>
	 * where SNS is the namespace of the annotation, SNAME is its name and SVALUE is the value of the annotation.
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	SRelation createSRelation(SNode sSource, SNode sTarget, STYPE_NAME sRelationType, String sAnnotations);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model overlappingRelationTypesMany="true"
	 * @generated
	 */
	EList<SToken> getOverlappedSTokens(SNode overlappingNode, EList<STYPE_NAME> overlappingRelationTypes);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method returns the exact text overlapped in the {@link STextualDS} by the given {@link SNode}.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String getSText(SNode sNode);

	/**
	 * Sets the SName of the SDocumentGraphImpl, but the parameter newSName is just a dummy. The SName of the corresponding SDocument plus "_graph" will be the SName.
	 * @param newSName this value will be ignored
	 */
	public void setSName(String newSName);
	
	/**
	 * What is this???
	 */
	void basicSetSElementId(); 
} // SDocumentGraph
