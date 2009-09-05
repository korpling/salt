package de.hub.corpling.salt.modules;

import de.hub.corpling.salt.saltExceptions.SaltException;

public class SaltModuleException extends SaltException 
{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -8082045343074569251L;

	public SaltModuleException()
	{ super(); }
	
    public SaltModuleException(String s)
    { super(s); }
    
	public SaltModuleException(String s, Throwable ex)
	{super(s, ex); }
}
