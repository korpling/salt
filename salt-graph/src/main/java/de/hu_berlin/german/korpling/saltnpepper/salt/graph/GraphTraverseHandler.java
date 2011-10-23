package de.hu_berlin.german.korpling.saltnpepper.salt.graph;


public interface GraphTraverseHandler {
	/**
	 * Call back method to notify the listener of traversing.
	 * @param traversalMode
	 * @param traversalId - a unique id for one traversing process, the same id as for GraphTraverserObject
	 * @param currNode
	 * @param edge
	 * @param fromNode
	 * @param order
	 */
	public void nodeReached(	GRAPH_TRAVERSE_TYPE traversalType, 
								String traversalId,
								Node currNode, 
								Edge edge, 
								Node fromNode, 
								long order);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	public void nodeLeft(	GRAPH_TRAVERSE_TYPE traversalTypse, 
							String traversalId,
							Node currNode, 
							Edge edge, 
							Node fromNode, 
							long order);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	public boolean checkConstraint(		GRAPH_TRAVERSE_TYPE traversalType, 
										String traversalId,
										Edge edge, 
										Node currNode, 
										long order);
}
