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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.storing;

import java.io.IOException;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs() <em>STextual DSs</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations() <em>STextual Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens() <em>STokens</em>}</li>
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
		setFixture(SDocumentStructureFactory.eINSTANCE.createSDocumentGraph());
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

	public void testStoring1() throws IOException
	{
		SDocumentGraph graph2= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		String tmpFileName= "_TMP/SDocumentGraph.saltCommon";
		{//adding id
			String id= "salt:/graph1";
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
		STextualDS text1= null;
		STextualDS text2= null;
		{//adding textualDS
			text1= SaltCommonFactory.eINSTANCE.createSTextualDS();
			text1.setId("text1");
			text1.setSText("This is text1.");
			this.getFixture().addSNode(text1);
			
			text2= SaltCommonFactory.eINSTANCE.createSTextualDS();
			text2.setId("text2");
			text2.setSText("This is text2.");
			this.getFixture().addSNode(text2);
		}
		SToken tok1= null;
		SToken tok2= null;
		SToken tok3= null;
		SToken tok4= null;
		{//adding tokens
			SAnnotation sAnno= null;
			
			tok1= SaltCommonFactory.eINSTANCE.createSToken();
			tok1.setId("tok1");
			this.getFixture().addSNode(tok1);
			sAnno= SaltCommonFactory.eINSTANCE.createSAnnotation();
			sAnno.setSName("pos");
			sAnno.setSValue("N");
			tok1.addSAnnotation(sAnno);
			
			tok2= SaltCommonFactory.eINSTANCE.createSToken();
			tok2.setId("tok2");
			this.getFixture().addSNode(tok2);
			sAnno= SaltCommonFactory.eINSTANCE.createSAnnotation();
			sAnno.setSName("pos");
			sAnno.setSValue("N");
			tok2.addSAnnotation(sAnno);
			
			tok3= SaltCommonFactory.eINSTANCE.createSToken();
			tok3.setId("tok3");
			this.getFixture().addSNode(tok3);
			
			tok4= SaltCommonFactory.eINSTANCE.createSToken();
			tok4.setId("tok4");
			this.getFixture().addSNode(tok4);
		}
		
		STextualRelation textRel1= null;
		STextualRelation textRel2= null;
		STextualRelation textRel3= null;
		STextualRelation textRel4= null;
		{//adding textualRelations
			SAnnotation sAnno= null;
			
			textRel1= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel1.setId("textRel1");
			textRel1.setSStart(0);
			textRel1.setSEnd(4);
			textRel1.setSTextualDS(text1);
			textRel1.setSToken(tok1);
			sAnno= SaltCommonFactory.eINSTANCE.createSAnnotation();
			sAnno.setSName("edgeType");
			sAnno.setSValue("k.a.");
			textRel1.addSAnnotation(sAnno);
			this.getFixture().addSRelation(textRel1);
			
			textRel2= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel2.setId("textRel2");
			textRel2.setSStart(0);
			textRel2.setSEnd(4);
			textRel2.setSTextualDS(text1);
			textRel2.setSToken(tok2);
			this.getFixture().addSRelation(textRel2);
			
			textRel3= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel3.setId("textRel3");
			textRel3.setSStart(0);
			textRel3.setSEnd(4);
			textRel3.setSTextualDS(text2);
			textRel3.setSToken(tok3);
			this.getFixture().addSRelation(textRel3);
			
			textRel4= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel4.setId("textRel4");
			textRel4.setSStart(0);
			textRel4.setSEnd(4);
			textRel4.setSTextualDS(text2);
			textRel4.setSToken(tok4);
			this.getFixture().addSRelation(textRel4);
		}
		
		{//save and reload
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register XML resource factory
			resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCommon",new XMIResourceFactoryImpl());
			
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
			graph2= (SDocumentGraph) resource.getContents().get(0);
		}
		
		{//check if equals
			//FIXME uncomment this, and make test work
			//assertEquals(this.getFixture(), graph2);
		}
	}
	
	/**
	 * Tests storing and reloading of document graph. This document graph contains STextualDS-objects,
	 * SToken-objects,... SLayer-objects
	 * 
	 * tokens:	tok1	tok2	tok3	tok4
	 * 			|		|		|		|
	 * text1:	This 	is 		text1	.
	 * 
	 * layer1:	tok1, tok2, tok3
	 * layer2:	tok4
	 * @throws IOException
	 */
	public void testStoring2() throws IOException
	{
		SDocumentGraph graph2= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		String tmpFileName= "_TMP/SDocumentGraph.saltCommon";
		{//adding id
			String id= "salt:/graph1";
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
		STextualDS text1= null;
		STextualDS text2= null;
		{//adding textualDS
			text1= SaltCommonFactory.eINSTANCE.createSTextualDS();
			text1.setId("text1");
			text1.setSText("This is text1.");
			this.getFixture().addSNode(text1);
			
			text2= SaltCommonFactory.eINSTANCE.createSTextualDS();
			text2.setId("text2");
			text2.setSText("This is text2.");
			this.getFixture().addSNode(text2);
		}
		SToken tok1= null;
		SToken tok2= null;
		SToken tok3= null;
		SToken tok4= null;
		{//adding tokens
			SAnnotation sAnno= null;
			
			tok1= SaltCommonFactory.eINSTANCE.createSToken();
			tok1.setId("tok1");
			this.getFixture().addSNode(tok1);
			sAnno= SaltCommonFactory.eINSTANCE.createSAnnotation();
			sAnno.setSName("pos");
			sAnno.setSValue("N");
			tok1.addSAnnotation(sAnno);
			
			tok2= SaltCommonFactory.eINSTANCE.createSToken();
			tok2.setId("tok2");
			this.getFixture().addSNode(tok2);
			sAnno= SaltCommonFactory.eINSTANCE.createSAnnotation();
			sAnno.setSName("pos");
			sAnno.setSValue("N");
			tok2.addSAnnotation(sAnno);
			
			tok3= SaltCommonFactory.eINSTANCE.createSToken();
			tok3.setId("tok3");
			this.getFixture().addSNode(tok3);
			
			tok4= SaltCommonFactory.eINSTANCE.createSToken();
			tok4.setId("tok4");
			this.getFixture().addSNode(tok4);
		}
		
		{//adding layers
			SLayer sLayer1= SaltCommonFactory.eINSTANCE.createSLayer();
			sLayer1.setSName("layer1");
			this.getFixture().getSLayers().add(sLayer1);
			sLayer1.getSNodes().add(tok1);
			sLayer1.getSNodes().add(tok2);
			sLayer1.getSNodes().add(tok3);
			
			SLayer sLayer2= SaltCommonFactory.eINSTANCE.createSLayer();
			sLayer2.setSName("layer2");
			this.getFixture().getSLayers().add(sLayer2);
			sLayer2.getSNodes().add(tok4);
			
		}//adding layers
		
		STextualRelation textRel1= null;
		STextualRelation textRel2= null;
		STextualRelation textRel3= null;
		STextualRelation textRel4= null;
		{//adding textualRelations
			SAnnotation sAnno= null;
			
			textRel1= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel1.setId("textRel1");
			textRel1.setSStart(0);
			textRel1.setSEnd(4);
			textRel1.setSTextualDS(text1);
			textRel1.setSToken(tok1);
			sAnno= SaltCommonFactory.eINSTANCE.createSAnnotation();
			sAnno.setSName("edgeType");
			sAnno.setSValue("k.a.");
			textRel1.addSAnnotation(sAnno);
			this.getFixture().addSRelation(textRel1);
			
			textRel2= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel2.setId("textRel2");
			textRel2.setSStart(5);
			textRel2.setSEnd(7);
			textRel2.setSTextualDS(text1);
			textRel2.setSToken(tok2);
			this.getFixture().addSRelation(textRel2);
			
			textRel3= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel3.setId("textRel3");
			textRel3.setSStart(8);
			textRel3.setSEnd(13);
			textRel3.setSTextualDS(text2);
			textRel3.setSToken(tok3);
			this.getFixture().addSRelation(textRel3);
			
			textRel4= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel4.setId("textRel4");
			textRel4.setSStart(13);
			textRel4.setSEnd(14);
			textRel4.setSTextualDS(text2);
			textRel4.setSToken(tok4);
			this.getFixture().addSRelation(textRel4);
		}
		
		{//save and reload
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register XML resource factory
			resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCommon",new XMIResourceFactoryImpl());
			
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
			graph2= (SDocumentGraph) resource.getContents().get(0);
		}
		
		{//check if equals
			//FIXME uncomment the next line, and make test work
//			assertEquals(this.getFixture(), graph2);
		}
	}
	
	/**
	 * Tests storing and reloading of document graph. This document graph contains STextualDS-objects,
	 * SToken-objects,... SLayer-objects
	 * 
	 * structs:				struct1
	 * 					/			\
	 * spans:		span1			span2	
	 * 				/	\			/	\
	 * tokens:	tok1	tok2	tok3	tok4
	 * 			|		|		|		|
	 * text1:	This 	is 		text1	.
	 * 
	 * layer1:	tok1, tok2, tok3, tok4
	 * layer2:	span1, span2 + edges
	 * layer3:	struct1	+ edges
	 * @throws IOException
	 */
	public void testStoring3() throws IOException
	{
		SDocumentGraph graph2= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		String tmpFileName= "_TMP/SDocumentGraph.saltCommon";
		{//adding id
			String id= "salt:/graph1";
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
		STextualDS text1= null;
		STextualDS text2= null;
		{//adding textualDS
			text1= SaltCommonFactory.eINSTANCE.createSTextualDS();
			text1.setId("text1");
			text1.setSText("This is text1.");
			this.getFixture().addSNode(text1);
			
			text2= SaltCommonFactory.eINSTANCE.createSTextualDS();
			text2.setId("text2");
			text2.setSText("This is text2.");
			this.getFixture().addSNode(text2);
		}
		SToken tok1= null;
		SToken tok2= null;
		SToken tok3= null;
		SToken tok4= null;
		{//adding tokens
			SAnnotation sAnno= null;
			
			tok1= SaltCommonFactory.eINSTANCE.createSToken();
			tok1.setId("tok1");
			this.getFixture().addSNode(tok1);
			sAnno= SaltCommonFactory.eINSTANCE.createSAnnotation();
			sAnno.setSName("pos");
			sAnno.setSValue("N");
			tok1.addSAnnotation(sAnno);
			
			tok2= SaltCommonFactory.eINSTANCE.createSToken();
			tok2.setId("tok2");
			this.getFixture().addSNode(tok2);
			sAnno= SaltCommonFactory.eINSTANCE.createSAnnotation();
			sAnno.setSName("pos");
			sAnno.setSValue("N");
			tok2.addSAnnotation(sAnno);
			
			tok3= SaltCommonFactory.eINSTANCE.createSToken();
			tok3.setId("tok3");
			this.getFixture().addSNode(tok3);
			
			tok4= SaltCommonFactory.eINSTANCE.createSToken();
			tok4.setId("tok4");
			this.getFixture().addSNode(tok4);
		}
		
		STextualRelation textRel1= null;
		STextualRelation textRel2= null;
		STextualRelation textRel3= null;
		STextualRelation textRel4= null;
		{//adding textualRelations
			SAnnotation sAnno= null;
			
			textRel1= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel1.setId("textRel1");
			textRel1.setSStart(0);
			textRel1.setSEnd(4);
			textRel1.setSTextualDS(text1);
			textRel1.setSToken(tok1);
			sAnno= SaltCommonFactory.eINSTANCE.createSAnnotation();
			sAnno.setSName("edgeType");
			sAnno.setSValue("k.a.");
			textRel1.addSAnnotation(sAnno);
			this.getFixture().addSRelation(textRel1);
			
			textRel2= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel2.setId("textRel2");
			textRel2.setSStart(5);
			textRel2.setSEnd(7);
			textRel2.setSTextualDS(text1);
			textRel2.setSToken(tok2);
			this.getFixture().addSRelation(textRel2);
			
			textRel3= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel3.setId("textRel3");
			textRel3.setSStart(8);
			textRel3.setSEnd(13);
			textRel3.setSTextualDS(text2);
			textRel3.setSToken(tok3);
			this.getFixture().addSRelation(textRel3);
			
			textRel4= SaltCommonFactory.eINSTANCE.createSTextualRelation();
			textRel4.setId("textRel4");
			textRel4.setSStart(13);
			textRel4.setSEnd(14);
			textRel4.setSTextualDS(text2);
			textRel4.setSToken(tok4);
			this.getFixture().addSRelation(textRel4);
		}
		
		SSpan span1= null;
		SSpan span2= null;
		{//adding spans
			span1= SaltCommonFactory.eINSTANCE.createSSpan();
			this.getFixture().addSNode(span1);
			span2= SaltCommonFactory.eINSTANCE.createSSpan();
			this.getFixture().addSNode(span2);
		}//adding spans
		
		SSpanningRelation sSpanRel1= null;
		SSpanningRelation sSpanRel2= null;
		SSpanningRelation sSpanRel3= null;
		SSpanningRelation sSpanRel4= null;
		{//adding span relations
			//span1 -> tok1
			sSpanRel1= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			this.getFixture().addSRelation(sSpanRel1);
			sSpanRel1.setSToken(tok1);
			sSpanRel1.setSSpan(span1);
			
			//span1 -> tok2
			sSpanRel2= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			this.getFixture().addSRelation(sSpanRel2);
			sSpanRel2.setSToken(tok2);
			sSpanRel2.setSSpan(span1);
			
			//span2 -> tok3
			sSpanRel3= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			this.getFixture().addSRelation(sSpanRel3);
			sSpanRel3.setSToken(tok3);
			sSpanRel3.setSSpan(span2);
			
			//span2 -> tok4
			sSpanRel4= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			this.getFixture().addSRelation(sSpanRel4);
			sSpanRel4.setSToken(tok4);
			sSpanRel4.setSSpan(span2);
		}//adding span relations
		
		SStructure struct1= null;
		{//adding structs
			struct1= SaltCommonFactory.eINSTANCE.createSStructure();
			this.getFixture().addSNode(struct1);
		}//adding spans
		
		SDominanceRelation sDomRel1= null;
		SDominanceRelation sDomRel2= null;
		{//adding span relations
			//struct1 -> span1
			sDomRel1= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			this.getFixture().addSRelation(sDomRel1);
			sDomRel1.setSSource(struct1);
			sDomRel1.setSTarget(span1);
			
			//struct1 -> span
			sDomRel2= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			this.getFixture().addSRelation(sDomRel2);
			sDomRel2.setSSource(struct1);
			sDomRel2.setSTarget(span2);
		}
		
		{//adding layers
			//layer1:	tok1, tok2, tok3, tok4
			 SLayer sLayer1= SaltCommonFactory.eINSTANCE.createSLayer();
			sLayer1.setSName("layer1");
			this.getFixture().getSLayers().add(sLayer1);
			sLayer1.getSNodes().add(tok1);
			sLayer1.getSNodes().add(tok2);
			sLayer1.getSNodes().add(tok3);
			sLayer1.getSNodes().add(tok4);
			
			//layer2:	span1, span2 + edges
			SLayer sLayer2= SaltCommonFactory.eINSTANCE.createSLayer();
			sLayer2.setSName("layer2");
			this.getFixture().getSLayers().add(sLayer2);
			sLayer2.getSNodes().add(span1);
			sLayer2.getSNodes().add(span2);
			sLayer2.getSRelations().add(sSpanRel1);
			sLayer2.getSRelations().add(sSpanRel2);
			sLayer2.getSRelations().add(sSpanRel3);
			sLayer2.getSRelations().add(sSpanRel4);
			
			//layer3:	struct1	+ edges
			
			SLayer sLayer3= SaltCommonFactory.eINSTANCE.createSLayer();
			sLayer3.setSName("layer3");
			this.getFixture().getSLayers().add(sLayer3);
			sLayer3.getSNodes().add(struct1);
			sLayer3.getSRelations().add(sDomRel1);
			sLayer3.getSRelations().add(sDomRel2);
			
		}//adding layers
		
		{//save and reload
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register XML resource factory
			resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCommon",new XMIResourceFactoryImpl());
			
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
			graph2= (SDocumentGraph) resource.getContents().get(0);
		}
		
		{//check if equals
			//FIXME uncomment the next line, and make test work
//			assertEquals(this.getFixture(), graph2);
		}
	}

} //SDocumentGraphTest
