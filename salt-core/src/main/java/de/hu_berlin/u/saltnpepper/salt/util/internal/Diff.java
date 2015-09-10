package de.hu_berlin.u.saltnpepper.salt.util.internal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotationContainer;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SNamedElement;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SFeatureImpl;

/**
 * This class compares two {@link SDocumentGraph} objects for isomorphy. It uses
 * characteristics of Salt Graphs to use a more specific algorithm for checking
 * whether a graph is isomorphic. At first tokens are compared. Both graphs are
 * compared starting with offset "0". Two tokens are the same, when the offsets
 * and the SText are the same. As with all following SNodes, SAnnotations and
 * SFeatures are checked. The next step is to look for SNodes that are the
 * source of a SIncomingRelation of a SToken. Of these only those are picked,
 * that have SNodes on their SOutgoingrelations, that already have been checked
 * (at this point: only STokens). These SNodes are then compared with eachother.
 * Whenever a relation is used in the way described above, the SRelation is
 * checked for SFeatures and SRelations.
 * 
 * @author André Röhrig
 *
 */
public class Diff {

	private SDocumentGraph template = null;
	private SDocumentGraph other = null;

	private Map options = new HashMap<>();

	public Diff() {
		options.put("annoIso", true);
		options.put("annoDiff", true);
		options.put("idCheck", false);
	}

	/**
	 * Initializes Diff object with the two graphs <code>template</code> and
	 * <code>other</code>.
	 * 
	 * @param template
	 * @param other
	 */
	public Diff(SDocumentGraph template, SDocumentGraph other) {
		this.template = template;
		this.other = other;

		options.put("annoIso", true);
		options.put("annoDiff", true);
		options.put("idCheck", false);
	}

	public Diff(SDocumentGraph template, SDocumentGraph other, Map optionMap) {
		this.template = template;
		this.other = other;

		options = optionMap;
	}

	public enum DIFF_TYPES {
		/*
		 * one of the compared objects contains a label, which is missing for
		 * the other one
		 */
		LABEL_MISSING,
		/* the compared labels differ in their namespace */
		LABEL_NAMESPACES_DIFFERING,
		/* the compared labels differ in their name */
		LABEL_NAME_DIFFERING,
		/* the compared labels differ in their value */
		LABEL_VALUE_DIFFERING,
		/* the ids of the compared objects differ */
		ID_DIFFERING,
		/*
		 * one of the compared graphs contains a node that is missing for the
		 * other one
		 */
		NODE_MISSING,
		/* the compared nodes differ in their name */
		NODE_NAME_DIFFERING,
		/*
		 * one of the compared graphs contains a relation that is missing for
		 * the other one
		 */
		RELATION_MISSING,
		/* the compared relations differ in their type */
		RELATION_TYPE_DIFFERING,
		/* the compared relations differ in their name */
		RELATION_NAME_DIFFERING,
		/*
		 * one of the compared graphs contains a layer that is missing for the
		 * other one
		 */
		LAYER_MISSING,
		/* the compared layers differ in their name */
		LAYER_NAME_DIFFERING
	}

	public class Difference {
		/** Object of graph template, if this difference type has one **/
		public Object templateObject;
		/** Object of graph other, if this difference type has one **/
		public Object otherObject;
		/** Object containing the given object, e.g. used for layers **/
		public Object container;
		/** type of the difference **/
		public DIFF_TYPES diffType;

		public Set<Difference> subDiffs = null;

		public void addSubDiffs(Set<Difference> subDiffs) {
			this.subDiffs = subDiffs;
		}

		public Difference(Object templateObject, Object otherObject, Object container, DIFF_TYPES diffType) {
			this.templateObject = templateObject;
			this.otherObject = otherObject;
			this.container = container;
			this.diffType = diffType;
		}

		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			str.append(diffType.toString());

			if (templateObject != null) {
				str.append("	Graph1_Object:");
				str.append(" SType:");

				str.append((String) templateObject.getClass().getSimpleName());

				str.append(" SName:");
				if (templateObject instanceof SAnnotationImpl) {
					str.append((String) ((SAnnotation) templateObject).getName());
				}

				else if (templateObject instanceof SFeatureImpl) {
					str.append((String) ((SFeature) templateObject).getName());
				}

				else {
					str.append((String) ((SNamedElement) templateObject).getName());
				}
			}

