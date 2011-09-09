/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;

public class Salt2DOT 
{

	/**
	 * Creates a dot resource to save a dot model of a SCorpusGraph or a SDocumentGraph (given by obj) to a file given by outputURI.
	 * @param obj a SCorpusGraph or a SDocumentGraph 
	 * @param outputURI the file to write to
	 * @param resourceSet the resourceSet for dot resources
	 */
	private void saveResource(EObject obj, URI outputURI, ResourceSet resourceSet) {
		Resource resourceOut = resourceSet.createResource(outputURI);
		if (resourceOut==null)
			throw new SaltResourceException("Cannot export salt model to dot, because the resource is null. Maybe, there is no resource-uri given, or it does not ends with '.dot'. Resource: "+ outputURI);
		resourceOut.getContents().add(obj);
		try {
			resourceOut.save(null);
		} catch (IOException e) {
			throw new SaltResourceException("Cannot export model to file '"+outputURI+"', because of an unknown error.", e);
		}
	}
	
	/**
	 * Creates a ResourceSet and calls saveResource. If obj is a SaltProject, directory structures for SCorpusGraphs and SDocumentGraphs are created first.  
	 * @param obj A SaltProject, SCorpusGraph or SDocumentGraph
	 * @param outputURI the URI for the DOT file(s)
	 */
	private void actualSalt2Dot(EObject obj, URI outputURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(SDocumentStructurePackage.eINSTANCE.getNsURI(), SDocumentStructurePackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("dot",new DOTResourceFactory());
		if (obj instanceof SCorpus)
		{
			SCorpus sCorpus= (SCorpus) obj;
			if (sCorpus.getSCorpusGraph()!= null)
				obj= sCorpus.getSCorpusGraph();
		}
		else if (obj instanceof SDocument)
		{
			SDocument sDocument= (SDocument) obj;
			if (sDocument.getSDocumentGraph()!= null)
				obj= sDocument.getSDocumentGraph();
		}
		
		//if obj is a SDocumentGraph or SCorpusGraph, outputURI does not have to be changed 
		if ((obj instanceof SCorpusGraph)||(obj instanceof SDocumentGraph)) 
		{
			saveResource(obj, outputURI, resourceSet);
		} 
		//if it is a SaltProject, different URIs for the different components of the project are needed
		else if (obj instanceof SaltProject) 
		{
			for (int corpIndex=0;corpIndex<((SaltProject)obj).getSCorpusGraphs().size();corpIndex++) {
			//for (SCorpusGraph sCorpusGraph:((SaltProject)obj).getSCorpusGraphs()) {
				SCorpusGraph sCorpusGraph = ((SaltProject)obj).getSCorpusGraphs().get(corpIndex);
				URI corpURI = outputURI.appendSegments((String[])sCorpusGraph.getSElementId().getSElementPath().segmentsList().toArray());
				saveResource(sCorpusGraph, corpURI.appendFileExtension("dot"), resourceSet);
				for (int docIndex=0;docIndex<sCorpusGraph.getSDocuments().size();docIndex++) {
				//for (SDocument sDocument:sCorpusGraph.getSDocuments()) {
					SDocument sDocument = sCorpusGraph.getSDocuments().get(docIndex);
					URI docURI = corpURI.appendSegments((String[])sDocument.getSDocumentGraph().getSElementId().getSElementPath().segmentsList().toArray());
					saveResource(sDocument.getSDocumentGraph(), docURI.appendFileExtension("dot"), resourceSet);
				}
			}
		} 
		else {
			throw new SaltResourceException("Cannot save Salt model to DOT format, because object is neither SCorpusGraph, SDocumentGraph nor SaltProject object. The given object is of type: '"+obj.getClass()+"'.");
		} 
	}
	
	/**
	 * Prints a given structure by sElementId to a dot file given by outputURI.
	 * @param sElementId
	 * @param outputURI
	 */
	public void salt2Dot(SElementId sElementId, URI outputURI)
	{
		if (sElementId==null) {
			throw new SaltResourceException("Cannot export salt model to dot, because the given SElementId-object is null.");
		}
		actualSalt2Dot(sElementId.getIdentifiableElement(), outputURI);
	}
	
	/**
	 * Prints a given SaltProject to a dot files given by outputURI.
	 * @param saltProject SaltProject to print
	 * @param outputURI
	 */
	public void salt2Dot(SaltProject saltProject, URI outputURI)
	{
		if (saltProject==null) {
			throw new SaltResourceException("Cannot export salt model to dot, because the salt project is null.");
		}
		actualSalt2Dot(saltProject, outputURI);
	}
	
	/**
	 * Prints a given SCorpusGraph to a dot file given by outputURI.
	 * @param sDocGraph SCorpusGraph-object to print
	 * @param outputURI
	 */
	public void salt2Dot(SCorpusGraph sCorpusGraph, URI outputURI)
	{
		if (sCorpusGraph==null) {
			throw new SaltResourceException("Cannot export salt model to dot, because the corpus graph is null.");
		}
		salt2Dot(sCorpusGraph.getSElementId(), outputURI);
	}
	
	/**
	 * Prints a given SDocumentGraph to a dot file given by outputURI.
	 * @param sDocGraph SDocumentGraph-object to print
	 * @param outputURI
	 */
	public void salt2Dot(SDocumentGraph sDocumentGraph, URI outputURI)
	{
		if (sDocumentGraph==null) {
			throw new SaltResourceException("Cannot export salt model to dot, because the document graph is null.");
		}
		salt2Dot(sDocumentGraph.getSElementId(), outputURI);
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		System.out.println("=========================== Printing Salt-model in dot ===========================");
		System.out.println(	"Salt2DOT converts files into a dot format. Therefore it loads data ");
		System.out.println(	"from Salt model and exports them into output format.");
		System.out.println(	);
		System.out.println(	"Synopsis: Salt2DOT -i INPUT_FILE -o OUTPUT_FILE");
		System.out.println(	);
		try
		{
			String inputFile= null;
			String outputFile= null;
			for (int i=0; i< args.length; i++)
			{
				if (args[i].equalsIgnoreCase("-i"))
					inputFile= args[i+1];
				
				if (args[i].equalsIgnoreCase("-o"))
					outputFile= args[i+1];
			}	
			
			if (	(inputFile== null) ||
					(outputFile== null))
				throw new NullPointerException("Please give an input and an output-file.");
			System.out.println("reading from: "+inputFile+" writing to: "+outputFile);
			
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();
	
			//important for registering the package, because somehow this hasn�t happend
			resourceSet.getPackageRegistry().put(SDocumentStructurePackage.eINSTANCE.getNsURI(), SDocumentStructurePackage.eINSTANCE);
			// Register XML resource factory
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",new XMIResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCommon",new XMIResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("dot",new DOTResourceFactory());
	
			//load resource 
			Resource resource = resourceSet.createResource(URI.createFileURI(inputFile));
			
			if (resource== null)
				throw new NullPointerException("The resource is null.");
			resource.load(null);
			
			SDocumentGraph sDocGraph= null;
			if (resource.getContents().get(0) instanceof SDocumentGraph)
				sDocGraph= (SDocumentGraph) resource.getContents().get(0);
			else throw new NullPointerException("Sorry, in this version i can just work with SDocumentGraph-objects");
			
	//		for (Token token: document.getTokens())
	//		{
	//			System.out.println(token.getText());
	//			for (Annotation anno : token.getAnnotations())
	//				System.out.print("\t"+anno.getName()+": "+ anno.getValue()+"\t");
	//			System.out.println();
	//		}
			
			
			Resource resourceOut = resourceSet.createResource(URI.createFileURI(outputFile));
			resourceOut.getContents().add(sDocGraph);
			resourceOut.save(null);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("==================================================================================");
		}
	}

}
