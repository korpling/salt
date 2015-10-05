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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
/**
 * This class provides static methods to store a Salt model the dot syntax (see: http://www.graphviz.org/) 
 * in a file. This dot graph can be visualized via the Graphviz toolbox (see: http://www.graphviz.org/)
 * into a bunch of graphical formats like jpeg, png, svg etc..
 * <br/>
 * This class provides a set of methods to store different parts of a Salt model:
 * <ul>
 * 	<li>{@link #salt2Dot(SaltProject, URI)} - to save an entire {@link SaltProject}</li>
 *  <li>{@link #salt2Dot(SCorpusGraph, URI)} - to store a {@link SCorpusGraph} and its contained entries</li>
 *  <li>{@link #salt2Dot(SDocumentGraph, URI) -  to store a {@link SDocumentGraph} and its contained entries</li>
 *  <li>{@link #salt2Dot(SElementId, URI) -  to store either a {@link SCorpusGraph} or a {@link SDocumentGraph} depending on the {@link SElementId}</li>
 * </ul>
 * 
 * @author Florian Zipser
 * @author hildebax
 */
@Deprecated  
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
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(SaltFactory.FILE_ENDING_DOT,new DOTResourceFactory());
		if (obj instanceof SCorpus)
		{
			SCorpus sCorpus= (SCorpus) obj;
			if (sCorpus.getSCorpusGraph()!= null)
				obj= sCorpus.getSCorpusGraph();
			else
				throw new SaltResourceException("Cannot save Salt model to DOT format, because the given "+SCorpus.class.getSimpleName()+" does not contain a "+SCorpusGraph.class.getSimpleName()+" object");
		}
		else if (obj instanceof SDocument)
		{
			SDocument sDocument= (SDocument) obj;
			if (sDocument.getSDocumentGraph()!= null)
				obj= sDocument.getSDocumentGraph();
			else
				throw new SaltResourceException("Cannot save Salt model to DOT format, because the given "+SDocument.class.getSimpleName()+" does not contain a "+SDocumentGraph.class.getSimpleName()+" object");
		}
		
		//if obj is a SDocumentGraph or SCorpusGraph, outputURI does not have to be changed 
		if ((obj instanceof SCorpusGraph)||(obj instanceof SDocumentGraph)) 
		{
			saveResource(obj, outputURI, resourceSet);
		} 
		//if it is a SaltProject, different URIs for the different components of the project are needed
		else if (obj instanceof SaltProject) 
		{
			Collection<SCorpusGraph> corpGraphs= Collections.synchronizedCollection(((SaltProject)obj).getSCorpusGraphs());
			
//			for (int corpIndex=0;corpIndex<((SaltProject)obj).getSCorpusGraphs().size();corpIndex++) {
			Integer corpIndex= 0;
			for (SCorpusGraph sCorpusGraph: corpGraphs) {
				URI corpUri = null;
				if (corpGraphs.size()>1){
					corpUri=outputURI.appendSegment(corpIndex.toString());
				}else{
					corpUri= outputURI;
				}				
				saveResource(sCorpusGraph, corpUri.appendFileExtension(SaltFactory.FILE_ENDING_DOT), resourceSet);
				
				//TODO check if this is really necessary
				//when calling saveResource(), the sCorpusGraph object will be attached to the resource and therefore removed from list of SaltProject, therefore the graph must be artificially added again  
				((SaltProject)obj).getSCorpusGraphs().add(corpIndex, sCorpusGraph);
				
				for (int docIndex=0;docIndex<sCorpusGraph.getSDocuments().size();docIndex++) 
				{
				//for (SDocument sDocument:sCorpusGraph.getSDocuments()) {
					SDocument sDocument = sCorpusGraph.getSDocuments().get(docIndex);
					if (sDocument.getSDocumentGraph()!= null)
					{
						URI docURI = corpUri.appendSegments((String[])sDocument.getSDocumentGraph().getSElementId().getSElementPath().segmentsList().toArray());
						SDocumentGraph sDocGraph= sDocument.getSDocumentGraph(); 
						saveResource(sDocGraph, docURI.appendFileExtension(SaltFactory.FILE_ENDING_DOT), resourceSet);
						//when calling saveResource(), the sCorpusGraph object will be attached to the resource and therefore removed from list of SaltProject, therefore the graph must be artificially added again  
						sDocument.setSDocumentGraph(sDocGraph);
					}
				}
				corpIndex++;
			}
		} 
		else {
			throw new SaltResourceException("Cannot save Salt model to DOT format, because object is neither "+SCorpusGraph.class.getSimpleName()+", "+SDocumentGraph.class.getSimpleName()+" nor "+SaltProject.class.getSimpleName()+" object. The given object is of type: '"+obj.getClass()+"'.");
		} 
	}
	
	/**
	 * Stores the container of the passed {@link SElementId} to a dot file located by the passed
	 * {@link URI}.
	 * @param sElementId 
	 * @param outputURI locating the place to store dot file
	 */
	public void salt2Dot(SElementId sElementId, URI outputURI)
	{
		if (sElementId==null) {
			throw new SaltResourceException("Cannot export salt model to dot, because the given SElementId-object is null.");
		}
		actualSalt2Dot(sElementId.getIdentifiableElement(), outputURI);
	}
	
	/**
	 * Stores the passed {@link SaltProject} to a dot file located by the passed
	 * {@link URI}.
	 * @param saltProject SaltProject to print
	 * @param outputURI locating the place to store dot file
	 */
	public void salt2Dot(SaltProject saltProject, URI outputURI)
	{
		if (saltProject==null) {
			throw new SaltResourceException("Cannot export salt model to dot, because the salt project is null.");
		}
		actualSalt2Dot(saltProject, outputURI);
	}
	
	/**
	 * Stores the passed {@link SCorpusGraph} to a dot file located by the passed
	 * {@link URI}.
	 * @param sDocGraph SCorpusGraph-object to print
	 * @param outputURI locating the place to store dot file
	 */
	public void salt2Dot(SCorpusGraph sCorpusGraph, URI outputURI)
	{
		if (sCorpusGraph==null) {
			throw new SaltResourceException("Cannot export salt model to dot, because the corpus graph is null.");
		}
		salt2Dot(sCorpusGraph.getSElementId(), outputURI);
	}
	
	/**
	 * Stores the passed {@link SDocumentGraph} to a dot file located by the passed
	 * {@link URI}.
	 * @param sDocGraph SDocumentGraph-object to print
	 * @param outputURI locating the place to store dot file
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
	
			//important for registering the package, because somehow this has't happend
			resourceSet.getPackageRegistry().put(SDocumentStructurePackage.eINSTANCE.getNsURI(), SDocumentStructurePackage.eINSTANCE);
			// Register XML resource factory
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",new XMIResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(SaltFactory.FILE_ENDING_SALT,new XMIResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(SaltFactory.FILE_ENDING_DOT,new DOTResourceFactory());
	
			//load resource 
			Resource resource = resourceSet.createResource(URI.createFileURI(inputFile));
			
			if (resource== null)
				throw new NullPointerException("The resource is null.");
			resource.load(null);
			
			SDocumentGraph sDocGraph= null;
			if (resource.getContents().get(0) instanceof SDocumentGraph)
				sDocGraph= (SDocumentGraph) resource.getContents().get(0);
			else throw new NullPointerException("Sorry, in this version i can just work with SDocumentGraph-objects");
			
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
