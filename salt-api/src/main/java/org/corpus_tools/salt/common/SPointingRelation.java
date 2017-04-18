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

import org.corpus_tools.salt.core.SRelation;

/**
 * Sometimes in linguistics you want to set nodes into a relationship without
 * adding a set semantic or a hierarchical relation. You sometimes just need an
 * interlinking mechanism. Such a relation is the type {@link SPointingRelation}
 * . A pointing relation in Salt allows to relate any kind of nodes with each
 * other. In general, this type of relation has no semantics and could be used
 * for a wide range of annotations, which does not group or structure nodes. For
 * instance, this could be very helpful for a dependency analysis or
 * coreferential chains etc. . To give an example, imagine the text:
 * <p>
 * <i> 'John was a big man ... he always had to move his head' </i>
 * </p>
 * In this text 'John' (token t1) and 'he' (token ti) refer to the same entity.
 * To express that in Salt, you can create a {@link SPointingRelation} object
 * having the source t1 and the target ti , or the other way around. Now let's
 * extend this example and imagine the text 'John Doe ... he', with the tokens
 * t1 ('John'), t2 ('Doe') and ti ('he'). In this case, we want to set 'John
 * Doe' as a whole in relation to 'he'. This is possible by creating a
 * {@link SSpan} object s 1 containing t1 and t2 and relating the token t i via
 * a {@link SPointingRelation} object to s1 . To determine a
 * {@link SPointingRelation} being a coreferential relation or a dependency, you
 * should use the type attribute which is available for every {@link SRelation}.
 * Like all the other relations, {@link SPointingRelation} can be annotated to
 * express some linguistic semantics.
 */
public interface SPointingRelation extends SRelation<SStructuredNode, SStructuredNode>, SDocumentGraphObject {
}