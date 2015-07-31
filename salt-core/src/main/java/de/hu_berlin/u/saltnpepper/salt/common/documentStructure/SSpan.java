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
package de.hu_berlin.u.saltnpepper.salt.common.documentStructure;

/**
 * A span is used to group a couple of tokens together to give them exactly the
 * same annotation or to connect them as a bunch with a 3rd node at once. A span
 * therefore has the semantic of an ordered set. In a graph-based world, we need
 * to model such an ordered set as nodes and edges. Therefore Salt provides the
 * node type SSpan and the relation type SSpanningRelation. A SSpan object
 * represents the span itself and for instance could be annotated or linked with
 * other nodes. To mark a token as being part of the set, a
 * {@link SSpanningRelation} object connects each token with the span. A
 * {@link SSpanningRelation} always has a span as source and a token as target.
 * 
 * @author florian
 */
public interface SSpan extends SStructuredNode, Bla {
} // SSpan
