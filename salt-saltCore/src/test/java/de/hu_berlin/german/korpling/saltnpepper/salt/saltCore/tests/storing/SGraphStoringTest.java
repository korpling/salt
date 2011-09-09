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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests.storing;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

public class SGraphStoringTest extends TestCase
{
	/**
	 * The fixture for this SNode test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SGraph fixture = null;

	protected void setFixture(SGraph fixture) {
		this.fixture = fixture;
	}

	protected SGraph getFixture() {
		return fixture;
	}

	protected void setUp() throws Exception {
		setFixture(SaltCoreFactory.eINSTANCE.createSGraph());
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
	 * graph:
	 * 		node1
	 * 	/			\
	 * node2		node3
	 * 				|
	 * 				node4
	 * 		
	 * layer1:	node1;
	 * layer2:	node2, node 2;
	 * layer3:	node4
	 * @throws IOException
	 */
	public void testStoring1() throws IOException
	{
		SGraph sGraph2= null;
		String tmpFileName= "_TMP/SGraph.saltCore";
		
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
		SNode node1= null;
		SNode node2= null;
		SNode node3= null;
		SNode node4= null;
		
		{//adding SNodes
			{//node 1
				node1= SaltCoreFactory.eINSTANCE.createSNode();
				this.getFixture().addSNode(node1);
				{//adding id
					String id= "salt:/node1";
					node1.setSId(id);
				}
				
				{//adding annotations
					SAnnotation sAnno= null;
					sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
					sAnno.setQName("ns1::annoName1");
					sAnno.setSValue("annoValue1");
					node1.addSAnnotation(sAnno);
					
					sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
					sAnno.setQName("ns2::annoName2");
					sAnno.setSValue("annoValue2");
					node1.addSAnnotation(sAnno);
				}
				
				{//adding Processing-Annotations
					SProcessingAnnotation sPAnno= null;
					sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
					sPAnno.setQName("procAnnos::annoName1");
					sPAnno.setSValue("pAnnoValue1");
					node1.addSProcessingAnnotation(sPAnno);
					
					sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
					sPAnno.setQName("procAnnos::annoName2");
					sPAnno.setSValue("pAnnoValue2");
					node1.addSProcessingAnnotation(sPAnno);
				}
			}
			{//node2
				node2= SaltCoreFactory.eINSTANCE.createSNode();
				this.getFixture().addSNode(node2);
				{//adding id
					String id= "salt:/node2";
					node2.setSId(id);
				}
			}
			{//node3
				node3= SaltCoreFactory.eINSTANCE.createSNode();
				this.getFixture().addSNode(node3);
				{//adding id
					String id= "salt:/node3";
					node1.setSId(id);
				}
			}
			{//node4
				node4= SaltCoreFactory.eINSTANCE.createSNode();
				this.getFixture().addSNode(node4);
				{//adding id
					String id= "salt:/node4";
					node1.setSId(id);
				}
			}
		}
		SRelation rel1= null;
		SRelation rel2= null;
		SRelation rel3= null;
		{//adding relations
			{//relation1
				rel1= SaltCoreFactory.eINSTANCE.createSRelation();
				{//adding id
					String id= "salt:/rel1";
					rel1.setSId(id);
				}
				this.getFixture().addSRelation(rel1);
				{//adding annotations
					SAnnotation sAnno= null;
					sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
					sAnno.setQName("ns1::annoName1");
					sAnno.setSValue("annoValue1");
					rel1.addSAnnotation(sAnno);
					
					sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
					sAnno.setQName("ns2::annoName2");
					sAnno.setSValue("annoValue2");
					rel1.addSAnnotation(sAnno);
				}
				
				{//adding Processing-Annotations
					SProcessingAnnotation sPAnno= null;
					sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
					sPAnno.setQName("procAnnos::annoName1");
					sPAnno.setSValue("pAnnoValue1");
					rel1.addSProcessingAnnotation(sPAnno);
					
					sPAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
					sPAnno.setQName("procAnnos::annoName2");
					sPAnno.setSValue("pAnnoValue2");
					rel1.addSProcessingAnnotation(sPAnno);
				}
				{//setting source node
					rel1.setSSource(node1);
				}
				{//setting target node
					rel1.setSTarget(node2);
				}
			}
			{//rel2
				rel2= SaltCoreFactory.eINSTANCE.createSRelation();
				{//adding id
					String id= "salt:/rel2";
					rel2.setSId(id);
				}
				this.getFixture().addSRelation(rel2);
				{//adding source and target
					rel2.setSSource(node1);
					rel2.setSSource(node3);
				}
			}
			{//rel3
				rel3= SaltCoreFactory.eINSTANCE.createSRelation();
				{//adding id
					String id= "salt:/rel3";
					rel3.setSId(id);
				}
				this.getFixture().addSRelation(rel3);
				{//adding source and target
					rel3.setSSource(node3);
					rel3.setSSource(node4);
				}
			}
			
			{//putting nodes and relations into layers
				//layer 1
				SLayer layer1= SaltCoreFactory.eINSTANCE.createSLayer();
				layer1.setSName("layer1");
				this.getFixture().getSLayers().add(layer1);
				layer1.getSNodes().add(node1);
				layer1.getSRelations().add(rel1);
				layer1.getSRelations().add(rel2);
				
				//layer 2
				SLayer layer2= SaltCoreFactory.eINSTANCE.createSLayer();
				layer2.setSName("layer2");
				this.getFixture().getSLayers().add(layer2);
				layer2.getSNodes().add(node2);
				layer2.getSNodes().add(node3);
				layer2.getSRelations().add(rel3);
				
				//layer 3
				SLayer layer3= SaltCoreFactory.eINSTANCE.createSLayer();
				layer3.setSName("layer3");
				this.getFixture().getSLayers().add(layer3);
				layer3.getSNodes().add(node4);
				
			}//putting nodes and relations into layers
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
			sGraph2= (SGraph) resource.getContents().get(0);
		}
		
		{//check if equals
			assertEquals(this.getFixture(), sGraph2);
		}
	}
}
