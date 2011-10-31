package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.helper.modules;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphModule;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;

/**
 * This class is a general parent class for modules working on a {@link SGraph} object. Often modules implementing 
 * this class are used as delegators, where methods of the class {@link SGraph} delegating to.  
 * 
 * @author Florian Zipser
 *
 */
public abstract class SGraphModule extends GraphModule
{
	/**
	 * Sets the graph object, on which derived modules are working on.
	 * @param sGraph object to work on
	 */
	public void setSGraph(SGraph sGraph)
	{
		super.setGraph(sGraph);
	}
	
	/**
	 * Returns the graph on which derived modules are working on.
	 * @return the graph on which derived modules are working on.
	 */
	public SGraph getSGraph()
	{
		return((SGraph) super.getGraph());
	}
	
}
