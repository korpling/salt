/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.u.saltnpepper.salt.common.documentStructure;

import java.util.List;
import java.util.Map;

import org.knallgrau.utils.textcat.TextCategorizer;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.tokenizer.Tokenizer;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.util.DataSourceSequence;
import de.hu_berlin.u.saltnpepper.salt.util.SALT_TYPE;

/**
 * The document-structure covers the "real" linguistic data, which means primary
 * data, linguistic structures and annotations on them. The linguistic structure
 * contains the nodes: {@link SSequentialDS}, {@link STextualDS},
 * {@link SMedialDS}, {@link SToken}, {@link SSpan} and {@link SStructure} and
 * the relations: {@link STextualRelation}, {@link SMedialRelation},
 * {@link SSpanningRelation}, {@link SDominanceRelation},
 * {@link SPointingRelation} and {@link SOrderRelation} which we will discuss in
 * the following. All these nodes and relations are contained in a graph, the
 * {@link SDocumentGraph}, which is the model element representing the
 * document-structure.
 * 
 * @author florian
 */
public interface SDocumentGraph extends SGraph {
	/**
	 * Returns the {@link SDocument} object containing this graph object. The
	 * {@link SDocument} object is linked via a {@link SFeature} object having
	 * the namespace {@value SaltFactory#NAMESPACE_SALT} and the name
	 * {@value SFEATURE_NAME#SDOCUMENT}.
	 * 
	 * @return the value of the '<em>SDocument</em>' reference.
	 */
	public SDocument getDocument();

	/**
	 * Sets the {@link SDocument} object as a container for this graph. The
	 * given {@link SDocument} object is linked via a {@link SFeature} object
	 * having the namespace {@value SaltFactory#NAMESPACE_SALT} and the name
	 * {@value SFEATURE_NAME#SDOCUMENT}.
	 * 
	 * @param document
	 *            the new value of the '<em>SDocument Graph</em>' reference.
	 * @param document
	 *            the new value of the '<em>SDocument</em>' reference.
	 */
	public void setDocument(SDocument document);

	/**
	 * Returns all primary texts contained in this document structure.
	 * 
	 * @return a list of contained primary texts
	 */
	public List<STextualDS> getTextualDSs();

	/**
	 * Returns all relations which connects a token with a primary text
	 * contained in this document structure.
	 * 
	 * @return all relations which connects a token with a primary text
	 */
	public List<STextualRelation> getTextualRelations();

	/**
	 * Returns all tokens contained contained in this document structure.
	 * 
	 * @return all tokens
	 */
	public List<SToken> getTokens();

	/**
	 * Returns the value of the '<em><b>STimeline</b></em>' reference. It is
	 * bidirectional and its opposite is '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph
	 * <em>SDocument Graph</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STimeline</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>STimeline</em>' reference.
	 * @see #setTimeline(STimeline)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STimeline()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph
	 * @model opposite="sDocumentGraph" transient="true" volatile="true"
	 *        derived="true"
	 * @generated
	 */
	STimeline getTimeline();

	/**
	 * Sets the value of the '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline
	 * <em>STimeline</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>STimeline</em>' reference.
	 * @see #getTimeline()
	 * @generated
	 */
	void setTimeline(STimeline value);

	/**
	 * Returns the value of the '<em><b>STimeline Relations</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation}
	 * . It is bidirectional and its opposite is '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph
	 * <em>SDocument Graph</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STimeline Relations</em>' containment
	 * reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>STimeline Relations</em>' containment
	 *         reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_STimelineRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true"
	 *        volatile="true" derived="true"
	 * @generated
	 */
	List<STimelineRelation> getTimelineRelations();

	/**
	 * Returns the value of the '<em><b>SSpanning Relations</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation}
	 * . It is bidirectional and its opposite is '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph
	 * <em>SDocument Graph</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSpanning Relations</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>SSpanning Relations</em>' containment
	 *         reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SSpanningRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true"
	 *        volatile="true" derived="true"
	 * @generated
	 */
	List<SSpanningRelation> getSpanningRelations();

	/**
	 * Returns the value of the '<em><b>SSpans</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan}
	 * . It is bidirectional and its opposite is '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan#getSDocumentGraph
	 * <em>SDocument Graph</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSpans</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>SSpans</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SSpans()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true"
	 *        volatile="true" derived="true"
	 * @generated
	 */
	List<SSpan> getSpans();

