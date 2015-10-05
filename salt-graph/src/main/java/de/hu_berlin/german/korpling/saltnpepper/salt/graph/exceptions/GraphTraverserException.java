/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
