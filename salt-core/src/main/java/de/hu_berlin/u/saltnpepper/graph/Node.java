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
	public void setGraph(Graph graph);
}
