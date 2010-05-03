package de.hub.corpling.salt.saltCommon.resources;

import java.io.File;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltExceptions.SaltException;

public class GrAFWriter 
{
// ========================================== start: SDocumentGraph	
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
// ========================================== end: SDocumentGraph
	
// ========================================== start: destination
	
	private File destination= null;
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(File destination) {
		this.destination = destination;
	}

	/**
	 * @return the destination
	 */
	public File getDestination() {
		return destination;
	}
// ========================================== end: destination
	
	/**
	 * Saves the given SDocumentGraph to the given destination.
	 */
	public void save()
	{
		if (this.getsDocumentGraph()== null)
			throw new SaltException("Cannot save an empty SDocumentGraph.");
		if (this.getDestination()== null)
			throw new SaltException("Cannot save SDocumentGraph to empty destination.");
		
		
	}
}
