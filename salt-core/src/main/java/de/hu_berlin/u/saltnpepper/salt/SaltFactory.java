package de.hu_berlin.u.saltnpepper.salt;

import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SNodeImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SRelationImpl;

public class SaltFactory{

	public SaltFactory() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Creates a new {@link SGraph} object of type {@link SGraphImpl}.
	 * 
	 * @return new {@link SGraph} object
	 */
	public static SGraph<SNode, SRelation<SNode, SNode>> createSGraph() {
		return (new SGraphImpl<SNode, SRelation<SNode, SNode>>());
	}

	/**
	 * Creates a new {@link SNode} object of type {@link SNodeImpl}.
	 * 
	 * @return new {@link SNode} object
	 */
	public static SNode createSNode() {
		return (new SNodeImpl());
	}

	/**
	 * Creates a new {@link SRelation} object of type {@link SRelationImpl}.
	 * 
	 * @return new {@link SRelation} object
	 */
	public static SRelation<SNode, SNode> createSRelation() {
		return (new SRelationImpl<SNode, SNode>());
	}
}
