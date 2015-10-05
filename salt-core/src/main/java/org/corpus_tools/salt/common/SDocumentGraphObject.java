package org.corpus_tools.salt.common;

import org.corpus_tools.salt.graph.Graph;

/**
 * This interface just converts the return type or the parameter for getting the
 * graph of a node or relation from {@link Graph} to {@link SDocumentGraph}.
 * 
 * @author florian
 *
 */
public interface SDocumentGraphObject {
	/**
	 * Returns the document structure object which contains this element.
	 * 
	 * @return document structure
	 */
	public SDocumentGraph getGraph();
}
