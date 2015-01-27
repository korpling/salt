package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tokenizer;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.neovisionaries.i18n.LanguageCode;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltTokenizerException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;

/**
 * This class is a very simple implementation of a tokenizer, which just splits a primary text
 * by a given list of characters. e.g. a blank.
 * 
 * @author Florian Zipser
 *
 */
public class SimpleTokenizer {
	/**
	 * Sets the {@link SDocumentGraph} to be used.
	 */
	private SDocumentGraph sDocumentGraph = null;

	public void setsDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.sDocumentGraph = sDocumentGraph;
	}

	public SDocumentGraph getsDocumentGraph() {
		return sDocumentGraph;
	}

	/**
	 * Initializes a new TTokenizer object.
	 */
	public SimpleTokenizer() {
	}

	/**
	 * Sets the {@link STextualDS} to be tokenized. Its language will be
	 * detected automatically if possible.
	 * 
	 * @param sTextualDSs
	 */
	public EList<SToken> tokenize(STextualDS sTextualDSs, Character... separator) {
		return (this.tokenize(sTextualDSs, null, null, separator));
	}
	
	/**
	 * Sets the {@link STextualDS} to be tokenized and the language of the text.
	 * If language is null, it will be detected automatically if possible.
	 * 
	 * @param sTextualDSs
	 *            {@link STextualDS} object containing the text to be tokenized
	 * @param startPos
	 *            start position, if text to be tokenized is subset (0 assumed
	 *            if set to null)
	 * @param startPos
	 *            end position, if text to be tokenized is subset (length of
	 *            text assumed if set to null)
	 */
	public EList<SToken> tokenize(STextualDS sTextualDS, Integer startPos, Integer endPos, Character... separator) {
		EList<SToken> retVal = null;
		if (sTextualDS == null)
			throw new SaltTokenizerException("Cannot tokenize an empty 'SSTextualDS' object.");

		if (this.getsDocumentGraph() == null) {
			if (sTextualDS.getSDocumentGraph() == null)
				throw new SaltTokenizerException("Cannot add tokens to an empty SDocumentGraph object and can not estimate SDocumentGraph, because STextualDS does not belong to a SDocumentGraph object.");
			else
				this.setsDocumentGraph(sTextualDS.getSDocumentGraph());
		}

		if (sTextualDS.getSText() != null) {
			if (startPos == null){
				startPos = 0;
			}
			if (endPos == null){
				endPos = sTextualDS.getSText().length();
			}
			
			char[] text;
			if (	(startPos!= 0)||
					(endPos!= sTextualDS.getSText().length())){
				text= sTextualDS.getSText().substring(startPos, endPos).toCharArray();
			}else{
				text= sTextualDS.getSText().toCharArray();
			}
			//true if last character was a separator, false otherwise
			boolean lastWasSep= false;
			int currStart= 0; // current start position for token
			int currEnd= 0;  //current end position for token
			for (char chr: text){
				for (char sep: separator){
					if (chr== sep){
						//create token
						getsDocumentGraph().createSToken(sTextualDS, currStart, currEnd);
						
					}else{
						currEnd++;
					}
				}
			}
		}
		return (retVal);
	}
}
