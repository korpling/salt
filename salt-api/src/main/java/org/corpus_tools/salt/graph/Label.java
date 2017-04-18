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

import org.corpus_tools.salt.util.Copyable;

/**
 * A label is an attribute-value-pair and can belong to either a {@link Node},
 * an {@link Relation}, a {@link Graph}, a {@link Layer} or another
 * {@link Label} as shown in . An attribute-value-pair is a triple which
 * consists of a namespace, a name and a value (namespace::name=value). The
 * combination of name and namespace is used to identify a label and therefore
 * must be unique. The namespace is an optional value, to distinguish in case of
 * there are two labels having the same name.
 * <p>
 * When a label is added to another container, it is removed from it's former
 * container.
 * </p>
 * 
 * @param <V>
 *            this parameter determines the type of the value of this label.
 */
public interface Label extends LabelableElement, Copyable<Label> {
	/**
	 * Separator between namespace and name: qname= NAMESPACE
	 * {@value #NS_SEPERATOR} NAME.
	 */
	public static final String NS_SEPERATOR = "::";

	/**
	 * Returns the optional namespace of the label. The combination of namespace
	 * and name must be unique in the containing object.
	 * 
	 * @return namespace
	 **/
	public String getNamespace();

	/**
	 * Sets the optional namespace of the label. The combination of namespace
	 * and name must be unique in the containing object.
	 * 
	 * @param namespace
	 *            namespace
	 */
	public void setNamespace(String namespace);

	/**
	 * Returns the name of the label. The combination of namespace and name must
	 * be unique in the containing object.
	 * 
	 * @return name of the label
	 */
	public String getName();

	/**
	 * Sets the name of the label. The combination of namespace and name must be
	 * unique in the containing object. The passed name must not be empty.
	 * 
	 * @param name
	 *            name of the label
	 */
	public void setName(String name);

	/**
	 * Returns the qName of this label, which is the combination of namespace
	 * and name must be unique in the containing object.
	 * 
	 * @return NAMESPACE {@value #NS_SEPERATOR} NAME
	 */
	public String getQName();

	/**
	 * Sets the qName of this label, which is the combination of namespace and
	 * name must be unique in the containing object.
	 * 
	 * @param qname
	 *            the qname is splitted into NAMESPACE {@value #NS_SEPERATOR}
	 *            NAME
	 */
	public void setQName(String qName);

	/**
	 * Returns the value of this label.
	 * 
	 * @return generic value of this label.
	 */
	public Object getValue();

	/**
	 * Sets the value of this label.
	 * 
	 * @param value
	 *            generic value of this label.
	 */
	public void setValue(Object value);

	/**
	 * Returns the container element, which contains this label. The label and
	 * the container are double chained, which means when a label is added to
	 * the container, the labels container is automatically set to it or even
	 * removed.
	 * 
	 * @return container of this label
	 */
	public LabelableElement getContainer();

	/**
	 * Sets the container element, which contains this label. The label and the
	 * container are double chained, which means when a label is added to the
	 * container, the labels container is automatically set to it or even
	 * removed. Passing a null value means removing the label from the
	 * container.
	 * 
	 * @param value
	 *            container of this label
	 */
	public void setContainer(LabelableElement container);
}
