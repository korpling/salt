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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.tests;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import junit.framework.TestCase;
import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.SDocumentInfo;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.SDocumentInfo.InfoEntry;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

public class SDocumentInfoTest extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		SCorpusGraph sgraph = SampleGenerator.createCorpusStructure_simple();
		SampleGenerator.createSDocument_simpleLayeredDocument(sgraph.getSDocuments().get(0));
		
		fixture = SDocumentInfo.init(sgraph.getSDocuments().get(0).getSDocumentGraph());
		System.out.println(sgraph.getSDocuments().get(0).getSDocumentGraph().getSTokens().size());
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

	public void testMergeTotal() {
	//FIXME
//		fail("Not yet implemented");
	}

	public void testSDocumentInfo() {
	//FIXME
//		fail("Not yet implemented");
	}

//	public void testAddMetaData() {
//		SampleGenerator.addMetaAnnotation(fixture.sdocgraph, "metaData", "SDocumentInfo");
//		fixture.addMetaData(fixture.sdocgraph.getSDocument());
//		fixture.me
//	}

	public void testGetAnnoEntries() {
//		fail("Not yet implemented");
	}

	public void testGetEntries() {
		for (InfoEntry info : fixture.getEntries(SDocumentInfo.NOSLAYER_TAG)) {
			if(info.name.equals("SToken")){
				assertEquals(5, info.getCount());
			}
		}
		
	}

	public void testAddAllObjects() {
		EList<SToken> tokenList = new BasicEList<SToken>();
		for (int i = 0; i < 5; i++) {
			SToken sToken= SaltFactory.eINSTANCE.createSToken();
			tokenList.add(sToken);
		}
		fixture.addAllObjects(tokenList);
		for (InfoEntry info : fixture.getEntries(SDocumentInfo.NOSLAYER_TAG)) {
			if(info.name.equals("SToken")){
				assertEquals(10, info.getCount());
			}
		}
	}

	public void testAdd() {
		SToken sToken= SaltFactory.eINSTANCE.createSToken();
		fixture.add(sToken);
		for (InfoEntry info : fixture.getEntries(SDocumentInfo.NOSLAYER_TAG)) {
			if(info.name.equals("SToken")){
				assertEquals(6, info.getCount());
			}
		}
	}


	public void testGetLayerNames() {
		Collection<String> layerNames = fixture.getLayerNames();
		for (String string : layerNames) {
			if(string.equals("sLayer1") ||
			   string.equals(SDocumentInfo.NOSLAYER_TAG)||
			   string.equals(SDocumentInfo.ALL_LAYERS) ||
			   string.equals("sLayer2")){
				
			}else{
				fail(string);
			}
		}
	}

	public void testGetAllEntries() {
		assertEquals(2, fixture.getAllEntries().size());
	}

}
