package org.corpus_tools.salt.graph;

public interface IdentifiableElement extends LabelableElement {
	/**
	 * Returns the id of this object, which is the value of the contained
	 * {@link Identifier} object.
	 * 
	 * @return the id String
	 **/
	public String getId();

	/**
	 * Creates a new {@link Identifier} object and sets its value to the passed
	 * id.
	 * 
	 * @param value
	 *            the id String
	 **/
	public void setId(String id);

	/**
	 * Returns the {@link Identifier} label for this object.
	 * 
	 * @return the {@link Identifier} object
	 **/
	public Identifier getIdentifier();

	/**
	 * Sets the {@link Identifier} label for this object. If this object alredy
	 * had an identifier, the old one is removed and the new one is added.
	 * 
	 * @param the
	 *            {@link Identifier} object
	 **/
	public void setIdentifier(Identifier identifier);
}
