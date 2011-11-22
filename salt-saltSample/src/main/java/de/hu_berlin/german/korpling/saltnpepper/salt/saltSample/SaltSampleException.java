package de.hu_berlin.german.korpling.saltnpepper.salt.saltSample;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;

public class SaltSampleException extends SaltException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2254913079950779931L;

	public SaltSampleException()
	{ super(); }
	
    public SaltSampleException(String s)
    { super(s); }
    
	public SaltSampleException(String s, Throwable ex)
	{super(s, ex); }
}
