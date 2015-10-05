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

import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules.SDocumentStructureModule;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;

/**
 * 
 * @author Florian Zipser
 * @deprecated since Salt 1.1.3
 *
 */
@Deprecated
public class SDocumentDataEnricher extends SDocumentStructureModule 
{
	
	/**
	 * This method creates a timeline with respect to order of token in STextual-object in documentGraph.
	 * This means, that every token will get its own timerange, accordingly to its place in TextualDS-object.
	 * If there are more than one STextualDS-objects, the points of time will be concatenated in order of 
	 * STextualDS in graph.
	 *   
	 * Note: STimeline-object is created only iff there is none already.
	 * @deprecated since Salt 1.1.3 use {@link SDocumentGraph#createSTimeline()} instead
	 */
	@Deprecated
	public void createSTimeline()
	{
		if (this.getSDocumentGraph().getSTimeline()== null)
		{
			STimeline sTimeline= SDocumentStructureFactory.eINSTANCE.createSTimeline();
			this.getSDocumentGraph().addSNode(sTimeline);
			EList<STimelineRelation> sTimeRelList= new BasicEList<STimelineRelation>();
			Map<STextualDS, EList<STimelineRelation>> sTimeRelTable= new Hashtable<STextualDS, EList<STimelineRelation>>();
			for (STextualRelation sTextRel: this.getSDocumentGraph().getSTextualRelations())
			{
				STimelineRelation sTimeRel= SDocumentStructureFactory.eINSTANCE.createSTimelineRelation();
				sTimeRel.setSTimeline(sTimeline);
				sTimeRel.setSToken(sTextRel.getSToken());
				
				{//put STimelineRelation into sTimeRelTable
					if (sTimeRelTable.get(sTextRel.getSTextualDS())== null)
						sTimeRelTable.put(sTextRel.getSTextualDS(), new BasicEList<STimelineRelation>());
					//TODO not only adding the timeRel, sorting for left and right textual position
					sTimeRelTable.get(sTextRel.getSTextualDS()).add(sTimeRel);
				}
			}
			for (STextualDS sTextualDS: this.getSDocumentGraph().getSTextualDSs())
			{
				sTimeRelList.addAll(sTimeRelTable.get(sTextualDS));
			}
			Integer pot= 0;
			sTimeline.addSPointOfTime(pot.toString());
			for (STimelineRelation sTimeRelation: sTimeRelList)
			{
				sTimeRelation.setSStart(pot);
				pot++;
				sTimeline.addSPointOfTime(pot.toString());
				sTimeRelation.setSEnd(pot);
				this.getSDocumentGraph().addSRelation(sTimeRelation);
			}
		}
	}
}
