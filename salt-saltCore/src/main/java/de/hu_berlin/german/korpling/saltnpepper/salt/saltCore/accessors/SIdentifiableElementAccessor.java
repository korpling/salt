/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;

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
	 * Sets the id of the given <code>sIdentElem</code> object. If this object does not already have an {@link SElementId}
	 * object, a new one will be created. If it already has one, the {@link SElementId#setSId(String)} method will be called
	 * to delegate setting of the identifier.
	 */
	public void setSId(SIdentifiableElement sIdentElem, String newSId) 
	{
		if (sIdentElem.getSElementId()== null)
		{
			SElementId sElementId= SaltCoreFactory.eINSTANCE.createSElementId();
			sElementId.setSId(newSId);
			sIdentElem.setSElementId(sElementId);
		}
		else
			sIdentElem.getSElementId().setSId(newSId);
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
