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
 * This type represents a hierarchical relation between two corpora (two objects
 * of type {@link SCorpus}). The source of this relation determines the super
 * corpus and the target determines the sub corpus in the hierarchical relation.
 */
public interface SCorpusRelation extends SRelation<SCorpus, SCorpus> {
}