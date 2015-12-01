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
package org.corpus_tools.salt.util.persistence.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.tests.SaltTestsUtil;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.internal.persistence.SaltXML10Writer;
import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Persist_SaltXML10_Test {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Tests the loading and storing of primary data.
	 */
	@Test
	public void testLoadStore_DocumentGraph_text() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(template);
		// create other
		SDocument other = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(other);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_text.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);
		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests the loading and storing of primary data.
	 */
	@Test
	public void testLoadStore_DocumentGraph_text_specialCharacters() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		template.setDocumentGraph(SaltFactory.createSDocumentGraph());
		template.getDocumentGraph().createTextualDS("This is a text with linebreaks\n and tabs\t.");
		// test attributes
		template.getDocumentGraph().createAnnotation("mnys", "myname", "This is a \"text\" with linebreaks\n and tabs\t.");

		// create other
		SDocument other = SaltFactory.createSDocument();
		other.setDocumentGraph(SaltFactory.createSDocumentGraph());
		other.getDocumentGraph().createTextualDS("This is a text with linebreaks\n and tabs\t.");
		other.getDocumentGraph().createAnnotation("mnys", "myname", "This is a \"text\" with linebreaks\n and tabs\t.");

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_text_specialCharacters.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);
		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests the loading and storing of tokenization
	 */
	@Test
	public void testLoadStore_DocumentGraph_tokenization() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		SampleGenerator.createTokens(template);
		// create other
		SDocument other = SaltFactory.createSDocument();
		SampleGenerator.createTokens(other);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_tokenization.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);
		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests the loading and storing of:
	 * <ul>
	 * <li>{@link SampleGenerator#createTokens(SDocument)}</li>
	 * <li>{@link SampleGenerator#createMorphologyAnnotations(SDocument)}</li>
	 * <li>{@link SampleGenerator#createAnaphoricAnnotations(SDocument)}</li>
	 * <li>{@link SampleGenerator#createDependencies(SDocument)}</li>
	 * <li>
	 * {@link SampleGenerator#createInformationStructureAnnotations(SDocument)}
	 * </li>
	 * <li>{@link SampleGenerator#createSyntaxAnnotations(SDocument)}</li>
	 * </ul>
	 */
	@Test
	public void testLoadStore_DocumentGraph_multilayer() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		SampleGenerator.createTokens(template);
		SampleGenerator.createMorphologyAnnotations(template);
		SampleGenerator.createAnaphoricAnnotations(template);
		SampleGenerator.createDependencies(template);
		SampleGenerator.createInformationStructureAnnotations(template);
		SampleGenerator.createSyntaxAnnotations(template);
		// create other
		SDocument other = SaltFactory.createSDocument();
		SampleGenerator.createTokens(other);
		SampleGenerator.createMorphologyAnnotations(other);
		SampleGenerator.createAnaphoricAnnotations(other);
		SampleGenerator.createDependencies(other);
		SampleGenerator.createInformationStructureAnnotations(other);
		SampleGenerator.createSyntaxAnnotations(other);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_multilayer.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);

		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests the loading and storing of:
	 * <ul>
	 * <li>{@link SampleGenerator#createDialogue(SDocument)}</li>
	 * </ul>
	 */
	@Test
	public void testLoadStore_DocumentGraph_dialogue() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		SampleGenerator.createDialogue(template);
		// create other
		SDocument other = SaltFactory.createSDocument();
		SampleGenerator.createDialogue(other);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_dialogue.salt");

		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);
		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests the loading and storing of:
	 * <ul>
	 * <li>{@link SampleGenerator#createParallelData(SDocument)}</li>
	 * </ul>
	 */
	@Test
	public void testLoadStore_DocumentGraph_parallelData() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		SampleGenerator.createParallelData(template);
		// create other
		SDocument other = SaltFactory.createSDocument();
		SampleGenerator.createParallelData(other);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_parallel.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(other.getDocumentGraph(), path);

		// compare both document graphs
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);
		assertTrue(template.getDocumentGraph().isIsomorph(graph));
	}

	/**
	 * Tests persisting a SaltProject structure (without storing the
	 * SDocumentGraphs)
	 */
	@Test
	public void testLoadStore_SaltProjectOnlyStructure() {
		SaltProject project = SaltFactory.createSaltProject();

		// create two corpus structures
		SampleGenerator.createCorpusStructure(project);
		SampleGenerator.createCorpusStructure(project);

		String outFolder = SaltTestsUtil.getTempTestFolder("/testLoadStore_SaltProjectOnlyStructure") + "/saltProject";
		File tmpFile = new File(outFolder + "/" + SaltUtil.FILE_SALT_PROJECT);
		SaltUtil.saveSaltProject(project, URI.createFileURI(tmpFile.getAbsolutePath()));
		SaltProject loaded = SaltUtil.loadSaltProject(URI.createFileURI(tmpFile.getAbsolutePath()));

		assertEquals(project.getCorpusGraphs().size(), loaded.getCorpusGraphs().size());
		assertEquals(project.getCorpusGraphs().get(0).getNodes().size(), loaded.getCorpusGraphs().get(0).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(0).getRelations().size(), loaded.getCorpusGraphs().get(0).getRelations().size());
		assertEquals(project.getCorpusGraphs().get(1).getNodes().size(), loaded.getCorpusGraphs().get(1).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(1).getRelations().size(), loaded.getCorpusGraphs().get(1).getRelations().size());

		// make sure it's also working when storing it a second time to some
		// other location
		outFolder = SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/saltProject2";
		tmpFile = new File(outFolder);
		SaltUtil.saveSaltProject(project, URI.createFileURI(tmpFile.getAbsolutePath()));
		loaded = SaltUtil.loadSaltProject(URI.createFileURI(tmpFile.getAbsolutePath()));

		assertEquals(project.getCorpusGraphs().size(), loaded.getCorpusGraphs().size());
		assertEquals(project.getCorpusGraphs().get(0).getNodes().size(), loaded.getCorpusGraphs().get(0).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(0).getRelations().size(), loaded.getCorpusGraphs().get(0).getRelations().size());
		assertEquals(project.getCorpusGraphs().get(1).getNodes().size(), loaded.getCorpusGraphs().get(1).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(1).getRelations().size(), loaded.getCorpusGraphs().get(1).getRelations().size());
	}

	/**
	 * Tests persisting a SaltProject structure (with storing the
	 * SDocumentGraphs)
	 */
	@Test
	public void testLoadStore_SaltProjectWithStructure() {

		SaltProject project = SampleGenerator.createSaltProject();

		String outFolder = SaltTestsUtil.getTempTestFolder("/testLoadStore_SaltProjectWithStructure") + "/saltProject";
		File tmpFile = new File(outFolder + "/" + SaltUtil.FILE_SALT_PROJECT);
		SaltUtil.saveSaltProject(project, URI.createFileURI(tmpFile.getAbsolutePath()));
		SaltProject loaded = SaltUtil.loadSaltProject(URI.createFileURI(tmpFile.getAbsolutePath()));

		assertEquals(project.getCorpusGraphs().size(), loaded.getCorpusGraphs().size());
		assertEquals(project.getCorpusGraphs().get(0).getNodes().size(), loaded.getCorpusGraphs().get(0).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(0).getRelations().size(), loaded.getCorpusGraphs().get(0).getRelations().size());

		Assert.assertNotNull(loaded.getCorpusGraphs().get(0).getDocuments().get(0).getDocumentGraphLocation());
		Assert.assertNotNull(loaded.getCorpusGraphs().get(0).getDocuments().get(1).getDocumentGraphLocation());
		Assert.assertNotNull(loaded.getCorpusGraphs().get(0).getDocuments().get(2).getDocumentGraphLocation());
		Assert.assertNotNull(loaded.getCorpusGraphs().get(0).getDocuments().get(3).getDocumentGraphLocation());

		assertEquals(outFolder + "/rootCorpus/subCorpus1/doc1.salt", loaded.getCorpusGraphs().get(0).getDocuments().get(0).getDocumentGraphLocation().toFileString());
		assertEquals(outFolder + "/rootCorpus/subCorpus1/doc2.salt", loaded.getCorpusGraphs().get(0).getDocuments().get(1).getDocumentGraphLocation().toFileString());
		assertEquals(outFolder + "/rootCorpus/subCorpus2/doc3.salt", loaded.getCorpusGraphs().get(0).getDocuments().get(2).getDocumentGraphLocation().toFileString());
		assertEquals(outFolder + "/rootCorpus/subCorpus2/doc4.salt", loaded.getCorpusGraphs().get(0).getDocuments().get(3).getDocumentGraphLocation().toFileString());
	}

	/**
	 * Tests the loading and storing different data types.
	 */
	@Test
	public void testLoadStore_DocumentGraph_DataTypes() {
		// create template
		SDocument template = SaltFactory.createSDocument();
		template.setDocumentGraph(SaltFactory.createSDocumentGraph());

		template.getDocumentGraph().createFeature("test", "double", 1.2345);
		template.getDocumentGraph().createFeature("test", "float", 1.2345f);

		// store other document
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/DocumentGraph_DataTypes.salt");
		URI path = URI.createFileURI(tmpFile.getAbsolutePath());
		SaltUtil.saveDocumentGraph(template.getDocumentGraph(), path);

		// retrieve features
		SDocumentGraph graph = SaltUtil.loadDocumentGraph(path);

		Double d = graph.getFeature("test", "double").getValue_SFLOAT();
		assertEquals(1.2345d, d, 0.0d);

		Float f = graph.getFeature("test", "float").getValue_SFLOAT().floatValue();
		assertEquals(1.2345f, f, 0.0f);

	}
	
	/**
	 * Test reference generation when there is more than one content root.
	 * EMF reference paths are relative to the index of the root content object.
	 * If only one is included in an XML file "//" is used as a shortcut, but when
	 * having more than one content objects the references must look like "/0/", "/1/" etc.
	 */
	@Test
	public void testLoadStore_MultipleContentRoots()
	{

		SaltProject proj = SaltFactory.createSaltProject();
		SDocument doc1 = SaltFactory.createSDocument();
		SDocument doc2 = SaltFactory.createSDocument();

		SampleGenerator.createDocumentStructure(doc1);
		SampleGenerator.createDocumentStructure(doc2);

		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore_MultipleContentRoots") + "/MultipleContentRoots.salt");

		XMLOutputFactory outFactory = XMLOutputFactory.newFactory();
		try (FileOutputStream fos = new FileOutputStream(tmpFile)) {
			
			
			
			XMLStreamWriter xml = outFactory.createXMLStreamWriter(fos, "UTF-8");
			SaltXML10Writer writer = new SaltXML10Writer();
			
			xml.writeStartDocument("1.0");
			xml.writeCharacters("\n");
			writer.writeXMIRootElement(xml);

			// store all objects in one single file
			writer.writeObjects(xml, proj, doc1.getDocumentGraph(), doc2.getDocumentGraph());
			
			xml.writeEndDocument();

			// restore the objects
			URI path = URI.createFileURI(tmpFile.getAbsolutePath());
			List<Object> roots = SaltUtil.loadObjects(path);

			assertEquals(3, roots.size());
			assertTrue(roots.get(0) instanceof SaltProject);
			assertTrue(roots.get(1) instanceof SDocumentGraph);
			assertTrue(roots.get(2) instanceof SDocumentGraph);

			SDocumentGraph loadedDoc1 = (SDocumentGraph) roots.get(1);
			SDocumentGraph loadedDoc2 = (SDocumentGraph) roots.get(2);

			assertTrue(doc1.getDocumentGraph().isIsomorph(loadedDoc1));
			assertTrue(doc2.getDocumentGraph().isIsomorph(loadedDoc2));
		} catch (IOException | XMLStreamException ex) {
			Assert.assertNull(ex);
		}
}
	
}
