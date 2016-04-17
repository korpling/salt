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
import java.util.LinkedHashSet;
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
import org.corpus_tools.salt.core.SAbstractAnnotation;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SAnnotationContainer;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SMetaAnnotation;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SProcessingAnnotation;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.graph.IdentifiableElement;
import org.corpus_tools.salt.util.DIFF_TYPES;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;
import org.corpus_tools.salt.util.SaltUtil;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * This class compares two {@link SDocumentGraph} objects for isomorphie. It
 * uses characteristics of document graphs to use a more specific algorithm for
 * checking whether a graph is isomorphic. At first tokens are compared. Both
 * graphs are compared starting with offset "0". Two tokens are the same, when
 * their textual offset and the overlapped text is the same. As with all
 * following SNodes, SAnnotations and SFeatures are checked. The next step is to
 * look for SNodes that are the source of a incoming relations of a SToken. Of
 * these only those are picked, that have SNodes on their SOutgoingrelations,
 * that already have been checked (at this point: only STokens). These SNodes
 * are then compared with each other. Whenever a relation is used in the way
 * described above, the SRelation is checked for SFeatures and SRelations.
 * 
 * To adapt the isomorphie check and the computation of differences you can pass
 * an option map via {@link #Diff(SDocumentGraph, SDocumentGraph, Map)}.
 * Possible options are:
 * <ul>
 * <li>{@link #OPTION_CHECK_ANNOTATION} - When true, even all annotations of
 * nodes and relations are used for isomorphie check and difference computation.
 * </li>
 * <li>{@link #OPTION_CHECK_ANNOTATION_DIFF} - ???</li>
 * <li>{@link #OPTION_CHECK_ID} - When true identifiers needs to be the same in
 * isomorphie check and difference computation.</li>
 * </ul>
 * 
 * @author florian
 * @author André Röhrig
 *
 */
public class Diff {
	// private static final Logger logger = LoggerFactory.getLogger("salt");

	private SDocumentGraph templateGraph = null;
	private SDocumentGraph otherGraph = null;

	private Map<String, Boolean> options = null;

	/**
	 * When true, differences in {@link SFeature} have no influence on
	 * isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_FEATURES = "ignoreFeatures";
	/**
	 * When true, differences in {@link SAnnotation} have no influence on
	 * isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_ANNOTATIONS = "ignoreAnnotations";
	/**
	 * When true, differences in {@link SMetaAnnotation} have no influence on
	 * isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_META_ANNOTATIONS = "ignoreMetaAnnotstaions";
	/**
	 * When true, differences in {@link SProcessingAnnotation} have no influence
	 * on isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_PROCESSING_ANNOTATIONS = "ignoreProcessingAnnotations";
	/**
	 * When true, differences in id have no influence on isomorphie and will not
	 * produce any differences.
	 */
	public static final String OPTION_IGNORE_ID = "ignoreId";
	/**
	 * When true, differences in name have no influence on isomorphie and will
	 * not produce any differences.
	 */
	public static final String OPTION_IGNORE_NAME = "ignoreName";
	/**
	 * When true, layers will not be checked when computing isomorphie and
	 * differences.
	 */
	public static final String OPTION_IGNORE_LAYER = "ignoreLayer";

	/**
	 * Initializes Diff object with the two graphs <code>template</code> and
	 * <code>other</code>.
	 * 
	 * @param template
	 * @param other
	 */
	public Diff(SDocumentGraph template, SDocumentGraph other) {
		this(template, other, null);
	}

	public Diff(SDocumentGraph template, SDocumentGraph other, Map<String, Boolean> optionMap) {
		this.templateGraph = template;
		this.otherGraph = other;

		if (optionMap == null) {
			optionMap = new DiffOptions();
		}
		options = optionMap;
	}

	private Set<Difference> differences = null;

	/**
	 * Returns a list containing all computed differences.
	 * 
	 * @return returns differences Set
	 **/
	private Set<Difference> getDifferences() {
		if (differences == null) {
			differences = new LinkedHashSet<>();
		}
		return differences;
	}

	/**
	 * Adds a difference to the differences set
	 * 
	 * @param templateObject
	 *            first Salt object
	 * @param otherObject
	 *            second Salt object
	 * @param container
	 *            Object containing the given object, e.g. used for layers
	 * @param diffType
	 *            type of the difference
	 * @return returns whether sizes are the same
	 **/
	private void addDifference(Object templateObject, Object otherObject, Object container, DIFF_TYPES diffType, Set<Difference> subDiffs) {
		Difference tempDiff = new Difference(templateObject, otherObject, container, diffType);
		if (subDiffs != null) {
			tempDiff.addSubDiffs(subDiffs);
		}
		getDifferences().add(tempDiff);
	}

	/**
	 * Compares the set graphs and returns if they are isomorphic or not. In
	 * case of the graphs are not isomorphic, this method does not record all
	 * differences. TO speed up the computation. it just detects the first
	 * difference and returns false. To get a full list of all differences, use
	 * method {@link #findDiffs()}.
	 * 
	 * @return true, if graphs are isomorphic, false otherwise.
	 */
	public boolean isIsomorph() {
		diffsRequested = false;
		return (findDiffs(false));
	}

	/**
	 * Compares the set graphs and returns if they are isomorphic or not. If
	 * graphs are not isomporphic, this method finds and records all differences
	 * and lists them. This means the entire graphs have to be compared and
	 * could slow down the computation. If you are only interested in the result
	 * and not in the particular differences, use method {@link #isIsomorph()}.
	 * 
	 * @return true, if graphs are isomorphic, false otherwise.
	 */
	public Set<Difference> findDiffs() {
		diffsRequested = true;
		findDiffs(true);
		return (getDifferences());
	}

	/**
	 * if false, only isomorphie is computed, which makes the process faster but
	 * does not collect all differences
	 **/
	private boolean diffsRequested = false;

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
	private boolean findDiffs(boolean diffsRequested) {
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
		List<SNode> roots = otherGraph.getRootsByRelation(SALT_TYPE.SSPANNING_RELATION, SALT_TYPE.SDOMINANCE_RELATION);
		if ((roots == null) || (roots.size() == 0)) {
			// logger.warn("Cannot start computing of differences, since no
			// tokens exist for document '{}'.",
			// templateGraph.getId());
		} else {
			List<SNode> remainingTemplateNodes = new ArrayList<>(templateGraph.getSpans().size() + templateGraph.getStructures().size());
			remainingTemplateNodes.addAll(templateGraph.getSpans());
			remainingTemplateNodes.addAll(templateGraph.getStructures());
			DifferenceHandler handler = new DifferenceHandler();
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
		if (!options.get(OPTION_IGNORE_LAYER)) {
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
		if (!options.get(OPTION_IGNORE_LAYER)) {
			if (template.getLayers().size() != other.getLayers().size()) {
				return (false);
			}
		}
		return true;
	}

	/** isomorphic {@link SNode}s key= template, value= other **/
	private BiMap<SNode, SNode> isoNodes = null;

	/**
	 * Return BiMap with isomorphic {@link SNode}s key= template, value= other
	 * 
	 * @return BiMap with isomorphic {@link SNode}s
	 **/
	public BiMap<SNode, SNode> getIsoNodes() {
		if (isoNodes == null) {
			isoNodes = HashBiMap.create();
		}
		return isoNodes;
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
		boolean retVal1 = compareDataSources(template.getTextualDSs(), other.getTextualDSs(), diff);
		// speed up
		if (!diff && !retVal1) {
			return (retVal1);
		}
		// compare medial data sources
		boolean retVal2 = compareDataSources(template.getMedialDSs(), other.getMedialDSs(), diff);
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
	private boolean compareDataSources(List<? extends SSequentialDS<?,?>> template, 
			List<? extends SSequentialDS<?,?>> other, boolean diff) {
		boolean iso = true;
		Map<Object, SSequentialDS<?,?>> dataToDS = new Hashtable<>();
		// data sources from template which have no partner in other
		Set<SSequentialDS<?,?>> remainingTemplates = new HashSet<>();

		// put all template data source to map
		Iterator<? extends SSequentialDS<?,?>> iterator = template.iterator();
		while (iterator.hasNext()) {
			SSequentialDS<?,?> templateDS = iterator.next();
			dataToDS.put(templateDS.getData(), templateDS);
			remainingTemplates.add(templateDS);
		}

		// check all other data source with map
		iterator = other.iterator();
		while (iterator.hasNext()) {
			SSequentialDS<?,?> otherDS = iterator.next();
			SSequentialDS<?,?> templateDS = dataToDS.get(otherDS.getData());
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
				SSequentialDS<?,?> templateDS = iterator.next();
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

	/**
	 * Checks whether two {@link IdentifiableElement} objects are isomorph. If
	 * option {@link #OPTION_IGNORE_ID} is false, this method returns true, if
	 * the id values of both are equal, false otherwise.If subdiffs is not null,
	 * the differences will be added to that list, if that list is empty the
	 * method returns false when the first difference was found.
	 * 
	 * @param templateNode
	 * @param otherNode
	 * @param subDiffs
	 * @return true if elements have the same id, false otherwise
	 */
	public boolean compareIdentifiableElements(IdentifiableElement template, IdentifiableElement other, Set<Difference> subDiffs) {
		boolean retVal = true;
		if (!options.get(OPTION_IGNORE_ID)) {
			if (!template.getId().equals(other.getId())) {
				retVal = false;
				if (subDiffs != null) {
					subDiffs.add(new Difference(template, other, null, DIFF_TYPES.ID_DIFFERING));
				}
			}
		}
		return (retVal);
	}

	/**
	 * Checks whether two {@link SAnnotationContainer} objects are isomorph and
	 * returns true if this is the case, false otherwise. If subdiffs is not
	 * null, the differences will be added to that list, if that list is empty
	 * the method returns false when the first difference was found. <br/>
	 * The behavior of this method depends on options:
	 * {@link #OPTION_IGNORE_META_ANNOTATIONS},
	 * {@link #OPTION_IGNORE_PROCESSING_ANNOTATIONS},
	 * {@link #OPTION_IGNORE_ANNOTATIONS} and {@link #OPTION_IGNORE_FEATURES}
	 * 
	 * @param templateNode
	 * @param otherNode
	 * @param subDiffs
	 *            if differences shall be computed, this list must not have to
	 *            be empty
	 * @return
	 */
	public boolean compareAnnotationContainers(SAnnotationContainer template, SAnnotationContainer other, Set<Difference> subDiffs) {
		boolean retVal1 = true;
		boolean retVal2 = true;
		boolean retVal3 = true;
		boolean retVal4 = true;

		if (!(boolean) options.get(OPTION_IGNORE_ANNOTATIONS)) {
			Iterator<? extends SAbstractAnnotation> otherIterator = other.iterator_SAnnotation();
			Iterator<? extends SAbstractAnnotation> templateIterator = template.iterator_SAnnotation();
			retVal1 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}
		if (!(boolean) options.get(OPTION_IGNORE_META_ANNOTATIONS)) {
			Iterator<? extends SAbstractAnnotation> otherIterator = other.iterator_SMetaAnnotation();
			Iterator<? extends SAbstractAnnotation> templateIterator = template.iterator_SMetaAnnotation();
			retVal2 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}
		if (!(boolean) options.get(OPTION_IGNORE_PROCESSING_ANNOTATIONS)) {
			Iterator<? extends SAbstractAnnotation> otherIterator = other.iterator_SProcessingAnnotation();
			Iterator<? extends SAbstractAnnotation> templateIterator = template.iterator_SProcessingAnnotation();
			retVal3 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}
		if (!(boolean) options.get(OPTION_IGNORE_FEATURES)) {
			Iterator<? extends SAbstractAnnotation> otherIterator = other.iterator_SFeature();
			Iterator<? extends SAbstractAnnotation> templateIterator = template.iterator_SFeature();
			retVal4 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}

		return (retVal1 && retVal2 && retVal3 && retVal4);
	}

	/**
	 * Checks all {@link SAbstractAnnotation}s in both iterators, whether each
	 * one has a potential matching partner in the other iterator.
	 * 
	 * @param template
	 * @param templateIterator
	 * @param other
	 * @param otherIterator
	 * @param subDiffs
	 * @return
	 */
	private boolean compareAnnotationContainers(SAnnotationContainer template, 
			Iterator<? extends SAbstractAnnotation> templateIterator, 
			SAnnotationContainer other, 
			Iterator<? extends SAbstractAnnotation> otherIterator, Set<Difference> subDiffs) {
		boolean retVal = true;

		// create remaining list, which contains all annos from other
		Set<SAbstractAnnotation> remainingLabels = new HashSet<>();
		while (otherIterator.hasNext()) {
			SAbstractAnnotation anno = otherIterator.next();
			if (anno instanceof SFeature) {
				if (options.get(OPTION_IGNORE_NAME)) {
					if (SaltUtil.FEAT_NAME_QNAME.equals(anno.getQName())) {
						continue;
					}
				}
			}
			remainingLabels.add(anno);
		}

		// for each annotation from template, check whether other also contains
		// a isomorph annotation
		while (templateIterator.hasNext()) {
			SAbstractAnnotation templateAnno = templateIterator.next();

			if (templateAnno instanceof SFeature) {
				if (options.get(OPTION_IGNORE_NAME)) {
					if (SaltUtil.FEAT_NAME_QNAME.equals(templateAnno.getQName())) {
						continue;
					}
				}
			}
			SAbstractAnnotation otherAnno = (SAbstractAnnotation) other.getLabel(templateAnno.getQName());
			if (otherAnno == null) {
				if (subDiffs != null) {
					subDiffs.add(new Difference(templateAnno, null, template, DIFF_TYPES.LABEL_MISSING));
					retVal = false;
				} else {
					return (false);
				}
			} else if (!otherAnno.getValue().equals(templateAnno.getValue())) {
				if (subDiffs != null) {
					subDiffs.add(new Difference(templateAnno, otherAnno, null, DIFF_TYPES.LABEL_VALUE_DIFFERING));
					retVal = false;
				} else {
					return (false);
				}
			} else {
				remainingLabels.remove(otherAnno);
			}
		}

		// create a difference for each annotation in list of remaining
		// annotations
		if (remainingLabels.size() > 0) {
			if (subDiffs != null) {
				retVal = false;
				for (SAbstractAnnotation otherAnno : remainingLabels) {
					subDiffs.add(new Difference(null, otherAnno, other, DIFF_TYPES.LABEL_MISSING));
				}
			} else {
				return (false);
			}

		}
		return (retVal);
	}

	private class DifferenceHandler implements GraphTraverseHandler {
		List<SNode> remainingTemplateNodes = null;
		private boolean abort = false;
		/**
		 * set of already visited {@link SRelation}s while traversing, this is
		 * necessary to avoid cycles
		 **/
		private Set<SRelation<? extends SNode,? extends SNode>> 
			visitedRelations = new HashSet<>();

		/**
		 * Called by Pepper as callback, when otherGraph is traversed. Currently
		 * only returns <code>true</code> to traverse the entire graph.
		 */
		@Override
		public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation<? extends SNode, ? extends SNode> sRelation, SNode currNode, long order) {
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
		public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation<? extends SNode, ? extends SNode> sRelation, SNode otherNode, long order) {
		}

		/**
		 * Called by Pepper as callback, when otherGraph is traversed.
		 */
		@Override
		public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation<? extends SNode, ? extends SNode> edge, SNode otherNode, long order) {
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
		 * --> A:(B,C) <=> A':(B', C'), A:(B,C) <=> (C', E')</li>
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
				List<SRelation<?,?>> otherOutRels = otherNode.getOutRelations();
				Set<SNode> trueCandidates = new HashSet<>();

				for (SNode templateCandidate : sharedParents) {
					List<SRelation<?,?>> templateOutRels = templateCandidate.getOutRelations();
					// check if node degree is the same
					if (otherOutRels.size() == templateOutRels.size()) {
						// check if each child of other node has a partner in
						// the children of template candidate

						// create a set of of otherChildren
						Set<SNode> otherChldren = new HashSet<>();
						Iterator<SRelation<?,?>> it = otherOutRels.iterator();
						while (it.hasNext()) {
							otherChldren.add((SNode) it.next().getTarget());
						}

						// ckeck if all children of other node and candidate are
						// isomorph
						boolean trueCandidate = true;
						Iterator<SRelation<?,?>> it_template = templateOutRels.iterator();
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
	public boolean compareRelations(SDocumentGraph template, 
			List<? extends SRelation<? extends SNode,? extends SNode>> templateRels, 
			SDocumentGraph other, 
			List<? extends SRelation<? extends SNode,? extends SNode>> otherRels, 
			Boolean diff) {
		boolean iso = true;

		Set<SRelation<? extends SNode,? extends SNode>> otherRelSet = new HashSet<>();
		Iterator<? extends SRelation<? extends SNode,? extends SNode>> iterator = 
				otherRels.iterator();
		while (iterator.hasNext()) {
			otherRelSet.add(iterator.next());
		}

		// iterate over all pointing relations in template
		iterator = templateRels.iterator();
		while (iterator.hasNext()) {
			SRelation<? extends SNode,? extends SNode> tempRel = iterator.next();
			SNode tempSource = tempRel.getSource();
			SNode tempTarget = tempRel.getTarget();
			SNode otherSource = getIsoNodes().get(tempSource);
			SNode otherTarget = getIsoNodes().get(tempTarget);

			// iterate over all relations between other source and other target
			if (otherSource != null && otherTarget != null) {
				Iterator<SRelation<? extends SNode, ? extends SNode>> inBetweenIterator = other.getInRelations(otherTarget.getId()).iterator();
				boolean isRelIso = true;
				while (inBetweenIterator.hasNext()) {
					// determines whether the current pair of template relation
					// and other relation are isomorph
					isRelIso = true;
					SRelation<? extends SNode, ? extends SNode> otherRel = inBetweenIterator.next();

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
	public boolean compareLayers(SDocumentGraph template, SDocumentGraph other, Boolean diff) {
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
