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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules;

import java.util.Comparator;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;

/**
 * 
 * @author Florian Zipser
 */
public class STextualRelationSStartComparator extends SDocumentStructureModule implements Comparator<STextualRelation> 
{
	/**
	 * Returns -1 if o1 has less text position than o2, 0 if both have equal positions and
	 * 1 if o1 has higher text position than o2. 
	 */
	@Override
	public int compare(STextualRelation o1, STextualRelation o2) 
	{
		int retVal= 0;
		if (o1== null)
			new SaltModuleException("Cannot compare the given STextualRelation-objects, because first one is null.");
		if (o2== null)
			new SaltModuleException("Cannot compare the given STextualRelation-objects, because second one is null.");

		//both textual relations are equal
		if (o1.getSStart().equals(o2.getSStart()))
			retVal= 0;
		else if (o1.getSStart() < o2.getSStart())
			retVal= -1;
		else if (o1.getSStart() > o2.getSStart())
			retVal= 1;
		return(retVal);
	}
}
