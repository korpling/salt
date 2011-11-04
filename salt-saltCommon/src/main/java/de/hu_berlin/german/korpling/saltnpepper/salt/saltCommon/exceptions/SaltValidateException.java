package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions;

public class SaltValidateException extends SaltException 
{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 7152733137673010658L;

	public SaltValidateException()
	{ super(); }
	
    public SaltValidateException(String s)
    { super(s); }
    
	public SaltValidateException(String s, Throwable ex)
	{super(s, ex); }
}
