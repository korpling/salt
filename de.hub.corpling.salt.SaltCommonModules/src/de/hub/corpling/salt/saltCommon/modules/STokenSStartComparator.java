package de.hub.corpling.salt.saltCommon.modules;

import java.util.Comparator;

import de.hub.corpling.graph.Edge;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;
import de.hub.corpling.salt.saltExceptions.SaltModuleException;

public class STokenSStartComparator implements Comparator<SToken> {

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
	
	/**
	 * Returns -1 if o1 has less text position than o2, 0 if both have equal positions and
	 * 1 if o1 has higher text position than o2. 
	 */
	@Override
	public int compare(SToken o1, SToken o2) 
	{
		int retVal= 0;
		if (o1== null)
			new SaltModuleException("Cannot compare the given SToken-objects, bacause first one is null.");
		if (o2== null)
			new SaltModuleException("Cannot compare the given SToken-objects, bacause second one is null.");
		
		STextualRelation sTextRelO1= null;
		for (Edge edge : this.getsDocumentGraph().getOutEdges(o1.getId()))
		{
			if (edge instanceof STextualRelation)
			{
				sTextRelO1= (STextualRelation) edge;
				break;
			}
		}
		
		STextualRelation sTextRelO2= null;
		for (Edge edge : this.getsDocumentGraph().getOutEdges(o2.getId()))
		{
			if (edge instanceof STextualRelation)
			{
				sTextRelO2= (STextualRelation) edge;
				break;
			}
		}
		
		//both tokens are equal
		if (sTextRelO1.getSStart().equals(sTextRelO2.getSStart()))
			retVal= 0;
		else if (sTextRelO1.getSStart() < sTextRelO2.getSStart())
			retVal= -1;
		else if (sTextRelO1.getSStart() > sTextRelO2.getSStart())
			retVal= 1;
			
		return(retVal);
	}
}
