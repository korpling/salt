package de.hub.corpling.salt.saltCommon.resources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;


public class GrAFResourceFactory extends ResourceFactoryImpl 
{
	public Resource createResource(URI uri)
	{
		System.out.println("=============> GrAFResourceFactory.createResource() was called");
		Resource resource=new GrAFResource();
		resource.setURI(uri);
		return(resource);
	}
}
