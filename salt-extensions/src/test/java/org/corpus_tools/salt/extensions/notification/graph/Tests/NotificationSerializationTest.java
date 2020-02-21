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
import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.SaltProject;
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
		SaltFactory.setFactory(new SaltNotificationFactory());
	}

	@After
	public void cleanup() {
		SaltFactory.setFactory(new SaltFactoryImpl());
	}


	@Test
	public void testSerializeGraphWithDelegates() throws IOException {

		// create template
		SaltProject template = SampleGenerator.createSaltProject();
		template.setName(null);
		assertEquals(1, template.getCorpusGraphs().size());

		SDocument doc1 = template.getCorpusGraphs().get(0).getDocuments().get(0);
		List<SToken> tokens = doc1.getDocumentGraph().getSortedTokenByText();
		doc1.getDocumentGraph().createSpan(tokens.get(0), tokens.get(1));

		// store other document
		File tmpFile = SaltTestsUtil.getTempTestFolder("/testLoadStoreExampleProject");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		template.saveSaltProject(path);

		// load project
		SaltProject loaded = SaltUtil.loadCompleteSaltProject(path);

		// compare document graphs
		assertEquals(1, loaded.getCorpusGraphs().size());
		Set<Difference> corpusGraphDiff = SaltUtil.compare(template).with(loaded)
				.useOption(DiffOptions.OPTION_IGNORE_ID, false).andFindDiffs();
		assertEquals(0, corpusGraphDiff.size());

		// compare documents
		List<SDocument> templateDocs = template.getCorpusGraphs().get(0).getDocuments();
		List<SDocument> loadedDocs = loaded.getCorpusGraphs().get(0).getDocuments();
		assertEquals(templateDocs.size(), loadedDocs.size());
		for (int i = 0; i < templateDocs.size(); i++) {
			Set<Difference> docDiff = SaltUtil.compare(templateDocs.get(i).getDocumentGraph())
					.with(loadedDocs.get(i).getDocumentGraph()).andFindDiffs();
			assertEquals(0, docDiff.size());
		}
	}

}