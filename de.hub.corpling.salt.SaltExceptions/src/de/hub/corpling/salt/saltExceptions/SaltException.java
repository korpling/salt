package de.hub.corpling.salt.saltExceptions;

/**
 * This class is highest exception. All PepperExceptions are derived from this class. 
 * It can be instantiated, if no other Exception maps to the problem.
 * @author Florian Zipser
 *
 */
public class SaltException extends java.lang.RuntimeException
{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 7152733137673010658L;

	public SaltException()
	{ super(); }
	
    public SaltException(String s)
    { super(s); }
    
	public SaltException(String s, Throwable ex)
	{super(s, ex); }
}
