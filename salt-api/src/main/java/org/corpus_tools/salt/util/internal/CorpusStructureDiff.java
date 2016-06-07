package org.corpus_tools.salt.util.internal;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.corpus_tools.salt.SALT_TYPE;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.util.DIFF_TYPES;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;

public class CorpusStructureDiff {
	private final SCorpusGraph templateGraph;
	private final SCorpusGraph otherGraph;

	private final Map<String, Boolean> options;

	private Set<Difference> differences = null;

	/**
	 * Initializes Diff object with the two graphs <code>template</code> and
	 * <code>other</code>.
	 * 
	 * @param template
	 * @param other
	 */
	public CorpusStructureDiff(final SCorpusGraph template, final SCorpusGraph other) {
		this(template, other, null);
	}

	public CorpusStructureDiff(final SCorpusGraph template, final SCorpusGraph other, final Map<String, Boolean> optionMap) {
		this.templateGraph = template;
		this.otherGraph = other;

		if (optionMap != null) {
			options = optionMap;
		} else {
			options = new DiffOptions();
		}

	}

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
	private void addDifference(final Object templateObject, final Object otherObject, final Object container, final DIFF_TYPES diffType, final Set<Difference> subDiffs) {
		final Difference tempDiff = new Difference(templateObject, otherObject, container, diffType);
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
		return true;
	}

	/**
	 * This method tests whether in both graphs are the same number of objects
	 * contained. Number of:
	 * <ul>
	 * <li>nodes</li>
	 * <li>relations</li>
	 * <li>corpora</li>
	 * <li>corpus relations</li>
	 * <li>documents</li>
	 * <li>corpus document relations</li>
	 * </ul>
	 * 
	 * @param template
	 *            first SDocGraph
	 * @param other
	 *            second SDocGraph
	 * @return returns whether sizes are the same
	 **/
	private static boolean compareSize(final SCorpusGraph template, final SCorpusGraph other) {
		// size comparison for all data structures in Salt beside STimeline
		if (template.getNodes().size() != other.getNodes().size()) {
			return false;
		}
		if (template.getRelations().size() != other.getRelations().size()) {
			return false;
		}
		if (template.getCorpora().size() != other.getCorpora().size()) {
			return false;
		}
		if (template.getCorpusRelations().size() != other.getCorpusRelations().size()) {
			return false;
		}
		if (template.getDocuments().size() != other.getDocuments().size()) {
			return false;
		}
		if (template.getCorpusDocumentRelations().size() != other.getCorpusDocumentRelations().size()) {
			return false;
		}
		return true;
	}
}
