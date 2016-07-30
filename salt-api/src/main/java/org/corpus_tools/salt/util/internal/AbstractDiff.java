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

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusDocumentRelation;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SCorpusRelation;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.core.SAbstractAnnotation;
import org.corpus_tools.salt.core.SAnnotationContainer;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.graph.IdentifiableElement;
import org.corpus_tools.salt.util.DIFF_TYPES;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;
import org.corpus_tools.salt.util.SaltUtil;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public abstract class AbstractDiff<G extends SGraph> {
	protected final G templateGraph;
	protected final G otherGraph;

	protected final DiffOptions options;

	protected Set<Difference> differences = null;
	/** isomorphic {@link SNode}s key= template, value= other **/
	private BiMap<SNode, SNode> isoNodes = null;

	/**
	 * Return BiMap with isomorphic {@link SNode}s key= template, value= other
	 * 
	 * @return BiMap with isomorphic {@link SNode}s
	 **/
	protected BiMap<SNode, SNode> getIsoNodes() {
		if (isoNodes == null) {
			isoNodes = HashBiMap.create();
		}
		return isoNodes;
	}

	/**
	 * Initializes Diff object with the two graphs <code>template</code> and
	 * <code>other</code>.
	 * 
	 * @param template
	 * @param other
	 */
	public AbstractDiff(final G template, final G other) {
		this(template, other, null);
	}

	public AbstractDiff(final G template, final G other, DiffOptions optionMap) {
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
	protected Set<Difference> getDifferences() {
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
	protected void addDifference(final Object templateObject, final Object otherObject, final Object container, final DIFF_TYPES diffType, final Set<Difference> subDiffs) {
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
	protected boolean diffsRequested = false;

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
	protected boolean compareIdentifiableElements(final IdentifiableElement template, final IdentifiableElement other, final Set<Difference> subDiffs) {
		boolean retVal = true;
		if (!options.get(DiffOptions.OPTION_IGNORE_ID)) {
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
	protected boolean compareAnnotationContainers(final SAnnotationContainer template, final SAnnotationContainer other, final Set<Difference> subDiffs) {
		boolean retVal1 = true;
		boolean retVal2 = true;
		boolean retVal3 = true;
		boolean retVal4 = true;

		if (!(boolean) options.get(DiffOptions.OPTION_IGNORE_ANNOTATIONS)) {
			final Iterator<SAbstractAnnotation> otherIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) other.iterator_SAnnotation();
			final Iterator<SAbstractAnnotation> templateIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) template.iterator_SAnnotation();
			retVal1 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}
		if (!(boolean) options.get(DiffOptions.OPTION_IGNORE_META_ANNOTATIONS)) {
			final Iterator<SAbstractAnnotation> otherIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) other.iterator_SMetaAnnotation();
			final Iterator<SAbstractAnnotation> templateIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) template.iterator_SMetaAnnotation();
			retVal2 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}
		if (!(boolean) options.get(DiffOptions.OPTION_IGNORE_PROCESSING_ANNOTATIONS)) {
			final Iterator<SAbstractAnnotation> otherIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) other.iterator_SProcessingAnnotation();
			final Iterator<SAbstractAnnotation> templateIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) template.iterator_SProcessingAnnotation();
			retVal3 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}
		if (!(boolean) options.get(DiffOptions.OPTION_IGNORE_FEATURES)) {
			final Iterator<SAbstractAnnotation> otherIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) other.iterator_SFeature();
			final Iterator<SAbstractAnnotation> templateIterator = (Iterator<SAbstractAnnotation>) (Iterator<? extends SAbstractAnnotation>) template.iterator_SFeature();
			retVal4 = compareAnnotationContainers(template, templateIterator, other, otherIterator, subDiffs);
			if (!retVal1 && subDiffs != null) {
				return (false);
			}
		}

		return (retVal1 && retVal2 && retVal3 && retVal4);
	}

	/**
	 * Returns true, when anno is a name feature and if the name feature should
	 * be ignored.
	 * 
	 * @param anno
	 * @return
	 */
	private boolean ignoreAbstractAnnotation(final SAbstractAnnotation anno) {
		if (anno == null) {
			return true;
		}
		if (anno instanceof SFeature) {
			if (SaltUtil.FEAT_NAME_QNAME.equals(anno.getQName())) {
				final boolean belongsToCorpusStructure = SaltUtil.belongsToCorpusStructure(anno.getContainer());
				if (belongsToCorpusStructure && options.get(DiffOptions.OPTION_IGNORE_CORPUS_STRUCTURE_NAME)) {
					return true;
				} else if (!belongsToCorpusStructure && options.get(DiffOptions.OPTION_IGNORE_NAME)) {
					return true;
				}
			}else if (SaltUtil.FEAT_SDOCUMENT_GRAPH_QNAME.equals(anno.getQName())) {
				return true;
			}else if (SaltUtil.FEAT_SDOCUMENT_GRAPH_LOCATION_QNAME.equals(anno.getQName())) {
				return true;
			}
		}
		return false;
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
	private boolean compareAnnotationContainers(final SAnnotationContainer template, final Iterator<SAbstractAnnotation> templateIterator, final SAnnotationContainer other, final Iterator<SAbstractAnnotation> otherIterator, final Set<Difference> subDiffs) {
		boolean retVal = true;

		// create remaining list, which contains all annos from other
		final Set<SAbstractAnnotation> remainingLabels = new HashSet<>();
		while (otherIterator.hasNext()) {
			final SAbstractAnnotation anno = otherIterator.next();
			if (ignoreAbstractAnnotation(anno)) {
				continue;
			}
			remainingLabels.add(anno);
		}

		// for each annotation from template, check whether other also contains
		// a isomorph annotation
		while (templateIterator.hasNext()) {
			final SAbstractAnnotation templateAnno = templateIterator.next();

			if (ignoreAbstractAnnotation(templateAnno)) {
				continue;
			}
			final SAbstractAnnotation otherAnno = (SAbstractAnnotation) other.getLabel(templateAnno.getQName());
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
					return false;
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

	protected abstract boolean findDiffs(boolean diffsRequested);
}