	/**
	 * Returns the value of the '<em><b>SStructures</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure}
	 * . It is bidirectional and its opposite is '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure#getSDocumentGraph
	 * <em>SDocument Graph</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStructures</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>SStructures</em>' containment reference
	 *         list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SStructures()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true"
	 *        volatile="true" derived="true"
	 * @generated
	 */
	List<SStructure> getStructures();

	/**
	 * Returns the value of the '<em><b>SDominance Relations</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation}
	 * . It is bidirectional and its opposite is '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph
	 * <em>SDocument Graph</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDominance Relations</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>SDominance Relations</em>' containment
	 *         reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SDominanceRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true"
	 *        volatile="true" derived="true"
	 * @generated
	 */
	List<SDominanceRelation> getDominanceRelations();

	/**
	 * Returns the value of the '<em><b>SPointing Relations</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation}
	 * . It is bidirectional and its opposite is '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation#getSDocumentGraph
	 * <em>SDocument Graph</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SPointing Relations</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>SPointing Relations</em>' containment
	 *         reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SPointingRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true"
	 *        volatile="true"
	 * @generated
	 */
	List<SPointingRelation> getPointingRelations();

	/**
	 * Returns the value of the '<em><b>SAudio DS Relations</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation}
	 * . It is bidirectional and its opposite is '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSDocumentGraph
	 * <em>SDocument Graph</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAudio DS Relations</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>SAudio DS Relations</em>' containment
	 *         reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SAudioDSRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true"
	 *        volatile="true" derived="true"
	 * @generated
	 */
	List<SMedialRelation> getMedialRelations();

	/**
	 * Returns the value of the '<em><b>SAudio Data Sources</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource}
	 * . It is bidirectional and its opposite is '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource#getSDocumentGraph
	 * <em>SDocument Graph</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAudio Data Sources</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>SAudio Data Sources</em>' containment
	 *         reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SAudioDataSources()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true"
	 *        volatile="true" derived="true"
	 * @generated
	 */
	List<SMedialDS> getMedialDSs();

	/**
	 * Returns the value of the '<em><b>SOrder Relations</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation}
	 * . It is bidirectional and its opposite is '
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation#getSDocumentGraph
	 * <em>SDocument Graph</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SOrder Relations</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>SOrder Relations</em>' containment
	 *         reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDocumentGraph_SOrderRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation#getSDocumentGraph
	 * @model opposite="sDocumentGraph" containment="true" transient="true"
	 *        volatile="true" derived="true"
	 * @generated
	 */
	List<SOrderRelation> getOrderRelations();

	/**
	 * Creates and returns a '<em><b>SRelation</b></em>' of the type given by
	 * sRelationType between source and target. Note that the source is required
	 * to be in the SDocumentGraph already and that the elationType may only be
	 * one of {@link SALT_TYPE#STEXTUAL_RELATION},
	 * {@link SALT_TYPE#SSPANNING_RELATION},
	 * {@link SALT_TYPE#SDOMINANCE_RELATION} and
	 * {@link SALT_TYPE#SPOINTING_RELATION}.
	 * 
	 * @param source
	 *            source node
	 * @param target
	 *            target node
	 * @param SALT_TYPE
	 *            type of the relation to be created between source and target
	 * @return created relation
	 */
	public SRelation addNode(SNode source, SNode target, SALT_TYPE relationType);

	/**
	 * Creates and adds a new {@link STextualDS} node object and sets its text
	 * to the passed one and adds it to the graph.
	 * 
	 * @param text
	 *            the text which shall be the primary text and be added to the
	 *            created {@link STextualDS} node
	 * @return the created {@link STextualDS} node which has been created
	 */
	public STextualDS createTextualDS(String text);

	/**
	 * Creates a new {@link SToken} object and adds it to the graph. The
	 * {@link SToken} object will be connected with the {@link SSequentialDS}
	 * object given in the passed {@link DataSourceSequence} object. The created
	 * relations get the borders also given in the {@link DataSourceSequence}
	 * object.
	 * 
	 * @param sequences
	 *            list of sequences which shall be overlapped by the created
	 *            token
	 * @return returns the created token
	 */
	public SToken createToken(List<DataSourceSequence> sequences);

