package de.hu_berlin.u.saltnpepper.salt.core;

/**
 * Each implementing subclass provides a name. The name is stored as label and
 * can be accessed with the namespace {@link #NAMESPACE} and the name
 * {@link #NAME}.
 * 
 * @author florian
 *
 */
public interface NamedElement {
	public static final String NAMESPACE = "salt";
	public static final String NAME = "name";

	public String getName();

	public void setName(String name);
}
