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
package org.corpus_tools.salt.util.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.SALT_TYPE;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SSequentialDS;
import org.corpus_tools.salt.common.SSequentialRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextOverlappingRelation;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.STimeOverlappingRelation;
import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.util.DataSourceSequence;
import org.corpus_tools.salt.util.STextualRelationSStartComparator;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.TokenStartComparator;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

/**
 * Provides some methods for an easier access to objects being contained by a
 * given {@link SDocumentGraph} object.
 * 
 * @author Florian Zipser
 *
 */
public class DataSourceAccessor {
	// ==================================== start: accessing concerning timeline
	/**
	 * Returns all {@link SToken} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of datasource by the instance <em>sSequentialDS</em>.
	 * 
	 * @param DataSourceSequence
	 *            an object determing the sequence to which the returned
	 *            {@link SToken} objects refer to.
	 * @return a list of {@link SToken} objects which refer or overlap the
	 *         passed sequence
	 */
	public static List<SToken> getTokensBySequence(SDocumentGraph documentGraph, DataSourceSequence DataSourceSequence) {
		List<Class<? extends SNode>> classes = new ArrayList<Class<? extends SNode>>();
		classes.add(SToken.class);
		@SuppressWarnings("unchecked")
		List<SToken> sTokens = ((List<SToken>) (List<? extends SNode>) getSNodesBySequence(documentGraph, DataSourceSequence, classes));

		return (sTokens);
	}

	/**
	 * Returns all {@link SSpan} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of datasource by the instance <em>sSequentialDS</em>.
	 * 
	 * @param DataSourceSequence
	 *            an object determing the sequence to which the returned
	 *            {@link SSpan} objects refer to.
	 * @return a list of {@link SSpan} objects which refer or overlap the passed
	 *         sequence
	 */
	public static List<SSpan> getSpanBySequence(SDocumentGraph documentGraph, DataSourceSequence DataSourceSequence) {
		List<Class<? extends SNode>> classes = new ArrayList<>();
		classes.add(SSpan.class);
		@SuppressWarnings("unchecked")
		List<SSpan> sSpans = ((List<SSpan>) (List<? extends SNode>) getSNodesBySequence(documentGraph, DataSourceSequence, classes));

		return (sSpans);
	}

	/**
	 * Returns all {@link SStructure} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of datasource by the instance <em>sSequentialDS</em>.
	 * 
	 * @param DataSourceSequence
	 *            an object determing the sequence to which the returned
	 *            {@link SStructure} objects refer to.
	 * @return a list of {@link SStructure} objects which refer or overlap the
	 *         passed sequence
	 */
	public static List<SStructure> getStructureBySequence(SDocumentGraph documentGraph, DataSourceSequence DataSourceSequence) {
		List<Class<? extends SNode>> classes = new ArrayList<Class<? extends SNode>>();
		classes.add(SStructure.class);
		@SuppressWarnings("unchecked")
		List<SStructure> sStructs = ((List<SStructure>) (List<? extends SNode>) getSNodesBySequence(documentGraph, DataSourceSequence, classes));

		return (sStructs);
	}

	/**
	 * Returns all {@link SNode} objects which refer to the passed
	 * {@link DataSourceSequence} object. The passed object determines the
	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
	 * and the type of datasource by the instance <em>sSequentialDS</em>.
	 * 
	 * @param DataSourceSequence
	 *            an object determing the sequence to which the returned
	 *            {@link SNode} objects refer to.
	 * @return a list of {@link SNode} objects which refer or overlap the passed
	 *         sequence
	 */
	public static List<SNode> getNodeBySequence(SDocumentGraph documentGraph, DataSourceSequence DataSourceSequence) {
		List<Class<? extends SNode>> classes = new ArrayList<Class<? extends SNode>>();
		classes.add(SNode.class);
		List<SNode> sNodes = getSNodesBySequence(documentGraph, DataSourceSequence, classes);

		return (sNodes);
	}

