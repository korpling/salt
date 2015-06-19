package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.Label;

public class LabelImpl<V extends Object> implements Label<V>{
	private String namespace= null;
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	private String name= null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/** The generic value field. **/
	private V value= null;
	/**
	 * Returns the value of this label.
	 * @return generic value of this label.
	 */
	public V getValue() {
		return value;
	}
	/**
	 * Sets the value of this label.
	 * @param value generic value of this label.
	 */
	public void setValue(V value) {
		this.value = value;
	}
}
