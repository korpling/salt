package org.corpus_tools.salt.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

public class IsSaltXmlFileTest {
	private final URI baseURI = URI.createFileURI("./src/test/resources/isSaltXmlFile");
	private URI supposedlyXmlFile;
	private boolean result;

	private void when() {
		result = SaltUtil.isSaltXmlFile(new File(supposedlyXmlFile.toFileString()));
	}

	@Test
	public void whenFileIsCorpusStructure_thenReturnTrue() {
		supposedlyXmlFile = baseURI.appendSegment("saltProject.salt");
		when();
		assertThat(result).isTrue();
	}

	@Test
	public void whenFileIsDocumentStructure_thenReturnTrue() {
		supposedlyXmlFile = baseURI.appendSegment("documentStructure.salt");
		when();
		assertThat(result).isTrue();
	}

	@Test
	public void whenFileIsXmlFile_thenReturnFalse() {
		supposedlyXmlFile = baseURI.appendSegment("anyXmlFile.txt");
		when();
		assertThat(result).isFalse();
	}

	@Test
	public void whenFileIsNoXmlFile_thenReturnFalse() {
		supposedlyXmlFile = baseURI.appendSegment("anyTextFile.txt");
		when();
		assertThat(result).isFalse();
	}
}
