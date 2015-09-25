package de.hu_berlin.u.saltnpepper.salt.util.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.samples.SampleGenerator;
import de.hu_berlin.u.saltnpepper.salt.tests.SaltTestsUtil;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

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
	 * {@link SampleGenerator#createInformationStructureAnnotations(SDocument)}</li>
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
	 * 
	 */
	@Test
	public void testLoadStore_SaltProject(){
		SaltProject project= SaltFactory.createSaltProject();
		
		//create two corpus structures
		SampleGenerator.createCorpusStructure(project);
		SampleGenerator.createCorpusStructure(project);
		
		File tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/saltProject/"+SaltUtil.FILE_SALT_PROJECT);
		SaltUtil.saveSaltProject(project, URI.createFileURI(tmpFile.getAbsolutePath()));
		SaltProject loaded= SaltUtil.loadSaltProject(URI.createFileURI(tmpFile.getAbsolutePath()));
		
		assertEquals(project.getCorpusGraphs().size(), loaded.getCorpusGraphs().size());
		assertEquals(project.getCorpusGraphs().get(0).getNodes().size(), loaded.getCorpusGraphs().get(0).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(0).getRelations().size(), loaded.getCorpusGraphs().get(0).getRelations().size());
		assertEquals(project.getCorpusGraphs().get(1).getNodes().size(), loaded.getCorpusGraphs().get(1).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(1).getRelations().size(), loaded.getCorpusGraphs().get(1).getRelations().size());
		
		tmpFile = new File(SaltTestsUtil.getTempTestFolder("/testLoadStore") + "/saltProject2/");
		SaltUtil.saveSaltProject(project, URI.createFileURI(tmpFile.getAbsolutePath()));
		loaded= SaltUtil.loadSaltProject(URI.createFileURI(tmpFile.getAbsolutePath()));
		
		assertEquals(project.getCorpusGraphs().size(), loaded.getCorpusGraphs().size());
		assertEquals(project.getCorpusGraphs().get(0).getNodes().size(), loaded.getCorpusGraphs().get(0).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(0).getRelations().size(), loaded.getCorpusGraphs().get(0).getRelations().size());
		assertEquals(project.getCorpusGraphs().get(1).getNodes().size(), loaded.getCorpusGraphs().get(1).getNodes().size());
		assertEquals(project.getCorpusGraphs().get(1).getRelations().size(), loaded.getCorpusGraphs().get(1).getRelations().size());
	}
}
