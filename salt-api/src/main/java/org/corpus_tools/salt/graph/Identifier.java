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
package org.corpus_tools.salt.graph;

import org.corpus_tools.salt.util.SaltUtil;

/**
 * This class represents an identifier, which is a special kind of a label. The
 * identifier is used for {@link Node}, {@link Relation}, {@link Graph} and
 * {@link Layer} objects. The namespace of an {@link Identifier} objectis fixed
 * to {@link SaltUtil#SALT_NAMESPACE} and its name is fixed to
 * {@link SaltUtil#LABEL_ID}.
 */
public interface Identifier extends Label {
	/**
	 * Returns the value of this {@link Label}.
	 * 
	 * @return the id value
	 */
	public String getId();

	/**
	 * Returns the {@link IdentifiableElement} object containing this
	 * identifier.
	 * 
	 * @return container
	 */
	public IdentifiableElement getIdentifiableElement();

	/**
	 * This method has no effect, since the id value is not changeable.
	 */
	public void setValue(String value);
}
