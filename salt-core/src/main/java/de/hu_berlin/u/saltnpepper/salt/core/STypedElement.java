package de.hu_berlin.u.saltnpepper.salt.core;

import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

/**
 * Each implementing subclass provides a type. The name is stored as label and
 * can be accessed with the namespace {@link SaltUtil#SALT_NAMESPACE} and the name
 * {@link SaltUtil#KW_TYPE}.
 * 
 * @author florian
 *
 */
public interface STypedElement {
	/**
	 * Returns the type of this element
	 * @return
	 */
	public String getType();

	/**
	 * Sets the type of this element.
	 * @param name type of this element
	 */
	public void setType(String name);
}
