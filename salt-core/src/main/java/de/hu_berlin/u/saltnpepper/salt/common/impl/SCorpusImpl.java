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
package de.hu_berlin.u.saltnpepper.salt.common.impl;

import de.hu_berlin.u.saltnpepper.salt.common.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SNodeImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInvalidModelException;

@SuppressWarnings("serial")
public class SCorpusImpl extends SNodeImpl implements SCorpus {
	/** {@inheritDoc} **/
	@Override
	public SCorpusGraph getGraph() {
		SGraph superGraph = super.getGraph();
		
		if(superGraph == null) {
			return null;
		}
		
		if(superGraph instanceof SCorpusGraph) {
			return (SCorpusGraph) superGraph;
		}
		
		throw new SaltInvalidModelException("Graph implementation is not of type SCorpusGraph (actual type is " 
				+ superGraph.getClass().getName() + ")");
	}
}
