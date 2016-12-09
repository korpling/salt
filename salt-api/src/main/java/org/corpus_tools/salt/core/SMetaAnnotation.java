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
package org.corpus_tools.salt.core;

import org.corpus_tools.salt.graph.Label;

/**
 * <p>
 * Meta annotations are very useful for instance to document the creation
 * process or the aim of a corpus, a sub corpus or a document. These information
 * are supposed to give a person working with this corpus additional
 * non-linguistic information. For instance which tools have been used, which
 * persons have annotated the corpus, when was the corpus annotated and so on.
 * Let's give an example: A meta annotation describing the creation date of the
 * origin would have the sName="date" and the sValue="1487" and an empty sNS can
 * be added to a SCorpus. Salt is an open model, which means, there are no
 * limitations on naming a meta annotation. Further, Salt does not interpret
 * them, therefore the meta annotation for determining the author can also be
 * named 'creator' or something else instead of 'author'.
 * </p>
 * <p>
 * The most convenient way to use meta annotations is to add a meta annotation
 * to a document node or a corpus node. But since a meta annotation is just a
 * label of a specific type, you are free to add it to each node or edge in the
 * Salt model (for instance to annotate a specific node being created by from a
 * specific annotator).
 * </p>
 * <p>
 * A {@link SFeature} could be used, to add some information to any Salt object
 * during a processing. So for instance you can store any state like 'already
 * processed' or other non-linguistic and non meta annotations like 'having the
 * color red' to it.
 * </p>
 * For further information on labels,
 * 
 * @see Label
 * 
 * @author florian
 *
 */
public interface SMetaAnnotation extends SAbstractAnnotation {
} // SMetaAnnotation
