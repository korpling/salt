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
package org.corpus_tools.salt.graph;

public interface IdentifiableElement extends LabelableElement {
	/**
	 * Returns the id of this object, which is the value of the contained
	 * {@link Identifier} object.
	 * 
	 * @return the id String
	 **/
	public String getId();

	/**
	 * Creates a new {@link Identifier} object and sets its value to the passed
	 * id.
	 * 
	 * @param value
	 *            the id String
	 **/
	public void setId(String id);

	/**
	 * Returns the {@link Identifier} label for this object.
	 * 
	 * @return the {@link Identifier} object
	 **/
	public Identifier getIdentifier();

	/**
	 * Sets the {@link Identifier} label for this object. If this object alredy
	 * had an identifier, the old one is removed and the new one is added.
	 * 
	 * @param the
	 *            {@link Identifier} object
	 **/
	public void setIdentifier(Identifier identifier);
}
