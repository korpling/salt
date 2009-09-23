/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.tests.storing;

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
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
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

	public void testStoring1() throws IOException
	{
		SCorpusGraph graph2= SaltCommonFactory.eINSTANCE.createSCorpusGraph();
		String tmpFileName= "_TMP/SCorpusGraph.saltCommon";
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
			graph2= (SCorpusGraph) resource.getContents().get(0);
		}
		
		{//check if equals
			assertEquals(this.getFixture(), graph2);
		}
	}

} //SCorpusGraphTest
