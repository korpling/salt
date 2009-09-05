package de.hub.corpling.salt.saltCommon.tests.storing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hub.corpling.salt.saltCommon.SaltCommonPackage;
import de.hub.corpling.salt.saltCommon.SaltProject;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

import junit.framework.TestCase;

public class StoringTest1 extends TestCase 
{	
	/**
	 * Checks saving and loading of CoreModel1
	 * @throws IOException
	 */
	public void testStoring() throws IOException
	{
		URI sourceURI= URI.createFileURI("./data/storing/sources/Model1.saltCommon");
		URI targetURI= URI.createFileURI("./data/storing/targets/Model1.saltCommon");
		
		this.SaveAndLoadResource(sourceURI, targetURI);
		assertTrue(this.compareFiles(new File(sourceURI.toFileString()), new File(targetURI.toFileString())));
	}
	
	protected void SaveAndLoadResource(URI sourceURI, URI targetURI) throws IOException
	{
		// create resource set and resource 
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML resource factory
		resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(SaltCommonPackage.eINSTANCE.getNsURI(), SaltCommonPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(SCorpusStructurePackage.eINSTANCE.getNsURI(), SCorpusStructurePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(SDocumentStructurePackage.eINSTANCE.getNsURI(), SDocumentStructurePackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCommon",new XMIResourceFactoryImpl());
		
		//load resource 
		Resource resource = resourceSet.createResource(sourceURI);
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		SaltProject sProject= (SaltProject) resource.getContents().get(0);
				
		XMLResource resourceOut = (XMLResource)resourceSet.createResource(targetURI);
		resourceOut.getContents().add(sProject);
		resourceOut.setEncoding("UTF-8");
		resourceOut.save(null);
		
	}
	
	protected boolean compareFiles(File file1, File file2) throws IOException
	{
		boolean retVal= false;
		
		if ((file1== null) || (file2== null))
			throw new NullPointerException("One of the files to compare are null.");
		
		String contentFile1= null;
		String contentFile2= null;
		BufferedReader brFile1= null;
		BufferedReader brFile2= null;
		try 
		{
			brFile1=  new BufferedReader(new FileReader(file1));
			String line= null;
			while (( line = brFile1.readLine()) != null)
			{
		          contentFile1= contentFile1+  line;
		    }
			brFile2=  new BufferedReader(new FileReader(file2));
			line= null;
			while (( line = brFile2.readLine()) != null)
			{
		          contentFile2= contentFile2+  line;
		    }
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally 
		{
			brFile1.close();
			brFile2.close();
		} 
		
		if (contentFile1== null)
		{
			if (contentFile2== null)
				retVal= true;
			else retVal= false;
		}	
		else if (contentFile1.equals(contentFile2))
			retVal= true;
		return(retVal);
	}

}
