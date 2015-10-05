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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions;

/**
 * This exception is used, when exceptions occurs while dealing the the SaltSemantics model.
 * @author Florian Zipser
 *
 */
public class SaltSemanticsException extends java.lang.RuntimeException
{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 1752733137673010658L;

	public SaltSemanticsException()
	{ super(); }
	
    public SaltSemanticsException(String s)
    { super(s); }
    
	public SaltSemanticsException(String s, Throwable ex)
	{super(s, ex); }
}
