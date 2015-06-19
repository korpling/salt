package de.hu_berlin.u.saltnpepper.graph;


public interface IdentifiableElement extends LabelableElement{
	/** 
	 * Returns the id of this object, which is the value of the contained {@link Identifier} object.
	 * @return the id String 
	 **/
	public String getId();
	/** 
	 * Sets the id of this object, which is the value of the contained {@link Identifier} object.
	 * @param value the id String
	 **/
	public void setId(String value);
	/** 
	 * Returns the {@link Identifier} label for this object.
	 * @return the {@link Identifier} object 
	 **/
	public Identifier getIdentifier();
	/** 
	 * Sets the {@link Identifier} label for this object.
	 * @param the {@link Identifier} object
	 **/
	public void setIdentifier(Identifier value);
}
