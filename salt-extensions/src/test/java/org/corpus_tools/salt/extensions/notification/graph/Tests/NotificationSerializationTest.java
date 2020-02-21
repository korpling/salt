/**
 * Copyright 2009 Humboldt-Universität zu Berlin
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
package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.corpus_tools.salt.impl.SaltFactoryImpl;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.tests.SaltTestsUtil;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotificationSerializationTest {

	@Before
	public void setUp() throws Exception {
		// make sure all calls in the functions under test are using notifications
		SaltFactory.setFactory(new SaltNotificationFactory());
	}

	@After
	public void cleanup() {
		SaltFactory.setFactory(new SaltFactoryImpl());
	}

	@Test
	public void testSerializeGraphWithDelegates() throws IOException {
		File tmpFile = SaltTestsUtil.getTempTestFolder("/testLoadStoreExampleProject");
		URI tmpPath = URI.createFileURI(tmpFile.getAbsolutePath());

		// create an keep original template in memory
		SaltProject template = SampleGenerator.createSaltProject();
		template.setName(null);

		// save -> load -> save -> load
		template.saveSaltProject(tmpPath);
		SaltProject loaded = SaltUtil.loadCompleteSaltProject(tmpPath);
		loaded.saveSaltProject(tmpPath);
		loaded = SaltUtil.loadCompleteSaltProject(tmpPath);

		assertEquals(1, template.getCorpusGraphs().size());

		// compare corpus graphs
		assertEquals(1, loaded.getCorpusGraphs().size());
		Set<Difference> corpusGraphDiff = SaltUtil.compare(template).with(loaded)
				.useOption(DiffOptions.OPTION_IGNORE_ID, false).andFindDiffs();
		assertEquals(0, corpusGraphDiff.size());

		// compare documents
		List<SDocument> templateDocs = template.getCorpusGraphs().get(0).getDocuments();
		List<SDocument> loadedDocs = loaded.getCorpusGraphs().get(0).getDocuments();
		assertEquals(templateDocs.size(), loadedDocs.size());
		for (int i = 0; i < templateDocs.size(); i++) {
			SDocumentGraph templateDocGraph = templateDocs.get(i).getDocumentGraph();
			SDocumentGraph loadedDocGraph = loadedDocs.get(i).getDocumentGraph();
			Set<Difference> docDiff = SaltUtil.compare(templateDocGraph).with(loadedDocGraph).andFindDiffs();
			assertEquals(0, docDiff.size());

			// Check that layers have survived the saving and loading cycles
			List<SLayer> loadedLayers = new ArrayList<>(loadedDocGraph.getLayers());
			assertEquals(2, loadedLayers.size());
			loadedLayers.sort(new Comparator<SLayer>() {
				@Override
				public int compare(SLayer o1, SLayer o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			assertEquals(11, loadedLayers.get(0).getNodes().size());
			assertEquals(12, loadedLayers.get(1).getNodes().size());
		}
	}

}