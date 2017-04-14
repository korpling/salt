package org.corpus_tools.salt.util.internal.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class IsSaltXmlFile {
	private static Logger LOG = LoggerFactory.getLogger(IsSaltXmlFile.class);
	private static final String CORPUS_STRUCTURE_MARKER = "<sCorpusGraphs>";
	private static final String DOCUMENT_STRUCTURE_MARKER = "sDocumentStructure";
	private final File supposedlyXmlFile;
	private final String firstXLines;

	public IsSaltXmlFile(File supposedlyXmlFile) {
		this.supposedlyXmlFile = supposedlyXmlFile;
		firstXLines = readFirstLines(10);
	}

	private String readFirstLines(final int numOfLinesToRead) {
		if (supposedlyXmlFile == null || !supposedlyXmlFile.exists()) {
			return null;
		}
		if (numOfLinesToRead < 1) {
			return null;
		}
		final StringBuilder fileContent = new StringBuilder();
		try (LineNumberReader reader = new LineNumberReader(
				new InputStreamReader(new FileInputStream(supposedlyXmlFile), Charsets.UTF_8))) {
			String line;
			boolean isFirstLine = true;
			while (((line = reader.readLine()) != null) && reader.getLineNumber() <= numOfLinesToRead) {
				if (!isFirstLine) {
					fileContent.append(System.lineSeparator());
				}
				isFirstLine = false;
				fileContent.append(line);
			}
		} catch (IOException e) {
			LOG.debug("Cannot read file '{}' to check whether it is a salt-xml file. ", supposedlyXmlFile);
			return null;
		}

		return fileContent.toString();
	}

	private boolean isCorpusStructure() {
		if (firstXLines.contains(CORPUS_STRUCTURE_MARKER)) {
			return true;
		}
		return false;
	}

	private boolean isDocumentStructure() {
		if (firstXLines.contains(DOCUMENT_STRUCTURE_MARKER)) {
			return true;
		}
		return false;
	}

	public boolean isSaltXmlFile() {
		if (supposedlyXmlFile == null || !supposedlyXmlFile.exists()) {
			return false;
		}
		if (isCorpusStructure() || isDocumentStructure()) {
			return true;
		}
		return false;
	}
}
