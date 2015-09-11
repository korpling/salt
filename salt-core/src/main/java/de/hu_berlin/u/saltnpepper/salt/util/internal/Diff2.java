package de.hu_berlin.u.saltnpepper.salt.util.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.core.GraphTraverseHandler;
import de.hu_berlin.u.saltnpepper.salt.core.SAbstractAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotationContainer;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;
import de.hu_berlin.u.saltnpepper.salt.util.DIFF_TYPES;
import de.hu_berlin.u.saltnpepper.salt.util.Difference;
import de.hu_berlin.u.saltnpepper.salt.util.SALT_TYPE;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

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
 * are then compared with eachother. Whenever a relation is used in the way
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
 * @author André Röhrig
 *
 */
public class Diff2 {
	// private static final Logger logger = LoggerFactory.getLogger("salt");

	private SDocumentGraph templateGraph = null;
	private SDocumentGraph otherGraph = null;

	private Map<String, Boolean> options = null;

	/**
	 * When true, even all annotations of nodes and relations are used for
	 * isomorphie check and difference computation.
	 **/
	public static final String OPTION_CHECK_ANNOTATION = "annoIso";
	/** ??? **/
	public static final String OPTION_CHECK_ANNOTATION_DIFF = "annoDiff";
	/**
	 * When true identifiers needs to be the same in isomorphie check and
	 * difference computation.
	 **/
	public static final String OPTION_CHECK_ID = "idCheck";
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
	 * Initializes Diff object with the two graphs <code>template</code> and
	 * <code>other</code>.
	 * 
	 * @param template
	 * @param other
	 */
	public Diff2(SDocumentGraph template, SDocumentGraph other) {
		this(template, other, null);
	}

