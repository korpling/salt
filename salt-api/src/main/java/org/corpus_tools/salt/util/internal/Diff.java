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

import java.util.Map;
import java.util.Set;

import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.util.DIFF_TYPES;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;

import com.google.common.collect.Sets;

/**
 * This class compares two {@link SDocumentGraph} objects for isomorphie. It
 * uses characteristics of document graphs to use a more specific algorithm for
 * checking whether a graph is isomorphic. At first tokens are compared. Both
 * graphs are compared starting with offset "0". Two tokens are the same, when
 * their textual offset and the overlapped text is the same. As with all
 * following {@link SNode}s, {@link SAnnotation}s and {@link SFeature}s are
 * checked. The next step is to look for {@link SNode}s that are the source of a
 * incoming relations of a {@link SToken}. Of these only those are picked, that
 * have {@link SNode}s on their outgoing relations, that already have been
 * checked (at this point: only {@link SToken}s). These {@link SNode}s are then
 * compared with each other. Whenever a relation is used in the way described
 * above, the {@link SRelation} is checked for {@link SFeature}s and
 * {@link SRelation}s.
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

	/**
	 * A fluent builder for comparing two {@link SDocumentGraph} or
	 * {@link SCorpusGraph} objects.
	 * 
	 * @author florian
	 *
	 * @param <S>
	 *            type of Salt element to be compared
	 */
	public static class Builder<S extends Object> {
		private final S saltElement;

		public Builder(S templateGraph) {
			this.saltElement = templateGraph;
		}

		public Builder2<S> with(S otherGraph) {
			return new Builder2<S>(saltElement, otherGraph);
		}

		public static class Builder2<S> {
			private final S templateObject;
			private final S otherObject;
			private DiffOptions options = new DiffOptions();

			public Builder2(final S templateGraph, final S otherGraph) {
				this.templateObject = templateGraph;
				this.otherObject = otherGraph;
			}

			public boolean andCheckIsomorphie() {
				if (templateObject == null || otherObject == null) {
					return false;
				} else if (templateObject instanceof SDocumentGraph && otherObject instanceof SDocumentGraph) {
					return new Diff((SDocumentGraph) templateObject, (SDocumentGraph) otherObject, options)
							.isIsomorph();
				} else if (templateObject instanceof SCorpusGraph && otherObject instanceof SCorpusGraph) {
					return new Diff((SCorpusGraph) templateObject, (SCorpusGraph) otherObject, options).isIsomorph();
				} else if (templateObject instanceof SaltProject && otherObject instanceof SaltProject) {
					return new Diff((SaltProject) templateObject, (SaltProject) otherObject, options).isIsomorph();
				}
				throw new SaltException("Cannot compare peaches with appels. ");
			}

			public Set<Difference> andFindDiffs() {
				if (templateObject == null || otherObject == null) {
					return Sets.newHashSet(new Difference(null, null, null, DIFF_TYPES.NULL_OBJECT));
				} else if (templateObject instanceof SDocumentGraph && otherObject instanceof SDocumentGraph) {
					return new Diff((SDocumentGraph) templateObject, (SDocumentGraph) otherObject, options).findDiffs();
				} else if (templateObject instanceof SCorpusGraph && otherObject instanceof SCorpusGraph) {
					return new Diff((SCorpusGraph) templateObject, (SCorpusGraph) otherObject, options).findDiffs();
				}else if (templateObject instanceof SaltProject && otherObject instanceof SaltProject) {
					return new Diff((SaltProject) templateObject, (SaltProject) otherObject, options).findDiffs();
				}
				throw new SaltException("Cannot compare peaches with appels. ");
			}

			public Builder2<S> useOption(String option) {
				options.put(option, true);
				return this;
			}

			public Builder2<S> useOption(String option, boolean value) {
				options.put(option, value);
				return this;
			}

			public Builder2<S> useOptions(DiffOptions options) {
				this.options = options;
				return this;
			}
		}
	}

	private DocumentStructureDiff documentStructureDiff = null;
	private CorpusStructureDiff corpusStructureDiff = null;
	private SaltProjectDiff saltProjectDiff = null;

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

	public Diff(SDocumentGraph template, SDocumentGraph other, DiffOptions optionMap) {
		documentStructureDiff = new DocumentStructureDiff(template, other, optionMap);
	}

	/**
	 * 
	 * @param template
	 * @param other
	 * @param optionMap
	 * @deprecated use {@link #Diff(SDocumentGraph, SDocumentGraph, DiffOptions)
	 *             instead
	 */
	@Deprecated
	public Diff(SDocumentGraph template, SDocumentGraph other, Map<String, Boolean> optionMap) {
		DiffOptions options = new DiffOptions();
		options.putAll(optionMap);
		documentStructureDiff = new DocumentStructureDiff(template, other, options);
	}

	/**
	 * Initializes Diff object with the two graphs <code>template</code> and
	 * <code>other</code>.
	 * 
	 * @param template
	 * @param other
	 */
	public Diff(SCorpusGraph template, SCorpusGraph other) {
		this(template, other, null);
	}

	public Diff(SCorpusGraph template, SCorpusGraph other, DiffOptions optionMap) {
		corpusStructureDiff = new CorpusStructureDiff(template, other, optionMap);
	}

	public Diff(SaltProject template, SaltProject other, DiffOptions optionMap) {
		saltProjectDiff = new SaltProjectDiff(template, other, optionMap);
	}

	/**
	 * 
	 * @param template
	 * @param other
	 * @param optionMap
	 * @deprecated use {@link #Diff(SCorpusGraph, SCorpusGraph, DiffOptions)}
	 *             instead
	 */
	@Deprecated
	public Diff(SCorpusGraph template, SCorpusGraph other, Map<String, Boolean> optionMap) {
		DiffOptions options = new DiffOptions();
		options.putAll(optionMap);
		corpusStructureDiff = new CorpusStructureDiff(template, other, options);
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
		if (documentStructureDiff != null) {
			return documentStructureDiff.isIsomorph();
		} else if (corpusStructureDiff != null) {
			return corpusStructureDiff.isIsomorph();
		} else {
			return saltProjectDiff.isIsomorph();
		}
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
		if (documentStructureDiff != null) {
			return documentStructureDiff.findDiffs();
		} else if (corpusStructureDiff != null) {
			return corpusStructureDiff.findDiffs();
		} else {
			return saltProjectDiff.findDiffs();
		}
	}
}
