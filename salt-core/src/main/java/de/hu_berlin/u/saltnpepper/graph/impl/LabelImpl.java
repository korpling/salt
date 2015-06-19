package de.hu_berlin.u.saltnpepper.graph.impl;

import org.apache.commons.lang3.tuple.Pair;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.util.GraphUtil;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;

public class LabelImpl<V extends Object> implements Label<V> {
	
	protected String namespace = null;
	/** {@inheritDoc Label#getNamespace()} */
	@Override
	public String getNamespace() {
		return namespace;
	}

	/** {@inheritDoc Label#setNamespace(String)} */
	@Override
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	protected String name = null;
	/** {@inheritDoc Label#getName()} */
	@Override
	public String getName() {
		return name;
	}

	/** {@inheritDoc Label#setName(String)} */
	@Override
	public void setName(String name) {
		if ((name == null) || (name.isEmpty())) {
			throw new SaltException("Cannot set the name of this label object, because it is empty.");
		}
		if (name.contains(NS_SEPERATOR))
			throw new SaltException("Cannot set the name to the given, because a namespace with namespace seperaor is illegal.");
		this.name = name;
	}

	/** {@inheritDoc Label#getQName()} */
	@Override
	public String getQName() {
		return GraphUtil.createQName(getNamespace(), getName());
	}

	/** {@inheritDoc Label#setQName(String)} */
	public void setQName(String newQName) {
		Pair<String, String> pair = GraphUtil.splitQName(newQName);
		setNamespace(pair.getLeft());
		setName(pair.getRight());
	}

	/** The generic value field. **/
	protected V value = null;

	/** {@inheritDoc Label#getValue()} */
	@Override
	public V getValue() {
		return value;
	}

	/** {@inheritDoc Label#setValue(Object)} */
	@Override
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * {@inheritDoc Label#clone()}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Label<V> clone() {
		return (this.copy((Label<V>) GraphFactory.createLabel()));
	}

	/** {@inheritDoc Label#copy()} **/
	@Override
	public Label<V> copy(Label<V> other) {
		if (other == null) {
			throw new SaltException("Cannot clone label '" + this + "', because the given object is null and its not possible to copy values into a null object.");
		}
		other.setNamespace(this.getNamespace());
		other.setName(this.getName());
		other.setValue(this.getValue());
		return (other);
	}
	@Override
	public String toString() {
		StringBuilder str= new StringBuilder();
		str.append(GraphUtil.createQName(getNamespace(), getName()));
		str.append("=");
		str.append(getValue());
		return super.toString();
	}
}
