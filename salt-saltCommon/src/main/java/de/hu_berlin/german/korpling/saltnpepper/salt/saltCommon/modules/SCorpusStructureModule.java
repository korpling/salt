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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;

/**
 * @deprecated since Salt 1.1.3
 * @author Florian Zipser
 *
 */
@Deprecated
public abstract class SCorpusStructureModule 
{
	/**
	 * The document structure graph, which shall be traversed.
	 * @deprecated since Salt 1.1.3
	 */
	@Deprecated
	private SCorpusGraph sCorpusGraph= null;

	/**
	 * Sets the current graph to work on.
	 * @param graph graph to traverse
	 * @deprecated since Salt 1.1.3
	 */
	@Deprecated
	public void setSCorpusGraph(SCorpusGraph sCorpusGraph) {
		this.sCorpusGraph = sCorpusGraph;
	}

	/**
	 * Returns the current graph to work on.
	 * @return the current graph
	 * @deprecated since Salt 1.1.3
	 */
	@Deprecated
	public SCorpusGraph getSCorpusGraph() {
		return sCorpusGraph ;
	}
}
