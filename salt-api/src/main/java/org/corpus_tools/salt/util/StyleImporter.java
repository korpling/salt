package org.corpus_tools.salt.util;

import org.corpus_tools.salt.core.SNode;


/**
 * This interface provides the possibility to highlight nodes while working with {@link VisJsVisualizer}.
 * 
 *  @author irina
 *
 */


public interface StyleImporter {
	
	/**
	 * Returns the hexadecimal RGB representation beginning with a hash-sign for the specified node.
	 * 
	 * @param node specified SNode
	 * @return the color in the format "#rrggbb"
	 */
	
	public String getHighlightingColor (SNode node);

}
