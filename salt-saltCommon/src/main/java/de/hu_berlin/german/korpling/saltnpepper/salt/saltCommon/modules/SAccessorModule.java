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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;

/**
 * 
 * @author Florian Zipser
 * @deprecated since Salt 1.1.3
 */
@Deprecated
public class SAccessorModule 
{
//TODO check if the following is used anywhere, because it is not the correct position for this, it has to be put in SDocumentStructureAccessor in de.hub.corpling.salt.SaltCommonModules
// === fixing a document to work with 	
	private SDocument sDocument= null;
	
	public void setSDocument(SDocument sDocument) {
		this.sDocument = sDocument;
	}

	public SDocument getSDocument() {
		return sDocument;
	}
// === fixing a document to work with
	/**
	 * @deprecated since Salt 1.1.3
	 */
	@Deprecated
	public String getOverlappedText(SElementId sElementId)
	{
		if (this.sDocument == null)
			throw new SaltModuleException("Cannot return overlapped text, because no SDocument-object is settet. Please set SDocument-object first or call 'getOverlappedText(SDocument, SElementId)'.");
		return(this.getOverlappedText(this.getSDocument(), sElementId));
	}
	/**
	 * 
	 * @param sDocument
	 * @param sNode
	 * @return
	 * @deprecated since Salt 1.1.3
	 */
	@Deprecated
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
				throw new SaltModuleException("Cannot return overlaped text, because left or right value of given textual data source aren�t set.");
			overlappedText= textRel.getSTextualDS().getSText().substring(sStart, sEnd);
		}	
		return(overlappedText);
	}
	
	/**
	 * 
	 * @param sDocument
	 * @param sElementId
	 * @return
	 * @deprecated since Salt 1.1.3
	 */
	@Deprecated
	public String getOverlappedText(SDocument sDocument, SElementId sElementId)
	{
		if (sElementId == null)
			throw new SaltModuleException("Cannot return overlapped text, because the given SElementId-object is null.");
		if (!(sElementId.getSIdentifiableElement() instanceof SNode))
			throw new SaltModuleException("Cannot return overlapped text, because the given SElementId-object does not belong to a SNode-object.");
		return(this.getOverlappedText(sDocument, (SNode)sElementId.getSIdentifiableElement()));
	}
//TODO check if the above is used anywhere, because it is not the correct position for this, it has to be put in SDocumentStructureAccessor in de.hub.corpling.salt.SaltCommonModules

}
