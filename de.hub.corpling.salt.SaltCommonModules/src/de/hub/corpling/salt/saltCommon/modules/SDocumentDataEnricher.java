package de.hub.corpling.salt.saltCommon.modules;

import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation;

public class SDocumentDataEnricher extends SDocumentStructureModule 
{
	
	/**
	 * This method creates a timeline with respect to order of token in STextual-object in documentGraph.
	 * This means, that every token will get its own timerange, accordingly to its place in TextualDS-object.
	 * If there are more than one STextualDS-objects, the points of time will be concatenated in order of 
	 * STextualDS in graph.
	 *   
	 * Note: STimeline-object is created only iff there is none already.
	 */
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
