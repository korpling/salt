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
package de.hu_berlin.u.saltnpepper.salt.common.tokenizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.knallgrau.utils.textcat.TextCategorizer;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.neovisionaries.i18n.LanguageCode;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltTokenizerException;
import de.hu_berlin.u.saltnpepper.salt.util.DataSourceSequence;

/**
 * The general task of this class is to tokenize a given text in the same order
 * as the tool TreeTagger will do. A list of tokenized text is returned with the
 * text anchor (start and end position) in original text. Reimplemented in Java
 * with permission from the original TreeTagger tokenizer in Perl by Helmut
 * Schmid (see http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/).
 * This implementation uses sets of abbreviations to detect tokens, which are
 * abbreviations in a specific language. Therefore you can set a file containing
 * abbreviations, to take others than the default ones. Because of abbreviations
 * are language dependend, you can set a language, to use only a specific set of
 * abbreviations. The current version of the {@link Tokenizer} supports
 * abbreviations for english, french, italian and german language. If no
 * language is set, all available abbreviations will be used.
 * 
 * @author Amir Zeldes
 * @author Florian Zipser
 * 
 */
public class Tokenizer {
	/**
	 * Sets the {@link SDocumentGraph} to be used.
	 */
	private SDocumentGraph documentGraph = null;

