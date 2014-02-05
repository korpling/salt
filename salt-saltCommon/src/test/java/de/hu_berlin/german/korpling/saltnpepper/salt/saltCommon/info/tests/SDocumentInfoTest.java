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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.info.tests;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.info.SDocumentInfo;
//import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.SDocumentInfo.InfoEntry;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;


public class SDocumentInfoTest extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		SCorpusGraph sgraph = SampleGenerator.createCorpusStructure_simple();
		SampleGenerator.createSDocument_simpleLayeredDocument(sgraph.getSDocuments().get(0));
		
		fixture = SDocumentInfo.init(sgraph.getSDocuments().get(0).getSDocumentGraph());
		System.out.println("Setup: STokens=" + sgraph.getSDocuments().get(0).getSDocumentGraph().getSTokens().size());
		fixture.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSTokens());
		super.setUp();
	}
	
	protected SDocumentInfo fixture = null;
	/**
	 * Returns the fixture for this Graph test case.
	 */
	protected SDocumentInfo getFixture() {
		return fixture;
	}
	
	public void testSample() throws Exception {
		SCorpusGraph sgraph = SampleGenerator.createCorpusStructure_simple();
		SampleGenerator.createSDocumentStructure(sgraph.getSDocuments().get(0));
		SDocumentInfo sample = SDocumentInfo.init(sgraph.getSDocuments().get(0).getSDocumentGraph());
		sample.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSNodes());
		sample.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSRelations());
		sample.print();
		
	}

	public void testMerge(){
		SCorpusGraph sgraph = SampleGenerator.createCorpusStructure_simple();
		SampleGenerator.createSDocument_simpleLayeredDocument(sgraph.getSDocuments().get(0));
//		SampleGenerator.
		SDocumentInfo left  = SDocumentInfo.init(sgraph.getSDocuments().get(0).getSDocumentGraph());
		left.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSNodes());
		left.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSRelations());
		SDocumentInfo right  = SDocumentInfo.init(sgraph.getSDocuments().get(0).getSDocumentGraph());
		right.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSNodes());
		right.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSRelations());
		left.print();
		SDocumentInfo merged = SDocumentInfo.init("Merged");
		merged = SDocumentInfo.merge(merged, left);
		merged = SDocumentInfo.merge(merged, right);
		
		
		assertEquals(20, merged.getCount("SToken", SDocumentInfo.ALL_LAYERS));
		assertEquals(10, merged.getCount("SToken", "sLayer1"));
		left.print();
		merged.print();
	}

	public void testSDocumentInfo() {
	//FIXME
//		fail("Not yet implemented");
	}



	public void testGetEntries() {
		assertEquals(5, fixture.getCount("SToken",SDocumentInfo.NOSLAYER_TAG));
	}

	public void testAddAllObjects() {
		EList<SToken> tokenList = new BasicEList<SToken>();
		for (int i = 0; i < 5; i++) {
			SToken sToken= SaltFactory.eINSTANCE.createSToken();
			tokenList.add(sToken);
		}
		fixture.print();
		fixture.addAllObjects(tokenList);
		fixture.print();
		assertEquals(10, fixture.getCount("SToken",SDocumentInfo.NOSLAYER_TAG));
	}

	public void testAdd() {
		fixture.print();
		SToken sToken = SaltFactory.eINSTANCE.createSToken();
		fixture.add(sToken);
		fixture.print();
		assertEquals(6, fixture.getCount("SToken", SDocumentInfo.NOSLAYER_TAG));
	}


	public void testGetLayerNames() {
		Collection<String> layerNames = fixture.getLayerNames();
		assertEquals(2, layerNames.size());
		for (String string : layerNames) {
			System.out.println("Layer: " + string);
			if(string.equals("sLayer1") ||
			   string.equals(SDocumentInfo.NOSLAYER_TAG)||
			   string.equals(SDocumentInfo.ALL_LAYERS) ||
			   string.equals("sLayer2")){
				
			}else{
				fail(string);
			}
		}
	}
	
	public void testMetaData() throws Exception {
		SCorpusGraph sgraph = SampleGenerator.createCompleteSaltproject().getSCorpusGraphs().get(0);
		SampleGenerator.createSDocument_simpleLayeredDocument(sgraph.getSDocuments().get(0));
		Map<String, String> metaMap = new HashMap<String, String>();
		metaMap.put("author", "Hans Würst");
		metaMap.put("title", "This is a title");
		for (Map.Entry<String, String> metaEntry : metaMap.entrySet()) {
			SampleGenerator.addMetaAnnotation(sgraph.getSDocuments().get(0).getSDocumentGraph(), metaEntry.getKey(),metaEntry.getValue());
		}
		
		SDocumentInfo annotated = SDocumentInfo.init(sgraph.getSDocuments().get(0).getSDocumentGraph());
		
//		SampleGenerator.addMetaAnnotation(sgraph.getSDocuments().get(0).getSDocumentGraph(), "year", "1989");
		SDocumentInfo annotated2 = SDocumentInfo.init(sgraph.getSDocuments().get(0).getSDocumentGraph());
		SDocumentInfo scorpus = SDocumentInfo.init("Test");
		annotated.addAllMetaData(sgraph.getSDocuments().get(0).getSDocumentGraph().getSMetaAnnotations());
		annotated.print();
		System.out.println(annotated.getMetaData().size());
		for (Entry<String, String> metaElement : annotated.getMetaData().entrySet()) {
			System.out.println(String.format("Metadata k=%s v=%s", metaElement.getKey(),metaElement.getValue()));
			assertTrue(metaMap.get(metaElement.getKey()).equals(metaElement.getValue()));
		}
		SDocumentInfo mergedMetaData = SDocumentInfo.merge(annotated, annotated2);
		mergedMetaData.print();
	}

