package de.hub.corpling.salt.saltCore.accessors;

import org.eclipse.emf.common.util.URI;

import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;

public class SIdentifiableElementAccessor 
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSId(SIdentifiableElement sIdentElem) 
	{
		return(sIdentElem.getId());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSId(SIdentifiableElement sIdentElem, String newSId) 
	{
		sIdentElem.setId(newSId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public URI getSElementPath(SIdentifiableElement sIdentElem) 
	{
		URI retVal= null;
		String id= sIdentElem.getSId();
		retVal= URI.createURI(id);
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSElementPath(SIdentifiableElement sIdentElem, URI newSElementPath) 
	{
		sIdentElem.setId(newSElementPath.toString());
	}
	
	public SElementId getSElementId(SIdentifiableElement sIdentElem) 
	{
		SElementId retVal= null;
		if (sIdentElem.getIdentifier() instanceof SElementId)
			retVal= (SElementId)sIdentElem.getIdentifier();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSElementId(SIdentifiableElement sIdentElem, SElementId newSElementId) 
	{
		sIdentElem.setIdentifier(newSElementId);
	}

}
