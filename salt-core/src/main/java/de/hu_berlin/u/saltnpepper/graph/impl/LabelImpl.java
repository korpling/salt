package de.hu_berlin.u.saltnpepper.graph.impl;

import org.apache.commons.lang3.tuple.Pair;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.util.GraphUtil;

public class LabelImpl<V extends Object> implements Label<V> {
	private String namespace = null;

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

	private String name = null;

	/** {@inheritDoc Label#getName()} */
	@Override
	public String getName() {
		return name;
	}

	/** {@inheritDoc Label#setName(String)} */
	@Override
	public void setName(String name) {
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
	private V value = null;

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
}