	/**
	 * Searches for all {@link SNode} objects of the given node type, which
	 * cover the given sequence.
	 * 
	 * @param sequence
	 *            sequence, which is overlapped
	 * @param nodeClasses
	 *            type of nodes to be returned
	 * @return nodes, which overlaps the given sequence
	 */
	private static List<SNode> getSNodesBySequence(SDocumentGraph documentGraph, DataSourceSequence sequence, List<Class<? extends SNode>> nodeClasses) {
		if (sequence == null) {
			throw new SaltParameterException("Cannot start returning nodes overlapping a data source, because the 'DataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
		}
		if (sequence.getStart() == null) {
			throw new SaltParameterException("Cannot start returning nodes overlapping a data source, because the 'sStart' value of the 'DataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
		}
		if (sequence.getEnd() == null) {
			throw new SaltParameterException("Cannot start returning nodes overlapping a data source, because the 'sEnd' value of the 'DataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
		}
		if (documentGraph == null) {
			throw new SaltParameterException("Cannot start method please set the document graph first.");
		}

		List<SNode> nodes = null;
		List<? extends SSequentialRelation> sSeqRels = null;
		if (sequence.getDataSource() instanceof STextualDS) {
			sSeqRels = documentGraph.getTextualRelations();
		} else if (sequence.getDataSource() instanceof STimeline) {
			sSeqRels = documentGraph.getTimelineRelations();
		} else {
			throw new SaltParameterException("Cannot compute overlaped nodes, because the given dataSource is not supported by this method.");
		}
		for (SSequentialRelation<SToken, ? extends SSequentialDS, ? extends Number> sSeqRel : sSeqRels) {
			// walk through all sequential relations
			if ((sequence.getDataSource().equals(sSeqRel.getTarget())) && (sSeqRel.getStart().doubleValue() >= sequence.getStart().doubleValue()) && (sSeqRel.getEnd().doubleValue() <= sequence.getEnd().doubleValue())) {
				// sequential relation is in the interval
				for (Class<? extends SNode> nodeClass : nodeClasses) {
					if (nodes == null)
						nodes = new ArrayList<SNode>();
					if (nodeClass.isInstance(sSeqRel.getSource())) {
						// source is of correct type
						nodes.add(sSeqRel.getSource());
					}
				}
			} // sequential relation is in the interval
		} // walk through all sequential relations
		return (nodes);
	}

	/**
	 * {@inheritDoc SDocumentGraph#isContinuousByText(List)} First sorts the
	 * given lists, than searches first occurance of first node in subSNodList
	 * in fullSNodList. Starting from this index, the method compares each
	 * element in subSNodList to element i in fullSNodList. If one is not equal
	 * the method returns false.
	 */
	// TODO must be enabled for all SNode lists and not only SToken lists
	public static boolean isContinuousByText(SDocumentGraph documentGraph, List<? extends SNode> subSNodList, List<? extends SNode> fullSNodList) {
		if (documentGraph == null) {
			throw new SaltParameterException("Cannot start method 'getContinuously(List<SToken>, List<SToken>)' please set the document graph first.");
		}
		Boolean retVal = null;
		// compute sorted list of overlapped tokens by the given sStructuredNode
		@SuppressWarnings("unchecked")
		List<SToken> overlappedSTokens = getSortedSTokenByText(documentGraph, (List<SToken>) subSNodList);

		retVal = true;

		Integer posOfFirstOverlappedToken = fullSNodList.indexOf(overlappedSTokens.get(0));
		int ctr = 0;
		SToken sTokInAllTokens = null;
		for (SToken sToken : overlappedSTokens) {
			// count the token in fullSTokenList
			sTokInAllTokens = (SToken) fullSNodList.get(posOfFirstOverlappedToken + ctr);
			if (sToken.hashCode() != sTokInAllTokens.hashCode()) {
				// tokens at same position relative to their list are not equal
				retVal = false;
				break;
			} // tokens at same position relative to their list are not equal
			ctr++;
		}
		return (retVal);
	}

	/**
	 * {@inheritDoc SDocumentGraph#isContinuousByText(List)}
	 */
	public static boolean isContinuousByText(SDocumentGraph documentGraph, List<SNode> subSNodList) {
		return (isContinuousByText(documentGraph, subSNodList, getSortedSTokenByText(documentGraph)));
	}

	/**
	 * {@inheritDoc SDocumentGraph#sortSTokenByText()}
	 */
	public static void sortSTokenByText(SDocumentGraph documentGraph) {
		if (documentGraph == null) {
			throw new SaltParameterException("Cannot start method please set the document graph first.");
		}
		if (documentGraph.getTokens() != null) {
			TokenStartComparator comparator = new TokenStartComparator();
			comparator.setDocumentGraph(documentGraph);

			// sort tokens
			List<SToken> tokens = documentGraph.getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SToken.class);
			List<SToken> mutableTokens = new LinkedList<SToken>(tokens);
			Collections.sort(mutableTokens, comparator);
			documentGraph.getIndexMgr().remove(SaltUtil.IDX_NODETYPE, SToken.class);
			documentGraph.getIndexMgr().putAll(SaltUtil.IDX_NODETYPE, SToken.class, mutableTokens);

			STextualRelationSStartComparator comparatortextrels = new STextualRelationSStartComparator();
			comparatortextrels.setDocumentGraph(documentGraph);

			// sort textual relations
			List<STextualRelation> textualRelations = documentGraph.getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, STextualRelation.class);
			List<STextualRelation> mutableTextualRelations = new LinkedList<STextualRelation>(textualRelations);
			Collections.sort(mutableTextualRelations, comparatortextrels);
			documentGraph.getIndexMgr().remove(SaltUtil.IDX_RELATIONTYPE, STextualRelation.class);
			documentGraph.getIndexMgr().putAll(SaltUtil.IDX_RELATIONTYPE, STextualRelation.class, mutableTextualRelations);

		}
	}

	/**
	 * {@inheritDoc SDocumentGraph#getSortedTokenByText(List)}
	 */
	public static List<SToken> getSortedSTokenByText(SDocumentGraph documentGraph, List<SToken> sTokens2sort) {
		if (documentGraph == null) {
			throw new SaltParameterException("Cannot start method please set the document graph first.");
		}
		List<SToken> retVal = null;
		if (sTokens2sort != null) {
			TokenStartComparator comparator = new TokenStartComparator();
			comparator.setDocumentGraph(documentGraph);
			retVal = new ArrayList<SToken>();
			retVal.addAll(sTokens2sort);
			// sort tokens
			Collections.sort(retVal, comparator);
		}
		return (retVal);
	}

	/**
	 * {@inheritDoc SDocumentGraph#getSortedTokenByText()}
	 */
	public static List<SToken> getSortedSTokenByText(SDocumentGraph documentGraph) {
		List<SToken> retVal = null;
		if (documentGraph == null) {
			throw new SaltParameterException("Cannot start method please set the document graph first.");
		}

		if ((documentGraph.getTextualDSs() != null) && (documentGraph.getTextualDSs().size() > 0)) {
			retVal = new ArrayList<>();
			for (STextualDS sTextualDS : documentGraph.getTextualDSs()) {
				DataSourceSequence sequence = new DataSourceSequence();
				sequence.setDataSource(sTextualDS);
				sequence.setStart(0);
				sequence.setEnd((sTextualDS.getText() != null) ? sTextualDS.getText().length() : 0);
				List<SToken> sTokens = getTokensBySequence(documentGraph, sequence);
				if (sTokens != null) {
					retVal.addAll(getSortedSTokenByText(documentGraph, sTokens));
				}
			}
		}
		return (retVal);
	}

	/**
	 * {@inheritDoc SDocumentGraph#getOverlappedDSSequences(SNode, List)}
	 */
	public static List<DataSourceSequence> getOverlappedDataSourceSequence(SDocumentGraph documentGraph, SNode sNode, SALT_TYPE... relationTypes) {
		List<SNode> rootSNodes = new ArrayList<>();
		rootSNodes.add(sNode);
		return (getOverlappedDataSourceSequence(documentGraph, rootSNodes, relationTypes));
	}

	/**
	 * {@inheritDoc SDocumentGraph#getOverlappedDSSequences(SNode, List)}
	 */
	// TODO this method can be fasten up, by remembering the overlapped
	// sequences for each node and not traverse deeper, when the sequence is
	// already computed for a node
	public static List<DataSourceSequence> getOverlappedDataSourceSequence(SDocumentGraph documentGraph, List<SNode> nodes, SALT_TYPE... relationTypes) {
		Traverser traverser = new Traverser();
		if (relationTypes != null && relationTypes.length != 0) {
			traverser.relationTypes2Traverse = new HashSet<SALT_TYPE>();
			Collections.addAll(traverser.relationTypes2Traverse, relationTypes);
			documentGraph.traverse(nodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.toString(), traverser);
			return (traverser.dataSourceSequences);
		} else {
			return (new ArrayList<DataSourceSequence>());
		}
	}

	/**
	 * This method searches for every {@link SToken} which is (transitively)
	 * overlapped by the given {@link SNode} by {@link SRelation} types which
	 * have one of the types given in the overlappingRelationTypes list.
	 * 
	 * @param overlappingNode
	 *            the node for which the overlapped {@link SToken} objects are
	 *            searched
	 * @param overlappingRelationTypes
	 *            the list of {@link SALT_TYPE}s which are used for traversion.
	 *            If, for example, all {@link SToken} are searched which are
	 *            overlapped by a {@link SStructure}, the
	 *            {@link SALT_TYPE.SDOMINANCE_RELATION} and
	 *            {@link SALT_TYPE.SPANNING_RELATION} should be contained in
	 *            this parameter.
	 * @return a list of {@link SToken} which are overlapped by the
	 *         overlappingNode.
	 */
	public static List<SToken> getOverlappedSTokens(SDocumentGraph documentGraph, SNode overlappingNode, SALT_TYPE... relationTypes) {
		Traverser traverser = new Traverser();
		// initialise the overlappedSToken List
		traverser.overlappedSToken = new HashSet<SToken>();
		// initialise the relationTypes2Traverse List
		traverser.relationTypes2Traverse = new HashSet<SALT_TYPE>();
		Collections.addAll(traverser.relationTypes2Traverse, relationTypes);
		List<SNode> rootNodes = new ArrayList<>();
		rootNodes.add(overlappingNode);
		documentGraph.traverse(rootNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAVERSION_TYPE.OVERLAPPED_STOKEN.toString(), traverser);

		return (new ArrayList<SToken>(traverser.overlappedSToken));
	}

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
	public static List<SNode> getRootsByRelation(SDocumentGraph documentGraph, SALT_TYPE... saltTypes) {
		HashSet<SNode> retSet = new LinkedHashSet<>();
		List<SRelation> relations = new ArrayList<>();
		for (SALT_TYPE saltType : saltTypes) {
			if (SALT_TYPE.SSPANNING_RELATION.equals(saltType)) {
				relations.addAll((List<SRelation>) (List<? extends SRelation>) documentGraph.getSpanningRelations());
			} else if (SALT_TYPE.SDOMINANCE_RELATION.equals(saltType)) {
				relations.addAll((List<SRelation>) (List<? extends SRelation>) documentGraph.getDominanceRelations());
			} else if (SALT_TYPE.SPOINTING_RELATION.equals(saltType)) {
				relations.addAll((List<SRelation>) (List<? extends SRelation>) documentGraph.getPointingRelations());
			} else if (SALT_TYPE.SORDER_RELATION.equals(saltType)) {
				relations.addAll((List<SRelation>) (List<? extends SRelation>) documentGraph.getOrderRelations());
			} else if (SALT_TYPE.STEXTUAL_RELATION.equals(saltType)) {
				relations.addAll((List<SRelation>) (List<? extends SRelation>) documentGraph.getTextualRelations());
			} else if (SALT_TYPE.STIMELINE_RELATION.equals(saltType)) {
				relations.addAll((List<SRelation>) (List<? extends SRelation>) documentGraph.getTimelineRelations());
			} else if (SALT_TYPE.SMEDIAL_RELATION.equals(saltType)) {
				relations.addAll((List<SRelation>) (List<? extends SRelation>) documentGraph.getMedialRelations());
			}
		}
		HashSet<SNode> notRootElements = new HashSet<>();
		for (SRelation<? extends SNode, ? extends SNode> relation : relations) {
			// mark destination as no root
			if (!notRootElements.contains(relation.getTarget()))
				notRootElements.add(relation.getTarget());
			// if source is not also a destination
			if ((!notRootElements.contains(relation.getSource())) && (!retSet.contains(relation.getSource())))
				retSet.add(relation.getSource());
			// remove wrong stored nodes in retList
			if (retSet.contains(relation.getTarget()))
				retSet.remove(relation.getTarget());
		}
		List<SNode> retVal = null;
		if (!retSet.isEmpty()) {
			retVal = new ArrayList<>(retSet);
		}
		return (retVal);
	}

	/**
	 * Returns all nodes, which are roots for the given relation-class respects
	 * to the given SType of the traversed relation. The following example shows
	 * the different to the method getRootsBySRelation(): Imagine the following
	 * graphFor example: node1 ->t1 node2, node2 ->t2-> node3. Also imagine,
	 * that -> is a relation of same class with sType=t1 respectivly sType=t2
	 * The returned roots will be node1 and node 2, because of node1 is the root
	 * of a subgraph for relation.sType=t1 and node2 is the root of the subgraph
	 * for relation.sType=t2. Whereas the returned nodes of
	 * getRootsBySRelation() is only node1.
	 * 
	 * @param clazz
	 *            class of Relation to be traversed for searching roots
	 * @return a map of types, with corresponding lists of root nodes
	 */
	@SuppressWarnings("unchecked")
	public static Multimap<String, SNode> getRootsByRelationType(SDocumentGraph documentGraph, SALT_TYPE sType) {
		return (getRootsByRelationType(documentGraph, (Class<? extends SRelation>) sType.getJavaType()));
	}

	/**
	 * {@inheritDoc SDocumentGraph#getRootsByRelationType(SALT_TYPE)}
	 * 
	 * <pre>
	 * for each relation R of type class
	 *     for each foregoing relation P (incoming relation of R'source)
	 *         check whether P is a parent of R (true, if they have the same class and the same type)   
	 *     if R has no parents store R corresponding to it's type in returned table
	 * </pre>
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static Multimap<String, SNode> getRootsByRelationType(SDocumentGraph documentGraph, Class<? extends SRelation> clazz) {
		if (clazz == null) {
			throw new SaltParameterException("clazz", "getRootsBySRelationSType", null);
		}
		if (documentGraph == null) {
			throw new SaltParameterException("Cannot compute roots, because there is no SDocumentGraph set to traverse.");
		}
		Class<? extends SRelation> currRelationType = null;
		currRelationType = clazz;
		Multimap<String, SNode> retVal = LinkedHashMultimap.create();
		List<SRelation> relations = documentGraph.getRelations(clazz);
		for (SRelation<? extends SNode, ? extends SNode> currentRel : relations) {

			if (currentRel.getSource() == null) {
				throw new SaltInvalidModelException("Cannot compute roots, because there is a SRelation object '" + currentRel.getId() + "' having no source node.");
			}
			boolean hasParent = false;
			for (SRelation<? extends SNode, ? extends SNode> parentRelation : documentGraph.getInRelations(currentRel.getSource().getId())) {
				// walk through all incoming relations of
				// currentRelation' source
				if (currRelationType.isInstance(parentRelation)) {
					// parent has same class
					// check whether parent is a real parent

					if (currentRel.getType() == null) {
						if (parentRelation.getType() == null) {
							// parent is a real parent
							hasParent = true;
						}
					} else if (currentRel.getType().equals(parentRelation.getType())) {
						// parent is a real parent
						hasParent = true;
					}
					if (hasParent) {
						break;
					}
				}
			}
			if (!hasParent) {
				// current relation is a root
				String type = currentRel.getType();
				if (type == null) {
					type = SaltUtil.SALT_NULL_VALUE;
				}
				retVal.put(type, currentRel.getSource());
			}
		}

		return (retVal);
	}

	// ====================================================== start: traversing
	// mechanism
	/**
	 * types of traversions, used by the several methods, used as id for
	 * traversion
	 */
	public enum TRAVERSION_TYPE {
		OVERLAPPED_DS_SEQUENCES, OVERLAPPED_STOKEN
	};

	private static class Traverser implements GraphTraverseHandler {
		public Traverser() {

		}

		/**
		 * in case of traversion type is
		 * {@link TRAVERSION_TYPE#OVERLAPPED_DS_SEQUENCES} or
		 * {@link TRAVERSION_TYPE#OVERLAPPED_STOKEN}, here are the relation
		 * types, which shall be used for traversion
		 */
		private Set<SALT_TYPE> relationTypes2Traverse = null;

		/**
		 * in case of traversion type is
		 * {@link TRAVERSION_TYPE#OVERLAPPED_DS_SEQUENCES}, the results are
		 * stored here
		 */
		private List<DataSourceSequence> dataSourceSequences = null;

		/**
		 * in case of traversion type is
		 * {@link TRAVERSION_TYPE#OVERLAPPED_STOKEN}, the results are stored
		 * here
		 */
		private HashSet<SToken> overlappedSToken = null;

		/**
		 * in case of traversion type is
		 * {@link TRAVERSION_TYPE#OVERLAPPED_DS_SEQUENCES}, stores the last seen
		 * data source
		 */
		private DataSourceSequence lastSeenDSSequence = null;

		@Override
		public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation<? extends SNode, ? extends SNode> relation, SNode fromNode, long order) {
			if (TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.equals(TRAVERSION_TYPE.valueOf(traversalId))) {// TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
				if (currNode instanceof SSequentialDS) {
					SSequentialDS dataSource = (SSequentialDS) currNode;
					DataSourceSequence sequence = null;
					if (dataSourceSequences == null) {
						dataSourceSequences = new ArrayList<DataSourceSequence>();
					}
					for (DataSourceSequence dsSequence : this.dataSourceSequences) {
						// search for correct sequence, containing the
						// datasource if it was already found
						if (dsSequence.getDataSource().equals(dataSource)) {
							sequence = dsSequence;
							lastSeenDSSequence = dsSequence;
							break;
						}
					} // search for correct sequence, containing the datasource
						// if it was already found
					if (sequence == null) {
						// sequence haven't been visit -> create it
						sequence = new DataSourceSequence();
						sequence.setDataSource(dataSource);
						lastSeenDSSequence = sequence;
						dataSourceSequences.add(sequence);
					} // sequence haven't been visit -> create it
				}
			} // TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
			else {
				if (TRAVERSION_TYPE.OVERLAPPED_STOKEN.equals(TRAVERSION_TYPE.valueOf(traversalId))) {
					// if a SToken was reached
					if (currNode instanceof SToken) {
						// add it to the overlapped token list
						overlappedSToken.add(((SToken) currNode));
					}
				}
			}
		}

		/**
		 * 
		 */
		@Override
		public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation<? extends SNode, ? extends SNode> relation, SNode fromNode, long order) {
			if (TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.equals(TRAVERSION_TYPE.valueOf(traversalId))) {
				// TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
				if (currNode instanceof SSequentialDS) {
					// check if current start and end value is smaller or
					// bigger, than reset
					if (relation == null) {
						lastSeenDSSequence.setDataSource((SSequentialDS) currNode);
						lastSeenDSSequence.setStart(((SSequentialDS) currNode).getStart());
						lastSeenDSSequence.setEnd(((SSequentialDS) currNode).getEnd());
					} else {
						if (relation instanceof SSequentialRelation) {
							SSequentialRelation<SToken, ? extends SSequentialDS, ? extends Number> seqRel = (SSequentialRelation) relation;
							if (seqRel.getStart() == null) {
								throw new SaltInvalidModelException("Cannot return overlapped DataSourceSequences, because the graph is inconsistent. The sStart value the SSequentialRelation '" + seqRel + "' is not set. ");
							} else if (seqRel.getEnd() == null) {
								throw new SaltInvalidModelException("Cannot return overlapped DataSourceSequences, because the graph is inconsistent. The sEnd value the SSequentialRelation '" + seqRel + "' is not set. ");
							}
							if ((lastSeenDSSequence.getStart() == null) || (seqRel.getStart().doubleValue() < this.lastSeenDSSequence.getStart().doubleValue())) {
								// if start value wasn't set or is higher than
								// current one
								lastSeenDSSequence.setStart(seqRel.getStart());
							}
							if ((lastSeenDSSequence.getEnd() == null) || (seqRel.getEnd().doubleValue() > this.lastSeenDSSequence.getEnd().doubleValue())) {
								// if end value wasn't set or is higher than
								// current one
								lastSeenDSSequence.setEnd(seqRel.getEnd());
							}
						}
					}
				}
			}

		}

