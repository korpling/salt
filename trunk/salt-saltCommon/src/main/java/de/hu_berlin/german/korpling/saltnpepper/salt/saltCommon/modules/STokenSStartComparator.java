/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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

import java.util.Comparator;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;

public class STokenSStartComparator implements Comparator<SToken> {

	private SDocumentGraph sDocumentGraph= null;
	
	/**
	 * @param sDocumentGraph the sDocumentGraph to set
	 */
	public void setsDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.sDocumentGraph = sDocumentGraph;
	}

	/**
	 * @return the sDocumentGraph
	 */
	public SDocumentGraph getsDocumentGraph() {
		return sDocumentGraph;
	}
	
	/**
	 * Returns -1 if o1 has less text position than o2, 0 if both have equal positions and
	 * 1 if o1 has higher text position than o2. 
	 */
	@Override
	public int compare(SToken o1, SToken o2) 
	{
		int retVal= 0;
		if (o1== null)
			new SaltModuleException("Cannot compare the given SToken-objects, bacause first one is null.");
		if (o2== null)
			new SaltModuleException("Cannot compare the given SToken-objects, bacause second one is null.");
		
		STextualRelation sTextRelO1= null;
		for (Edge edge : this.getsDocumentGraph().getOutEdges(o1.getId()))
		{
			if (edge instanceof STextualRelation)
			{
				sTextRelO1= (STextualRelation) edge;
				break;
			}
		}
		
		STextualRelation sTextRelO2= null;
		for (Edge edge : this.getsDocumentGraph().getOutEdges(o2.getId()))
		{
			if (edge instanceof STextualRelation)
			{
				sTextRelO2= (STextualRelation) edge;
				break;
			}
		}
		
		//both tokens are equal
		if (sTextRelO1.getSStart().equals(sTextRelO2.getSStart()))
			retVal= 0;
		else if (sTextRelO1.getSStart() < sTextRelO2.getSStart())
			retVal= -1;
		else if (sTextRelO1.getSStart() > sTextRelO2.getSStart())
			retVal= 1;
			
		return(retVal);
	}
}
