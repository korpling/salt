package de.hu_berlin.u.saltnpepper.graph;

/**
 * A label is an attribute-value-pair and can belong to either a {@link Node}, an {@link Relation}, a {@link Graph}, 
 * a {@link Layer} or another {@link Label} as shown in . An attribute-value-pair is a triple which consists of 
 * a namespace, a name and a value (namespace::name=value). The combination of name and namespace is used to 
 * identify a label and therefore must be unique. The namespace is an optional value, to distinguish in case of 
 * there are two labels having the same name.
 * 
 * @author florian
 *
 * @param <V> this parameter determines the type of the value of this label. 
 */
public interface Label<V extends Object> extends LabelableElement{
	/** Separator between namespace and name: qname= NAMESPACE {@value #NS_SEPERATOR} NAME. */
	public static final String NS_SEPERATOR= "::";
	/** 
	 * Returns the optional namespace of the label. The combination of namespace and name must be unique 
	 * in the containing object.
	 * @return namespace 
	 **/
	public String getNamespace();
	/**
	 * Sets the optional namespace of the label. The combination of namespace and name must be unique 
	 * in the containing object.
	 * @param namespace namespace
	 */
	public void setNamespace(String namespace);
	/**
	 * Returns the name of the label. The combination of namespace and name must be unique 
	 * in the containing object.
	 * @return name of the label
	 */
	public String getName();
	/**
	 * Sets the name of the label. The combination of namespace and name must be unique 
	 * in the containing object. The passed name must not be empty.
	 * @param name name of the label
	 */
	public void setName(String name);
	/**
	 * Returns the qName of this label, which is the combination of namespace and name must be unique 
	 * in the containing object.
	 * @return NAMESPACE {@value #NS_SEPERATOR} NAME 
	 */
	public String getQName();
	/**
	 * Sets the qName of this label, which is the combination of namespace and name must be unique 
	 * in the containing object.
	 * @param qname the qname is splitted into NAMESPACE {@value #NS_SEPERATOR} NAME 
	 */
	public void setQName(String qName);
	/**
	 * Returns the value of this label.
	 * @return generic value of this label.
	 */
	public V getValue();
	/**
	 * Sets the value of this label.
	 * @param value generic value of this label.
	 */
	public void setValue(V value);
	
	/**
	 * Creates a new object of type {@link Label} and copies the namespace, name and value of this label.
	 * @return a new {@link Label} object
	 */
	public Label<V> clone();
	/**
	 * This method the namespace, the name and the value from this object to the passed one and 
	 * returns the passed one.
	 * @param clone
	 *            the clone to which all properties of this shall be copied to
	 * @return other enhanced for namespace, name and value
	 */
	public Label<V> copy(Label<V> other);
}
