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

import org.corpus_tools.salt.graph.Graph;

/**
 * This interface just converts the return type or the parameter for getting the
 * graph of a node or relation from {@link Graph} to {@link SDocumentGraph}.
 * 
 * @author florian
 *
 */
public interface SDocumentGraphObject {
	/**
	 * Returns the document structure object which contains this element.
	 * 
	 * @return document structure
	 */
	public SDocumentGraph getGraph();
}
