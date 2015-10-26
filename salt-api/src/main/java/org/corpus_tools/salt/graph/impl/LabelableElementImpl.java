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
package org.corpus_tools.salt.graph.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.corpus_tools.salt.exceptions.SaltInsertionException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.IdentifiableElement;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.LabelableElement;
import org.corpus_tools.salt.util.SaltUtil;

/**
 * This class is an abstract container containing a set of {@link Label}
 * objects.
 * 
 * @author florian
 *
 */
@SuppressWarnings("serial")
public abstract class LabelableElementImpl implements LabelableElement, Serializable {
	/** Determines the expected number of labels. **/
	public static final int EXPECTED_NUMBER_OF_LABELS=5;
	
	/** internal set of all labels **/
	private Map<String, Label> labels = null;

	/** {@inheritDoc LabelableElement#getLabels()} **/
	@Override
	public Collection<Label> getLabels() {
		Collection<Label> retVal = null;
		if (labels != null) {
			retVal = labels.values();
		}
		return (retVal);
	}

	/** {@inheritDoc LabelableElement#getLabel(String)} **/
	@Override
	public Label getLabel(String qName) {
		if (labels != null) {
			return (labels.get(qName));
		} else {
			return (null);
		}
	}

	/** {@inheritedDoc LabelableElement#getLabel(String, String)} **/
	@Override
	public Label getLabel(String namespace, String name) {
		String qName = SaltUtil.createQName(namespace, name);
		return (getLabel(qName));
	}

	/** {@inheritDoc LabelableElement#getLabelsByNamespace(String)} **/
	@Override
	public Set<Label> getLabelsByNamespace(String ns) {
		Set<Label> retVal = new HashSet<>(EXPECTED_NUMBER_OF_LABELS);
		if (labels != null) {
			for (Label label : labels.values()) {
				if (ns == null) {
					if (label.getNamespace() == null) {
						retVal.add(label);
					}
				} else if (ns.equals(label.getNamespace())) {
					retVal.add(label);
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} */
	@Override
	public void addLabel(Label label) {
		if (label != null) {
			if (label instanceof LabelImpl) {
				if (label.getContainer()!= null){
					//removes the label from old container, if an old container exists
					label.getContainer().removeLabel(label.getQName());
				}
				((LabelImpl) label).basicSetLabelableElement(this);
			}
			basicAddLabel(label);
		}
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link LabelableElement} and {@link label} object. When a label is
	 * inserted into this container and to avoid an endless invocation the
	 * insertion of a label is split into the two methods
	 * {@link #addLabel(Label)} and {@link #basicAddLabel(Label)}. The
	 * invocation of methods is implement as follows:
	 * 
	 * <pre>
	 * {@link #addLabel(Label)}                      {@link Label#setContainer(LabelableElement)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicAddLabel(Label)}            {@link LabelImpl#basicSetLabelableElement(LabelableElement)}
	 * </pre>
	 * 
	 * That means method {@link #addLabel(Label)} calls
	 * {@link #basicAddLabel(Label)} and {@link Label#basicSetGraph(Graph)}. And
	 * method {@link Label#setContainer(LabelableElement)} calls
	 * {@link #basicAddLabel(Label)} and
	 * {@link LabelImpl#basicSetLabelableElement(LabelableElement)}.
	 * 
	 * @param label
	 *            label to be inserted
	 */
	public void basicAddLabel(Label label) {
		if (label != null) {
			if ((label.getName() == null) || (label.getName().isEmpty())) {
				throw new SaltInsertionException(this, label, "Cannot add a label object without a name.");
			}
			if (labels == null) {
				labels = new HashMap<>(EXPECTED_NUMBER_OF_LABELS);
			}
			String qName = SaltUtil.createQName(label.getNamespace(), label.getName());
			if (labels.containsKey(qName)) {
				if (this instanceof IdentifiableElement) {
					throw new SaltInsertionException(this, label, " Because an id already exists: " + labels.get(qName) + ".");
				} else {
					throw new SaltInsertionException(this, label, "Cannot add the given label object, because a label with this QName already exists: " + label.getQName());
				}
			}
			labels.put(qName, label);
		}
	}

	/** {@inheritDoc LabelableElement#removeLabel(String)} **/
	@Override
	public void removeLabel(String qName) {
		if (qName != null) {
			Label label = getLabel(qName);
			if (label instanceof LabelImpl) {
				((LabelImpl) label).setContainer(null);
			}
			basicRemoveLabel(qName);
		}
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link LabelableElement} and {@link label} object. When a label is
	 * inserted into this container and to avoid an endless invocation the
	 * insertion of a label is split into the two methods
	 * {@link #removeLabel(String)} and {@link #basicRemoveLabel(String)}. The
	 * invocation of methods is implement as follows:
	 * 
	 * <pre>
	 * {@link #removeLabel(String)}                      {@link Label#setContainer(LabelableElement)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicRemoveLabel(STring)}            {@link LabelImpl#basicSetLabelableElement(LabelableElement)}
	 * </pre>
	 * 
	 * That means method {@link #removeLabel(String)} calls
	 * {@link #basicRemoveLabel(String)} and {@link Label#basicSetGraph(Graph)}.
	 * And method {@link Label#setContainer(LabelableElement)} calls
	 * {@link #basicRemoveLabel(String)} and
	 * {@link LabelImpl#basicSetLabelableElement(LabelableElement)}.
	 * 
	 * @param label
	 *            label to be inserted
	 */
	public void basicRemoveLabel(String qName) {
		if (qName != null) {
			labels.remove(qName);
		}
	}

	/** {@inheritDoc LabelableElement#removeLabel(String, String))} **/
	@Override
	public void removeLabel(String namespace, String name) {
		removeLabel(SaltUtil.createQName(namespace, name));
	}

	/** {@inheritDoc LabelableElement#removeAll()} **/
	@Override
	public void removeAll() {
		labels = new HashMap<>(EXPECTED_NUMBER_OF_LABELS);
	}

	/** {@inheritDoc LabelableElement#containsLabel(String)} **/
	@Override
	public boolean containsLabel(String qName) {
		return (labels.containsKey(qName));
	}

	/** {@inheritDoc LabelableElement#sizeLabels()} **/
	@Override
	public Integer sizeLabels() {
		if (labels != null) {
			return (labels.values().size());
		}
		return (0);
	}
}
