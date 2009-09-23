package de.hub.corpling.salt.saltCommon.sDocumentStructure.accessors;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation;
import de.hub.corpling.salt.saltCore.SFeature;

public class STimeOverlappingRelationAccessor 
{
	/**
	 * Returns truw, if this relation transports the feature time_overlapping. Means,
	 * that if the target has a text, the, source also have this text.
	 * @return true, iff the feature STIME_OVERLAPPING is true
	 */
	public Boolean isSTimeOverlapping(STimeOverlappingRelation delegateeObject) 
	{
		Boolean retVal= false;
		if (delegateeObject.getSFeature(SFEATURE_NAMES.STEXT_OVERLAPPING.toString())== null)
		{//create new feature
			SFeature feature= SaltCommonFactory.eINSTANCE.createSFeature();
			feature.setFullName(SFEATURE_NAMES.STIME_OVERLAPPING.toString());
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
