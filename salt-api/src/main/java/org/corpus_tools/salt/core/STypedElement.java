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

import org.corpus_tools.salt.util.SaltUtil;

/**
 * Each implementing subclass provides a type. The name is stored as label and
 * can be accessed with the namespace {@link SaltUtil#SALT_NAMESPACE} and the
 * name {@link SaltUtil#FEAT_TYPE}.
 * 
 * @author florian
 *
 */
public interface STypedElement {
	/**
	 * Returns the type of this element
	 * 
	 * @return
	 */
	public String getType();

	/**
	 * Sets the type of this element.
	 * 
	 * @param name
	 *            type of this element
	 */
	public void setType(String name);
}
