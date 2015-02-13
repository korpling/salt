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

import org.eclipse.emf.ecore.EObject;

/**
 * This exception class is used to define an exception occuring when a parameter in a function call is 
 * empty or null.
 * @author Florian Zipser
 *
 */
public class SaltEmptyParameterException extends SaltException
{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 7152733137673010658L;

	public SaltEmptyParameterException()
	{ super(); }
	
	public SaltEmptyParameterException(	String parameterName, 
										String methodName, 
										Class<? extends Object> clazz)
	{ 
		super("The method '"+methodName+"' of class '"+clazz.getSimpleName()+"' invokes an exception, because the parameter '"+parameterName+"' was empty or null.");
	}
	
    public SaltEmptyParameterException(String s)
    { super(s); }
    
	public SaltEmptyParameterException(String s, Throwable ex)
	{super(s, ex); }
}