	/**
	 * Creates a new {@link SToken} object and adds it to the graph. The
	 * {@link SToken} object will be connected with the {@link SSequentialDS}
	 * objects given in the passed {@link DataSourceSequence} object. The
	 * created relations get the borders also given in the
	 * {@link DataSourceSequence} object.
	 * 
	 * @param sequence
	 *            the sequence which shall be overlapped by the created token
	 * @return returns the created token
	 */
	public SToken createToken(DataSourceSequence sequence);
	
	/**
	 * Creates a new {@link SSpan} object, adds it to the graph and returns the
	 * new object. Further, this method creates a {@link SSpanningRelation}
	 * object and sets its source to the created {@link SSpan} object and the
	 * target to the given source node.
	 * 
	 * @param sourceToken
	 *            source {@link SToken} node to which the
	 *            {@link SSpanningRelation} relation points to
	 * @return the created {@link SSpan} node
	 */
	public SSpan createSpan(SToken sourceToken);

	/**
	 * Creates a {@link SSpan} object, adds it to the graph and returns the new
	 * object. Further, this method creates {@link SSpanningRelation} relations
	 * and sets their source to the created {@link SSpan} object and the targets
	 * to the given source nodes.
	 * 
	 * @param sourceTokens
	 *            source {@link SToken} node to which the
	 *            {@link SSpanningRelation} relation points to
	 * @return the created {@link SSpan} node
	 */
	public SSpan createSpan(List<SToken> sourceTokens);

	/**
	 * Creates a new {@link SStructure} object, adds it to the graph and returns
	 * the new object. Further, this method creates a {@link SDominanceRelation}
	 * object and sets its source to the created {@link SStructure} object and
	 * the target to the given source node.
	 * 
	 * @param structure
	 *            source {@link SStructuredNode} node to which the
	 *            {@link SDominanceRelation} relation points to
	 * @return {@link SStructure} node
	 */
	public SStructure createSStructure(SStructuredNode structure);

	/**
	 * Creates a new {@link SStructure} object, adds it to the graph and returns
	 * the new object. Further, this method creates {@link SDominanceRelation}
	 * relations and sets their sources to the created {@link SStructure} object
	 * and the targets to the given source nodes.
	 * 
	 * @param structures
	 *            list of source {@link SStructuredNode} nodes to which the
	 *            {@link SDominanceRelation} relation points to
	 * @return {@link SStructure} node
	 */
	public SStructure createStructure(List<SStructuredNode> structures);

	/**
	 * Creates an {@link STimeline} object being contained in this
	 * {@link SDocumentGraph} object. The new {@link STimeline} object is filled
	 * with points of time computed out of the {@link STextualRelation} objects
	 * being contained by this {@link SDocumentGraph} object. For each
	 * {@link STextualDS} object, for each {@link STextualRelation} object one
	 * point of time would be created. If this object already contains a not
	 * empty {@link STimeline} object the already existing one would be
	 * returned.
	 * 
	 * @return returns a new created and automatically filled {@link STimeline}
	 *         object if no one exists yet
	 */
	public STimeline createTimeline();

	/**
	 * Returns all {@link SToken} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of data source by the instance <em>sSequentialDS</em>.
	 * 
	 * @param sequence
	 *            an object determining the sequence to which the returned
	 *            {@link SToken} objects refer to.
	 * @return a list of {@link SToken} objects which refer or overlap the
	 *         passed sequence
	 */
	public List<SToken> getTokensBySequence(DataSourceSequence sequence);

	/**
	 * Returns all {@link SSpan} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of data source by the instance <em>sSequentialDS</em>.
	 * 
	 * @param sequence
	 *            an object determining the sequence to which the returned
	 *            {@link SSpan} objects refer to.
	 * @return a list of {@link SSpan} objects which refer or overlap the passed
	 *         sequence
	 */
	public List<SSpan> getSpansBySequence(DataSourceSequence sequence);

	/**
	 * Returns all {@link SStructure} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of datasource by the instance <em>sSequentialDS</em>.
	 * 
	 * @param sequence
	 *            an object determining the sequence to which the returned
	 *            {@link SStructure} objects refer to.
	 * @return a list of {@link SStructure} objects which refer or overlap the
	 *         passed sequence
	 */
	public List<SStructure> getStructuresBySequence(DataSourceSequence sequence);

