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
package org.corpus_tools.salt.util;

import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SaltProject;

/**
 * Defines types of differences between two {@link SDocumentGraph} objects.
 */
public enum DIFF_TYPES {
	/**
	 * one of the objects to be compared (e.g. {@link SaltProject},
	 * {@link SCorpusGraph} or {@link SDocumentGraph}) is null
	 **/
	NULL_OBJECT,
	/** one of the compared Salt projects is missing. **/
	PROJECT_MISSING,
	/** the names of Salt projects are different **/
	PROJECT_NAME_DIFFERING,
	/** the number of corpus graphs in Salt projects are different **/
	PROJECT_NUMBER_CORPUS_GRAPH_DIFFERING,
	/** the corpus graphs in Salt project are different **/
	CORPUS_GRAPH_DIFFERING,
	/**
	 * one of the compared objects contains a label, which is missing for the
	 * other one
	 */
	LABEL_MISSING,
	/** the compared labels differ in their namespace */
	LABEL_NAMESPACES_DIFFERING,
	/** the compared labels differ in their name */
	LABEL_NAME_DIFFERING,
	/** the compared labels differ in their value */
	LABEL_VALUE_DIFFERING,
	/** the ids of the compared objects differ */
	ID_DIFFERING,
	/**
	 * one of the compared graphs contains a node that is missing for the other
	 * one
	 */
	NODE_MISSING,
	/** the compared nodes differ in their name */
	NODE_NAME_DIFFERING,
	/** the compared nodes differ in for instance their labels **/
	NODE_DIFFERING,
	/**
	 * one of the compared graphs contains a relation that is missing for the
	 * other one
	 */
	RELATION_MISSING,
	/** the compared relations differ in for instance their labels **/
	RELATION_DIFFERING,
	/** the compared relations differ in their type */
	RELATION_TYPE_DIFFERING,
	/** the compared relations differ in their name */
	RELATION_NAME_DIFFERING,
	/**
	 * one of the compared graphs contains a layer that is missing for the other
	 * one
	 */
	LAYER_MISSING,
	/**
	 * the compared layers differ in their name, the number of nodes or the
	 * number of relations
	 */
	LAYER_DIFFERING
}
