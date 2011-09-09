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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;

public class DOTResource extends ResourceImpl
{	

	/**
	 * Stores a SCorpusGraph model into DOT file
	 */
	private void saveSCorpusGraph(SCorpusGraph sCorpusGraph, URI uri) {
		SCorpusGraphDOTWriter writer = new SCorpusGraphDOTWriter();
		writer.setSCorpusGraph(sCorpusGraph);		
		writer.setOutputURI(uri);
		writer.save();
	}
	
	/**
	 * Stores a SDocumentGraph model into DOT file
	 */
	private void saveSDocumentGraph(SDocumentGraph sDocumentGraph, URI uri) {
		SDocumentGraphDOTWriter writer= new SDocumentGraphDOTWriter();
		writer.setSDocumentGraph(sDocumentGraph);
		writer.setOutputURI(uri);
		writer.save();
	}
	
	/**
	 * Stores a SaltProject model into DOT file
	 */
	public void save(java.util.Map<?,?> options) throws java.io.IOException
	{
		if (this.getContents().size()>1) {
			throw new SaltModuleException("Cannot write more than one content per file.");
		}
		else if (this.getContents().isEmpty()) {
			throw new SaltModuleException("No contents to write to file found");
		}
	
		EObject content = this.getContents().get(0);
		
		if ((content instanceof SCorpusGraph)||(content instanceof SDocumentGraph)) {
			File path= new File(this.getURI().toString());
			if (!path.exists()) {
				path.mkdirs();
			}
			if (content instanceof SCorpusGraph) {
				saveSCorpusGraph( (SCorpusGraph)content, this.getURI() );
			}
			else if (content instanceof SDocumentGraph)	{
				saveSDocumentGraph( (SDocumentGraph)content, this.getURI() );
			}
		}
	}
}
