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
	public static final String NAMESPACE = "salt";
	public static final String NAME = "type";

	public String getName();

	public void setName(String name);
}
