package de.hub.corpling.salt.saltExceptions;

public class SaltModuleException extends SaltException
{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 7152733137873010658L;

	public SaltModuleException()
	{ super(); }
	
    public SaltModuleException(String s)
    { super(s); }
    
	public SaltModuleException(String s, Throwable ex)
	{super(s, ex); }
}
