package de.hub.corpling.salt.saltCommon.modules;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;

public class SDocumentStructureModule 
{
	/**
	 * The document structure graph, which shall be traversed.
	 */
	private SDocumentGraph sDGraph= null;

	/**
	 * Sets the current graph to work on.
	 * @param graph graph to traverse
	 */
	public void setSDocumentGraph(SDocumentGraph sDGraph) {
		this.sDGraph = sDGraph;
	}

	/**
	 * Returns the current graph to work on.
	 * @return the current graph
	 */
	public SDocumentGraph getSDocumentGraph() {
		return sDGraph ;
	}
}
