package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions;

public class SaltTokenizerException extends SaltException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3806907508823082271L;

	public SaltTokenizerException()
	{ super(); }
	
    public SaltTokenizerException(String s)
    { super(s); }
    
	public SaltTokenizerException(String s, Throwable ex)
	{super(s, ex); }
}