			if (otherObject != null) {
				str.append(" Graph2_Object:");
				str.append(" SType:");

				str.append((String) otherObject.getClass().getSimpleName());

				str.append(" SName:");
				if (otherObject instanceof SAnnotationImpl) {
					str.append((String) ((SAnnotation) otherObject).getName());
				}

				else if (otherObject instanceof SFeatureImpl) {
					str.append((String) ((SFeature) otherObject).getName());
				}

				else {
					str.append((String) ((SNamedElement) otherObject).getName());
				}
			}

			if (container != null) {
				str.append(" Container:" + container.toString());
			}

			if (subDiffs != null) {
				Iterator<Difference> iterator = subDiffs.iterator();
				while (iterator.hasNext()) {
					str.append("\n	" + iterator.next().toString());
				}

			}

			return str.toString();
		}
	}

	private Set<Difference> differences = null;

	/**
	 * Returns a list containing all computed differences.
	 * 
	 * @return returns differences Set
	 **/
	public Set<Difference> getDifferences() {
		if (differences == null) {
			differences = new LinkedHashSet<Diff.Difference>();
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
	public void addDifference(Object templateObject, Object otherObject, Object container, DIFF_TYPES diffType, Set<Difference> subDiffs) {
		Difference tempDiff = new Difference(templateObject, otherObject, container, diffType);
		if (subDiffs != null) {
			tempDiff.addSubDiffs(subDiffs);
		}
		getDifferences().add(tempDiff);
	}

	Difference diff = null;

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
		if (!checkingSizes(template, other)) {
			return false;
		}

		if (!compareSTextualDS(template, other, false)) {
			return false;
		}

		if (!compareSToken(template, other, false)) {
			return false;
		}

		if (!compareSNode(template, other, false)) {
			return false;
		}

		if (!checkPointingRelations(template, other, false)) {
			return false;
		}

		if (!checkOrderRelations(template, other, false)) {
			return false;
		}

		if (!checkLayers(template, other, false)) {
			return false;
		}
		return true;
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
		checkingSizes(template, other);
		compareSTextualDS(template, other, true);
		compareSToken(template, other, true);
		compareSNode(template, other, true);
		checkPointingRelations(template, other, true);
		checkOrderRelations(template, other, true);
		checkLayers(template, other, true);
		return getDifferences();
	}

	// helper methods for checking certain data structures of salt
	/**
	 * method to check sizes of all Salt specific data structures
	 * 
	 * @param template
	 *            first SDocGraph
	 * @param other
	 *            second SDocGraph
	 * @return returns whether sizes are the same
	 **/
	private boolean checkingSizes(SDocumentGraph template, SDocumentGraph other) {

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

	private BiMap<Object, Object> isoObjects = null;

	/**
	 * return BiMap with isomorphic Salt object
	 * 
	 * @return BiMap with isomorphic Salt objects
	 **/
	public BiMap<Object, Object> getIsoObjects() {
		if (isoObjects == null) {
			isoObjects = HashBiMap.create();
		}
		return isoObjects;
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
	 * method to check STextualDSs for isomorphy
	 * 
	 * @return isomorphy still possible after this check
	 * @param template
	 *            first sDocGraph
	 * @param other
	 *            second sDocGraph
	 * @param diff
	 *            if true, diffs are checked as well
	 **/
	private boolean compareSTextualDS(SDocumentGraph template, SDocumentGraph other, boolean diff) {
		boolean iso = true;

		// initializing
		List<STextualDS> templateDSlist = template.getTextualDSs();
		List<STextualDS> otherDSlist = other.getTextualDSs();

		int templateRange = templateDSlist.size();
		int otherRange = otherDSlist.size();

		Set<STextualDS> templateMatched = new HashSet<>();
		Set<STextualDS> otherMatched = new HashSet<>();

		// checking for isomorphic objects
		// adding these objects to BiMap
		for (int i = 0; i < templateRange; i = i + 1) {
			STextualDS templateDS = templateDSlist.get(i);
			for (int j = 0; j < otherRange; j = j + 1) {
				STextualDS otherDS = otherDSlist.get(j);
				if (!otherMatched.contains(otherDS)) {
					if (templateDS.getText().equals(otherDS.getText())) {
						getIsoObjects().put(templateDS, otherDS);
						templateMatched.add(templateDSlist.get(i));
						otherMatched.add(otherDSlist.get(i));
						break;
					}
				}
			}
			// check whether isomorphy can be ruled out
			if (!templateMatched.contains(templateDS)) {
				if (!diff) {
					return false;
				} else {
					iso = false;
				}
			}
		}
		// check whether isomorphy can be ruled out
		if (otherMatched.size() < otherDSlist.size()) {
			if (!diff) {
				return false;
			} else {
				iso = false;
			}
		}

		if (!diff) {
			return iso;
		}

		// find unmatched objects and declare diffs
		templateRange = templateDSlist.size();
		otherRange = otherDSlist.size();

		for (int i = 0; i < templateRange; i = i + 1) {
			STextualDS templateDS = templateDSlist.get(i);
			if (!templateMatched.contains(templateDS))
				addDifference(templateDS, null, null, DIFF_TYPES.NODE_MISSING, null);
		}

		for (int i = 0; i < templateRange; i = i + 1) {
			STextualDS otherDS = otherDSlist.get(i);
			if (!otherMatched.contains(otherDS))
				addDifference(null, otherDS, null, DIFF_TYPES.NODE_MISSING, null);
		}
		return iso;
	}

	/**
	 * method to check STokens for isomorphy
	 * 
	 * @return isomorphy still possible after this check
	 * @param template
	 *            first sDocGraph
	 * @param other
	 *            second sDocGraph
	 * @param diff
	 *            if true, diffs are checked as well
	 **/
	private boolean compareSToken(SDocumentGraph template, SDocumentGraph other, boolean diff) {
		boolean iso = true;

		// initializing
		List<SToken> templateDSlist = template.getTokens();
		List<SToken> otherDSlist = other.getTokens();

		checkedElements.addAll(templateDSlist);
		checkedElements.addAll(otherDSlist);

		int templateRange = templateDSlist.size();
		int otherRange = otherDSlist.size();

		Set<SToken> templateMatched = new HashSet<>();
		Set<SToken> otherMatched = new HashSet<>();

		// checking for isomorphic objects
		// adding these objects to BiMap
		int nextJ = 0;

		for (int i = 0; i < templateRange; i = i + 1) {
			SToken templateTok = templateDSlist.get(i);
			for (int j = nextJ; j < otherRange; j = j + 1) {
				SToken otherTok = otherDSlist.get(j);
				if (!otherMatched.contains(otherTok)) {
					if (template.getText(templateTok).equals(other.getText(otherTok))) {
						Set<Difference> subDiffs = new HashSet<>();
						if (compareSAnnotations(templateTok, otherTok, subDiffs)) {

						} else {
							iso = false;
							if ((boolean) options.get("annoIso")) {
								addDifference(templateTok, otherTok, null, DIFF_TYPES.NODE_MISSING, subDiffs);
							}
						}

						getIsoObjects().put(templateTok, otherTok);
						templateMatched.add(templateDSlist.get(i));
						otherMatched.add(otherDSlist.get(i));
						nextJ = j;
						break;

					}
				}
			}
			// check whether isomorphy can be ruled out
			if (!templateMatched.contains(templateTok)) {
				if (!diff) {
					return false;
				} else {
					iso = false;
				}
			}
		}

		// check whether isomorphy can be ruled out
		if (otherMatched.size() < otherDSlist.size()) {
			if (!diff) {
				return false;
			} else {
				iso = false;
			}
		}

		if (!diff) {
			return iso;
		}

		// find unmatched objects and declare diffs
		templateRange = templateDSlist.size();
		otherRange = otherDSlist.size();

		for (int i = 0; i < templateRange; i = i + 1) {
			SToken templateDS = templateDSlist.get(i);
			if (!templateMatched.contains(templateDS))
				addDifference(templateDS, null, null, DIFF_TYPES.NODE_MISSING, null);
		}

		for (int i = 0; i < templateRange; i = i + 1) {
			SToken otherDS = otherDSlist.get(i);
			if (!otherMatched.contains(otherDS))
				addDifference(null, otherDS, null, DIFF_TYPES.NODE_MISSING, null);
		}
		return iso;
	}

	/**
	 * method to check SNodes of docGraphs for isomorphy
	 * 
	 * @return isomorphy still possible after this check
	 * @param template
	 *            first sDocGraph
	 * @param other
	 *            second sDocGraph
	 * @param diff
	 *            if true, diffs are checked as well
	 **/
	private boolean compareSNode(SDocumentGraph template, SDocumentGraph other, boolean diff) {
		boolean iso = true;

		// initializing
		List<SToken> templateDSlist = template.getTokens();
		List<SToken> otherDSlist = other.getTokens();

		Set<SNode> template0 = new HashSet<>();
		Set<SNode> other0 = new HashSet<>();

		for (int i = 0; i < templateDSlist.size(); i = i + 1) {
			List<SRelation> relList = templateDSlist.get(i).getInRelations();
			for (int j = 0; j < relList.size(); j = j + 1) {
				if (!(template0.contains(relList.get(j).getSource()) || relList.get(j) instanceof SPointingRelation || relList.get(j) instanceof SOrderRelation))
					template0.add((SNode) relList.get(j).getSource());
			}
		}

		for (int i = 0; i < otherDSlist.size(); i = i + 1) {
			List<SRelation> relList = otherDSlist.get(i).getInRelations();
			for (int j = 0; j < relList.size(); j = j + 1) {
				if (!(other0.contains(relList.get(j).getSource()) || relList.get(j) instanceof SPointingRelation || relList.get(j) instanceof SOrderRelation))
					other0.add((SNode) relList.get(j).getSource());
			}
		}

		for (SNode s : template0) {
			Set<Difference> subDiffs = null;
			boolean tempIso = false;
			for (SNode t : other0) {
				if (compareTwoNodes(s, t, subDiffs)) {
					tempIso = true;
				}
			}
			if (tempIso == false) {
				addDifference(s, null, null, DIFF_TYPES.NODE_MISSING, subDiffs);
				iso = false;
			}
		}

		for (SNode t : other0) {
			Set<Difference> subDiffs = null;
			boolean tempIso = false;
			for (SNode s : template0) {
				if (compareTwoNodes(t, s, subDiffs)) {
					tempIso = true;
				}
			}
			if (tempIso == false) {
				addDifference(null, t, null, DIFF_TYPES.NODE_MISSING, subDiffs);
				iso = false;
			}
		}

		itNodeClass it = new itNodeClass();
		it.iso = iso;
		it.templateSet = template0;
		it.otherSet = other0;

		while (it.newNodes) {
			iterateNodeCheck(it);
		}

		return it.iso;

	}

	private itNodeClass iterateNodeCheck(itNodeClass it) {
		Set<SNode> template0 = it.templateSet;
		Set<SNode> other0 = it.otherSet;

		Iterator<SNode> itTemplate = template0.iterator();
		Iterator<SNode> otTemplate = other0.iterator();

		Set<SNode> template1 = new HashSet<>();
		Set<SNode> other1 = new HashSet<>();

		while (itTemplate.hasNext()) {
			List<SRelation> relList = itTemplate.next().getInRelations();
			for (int j = 0; j < relList.size(); j = j + 1) {
				if (!(template0.contains(relList.get(j).getSource()) || relList.get(j) instanceof SPointingRelation || relList.get(j) instanceof SOrderRelation))
					template1.add((SNode) relList.get(j).getSource());
			}
		}

		while (otTemplate.hasNext()) {
			List<SRelation> relList = otTemplate.next().getInRelations();
			for (int j = 0; j < relList.size(); j = j + 1) {
				if (!(other0.contains(relList.get(j).getSource()) || relList.get(j) instanceof SPointingRelation || relList.get(j) instanceof SOrderRelation))
					other1.add((SNode) relList.get(j).getSource());
			}
		}

		for (SNode s : template1) {
			Set<Difference> subDiffs = null;
			if (checkChecked(s)) {
				checkedElements.add(s);

				boolean tempIso = false;
				for (SNode t : other0) {
					if (compareTwoNodes(s, t, subDiffs)) {
						tempIso = true;
					}
				}
				if (tempIso == false) {
					it.iso = false;
					addDifference(s, null, null, DIFF_TYPES.NODE_MISSING, subDiffs);
				}
			}
		}

		for (SNode t : other1) {
			Set<Difference> subDiffs = null;
			if (checkChecked(t)) {
				checkedElements.add(t);
				boolean tempIso = false;
				for (SNode s : template0) {
					if (compareTwoNodes(t, s, subDiffs)) {
						tempIso = true;
					}
				}
				if (tempIso == false) {
					it.iso = false;
					addDifference(null, t, null, DIFF_TYPES.NODE_MISSING, subDiffs);
				}
			}
		}

		it.templateSet = template1;
		it.otherSet = other1;

		if (it.templateSet.size() == 0 && it.otherSet.size() == 0) {
			it.newNodes = false;
		}

		return it;
	}

	public class itNodeClass {
		Set<SNode> templateSet = null;
		Set<SNode> otherSet = null;
		boolean iso = true;
		boolean newNodes = true;
	}

	/**
	 * method to check two SNode for isomorphy
	 * 
	 * @return isomorphy still possible after this check
	 * @param template
	 *            first SNode
	 * @param other
	 *            second SNode
	 **/
	public boolean compareTwoNodes(SNode templateNode, SNode otherNode, Set<Difference> subDiffs) {
		List<SRelation> tempList = templateNode.getOutRelations();
		Set<SNode> templateSet = new HashSet<>();

		boolean iso = true;

		for (SRelation r : tempList) {
			templateSet.add((SNode) r.getTarget());
		}

		List<SRelation> otherList = otherNode.getOutRelations();
		Set<SNode> otherSet = new HashSet<>();

		for (SRelation r : otherList) {
			otherSet.add((SNode) r.getTarget());
		}

		Iterator<SNode> itTemplate = templateSet.iterator();

		while (itTemplate.hasNext()) {
			SNode tempItTemplate = itTemplate.next();
			if (!otherSet.contains(isoObjects.get(tempItTemplate))) {
				iso = false;
			}
		}

		Iterator<SNode> itOther = otherSet.iterator();

		while (itOther.hasNext()) {
			SNode tempItOther = itOther.next();
			if (!templateSet.contains(isoObjects.inverse().get(tempItOther))) {
				iso = false;
			}
		}

		for (SRelation i : tempList) {
			boolean tempIso = false;
			for (SRelation j : otherList) {
				Set<Difference> tempSet = new HashSet<>();
				SAnnotationContainer iTarget = (SAnnotationContainer) i.getTarget();
				SAnnotationContainer jTarget = (SAnnotationContainer) j.getTarget();
				if (jTarget.equals(isoObjects.get(iTarget)) && compareSFeatures(iTarget, jTarget, tempSet) && iTarget.equals(isoObjects.inverse().get(jTarget))) {
					tempIso = true;
					tempIso = compareSAnnotations(i, j, null);
				}
			}
			if (tempIso == false) {
				iso = false;
			}
		}

		subDiffs = new HashSet<>();

		if (iso) {
			if ((boolean) options.get("annoIso")) {
				compareSAnnotations(templateNode, otherNode, subDiffs);
			}

			compareSFeatures(templateNode, otherNode, subDiffs);

			if (iso) {
				isoObjects.put(templateNode, otherNode);
			}
		}

		if ((boolean) options.get("idCheck") && iso) {
			if (templateNode.getId() != otherNode.getId()) {
				addDifference(templateNode, otherNode, null, DIFF_TYPES.ID_DIFFERING, null);
				iso = false;
			}
		}

		return iso;
	}

	public boolean compareSFeatures(SAnnotationContainer templateNode, SAnnotationContainer otherNode, Set<Difference> subDiffs) {
		Set<SFeature> tempSet = new HashSet<>(templateNode.getFeatures());
		Set<SFeature> otherSet = new HashSet<>(otherNode.getFeatures());

		boolean iso = true;
		Iterator<SFeature> itTemplate = tempSet.iterator();

		while (itTemplate.hasNext()) {
			SFeature tempFeat = itTemplate.next();
			if (!otherSet.contains(tempFeat)) {
				Difference tempDiff = new Difference(tempFeat, null, null, DIFF_TYPES.LABEL_MISSING);
				subDiffs.add(tempDiff);
				iso = false;
			}
		}

		Iterator<SFeature> itOther = otherSet.iterator();

		while (itOther.hasNext()) {
			SFeature tempFeat = itOther.next();
			if (!tempSet.contains(tempFeat)) {
				Difference tempDiff = new Difference(null, tempFeat, null, DIFF_TYPES.LABEL_MISSING);
				subDiffs.add(tempDiff);
				iso = false;
			}
		}

		return iso;
	}

	public boolean compareSAnnotations(SAnnotationContainer templateNode, SAnnotationContainer otherNode, Set<Difference> subDiffs) {
		
		boolean iso = true;
		if ((boolean) options.get("annoDiff")) {
			Iterator<SAnnotation> it= templateNode.iterator_SAnnotation();
			while (it.hasNext()) {
				SAnnotation anno = it.next();
				if (!otherNode.containsLabel(anno.getQName())){
					Difference tempDiff = new Difference(anno, null, null, DIFF_TYPES.LABEL_MISSING);
					subDiffs.add(tempDiff);
					iso = false;
				}
			}
			it= otherNode.iterator_SAnnotation();
			while (it.hasNext()) {
				SAnnotation anno = it.next();
				if (!templateNode.containsLabel(anno.getQName())) {
					Difference tempDiff = new Difference(null, anno, null, DIFF_TYPES.LABEL_MISSING);
					subDiffs.add(tempDiff);
					iso = false;
				}
			}
		}
		return iso;

		
		
		//		Set<SAnnotation> tempSet = new HashSet<>(templateNode.getAnnotations());
//		Set<SAnnotation> otherSet = new HashSet<>(otherNode.getAnnotations());
//
//		boolean iso = true;
//		Iterator<SAnnotation> itTemplate = tempSet.iterator();
//
//		if ((boolean) options.get("annoDiff")) {
//			while (itTemplate.hasNext()) {
//				SAnnotation tempFeat = itTemplate.next();
//				System.out.println("search "+tempFeat);
//				if (!otherSet.contains(tempFeat)) {
//					Difference tempDiff = new Difference(tempFeat, null, null, DIFF_TYPES.LABEL_MISSING);
//					subDiffs.add(tempDiff);
//					System.out.println("not there ");
//					iso = false;
//				}else{
//					System.out.println("is there ");
//				}
//			}
//
//			Iterator<SAnnotation> itOther = otherSet.iterator();
//
//			while (itOther.hasNext()) {
//				SAnnotation tempFeat = itOther.next();
//				if (!tempSet.contains(tempFeat)) {
//					Difference tempDiff = new Difference(null, tempFeat, null, DIFF_TYPES.LABEL_MISSING);
//					subDiffs.add(tempDiff);
//					System.out.println("compare sanno 2: ");
//					iso = false;
//				}
//			}
//		}
//		return iso;

	}

	public boolean checkPointingRelations(SDocumentGraph template, SDocumentGraph other, Boolean diff) {
		HashSet<SPointingRelation> tempSet = new HashSet<>(template.getPointingRelations());
		Iterator<SPointingRelation> itTemp = tempSet.iterator();

		HashSet<SPointingRelation> otherSet = new HashSet<>(other.getPointingRelations());
		Iterator<SPointingRelation> itOther = otherSet.iterator();

		boolean relIso = true;
		while (itTemp.hasNext()) {
			SPointingRelation tempPR = itTemp.next();
			boolean tempIso = false;
			SNode tempSource = tempPR.getSource();
			SNode tempTarget = tempPR.getTarget();
			for (SPointingRelation t : other.getPointingRelations()) {
				if (isoObjects.get(tempSource).equals(t.getSource()) && isoObjects.get(tempTarget).equals(t.getTarget())) {
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
				if (isoObjects.get(otherSource).equals(t.getSource()) && isoObjects.get(otherTarget).equals(t.getTarget())) {
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
				if (isoObjects.get(tempSource).equals(t.getSource()) && isoObjects.get(tempTarget).equals(t.getTarget())) {
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
				if (isoObjects.get(otherSource).equals(t.getSource()) && isoObjects.get(otherTarget).equals(t.getTarget())) {
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
			if (!oNodes.contains(isoObjects.get(t))) {
				iso = false;
			}
		}

		for (SNode o : oNodes) {
			if (!tNodes.contains(isoObjects.inverse().get(o))) {
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
				if (isoObjects.get(tempSource).equals(o.getSource()) && isoObjects.get(tempTarget).equals(o.getTarget())) {
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
				if (isoObjects.inverse().get(tempSource).equals(t.getSource()) && isoObjects.inverse().get(tempTarget).equals(t.getTarget())) {
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
