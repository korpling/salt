/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.exceptions;

/**
 * This exception class is thrown, when a wrong parameter was passed to a method
 * in the Salt api.
 * 
 * @author Florian Zipser
 *
 */
@SuppressWarnings("serial")
public class SaltParameterException extends SaltException {
	public SaltParameterException(String parameterName, String methodName, Class<? extends Object> clazz) {
		this(parameterName, methodName, clazz, null);
	}

	public SaltParameterException(String parameterName, String methodName, Class<? extends Object> clazz, String msg) {
		super("The method '" + methodName + "' of class '" + (clazz != null ? clazz.getSimpleName() : "")
				+ "' invokes an exception, because the specified parameter '" + parameterName + "' was not correct. "
				+ (msg != null ? msg : ""));
	}

	public SaltParameterException(String s) {
		super(s);
	}

	public SaltParameterException(String s, Throwable ex) {
		super(s, ex);
	}
}
