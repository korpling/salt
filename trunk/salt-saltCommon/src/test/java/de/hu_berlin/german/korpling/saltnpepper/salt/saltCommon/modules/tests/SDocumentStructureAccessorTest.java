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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.tests.SDataSourceAccessorTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.tests.SDocumentStructureRootAccessorTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules.SDocumentStructureAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;

/**
 * @deprecated since Salt 1.1.3
 * @author Florian Zipser
 * {@link SDocumentStructureRootAccessorTest} and {@link SDataSourceAccessorTest}
 *
 */
@Deprecated
public class SDocumentStructureAccessorTest extends SDocumentStructureModuleTest 
{
	public SDocumentStructureAccessor getFixture() {
		return((SDocumentStructureAccessor)super.getFixture());
	} 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception 
	{
		setFixture(new SDocumentStructureAccessor());
		SDocumentGraph sDocGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sDocGraph);
	}
	
	/**
	 * 
	 * 		span1
	 * 		/		\
	 * 	tok1		tok2
	 * 	|			|
	 * 	This		is
	 */
	//copied
	public void testGetSText()
	{
		//text
		STextualDS sText= SaltCommonFactory.eINSTANCE.createSTextualDS();
		sText.setSText("This is a sample text.");
		this.getFixture().getSDocumentGraph().addSNode(sText);
		
		//tok1
		SToken tok1= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().getSDocumentGraph().addSNode(tok1);
		//tok2
		SToken tok2= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().getSDocumentGraph().addSNode(tok2);
		//textlRel1
		STextualRelation textRel1= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		textRel1.setSTextualDS(sText);
		textRel1.setSToken(tok1);
		textRel1.setSStart(0);
		textRel1.setSEnd(4);
		this.getFixture().getSDocumentGraph().addSRelation(textRel1);
		
		//textlRel1
		STextualRelation textRel2= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		textRel2.setSTextualDS(sText);
		textRel2.setSToken(tok2);
		textRel2.setSStart(5);
		textRel2.setSEnd(7);
		this.getFixture().getSDocumentGraph().addSRelation(textRel2);
		
		//span1 
		SSpan span= SaltCommonFactory.eINSTANCE.createSSpan();
		this.getFixture().getSDocumentGraph().addSNode(span);
		
		//spanRel1
		SSpanningRelation spanRel1= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
		spanRel1.setSSpan(span);
		spanRel1.setSToken(tok1);
		this.getFixture().getSDocumentGraph().addSRelation(spanRel1);
		
		//spanRel2
		SSpanningRelation spanRel2= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
		spanRel2.setSSpan(span);
		spanRel2.setSToken(tok2);
		this.getFixture().getSDocumentGraph().addSRelation(spanRel2);
		
		assertEquals("This", this.getFixture().getSOverlappedText(tok1));
		assertEquals("is", this.getFixture().getSOverlappedText(tok2));
		assertEquals("This is", this.getFixture().getSOverlappedText(span));
	}
	
	/**
	 * tests graph:
	 * 			struct2			
	 * 		/	/			\
	 * 	struct1	/			|		
	 * 	/	|	/			|
	 * 	|	span1			span2		
	 * 	|	/	\	/					\
	 * tok1		tok2		tok3		tok4		tok5
	 * 
	 * PR�s tok1-> tok2; tok3-> tok4; tok4->tok2
	 */
	//copied
	public void testGetRootsBySRelation()
	{
		SToken tok1= null;
		SToken tok2= null;
		SToken tok3= null;
		SToken tok4= null;
		SToken tok5= null;
		
		SSpan span1= null;
		SSpan span2= null;
		
		SStructure struct1= null;
		SStructure struct2= null;
		{//Token
			tok1= SaltCommonFactory.eINSTANCE.createSToken();
			tok1.setSName("tok1");
			this.getFixture().getSDocumentGraph().addSNode(tok1);
			assertEquals(tok1, this.getFixture().getSDocumentGraph().getSNode(tok1.getSId()));
			
			tok2= SaltCommonFactory.eINSTANCE.createSToken();
			tok2.setSName("tok2");
			this.getFixture().getSDocumentGraph().addSNode(tok2);
			assertEquals(tok2, this.getFixture().getSDocumentGraph().getSNode(tok2.getSId()));
			
			tok3= SaltCommonFactory.eINSTANCE.createSToken();
			tok3.setSName("tok3");
			this.getFixture().getSDocumentGraph().addSNode(tok3);
			assertEquals(tok3, this.getFixture().getSDocumentGraph().getSNode(tok3.getSId()));
			
			tok4= SaltCommonFactory.eINSTANCE.createSToken();
			tok4.setSName("tok4");
			this.getFixture().getSDocumentGraph().addSNode(tok4);
			assertEquals(tok4, this.getFixture().getSDocumentGraph().getSNode(tok4.getSId()));
			
			tok5= SaltCommonFactory.eINSTANCE.createSToken();
			tok5.setSName("tok5");
			this.getFixture().getSDocumentGraph().addSNode(tok5);
			assertEquals(tok5, this.getFixture().getSDocumentGraph().getSNode(tok5.getSId()));
		}//SToken
		{//SSpan
			span1= SaltCommonFactory.eINSTANCE.createSSpan();
			span1.setSName("span1");
			this.getFixture().getSDocumentGraph().addSNode(span1);
			assertEquals(span1, this.getFixture().getSDocumentGraph().getSNode(span1.getSId()));
			
			span2= SaltCommonFactory.eINSTANCE.createSSpan();
			span2.setSName("span2");
			this.getFixture().getSDocumentGraph().addSNode(span2);
			assertEquals(span2, this.getFixture().getSDocumentGraph().getSNode(span2.getSId()));
		}//SSpan
		
		{//SStructure
			struct1= SaltCommonFactory.eINSTANCE.createSStructure();
			struct1.setSName("struct1");
			this.getFixture().getSDocumentGraph().addSNode(struct1);
			assertEquals(struct1, this.getFixture().getSDocumentGraph().getSNode(struct1.getSId()));
			
			struct2= SaltCommonFactory.eINSTANCE.createSStructure();
			struct2.setSName("struct2");
			this.getFixture().getSDocumentGraph().addSNode(struct2);
			assertEquals(struct2, this.getFixture().getSDocumentGraph().getSNode(struct2.getSId()));
		}//SStructure
		
		{//SSpanningRelation
			SSpanningRelation sSpanRel= null;
			sSpanRel= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok1);
			sSpanRel.setSSpan(span1);
			this.getFixture().getSDocumentGraph().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSDocumentGraph().getSRelation(sSpanRel.getSId()));
			
			sSpanRel= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok2);
			sSpanRel.setSSpan(span1);
			this.getFixture().getSDocumentGraph().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSDocumentGraph().getSRelation(sSpanRel.getSId()));
			
			sSpanRel= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok2);
			sSpanRel.setSSpan(span2);
			this.getFixture().getSDocumentGraph().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSDocumentGraph().getSRelation(sSpanRel.getSId()));
			
			sSpanRel= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok4);
			sSpanRel.setSSpan(span2);
			this.getFixture().getSDocumentGraph().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSDocumentGraph().getSRelation(sSpanRel.getSId()));
		}//SSpanningRelation
		
		{//SDominanceRelation
			SDominanceRelation sDomRel= null;
			sDomRel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			sDomRel.setSStructure(struct1);
			sDomRel.setSStructuredTarget(tok1);
			this.getFixture().getSDocumentGraph().addSRelation(sDomRel);
			assertEquals(sDomRel, this.getFixture().getSDocumentGraph().getSRelation(sDomRel.getSId()));
			
			sDomRel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			sDomRel.setSStructure(struct1);
			sDomRel.setSStructuredTarget(span1);
			this.getFixture().getSDocumentGraph().addSRelation(sDomRel);
			assertEquals(sDomRel, this.getFixture().getSDocumentGraph().getSRelation(sDomRel.getSId()));
			
			sDomRel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			sDomRel.setSStructure(struct2);
			sDomRel.setSStructuredTarget(struct1);
			this.getFixture().getSDocumentGraph().addSRelation(sDomRel);
			assertEquals(sDomRel, this.getFixture().getSDocumentGraph().getSRelation(sDomRel.getSId()));
			
			sDomRel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			sDomRel.setSStructure(struct2);
			sDomRel.setSStructuredTarget(span1);
			this.getFixture().getSDocumentGraph().addSRelation(sDomRel);
			assertEquals(sDomRel, this.getFixture().getSDocumentGraph().getSRelation(sDomRel.getSId()));
			
			sDomRel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			sDomRel.setSStructure(struct2);
			sDomRel.setSStructuredTarget(span2);
			this.getFixture().getSDocumentGraph().addSRelation(sDomRel);
			assertEquals(sDomRel, this.getFixture().getSDocumentGraph().getSRelation(sDomRel.getSId()));
		}//SDominanceRelation
		
		{//SPointingRelation
			SPointingRelation sPRel= null;
			sPRel= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			sPRel.setSStructuredSource(tok1);
			sPRel.setSStructuredTarget(tok2);
			this.getFixture().getSDocumentGraph().addSRelation(sPRel);
			assertEquals(sPRel, this.getFixture().getSDocumentGraph().getSRelation(sPRel.getSId()));
			
			sPRel= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			sPRel.setSStructuredSource(tok3);
			sPRel.setSStructuredTarget(tok4);
			this.getFixture().getSDocumentGraph().addSRelation(sPRel);
			assertEquals(sPRel, this.getFixture().getSDocumentGraph().getSRelation(sPRel.getSId()));
			
			sPRel= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			sPRel.setSStructuredSource(tok4);
			sPRel.setSStructuredTarget(tok2);
			this.getFixture().getSDocumentGraph().addSRelation(sPRel);
			assertEquals(sPRel, this.getFixture().getSDocumentGraph().getSRelation(sPRel.getSId()));
		}//SPointingRelation
		
		{//print saltGraph to dot (just for testing)
//			Salt2DOT salt2Dot= new Salt2DOT();
//			salt2Dot.salt2Dot(this.getFixture().getSDocumentGraph(), URI.createFileURI("_TMP" + "/doc1.dot"));
		}
		
		EList<SNode> roots= null;
		{//check SSpanningRelation
			roots= new BasicEList<SNode>();
			roots.add(span1);
			roots.add(span2);
			assertTrue(roots.containsAll(this.getFixture().getRootsBySRelation(SSpanningRelation.class)));
			assertTrue(this.getFixture().getRootsBySRelation(SSpanningRelation.class).containsAll(roots));
		}//check SSpanningRelation
		
		{//check SDominanceRelation
			roots= new BasicEList<SNode>();
			roots.add(struct2);
			assertTrue(roots.containsAll(this.getFixture().getRootsBySRelation(SDominanceRelation.class)));
			assertTrue(this.getFixture().getRootsBySRelation(SDominanceRelation.class).containsAll(roots));
		}//check SDominanceRelation
		
		{//check SPointingRelation
			roots= new BasicEList<SNode>();
			roots.add(tok1);
			roots.add(tok3);
			assertTrue(roots.containsAll(this.getFixture().getRootsBySRelation(SPointingRelation.class)));
			assertTrue(this.getFixture().getRootsBySRelation(SPointingRelation.class).containsAll(roots));
		}//check SPointingRelation
	}
	
	/**
	 * Checks the method getRootsBySRelationSType().
	 * Just for SPointingRelation
	 */
	//copied
	public void testGetRootsBySRelationSTypePR1()
	{
		{//checking for SPointingRelation
			SNode node1= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node1);
			SNode node2= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node2);
			SNode node3= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node3);
			
			String type1= "type1";
			String type2= "type2";
			
			SPointingRelation rel1= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel1.addSType(type1);
			rel1.setSSource(node1);
			rel1.setSTarget(node2);
			this.getFixture().getSDocumentGraph().addSRelation(rel1);
			
			SPointingRelation rel2= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel2.addSType(type2);
			rel2.setSSource(node2);
			rel2.setSTarget(node1);
			this.getFixture().getSDocumentGraph().addSRelation(rel2);
			
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type1));
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type2));
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).size());
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type2).size());
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).contains(node1));
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type2).contains(node2));
		}//checking for SPointingRelation
	}
	
	/**
	 * Checks the method getRootsBySRelationSType().
	 * Just for SPointingRelation
	 */
	//copied
	public void testGetRootsBySRelationSTypePR2()
	{
		{//checking for SPointingRelation
			SNode node1= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node1);
			SNode node2= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node2);
			SNode node3= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node3);
			
			String type1= "type1";
			String type2= "type2";
			
			SPointingRelation rel1= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel1.addSType(type1);
			rel1.setSSource(node1);
			rel1.setSTarget(node2);
			this.getFixture().getSDocumentGraph().addSRelation(rel1);
			
			SPointingRelation rel2= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel2.addSType(type1);
			rel2.setSSource(node2);
			rel2.setSTarget(node3);
			this.getFixture().getSDocumentGraph().addSRelation(rel2);
			
			SPointingRelation rel3= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel3.addSType(type2);
			rel3.setSSource(node3);
			rel3.setSTarget(node1);
			this.getFixture().getSDocumentGraph().addSRelation(rel3);
			
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type1));
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type2));
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).size());
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type2).size());
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).contains(node1));
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type2).contains(node3));
		}//checking for SPointingRelation
	}
	
	/**
	 * tests a chain of pr with the same type.
	 * node1 ->t1 node2 ->t1 node3
	 */
	//copied
	public void testGetRootsBySRelationSTypePR3()
	{
		{//checking for SPointingRelation
			SNode node1= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node1);
			SNode node2= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node2);
			SNode node3= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node3);
			
			String type1= "type1";
			
			SPointingRelation rel1= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel1.addSType(type1);
			rel1.setSSource(node1);
			rel1.setSTarget(node2);
			this.getFixture().getSDocumentGraph().addSRelation(rel1);
			
			SPointingRelation rel2= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel2.addSType(type1);
			rel2.setSSource(node2);
			rel2.setSTarget(node3);
			this.getFixture().getSDocumentGraph().addSRelation(rel2);
						
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type1));
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).size());
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).contains(node1));
		}//checking for SPointingRelation
	}
	
	/**
	 * tests a chain of pr with the same type. But all nodes have a second incoming relation of another type.
	 * node1 ->t1 node2 ->t1 node3
	 */
	//copied
	public void testGetRootsBySRelationSTypePR4()
	{
		{//checking for SPointingRelation
			SNode node1= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node1);
			SNode node2= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node2);
			SNode node3= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node3);
			
			SNode node4= SaltCommonFactory.eINSTANCE.createSStructure();
			this.getFixture().getSDocumentGraph().addSNode(node4);
			
			String type1= "type1";
			
			SPointingRelation rel1= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel1.addSType(type1);
			rel1.setSSource(node1);
			rel1.setSTarget(node2);
			this.getFixture().getSDocumentGraph().addSRelation(rel1);
			
			SPointingRelation rel2= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel2.addSType(type1);
			rel2.setSSource(node2);
			rel2.setSTarget(node3);
			this.getFixture().getSDocumentGraph().addSRelation(rel2);
			
			SDominanceRelation dom1= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			dom1.setSSource(node4);
			dom1.setSTarget(node1);
			this.getFixture().getSDocumentGraph().addSRelation(dom1);
			
			SDominanceRelation dom2= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			dom2.setSSource(node4);
			dom2.setSTarget(node2);
			this.getFixture().getSDocumentGraph().addSRelation(dom2);
			
			SDominanceRelation dom3= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			dom3.setSSource(node4);
			dom3.setSTarget(node3);
			this.getFixture().getSDocumentGraph().addSRelation(dom3);
						
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type1));
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).size());
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).contains(node1));
		}//checking for SPointingRelation
	}
	
	/**
	 * tests a chain of pr with the same type, and one cycle pr with another type.
	 * node1 ->t1 node2 ->t1 node3 ->t1 node4 ->t2 node1
	 */
	//copied
	public void testGetRootsBySRelationSTypePR5()
	{
		{//checking for SPointingRelation
			SNode node1= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node1);
			SNode node2= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node2);
			SNode node3= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node3);
			SNode node4= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node4);
			
			String type1= "type1";
			String type2= "type2";
			
			SPointingRelation rel1= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel1.addSType(type1);
			rel1.setSSource(node1);
			rel1.setSTarget(node2);
			this.getFixture().getSDocumentGraph().addSRelation(rel1);
			
			SPointingRelation rel2= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel2.addSType(type1);
			rel2.setSSource(node2);
			rel2.setSTarget(node3);
			this.getFixture().getSDocumentGraph().addSRelation(rel2);
			
			SPointingRelation rel3= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel3.addSType(type1);
			rel3.setSSource(node3);
			rel3.setSTarget(node4);
			this.getFixture().getSDocumentGraph().addSRelation(rel3);
			
			SPointingRelation rel4= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel4.addSType(type2);
			rel4.setSSource(node4);
			rel4.setSTarget(node2);
			this.getFixture().getSDocumentGraph().addSRelation(rel4);
						
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type1));
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type2));
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).size());
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).size());
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).contains(node1));
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type2).contains(node4));
		}//checking for SPointingRelation
	}
	
	/**
	 * tests a chain of pr with the same type, except one, it has two types. And one cycle pr with 
	 * another type exists.
	 * node1 ->t1 node2 ->t1, t2 node3 ->t1 node4 ->t2 node1
	 */
	//copied
	public void testGetRootsBySRelationSTypePR6()
	{
		{//checking for SPointingRelation
			SNode node1= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node1);
			SNode node2= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node2);
			SNode node3= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node3);
			SNode node4= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(node4);
			
			String type1= "type1";
			String type2= "type2";
			String type3= "type3";
			
			SPointingRelation rel1= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel1.addSType(type1);
			rel1.setSSource(node1);
			rel1.setSTarget(node2);
			this.getFixture().getSDocumentGraph().addSRelation(rel1);
			
			SPointingRelation rel2= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel2.addSType(type1);
			rel2.addSType(type3);
			rel2.setSSource(node2);
			rel2.setSTarget(node3);
			this.getFixture().getSDocumentGraph().addSRelation(rel2);
			
			SPointingRelation rel3= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel3.addSType(type1);
			rel3.setSSource(node3);
			rel3.setSTarget(node4);
			this.getFixture().getSDocumentGraph().addSRelation(rel3);
			
			SPointingRelation rel4= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			rel4.addSType(type2);
			rel4.setSSource(node4);
			rel4.setSTarget(node2);
			this.getFixture().getSDocumentGraph().addSRelation(rel4);
						
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type1));
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type2));
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).containsKey(type3));
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).size());
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type2).size());
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type3).size());
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type1).contains(node1));
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type2).contains(node4));
			assertTrue(this.getFixture().getRootsBySRelationSType(SPointingRelation.class).get(type3).contains(node2));
		}//checking for SPointingRelation
	}
	
	/**
	 * tests a tree of dominance relations 
	 * 		struct1
	 * 	/	|		\		\
	 * tok1	tok2	tok3	struct2
	 * 						|		\
	 * 						tok4	tok5
	 */
	//copied
	public void testGetRootsBySRelationSTypeDR1()
	{
		{//checking for SPointingRelation
			SNode tok1= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(tok1);
			SNode tok2= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(tok2);
			SNode tok3= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(tok3);
			SNode tok4= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(tok4);
			SNode tok5= SaltCommonFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(tok5);
			
			SNode struct1= SaltCommonFactory.eINSTANCE.createSStructure();
			this.getFixture().getSDocumentGraph().addSNode(struct1);
			SNode struct2= SaltCommonFactory.eINSTANCE.createSStructure();
			this.getFixture().getSDocumentGraph().addSNode(struct2);
			
			String type1= "type1";
			
			SDominanceRelation rel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			rel.addSType(type1);
			rel.setSSource(struct1);
			rel.setSTarget(tok1);
			this.getFixture().getSDocumentGraph().addSRelation(rel);
			
			rel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			rel.addSType(type1);
			rel.setSSource(struct1);
			rel.setSTarget(tok2);
			this.getFixture().getSDocumentGraph().addSRelation(rel);
			
			rel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			rel.addSType(type1);
			rel.setSSource(struct1);
			rel.setSTarget(tok3);
			this.getFixture().getSDocumentGraph().addSRelation(rel);
			
			rel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			rel.addSType(type1);
			rel.setSSource(struct1);
			rel.setSTarget(struct2);
			this.getFixture().getSDocumentGraph().addSRelation(rel);
			
			rel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			rel.addSType(type1);
			rel.setSSource(struct2);
			rel.setSTarget(tok4);
			this.getFixture().getSDocumentGraph().addSRelation(rel);
			
			rel= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			rel.addSType(type1);
			rel.setSSource(struct2);
			rel.setSTarget(tok5);
			this.getFixture().getSDocumentGraph().addSRelation(rel);
			this.getFixture().getRootsBySRelationSType(SDominanceRelation.class);
			
			assertTrue(this.getFixture().getRootsBySRelationSType(SDominanceRelation.class).containsKey(type1));
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SDominanceRelation.class).get(type1).size());
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SDominanceRelation.class).get(type1).size());
			assertEquals(1, this.getFixture().getRootsBySRelationSType(SDominanceRelation.class).get(type1).size());
			assertTrue(this.getFixture().getRootsBySRelationSType(SDominanceRelation.class).get(type1).contains(struct1));
		}//checking for SPointingRelation
	}
	
	//copied
	public void testGetSTokensSortedByText()
	{
		EList<SToken> sTokens= new BasicEList<SToken>();
		
		STextualRelation sTextualRelation= null;
		
		SToken sToken1= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().getSDocumentGraph().addSNode(sToken1);
		sTextualRelation= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		sTextualRelation.setSToken(sToken1);
		sTextualRelation.setSStart(1);
		sTextualRelation.setSStart(3);
		this.getFixture().getSDocumentGraph().addSRelation(sTextualRelation);
		
		SToken sToken2= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().getSDocumentGraph().addSNode(sToken2);
		sTextualRelation= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		sTextualRelation.setSToken(sToken2);
		sTextualRelation.setSStart(0);
		sTextualRelation.setSStart(1);
		this.getFixture().getSDocumentGraph().addSRelation(sTextualRelation);
		
		SToken sToken3= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().getSDocumentGraph().addSNode(sToken3);
		sTextualRelation= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		sTextualRelation.setSToken(sToken3);
		sTextualRelation.setSStart(4);
		sTextualRelation.setSStart(5);
		this.getFixture().getSDocumentGraph().addSRelation(sTextualRelation);
		
		SToken sToken4= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().getSDocumentGraph().addSNode(sToken4);
		sTextualRelation= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		sTextualRelation.setSToken(sToken4);
		sTextualRelation.setSStart(2);
		sTextualRelation.setSStart(3);
		this.getFixture().getSDocumentGraph().addSRelation(sTextualRelation);
		
		SToken sToken5= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().getSDocumentGraph().addSNode(sToken5);
		sTextualRelation= SaltCommonFactory.eINSTANCE.createSTextualRelation();
		sTextualRelation.setSToken(sToken5);
		sTextualRelation.setSStart(3);
		sTextualRelation.setSStart(4);
		this.getFixture().getSDocumentGraph().addSRelation(sTextualRelation);
		
		sTokens.add(sToken2);
		sTokens.add(sToken1);
		sTokens.add(sToken4);
		sTokens.add(sToken5);
		sTokens.add(sToken3);
		
		//FIXME uncomment next lines and make the test run
//		assertTrue(sTokens.containsAll(this.getFixture().getSTokensSortedByText()));
//		assertTrue(this.getFixture().getSTokensSortedByText().containsAll(sTokens));
		for (SToken currSToken: sTokens)
		{
//			assertEquals(sTokens.indexOf(currSToken), this.getFixture().getSTokensSortedByText().indexOf(currSToken));
		}
	}
}
