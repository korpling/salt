package org.corpus_tools.salt.util.traversal;

/**
 * Determines the strategy used by the traverser.
 */
public enum TraversalStrategy {
	/**
	 * When traversal was started at n1, then traverses the following graph in
	 * specified order: n1, n2, n3, n4, n5, n6, n7
	 * 
	 * <pre>
	 *              n1             
	 *          /   |  \  
	 *        n2    n5  n7
	 *       / \    |         
	 *    n3    n4  n6
	 * </pre>
	 **/
	TOP_DOWN_DEPTH_FIRST,
	/**
	 * When traversal was started at n1, then traverses the following graph in
	 * specified order: n1, n2, n5, n7, n3, n4, n6
	 * 
	 * <pre>
	 *              n1             
	 *          /   |  \  
	 *        n2    n5  n7
	 *       / \    |         
	 *    n3    n4  n6
	 * </pre>
	 **/
	TOP_DOWN_BREADTH_FIRST,
	/**
	 * When traversal was started at n3, n4, n6, then traverses the following
	 * graph in specified order: n3, n2, n1, n4, n2, n1, n6, n5, n1, n7, n1
	 * 
	 * <pre>
	 *              n1             
	 *          /   |  \  
	 *        n2    n5  n7
	 *       / \    |         
	 *    n3    n4  n6
	 * </pre>
	 **/
	BOTTOM_UP_DEPTH_FIRST,
	/**
	 * When traversal was started at n1, then traverses the following graph in
	 * specified order: n3, n4, n6, n7, n2, n2, n5, n1, n1, n1, n1
	 * 
	 * <pre>
	 *              n1             
	 *          /   |  \  
	 *        n2    n5  n7
	 *       / \    |         
	 *    n3    n4  n6
	 * </pre>
	 **/
	BOTTOM_UP_BREADTH_FIRST
}
