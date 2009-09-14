package de.hub.corpling.salt.saltCore.tests.storing;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

public class SAnnotationStoringTest extends TestCase 
{
	protected SAnnotation fixture = null;

	protected void setFixture(SAnnotation fixture) {
		this.fixture = fixture;
	}

		protected SAnnotation getFixture() {
		return fixture;
	}

	protected void setUp() throws Exception {
		setFixture(SaltCoreFactory.eINSTANCE.createSAnnotation());
	}

	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	public void testStoring() throws IOException
	{
		SAnnotation sAnnoNew= null;
		String tmpFileName= "_TMP/SAnnotation.saltCore";
		
		this.getFixture().setSName("annoName");
		this.getFixture().setSValue("annoValue");
		{//save and reload
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register XML resource factory
			resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCore",new XMIResourceFactoryImpl());
			
			URI outURI= URI.createFileURI(tmpFileName);
			
			//save resources
			XMLResource resourceOut = (XMLResource)resourceSet.createResource(outURI);
			resourceOut.getContents().add(this.getFixture());
			resourceOut.setEncoding("UTF-8");
			resourceOut.save(null);
			
			
			//load resource 
			Resource resource = resourceSet.createResource(URI.createFileURI(tmpFileName));
			
			if (resource== null)
				throw new NullPointerException("The resource is null.");
			resource.load(null);
			sAnnoNew= (SAnnotation) resource.getContents().get(0);
			
		}
		{//check if both are equal
			assertEquals(this.getFixture(), sAnnoNew);
		}
	}
	
	public void testStoring2() throws IOException
	{
		SAnnotation sAnnoNew= null;
		String tmpFileName= "_TMP/SAnnotation2.saltCore";
		
		this.getFixture().setNamespace("annoNS");
		this.getFixture().setSName("annoName");
		this.getFixture().setSValue("annoValue");
		{//save and reload
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register XML resource factory
			resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCore",new XMIResourceFactoryImpl());
			
			URI outURI= URI.createFileURI(tmpFileName);
			
			//save resources
			XMLResource resourceOut = (XMLResource)resourceSet.createResource(outURI);
			resourceOut.getContents().add(this.getFixture());
			resourceOut.setEncoding("UTF-8");
			resourceOut.save(null);
			
			
			//load resource 
			Resource resource = resourceSet.createResource(URI.createFileURI(tmpFileName));
			
			if (resource== null)
				throw new NullPointerException("The resource is null.");
			resource.load(null);
			sAnnoNew= (SAnnotation) resource.getContents().get(0);
			
		}
		{//check if both are equal
			assertEquals(this.getFixture(), sAnnoNew);
		}
	}
}
