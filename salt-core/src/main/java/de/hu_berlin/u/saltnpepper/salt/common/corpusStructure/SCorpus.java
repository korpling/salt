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
package de.hu_berlin.u.saltnpepper.salt.common.corpusStructure;

import de.hu_berlin.u.saltnpepper.salt.core.SNode;

/**
 * In Salt a corpus is represented by this class. An object of this class can be a super corpus, a sun corpus or none of them as well. 
 * The class {@link SCorpus} is a derivation of of class {@link SNode} and can be added to an object of type {@link SCorpusGraph}. To
 * know how to create a hierarchical relation between several {@link SCorpus} objects please read the documentation in {@link SCorpusGraph}}.
 * @author florian 
 */
public interface SCorpus extends SNode {
//	/**
//	 * Returns the corpus structure container, which is represented by {@link SCorpusGraph} object. 
//	 * @return corpus structure
//	 */
//	public SCorpusGraph getSCorpusGraph();
//	/**
//	 * Sets the corpus structure container, which is represented by {@link SCorpusGraph} object. 
//	 * @return corpus structure
//	 */
//	public void setSCorpusGraph(SCorpusGraph value);
	
} // SCorpus
