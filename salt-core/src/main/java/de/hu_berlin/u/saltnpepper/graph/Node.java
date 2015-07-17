package de.hu_berlin.u.saltnpepper.graph;

/**
 * In graph theory a node is a placeholder, which can be related with other
 * nodes via an relation.
 * 
 * The here defined node, is a labeled node, which means, it can contain a set
 * of {@link Label}s. Am node always belong to 0..1 {@link Graph}s and can also
 * be contained in one or more {@link Layer}s.
 * 
 * @author florian
 *
 */
public interface Node extends IdentifiableElement {
	/**
	 * Returns the container graph of this node.
	 * 
	 * @return graph object which contains this node.
	 */
	public Graph getGraph();

	/**
	 * Sets the container graph of this node. The passed graph and this node
	 * will be double chained, which means the method {@link Graph#getNodes()}
	 * will return a list containing this node.
	 * 
	 * @param graph
	 *            graph which contains this node
	 */
	public void setGraph(Graph graph);
}
