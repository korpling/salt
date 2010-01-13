package de.hub.corpling.salt.saltCommon.modules;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;

public abstract class SCorpusStructureModule 
{
	/**
	 * The document structure graph, which shall be traversed.
	 */
	private SCorpusGraph sCorpusGraph= null;

	/**
	 * Sets the current graph to work on.
	 * @param graph graph to traverse
	 */
	public void setSCorpusGraph(SCorpusGraph sCorpusGraph) {
		this.sCorpusGraph = sCorpusGraph;
	}

	/**
	 * Returns the current graph to work on.
	 * @return the current graph
	 */
	public SCorpusGraph getSCorpusGraph() {
		return sCorpusGraph ;
	}
}
