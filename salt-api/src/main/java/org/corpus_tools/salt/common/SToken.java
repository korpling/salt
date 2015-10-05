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
package org.corpus_tools.salt.common;

import org.corpus_tools.salt.core.SNode;

/**
 * In general, it is not totally clear in linguistics what a token is. In most
 * interpretations the term is used synonymously with 'word' (in the sense of
 * graphmatics). But even here, the question what a word is, is controversial.
 * Therefore we here use a more technical definition of what a token is. In Salt
 * a token is the smallest countable unit of primary data. For instance in a
 * primary text, a token could be a set of characters, just one character or
 * even an empty character. This allows us, to use tokens free of a semantical
 * interpretation. A token now can be a word, a syllable, a sentence or any
 * other textual categorization. The Salt element representing a token is the
 * type SToken, a specialization of the type {@link SNode}. Such a
 * {@link SToken} object is a placeholder for annotations and a target for
 * interlinking. The SToken object itself does not contain any information about
 * the overlapped primary data. In case of the primary data is a text, this is
 * realized with a specific type of SRelation, the {@link STextualRelation}. A
 * {@link STextualRelation} links a primary text (as source) with a token (as
 * target)
 * 
 * @author florian
 */
public interface SToken extends SStructuredNode, SDocumentGraphObject {
} // SToken
