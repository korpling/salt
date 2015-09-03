///**
// * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *       http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// *
// *
// */
//package de.hu_berlin.u.saltnpepper.salt.util;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//
//import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialDS;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialRelation;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructure;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextOverlappingRelation;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimeOverlappingRelation;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimeline;
//import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
//import de.hu_berlin.u.saltnpepper.salt.core.GraphTraverseHandler;
//import de.hu_berlin.u.saltnpepper.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
//import de.hu_berlin.u.saltnpepper.salt.core.SNode;
//import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
//import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltParameterException;
//
///**
// * Provides some methods for an easier access to objects being contained by a
// * given {@link SDocumentGraph} object.
// * 
// * @author Florian Zipser
// *
// */
//public class DataSourceAccessor {
//	// ==================================== start: accessing concerning timeline
//	/**
//	 * Returns all {@link SToken} objects which refer to the passed
//	 * {@link DataSourceSequence} object. The passed object determines the
//	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
//	 * and the type of datasource by the instance <em>sSequentialDS</em>.
//	 * 
//	 * @param DataSourceSequence
//	 *            an object determing the sequence to which the returned
//	 *            {@link SToken} objects refer to.
//	 * @return a list of {@link SToken} objects which refer or overlap the
//	 *         passed sequence
//	 */
//	public static List<SToken> getSTokensBySequence(SDocumentGraph documentGraph, DataSourceSequence DataSourceSequence) {
//		List<Class<? extends SNode>> classes = new ArrayList<Class<? extends SNode>>();
//		classes.add(SToken.class);
//		@SuppressWarnings("unchecked")
//		List<SToken> sTokens = ((List<SToken>) (List<? extends SNode>) getSNodesBySequence(documentGraph, DataSourceSequence, classes));
//
//		return (sTokens);
//	}
//
//	/**
//	 * Returns all {@link SSpan} objects which refer to the passed
//	 * {@link DataSourceSequence} object. The passed object determines the
//	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
//	 * and the type of datasource by the instance <em>sSequentialDS</em>.
//	 * 
//	 * @param DataSourceSequence
//	 *            an object determing the sequence to which the returned
//	 *            {@link SSpan} objects refer to.
//	 * @return a list of {@link SSpan} objects which refer or overlap the passed
//	 *         sequence
//	 */
//	public static List<SSpan> getSSpanBySequence(SDocumentGraph documentGraph, DataSourceSequence DataSourceSequence) {
//		List<Class<? extends SNode>> classes = new ArrayList<>();
//		classes.add(SSpan.class);
//		@SuppressWarnings("unchecked")
//		List<SSpan> sSpans = ((List<SSpan>) (List<? extends SNode>) getSNodesBySequence(documentGraph, DataSourceSequence, classes));
//
//		return (sSpans);
//	}
//
//	/**
//	 * Returns all {@link SStructure} objects which refer to the passed
//	 * {@link DataSourceSequence} object. The passed object determines the
//	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
//	 * and the type of datasource by the instance <em>sSequentialDS</em>.
//	 * 
//	 * @param DataSourceSequence
//	 *            an object determing the sequence to which the returned
//	 *            {@link SStructure} objects refer to.
//	 * @return a list of {@link SStructure} objects which refer or overlap the
//	 *         passed sequence
//	 */
//	public static List<SStructure> getSStructureBySequence(SDocumentGraph documentGraph, DataSourceSequence DataSourceSequence) {
//		List<Class<? extends SNode>> classes = new ArrayList<Class<? extends SNode>>();
//		classes.add(SStructure.class);
//		@SuppressWarnings("unchecked")
//		List<SStructure> sStructs = ((List<SStructure>) (List<? extends SNode>) getSNodesBySequence(documentGraph, DataSourceSequence, classes));
//
//		return (sStructs);
//	}
//
//	/**
//	 * Returns all {@link SNode} objects which refer to the passed
//	 * {@link DataSourceSequence} object. The passed object determines the
//	 * borders of the sequence by the values <em>sStart</em> and <em>sEnd</em>
//	 * and the type of datasource by the instance <em>sSequentialDS</em>.
//	 * 
//	 * @param DataSourceSequence
//	 *            an object determing the sequence to which the returned
//	 *            {@link SNode} objects refer to.
//	 * @return a list of {@link SNode} objects which refer or overlap the passed
//	 *         sequence
//	 */
//	public static List<? extends SNode> getSNodeBySequence(SDocumentGraph documentGraph, DataSourceSequence DataSourceSequence) {
//		List<Class<? extends SNode>> classes = new ArrayList<Class<? extends SNode>>();
//		classes.add(SNode.class);
//		List<? extends SNode> sNodes = getSNodesBySequence(documentGraph, DataSourceSequence, classes);
//
//		return (sNodes);
//	}
//
//	/**
//	 * Searches for all {@link SNode} objects of the given node type, which
//	 * cover the given sequence.
//	 * 
//	 * @param sequence
//	 *            sequence, which is overlapped
//	 * @param nodeClasses
//	 *            type of nodes to be returned
//	 * @return nodes, which overlaps the given sequence
//	 */
//	private static List<SNode> getSNodesBySequence(SDocumentGraph documentGraph, DataSourceSequence sequence, List<Class<? extends SNode>> nodeClasses) {
//		if (sequence == null) {
//			new SaltParameterException("Cannot start returning nodes overlapping a data source, because the 'DataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
//		}
//		if (sequence.getStart() == -1) {
//			new SaltParameterException("Cannot start returning nodes overlapping a data source, because the 'sStart' value of the 'DataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
//		}
//		if (sequence.getEnd() == -1) {
//			new SaltParameterException("Cannot start returning nodes overlapping a data source, because the 'sEnd' value of the 'DataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
//		}
//		if (documentGraph == null) {
//			new SaltParameterException("Cannot start method please set the document graph first.");
//		}
//
//		List<SNode> nodes = null;
//		List<? extends SSequentialRelation> sSeqRels = null;
//		if (sequence.getDataSource() instanceof STextualDS) {
//			sSeqRels = documentGraph.getTextualRelations();
//		} else if (sequence.getDataSource() instanceof STimeline) {
//			sSeqRels = documentGraph.getTimelineRelations();
//		} else {
//			throw new SaltParameterException("Cannot compute overlaped nodes, because the given dataSource is not supported by this method.");
//		}
//		for (SSequentialRelation sSeqRel : sSeqRels) {
//			// walk through all sequential relations
//			if ((sequence.getDataSource().equals(sSeqRel.getTarget())) && (sSeqRel.getStart() >= sequence.getStart()) && (sSeqRel.getEnd() <= sequence.getEnd())) {
//				// sequential relation is in the interval
//				for (Class<? extends SNode> nodeClass : nodeClasses) {
//					if (nodes == null)
//						nodes = new ArrayList<SNode>();
//					if (nodeClass.isInstance(sSeqRel.getSource())) {
//						// source is of correct type
//						nodes.add(sSeqRel.getSource());
//					}
//				}
//			}// sequential relation is in the interval
//		}// walk through all sequential relations
//		return (nodes);
//	}
//
//	/**
//	 * {@inheritDoc SDocumentGraph#isContinuousByText(List)} First sorts the
//	 * given lists, than searches first occurance of first node in subSNodList
//	 * in fullSNodList. Starting from this index, the method compares each
//	 * element in subSNodList to element i in fullSNodList. If one is not equal
//	 * the method returns false.
//	 */
//	// TODO must be enabled for all SNode lists and not only SToken lists
//	public static boolean isContinuousByText(SDocumentGraph documentGraph, List<? extends SNode> subSNodList, List<? extends SNode> fullSNodList) {
//		if (documentGraph == null) {
//			new SaltParameterException("Cannot start method 'getContinuously(List<SToken>, List<SToken>)' please set the document graph first.");
//		}
//		Boolean retVal = null;
//		// compute sorted list of overlapped tokens by the given sStructuredNode
//		@SuppressWarnings("unchecked")
//		List<SToken> overlappedSTokens = getSortedSTokenByText(documentGraph, (List<SToken>) subSNodList);
//
//		retVal = true;
//
//		Integer posOfFirstOverlappedToken = fullSNodList.indexOf(overlappedSTokens.get(0));
//		int ctr = 0;
//		SToken sTokInAllTokens = null;
//		for (SToken sToken : overlappedSTokens) {
//			// count the token in fullSTokenList
//			sTokInAllTokens = (SToken) fullSNodList.get(posOfFirstOverlappedToken + ctr);
//			if (sToken.hashCode() != sTokInAllTokens.hashCode()) {
//				// tokens at same position relative to their list are not equal
//				retVal = false;
//				break;
//			}// tokens at same position relative to their list are not equal
//			ctr++;
//		}
//		return (retVal);
//	}
//
//	/**
//	 * {@inheritDoc SDocumentGraph#isContinuousByText(List)}
//	 */
//	public static boolean isContinuousByText(SDocumentGraph documentGraph, List<SNode> subSNodList) {
//		return (isContinuousByText(documentGraph, subSNodList, getSortedSTokenByText(documentGraph)));
//	}
//
//	/**
//	 * {@inheritDoc SDocumentGraph#sortSTokenByText()}
//	 */
//	public static void sortSTokenByText(SDocumentGraph documentGraph) {
//		if (documentGraph == null) {
//			new SaltParameterException("Cannot start method please set the document graph first.");
//		}
//		if (documentGraph.getTokens() != null) {
//			STokenSStartComparator comparator = new STokenSStartComparator();
//			comparator.setSDocumentGraph(documentGraph);
//
//			// sort tokens
//			List<SToken> tokens = documentGraph.getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SToken.class);
//			List<SToken> mutableTokens = new LinkedList<SToken>(tokens);
//			Collections.sort(mutableTokens, comparator);
//			documentGraph.getIndexMgr().remove(SaltUtil.IDX_NODETYPE, SToken.class);
//			documentGraph.getIndexMgr().putAll(SaltUtil.IDX_NODETYPE, SToken.class, mutableTokens);
//
//			STextualRelationSStartComparator comparatortextrels = new STextualRelationSStartComparator();
//			comparatortextrels.setSDocumentGraph(documentGraph);
//
//			// sort textual relations
//			List<STextualRelation> textualRelations = documentGraph.getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, STextualRelation.class);
//			List<STextualRelation> mutableTextualRelations = new LinkedList<STextualRelation>(textualRelations);
//			Collections.sort(mutableTextualRelations, comparatortextrels);
//			documentGraph.getIndexMgr().remove(SaltUtil.IDX_RELATIONTYPE, STextualRelation.class);
//			documentGraph.getIndexMgr().putAll(SaltUtil.IDX_RELATIONTYPE, STextualRelation.class, mutableTextualRelations);
//
//		}
//	}
//
//	/**
//	 * {@inheritDoc SDocumentGraph#getSortedSTokenByText(List)}
//	 */
//	public static List<SToken> getSortedSTokenByText(SDocumentGraph documentGraph, List<SToken> sTokens2sort) {
//		if (documentGraph == null) {
//			new SaltParameterException("Cannot start method please set the document graph first.");
//		}
//		List<SToken> retVal = null;
//		if (sTokens2sort != null) {
//			STokenSStartComparator comparator = new STokenSStartComparator();
//			comparator.setSDocumentGraph(documentGraph);
//			retVal = new ArrayList<SToken>();
//			retVal.addAll(sTokens2sort);
//			// sort tokens
//			Collections.sort(retVal, comparator);
//		}
//		return (retVal);
//	}
//
//	/**
//	 * {@inheritDoc SDocumentGraph#getSortedSTokenByText()}
//	 */
//	public static List<SToken> getSortedSTokenByText(SDocumentGraph documentGraph) {
//		List<SToken> retVal = null;
//		if (documentGraph == null) {
//			new SaltParameterException("Cannot start method please set the document graph first.");
//		}
//
//		if ((documentGraph.getTextualDSs() != null) && (documentGraph.getTextualDSs().size() > 0)) {
//			retVal = new ArrayList<>();
//			for (STextualDS sTextualDS : documentGraph.getTextualDSs()) {
//				DataSourceSequence sequence = new DataSourceSequence();
//				sequence.setDataSource(sTextualDS);
//				sequence.setStart(0);
//				sequence.setEnd((sTextualDS.getText() != null) ? sTextualDS.getText().length() : 0);
//				List<SToken> sTokens = getSTokensBySequence(documentGraph, sequence);
//				if (sTokens != null) {
//					retVal.addAll(getSortedSTokenByText(documentGraph, sTokens));
//				}
//			}
//		}
//		return (retVal);
//	}
//
//	/**
//	 * {@inheritDoc SDocumentGraph#getOverlappedDSSequences(SNode, List)}
//	 */
//	public static List<DataSourceSequence> getOverlappedDSSequences(SDocumentGraph documentGraph, SNode sNode, List<SALT_TYPE> sRelationTypes) {
//		List<SNode> rootSNodes = new ArrayList<>();
//		rootSNodes.add(sNode);
//		return (getOverlappedDSSequences(documentGraph, rootSNodes, sRelationTypes));
//	}
//
//	/**
//	 * {@inheritDoc SDocumentGraph#getOverlappedDSSequences(SNode, List)}
//	 */
//	// TODO this method can be fasten up, by remembering the overlapped
//	// sequences for each node and not traverse deeper, when the sequence is
//	// already computed for a node
//	public static List<DataSourceSequence> getOverlappedDSSequences(SDocumentGraph documentGraph, List<SNode> sNodes, List<SALT_TYPE> sRelationTypes) {
//
//		relationTypes2Traverse = sRelationTypes;
//		documentGraph.traverse(sNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.toString(), this);
//		return (DataSourceSequences);
//	}
//
//	/**
//	 * This method searches for every {@link SToken} which is (transitively)
//	 * overlapped by the given {@link SNode} by {@link SRelation} types which
//	 * have one of the types given in the overlappingRelationTypes list.
//	 * 
//	 * @param overlappingNode
//	 *            the node for which the overlapped {@link SToken} objects are
//	 *            searched
//	 * @param overlappingRelationTypes
//	 *            the list of {@link SALT_TYPE}s which are used for traversion.
//	 *            If, for example, all {@link SToken} are searched which are
//	 *            overlapped by a {@link SStructure}, the
//	 *            {@link SALT_TYPE.SDOMINANCE_RELATION} and
//	 *            {@link SALT_TYPE.SPANNING_RELATION} should be contained in
//	 *            this parameter.
//	 * @return a list of {@link SToken} which are overlapped by the
//	 *         overlappingNode.
//	 */
//	public static List<SToken> getOverlappedSTokens(SDocumentGraph documentGraph, SNode overlappingNode, List<SALT_TYPE> overlappingRelationTypes) {
//		// initialise the overlappedSToken List
//		overlappedSToken = new HashSet<SToken>();
//		// initialise the relationTypes2Traverse List
//		relationTypes2Traverse = overlappingRelationTypes;
//		List<SNode> rootNodes = new ArrayList<>();
//		rootNodes.add(overlappingNode);
//		documentGraph.traverse(rootNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAVERSION_TYPE.OVERLAPPED_STOKEN.toString(), documentGraph);
//
//		return (new ArrayList<SToken>(overlappedSToken));
//	}
//	
//	// ====================================================== start: traversing
//	// mechanism
//	/**
//	 * types of traversions, used by the several methods, used as id for
//	 * traversion
//	 */
//	public enum TRAVERSION_TYPE {
//		OVERLAPPED_DS_SEQUENCES, OVERLAPPED_STOKEN
//	};
//
//	private class Traverser implements GraphTraverseHandler {
//
//		/**
//		 * in case of traversion type is
//		 * {@link TRAVERSION_TYPE#OVERLAPPED_DS_SEQUENCES} or
//		 * {@link TRAVERSION_TYPE#OVERLAPPED_STOKEN}, here are the relation
//		 * types, which shall be used for traversion
//		 */
//		private List<SALT_TYPE> relationTypes2Traverse = null;
//
//		/**
//		 * in case of traversion type is
//		 * {@link TRAVERSION_TYPE#OVERLAPPED_DS_SEQUENCES}, the results are
//		 * stored here
//		 */
//		private List<DataSourceSequence> DataSourceSequences = null;
//
//		/**
//		 * in case of traversion type is
//		 * {@link TRAVERSION_TYPE#OVERLAPPED_STOKEN}, the results are stored
//		 * here
//		 */
//		private HashSet<SToken> overlappedSToken = null;
//
//		/**
//		 * in case of traversion type is
//		 * {@link TRAVERSION_TYPE#OVERLAPPED_DS_SEQUENCES}, stores the last seen
//		 * data source
//		 */
//		private DataSourceSequence lastSeenDSSequence = null;
//
//		@Override
//		public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation<SNode, SNode> relation, SNode fromNode, long order) {
//			if (TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.equals(TRAVERSION_TYPE.valueOf(traversalId))) {// TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
//				if (currNode instanceof SSequentialDS) {
//					SSequentialDS dataSource = (SSequentialDS) currNode;
//					DataSourceSequence sequence = null;
//					if (this.DataSourceSequences == null)
//						this.DataSourceSequences = new ArrayList<DataSourceSequence>();
//					for (DataSourceSequence dsSequence : this.DataSourceSequences) {
//						// search for correct sequence, containing the
//						// datasource if it was already found
//						if (dsSequence.getDataSource().equals(dataSource)) {
//							sequence = dsSequence;
//							this.lastSeenDSSequence = dsSequence;
//							break;
//						}
//					}// search for correct sequence, containing the datasource
//						// if it was already found
//					if (sequence == null) {// sequence haven't been visit ->
//											// create it
//						sequence = new DataSourceSequence();
//						sequence.setDataSource(dataSource);
//						this.lastSeenDSSequence = sequence;
//						this.DataSourceSequences.add(sequence);
//					}// sequence haven't been visit -> create it
//				}
//			}// TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
//			else {
//				if (TRAVERSION_TYPE.OVERLAPPED_STOKEN.equals(TRAVERSION_TYPE.valueOf(traversalId))) {
//					// if a SToken was reached
//					if (currNode instanceof SToken) {
//						// add it to the overlapped token list
//						this.overlappedSToken.add(((SToken) currNode));
//					}
//				}
//			}
//		}
//
//		/**
//		 * 
//		 */
//		@Override
//		public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation<SNode, SNode> relation, SNode fromNode, long order) {
//			if (TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.equals(TRAVERSION_TYPE.valueOf(traversalId))) {
//				// TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
//				if (currNode instanceof SSequentialDS) {
//					// check if current start and end value is smaller or bigger, than reset
//					SSequentialRelation seqRel = (SSequentialRelation) relation;
//					try {
//						if ((relation == null) && (currNode instanceof SSequentialDS)) {
//							this.lastSeenDSSequence.setDataSource((SSequentialDS) currNode);
//							this.lastSeenDSSequence.setStart(((SSequentialDS) currNode).getStart());
//							this.lastSeenDSSequence.setEnd(((SSequentialDS) currNode).getEnd());
//						} else {
//							if ((this.lastSeenDSSequence.getStart() == null) || (seqRel.getStart() < this.lastSeenDSSequence.getStart())) {
//								// if start value wasn't set or is higher than
//								// current one
//								this.lastSeenDSSequence.setStart(seqRel.getStart());
//							}
//							if ((this.lastSeenDSSequence.getEnd() == null) || (seqRel.getEnd() > this.lastSeenDSSequence.getEnd())) {
//								// if end value wasn't set or is higher than
//								// current one
//								this.lastSeenDSSequence.setSEnd(seqRel.getEnd());
//							}
//						}
//					} catch (NullPointerException e) {
//						if (seqRel.getStart() == null) {
//							throw new SaltParameterException("Cannot return overlapped DataSourceSequences, because the graph is inconsistent. The sStart value the SSequentialRelation '" + seqRel + "' is not set.", e);
//						} else if (seqRel.getEnd() == null) {
//							throw new SaltParameterException("Cannot return overlapped DataSourceSequences, because the graph is inconsistent. The sEnd value the SSequentialRelation '" + seqRel + "' is not set.", e);
//						} else {
//							throw e;
//						}
//					}
//				}
//			} else {
//				if (TRAVERSION_TYPE.OVERLAPPED_STOKEN.equals(TRAVERSION_TYPE.valueOf(traversalId))) {
//					// do nothing?
//				}
//			}
//
//		}
//
//		@Override
//		public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation<SNode, SNode> relation, SNode currNode, long order) {
//			boolean retVal = false;
//			if (TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.equals(TRAVERSION_TYPE.valueOf(traversalId))) {// TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
//				if (relation != null) {
//					if (((this.relationTypes2Traverse.contains(SALT_TYPE.STEXT_OVERLAPPING_RELATION)) || (this.relationTypes2Traverse.contains(SALT_TYPE.SSEQUENTIAL_RELATION))) && (sRelation instanceof STextOverlappingRelation)) {
//						retVal = true;
//					} else if (((this.relationTypes2Traverse.contains(SALT_TYPE.STIME_OVERLAPPING_RELATION)) || (this.relationTypes2Traverse.contains(SALT_TYPE.SSEQUENTIAL_RELATION))) && (sRelation instanceof STimeOverlappingRelation)) {
//						retVal = true;
//					}
//				} else
//					retVal = true;
//
//			}// TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
//			else {
//				if (TRAVERSION_TYPE.OVERLAPPED_STOKEN.equals(TRAVERSION_TYPE.valueOf(traversalId))) {
//					// there is a relation
//					if (relation != null) {
//						// get the typename for the sRelation class
//						HashSet<SALT_TYPE> typeName = SaltFactory.convertClazzToSTypeName(relation.getClass());
//						if (typeName != null) {
//							// found matching SType for an implemented interface
//							for (SALT_TYPE name : typeName) {
//								if (this.relationTypes2Traverse.contains(name)) {
//									return (true);
//								}
//							}
//
//						}
//					} else {
//						retVal = true;
//					}
//				}
//			}
//			return (retVal);
//		}
//	}
//}
