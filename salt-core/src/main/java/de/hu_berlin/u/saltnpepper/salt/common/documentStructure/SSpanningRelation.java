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

import de.hu_berlin.u.saltnpepper.salt.core.SRelation;

/**
 * <p>
 * A span is used to group a couple of tokens together to give them exactly the
 * same annotation or to connect them as a bunch with a 3rd node at once. A span
 * therefore has the semantic of an ordered set. In a graph-based world, we need
 * to model such an ordered set as nodes and edges. Therefore Salt provides the
 * node type {@link SSpan} and the relation type {@link SSpanningRelation}. A
 * {@link SSpan} object represents the span itself and for instance could be
 * annotated or linked with other nodes. To mark a token as being part of the
 * set, a {@link SSpanningRelation} object connects each token with the span. A
 * {@link SSpanningRelation} always has a span as source and a token as target.
 * </p>
 * <p>
 * Imagine a piece of a primary text like 'New York' and two tokens t1
 * (representing 'New') and t2 (representing 'York'). For annotating them as an
 * entity, you can create a span s1 and connect t1 with s1 via one
 * {@link SSpanningRelation} r1 and t2 with s1 via a second SSpanningRelation
 * r2. Since a {@link SSpan} is just a node, it can be further annotated for
 * instance with an annotation 'entity= city'.
 * </p>
 * <p>
 * Spans can even be very helpful to annotate bigger parts of the primary text,
 * for instance to annotate several tokens as phrases, sentences or foreign
 * language parts etc. . Also a {@link SSpanningRelation} can carry further
 * annotations, but this is rather unusual since such an edge has no own
 * linguistic semantics and is just a technical mechanism to model ordered sets
 * in a graph.
 * </p>
 */
public interface SSpanningRelation extends SRelation<SSpan, SToken>, STextOverlappingRelation<SSpan, SToken>, STimeOverlappingRelation<SSpan, SToken> {
} // SSpanningRelation
