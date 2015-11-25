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
package org.corpus_tools.salt.exceptions;

/**
 * This class is highest exception. All {@link SaltException} classes are
 * derived from this class. It can be instantiated, if no other Exception
 * matches to the problem.
 * 
 * @author Florian Zipser
 *
 */
@SuppressWarnings("serial")
public class SaltException extends java.lang.RuntimeException {

	public SaltException() {
		super();
	}

	public SaltException(String s) {
		super(s);
	}

	public SaltException(String s, Throwable ex) {
		super(s, ex);
	}
}
