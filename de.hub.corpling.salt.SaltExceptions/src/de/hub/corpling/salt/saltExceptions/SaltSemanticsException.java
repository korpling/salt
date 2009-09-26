package de.hub.corpling.salt.saltExceptions;

/**
 * This class is highest exception. All PepperExceptions are derived from this class. 
 * It can be instantiated, if no other Exception maps to the problem.
 * @author Florian Zipser
 *
 */
public class SaltSemanticsException extends java.lang.RuntimeException
{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 1752733137673010658L;

	public SaltSemanticsException()
	{ super(); }
	
    public SaltSemanticsException(String s)
    { super(s); }
    
	public SaltSemanticsException(String s, Throwable ex)
	{super(s, ex); }
}
