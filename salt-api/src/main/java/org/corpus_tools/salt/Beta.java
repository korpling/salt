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
package org.corpus_tools.salt;

/**
 * Indicates that this part of the API might be changed in an incompatible way in
 * future releases.
 * <p>
 * Salt follows the semantic versioning scheme but for classes or functions having
 * this annotation the "no downward compatible changes" promise might not be kept.
 * Normally this function is safe to use and release ready but the interface might change
 * in the future.
 * </p>
 * <p>
 * If a class has this annotation all functions of this class are implicitly marked
 * with {@code @Beta} as well. Implementations of interfaces with a {@code @Beta}
 * annnotation will inherit the beta status as well.
 * </p>
 * @author Thomas Krause <krauseto@hu-berlin.de>
 */
public @interface Beta {
	
}
