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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.accessors;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;

public class STimeOverlappingRelationAccessor 
{
	/**
	 * Returns true, if this relation transports the feature time_overlapping. Means,
	 * that if the target has a time, the, source also have this time.
	 * @return true, iff the feature STIME_OVERLAPPING is true
	 */
	public Boolean isSTimeOverlapping(STimeOverlappingRelation delegateeObject) 
	{
		Boolean retVal= false;
		if (delegateeObject.getSFeature(SFEATURE_NAMES.STIME_OVERLAPPING.toString())== null)
		{//create new feature
			SFeature feature= SaltCommonFactory.eINSTANCE.createSFeature();
			feature.setQName(SFEATURE_NAMES.STIME_OVERLAPPING.toString());
			feature.setValue(new Boolean(true));
			delegateeObject.addSFeature(feature);
		}
		String retValStr= delegateeObject.getSFeature(SFEATURE_NAMES.STIME_OVERLAPPING.toString()).getSValue().toString();
		if (retValStr.equalsIgnoreCase("true"))
			retVal= true;
		else retVal= false;
		
		return(retVal);
	}
}
