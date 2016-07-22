package org.corpus_tools.salt.util;

import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;


/**
 * This interface can be used if one want explicitly include or exclude nodes and/or relations while working with {@link VisJsVisualizer}.
 * If the method {@link #excludeNode(SNode)} returns true, then the passed node will be part of the visualization. Otherwise it will be omitted. 
 * The method {@link #excludeRelation(SRelation)} has a similar meaning. If it returns true, then the passed relation 
 * will also be included in the visualization.
 * 
 *  @author irina
 *
 */

public interface ExportFilter {
/**
 * Returns a boolean to indicate, whether the specified node must be included or not.
 * 
 * @param node specified SNode
 */
public boolean includeNode (SNode node);

/**
 * Returns a boolean to indicate, whether the specified relation must be included or not.
 * 
 * @param relation specified SRelation
 */	
public boolean includeRelation (SRelation relation);
		

}
