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
package de.hu_berlin.u.saltnpepper.salt.common;

import de.hu_berlin.u.saltnpepper.salt.core.SRelation;

/**
 * This class provides SOrderRelation, to determine the order of SNodes. Means
 * creating a path through nodes on "same level", to identify, that one nodes
 * comes before another one, when it is not computable from the datasources.
 * 
 * @author florian
 */
public interface SOrderRelation extends SRelation<SStructuredNode, SStructuredNode>, SDocumentGraphObject {
} // SOrderRelation
