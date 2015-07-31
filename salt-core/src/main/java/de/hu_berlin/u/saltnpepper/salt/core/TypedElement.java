package de.hu_berlin.u.saltnpepper.salt.core;

/**
 * Each implementing subclass provides a type. The name is stored as label and
 * can be accessed with the namespace {@link #NAMESPACE} and the name
 * {@link #NAME}.
 * 
 * @author florian
 *
 */
public interface TypedElement {
	/**
	 * Returns the type of this element
	 * @return
	 */
	public String getType();

	public void setType(String name);
}
