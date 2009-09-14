package de.hub.corpling.salt.saltCore.tests.storing;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

public class SRelationStoringTest extends TestCase
{
	/**
	 * The fixture for this SNode test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SRelation fixture = null;

	protected void setFixture(SRelation fixture) {
		this.fixture = fixture;
	}

	protected SRelation getFixture() {
		return fixture;
	}

	protected void setUp() throws Exception {
		setFixture(SaltCoreFactory.eINSTANCE.createSRelation());
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
		SRelation sRel2= null;
		String tmpFileName= "_TMP/SRelation.saltCore";
		
		{//adding id
			String id= "salt:/rel1";
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
		
		{//save and reload
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register XML resource factory
			resourceSet.getPackageRegistry().put(SaltCorePackage.eINSTANCE.getNsURI(), SaltCorePackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("saltCore",new XMIResourceFactoryImpl());
			
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
			sRel2= (SRelation) resource.getContents().get(0);
		}
		
		{//check if equals
			assertEquals(this.getFixture(), sRel2);
		}
	}
}
