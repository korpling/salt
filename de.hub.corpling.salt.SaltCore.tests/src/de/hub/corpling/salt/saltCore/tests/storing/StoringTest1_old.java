//package de.hub.corpling.salt.saltCore.tests.storing;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//import org.eclipse.emf.common.util.BasicEList;
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.resource.Resource;
//import org.eclipse.emf.ecore.resource.ResourceSet;
//import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
//import org.eclipse.emf.ecore.xmi.XMLResource;
//import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
//
//import de.hub.corpling.salt.saltCore.SElementId;
//import de.hub.corpling.salt.saltCore.SGraph;
//import de.hub.corpling.salt.saltCore.SNode;
//import de.hub.corpling.salt.saltCore.SRelation;
//import de.hub.corpling.salt.saltCore.SaltCoreFactory;
//import de.hub.corpling.salt.saltCore.SaltCorePackage;
//
//import junit.framework.TestCase;
//
//public class StoringTest1_old extends TestCase 
//{	
//	/**
//	 * Checks saving and loading of CoreModel1
//	 * @throws IOException
//	 */
//	public void testSaving() throws IOException
//	{
//		URI sourceURI= URI.createFileURI("./data/storing/sources/CoreModel1.saltCore");
//		URI targetURI= URI.createFileURI("./data/storing/targets/CoreModel1.saltCore");
//		
//		this.SaveAndLoadResource(sourceURI, targetURI);
//		assertTrue(this.compareFiles(new File(sourceURI.toFileString()), new File(targetURI.toFileString())));
//	}
//	
//	protected void SaveAndLoadResource(URI sourceURI, URI targetURI) throws IOException
//	{
//		// create resource set and resource 
//		ResourceSet resourceSet = new ResourceSetImpl();
//
//		// Register XML resource factory
//		resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCore",new XMIResourceFactoryImpl());
//		
//		//load resource 
//		Resource resource = resourceSet.createResource(sourceURI);
//		
//		if (resource== null)
//			throw new NullPointerException("The resource is null.");
//		resource.load(null);
//		
//		SGraph sGraph= (SGraph) resource.getContents().get(0);
//				
//		XMLResource resourceOut = (XMLResource)resourceSet.createResource(targetURI);
//		resourceOut.getContents().add(sGraph);
//		resourceOut.setEncoding("UTF-8");
//		resourceOut.save(null);	
//	}
//	
//	/**
//	 * 
//	 * 
//	 * 		node1		node4
//	 * 		/	\	/		\
//	 * node2	node3		node5
//	 * @throws IOException 
//	 */
//	public void testStoring1() throws IOException
//	{
//		String tmpFileName= "./data/storing/targets/CoreModel1.saltCore";
//		SGraph sGraph= null;
//		SGraph sGraphNew= null;
//		{//create graph
//			sGraph= SaltCoreFactory.eINSTANCE.createSGraph();
//			sGraph.setId("graph1");
//			
//			//create nodes
//			String[] sNodeNames= {"sNode1", "sNode2", "sNode3", "sNode4", "sNode5"};
//			EList<SNode> sNodes= new BasicEList<SNode>(); 
//			SNode sNode= null;
//			for (String sNodeName: sNodeNames)
//			{
//				sNode= SaltCoreFactory.eINSTANCE.createSNode();
//				SElementId sElementId= SaltCoreFactory.eINSTANCE.createSElementId();
//				sElementId.setSId(sNodeName);
//				sNode.setSElementId(sElementId);
//				sNodes.add(sNode);
//				sGraph.addSNode(sNode);
//			}	
//			
//			//checking if all nodes are there
//			assertTrue(sGraph.getSNodes().containsAll(sNodes));
//			assertTrue(sNodes.containsAll(sGraph.getSNodes()));
//			
//			//create relations
//			SRelation sRel= null;
//			
//			//node1 -> node2
//			sRel= SaltCoreFactory.eINSTANCE.createSRelation();
//			sRel.setId("rel1");
//			sRel.setSSource(sNodes.get(0));
//			sRel.setSSource(sNodes.get(1));
//			sGraph.addSRelation(sRel);
//			assertEquals(sGraph.getSRelation(sRel.getSElementId()), sRel);
//			
//			//node1 -> node3
//			sRel= SaltCoreFactory.eINSTANCE.createSRelation();
//			sRel.setId("rel2");
//			sRel.setSSource(sNodes.get(0));
//			sRel.setSSource(sNodes.get(2));
//			sGraph.addSRelation(sRel);
//			assertEquals(sGraph.getSRelation(sRel.getSElementId()), sRel);
//			
//			//node4 -> node3
//			sRel= SaltCoreFactory.eINSTANCE.createSRelation();
//			sRel.setId("rel3");
//			sRel.setSSource(sNodes.get(3));
//			sRel.setSSource(sNodes.get(2));
//			sGraph.addSRelation(sRel);
//			assertEquals(sGraph.getSRelation(sRel.getSElementId()), sRel);
//			
//			//node4 -> node5
//			sRel= SaltCoreFactory.eINSTANCE.createSRelation();
//			sRel.setId("rel4");
//			sRel.setSSource(sNodes.get(3));
//			sRel.setSSource(sNodes.get(4));
//			sGraph.addSRelation(sRel);
//			assertEquals(sGraph.getSRelation(sRel.getSElementId()), sRel);
//			
//			System.out.println("graph Id: "+ sGraph.getId());
//		}
//		
//		{//save and reload
//			// create resource set and resource 
//			ResourceSet resourceSet = new ResourceSetImpl();
//
//			// Register XML resource factory
//			resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
//			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCore",new XMIResourceFactoryImpl());
//			
//			URI outURI= URI.createFileURI(tmpFileName);
//			System.out.println("out uri: "+ outURI);
//			
//			//save resources
//			XMLResource resourceOut = (XMLResource)resourceSet.createResource(outURI);
//			resourceOut.getContents().add(sGraph);
//			resourceOut.setEncoding("UTF-8");
//			resourceOut.save(null);
//			
//			
//			//load resource 
//			Resource resource = resourceSet.createResource(URI.createFileURI(tmpFileName));
//			
//			if (resource== null)
//				throw new NullPointerException("The resource is null.");
//			resource.load(null);
//			
//			sGraphNew= (SGraph) resource.getContents().get(0);
//		}
//		{//checking if models are equal
//			assertTrue(this.checkModels(sGraph, sGraphNew));
//		}
//	}
//	
//	/**
//	 * Checks if two models are equal.
//	 * @return true, if they are equal
//	 */
//	private Boolean checkModels(SGraph sGraph1, SGraph sGraph2)
//	{
//		assertNotNull(sGraph1);
//		assertNotNull(sGraph2);
//		assertEquals(sGraph1.getId(), sGraph2.getId());
//		assertEquals(sGraph1.getNumOfNodes(), sGraph2.getNumOfNodes());
//		assertEquals(sGraph1.getNumOfEdges(), sGraph2.getNumOfEdges());
//		
//		for (SNode node1: sGraph1.getSNodes())
//		{
//			boolean exists= false;
//			for (SNode node2: sGraph2.getSNodes())
//			{
//				if (node1.getSElementId().getSId().equalsIgnoreCase(node2.getSElementId().getSId()))
//				{
//					exists= true;
//					break;
//				}
//			}
//			assertTrue(exists);
//		}	
//		
//		for (SRelation rel1: sGraph1.getSRelations())
//		{
//			boolean exists= false;
//			for (SRelation rel2: sGraph2.getSRelations())
//			{
//				if (rel1.getSElementId().getSId().equalsIgnoreCase(rel2.getSElementId().getSId()))
//				{
//					exists= true;
//					assertEquals(rel1.getSSource().getSElementId().getSId(), rel2.getSSource().getSElementId().getSId());
//					assertEquals(rel1.getSTarget().getSElementId().getSId(), rel2.getSTarget().getSElementId().getSId());
//					break;
//				}
//			}
//			assertTrue(exists);
//		}
//		
//		return(true);
//	}
//	
//	
//	protected boolean compareFiles(File file1, File file2) throws IOException
//	{
//		boolean retVal= false;
//		
//		if ((file1== null) || (file2== null))
//			throw new NullPointerException("One of the files to compare are null.");
//		
//		String contentFile1= null;
//		String contentFile2= null;
//		BufferedReader brFile1= null;
//		BufferedReader brFile2= null;
//		try 
//		{
//			brFile1=  new BufferedReader(new FileReader(file1));
//			String line= null;
//			while (( line = brFile1.readLine()) != null)
//			{
//		          contentFile1= contentFile1+  line;
//		    }
//			brFile2=  new BufferedReader(new FileReader(file2));
//			line= null;
//			while (( line = brFile2.readLine()) != null)
//			{
//		          contentFile2= contentFile2+  line;
//		    }
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		finally 
//		{
//			brFile1.close();
//			brFile2.close();
//		} 
//		
//		if (contentFile1== null)
//		{
//			if (contentFile2== null)
//				retVal= true;
//			else retVal= false;
//		}	
//		else if (contentFile1.equals(contentFile2))
//			retVal= true;
//		return(retVal);
//	}
//
//}
