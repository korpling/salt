package org.corpus_tools.salt.util;

import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;


/**
 * This interface can be used if an excluding of certain nodes and/or relations while working with {@link VisJsVisualizer} 
 * is necessary.
 * If the method {@link #excludeNode(SNode)} returns true, then the passed node will not be inserted to the node set 
 * and therefore it will be excluded from the visualization. 
 * The method {@link #excludeRelation(SRelation)} has a similar meaning. If it returns true, then the passed relation 
 * will also be excluded from the visualization.
 * 
 *  @author irina
 *
 */

public interface ExportFilter {
/**
 * Returns a boolean to indicate, whether the specified node must be included.
 * 
 * @param node specified SNode
 */
public boolean includeNode (SNode node);

/**
 * Returns a boolean to indicate, whether the specified relation must be included.
 * 
 * @param relation specified SRelation
 */	
public boolean includeRelation (SRelation relation);
		

}
