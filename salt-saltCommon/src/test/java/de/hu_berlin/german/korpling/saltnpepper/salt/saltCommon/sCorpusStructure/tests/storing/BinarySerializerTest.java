package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests.storing;

import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

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
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SaltSample;

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
		SaltSample.createCorpusStructure(this.getFixture());
		for (SDocument sDocument: this.getFixture().getSCorpusGraphs().get(0).getSDocuments())
		{//filling all of the documents in the corpus structure with document structure data	
			SaltSample.createSDocumentStructure(sDocument);
		}//filling all of the documents in the corpus structure with document structure data
	}

	public void testBinarySerialize() throws IOException
	{
		URI resourceURI= URI.createFileURI(System.getProperty("java.io.tmpdir")+"/SaltCommonTests/testBinarySerialize.bin");
		System.out.println("resourceURI: "+ resourceURI);
		Resource resource;
	    resource = new BinaryResourceImpl(resourceURI);
	    SDocument sDoc= SaltFactory.eINSTANCE.createSDocument();
	    SaltSample.createSDocumentStructure(sDoc);
	    
	    Salt2DOT s2d= new Salt2DOT();
	    s2d.salt2Dot(sDoc.getSDocumentGraph(), URI.createFileURI("d:/Test/saltBinary/original/doc.dot"));
	    
//	    sDoc.saveSDocumentGraph(URI.createFileURI("d:/Test/saltBinary/original/doc.dot"));
	    
	    
	    // add the project itself
	    resource.getContents().add(sDoc.getSDocumentGraph());
	    resource.save(null);
	    System.out.println("=============================================================================================================================");
	    BinaryResourceImpl resourceLoad = new BinaryResourceImpl();
	    
	    ResourceSet resourceSet = new ResourceSetImpl();
	    resourceSet.getPackageRegistry().put(SaltCommonPackage.eINSTANCE.getNsURI(), SaltCommonPackage.eINSTANCE);

	    resourceSet.getResources().add(resourceLoad);
	    resourceLoad.setURI(resourceURI);
	    resourceLoad.load(null);
	    
//	    assertNotNull(resourceLoad.getContents());
//	    assertEquals(1, resourceLoad.getContents().size());
//	    assertTrue(resourceLoad.getContents().get(0) instanceof SaltProject);
	   
	    
	    	    SDocumentGraph graph= (SDocumentGraph) resourceLoad.getContents().get(0);
	    
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
	    
	    	    s2d= new Salt2DOT();
	    	    s2d.salt2Dot(graph, URI.createFileURI("d:/Test/saltBinary/generated/doc.dot"));
	    	    
	    
//	    SDocument sDocument= SaltFactory.eINSTANCE.createSDocument();
//	    sDocument.setSDocumentGraph(graph);
//	    sDocument.saveSDocumentGraph(URI.createFileURI("d:/Test/saltBinary/generated/doc.dot"));
	}
	
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