	public void setsDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.documentGraph = sDocumentGraph;
	}

	public SDocumentGraph getDocumentGraph() {
		return documentGraph;
	}

	/**
	 * Initializes a new TTokenizer object.
	 */
	public Tokenizer() {
	}

	/**
	 * Sets the {@link STextualDS} to be tokenized. Its language will be
	 * detected automatically if possible.
	 * 
	 * @param sTextualDSs
	 */
	public List<SToken> tokenize(STextualDS sTextualDSs) {
		return (tokenize(sTextualDSs, null));
	}

	/**
	 * Sets the {@link STextualDS} to be tokenized and the language of the text.
	 * If language is null, it will be detected automatically if possible.
	 * 
	 * @param sTextualDSs
	 */
	public List<SToken> tokenize(STextualDS sTextualDSs, LanguageCode language) {
		return (this.tokenize(sTextualDSs, language, null, null));
	}

	/**
	 * Sets the {@link STextualDS} to be tokenized and the language of the text.
	 * If language is null, it will be detected automatically if possible.
	 * 
	 * @param sTextualDSs
	 *            {@link STextualDS} object containing the text to be tokenized
	 * @param language
	 *            language of text, if null, language will be detected
	 *            automatically
	 * @param startPos
	 *            start position, if text to be tokenized is subset (0 assumed
	 *            if set to null)
	 * @param startPos
	 *            end position, if text to be tokenized is subset (length of
	 *            text assumed if set to null)
	 */
	public List<SToken> tokenize(STextualDS sTextualDS, LanguageCode language, Integer startPos, Integer endPos) {
		List<SToken> retVal = null;
		if (sTextualDS == null){
			throw new SaltTokenizerException("Cannot tokenize an empty 'SSTextualDS' object.");
		}
		if (this.getDocumentGraph() == null) {
			if (sTextualDS.getGraph() == null) {
				throw new SaltTokenizerException("Cannot add tokens to an empty SDocumentGraph object and can not estimate SDocumentGraph, because STextualDS does not belong to a SDocumentGraph object.");
			} else {
				this.setsDocumentGraph(sTextualDS.getGraph());
			}
		}

		if (sTextualDS.getText() != null) {
			if (startPos == null){
				startPos = 0;
			}
			if (endPos == null){
				endPos = sTextualDS.getText().length();
			}
			// detect language
			if (language == null) {
				language = checkLanguage(sTextualDS.getText().substring(startPos, endPos));
				// if text was to short to emit language try entire text (and
				// hope, that no language mixes are contained :-})
				if (language == null){
					language = checkLanguage(sTextualDS.getText().substring(startPos, endPos));
				}
			}

			if (language != null) {// set abbreviations
				if (this.getAbbreviations(language) == null) {
					if (LanguageCode.de.equals(language)){
						this.addAbbreviation(LanguageCode.de, AbbreviationDE.createAbbriviations());
					}else if (LanguageCode.en.equals(language)){
						this.addAbbreviation(LanguageCode.en, AbbreviationEN.createAbbriviations());
					}else if (LanguageCode.fr.equals(language)){
						this.addAbbreviation(LanguageCode.fr, AbbreviationFR.createAbbriviations());
					}else if (LanguageCode.it.equals(language)){
						this.addAbbreviation(LanguageCode.it, AbbreviationIT.createAbbriviations());
					}
				}
			}// set abbreviations

			this.setClitics(language);

			retVal = tokenizeToToken(sTextualDS, language, startPos, endPos);
		}
		return (retVal);
	}

	/**
	 * Tries to detect language and returns ISO 639-2 language code
	 * 
	 * @param text
	 * @return
	 */
	public static LanguageCode checkLanguage(String text) {
		LanguageCode retVal = null;
		if (text != null) {// detect language
			TextCategorizer textCategorizer = new TextCategorizer();
			String lang = textCategorizer.categorize(text);
			return (mapISOLanguageCode(lang));
		}// detect language
		return (retVal);
	}

	/**
	 * Maps the knallgrau {@link TextCategorizer} language description codes to
	 * ISO 639 codes.
	 * 
	 * @return
	 */
	public static LanguageCode mapISOLanguageCode(String language) {
		LanguageCode retVal = null;
		if ("german".equals(language)) {
			retVal = LanguageCode.de;
		} else if ("english".equals(language)) {
			retVal = LanguageCode.en;
		} else if ("french".equals(language)) {
			retVal = LanguageCode.fr;

		} else if ("spanish".equals(language)) {
			retVal = LanguageCode.es;
		} else if ("italian".equals(language)) {
			retVal = LanguageCode.it;
		} else if ("swedish".equals(language)) {
			retVal = LanguageCode.sv;
		} else if ("polish".equals(language)) {
			retVal = LanguageCode.pl;
		} else if ("dutch".equals(language)) {
			retVal = LanguageCode.nl;
		} else if ("norwegian".equals(language)) {
			retVal = LanguageCode.no;
		} else if ("finnish".equals(language)) {
			retVal = LanguageCode.fi;
		} else if ("albanian".equals(language)) {
			retVal = LanguageCode.sq;
		} else if ("slovakian".equals(language)) {
			retVal = LanguageCode.sk;
		} else if ("slovenian".equals(language)) {
			retVal = LanguageCode.sl;
		} else if ("danish".equals(language)) {
			retVal = LanguageCode.da;
		} else if ("hungarian".equals(language)) {
			retVal = LanguageCode.hu;
		}
			return (retVal);
	}

	private Map<LanguageCode, HashSet<String>> abbreviations = null;

	/**
	 * Adds the given list of abbreviation to the internal map corresponding to
	 * given language.
	 * 
	 * @param language
	 * @param abbreviations
	 */
	public void addAbbreviation(LanguageCode language, HashSet<String> abbreviations) {
		if ((language != null) && (abbreviations != null)) {
			if (this.abbreviations == null){
				this.abbreviations = new ConcurrentHashMap<LanguageCode, HashSet<String>>();
			}
			if (!this.abbreviations.containsKey(language)){
				this.abbreviations.put(language, abbreviations);
			}
		}
	}

	/**
	 * Adds the content of given file as a list of abbreviation to the internal
	 * map corresponding to given language. Form of the file: Adm.<br/>
	 * Ala.<br/>
	 * Ariz.<br/>
	 * Ark.<br/>
	 * Aug.<br/>
	 * Ave.<br/>
	 * Bancorp.<br/>
	 * 
	 * @param language
	 * @param abbreviations
	 */
	public void addAbbreviation(LanguageCode language, File abbreviationFile) {
		HashSet<String> abbreviations = null;
		try {
			abbreviations = new HashSet<String>();

			BufferedReader inReader;

			inReader = new BufferedReader(new InputStreamReader(new FileInputStream(abbreviationFile), "UTF8"));

			String input = "";

			while ((input = inReader.readLine()) != null) {
				// putting
				abbreviations.add(input);
			}
			inReader.close();

		} catch (FileNotFoundException e) {
			throw new SaltTokenizerException("Cannot tokenize the given text, because the file for abbreviation '" + abbreviationFile.getAbsolutePath() + "' was not found.");
		} catch (IOException e) {
			throw new SaltTokenizerException("Cannot tokenize the given text, because can not read file '" + abbreviationFile.getAbsolutePath() + "'.");
		}
		this.addAbbreviation(language, abbreviations);
	}

	/**
	 * Returns a list of abbreviations corresponding to the given language.
	 * 
	 * @param language
	 * @return
	 */
	public HashSet<String> getAbbreviations(LanguageCode language) {
		HashSet<String> retVal = null;
		if (language != null) {
			if (this.abbreviations == null)
				this.abbreviations = new ConcurrentHashMap<LanguageCode, HashSet<String>>();
			retVal = abbreviations.get(language);
		}
		return (retVal);
	}

	// ======================= start: important issues
	// characters which have to be cut off at the beginning of a word
	protected final static String P_CHAR = "\\[\\{\\(´`\"»«‚„†‡‹‘’“”•–—›";
	// characters which have to be cut off at the end of a word
	protected final static String F_CHAR = "\\]\\}'`\"\\),;:!\\?%»«‚„…†‡‰‹‘’“”•–—›";

	// character sequences which have to be cut off at the beginning of a word
	private String PClitic = "";
	// character sequences which have to be cut off at the end of a word
	private String FClitic = "";

	/**
	 * Sets clitics corresponding to the given language.
	 * 
	 * @param lngLang
	 *            language
	 */
	private void setClitics(LanguageCode language) {
		if (LanguageCode.en.equals(language))
			this.FClitic = "('(s|re|ve|d|m|em|ll)|n't)";
		else if (LanguageCode.fr.equals(language)) {
			this.PClitic = "([dcjlmnstDCJLNMST]'|[Qq]u'|[Jj]usqu'|[Ll]orsqu')";
			this.FClitic = "(-t-elles?|-t-ils?|-t-on|-ce|-elles?|-ils?|-je|-la|-les?|-leur|-lui|-mêmes?|-m'|-moi|-nous|-on|-toi|-tu|-t'|-vous|-en|-y|-ci|-là)";
		} else if (LanguageCode.es.equals(language))
			this.PClitic = "([dD][ae]ll'|[nN]ell'|[Aa]ll'|[lLDd]'|[Ss]ull'|[Qq]uest'|[Uu]n'|[Ss]enz'|[Tt]utt')";
		else if (LanguageCode.de.equals(language))
			;// do nothing
	}

	/**
	 * The general task of this class is to tokenize a given text in the same
	 * order as the tool TreeTagger will do. A list of tokenized text is
	 * returned with the text anchor (start and end position) in original text.
	 * If the {@link SDocumentGraph} already contains tokens, the tokens will be
	 * preserved, if they overlap the same textual range as the new one.
	 * Otherwise a {@link SSpan} is created covering corresponding to the
	 * existing token. The span than overlaps all new tokens and contains all
	 * annotations the old token did. In case, the span would overlaps the same
	 * textual range as the old token did, no span is created.
	 * 
	 * @param strInput
	 *            original text
	 * @return tokenized text fragments and their position in the original text
	 */
	public List<SToken> tokenizeToToken(STextualDS sTextualDS, LanguageCode language, Integer startPos, Integer endPos) {
		List<SToken> retVal = null;
		List<String> strTokens = null;
		String strInput = sTextualDS.getText().substring(startPos, endPos);

		strTokens = this.tokenizeToString(strInput, language);
		if ((strTokens != null) && (strTokens.size() > 0)) {
			char[] chrText = strInput.toCharArray();
			int tokenCntr = 0;

			// check if tokens exist for passed span
			List<SToken> tokens = null;
			if ((startPos != 0) || (endPos != sTextualDS.getText().length()) || (getDocumentGraph().getTextualDSs().size() > 1)) {
				DataSourceSequence sequence = new DataSourceSequence();
				sequence.setDataSource(sTextualDS);
				sequence.setStart(startPos);
				sequence.setEnd(endPos);
				tokens = getDocumentGraph().getTokensBySequence(sequence);
			} else {
				tokens = getDocumentGraph().getTokens();
			}

			RangeMap<Integer, SToken> oldTokens = null;
			// create an organization structure for a tokens interval which
			// corresponds to a token
			if ((tokens != null) && (tokens.size() != 0)) {
				if ((getDocumentGraph().getTextualRelations() != null) && (getDocumentGraph().getTextualRelations().size() > 0)) {
					oldTokens = TreeRangeMap.create();
					for (STextualRelation rel : getDocumentGraph().getTextualRelations()) {
						oldTokens.put(Range.closed(rel.getStart(), rel.getEnd()), rel.getSource());
					}
				}
			}
			// a map mapping new created tokens, to old already existing tokens.
			// The old tokens should be removed later on and spans should be
			// created instead
			Multimap<SToken, SToken> old2newToken = ArrayListMultimap.create();

			for (int i = 0; i < chrText.length; i++) {
				if ((strTokens.get(tokenCntr).length() < 1) || (strTokens.get(tokenCntr).substring(0, 1).equals(String.valueOf(chrText[i])))) {
					// first letter matches
					StringBuffer pattern = new StringBuffer();
					for (int y = 0; y < strTokens.get(tokenCntr).length(); y++) {
						// compute pattern in text
						pattern.append(chrText[i + y]);
					}// compute pattern in text
					if (strTokens.get(tokenCntr).hashCode() == pattern.toString().hashCode()) {
						// pattern found
						int start = i + startPos;
						int end = i + startPos + strTokens.get(tokenCntr).length();

						if (this.getDocumentGraph() == null) {
							throw new SaltTokenizerException("Cannot add tokens to an empty SDocumentGraph object.");
						}

						SToken sTok = this.getDocumentGraph().createSToken(sTextualDS, start, end);
						if (retVal == null) {
							retVal = new ArrayList<SToken>();
						}
						retVal.add(sTok);
						i = i + strTokens.get(tokenCntr).length() - 1;
						tokenCntr++;
						if (tokenCntr >= strTokens.size()) {
							break;
						}

						/**
						 * check, if there is an old token, overlapping the same
						 * or a bigger span as the currently created one. If
						 * yes, remove the old one and create a span overlapping
						 * the new one.
						 **/
						if (oldTokens != null) {
							SToken oldToken = oldTokens.get(start);
							if (oldToken != null) {
								old2newToken.put(oldToken, sTok);
							}
						}

					}// pattern found
				}// first letter matches
			}

			if (old2newToken != null) {
				for (SToken oldToken : old2newToken.keySet()) {
					// create span for oldToken
					List<SToken> overlappedTokens = new ArrayList<SToken>(old2newToken.get(oldToken));
					if (overlappedTokens.size() == 1) {
						getDocumentGraph().removeNode(overlappedTokens.get(0));
					} else {

						SSpan span = getDocumentGraph().createSpan(overlappedTokens);

						// move all annotations from old token to span
						for (SAnnotation sAnno : oldToken.getAnnotations()) {
							span.addAnnotation(sAnno);
						}

						// redirect all relations to span
						List<SRelation<SNode, SNode>> inRels = new ArrayList<>();
						for (SRelation rel : getDocumentGraph().getInRelations(oldToken.getId())) {
							inRels.add(rel);
						}
						for (SRelation inRel : inRels) {
							if (inRel instanceof SSpanningRelation) {
								// in case of edge is a SSpanningRelation remove
								// it and create new ones for each token under
								// the span
								if (inRel.getSource() instanceof SSpan) {
									SSpan parentSpan = (SSpan) inRel.getSource();
									getDocumentGraph().removeRelation(inRel);
									for (SToken overlappedToken : overlappedTokens) {
										SSpanningRelation rel = SaltFactory.createSSpanningRelation();
										rel.setSource(parentSpan);
										rel.setTarget(overlappedToken);
										getDocumentGraph().addRelation(rel);
										// getsDocumentGraph().addRelation(((SRelation<SNode,
										// SNode>)(SRelation<? extends SNode, ?
										// extends SNode>)rel));
									}
								}
							} else {
								inRel.setTarget(span);
							}
						}
						List<SRelation<SNode, SNode>> outRels = new ArrayList<>();
						for (SRelation outRel : getDocumentGraph().getOutRelations(oldToken.getId())) {
							if (!(outRel instanceof STextualRelation)) {
								outRels.add(outRel);
							}
						}
						for (SRelation outRel : outRels) {
							outRel.setSource(span);
						}
						getDocumentGraph().removeNode(oldToken);
					}
				}
			}
		}
		return (retVal);
	}

	/**
	 * The general task of this class is to tokenize a given text in the same
	 * order as the tool TreeTagger will do. Returns a list of tokenized text.
	 * 
	 * @param strInput
	 *            original text
	 * @return tokeized text fragments
	 */
	public List<String> tokenizeToString(String strInput, LanguageCode language) {
		// insert missing blanks after punctuation
		strInput = strInput.replaceAll("\\.\\.\\.", " ... ");
		strInput = strInput.replaceAll("([;\\!\\?])([^ ])", "$1 $2");

		// replace any amount of white spaces with one space
		strInput = strInput.replaceAll("\\s+", " ");

		// make sure there are no leading or trailing spaces
		strInput = strInput.trim();

		String[] strOutput;
		// split based on whitespace
		strOutput = strInput.split(" ");

		ArrayList<String> lstTokens = new ArrayList<String>(Arrays.asList(strOutput));
		Pattern p = null;
		Matcher m = null;
		Pattern p2 = null;
		Matcher m2 = null;

		for (int i = 0; i < lstTokens.size(); i++) {
			// cut off preceding punctuation
			p = Pattern.compile("^([" + P_CHAR + "])(.+)");
			m = p.matcher(lstTokens.get(i));
			if (m.find()) {
				lstTokens.remove(i);
				lstTokens.add(i, m.group(2));
				lstTokens.add(i, m.group(1));
				continue; // advance further in the loop, checking the token
				// without preceding punctuation
			}

			// cut off trailing punctuation
			p = Pattern.compile("^(.+)([" + F_CHAR + "])$");
			m = p.matcher(lstTokens.get(i));
			if (m.find()) {
				lstTokens.remove(i);
				lstTokens.add(i, m.group(2));
				lstTokens.add(i, m.group(1));
				i--; // do not advance, the token needs to be checked without
						// trailing punctuation
				continue; // repeat the loop, checking the same token without
				// trailing punctuation
			}

			// cut off trailing periods if punctuation precedes
			p = Pattern.compile("^(.+[" + F_CHAR + "])(\\.)$");
			m = p.matcher(lstTokens.get(i));
			if (m.find()) {
				lstTokens.remove(i);
				lstTokens.add(i, m.group(2));
				lstTokens.add(i, m.group(1));
				i--; // do not advance, the token needs to be checked without
						// trailing period
				continue; // repeat the loop, checking the same token without
				// trailing period
			}

			// check abbreviation list
			HashSet<String> abbreviations = this.getAbbreviations(language);
			if ((abbreviations != null) && (abbreviations.contains(lstTokens.get(i)))) {
				// known abbreviation found
				continue;
			}

			// abbreviations of the form A. or U.S.A.
			p = Pattern.compile("^([A-Za-zÁÂÃÈý®Ð×ÝÞÍðÎÓÔÕØÙãõš›€ß‚ƒ„‡ˆ‰Š‹ŒŽøŸ÷·”“’]\\.)+$");
			m = p.matcher(lstTokens.get(i));
			if (m.find()) {
				continue; // leave this acronym token alone and advance the loop
			}

			// disambiguate periods
			p = Pattern.compile("^(.+)(\\.)$");
			m = p.matcher(lstTokens.get(i));
			p2 = Pattern.compile("^(\\.\\.\\.|[0-9]+\\.)$");
			m2 = p2.matcher(lstTokens.get(i));
			if (m.find() && !m2.find()) {
				lstTokens.remove(i);
				lstTokens.add(i, m.group(2));
				lstTokens.add(i, m.group(1));
				i++; // no need to check next token, as it is a separate period
				continue; // advance the loop
			}

			// attempt to separate proclitics
			p = Pattern.compile("^(" + PClitic + ")(.+)$");
			m = p.matcher(lstTokens.get(i));
			if (m.find() && !PClitic.isEmpty()) {
				lstTokens.remove(i);
				lstTokens.add(i, m.group(2));
				lstTokens.add(i, m.group(1));
				continue; // proclitic has been removed, but next token must
				// still be checked
			}

			// attempt to separate enclitics
			p = Pattern.compile("(.+)(" + FClitic + ")$");
			m = p.matcher(lstTokens.get(i));
			if (m.find() && !FClitic.isEmpty()) {
				lstTokens.remove(i);
				lstTokens.add(i, m.group(2));
				lstTokens.add(i, m.group(1));
				i++; // next token is a known enclitic, skip it
				continue; // advance to get past the enclitic
			}
		}
		return lstTokens;
	}
	// ======================= end: important issues
}
