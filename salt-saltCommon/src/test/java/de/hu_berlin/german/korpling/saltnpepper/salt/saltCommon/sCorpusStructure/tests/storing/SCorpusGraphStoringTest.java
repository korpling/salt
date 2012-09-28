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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests.storing;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.exceptions.SaltCoreException;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SCorpusGraph#getSTextualDSs() <em>STextual DSs</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SCorpusGraph#getSTextualRelations() <em>STextual Relations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SCorpusGraph#getSTokens() <em>STokens</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SCorpusGraphStoringTest extends TestCase {

	/**
	 * The fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusGraph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SCorpusGraphStoringTest.class);
	}

	/**
	 * Constructs a new SDocument Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusGraphStoringTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SCorpusGraph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusGraph getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SCorpusStructureFactory.eINSTANCE.createSCorpusGraph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	/**
	 * Stores the given {@link SCorpusGraph} object and loads it again. The loaded {@link SCorpusGraph} will be put to a different instance
	 * and returned.
	 * @param sGraph2store
	 * @return
	 * @throws IOException 
	 */
	private SCorpusGraph storeAndLoadSCorpusGraph(SCorpusGraph sGraph2store, File tmpOutput) throws IOException
	{
		// create resource set and resource 
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML resource factory
		resourceSet.getPackageRegistry().put(SaltCommonPackage.eINSTANCE.getNsURI(), SaltCommonPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("salt",new XMIResourceFactoryImpl());
		
		URI outURI= URI.createFileURI(tmpOutput.getAbsolutePath());
		
		//save resources
		XMLResource resourceOut = (XMLResource)resourceSet.createResource(outURI);
		resourceOut.getContents().add(sGraph2store);
		resourceOut.setEncoding("UTF-8");
		resourceOut.save(null);
		
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(tmpOutput.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		SCorpusGraph sCorpGraph2= null; 
		sCorpGraph2= (SCorpusGraph) resource.getContents().get(0);
		return(sCorpGraph2);
	}
	
	/**
	 * Creates a corpus structure, stores it and loads it again. the loaded model will be compared,
	 * to the created one. The crested corpus structure only contains one {@link SCorpus} node.
	
	 * @throws IOException
	 */
	public void testStoring1() throws IOException
	{
		SCorpusGraph graph2= SaltCommonFactory.eINSTANCE.createSCorpusGraph();
		File tmpOutput= new File("./_TMP/SCorpusGraph1.salt");
		
		//adding sName
		String sName= "myGraph1";
		this.getFixture().setSName(sName);
		
		//adding id
		String id= "salt:/"+ sName;
		this.getFixture().setSId(id);
		
		//start: adding SCorpus
			sName= "myCorp1";
			SCorpus sCorpus= SaltFactory.eINSTANCE.createSCorpus();
			sCorpus.setSName(sName);
			this.getFixture().addSNode(sCorpus);
		//end: adding SCorpus
		
		//save and reload
		graph2= this.storeAndLoadSCorpusGraph(this.getFixture(), tmpOutput);
		
		//check if both graphs are equals
		assertEquals("The graph which was storeed to '"+tmpOutput.getAbsolutePath()+"' and loaded again is not equal any more, to the instance before.",this.getFixture(), graph2);

	}
	
	/**
	 * Creates a corpus structure, stores it and loads it again. the loaded model will be compared,
	 * to the created one.
	 * 
	 * 				corp1
	 * 			/			\
	 * 		corp2			corp4
	 * 		/	\			/		\
	 * 	corp3	doc2		doc3	doc4
	 *	/
	 *	doc1
	 * @throws IOException
	 */
	public void testStoring2() throws IOException
	{
		SCorpusGraph graph2= SaltCommonFactory.eINSTANCE.createSCorpusGraph();
		File tmpOutput= new File("_TMP/SCorpusGraph.salt");
		{//adding id
			String id= "salt:/myGraph1";
			this.getFixture().setSId(id);
		}
		
		{//adding annotations
			SAnnotation sAnno= null;
			sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
			sAnno.setQName("ns1::annoName1");
			sAnno.setSValue("annoValue1");
			this.getFixture().addSAnnotation(sAnno);
			
			sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
			sAnno.setQName("ns2::annoName2");
			sAnno.setSValue("annoValue2");
			this.getFixture().addSAnnotation(sAnno);
		}
		
		{//adding Processing-Annotations
			SProcessingAnnotation sPAnno= null;
			sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
			sPAnno.setQName("procAnnos::annoName1");
			sPAnno.setSValue("pAnnoValue1");
			this.getFixture().addSProcessingAnnotation(sPAnno);
			
			sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
			sPAnno.setQName("procAnnos::annoName2");
			sPAnno.setSValue("pAnnoValue2");
			this.getFixture().addSProcessingAnnotation(sPAnno);
		}
		{//creating content
			/**
			 * 				corp1
			 * 			/			\
			 * 		corp2			corp4
			 * 		/	\			/		\
			 * 	corp3	doc2		doc3	doc4
			 *	/
			 *	doc1
			 */
			
			SCorpus corp1= SCorpusStructureFactory.eINSTANCE.createSCorpus();
			this.getFixture().addSNode(corp1);
			SCorpus corp2= SCorpusStructureFactory.eINSTANCE.createSCorpus();
			this.getFixture().addSNode(corp2);
			SCorpus corp3= SCorpusStructureFactory.eINSTANCE.createSCorpus();
			this.getFixture().addSNode(corp3);
			SCorpus corp4= SCorpusStructureFactory.eINSTANCE.createSCorpus();
			this.getFixture().addSNode(corp4);
			
			//relations
			SCorpusRelation corpRel= null;
			
			corpRel= SCorpusStructureFactory.eINSTANCE.createSCorpusRelation();
			corpRel.setSSuperCorpus(corp1);
			corpRel.setSSubCorpus(corp2);
			this.getFixture().addSRelation(corpRel);
			
			corpRel= SCorpusStructureFactory.eINSTANCE.createSCorpusRelation();
			corpRel.setSSuperCorpus(corp2);
			corpRel.setSSubCorpus(corp3);
			this.getFixture().addSRelation(corpRel);
			
			corpRel= SCorpusStructureFactory.eINSTANCE.createSCorpusRelation();
			corpRel.setSSuperCorpus(corp1);
			corpRel.setSSubCorpus(corp4);
			this.getFixture().addSRelation(corpRel);
			
			//documents
			SDocument doc1= SCorpusStructureFactory.eINSTANCE.createSDocument();
			this.getFixture().addSNode(doc1);
			SDocument doc2= SCorpusStructureFactory.eINSTANCE.createSDocument();
			this.getFixture().addSNode(doc2);
			SDocument doc3= SCorpusStructureFactory.eINSTANCE.createSDocument();
			this.getFixture().addSNode(doc3);
			SDocument doc4= SCorpusStructureFactory.eINSTANCE.createSDocument();
			this.getFixture().addSNode(doc4);
			
			//relations
			SCorpusDocumentRelation corpDocRel= null;
			
			corpDocRel= SCorpusStructureFactory.eINSTANCE.createSCorpusDocumentRelation();
			corpDocRel.setSCorpus(corp3);
			corpDocRel.setSDocument(doc1);
			this.getFixture().addSRelation(corpDocRel);
			
			corpDocRel= SCorpusStructureFactory.eINSTANCE.createSCorpusDocumentRelation();
			corpDocRel.setSCorpus(corp2);
			corpDocRel.setSDocument(doc2);
			this.getFixture().addSRelation(corpDocRel);
			
			corpDocRel= SCorpusStructureFactory.eINSTANCE.createSCorpusDocumentRelation();
			corpDocRel.setSCorpus(corp4);
			corpDocRel.setSDocument(doc3);
			this.getFixture().addSRelation(corpDocRel);
			
			corpDocRel= SCorpusStructureFactory.eINSTANCE.createSCorpusDocumentRelation();
			corpDocRel.setSCorpus(corp4);
			corpDocRel.setSDocument(doc4);
			this.getFixture().addSRelation(corpDocRel);
		}
		
		
		graph2= this.storeAndLoadSCorpusGraph(this.getFixture(), tmpOutput);
		
		//check if both graphs are equals
		assertEquals("The graph which was storeed to '"+tmpOutput.getAbsolutePath()+"' and loaded again is not equal any more, to the instance before.",this.getFixture(), graph2);
	}

} //SCorpusGraphTest