//	public void testGetAllEntries() {
//		assertEquals(2, fixture.getAllEntries().size());
//	}

	public void testGetAnnotations() throws Exception {
		SCorpusGraph sgraph = SampleGenerator.createCorpusStructure();
		SampleGenerator.createSDocumentStructure(sgraph.getSDocuments().get(0));
		SDocumentInfo sample = SDocumentInfo.init(sgraph.getSDocuments().get(0).getSDocumentGraph());
		sample.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSNodes());
		sample.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSRelations());
		sample.print();
		Map<String, Integer> annos = sample.getCounts(SDocumentInfo.ALL_LAYERS);
		for (Entry<String, Integer> annoType : annos.entrySet()) {
			Map<String, Integer> annoNames = sample.getCounts(SDocumentInfo.ALL_LAYERS,annoType.getKey());
			for (Entry<String, Integer> annoValue : annoNames.entrySet()) {
				Map<String, Integer> annoValues = sample.getCounts(SDocumentInfo.ALL_LAYERS,annoType.getKey(),annoValue.getKey());
				System.out.println(String.format("Annotation: Layer=%s, annotype=%s, annoName=%s, annoOcc=%s", SDocumentInfo.ALL_LAYERS, annoType.getKey(),annoValue.getKey(),annoValue.getValue() ));
			}
		}
	}
	
	public void testGetCounts() throws Exception {
		SCorpusGraph sgraph = SampleGenerator.createCorpusStructure_simple();
		SampleGenerator.createSDocumentStructure(sgraph.getSDocuments().get(0));
		SDocumentInfo sample = SDocumentInfo.init(sgraph.getSDocuments().get(0).getSDocumentGraph());
		sample.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSNodes());
		sample.addAllObjects(sgraph.getSDocuments().get(0).getSDocumentGraph().getSRelations());
		
		Map<String, Integer> test = sample.getCounts(SDocumentInfo.ALL_LAYERS, "SSpan", "Inf-Struct" );
		assertEquals(2, test.size());
		assertEquals(new Integer(1), (Integer) test.get("topic")); 
		assertEquals(new Integer(1), (Integer) test.get("contrast-focus")); 
	}
}
