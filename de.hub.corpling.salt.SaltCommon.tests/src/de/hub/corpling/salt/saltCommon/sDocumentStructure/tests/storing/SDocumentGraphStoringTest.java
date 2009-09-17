/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests.storing;

import java.io.IOException;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

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
			sAnno.setFullName("ns1::annoName1");
			sAnno.setSValue("annoValue1");
			this.getFixture().addSAnnotation(sAnno);
			
			sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
			sAnno.setFullName("ns2::annoName2");
			sAnno.setSValue("annoValue2");
			this.getFixture().addSAnnotation(sAnno);
		}
		
		{//adding Processing-Annotations
			SProcessingAnnotation sPAnno= null;
			sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
			sPAnno.setFullName("procAnnos::annoName1");
			sPAnno.setSValue("pAnnoValue1");
			this.getFixture().addSProcessingAnnotation(sPAnno);
			
			sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
			sPAnno.setFullName("procAnnos::annoName2");
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
			assertEquals(this.getFixture(), graph2);
		}
	}

} //SDocumentGraphTest
