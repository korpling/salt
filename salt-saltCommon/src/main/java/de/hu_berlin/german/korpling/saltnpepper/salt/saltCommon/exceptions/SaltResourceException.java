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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions;

/**
 * This exception is used for exceptions occuring while loading or storing Salt data from or to disk.
 * @author Florian Zipser
 *
 */
public class SaltResourceException extends SaltException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1933070772503535889L;

	public SaltResourceException()
	{ super(); }
	
    public SaltResourceException(String s)
    { super(s); }
    
	public SaltResourceException(String s, Throwable ex)
	{super(s, ex); }
}
