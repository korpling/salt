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
package org.corpus_tools.salt.common;

import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.SALT_TYPE;
import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.tokenizer.Tokenizer;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.util.DataSourceSequence;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;
import org.corpus_tools.salt.util.SaltUtil;
import org.knallgrau.utils.textcat.TextCategorizer;

import com.google.common.collect.Multimap;

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
	 * Returns the timeline of this document graph. A timeline is a specific
	 * datasource and acts as an anchor for {@link STimelineRelation}s. A
	 * timeline is necessary to set tokens in correspondance when they belong to
	 * different {@link STextualDS}s. For instance a timeline is necessary to
	 * model dialogue data.
	 * 
	 * @return timeline
	 */
	public STimeline getTimeline();

	/**
	 * Sets a new timeline- A timeline is a specific
	 * datasource and acts as an anchor for {@link STimelineRelation}s. A
	 * timeline is necessary to set tokens in correspondance when they belong to
	 * different {@link STextualDS}s. For instance a timeline is necessary to
	 * model dialogue data.
	 * @param value new timeline, which replaces the old one
	 */
	void setTimeline(STimeline value);

	/**
	 * Returns all relations of the passed type.
	 * 
	 * @param type
	 *            type of relations
	 * @return a list of relations matching passed type
	 */
	public List<? extends SRelation<?, ?>> getRelations(SALT_TYPE type);

	/**
	 * Returns all relations of the passed class.
	 * 
	 * @param clazz
	 *            class of relations
	 * @return a list of relations matching passed class
	 */
	public List<? extends SRelation<?, ?>> getRelations(Class<?> clazz);

	/**
	 * Returns all nodes of the passed type.
	 * 
	 * @param type
	 *            type of nodes
	 * @return a list of nodes matching passed type
	 */
	public List<SNode> getNodes(SALT_TYPE type);

	/**
	 * Returns all nodes of the passed class.
	 * 
	 * @param clazz
	 *            class of nodes
	 * @return a list of nodes matching passed class
	 */
	public List<SNode> getNodes(Class<?> clazz);

	public List<STimelineRelation> getTimelineRelations();

	public List<SSpanningRelation> getSpanningRelations();

	public List<SSpan> getSpans();

	public List<SStructure> getStructures();

	public List<SDominanceRelation> getDominanceRelations();

	public List<SPointingRelation> getPointingRelations();

	public List<SMedialRelation> getMedialRelations();

	public List<SMedialDS> getMedialDSs();

	public List<SOrderRelation> getOrderRelations();

	/**
	 * Creates and returns a '<em><b>SRelation</b></em>' of the type given by
	 * sRelationType between source and target. Note that the source is required
	 * to be in the SDocumentGraph already and that the relationType may only be
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
	public SRelation<? extends SNode, ? extends SNode> addNode(SNode source, SNode target, SALT_TYPE relationType);

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
	public SToken createToken(List<DataSourceSequence<Integer>> sequences);

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
	public SToken createToken(DataSourceSequence<Integer> sequence);

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
	public SSpan createSpan(SToken... sourceToken);

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
	public SStructure createStructure(SStructuredNode... structure);

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
	public List<SToken> getTokensBySequence(DataSourceSequence<?> sequence);

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
	public List<SSpan> getSpansBySequence(DataSourceSequence<?> sequence);

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
	public List<SStructure> getStructuresBySequence(DataSourceSequence<?> sequence);

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
	public List<SNode> getNodesBySequence(DataSourceSequence<?> sequence);

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
	public List<? extends DataSourceSequence<? extends Number>> getOverlappedDataSourceSequence(SNode node, SALT_TYPE... relationTypes);

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
	public List<? extends DataSourceSequence<? extends Number>> getOverlappedDataSourceSequence(List<SNode> nodes, SALT_TYPE... relationTypes);

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
	public List<SToken> getSortedTokenByText(List<SToken> tokens2sort);

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
	 * Returns all {@link SNode} objects which are roots for the given types of
	 * {@link SRelation}. Means, that all {@link SNode}s will be returned as
	 * roots, which have no incoming relations of the given type.
	 * <p>
	 * For instance imagine the following structure and assume that the passed
	 * {@link SALT_TYPE}s are {@link SALT_TYPE#SDOMINANCE_RELATION} and
	 * {@link SALT_TYPE#SSPANNING_RELATION}:
	 *
	 * <pre>
	 *       struct1
	 *     //      ||
	 *   span1     ||   span2
	 * 	/    \     ||    |
	 * tok1	tok2  tok3  tok4
	 * </pre>
	 * 
	 * the nodes:
	 * 
	 * struct1 and span2 are returned, even if a pointing relation connects
	 * struct1 and span2.
	 * </p>
	 * 
	 * @param saltTypes
	 *            a set of types for which nodes have to be computed.
	 * @return a list of {@link SNode}s which are roots
	 */
	public List<SNode> getRootsByRelation(SALT_TYPE... type);

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
	 * {@link #getRootsByRelation(SALT_TYPE)} is only node1. <br/>
	 * All relations having no type are stored in returned map corresponding to
	 * key {@link SaltUtil#SALT_NULL_VALUE}.
	 * 
	 * @param type
	 *            type, which shall be used for computing roots
	 * @return a map of types, with corresponding lists of root nodes
	 */
	public Multimap<String, SNode> getRootsByRelationType(SALT_TYPE type);

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
	public SToken createToken(SSequentialDS<?,Integer> sequentialDS, Integer start, Integer end);

	/**
	 * Tokenizes all {@link STextualDS} object being contained in this
	 * {@link SDocumentGraph} object. The Tokenization is similar to the
	 * tokenization made by the TreeTagger tokenizer. This method calls the
	 * method {@link #createTokenizer()} and initializes with automatic detected
	 * values. The language will be detected automatically for each
	 * {@link STextualDS} object by use of the {@link TextCategorizer} (see:
	 * <a href=
	 * "http://textcat.sourceforge.net/doc/org/knallgrau/utils/textcat/TextCategorizer.html"
	 * >http://textcat.sourceforge.net/doc/org/knallgrau/utils/textcat/
	 * TextCategorizer.html</a>). If the language is one of the given ones:
	 * English, French, Italian and German, abbreviations also taken from the
	 * Treetagger will be used. To customize these settings use the method
	 * {@link #createTokenizer()}.
	 * 
	 * The used Treetagger is a reimplementation in Java with permission from
	 * the original TreeTagger tokenizer in Perl by Helmut Schmid (see:
	 * <a href="http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/" >
	 * http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/</a>). For
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
	 * Helmut Schmid (see:
	 * <a href="http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/" >
	 * http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/</a>). For
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
	 * the call insertSTokensAt(sTextualDS, 5, {"additional" "text"}, true);
	 * <br/>
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
	public SRelation<? extends SNode, ? extends SNode> createRelation(SNode source, SNode target, SALT_TYPE relationType, String annotations);

	/**
	 * Returns all tokens in the graph, which are overlapped by the passed node
	 * and are reachable via relations having at least one of the passed types.
	 * 
	 * @param overlappingNode
	 *            anchor node, which overlaps the returned tokens
	 * @param overlappingRelationTypes
	 *            relation types
	 */
	public List<SToken> getOverlappedTokens(SNode overlappingNode, SALT_TYPE... overlappingRelationTypes);

	/**
	 * Returns all tokens in the graph, which are overlapped by the passed node
	 * and are reachable via {@link SALT_TYPE#STEXT_OVERLAPPING_RELATION} having
	 * at least one of the passed types.
	 * 
	 * @param overlappingNode
	 *            anchor node, which overlaps the returned tokens
	 */
	public List<SToken> getOverlappedTokens(SNode overlappingNode);

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
	public String getText(SNode sNode);

	/**
	 * Compares the passed graph with the current one and returns if they are
	 * isomorph or not. In case of the graphs are not isomorph, this method does
	 * not record all differences. To speed up the computation. it just detects
	 * the first difference and returns false. To get a full list of all
	 * differences, use method {@link #findDiffs()}.
	 * 
	 * @param other
	 *            the graph to be compared with this one
	 * @return true, if graphs are isomorph, false otherwise.
	 */
	public boolean isIsomorph(SDocumentGraph other);

	/**
	 * Compares the passed graph with the current one and returns if they are
	 * isomorph or not. In case of the graphs are not isomorph, this method does
	 * not record all differences. To speed up the computation. it just detects
	 * the first difference and returns false. To get a full list of all
	 * differences, use method {@link #findDiffs()}.
	 * 
	 * @param other
	 *            the graph to be compared with this one
	 * @param options
	 *            an option map to customize the isomorphie comparison, for more
	 *            information about how to customize the comparison, please
	 *            check the javadoc to {@link DiffOptions}
	 * @return true, if graphs are isomorph, false otherwise.
	 */
	public boolean isIsomorph(SDocumentGraph other, DiffOptions options);

	/**
	 * Compares the passed graph with the current one and returns if they are
	 * isomorph or not. If graphs are not isomporph, this method finds and
	 * records all differences and lists them. That means the entire graphs have
	 * to be compared and could slow down the computation. If you are only
	 * interested in the result and not in the particular differences, use
	 * method {@link #isIsomorph()}.
	 * 
	 * @param other
	 *            the graph to be compared with this one
	 * @return true, if graphs are isomorph, false otherwise.
	 */
	public Set<Difference> findDiffs(SDocumentGraph other);

	/**
	 * Compares the passed graph with the current one and returns if they are
	 * isomorph or not. If graphs are not isomporph, this method finds and
	 * records all differences and lists them. That means the entire graphs have
	 * to be compared and could slow down the computation. If you are only
	 * interested in the result and not in the particular differences, use
	 * method {@link #isIsomorph()}.
	 * 
	 * @param other
	 *            the graph to be compared with this one
	 * @param options
	 *            an option map to customize the isomorphie comparison, for more
	 *            information about how to customize the comparison, please
	 *            check the javadoc to {@link DiffOptions}
	 * @return true, if graphs are isomorph, false otherwise.
	 */
	public Set<Difference> findDiffs(SDocumentGraph other, DiffOptions options);
} // SDocumentGraph
