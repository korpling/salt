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
package org.corpus_tools.salt.common.tokenizer;

import java.util.List;

import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.exceptions.SaltTokenizerException;

/**
 * This class is a very simple implementation of a tokenizer, which just splits
 * a primary text by a given list of characters. e.g. a blank.
 */
public class SimpleTokenizer {
	/**
	 * Sets the {@link SDocumentGraph} to be used.
	 */
	private SDocumentGraph documentGraph = null;

	public void setDocumentGraph(SDocumentGraph documentGraph) {
		this.documentGraph = documentGraph;
	}

	public SDocumentGraph getDocumentGraph() {
		return documentGraph;
	}

	/**
	 * Initializes a new TTokenizer object.
	 */
	public SimpleTokenizer() {
	}

	/**
	 * Sets the {@link STextualDS} to be tokenized. Its language will be
	 * detected automatically if possible.
	 * 
	 * @param textualDSs
	 */
	public List<SToken> tokenize(STextualDS textualDSs, Character... separator) {
		return (tokenize(textualDSs, null, null, separator));
	}

	/**
	 * Sets the {@link STextualDS} to be tokenized and the language of the text.
	 * If language is null, it will be detected automatically if possible.
	 * 
	 * @param sTextualDSs
	 *            {@link STextualDS} object containing the text to be tokenized
	 * @param startPos
	 *            start position, if text to be tokenized is subset (0 assumed
	 *            if set to null)
	 * @param endPos
	 *            end position, if text to be tokenized is subset (length of
	 *            text assumed if set to null)
	 */
	public List<SToken> tokenize(STextualDS textualDS, Integer startPos, Integer endPos, Character... separator) {
		List<SToken> retVal = null;
		if (textualDS == null) {
			throw new SaltTokenizerException("Cannot tokenize an empty 'SSTextualDS' object.");
		}
		if (getDocumentGraph() == null) {
			if (textualDS.getGraph() == null) {
				throw new SaltTokenizerException(
						"Cannot add tokens to an empty SDocumentGraph object and can not estimate SDocumentGraph, because STextualDS does not belong to a SDocumentGraph object.");
			} else {
				setDocumentGraph(textualDS.getGraph());
			}
		}

		if (textualDS.getText() != null) {
			if (startPos == null) {
				startPos = 0;
			}
			if (endPos == null) {
				endPos = textualDS.getText().length();
			}

			char[] text;
			if ((startPos != 0) || (endPos != textualDS.getText().length())) {
				text = textualDS.getText().substring(startPos, endPos).toCharArray();
			} else {
				text = textualDS.getText().toCharArray();
			}
			// true if last character was a separator, false otherwise
			boolean isSep = false;
			int currStart = 0; // current start position for token
			int currEnd = 0; // current end position for token
			boolean wasHere = false;
			for (char chr : text) {
				wasHere = false;
				for (char sep : separator) {
					if (chr == sep) {
						if (currStart != currEnd) {
							// create token
							getDocumentGraph().createToken(textualDS, startPos + currStart, startPos + currEnd);
						}
						isSep = true;
					} else {
						if (wasHere) {
							break;
						}
						isSep = false;
					}
					wasHere = true;
				}
				currEnd++;
				if (isSep) {
					currStart = currEnd;
				}
			}
			if (!isSep) {
				// create a token for the last part of text, if last character
				// was not a separator
				getDocumentGraph().createToken(textualDS, startPos + currStart, startPos + currEnd);
			}
		}
		return (retVal);
	}
}
