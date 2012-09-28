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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions;

/**
 * A {@link GraphInsertException} is thrown if an object can not be inserted or added to
 * another object. Such an exception can be thrown if an insert or into a list fails and 
 * even if a set of the object fails. 
 * 
 * @author Florian Zipser
 *
 */
public class GraphInsertException extends GraphException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4559500051239383871L;

	public GraphInsertException()
	{ super(); }
	
    public GraphInsertException(String s)
    { super(s); }
    
	public GraphInsertException(String s, Throwable ex)
	{super(s, ex); }
}