	/**
	 * Returns all {@link SNode} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of data source by the instance <em>sSequentialDS</em>.
	 * 
	 * @param sequence
	 *            an object determining the sequence to which the returned
	 *            {@link SNode} objects refer to.
	 * @return a list of {@link SNode} objects which refer or overlap the passed
	 *         sequence
	 */
	public List<SNode> getNodesBySequence(DataSourceSequence sequence);

	/**
	 * Returns the sequences as {@link DataSourceSequence} which are overlapped
	 * by the given {@link SNode} node. Overlapped means, that starting from the
	 * given {@link SNode} node the {@link SSequentialDS} can reached by
	 * traversing relations of one of the types contained in the given list of
	 * {@link SALT_TYPE}.
	 * 
	 * @param node
	 *            node to start from
	 * @param relationTypes
	 *            a list of relation types, which are traversed
	 * @return the overlapped {@link DataSourceSequence} objects
	 */
	public List<DataSourceSequence> getOverlappedDSSequences(SNode node, List<SALT_TYPE> relationTypes);

	/**
	 * Returns the sequences as {@link DataSourceSequence} which are overlapped
	 * by the given {@link SNode} node. Overlapped means, that starting from the
	 * given {@link SNode} node the {@link SSequentialDS} can reached by
	 * traversing relations of one of the types contained in the given list of
	 * {@link SALT_TYPE}.
	 * 
	 * @param nodes
	 *            a list of nodes to start from
	 * @param relationTypes
	 *            a list of relation types, which are traversed
	 * @return the overlapped {@link DataSourceSequence} objects
	 */
	public List<DataSourceSequence> getOverlappedDSSequences(List<SNode> nodes, List<SALT_TYPE> relationTypes);

	/**
	 * Returns true, if the given list of nodes <em>subNodeList</em> is
	 * continuous respecting the overlapped text. A list of nodes is continuous,
	 * if there is no other node overlapping a text sequence, which is a
	 * subsequence of the sequence overlapped by the given list and is not part
	 * of the list.
	 * 
	 * @param subNodeList
	 *            list to check against fullSNodeList
	 * @param fullNodeList
	 *            list which contains all nodes in correct order
	 * @return true, if list is continuous
	 */
	public boolean isContinuousByText(List<SNode> subNodeList, List<SNode> fullNodeList);

	/**
	 * Returns true, if the given list of nodes <em>subNodeList</em> is
	 * continuous respecting the overlapped text. A list of nodes is continuous,
	 * if there is no other node overlapping a text sequence, which is a
	 * subsequence of the sequence overlapped by the given list and is not part
	 * of the list. The fullSNodeList is given by the token list of this graph.
	 * 
	 * @param subNodeList
	 *            list to check against fullSNodeList
	 * @return true, if list is continuous
	 */
	public boolean isContinuousByText(List<SNode> subNodeList);

	/**
	 * Returns all {@link SToken} objects being contained in the given list and
	 * sorts them by the {@link STextualRelation#getStart()} value of
	 * {@link SToken} object.
	 * 
	 * @param tokens2sort
	 *            the list of {@link SToken} objects to sort
	 * @return list of tokens in order of left text position
	 */
	public List<SToken> getSortedSTokenByText(List<SToken> tokens2sort);

	/**
	 * Returns all {@link SToken} objects being contained in the list
	 * {@link SDocumentGraph#getTokens()} and sorts them by the
	 * {@link STextualRelation#getStart()} value of {@link SToken} object.
	 * 
	 * @return list of tokens in order of left text position
	 */
	public List<SToken> getSortedTokenByText();

	/**
	 * Sorts all {@link SToken} and {@link STextualRelation} objects being
	 * contained in the list {@link SDocumentGraph#getTokens()} and
	 * {@link SDocumentGraph#getSTextualRelations()} by the
	 * {@link STextualRelation#getStart()} value of {@link SToken} and
	 * {@link STextualRelation} object.
	 */
	public void sortTokenByText();

