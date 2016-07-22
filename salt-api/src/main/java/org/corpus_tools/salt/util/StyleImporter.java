package org.corpus_tools.salt.util;

import org.corpus_tools.salt.core.SNode;

public interface StyleImporter {
	
	/**
	 * Returns the hexadecimal RGB representation beginning with a hash-sign for the specified node.
	 * 
	 * @param node specified SNode
	 * @return the color in the format "#rrggbb"
	 */
	
	public String getHighlightingColor (SNode node);

}
