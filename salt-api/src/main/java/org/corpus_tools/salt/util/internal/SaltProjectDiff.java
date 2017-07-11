/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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

import static org.corpus_tools.salt.util.DIFF_TYPES.PROJECT_MISSING;
import static org.corpus_tools.salt.util.DIFF_TYPES.PROJECT_NAME_DIFFERING;

import java.util.Set;

import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.util.DIFF_TYPES;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;
import org.corpus_tools.salt.util.SaltUtil;

public class SaltProjectDiff extends AbstractDiff<SaltProject> {

	/**
	 * Initializes Diff object with the two graphs <code>template</code> and
	 * <code>other</code>.
	 * 
	 * @param template
	 * @param other
	 */
	public SaltProjectDiff(SaltProject template, SaltProject other) {
		this(template, other, null);
	}

	public SaltProjectDiff(SaltProject template, SaltProject other, DiffOptions optionMap) {
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
		boolean retVal = true;
		if (templateObject == null || otherObject == null) {
			if (!diffsRequested) {
				return false;
			}
			retVal = false;
			addDifference(templateObject, otherObject, null, PROJECT_MISSING, null);
		}
		if (templateObject.getName() != null) {
			if (!templateObject.getName().equals(otherObject.getName())) {
				if (!diffsRequested) {
					return false;
				}
				retVal = false;
				addDifference(templateObject, otherObject, null, PROJECT_NAME_DIFFERING, null);
			}
		} else if (otherObject.getName() != null) {
			if (!diffsRequested) {
				return false;
			}
			retVal = false;
			addDifference(templateObject, otherObject, null, DIFF_TYPES.PROJECT_NAME_DIFFERING, null);
		}
		if (otherObject.getCorpusGraphs().size() != templateObject.getCorpusGraphs().size()) {
			if (!diffsRequested) {
				return false;
			}
			retVal = false;
			addDifference(templateObject, otherObject, null, DIFF_TYPES.PROJECT_NUMBER_CORPUS_GRAPH_DIFFERING, null);
		}
		for (int i = 0; i < otherObject.getCorpusGraphs().size(); i++) {
			if (!diffsRequested) {
				return SaltUtil.compare(templateObject.getCorpusGraphs().get(0))
						.with(otherObject.getCorpusGraphs().get(0)).andCheckIsomorphie();
			}
			final Set<Difference> diffs = SaltUtil.compare(templateObject.getCorpusGraphs().get(0))
					.with(otherObject.getCorpusGraphs().get(0)).andFindDiffs();
			if (diffs.size() > 0) {
				retVal = false;
				addDifference(templateObject, otherObject, null, DIFF_TYPES.CORPUS_GRAPH_DIFFERING, diffs);
			}
		}
		return retVal;
	}
}
