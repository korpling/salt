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
 * An object of class {@link SFeature} is a label and can be added like every
 * other label to a node, relation, graph, layer or to another label. Like every
 * label a {@link SFeature} object consists of the main fields
 * {@link Label#getNamespace()}, {@link Label#getName()} and
 * {@link Label#getValue()}.
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
 */
public interface SFeature extends SAbstractAnnotation {
} // SFeature
