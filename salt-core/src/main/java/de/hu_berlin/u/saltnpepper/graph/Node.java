package de.hu_berlin.u.saltnpepper.graph;

public interface Node {
	/**
	 * Returns the container graph of this node.
	 * @return graph object which contains this node.
	 */
	public Graph getGraph();
	/**
	 * Sets the container graph of this node.
	 * @param graph object which contains this node.
	 */
	/**
	 * Sets the container graph of this node.
	 * For double chaining between this {@link Node} and the passed {@link Graph} object,
	 * the real insertion is done by method {@link #basicSetGraph(Graph)}.
	 * @param graph graph which contains this node 
	 */
	public void setGraph(Graph graph);
	/**
	 * This is an internally used method. To implement a double chaining of {@link Graph} and {@link Node} object when an
	 * node is inserted into this graph and to avoid an endless invocation the insertion of an node is splited into
	 * the two methods {@link #setGraph(Graph)} and {@link #basicSetGraph(Graph)}. The invocation of methods is implement 
	 * as follows:
	 * <pre>
	 * {@link Graph#addNode(Node)}                      {@link Node#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link Graph#basicAddNode(Node)}            {@link Node#basicSetGraph(Graph)}
	 * </pre> 
	 * 
	 * That means method {@link #setGraph(Graph)} calls {@link #basicSetGraph(Graph)} 
	 * and {@link Graph#basicAddNode(Node)}. And method {@link #setGraph(Graph)} calls 
	 * {@link Graph#basicAddNode(Node)} and {@link Node#basicSetGraph(Graph)}.
	 * 
	 * @param graph graph which contains this node
	 */
	public void basicSetGraph(Graph graph);
}
