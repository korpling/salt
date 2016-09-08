/**
 * Copyright 2016 Humboldt-Universität zu Berlin.
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

import java.util.Iterator;

import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;

public class Validator {
	public static class Builder<T extends Object> {
		private final T saltObject;

		public Builder(T saltObject) {
			this.saltObject = saltObject;
		}

		public ValidationResult andFindInvalidities() {
			Validator validator = new Validator(false);
			validate(validator);
			return validator.getResult();
		}

		/**
		 * When an invalidity was found, it will be repaired. Note, that this
		 * can also mean to remove the invalid object.
		 * 
		 * @return
		 */
		public ValidationResult andRepairInvalidities() {
			Validator validator = new Validator(true);
			validate(validator);
			return validator.getResult();
		}

		private void validate(Validator validator) {
			if (saltObject == null) {
				return;
			} else if (saltObject instanceof SCorpusGraph) {
				validator.validate((SCorpusGraph) saltObject);
			} else if (saltObject instanceof SCorpus) {
				validator.validate((SCorpus) saltObject);
			} else if (saltObject instanceof SDocument) {
				validator.validate((SDocument) saltObject);
			} else if (saltObject instanceof SDocumentGraph) {
				validator.validate((SDocumentGraph) saltObject);
			}
		}
	}

	public ValidationResult getResult() {
		return result;
	}

	/** Determines whether invalidities should be repaired. **/
	private boolean withRepairing = false;
	private final ValidationResult result = new ValidationResult();

	private Validator(boolean withRepairing) {
		this.withRepairing = withRepairing;
	}

	private void validate(final SCorpusGraph corpusGraph) {
		if (corpusGraph == null) {
			return;
		}
		for (SCorpus corpus : corpusGraph.getCorpora()) {
			validate(corpus);
		}
		for (SDocument document : corpusGraph.getDocuments()) {
			validate(document);
		}
	}

	private void validate(SCorpus corpus) {
		if (corpus == null) {
			return;
		}

		boolean containsDocuments = false;
		boolean containsCorpora = false;
		for (SRelation<? extends SNode, ? extends SNode> relation : corpus.getGraph().getOutRelations(corpus.getId())) {
			if (relation.getTarget() instanceof SDocument) {
				if (containsCorpora) {
					result.add(new Invalidity(relation, "Salt model not valid, the corpus '"
							+ relation.getSource().getId() + "' contains corpora and documents as well."));
					break;
				}
				containsDocuments = true;
			} else if (relation.getTarget() instanceof SCorpus) {
				if (containsDocuments) {
					result.add(new Invalidity(relation, "Salt model not valid, the corpus '"
							+ relation.getSource().getId() + "' contains corpora and documents as well."));
					break;
				}
				containsCorpora = true;
			}
		}
	}

	/**
	 * @param relation
	 * @return true, when relation is invalid and could not be repaired. The
	 *         solution is removing.
	 */
	private boolean validate(SRelation<? extends SNode, ? extends SNode> relation) {
		boolean toRemove = false;
		if (relation.getSource() == null) {
			result.add(new Invalidity(relation, "The relation '" + relation.getId() + "' has no source node. "));
			toRemove = true;
		}
		if (relation.getTarget() == null) {
			result.add(new Invalidity(relation, "The relation '" + relation.getId() + "' has no target node. "));
			toRemove = true;
		}
		if ((relation.getSource() != null) && (relation.getTarget() != null)
				&& (relation.getSource().equals(relation.getTarget()))) {
			result.add(new Invalidity(relation, "The source and target of relation '" + relation.getId()
					+ "' points to the same node '" + relation.getSource().getId() + "'. "));
			toRemove = true;
		}
		return toRemove;
	}

	/**
	 * @param relation
	 * @return true, when relation is invalid and could not be repaired. The
	 *         solution is removing.
	 */
	private boolean validate(STextualRelation relation) {
		boolean toRemove = validate((SRelation) relation);
		if (relation.getStart() == null) {
			result.add(new Invalidity(relation, "The " + STextualRelation.class.getSimpleName() + " '"
					+ relation.getId() + "' has no start value."));
			toRemove = true;
		}
		if (relation.getEnd() == null) {
			result.add(new Invalidity(relation,
					"The " + STextualRelation.class.getSimpleName() + " '" + relation.getId() + "' has no end value."));
			toRemove = true;
		}

		if (relation.getStart() != null && relation.getEnd() != null && relation.getEnd() < relation.getStart()) {
			result.add(new Invalidity(relation,
					"The start value '" + relation.getStart() + "' of " + STextualRelation.class.getSimpleName() + " '"
							+ relation.getId() + "' is bigger than its end value '" + relation.getEnd() + "'. "));
		}

		if (relation.getStart() != null) {
			if (relation.getTarget() != null && relation.getTarget().getText() != null
					&& relation.getStart() > relation.getTarget().getText().length()) {
				// start value is bigger than size of text or is less
				// than o
				result.add(new Invalidity(relation,
						"The start value '" + relation.getStart() + "' of " + STextualRelation.class.getSimpleName()
								+ " '" + relation.getId() + "' is than the target text' size. It's length is '"
								+ relation.getTarget().getText().length() + "'."));
				if (withRepairing) {
					relation.setStart(relation.getTarget().getText().length());
				}
			}
			if (relation.getStart() < 0) {
				result.add(new Invalidity(relation, "The start value '" + relation.getStart() + "' of "
						+ STextualRelation.class.getSimpleName() + " '" + relation.getId() + "' is samller then 0. "));
				if (withRepairing) {
					relation.setStart(0);
				}
			}
		}
		if (relation.getEnd() != null) {
			if (relation.getTarget() != null && relation.getTarget().getText() != null
					&& (relation.getEnd() > relation.getTarget().getText().length())) {
				// end value is bigger than size of text or is less
				// than o
				result.add(new Invalidity(relation,
						"The end value '" + relation.getEnd() + "' of " + STextualRelation.class.getSimpleName() + " '"
								+ relation.getId() + "' is not higher than the target text' size. It's length is '"
								+ relation.getTarget().getText().length() + "'."));
				if (withRepairing) {
					relation.setEnd(relation.getTarget().getText().length());
				}
			}
			if (relation.getEnd() < 0) {
				result.add(new Invalidity(relation, "The end value '" + relation.getStart() + "' of "
						+ STextualRelation.class.getSimpleName() + " '" + relation.getId() + "' is samller then 0. "));
				if (withRepairing) {
					relation.setEnd(0);
				}
			}
		}
		return toRemove;
	}

	private void validate(STextualDS text) {
		if (text != null) {
			if (text.getText() == null) {
				result.add(
						new Invalidity(text, "The primary text node '" + text.getId() + "' does not contain a text. "));
				if (withRepairing) {
					text.setText("");
				}
			}
		}
	}

	private boolean validate(SDocument document) {
		if (document == null) {
			return false;
		}
		boolean isValid = true;
		if (document.getDocumentGraph() != null) {
			validate(document.getDocumentGraph());
		}
		return isValid;
	}

	private void validate(SDocumentGraph documentGraph) {
		if (documentGraph == null) {
			return;
		}
		for (STextualDS texts : documentGraph.getTextualDSs()) {
			validate(texts);
		}

		final Iterator<SRelation<SNode, SNode>> iterator = documentGraph.getRelations().iterator();
		while (iterator.hasNext()) {
			final SRelation<? extends SNode, ? extends SNode> rel = iterator.next();
			boolean toRemove = false;
			toRemove = validate(rel);
			if (rel instanceof STextualRelation) {
				validate((STextualRelation) rel);
			}
			if (withRepairing && toRemove) {
				documentGraph.removeRelation(rel);
			}
		}
	}
}
