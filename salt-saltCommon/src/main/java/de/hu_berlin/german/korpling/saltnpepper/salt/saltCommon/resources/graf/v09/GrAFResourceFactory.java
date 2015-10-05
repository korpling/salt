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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09;

import java.util.Hashtable;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;

public class GrAFResourceFactory extends ResourceFactoryImpl 
{
	
	private static volatile Hashtable<URI, Resource> uri2Resource= null;
	private static GrAFResourceFactory instance= null;
	public synchronized static GrAFResourceFactory newInstance()
	{
		if (instance== null)
		{
			instance= new GrAFResourceFactory();
		}
		return(instance);	
	}
	
	private GrAFResourceFactory()
	{}
	
	public Resource createResource(URI uri)
	{
		if (uri== null)
			throw new SaltResourceException("Cannot create a resource for uri, because it is null.");
		Resource resource= null;
		if (uri2Resource== null)
		{
			synchronized (this) {
				if (uri2Resource== null)
					uri2Resource= new Hashtable<URI, Resource>();
			}
		}
		resource = uri2Resource.get(uri);
		if (resource== null)
		{
			synchronized (this) {
				if (resource== null)
				{
					resource= new GrAFResource();
					resource.setURI(uri);
					uri2Resource.put(uri, resource);
				}
			}
		}
		return(resource);
	}
}
