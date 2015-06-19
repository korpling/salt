package de.hu_berlin.u.saltnpepper.graph;

import de.hu_berlin.u.saltnpepper.graph.util.GraphUtil;

/**
 * This class represents an identifier, which is a special kind of a label. The identifier is used for
 * {@link Node}, {@link Edge}, {@link Graph} and {@link Layer} objects. The namespace of an {@link Identifier} 
 * objectis fixed to {@link GraphUtil#IDENTIFIER_NAMESPACE} and its name is fixed to 
 * {@link GraphUtil#IDENTIFIER_NAME}. 
 * 
 * @author florian
 */
public interface Identifier extends Label<String>{
	/**
	 * Returns the value of this {@link Label}.
	 * @return the id value
	 */
	public String getId();

	/**
	 * Sets the value of this label.
	 * @param value id value to be set
	 */
	public void setId(String value);

	/**
	 * Returns the {@link IdentifiableElement} object containing this identifier.
	 * @return container
	 */
	public IdentifiableElement getIdentifiableElement();

	/**
	 * Sets the {@link IdentifiableElement} object containing this identifier.
	 * @param container object contianing this id.
	 */
	void setIdentifiableElement(IdentifiableElement container);
}
