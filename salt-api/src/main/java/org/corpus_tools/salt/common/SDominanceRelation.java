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
 * The meaning of the type {@link SDominanceRelation} is a part-of relation. In
 * contrast to the {@link SSpan} and the {@link SSpanningRelation}, a
 * {@link SStructure} is not just a placeholder for a bunch of {@link SToken}
 * objects, it is a proper element itself. The same goes for
 * {@link SDominanceRelation} objects. For instance, in many cases it makes a
 * linguistic difference whether tokens t1 , t2 and t3 are directly dominated by
 * a structure s1 or whether t1 and t2 are dominated by a structure s2 which is,
 * together with t3 , dominated by structure s2.
 * 
 * @author florian
 */
public interface SDominanceRelation extends STextOverlappingRelation<SStructure, SStructuredNode>, STimeOverlappingRelation<SStructure, SStructuredNode>, SDocumentGraphObject {
} // SDominanceRelation
