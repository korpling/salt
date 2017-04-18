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
package org.corpus_tools.salt.util;

/**
 * An interface to ensure that an object is copyable. This is an alternative to
 * the {@link Cloneable} interface which seems to be very controversial.
 */
public interface Copyable<T> {

	/**
	 * Takes a new 'empty' object and sets all its fields by copying by value.
	 * 
	 * @param surrogate
	 *            empty object to be filled
	 * @return returns surrogate
	 */
	public T copy(T other);
}