	/**
	 * Returns all SNode objects which are roots for the given SRelation
	 * Subtype. Means, that all SNode-objects will be returned as roots, which
	 * have no incoming SRelation-objects of the given subtype clazz. <br/>
	 * Attention: Only the subtypes SPointingRelation, SSpanningRelation and
	 * SDominanceRelation are supported yet. <br/>
	 * 
	 * @param type
	 *            type, which shall be used for computing roots
	 * @return a list of SNode-objects which are roots
	 */
	public List<SNode> getRootsByRelation(SALT_TYPE type);

	/**
	 * Returns all nodes, which are roots for the given relation-class respects
	 * to the given SType of the traversed relation. The following example shows
	 * the different to the method getRootsBySRelation(): Imagine the following
	 * graphFor example:
	 * 
	 * <pre>
	 * node1 ->t1 node2, node2 ->t2-> node3
	 * </pre>
	 * 
	 * Also imagine, that -> is a relation of same class with sType=t1
	 * respectivly sType=t2 The returned roots will be node1 and node 2, because
	 * of node1 is the root of a subgraph for relation.sType=t1 and node2 is the
	 * root of the subgraph for relation.sType=t2. Whereas the returned nodes of
	 * getRootsBySRelation() is only node1.
	 * 
	 * @param type
	 *            type, which shall be used for computing roots
	 * @return a map of types, with corresponding lists of root nodes
	 */
	public Map<String, List<SNode>> getRootsBySRelationSType(SALT_TYPE type);

	/**
	 * Creates a new {@link SToken} object and adds it to the graph. The
	 * {@link SToken} object will be connected with the given
	 * {@link SSequentialDS} object. The created relation get the passed
	 * positions.
	 * 
	 * @param sequentialDS
	 *            the data source to which the created token should be connected
	 * @param start
	 *            the offset in the data source where the created token starts
	 * @param end
	 *            the offset in the data source where the created token ends
	 * @return the created token
	 */
	public SToken createToken(SSequentialDS sequentialDS, Integer start, Integer end);

	/**
	 * Tokenizes all {@link STextualDS} object being contained in this
	 * {@link SDocumentGraph} object. The Tokenization is similar to the
	 * tokenization made by the TreeTagger tokenizer. This method calls the
	 * method {@link #createTokenizer()} and initializes with automatic detected
	 * values. The language will be detected automatically for each
	 * {@link STextualDS} object by use of the {@link TextCategorizer} (see: <a
	 * href=
	 * "http://textcat.sourceforge.net/doc/org/knallgrau/utils/textcat/TextCategorizer.html"
	 * >http://textcat.sourceforge.net/doc/org/knallgrau/utils/textcat/
	 * TextCategorizer.html</a>). If the language is one of the given ones:
	 * English, French, Italian and German, abbreviations also taken from the
	 * Treetagger will be used. To customize these settings use the method
	 * {@link #createTokenizer()}.
	 * 
	 * The used Treetagger is a reimplementation in Java with permission from
	 * the original TreeTagger tokenizer in Perl by Helmut Schmid (see: <a
	 * href="http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/"
	 * >http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/</a>). For
	 * each token detected in the text given by
	 * <code>sTextualDS.getSText()</code> an {@link SToken} object is created
	 * and linked with the {@link STextualDS} object via a new
	 * {@link STextualRelation} object containing the textual offset.
	 * 
	 * @return a list of all created tokens
	 */
	public List<SToken> tokenize();

	/**
	 * Creates a new {@link Tokenizer} object to tokenize the set
	 * {@link STextualDS} objects being contained in this {@link SDocumentGraph}
	 * object. To customize the tokenization, set take a look to the properties
	 * of the returned {@link Tokenizer} object. This method is used by the
	 * method {@link #tokenize()}. The used Treetagger is a reimplementation in
	 * Java with permission from the original TreeTagger tokenizer in Perl by
	 * Helmut Schmid (see: <a
	 * href="http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/"
	 * >http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/</a>). For
	 * each token detected in the text given by
	 * <code>sTextualDS.getSText()</code> an {@link SToken} object is created
	 * and linked with the {@link STextualDS} object via a new
	 * {@link STextualRelation} object containing the textual offset. If the set
	 * {@link STextualDS} object is empty or if it does not belong to this
	 * {@link SDocumentGraph} object an exception is thrown.
	 * 
	 * @return a tokenizer object
	 */
	public Tokenizer createTokenizer();

