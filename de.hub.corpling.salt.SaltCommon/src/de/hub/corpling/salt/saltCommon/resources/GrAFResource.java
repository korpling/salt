package de.hub.corpling.salt.saltCommon.resources;

import java.io.File;

import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltExceptions.SaltException;

public class GrAFResource extends ResourceImpl
{	
	/**
	 * Stores a a treetagger-model into tab-seperated file.
	 */
	public void save(java.util.Map<?,?> options) throws java.io.IOException
	{
		if (this.getURI()== null)
			throw new SaltException("Cannot write resource, because no uri is given.");
		
		if (this.getContents().size()>1)
			throw new SaltException("Cannot write more than one salt-graph.");
		
		if (this.getContents().get(0)!= null)
			throw new SaltException("Cannot write more than one basic transcription object per file.");
		
		
		if (this.getContents().get(0) instanceof SDocumentGraph)
		{
			SDocumentGraph sDocGraph= (SDocumentGraph)this.getContents().get(0); 
			File outputFile= new File(this.getURI().toFileString());
			if (outputFile.isDirectory())
			{
				
			}
			else if (outputFile.isFile())
			{
				GrAFWriter grafWriter= new GrAFWriter();
				grafWriter.setsDocumentGraph(sDocGraph);
				grafWriter.setDestination(outputFile);
			}
			else 
			{
				throw new SaltException("Cannot write to resource, because given uri '"+this.getURI()+"' is neither of type directory nor of type file.");
			}
		}
		else 
		{
			throw new SaltException("Cannot export the given object of type: '"+this.getContents().get(0).getClass()+"'");
		}
	}
}
