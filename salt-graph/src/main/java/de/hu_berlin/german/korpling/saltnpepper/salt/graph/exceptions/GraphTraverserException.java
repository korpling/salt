package de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.exceptions.GraphModuleException;

public class GraphTraverserException extends GraphModuleException 
{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 7152733137673010658L;

	public GraphTraverserException()
	{ super(); }
	
    public GraphTraverserException(String s)
    { super(s); }
    
	public GraphTraverserException(String s, Throwable ex)
	{super(s, ex); }
}