	/**
	 * Inserts a token to the graph starting at position <em>posInText</em> and
	 * relates them to the given {@link STextualDS} object.<br/>
	 * An example:<br/>
	 * Imagine the following sText and tokenization
	 * 
	 * <pre>
	 * tok1  tok2  tok3  tok4
	 * This  is    a     text.
	 * </pre>
	 * 
	 * the call insertSTokensAt(sTextualDS, 5, "additional", true);<br/>
	 * results in <br/>
	 * 
	 * <pre>
	 * tok1  tok5        tok2  tok3  tok4
	 * This  additional  is    a     text.
	 * </pre>
	 * 
	 * @param textualDS
	 *            the {@link STextualDS} object to which the new tokens should
	 *            be related to. Make sure, that stextualDS is already contained
	 *            in the {@link SDocumentGraph}
	 * @param posInText
	 *            textual position where to add the new tokens.
	 * @param text
	 *            text value, the new token should cover
	 * @param insertSpace
	 *            if true, a blank after each new text is inserted
	 * @return new created token
	 */
	public SToken insertTokenAt(STextualDS textualDS, Integer posInText, String text, Boolean insertSpace);

	/**
	 * Inserts n tokens (where n is the size of the given list <em>texts</em>)
	 * to the graph starting at position <em>posInText</em> and relates them to
	 * the given {@link STextualDS} object.<br/>
	 * An example:<br/>
	 * Imagine the following sText and tokenization
	 * 
	 * <pre>
	 * tok1  tok2  tok3  tok4
	 * This  is    a     text.
	 * </pre>
	 * 
	 * the call insertSTokensAt(sTextualDS, 5, {"additional" "text"}, true);<br/>
	 * results in <br/>
	 * 
	 * <pre>
	 * tok1  tok5        tok6  tok2  tok3  tok4
	 * This  additional  text  is    a     text.
	 * </pre>
	 * 
	 * @param textualDS
	 *            the {@link STextualDS} object to which the new tokens should
	 *            be related to. Make sure, that stextualDS is already contained
	 *            in the {@link SDocumentGraph}
	 * @param posInText
	 *            textual position where to add the new tokens.
	 * @param texts
	 *            text values, the new tokens should cover
	 * @param insertSpace
	 *            if true, a blank after each new text is inserted
	 */
	public List<SToken> insertTokensAt(STextualDS textualDS, Integer posInText, List<String> texts, Boolean insertSpace);

	/**
	 * Creates a {@link SRelation} object, and sets its sSource and sTarget to
	 * the passed ones. The created {@link SRelation} is of the passed type. If
	 * annotations are not empty, even {@link SAnnotation} objects will be
	 * created. The syntax to pass annotations is: <br/>
	 * (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)+ <br/>
	 * where SNS is the namespace of the annotation, SNAME is its name and
	 * SVALUE is the value of the annotation.
	 * 
	 * @param source
	 *            source node
	 * @param target
	 *            target node
	 * @param relationType
	 *            type of the relation
	 * @param annotations
	 *            annotations to be added to the created relation
	 *            (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)+
	 * @return the created relation
	 */
	public SRelation createSRelation(SNode source, SNode target, SALT_TYPE relationType, String annotations);

	/**
	 * Returns all tokens in the graph, which are overlapped by the passed node
	 * and are reachable via relations having at least one of the passed types.
	 * 
	 * @param overlappingNode anchor node, which overlaps the returned tokens
	 * @param overlappingRelationTypes relation types
	 */
	public List<SToken> getOverlappedTokens(SNode overlappingNode, List<SALT_TYPE> overlappingRelationTypes);

	/**
	 * This method returns the exact text overlapped in the {@link STextualDS}
	 * by the given {@link SNode}. Imagine the following graph:
	 * 
	 * <pre>
	 *       n1
	 *      /  \
	 *  t1 t2  t3 t4      t5
	 *   |  |  |   |      |
	 * This is a sample text.
	 * </pre>
	 * 
	 * The method will return the text 'text' for token t5 and 'is a' for node
	 * n1.
	 * 
	 * @param sNode
	 *            the node for which the text should be retrieved.
	 * @return the text which is overlapped by the passed node
	 */
	public String getSText(SNode sNode);
} // SDocumentGraph
