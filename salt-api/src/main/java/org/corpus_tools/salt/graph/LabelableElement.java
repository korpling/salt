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

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * This interface defines a container to hold {@link Label} objects and makes
 * them accessible.
 * <p>
 * When a label is added to another container, it is removed from it's former
 * container.
 * </p>
 *
 */
public interface LabelableElement extends Serializable {
	/**
	 * Returns all labels being contained by this object.
	 * 
	 * @return set of all {@link Label} objects
	 */
	public Collection<Label> getLabels();

	/**
	 * Adds the given Label object to the list of labels.
	 * 
	 * @param label
	 *            the Label object to be added
	 */
	public void addLabel(Label label);

	/**
	 * Returns a label having the passed namespace and name, if such a label is
	 * contained by this object
	 * 
	 * @param namespace
	 *            namespace of the {@link Label} to be searched for
	 * @param name
	 *            name of the {@link Label} to be searched for
	 * @return {@link Label} object
	 * @deprecated will be removed with Salt 5.0.
	 */
	@Deprecated
	public Label getLabel(String namespace, String name);

	/**
	 * Returns a label having the passed qualified name. Therefore the qName is
	 * splitted into namespace and name.
	 * 
	 * @param qName
	 *            the qualified name to be splitted
	 * @return {@link Label} object
	 */
	public Label getLabel(String qName);

	/**
	 * Returns a set containing all Label objects having the given namespace. If
	 * no such {@link Label} was found or the passed namespace was empty, an
	 * empty list is returned.
	 * 
	 * @param ns
	 *            the namespace of Label objects to be looked for.
	 * @return a list of Label objects if this object contains Label objects
	 *         having the given namespace, null otherwise.
	 * @deprecated will be removed with Salt 5.0.
	 */
	@Deprecated
	public Set<Label> getLabelsByNamespace(String namespace);

	/**
	 * Removes the label having the passed qName.
	 * 
	 * @param qName
	 *            qualified name of the {@link Label} to be removed
	 * 
	 */
	public void removeLabel(String qName);

	/**
	 * Removes a Label object from the list of labels of this object. The Label
	 * object to be removed is identified by given namespace and name.
	 * 
	 * @param namespace
	 *            the namespace of the object to be removed
	 * @param name
	 *            the name of the object to be removed
	 * @deprecated Will be removed with Salt 5.0.
	 */
	@Deprecated
	public void removeLabel(String namespace, String name);

	/**
	 * Removes all {@link Label} objects.
	 */
	public void removeAll();

	/**
	 * Checks if this object has a Label object in its list having the given
	 * qualified name.
	 * 
	 * @param fullName
	 *            the full qualified name of the label to be looked for
	 * @return true, if this object contains such a Label object, false
	 *         otherwise
	 */
	public boolean containsLabel(String qName);

	/**
	 * returns the number of {@link Label} objects contained by this object.
	 * 
	 * @return number of {@link Label} objects
	 */
	public Integer sizeLabels();
}
