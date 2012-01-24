/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
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
