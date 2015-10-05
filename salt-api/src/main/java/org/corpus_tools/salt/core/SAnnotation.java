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
package org.corpus_tools.salt.core;

import org.corpus_tools.salt.graph.Label;

/**
 * <p>
 * An annotation in Salt is an attribute-value-pair and can belong to either a
 * node, an edge, a graph, a layer or another label. An attribute-value-pair is
 * a triple which consists of a namespace, a name and a value
 * (namespace:name=value). The combination of name and namespace is used to
 * identify a label and therefore must be unique. The namespace is an optional
 * value, to distinguish in case of there are two annotations having the same
 * name. For instance a node etc. can have a label stts:pos=VVFIN as well as the
 * label pos:VV to annotate it with two part-of-speech annotations from
 * different tagsets.
 * </p>
 * </p> SFeature objects are used to store structural information of Salt, which
 * are necessary to map a linguistic model to a graph. For instance
 * {@link SFeature} added to the relation between a token and a primary text
 * contain the start and end position of the token in the primary text. In the
 * very most cases a user of the Salt api will never need to use a
 * {@link SFeature} object.</p> For further information on labels,
 * 
 * @see Label
 * 
 * @author florian
 *
 */
public interface SAnnotation extends SAbstractAnnotation {
} // SAnnotation
