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
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs() <em>STextual DSs</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations() <em>STextual Relations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens() <em>STokens</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SDocumentGraphStoringTest extends TestCase {

	/**
	 * The fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocumentGraph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SDocumentGraphStoringTest.class);
	}

	/**
	 * Constructs a new SDocument Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraphStoringTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SDocumentGraph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocumentGraph getFixture() {
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
		setFixture(SaltFactory.eINSTANCE.createSDocumentGraph());
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
	 * Stores the given {@link SDocumentGraph} object and loads it again. The loaded {@link SDocumentGraph} will be put to a different instance
	 * and returned.
	 * @param sGraph2store
	 * @return
	 * @throws IOException 
	 */
	private SDocumentGraph storeAndLoadSDocumentGraph(SDocumentGraph sGraph2store, File tmpOutput) throws IOException
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
		SDocumentGraph sCorpGraph2= null; 
		sCorpGraph2= (SDocumentGraph) resource.getContents().get(0);
		return(sCorpGraph2);
	}
	
	/**
	 * Creates a corpus structure, stores it and loads it again. the loaded model will be compared,
	 * to the created one. The crested corpus structure only contains one {@link SCorpus} node.
	
	 * @throws IOException
	 */
	public void testStoring1() throws IOException
	{
		SDocumentGraph graph2= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		File tmpOutput= new File("./_TMP/SDocumentGraph1.salt");
		
		//adding sName
		String sName= "myDoc1";
		this.getFixture().setSName(sName);
		
		//adding id
		String id= "salt:/"+ sName;
		this.getFixture().setSId(id);
		
		//start: adding SCorpus
			sName= "myText1";
			STextualDS sText= SaltFactory.eINSTANCE.createSTextualDS();
			sText.setSName(sName);
			this.getFixture().addSNode(sText);
		//end: adding SCorpus
		
		//save and reload
		graph2= this.storeAndLoadSDocumentGraph(this.getFixture(), tmpOutput);
		
		//check if both graphs are equals
		assertEquals("The graph which was storeed to '"+tmpOutput.getAbsolutePath()+"' and loaded again is not equal any more, to the instance before.",this.getFixture(), graph2);

	}
	
	/**
	 * Creates a document structure, having a primary text with two words, tokenized into two tokens
	 * being annotated with pos an lemma. Both tokens are connected via a pointing relation.
	 * @throws IOException
	 */
	public void testStoring2() throws IOException
	{
		File tmpOutput= new File("_TMP/SDocumentGraph2.salt");
		
		STextualDS sPrimText= this.getFixture().createSTextualDS("A text.");
		SToken sTok1= this.getFixture().createSToken(sPrimText, 0, 1);
		SToken sTok2= this.getFixture().createSToken(sPrimText, 2, 6);
		sTok1.createSAnnotation(null, "pos", "pos1");
		sTok1.createSAnnotation(null, "lemma", "a");
		sTok2.createSAnnotation(null, "pos", "pos2");
		sTok2.createSAnnotation(null, "lemma", "text");
		
		SPointingRelation sPointRel= SaltFactory.eINSTANCE.createSPointingRelation();
		sPointRel.setSource(sTok2);
		sPointRel.setTarget(sTok2);
		this.getFixture().addSRelation(sPointRel);
		
		SDocumentGraph graph2= null;
		graph2= this.storeAndLoadSDocumentGraph(this.getFixture(), tmpOutput);
		
		//check if both graphs are equals
		assertEquals("The graph which was stored to '"+tmpOutput.getAbsolutePath()+"' and loaded again is not equal any more, to the instance before.",this.getFixture(), graph2);
	}

} //SDocumentGraphTest
