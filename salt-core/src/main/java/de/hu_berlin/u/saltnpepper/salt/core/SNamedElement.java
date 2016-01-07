package de.hu_berlin.u.saltnpepper.salt.core;

/**
 * Each implementing subclass provides a name. The name is stored as label and
 * can be accessed with the namespace {@link #NAMESPACE} and the name
 * {@link #NAME}.
 * 
 * @author florian
 *
 */
public interface SNamedElement {
	/**
	 * Returns the name of this element. The name of the element is not the
	 * identifier of the element. The identifier is given by the graph and
	 * constructed as a URI, where the name is used as fragment. If this is not
	 * unique, the graph will add a number to the fragment to make it unique.
	 * 
	 * @return name of the element.
	 */
	public String getName();

	/**
	 * Sets the name of the element. The name of the element is not the
	 * identifier of the element. The identifier is given by the graph and
	 * constructed as a URI, where the name is used as fragment. If this is not
	 * unique, the graph will add a number to the fragment to make it unique.
	 * 
	 * @param name
	 *            name of the element.
	 */
	public void setName(String name);
}
