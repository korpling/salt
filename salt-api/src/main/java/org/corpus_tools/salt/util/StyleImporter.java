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
package org.corpus_tools.salt.util;

import org.corpus_tools.salt.core.SNode;

/**
 * This interface provides the possibility to highlight nodes while working with
 * {@link VisJsVisualizer}.
 * 
 * @author irina
 *
 */

public interface StyleImporter {

	/**
	 * Returns the hexadecimal RGB representation beginning with a hash-sign for
	 * the specified node.
	 * 
	 * @param node
	 *            specified SNode
	 * @return the color in the format "#rrggbb"
	 */

	public String setHighlightingColor(SNode node);

}
