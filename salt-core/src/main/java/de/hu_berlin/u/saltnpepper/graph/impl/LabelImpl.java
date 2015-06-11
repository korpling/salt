package de.hu_berlin.u.saltnpepper.graph.impl;

public class LabelImpl {
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
	private Object value= null;
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
