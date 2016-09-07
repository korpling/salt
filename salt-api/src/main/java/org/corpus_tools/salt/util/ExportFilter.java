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
import org.corpus_tools.salt.core.SRelation;


/**
 * This interface can be used if one want explicitly include or exclude nodes and/or relations while working with {@link VisJsVisualizer}.
 * If the method {@link #excludeNode(SNode)} returns true, then the passed node will be part of the visualization. Otherwise it will be omitted. 
 * The method {@link #excludeRelation(SRelation)} has a similar meaning. If it returns true, then the passed relation 
 * will also be included in the visualization.
 * 
 *  @author irina
 *
 */

public interface ExportFilter {
/**
 * Returns a boolean to indicate, whether the specified node must be included or not.
 * 
 * @param node specified SNode
 */
public boolean includeNode (SNode node);

/**
 * Returns a boolean to indicate, whether the specified relation must be included or not.
 * 
 * @param relation specified SRelation
 */	
public boolean includeRelation (SRelation relation);
		

}
