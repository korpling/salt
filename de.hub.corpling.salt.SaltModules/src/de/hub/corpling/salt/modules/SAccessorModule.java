package de.hub.corpling.salt.modules;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;
import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SNode;

public class SAccessorModule 
{
// === fixing a document to work with 	
	private SDocument sDocument= null;
	
	public void setSDocument(SDocument sDocument) {
		this.sDocument = sDocument;
	}

	public SDocument getSDocument() {
		return sDocument;
	}
// === fixing a document to work with
	
	public String getOverlappedText(SElementId sElementId)
	{
		if (this.sDocument == null)
			throw new SaltModuleException("Cannot return overlapped text, because no SDocument-object is settet. Please set SDocument-object first or call 'getOverlappedText(SDocument, SElementId)'.");
		return(this.getOverlappedText(this.getSDocument(), sElementId));
	}
	
	public String getOverlappedText(SDocument sDocument, SNode sNode)
	{
		String overlappedText= null;
		if (sDocument == null)
			throw new SaltModuleException("Cannot return overlapped text, because the given SDocument-object is null.");
		
		//TODO if graph is behind saltCore, traverse by graph
		if (sNode instanceof SToken)
		{
			STextualRelation textRel= null;
			for (STextualRelation rel: sDocument.getSDocumentGraph().getSTextualRelations())
			{
				if (rel.getSToken().equals(sNode))
				{
					textRel= rel;
					break;
				}	
			}	
			Integer sStart= textRel.getSStart();
			Integer sEnd= textRel.getSEnd();
			if ((sStart== null) || (sEnd== null))
				throw new SaltModuleException("Cannot return overlaped text, because left or right value of given textual data source aren´t set.");
			overlappedText= textRel.getSTextualDS().getSText().substring(sStart, sEnd);
		}	
		return(overlappedText);
	}
	
	public String getOverlappedText(SDocument sDocument, SElementId sElementId)
	{
		if (sElementId == null)
			throw new SaltModuleException("Cannot return overlapped text, because the given SElementId-object is null.");
		if (!(sElementId.getSIdentifiableElement() instanceof SNode))
			throw new SaltModuleException("Cannot return overlapped text, because the given SElementId-object does not belong to a SNode-object.");
		return(this.getOverlappedText(sDocument, (SNode)sElementId.getSIdentifiableElement()));
	}

	
}