	public Diff2(SDocumentGraph template, SDocumentGraph other, Map<String, Boolean> optionMap) {
		this.templateGraph = template;
		this.otherGraph = other;

		options = optionMap;
		if (options == null) {
			options = new Hashtable<>();
		}
		if (!options.containsKey(OPTION_IGNORE_ANNOTATIONS)) {
			options.put(OPTION_IGNORE_ANNOTATIONS, false);
		}
		if (!options.containsKey(OPTION_IGNORE_META_ANNOTATIONS)) {
			options.put(OPTION_IGNORE_META_ANNOTATIONS, false);
		}
		if (!options.containsKey(OPTION_IGNORE_PROCESSING_ANNOTATIONS)) {
			options.put(OPTION_IGNORE_PROCESSING_ANNOTATIONS, true);
		}
		if (!options.containsKey(OPTION_IGNORE_FEATURES)) {
			options.put(OPTION_IGNORE_FEATURES, false);
		}
		if (!options.containsKey(OPTION_IGNORE_ID)) {
			options.put(OPTION_IGNORE_ID, true);
		}
		if (!options.containsKey(OPTION_IGNORE_NAME)) {
			options.put(OPTION_IGNORE_NAME, true);
		}
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
		if (!compareSizes(templateGraph, otherGraph)) {
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
		System.out.println("roots: " + roots);
		if ((roots == null) || (roots.size() == 0)) {
			// logger.warn("Cannot start computing of differences, since no tokens exist for document '{}'.",
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
			System.out.println("remainingTemplateNodes: " + remainingTemplateNodes);
			if (remainingTemplateNodes.size() > 0) {
				for (SNode remainingNode : remainingTemplateNodes) {
					if (!diffsRequested) {
						return false;
					}
					addDifference(remainingNode, null, null, DIFF_TYPES.NODE_MISSING, null);
				}
			}
		}

		//
		// if (!compareNodes(templateGraph, otherGraph, diffsRequested)) {
		// if (!diffsRequested) {
		// return false;
		// }
		// }
		if (!checkPointingRelations(templateGraph, otherGraph, diffsRequested)) {
			if (!diffsRequested) {
				return false;
			}
		}
		if (!checkOrderRelations(templateGraph, otherGraph, diffsRequested)) {
			if (!diffsRequested) {
				return false;
			}
		}
		if (!checkLayers(templateGraph, otherGraph, diffsRequested)) {
			if (!diffsRequested) {
				return false;
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
	private boolean compareSizes(SDocumentGraph template, SDocumentGraph other) {
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

	private Set<Object> checkedElements = new HashSet<>();

	private void addtoCheckedElements(Object element) {
		checkedElements.add(element);
	}

	private boolean checkChecked(SNode node) {
		List<SNode> nodes = new LinkedList<SNode>();
		List<SRelation> rels = node.getOutRelations();
		for (SRelation<? extends SNode, ? extends SNode> i : rels) {
			nodes.add(i.getSource());
		}
		if (checkedElements.containsAll(nodes)) {
			return true;
		} else {
			return false;
		}
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
			SSequentialDS templateDS = (SSequentialDS) dataToDS.get(otherDS.getData());
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
	 * @return
	 */
	public boolean compareIdentifiableElements(IdentifiableElement template, IdentifiableElement other, Set<Difference> subDiffs) {
		boolean retVal = true;
		if (!(boolean) options.get(OPTION_IGNORE_ID)) {
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
			Iterator<SAbstractAnnotation> otherIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) other.iterator_SAnnotation();
			Iterator<SAbstractAnnotation> templateIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) template.iterator_SAnnotation();
			retVal1 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}
		if (!(boolean) options.get(OPTION_IGNORE_META_ANNOTATIONS)) {
			Iterator<SAbstractAnnotation> otherIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) other.iterator_SMetaAnnotation();
			Iterator<SAbstractAnnotation> templateIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) template.iterator_SMetaAnnotation();
			retVal2 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}
		if (!(boolean) options.get(OPTION_IGNORE_PROCESSING_ANNOTATIONS)) {
			Iterator<SAbstractAnnotation> otherIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) other.iterator_SProcessingAnnotation();
			Iterator<SAbstractAnnotation> templateIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) template.iterator_SProcessingAnnotation();
			retVal3 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}
		if (!(boolean) options.get(OPTION_IGNORE_FEATURES)) {
			Iterator<SAbstractAnnotation> otherIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) other.iterator_SFeature();
			Iterator<SAbstractAnnotation> templateIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) template.iterator_SFeature();
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
	private boolean compareAnnotationContainers(SAnnotationContainer template, Iterator<SAbstractAnnotation> templateIterator, SAnnotationContainer other, Iterator<SAbstractAnnotation> otherIterator, Set<Difference> subDiffs) {
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
			System.out.println("--> " + currNode);
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
			
			List<SNode> templateChildren= new ArrayList<SNode>();
			for (SNode child: children){
				SNode templateChild= getIsoNodes().inverse().get(child);
				if (templateChild!= null){
					templateChildren.add(templateChild);
				}
			}
			// list all parents in base document sharing the children
			List<SNode> sharedParents = new ArrayList<>();
			if (templateChildren.size() > 0) {
				sharedParents = otherGraph.getSharedParent(templateChildren, nodeType);
			}
			if (sharedParents.size() > 0) {
				// an equivalent to current node in base document was found

				templateNode = sharedParents.get(0);
			}

			System.out.println("--> template node: " + templateNode);

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
				System.out.println("remainingTemplateNodes before: " + remainingTemplateNodes);
				System.out.println("remove: " + templateNode);
				remainingTemplateNodes.remove(templateNode);
				System.out.println("remainingTemplateNodes after: " + remainingTemplateNodes);
				// check whether both data sources have the same id
				Set<Difference> subDiffs = new HashSet<Difference>();
				compareIdentifiableElements(templateNode, otherNode, subDiffs);
				if (subDiffs.size() > 0) {
					if (!diffsRequested) {
						return false;
					}
					isIsomorph = false;
					System.out.println("add diff 1");
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
					System.out.println("add diff 2");
					addDifference(templateNode, otherNode, null, DIFF_TYPES.NODE_DIFFERING, subDiffs);
				}
				return (isIsomorph);
			}
		}
	}

	// /**
	// * method to check {@link SNode}s of docGraphs for isomorphie
	// *
	// * @return isomorphie still possible after this check
	// * @param template
	// * first sDocGraph
	// * @param other
	// * second sDocGraph
	// * @param diff
	// * if true, diffs are checked as well
	// **/
	// private boolean compareNodes(SDocumentGraph template, SDocumentGraph
	// other, boolean diff) {
	// boolean iso = true;
	//
	// // initializing
	// List<SToken> templateDSlist = template.getTokens();
	// List<SToken> otherDSlist = other.getTokens();
	//
	// Set<SNode> template0 = new HashSet<>();
	// Set<SNode> other0 = new HashSet<>();
	//
	// // walk through all template tokens and add all nodes which refer to a
	// // token to list
	// for (int i = 0; i < templateDSlist.size(); i = i + 1) {
	// List<SRelation> relList = templateDSlist.get(i).getInRelations();
	// for (int j = 0; j < relList.size(); j = j + 1) {
	// if (!(template0.contains(relList.get(j).getSource()) || relList.get(j)
	// instanceof SPointingRelation || relList.get(j) instanceof
	// SOrderRelation))
	// template0.add((SNode) relList.get(j).getSource());
	// }
	// }
	// // walk through all other tokens and add all nodes which refer to a
	// // token to list
	// for (int i = 0; i < otherDSlist.size(); i = i + 1) {
	// List<SRelation> relList = otherDSlist.get(i).getInRelations();
	// for (int j = 0; j < relList.size(); j = j + 1) {
	// if (!(other0.contains(relList.get(j).getSource()) || relList.get(j)
	// instanceof SPointingRelation || relList.get(j) instanceof
	// SOrderRelation))
	// other0.add((SNode) relList.get(j).getSource());
	// }
	// }
	//
	// for (SNode s : template0) {
	// Set<Difference> subDiffs = null;
	// boolean tempIso = false;
	// for (SNode t : other0) {
	// if (compareTwoNodes(s, t, subDiffs)) {
	// tempIso = true;
	// }
	// }
	// if (tempIso == false) {
	// addDifference(s, null, null, DIFF_TYPES.NODE_MISSING, subDiffs);
	// iso = false;
	// }
	// }
	//
	// for (SNode t : other0) {
	// Set<Difference> subDiffs = null;
	// boolean tempIso = false;
	// for (SNode s : template0) {
	// if (compareTwoNodes(t, s, subDiffs)) {
	// tempIso = true;
	// }
	// }
	// if (tempIso == false) {
	// addDifference(null, t, null, DIFF_TYPES.NODE_MISSING, subDiffs);
	// iso = false;
	// }
	// }
	//
	// itNodeClass it = new itNodeClass();
	// it.iso = iso;
	// it.templateSet = template0;
	// it.otherSet = other0;
	//
	// while (it.newNodes) {
	// iterateNodeCheck(it);
	// }
	//
	// return it.iso;
	// }
	//
	// private itNodeClass iterateNodeCheck(itNodeClass it) {
	// Set<SNode> template0 = it.templateSet;
	// Set<SNode> other0 = it.otherSet;
	//
	// Iterator<SNode> itTemplate = template0.iterator();
	// Iterator<SNode> otTemplate = other0.iterator();
	//
	// Set<SNode> template1 = new HashSet<>();
	// Set<SNode> other1 = new HashSet<>();
	//
	// while (itTemplate.hasNext()) {
	// List<SRelation> relList = itTemplate.next().getInRelations();
	// for (int j = 0; j < relList.size(); j = j + 1) {
	// if (!(template0.contains(relList.get(j).getSource()) || relList.get(j)
	// instanceof SPointingRelation || relList.get(j) instanceof
	// SOrderRelation))
	// template1.add((SNode) relList.get(j).getSource());
	// }
	// }
	//
	// while (otTemplate.hasNext()) {
	// List<SRelation> relList = otTemplate.next().getInRelations();
	// for (int j = 0; j < relList.size(); j = j + 1) {
	// if (!(other0.contains(relList.get(j).getSource()) || relList.get(j)
	// instanceof SPointingRelation || relList.get(j) instanceof
	// SOrderRelation))
	// other1.add((SNode) relList.get(j).getSource());
	// }
	// }
	//
	// for (SNode s : template1) {
	// Set<Difference> subDiffs = null;
	// if (checkChecked(s)) {
	// checkedElements.add(s);
	//
	// boolean tempIso = false;
	// for (SNode t : other0) {
	// if (compareTwoNodes(s, t, subDiffs)) {
	// tempIso = true;
	// }
	// }
	// if (tempIso == false) {
	// it.iso = false;
	// addDifference(s, null, null, DIFF_TYPES.NODE_MISSING, subDiffs);
	// }
	// }
	// }
	//
	// for (SNode t : other1) {
	// Set<Difference> subDiffs = null;
	// if (checkChecked(t)) {
	// checkedElements.add(t);
	// boolean tempIso = false;
	// for (SNode s : template0) {
	// if (compareTwoNodes(t, s, subDiffs)) {
	// tempIso = true;
	// }
	// }
	// if (tempIso == false) {
	// it.iso = false;
	// addDifference(null, t, null, DIFF_TYPES.NODE_MISSING, subDiffs);
	// }
	// }
	// }
	//
	// it.templateSet = template1;
	// it.otherSet = other1;
	//
	// if (it.templateSet.size() == 0 && it.otherSet.size() == 0) {
	// it.newNodes = false;
	// }
	//
	// return it;
	// }
	//
	// public class itNodeClass {
	// Set<SNode> templateSet = null;
	// Set<SNode> otherSet = null;
	// boolean iso = true;
	// boolean newNodes = true;
	// }
	//
	// /**
	// * method to check two {@link SNode}s for isomorphie
	// *
	// * @return isomorphie still possible after this check
	// * @param templateGraph
	// * first SNode
	// * @param otherGraph
	// * second SNode
	// **/
	// public boolean compareTwoNodes(SNode templateNode, SNode otherNode,
	// Set<Difference> subDiffs) {
	// List<SRelation> tempList = templateNode.getOutRelations();
	// Set<SNode> templateSet = new HashSet<>();
	//
	// boolean iso = true;
	//
	// for (SRelation r : tempList) {
	// templateSet.add((SNode) r.getTarget());
	// }
	//
	// List<SRelation> otherList = otherNode.getOutRelations();
	// Set<SNode> otherSet = new HashSet<>();
	//
	// for (SRelation r : otherList) {
	// otherSet.add((SNode) r.getTarget());
	// }
	//
	// Iterator<SNode> itTemplate = templateSet.iterator();
	//
	// while (itTemplate.hasNext()) {
	// SNode tempItTemplate = itTemplate.next();
	// if (!otherSet.contains(getIsoNodes().get(tempItTemplate))) {
	// iso = false;
	// }
	// }
	//
	// Iterator<SNode> itOther = otherSet.iterator();
	//
	// while (itOther.hasNext()) {
	// SNode tempItOther = itOther.next();
	// if (!templateSet.contains(getIsoNodes().inverse().get(tempItOther))) {
	// iso = false;
	// }
	// }
	//
	// for (SRelation i : tempList) {
	// boolean tempIso = false;
	// for (SRelation j : otherList) {
	// Set<Difference> tempSet = new HashSet<>();
	// SAnnotationContainer iTarget = (SAnnotationContainer) i.getTarget();
	// SAnnotationContainer jTarget = (SAnnotationContainer) j.getTarget();
	// // TODO check whether equals() can be used here
	// if (jTarget.equals(getIsoNodes().get(iTarget)) &&
	// compareAnnotationContainers(iTarget, jTarget, tempSet) &&
	// iTarget.equals(getIsoNodes().inverse().get(jTarget))) {
	// tempIso = true;
	// }
	// }
	// if (tempIso == false) {
	// iso = false;
	// }
	// }
	//
	// subDiffs = new HashSet<>();
	//
	// if (iso) {
	// compareAnnotationContainers(templateNode, otherNode, subDiffs);
	//
	// if (iso) {
	// getIsoNodes().put(templateNode, otherNode);
	// }
	// }
	//
	// // check whether both data sources have the same id
	// subDiffs = new HashSet<Difference>();
	// compareIdentifiableElements(templateNode, otherNode, subDiffs);
	// if (subDiffs.size() > 0) {
	// iso = false;
	// addDifference(templateNode, otherNode, null, DIFF_TYPES.ID_DIFFERING,
	// null);
	// }
	//
	// return iso;
	// }

	public boolean checkPointingRelations(SDocumentGraph template, SDocumentGraph other, Boolean diff) {
		HashSet<SPointingRelation> tempSet = new HashSet<>(template.getPointingRelations());
		Iterator<SPointingRelation> itTemp = tempSet.iterator();

		HashSet<SPointingRelation> otherSet = new HashSet<>(other.getPointingRelations());
		Iterator<SPointingRelation> itOther = otherSet.iterator();

		boolean relIso = true;
		// check whether template contains all pointing relations of other
		while (itTemp.hasNext()) {
			SPointingRelation tempPR = itTemp.next();
			boolean tempIso = false;
			SNode tempSource = tempPR.getSource();
			SNode tempTarget = tempPR.getTarget();
			for (SPointingRelation t : other.getPointingRelations()) {
				// TODO check whether equals() can be used here
				if (getIsoNodes().get(tempSource).equals(t.getSource()) && getIsoNodes().get(tempTarget).equals(t.getTarget())) {
					tempIso = true;
				}
			}
			if (tempIso == false) {
				relIso = false;
				addDifference(tempPR, null, null, DIFF_TYPES.RELATION_MISSING, null);
			}
		}

		while (itOther.hasNext()) {
			SPointingRelation otherPR = itOther.next();
			boolean otherIso = false;
			SNode otherSource = otherPR.getSource();
			SNode otherTarget = otherPR.getTarget();
			for (SPointingRelation t : template.getPointingRelations()) {
				// TODO check whether equals() can be used here
				if (getIsoNodes().get(otherSource).equals(t.getSource()) && getIsoNodes().get(otherTarget).equals(t.getTarget())) {
					otherIso = true;
				}
			}
			if (otherIso == false) {
				relIso = false;
				addDifference(null, otherPR, null, DIFF_TYPES.RELATION_MISSING, null);
			}
		}

		return relIso;

	}

	public boolean checkOrderRelations(SDocumentGraph template, SDocumentGraph other, Boolean diff) {
		HashSet<SOrderRelation> tempSet = new HashSet<>(template.getOrderRelations());
		Iterator<SOrderRelation> itTemp = tempSet.iterator();

		HashSet<SOrderRelation> otherSet = new HashSet<>(other.getOrderRelations());
		Iterator<SOrderRelation> itOther = otherSet.iterator();

		boolean relIso = true;
		while (itTemp.hasNext()) {
			SOrderRelation tempPR = itTemp.next();
			boolean tempIso = false;
			SNode tempSource = tempPR.getSource();
			SNode tempTarget = tempPR.getTarget();
			for (SOrderRelation t : other.getOrderRelations()) {
				// TODO check whether equals() can be used here
				if (getIsoNodes().get(tempSource).equals(t.getSource()) && getIsoNodes().get(tempTarget).equals(t.getTarget())) {
					tempIso = true;
				}
			}
			if (tempIso == false) {
				relIso = false;
				addDifference(tempPR, null, null, DIFF_TYPES.RELATION_MISSING, null);
			}
		}

		while (itOther.hasNext()) {
			SOrderRelation otherPR = itOther.next();
			boolean otherIso = false;
			SNode otherSource = otherPR.getSource();
			SNode otherTarget = otherPR.getTarget();
			for (SOrderRelation t : template.getOrderRelations()) {
				// TODO check whether equals() can be used here
				if (getIsoNodes().get(otherSource).equals(t.getSource()) && getIsoNodes().get(otherTarget).equals(t.getTarget())) {
					otherIso = true;
				}
			}
			if (otherIso == false) {
				relIso = false;
				addDifference(null, otherPR, null, DIFF_TYPES.RELATION_MISSING, null);
			}
		}

		return relIso;

	}

	public boolean checkLayers(SDocumentGraph template, SDocumentGraph other, Boolean diff) {
		Set<SLayer> tempLayers = (Set<SLayer>) template.getLayers();
		Set<SLayer> otherLayers = (Set<SLayer>) other.getLayers();

		Boolean iso = true;

		for (SLayer i : tempLayers) {
			boolean tempIso = false;
			for (SLayer j : otherLayers) {
				if (checkTwoLayers(i, j)) {
					tempIso = true;
				}
				if (!tempIso) {
					iso = false;
					addDifference(i, null, null, DIFF_TYPES.LAYER_MISSING, null);
				}
			}
		}

		for (SLayer j : otherLayers) {
			boolean tempIso = false;
			for (SLayer i : tempLayers) {
				if (checkTwoLayers(i, j)) {
					tempIso = true;
				}
				if (!tempIso) {
					iso = false;
					addDifference(null, j, null, DIFF_TYPES.LAYER_MISSING, null);
				}
			}
		}

		return iso;
	}

	public boolean checkTwoLayers(SLayer template, SLayer other) {
		Set<SNode> tNodes = template.getNodes();
		Set<SRelation<SNode, SNode>> tRelations = template.getRelations();

		Set<SNode> oNodes = other.getNodes();
		Set<SRelation<SNode, SNode>> oRelations = other.getRelations();

		Boolean iso = true;

		for (SNode t : tNodes) {
			if (!oNodes.contains(getIsoNodes().get(t))) {
				iso = false;
			}
		}

		for (SNode o : oNodes) {
			if (!tNodes.contains(getIsoNodes().inverse().get(o))) {
				iso = false;
			}
		}

		if (tRelations.size() != oRelations.size()) {
			iso = false;
		}

		for (SRelation<? extends SNode, ? extends SNode> t : tRelations) {
			SNode tempSource = t.getSource();
			SNode tempTarget = t.getTarget();
			for (SRelation o : oRelations) {
				boolean tempIso = false;
				// TODO check whether equals() can be used here
				if (getIsoNodes().get(tempSource).equals(o.getSource()) && getIsoNodes().get(tempTarget).equals(o.getTarget())) {
					tempIso = true;
				}
				if (tempIso == false) {
					iso = false;
					addDifference(t, null, other, DIFF_TYPES.RELATION_MISSING, null);
				}
			}
		}

		for (SRelation<? extends SNode, ? extends SNode> o : oRelations) {
			SNode tempSource = o.getSource();
			SNode tempTarget = o.getTarget();
			for (SRelation t : tRelations) {
				boolean tempIso = false;
				// TODO check whether equals() can be used here
				if (getIsoNodes().inverse().get(tempSource).equals(t.getSource()) && getIsoNodes().inverse().get(tempTarget).equals(t.getTarget())) {
					tempIso = true;
				}
				if (tempIso == false) {
					iso = false;
					addDifference(null, t, template, DIFF_TYPES.RELATION_MISSING, null);
				}
			}
		}
		return iso;
	}
}
