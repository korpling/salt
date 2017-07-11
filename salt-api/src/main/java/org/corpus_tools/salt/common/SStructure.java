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
package org.corpus_tools.salt.common;

/**
 * Hierarchies are a useful mechanism to express tree-like or hierarchical
 * structures behind a text. For instance, a widely used mechanism to describe
 * phrase structures are syntax trees. The term syntax trees implies that these
 * hierarchies are trees, even in a graph sense. This means, they consist of
 * nodes and relations and are therefore easy to model in Salt. Salt offers a
 * specific type of node, the {@link SStructure}, and a specific type of
 * relation, the {@link SDominanceRelation}. The source of an
 * {@link SDominanceRelation} could be a {@link SToken}, {@link SSpan} or even a
 * {@link SStructure}. The unit of both elements enables to create unbound
 * hierarchies above a tokenization.
 * 
 * @author florian
 */
public interface SStructure extends SStructuredNode, SDocumentGraphObject {
} // SStructure
