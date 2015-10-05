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
 * This exception is a specialized exception of type {@link SaltResourceException}} and can be used to mark, that 
 * a resource to which Salt data shall be stored or loaded from does not exist.
 * @author Florian Zipser
 *
 */
public class SaltResourceNotFoundException extends SaltResourceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6754222858772290364L;

	public SaltResourceNotFoundException()
	{ super(); }
	
    public SaltResourceNotFoundException(String s)
    { super(s); }
    
	public SaltResourceNotFoundException(String s, Throwable ex)
	{super(s, ex); }
}