		@Override
		public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation<? extends SNode, ? extends SNode> relation, SNode currNode, long order) {
			boolean retVal = false;
			if (TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.equals(TRAVERSION_TYPE.valueOf(traversalId))) {// TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
				if (relation != null) {
					if (((this.relationTypes2Traverse.contains(SALT_TYPE.STEXT_OVERLAPPING_RELATION)) || (this.relationTypes2Traverse.contains(SALT_TYPE.SSEQUENTIAL_RELATION))) && (relation instanceof STextOverlappingRelation)) {
						retVal = true;
					} else if (((this.relationTypes2Traverse.contains(SALT_TYPE.STIME_OVERLAPPING_RELATION)) || (this.relationTypes2Traverse.contains(SALT_TYPE.SSEQUENTIAL_RELATION))) && (relation instanceof STimeOverlappingRelation)) {
						retVal = true;
					}
				} else {
					retVal = true;
				}
			} // TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
			else {
				if (TRAVERSION_TYPE.OVERLAPPED_STOKEN.equals(TRAVERSION_TYPE.valueOf(traversalId))) {
					// there is a relation
					if (relation != null) {
						// get the typename for the sRelation class
						Set<SALT_TYPE> typeName = SALT_TYPE.class2SaltType(relation.getClass());
						// found matching SType for an implemented interface
						for (SALT_TYPE name : typeName) {
							if (this.relationTypes2Traverse.contains(name)) {
								return (true);
							}
						}
					} else {
						retVal = true;
					}
				}
			}
			return (retVal);
		}
	}
}
