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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests.storing;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.Salt2DOT;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;
import org.junit.Ignore;
import org.junit.Test;

public class BinarySerializerTest extends TestCase {

	private SaltProject fixture= null;
	
	public SaltProject getFixture() {
		return fixture;
	}

	public void setFixture(SaltProject fixture) {
		this.fixture = fixture;
	}

	protected void setUp() throws Exception {
		super.setUp();
		this.setFixture(SaltFactory.eINSTANCE.createSaltProject());
		SampleGenerator.createCorpusStructure(this.getFixture());
		for (SDocument sDocument: this.getFixture().getSCorpusGraphs().get(0).getSDocuments())
		{//filling all of the documents in the corpus structure with document structure data	
			SampleGenerator.createSDocumentStructure(sDocument);
		}//filling all of the documents in the corpus structure with document structure data
	}
	
	public void testDummyTest()
	{
		// do not fail...
	}

//	public void testBinarySerialize() throws IOException
//	{
//		URI resourceURI= URI.createFileURI(System.getProperty("java.io.tmpdir")+"/SaltCommonTests/testBinarySerialize.bin");
//		System.out.println("resourceURI: "+ resourceURI);
//		Resource resource;
//	    resource = new BinaryResourceImpl(resourceURI);
//	    SDocument sDoc= SaltFactory.eINSTANCE.createSDocument();
//	    SampleGenerator.createSDocumentStructure(sDoc);
//	    
//	    Salt2DOT s2d= new Salt2DOT();
//	    s2d.salt2Dot(sDoc.getSDocumentGraph(), URI.createFileURI("d:/Test/saltBinary/original/doc.dot"));
//	    
////	    sDoc.saveSDocumentGraph(URI.createFileURI("d:/Test/saltBinary/original/doc.dot"));
//	    
//	    
//	    // add the project itself
//	    resource.getContents().add(sDoc.getSDocumentGraph());
//	    resource.save(null);
//	    System.out.println("=============================================================================================================================");
//	    BinaryResourceImpl resourceLoad = new BinaryResourceImpl();
//	    
//	    ResourceSet resourceSet = new ResourceSetImpl();
//	    resourceSet.getPackageRegistry().put(SaltCommonPackage.eINSTANCE.getNsURI(), SaltCommonPackage.eINSTANCE);
//
//	    resourceSet.getResources().add(resourceLoad);
//	    resourceLoad.setURI(resourceURI);
//	    resourceLoad.load(null);
//	    
////	    assertNotNull(resourceLoad.getContents());
////	    assertEquals(1, resourceLoad.getContents().size());
////	    assertTrue(resourceLoad.getContents().get(0) instanceof SaltProject);
//	   
//	    
//	    	    SDocumentGraph graph= (SDocumentGraph) resourceLoad.getContents().get(0);
//	    
////	    assertEquals(this.getFixture().getSCorpusGraphs().size(), saltProject.getSCorpusGraphs().size());
////	    for (int i=0; i< this.getFixture().getSCorpusGraphs().size();i++)
////	    {
////	    	assertEquals(this.getFixture().getSCorpusGraphs().get(i).getNodes().size(), saltProject.getSCorpusGraphs().get(i).getNodes().size());
////	    	assertEquals(this.getFixture().getSCorpusGraphs().get(i).getEdges().size(), saltProject.getSCorpusGraphs().get(i).getEdges().size());
////	    	assertEquals(this.getFixture().getSCorpusGraphs().get(i).getLabels().size(), saltProject.getSCorpusGraphs().get(i).getLabels().size());
////	    	assertEquals(this.getFixture().getSCorpusGraphs().get(i).getLayers().size(), saltProject.getSCorpusGraphs().get(i).getLayers().size());
////	    	assertEquals(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().size(), saltProject.getSCorpusGraphs().get(i).getSDocuments().size());
////	    	for (int y=0; y < this.getFixture().getSCorpusGraphs().get(i).getSDocuments().size(); y++)
////	    	{
////	    		assertNotNull(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph());
////	    		assertEquals(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getNodes().size(), saltProject.getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getNodes().size());
////	    		assertEquals(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getEdges().size(), saltProject.getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getEdges().size());
////	    		assertEquals(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getLayers().size(), saltProject.getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getLayers().size());
////	    		assertEquals(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getLabels().size(), saltProject.getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getLabels().size());
////	    	}
////	    }
//	    
//	    	    s2d= new Salt2DOT();
//	    	    s2d.salt2Dot(graph, URI.createFileURI("d:/Test/saltBinary/generated/doc.dot"));
//	    	    
//	    
////	    SDocument sDocument= SaltFactory.eINSTANCE.createSDocument();
////	    sDocument.setSDocumentGraph(graph);
////	    sDocument.saveSDocumentGraph(URI.createFileURI("d:/Test/saltBinary/generated/doc.dot"));
//	}
	
//	public void testBinarySerialize() throws IOException
//	{
//		URI dirURI= URI.createFileURI(System.getProperty("java.io.tmpdir")+"/SaltCommonTests/testBinarySerialize.bin");
//		URI resourceURI= URI.createFileURI(System.getProperty("java.io.tmpdir")+"/SaltCommonTests/testBinarySerialize.bin");
//		System.out.println("resourceURI: "+ resourceURI);
//		Resource resource;
//	    resource = new BinaryResourceImpl(resourceURI);
//	    
//	    Collection<Resource> resources= new Vector<Resource>();
//	    
//	    // add the project itself
//	    resource.getContents().add(this.getFixture());
//	    resources.add(resource);
//	    for (SDocument sDocument: this.getFixture().getSCorpusGraphs().get(0).getSDocuments())
//	    {
//	    	URI docURI= URI.createFileURI(System.getProperty("java.io.tmpdir")+"/SaltCommonTests/"+sDocument.getSName()+".bin");
//	    	
//	    	resource = new BinaryResourceImpl(docURI);
//	    	resources.add(resource);
//	    	resource.getContents().add(sDocument.getSDocumentGraph());
//	    	sDocument.setSDocumentGraph(null);
//	    }
//	    for (Resource resource2: resources)
//	    {
//	    	System.out.println("store to: "+ resource2.getURI());
//	    	resource2.save(null);
//	    }
//	    
//	    System.out.println("=============================================================================================================================");
//	    BinaryResourceImpl resourceLoad = new BinaryResourceImpl();
//	    
//	    ResourceSet resourceSet = new ResourceSetImpl();
//	    resourceSet.getPackageRegistry().put(SaltCommonPackage.eINSTANCE.getNsURI(), SaltCommonPackage.eINSTANCE);
//
//	    resourceSet.getResources().add(resourceLoad);
//	    resourceLoad.setURI(resourceURI);
//	    resourceLoad.load(null);
//	    
//	    assertNotNull(resourceLoad.getContents());
////	    assertEquals(1, resourceLoad.getContents().size());
//	    assertTrue(resourceLoad.getContents().get(0) instanceof SaltProject);
//	    SaltProject saltProject= (SaltProject) resourceLoad.getContents().get(0);
//	    
//	    assertEquals(this.getFixture().getSCorpusGraphs().size(), saltProject.getSCorpusGraphs().size());
//	    for (int i=0; i< this.getFixture().getSCorpusGraphs().size();i++)
//	    {
//	    	assertEquals(this.getFixture().getSCorpusGraphs().get(i).getNodes().size(), saltProject.getSCorpusGraphs().get(i).getNodes().size());
//	    	assertEquals(this.getFixture().getSCorpusGraphs().get(i).getEdges().size(), saltProject.getSCorpusGraphs().get(i).getEdges().size());
//	    	assertEquals(this.getFixture().getSCorpusGraphs().get(i).getLabels().size(), saltProject.getSCorpusGraphs().get(i).getLabels().size());
//	    	assertEquals(this.getFixture().getSCorpusGraphs().get(i).getLayers().size(), saltProject.getSCorpusGraphs().get(i).getLayers().size());
//	    	assertEquals(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().size(), saltProject.getSCorpusGraphs().get(i).getSDocuments().size());
//	    	for (int y=0; y < this.getFixture().getSCorpusGraphs().get(i).getSDocuments().size(); y++)
//	    	{
//	    		assertNotNull(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph());
//	    		assertEquals(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getNodes().size(), saltProject.getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getNodes().size());
//	    		assertEquals(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getEdges().size(), saltProject.getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getEdges().size());
//	    		assertEquals(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getLayers().size(), saltProject.getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getLayers().size());
//	    		assertEquals(this.getFixture().getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getLabels().size(), saltProject.getSCorpusGraphs().get(i).getSDocuments().get(y).getSDocumentGraph().getLabels().size());
//	    	}
//	    }
//	    
//	    this.getFixture().saveSaltProject_DOT(URI.createFileURI("d:/Test/saltBinary/original/"));
//	    saltProject.saveSaltProject_DOT(URI.createFileURI("d:/Test/saltBinary/generated/"));
//	    
//	    
//	}
}
