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
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.corpus_tools.salt.SALT_TYPE;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSequentialDS;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.util.DIFF_TYPES;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;
import org.corpus_tools.salt.util.SaltUtil;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class DocumentStructureDiff extends AbstractDiff<SDocumentGraph> {

	/**
	 * Initializes Diff object with the two graphs <code>template</code> and
	 * <code>other</code>.
	 * 
	 * @param template
	 * @param other
	 */
	public DocumentStructureDiff(SDocumentGraph template, SDocumentGraph other) {
		this(template, other, null);
	}

	public DocumentStructureDiff(SDocumentGraph template, SDocumentGraph other, DiffOptions optionMap) {
		super(template, other, optionMap);
	}

	/**
	 * Compares the set graphs and returns if they are isomorphic or not. If
	 * graphs are not isomporphic, this method finds and records all differences
	 * and lists them. This means the entire graphs have to be compared and
	 * could slow down the computation. If you are only interested in the result
	 * and not in the particular differences, use method {@link #isIsomorph()}.
	 * 
	 * @param diffsRequested
	 *            if false, only isomorphie is computed, which makes the process
	 *            faster but does not collect all differences
	 * @return true, if graphs are isomorphic, false otherwise.
	 */
	@Override
	protected boolean findDiffs(boolean diffsRequested) {
		if (!compareSize(templateGraph, otherGraph)) {
			if (!diffsRequested) {
				return false;
			}
		}
		if (!compareDataSources(templateGraph, otherGraph, diffsRequested)) {
			if (!diffsRequested) {
				return false;
			}
		}
		if (!compareTokens(templateGraph, otherGraph, diffsRequested)) {
			if (!diffsRequested) {
				return false;
			}
		}
		final List<SNode> roots = otherGraph.getRootsByRelation(SALT_TYPE.SSPANNING_RELATION, SALT_TYPE.SDOMINANCE_RELATION);
		if ((SaltUtil.isNullOrEmpty(roots))) {
			// logger.warn("Cannot start computing of differences, since no
			// tokens exist for document '{}'.",
			// templateGraph.getId());
		} else {
			final List<SNode> remainingTemplateNodes = new ArrayList<>(templateGraph.getSpans().size() + templateGraph.getStructures().size());
			remainingTemplateNodes.addAll(templateGraph.getSpans());
			remainingTemplateNodes.addAll(templateGraph.getStructures());
			final DifferenceHandler handler = new DifferenceHandler();
			handler.remainingTemplateNodes = remainingTemplateNodes;
			otherGraph.traverse(roots, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "diff_" + templateGraph.getId(), handler, false);
			if (getDifferences().size() > 0) {
				return (false);
			}
			if (remainingTemplateNodes.size() > 0) {
				for (SNode remainingNode : remainingTemplateNodes) {
					if (!diffsRequested) {
						return false;
					}
					addDifference(remainingNode, null, null, DIFF_TYPES.NODE_MISSING, null);
				}
			}
		}
		// compare pointing relations
		if (!compareRelations(templateGraph, templateGraph.getPointingRelations(), otherGraph, otherGraph.getPointingRelations(), diffsRequested)) {
			if (!diffsRequested) {
				return false;
			}
		}
		// compare order relations
		if (!compareRelations(templateGraph, templateGraph.getOrderRelations(), otherGraph, otherGraph.getOrderRelations(), diffsRequested)) {
			if (!diffsRequested) {
				return false;
			}
		}
		// compare layers
		if (!options.get(DiffOptions.OPTION_IGNORE_LAYER)) {
			if (!compareLayers(templateGraph, otherGraph, diffsRequested)) {
				if (!diffsRequested) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This method tests whether in both graphs are the same number of objects
	 * contained. Number of:
	 * <ul>
	 * <li>nodes</li>
	 * <li>relations</li>
	 * <li>textual data sources</li>
	 * <li>textual relations</li>
	 * <li>tokens</li>
	 * <li>order relations</li>
	 * <li>pointing relations</li>
	 * <li>spanning relations</li>
	 * <li>spans</li>
	 * <li>dominance relations</li>
	 * <li>structures</li>
	 * <li>medial data sources</li>
	 * <li>medial relations</li>
	 * <li>timeline relations</li>
	 * </ul>
	 * 
	 * @param template
	 *            first SDocGraph
	 * @param other
	 *            second SDocGraph
	 * @return returns whether sizes are the same
	 **/
	private boolean compareSize(SDocumentGraph template, SDocumentGraph other) {
		// size comparison for all data structures in Salt beside STimeline
		if (template.getNodes().size() != other.getNodes().size()) {
			return false;
		}
		if (template.getRelations().size() != other.getRelations().size()) {
			return false;
		}
		if (template.getTextualDSs().size() != other.getTextualDSs().size()) {
			return false;
		}
		if (template.getTextualRelations().size() != other.getTextualRelations().size()) {
			return false;
		}
		if (template.getTokens().size() != other.getTokens().size()) {
			return false;
		}
		if (template.getOrderRelations().size() != other.getOrderRelations().size()) {
			return false;
		}
		if (template.getPointingRelations().size() != other.getPointingRelations().size()) {
			return false;
		}
		if (template.getSpanningRelations().size() != other.getSpanningRelations().size()) {
			return false;
		}
		if (template.getSpans().size() != other.getSpans().size()) {
			return false;
		}
		if (template.getDominanceRelations().size() != other.getDominanceRelations().size()) {
			return false;
		}
		if (template.getStructures().size() != other.getStructures().size()) {
			return false;
		}
		if (template.getMedialDSs().size() != other.getMedialDSs().size()) {
			return false;
		}
		if (template.getMedialRelations().size() != other.getMedialRelations().size()) {
			return false;
		}
		if (template.getTimelineRelations().size() != other.getTimelineRelations().size()) {
			return false;
		}
		if (!options.get(DiffOptions.OPTION_IGNORE_LAYER)) {
			if (template.getLayers().size() != other.getLayers().size()) {
				return (false);
			}
		}
		return true;
	}

	/**
	 * Checks all data sources and calls for each type
	 * {@link #compareDataSources(List, List, boolean)}
	 * 
	 * @param template
	 * @param other
	 * @param diff
	 * @return
	 */
	private boolean compareDataSources(SDocumentGraph template, SDocumentGraph other, boolean diff) {
		// compare textual data sources
		boolean retVal1 = compareDataSources((List<SSequentialDS>) (List<? extends SSequentialDS>) template.getTextualDSs(), (List<SSequentialDS>) (List<? extends SSequentialDS>) other.getTextualDSs(), diff);
		// speed up
		if (!diff && !retVal1) {
			return (retVal1);
		}
		// compare medial data sources
		boolean retVal2 = compareDataSources((List<SSequentialDS>) (List<? extends SSequentialDS>) template.getMedialDSs(), (List<SSequentialDS>) (List<? extends SSequentialDS>) other.getMedialDSs(), diff);
		return (retVal1 && retVal2);
	}

	/**
	 * To check whether all {@link SSequentialDS} have a partner, create a map
	 * for all {@link SSequentialDS} in template having the data as key and the
	 * {@link SSequentialDS} as value. Next check all {@link SSequentialDS} of
	 * other if they have a mapping partner.
	 * 
	 * @return isomorphie still possible after this check
	 * @param template
	 *            first sDocGraph
	 * @param other
	 *            second sDocGraph
	 * @param diff
	 *            if true, diffs are checked as well
	 **/
	private boolean compareDataSources(List<SSequentialDS> template, List<SSequentialDS> other, boolean diff) {
		boolean iso = true;
		Map<Object, SSequentialDS> dataToDS = new Hashtable<>();
		// data sources from template which have no partner in other
		Set<SSequentialDS> remainingTemplates = new HashSet<>();

		// put all template data source to map
		Iterator<SSequentialDS> iterator = template.iterator();
		while (iterator.hasNext()) {
			SSequentialDS templateDS = iterator.next();
			dataToDS.put(templateDS.getData(), templateDS);
			remainingTemplates.add(templateDS);
		}

		// check all other data source with map
		iterator = other.iterator();
		while (iterator.hasNext()) {
			SSequentialDS otherDS = iterator.next();
			SSequentialDS templateDS = dataToDS.get(otherDS.getData());
			if (templateDS == null) {
				if (!diff) {
					return false;
				}
				iso = false;
				addDifference(null, otherDS, null, DIFF_TYPES.NODE_MISSING, null);
			} else {
				getIsoNodes().put(templateDS, otherDS);
				// check whether both data sources have the same id
				Set<Difference> subDiffs = new HashSet<Difference>();
				compareIdentifiableElements(templateDS, otherDS, subDiffs);
				if (subDiffs.size() > 0) {
					if (!diff) {
						return false;
					}
					iso = false;
					addDifference(templateDS, otherDS, null, DIFF_TYPES.NODE_DIFFERING, subDiffs);
				}
				// check whether both data sources have the same labels
				subDiffs = new HashSet<Difference>();
				compareAnnotationContainers(templateDS, otherDS, subDiffs);
				if (subDiffs.size() > 0) {
					if (!diff) {
						return false;
					}
					iso = false;
					addDifference(templateDS, otherDS, null, DIFF_TYPES.NODE_DIFFERING, subDiffs);
				}
				remainingTemplates.remove(templateDS);
			}
		}

		// check the remaining data sources
		if (remainingTemplates.size() > 0) {
			iterator = remainingTemplates.iterator();
			while (iterator.hasNext()) {
				SSequentialDS templateDS = iterator.next();
				if (!diff) {
					return false;
				}
				iso = false;
				addDifference(templateDS, null, null, DIFF_TYPES.NODE_MISSING, null);
			}
		}
		return (iso);
	}

	/**
	 * method to check {@link SToken}s for isomorphie
	 * 
	 * @param template
	 *            first sDocGraph
	 * @param other
	 *            second sDocGraph
	 * @param diff
	 *            if true, differences are checked as well
	 * @return isomorphie still possible after this check
	 **/
	private boolean compareTokens(SDocumentGraph template, SDocumentGraph other, boolean diff) {
		boolean iso = true;
		Map<STextualDS, Map<String, STextualRelation>> textDSsToOffsetMap = new Hashtable<>();
		// data sources from template which have no partner in other
		Set<STextualRelation> remainingTemplates = new HashSet<>();
		Iterator<STextualRelation> iterator = template.getTextualRelations().iterator();
		while (iterator.hasNext()) {
			STextualRelation textRel = iterator.next();
			Map<String, STextualRelation> offsetMap = textDSsToOffsetMap.get(textRel.getTarget());
			if (offsetMap == null) {
				offsetMap = new Hashtable<>();
				textDSsToOffsetMap.put(textRel.getTarget(), offsetMap);
			}
			offsetMap.put(textRel.getStart() + "#" + textRel.getEnd(), textRel);
			remainingTemplates.add(textRel);
		}

		// check all other data source with map
		iterator = other.getTextualRelations().iterator();
		while (iterator.hasNext()) {
			STextualRelation otherRel = iterator.next();
			STextualDS templateDS = (STextualDS) getIsoNodes().inverse().get(otherRel.getTarget());
			if (templateDS != null) {
				Map<String, STextualRelation> offsetMap = textDSsToOffsetMap.get(templateDS);
				STextualRelation templateRel = offsetMap.get(otherRel.getStart() + "#" + otherRel.getEnd());
				if (templateRel == null) {
					// no partner for rel was found, since the combination
					// textual data source, start and end value has matched
					if (!diff) {
						return false;
					}
					iso = false;
					addDifference(null, otherRel.getTarget(), null, DIFF_TYPES.NODE_MISSING, null);
				} else {
					// add tokens to isomorphie table
					getIsoNodes().put(templateRel.getSource(), otherRel.getSource());

					// in case the token has dependencies to other data sources,
					// check their isomorphie
					// TODO: still missing is the reference to other data
					// sources like
					// timeline and medial data source

					// check whether both data sources have the same id
					Set<Difference> subDiffs = new HashSet<Difference>();
					compareIdentifiableElements(templateRel.getSource(), otherRel.getSource(), subDiffs);
					if (subDiffs.size() > 0) {
						if (!diff) {
							return false;
						}
						iso = false;
						addDifference(templateRel.getSource(), otherRel.getSource(), null, DIFF_TYPES.NODE_DIFFERING, subDiffs);
					}
					// check whether both data sources have the same labels
					subDiffs = new HashSet<Difference>();
					compareAnnotationContainers(templateRel.getSource(), otherRel.getSource(), subDiffs);
					if (subDiffs.size() > 0) {
						if (!diff) {
							return false;
						}
						iso = false;
						addDifference(templateRel.getSource(), otherRel.getSource(), null, DIFF_TYPES.NODE_DIFFERING, subDiffs);
					}
					remainingTemplates.remove(templateRel);
				}
			} else {
				// no partner for rel was found, since the textual data source
				// does not exist in template
				if (!diff) {
					return false;
				}
				iso = false;
				addDifference(null, otherRel.getTarget(), null, DIFF_TYPES.NODE_MISSING, null);
			}
		}

		// check the remaining textual relations
		if (remainingTemplates.size() > 0) {
			iterator = remainingTemplates.iterator();
			while (iterator.hasNext()) {
				STextualRelation templateRel = iterator.next();
				if (!diff) {
					return false;
				}
				iso = false;
				addDifference(templateRel.getSource(), null, null, DIFF_TYPES.NODE_MISSING, null);
			}
		}
		return (iso);
	}

	private class DifferenceHandler implements GraphTraverseHandler {
		List<SNode> remainingTemplateNodes = null;
		private boolean abort = false;
		/**
		 * set of already visited {@link SRelation}s while traversing, this is
		 * necessary to avoid cycles
		 **/
		private Set<SRelation> visitedRelations = new HashSet<>();

		/**
		 * Called by Pepper as callback, when otherGraph is traversed. Currently
		 * only returns <code>true</code> to traverse the entire graph.
		 */
		@Override
		public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation sRelation, SNode currNode, long order) {
			if (abort) {
				return (false);
			}
			boolean retVal = true;
			if (sRelation != null) {
				if (sRelation instanceof SPointingRelation) {
					// in case of relation is pointing relation, ignore it, it
					// will
					// be processed later

					retVal = false;
				} else if (currNode instanceof SToken) {
					// if current node is a token, ignore it, it was already
					// processed
					retVal = false;
				} else {
					if (visitedRelations.contains(sRelation)) {
						retVal = false;
					} else {
						visitedRelations.add(sRelation);
					}
				}
			}
			return (retVal);
		}

		/**
		 * Called by Pepper as callback, when otherGraph is traversed. Currently
		 * is empty.
		 */
		@Override
		public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation sRelation, SNode otherNode, long order) {
		}

		/**
		 * Called by Pepper as callback, when otherGraph is traversed.
		 */
		@Override
		public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation edge, SNode otherNode, long order) {
			if (currNode instanceof SSpan) {
				if (!findIsomorphicNode(currNode, SALT_TYPE.SSPANNING_RELATION, SALT_TYPE.SSPAN)) {
					abort = true;
				}
			} else if (currNode instanceof SStructure) {
				if (!findIsomorphicNode(currNode, SALT_TYPE.SDOMINANCE_RELATION, SALT_TYPE.SSTRUCTURE)) {
					abort = true;
				}
			} else if (currNode instanceof STextualDS) {
				// base text should be merged already
			} else {
				throw new SaltException("Computing of Differences is not implemented for this node type: " + currNode);
			}
		}

		/**
		 * To check if two nodes A, A' are equal, the following algorithm is
		 * used. We illustrate that algorithm along this sample:
		 * 
		 * <pre>
		 * G            | G' 
		 *              | 
		 *      A       |     A'    D' 
		 *    /   \     |     |  X  |  \ 
		 *   B     C    |     B'    C'  E'
		 * 
		 * </pre>
		 * <ol>
		 * <li>find all children of other node: otherChilds --> (B, C)</li>
		 * <li>for each node in otherChilds find isomorphic nodes:
		 * templateChilds--> (B', C')</li>
		 * <li>for each node in templateChild find shared parents: candidates
		 * --> (A', D')</li>
		 * <li>for each node in candidates compare its children to otherChilds
		 * --> A:(B,C) <=> A':(B', C'), A:(B,C) <=> D':(B', C', E')</li>
		 * </ol>
		 * 
		 * @param otherNode
		 * @param sTypeRelations
		 * @param nodeType
		 * @return
		 */
		private boolean findIsomorphicNode(SNode otherNode, SALT_TYPE sTypeRelations, SALT_TYPE nodeType) {
			SNode templateNode = null;
			// list of all equivalents to children of current node in other
			// graph
			List<SNode> children = otherGraph.getChildren(otherNode, sTypeRelations);

			List<SNode> templateChildren = new ArrayList<SNode>();
			for (SNode child : children) {
				SNode templateChild = getIsoNodes().inverse().get(child);
				if (templateChild != null) {
					templateChildren.add(templateChild);
				}
			}
			// list all parents in base document sharing the children
			List<SNode> sharedParents = new ArrayList<>();
			if (templateChildren.size() > 0) {
				sharedParents = templateGraph.getSharedParent(templateChildren, nodeType);
			}
			if (sharedParents.size() == 1) {
				// an equivalent to current node in base document was found
				templateNode = sharedParents.get(0);
			} else if (sharedParents.size() > 1) {
				// Several candidates have been found. Check which shared parent
				// node has the same children as other node
				List<SRelation> otherOutRels = otherNode.getOutRelations();
				Set<SNode> trueCandidates = new HashSet<>();

				for (SNode templateCandidate : sharedParents) {
					List<SRelation> templateOutRels = templateCandidate.getOutRelations();
					// check if node degree is the same
					if (otherOutRels.size() == templateOutRels.size()) {
						// check if each child of other node has a partner in
						// the children of template candidate

						// create a set of of otherChildren
						Set<SNode> otherChldren = new HashSet<>();
						Iterator<SRelation> it = otherOutRels.iterator();
						while (it.hasNext()) {
							otherChldren.add((SNode) it.next().getTarget());
						}

						// ckeck if all children of other node and candidate are
						// isomorph
						boolean trueCandidate = true;
						Iterator<SRelation> it_template = templateOutRels.iterator();
						while (it_template.hasNext()) {
							SNode templateChild = (SNode) it_template.next().getTarget();
							if (!otherChldren.contains(getIsoNodes().get(templateChild))) {
								trueCandidate = false;
								break;
							}
						}
						if (trueCandidate) {
							// templateNode= templateCandidate;
							trueCandidates.add(templateCandidate);
						}
					}
				}
				// there are multiple true candidates (candidates which have the
				// same position in graph (same children)), to decide which one
				// is to take, check which one has the minimum of differences in
				// annotations
				if (trueCandidates.size() > 1) {
					int minNumberOfDiffs = Integer.MAX_VALUE;
					for (SNode trueCandidate : trueCandidates) {
						Set<Difference> subDiff = new HashSet<>();
						compareAnnotationContainers(trueCandidate, otherNode, subDiff);
						if (subDiff.size() < minNumberOfDiffs) {
							minNumberOfDiffs = subDiff.size();
							// this is the node that will be checked again
							templateNode = trueCandidate;
						}
					}
				} else if (!trueCandidates.isEmpty()) {
					templateNode = trueCandidates.iterator().next();
				}
			}
			if (templateNode == null) {
				// no equivalent to currNode in base document was found

				if (!diffsRequested) {
					return false;
				}
				addDifference(null, otherNode, null, DIFF_TYPES.NODE_MISSING, null);
				return (false);
			} else {
				boolean isIsomorph = true;
				getIsoNodes().put(templateNode, otherNode);
				remainingTemplateNodes.remove(templateNode);
				// check whether both data sources have the same id
				Set<Difference> subDiffs = new HashSet<Difference>();
				compareIdentifiableElements(templateNode, otherNode, subDiffs);
				if (subDiffs.size() > 0) {
					if (!diffsRequested) {
						return false;
					}
					isIsomorph = false;
					addDifference(templateNode, otherNode, null, DIFF_TYPES.NODE_DIFFERING, subDiffs);
				}
				// check whether both data sources have the same labels
				subDiffs = new HashSet<Difference>();
				compareAnnotationContainers(templateNode, otherNode, subDiffs);
				if (subDiffs.size() > 0) {
					if (!diffsRequested) {
						return false;
					}
					isIsomorph = false;
					addDifference(templateNode, otherNode, null, DIFF_TYPES.NODE_DIFFERING, subDiffs);
				}
				return (isIsomorph);
			}
		}
	}

	/**
	 * Compares all {@link SPointingRelation} of other and template graph.<br/>
	 * When diff is true, the return value is not necessarily correct, since in
	 * that case the differences in {@link #getDifferences()} is computed. To
	 * check the isomorphie there must be no differences.
	 * 
	 * @param template
	 * @param other
	 * @param diff
	 * @return
	 */
	protected boolean compareRelations(SDocumentGraph template, List<? extends SRelation> templateRels, SDocumentGraph other, List<? extends SRelation> otherRels, Boolean diff) {
		boolean iso = true;

		Set<SRelation> otherRelSet = new HashSet<SRelation>();
		Iterator<? extends SRelation> iterator = otherRels.iterator();
		while (iterator.hasNext()) {
			otherRelSet.add(iterator.next());
		}

		// iterate over all pointing relations in template
		iterator = templateRels.iterator();
		while (iterator.hasNext()) {
			SRelation<SNode, SNode> tempRel = iterator.next();
			SNode tempSource = tempRel.getSource();
			SNode tempTarget = tempRel.getTarget();
			SNode otherSource = getIsoNodes().get(tempSource);
			SNode otherTarget = getIsoNodes().get(tempTarget);

			// iterate over all relations between other source and other target
			if (otherSource != null && otherTarget != null) {
				Iterator<SRelation<SNode, SNode>> inBetweenIterator = other.getInRelations(otherTarget.getId()).iterator();
				boolean isRelIso = true;
				while (inBetweenIterator.hasNext()) {
					// determines whether the current pair of template relation
					// and other relation are isomorph
					isRelIso = true;
					SRelation<SNode, SNode> otherRel = inBetweenIterator.next();

					// check whether both relations are isomorph
					if (otherRel.getSource().equals(otherSource) && tempRel.getClass().equals(otherRel.getClass())) {
						// a potential partner for tempRel was found

						// check whether both data sources have the same
						// identifier
						Set<Difference> subDiffs = new HashSet<Difference>();
						compareIdentifiableElements(tempRel, otherRel, subDiffs);
						if (subDiffs.size() > 0) {
							if (!diff) {
								return false;
							}
							isRelIso = false;
							addDifference(tempRel, otherRel, null, DIFF_TYPES.RELATION_DIFFERING, subDiffs);
						}
						// check whether both data sources have the same labels
						subDiffs = new HashSet<Difference>();
						compareAnnotationContainers(tempRel, otherRel, subDiffs);
						if (subDiffs.size() > 0) {
							if (!diff) {
								return false;
							}
							isRelIso = false;
							addDifference(tempRel, otherRel, null, DIFF_TYPES.RELATION_DIFFERING, subDiffs);
						}
					} else {
						// either template source and other source are not
						// isomorph or classes are not equal
						isRelIso = false;
					}
					// both relations are isomorph
					if (isRelIso) {
						otherRelSet.remove(otherRel);
						break;
					}
				}
				// the current template relation has no partner
				if (!isRelIso) {
					addDifference(tempRel, null, null, DIFF_TYPES.RELATION_MISSING, null);
					iso = false;
				}
			}
		}

		// all remaining rels from other have no matching partner
		if (otherRelSet.size() > 0) {
			iterator = otherRelSet.iterator();
			while (iterator.hasNext()) {
				addDifference(null, iterator.next(), null, DIFF_TYPES.RELATION_MISSING, null);
			}
			iso = false;
		}
		return (iso);
	}

	/**
	 * Compares all layers in template graph with all layers in other graph and
	 * searches for isomorphic partners. To layers are isomorph, when have the
	 * same name and contain the same number of nodes and relations and have the
	 * same labels. <br/>
	 * When diff is true, the return value is not necessarily correct, since in
	 * that case the differences in {@link #getDifferences()} is computed. To
	 * check the isomorphie there must be no differences.
	 * 
	 * @param template
	 * @param other
	 * @param diff
	 * @return
	 */
	protected boolean compareLayers(SDocumentGraph template, SDocumentGraph other, Boolean diff) {
		Set<SLayer> remainingLayers = new HashSet<SLayer>();

		// create a map corresponding the layer's name and the layer
		Multimap<String, SLayer> nameToLayer = HashMultimap.create();
		Iterator<SLayer> iterator = template.getLayers().iterator();
		while (iterator.hasNext()) {
			SLayer templateLayer = iterator.next();
			nameToLayer.put(templateLayer.getName(), templateLayer);
			remainingLayers.add(templateLayer);
		}

		// for each layer in other search for a layer in template
		iterator = other.getLayers().iterator();
		while (iterator.hasNext()) {
			SLayer otherLayer = iterator.next();
			Collection<SLayer> templateLayers = nameToLayer.get(otherLayer.getName());
			if (templateLayers == null || templateLayers.size() == 0) {
				// no potential partner for layer was found, since the
				// layers name was not found
				if (!diff) {
					return false;
				}
				addDifference(null, otherLayer, null, DIFF_TYPES.LAYER_MISSING, null);
			} else {
				// when there are more than one potential partners for layer was
				// found
				int i = 0;
				for (SLayer templateLayer : templateLayers) {
					i++;
					boolean morePotentialPartners = i < templateLayers.size();
					// stores whether current potential partner mathes
					boolean matches = true;
					if (templateLayer.getNodes().size() != otherLayer.getNodes().size()) {
						// template and other layer does not match
						matches = false;
						if (!morePotentialPartners) {
							addDifference(templateLayer, otherLayer, null, DIFF_TYPES.LAYER_DIFFERING, null);
							if (!diff) {
								return false;
							}
						}
					}
					if (templateLayer.getRelations().size() != otherLayer.getRelations().size()) {
						// template and other layer does not match
						matches = false;
						if (!morePotentialPartners) {
							addDifference(templateLayer, otherLayer, null, DIFF_TYPES.LAYER_DIFFERING, null);
							if (!diff) {
								return false;
							}
						}
					}
					// check whether both layers have the same id
					Set<Difference> subDiffs = new HashSet<Difference>();
					compareIdentifiableElements(templateLayer, otherLayer, subDiffs);
					if (subDiffs.size() > 0) {
						// template and other layer does not match
						matches = false;
						if (!morePotentialPartners) {
							if (!diff) {
								return false;
							}
							addDifference(templateLayer, otherLayer, null, DIFF_TYPES.LAYER_DIFFERING, subDiffs);
						}
					}
					// check whether both data sources have the same labels
					subDiffs = new HashSet<Difference>();
					compareAnnotationContainers(templateLayer, otherLayer, subDiffs);
					if (subDiffs.size() > 0) {
						matches = false;

						if (!morePotentialPartners) {
							// template and other layer does not match
							if (!diff) {
								return false;
							}
							addDifference(templateLayer, otherLayer, null, DIFF_TYPES.LAYER_DIFFERING, subDiffs);
						}
					}
					if (matches) {
						remainingLayers.remove(templateLayer);
						break;
					}
				}
			}
		}
		// check the remaining layers
		if (remainingLayers.size() > 0) {
			for (SLayer layer : remainingLayers) {
				if (!diff) {
					return false;
				}
				addDifference(layer, null, null, DIFF_TYPES.LAYER_MISSING, null);
			}
		}
		return (true);
	}

}
