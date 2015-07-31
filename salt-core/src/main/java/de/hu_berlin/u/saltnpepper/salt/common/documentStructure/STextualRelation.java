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

import de.hu_berlin.u.saltnpepper.salt.core.SFeature;

/**
 * A {@link STextualRelation} links a primary text (as source) with a token (as target).
 * A {@link STextualRelation} further contains two labels (or more precisely {@link SFeature}
 * objects) representing the start and the end position determining the interval
 * of the primary text overlapped by the token.
 * @author florian
 */
public interface STextualRelation extends SSequentialRelation<SToken, STextualDS>, STextOverlappingRelation<SToken, STextualDS> {
} // STextualRelation
