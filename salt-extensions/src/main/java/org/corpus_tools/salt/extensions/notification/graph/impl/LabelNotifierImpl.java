/**
 * Copyright 2009 Humboldt-Universität zu Berlin
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
package org.corpus_tools.salt.extensions.notification.graph.impl;

import java.util.Collection;
import java.util.List;

import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.graph.Notifier;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.impl.LabelImpl;

@SuppressWarnings("serial")
public class LabelNotifierImpl extends LabelImpl implements Label, Notifier {

	// ==========================================> listener list
	protected List<Listener> listenerList = null;

	/** {@inheritDoc} **/
	@Override
	public List<Listener> getListener() {
		return (NotifierHelper.getListener(listenerList));
	}

	/** {@inheritDoc} **/
	@Override
	public synchronized void addListener(Listener listener) {
		listenerList = NotifierHelper.addListener(listenerList, listener);
	}

	/** {@inheritDoc} **/
	@Override
	public void addListener(Collection<Listener> listener) {
		listenerList = NotifierHelper.addListener(listenerList, listener);
	}

	/** {@inheritDoc} **/
	@Override
	public synchronized void removeListener(Listener listener) {
		listenerList = NotifierHelper.removeListener(listenerList, listener);
	}
	// ==========================================< listener list

	// ==========================================> handling contained label
	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void addLabel(Label label) {
		super.addLabel(label);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.LABEL_LABELS, null, label, this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void removeLabel(String qName) {
		Label oldValue = getLabel(qName);
		super.removeLabel(qName);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.LABEL_LABELS, oldValue, null, this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void removeAll() {
		Collection<Label> oldValue = getLabels();
		super.removeAll();
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE_ALL, GRAPH_ATTRIBUTES.LABEL_LABELS, oldValue, null, this);
		}
	}
	// ==========================================< handling contained label

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void setNamespace(String namespace) {
		String oldValue = getNamespace();
		super.setNamespace(namespace);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, oldValue, namespace, this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void setName(String name) {
		String oldValue = getName();
		super.setName(name);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, oldValue, name, this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void setQName(String qName) {
		String oldNamespace = getNamespace();
		String oldName = getName();
		super.setNamespace(namespace);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, oldNamespace, getNamespace(), this);
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, oldName, getName(), this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void setValue(Object value) {
		Object oldValue = getValue();
		super.setValue(value);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, oldValue, value, this);
		}
	}
}
