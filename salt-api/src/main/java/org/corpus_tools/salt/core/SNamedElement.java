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
package org.corpus_tools.salt.core;

/**
 * Each implementing subclass provides a name. The name is stored as label and
 * can be accessed with the namespace {@link #NAMESPACE} and the name
 * {@link #NAME}.
 * 
 * @author florian
 *
 */
public interface SNamedElement {
	/**
	 * Returns the name of this element. The name of the element is not the
	 * identifier of the element. The identifier is given by the graph and
	 * constructed as a URI, where the name is used as fragment. If this is not
	 * unique, the graph will add a number to the fragment to make it unique.
	 * 
	 * @return name of the element.
	 */
	public String getName();

	/**
	 * Sets the name of the element. The name of the element is not the
	 * identifier of the element. The identifier is given by the graph and
	 * constructed as a URI, where the name is used as fragment. If this is not
	 * unique, the graph will add a number to the fragment to make it unique.
	 * 
	 * @param name
	 *            name of the element.
	 */
	public void setName(String name);
}
