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
package de.hu_berlin.u.saltnpepper.salt.samples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.xml.sax.SAXException;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.STimeline;
import de.hu_berlin.u.saltnpepper.salt.common.STimelineRelation;
import de.hu_berlin.u.saltnpepper.salt.common.SToken;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltSampleException;
import de.hu_berlin.u.saltnpepper.salt.semantics.SLemmaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SPOSAnnotation;
import de.hu_berlin.u.saltnpepper.salt.util.SALT_TYPE;

/**
 * Creates samples of {@link SDocumentGraph} and {@link SCorpusGraph} instances.
 * 
 * @author Florian Zipser
 * 
 */
public class SampleGenerator {

	/**
	 * Creates the following corpus structure and adds it to the given salt
	 * project.
	 * 
	 * <pre>
	 *      rootCorpus 
	 *       /      \ 
	 * subCorp1      subCorp2 
	 *    / \          / \ 
	 * doc1 doc2    doc3 doc4
	 * </pre>
	 * 
	 * @throws IOException
	 * @throws SAXException
	 */
	public static SCorpusGraph createCorpusStructure(SaltProject saltProject) {
		/**
		 * TODO replace code with call of createCorpusStructure(SCorpusGraph
		 * sCorpGraph1)
		 */
		if (saltProject == null) {
			throw new SaltSampleException("Cannot create example, because the given saltProjects is empty.");
		}

		SCorpusGraph corpGraph = SaltFactory.createSCorpusGraph();
		saltProject.addCorpusGraph(corpGraph);
		SCorpus corpus1 = SaltFactory.createSCorpus();
		corpus1.setName("rootCorpus");
		corpGraph.addNode(corpus1);
		SCorpus corpus2 = SaltFactory.createSCorpus();
		corpus2.setName("subCorpus1");
		SCorpus corpus3 = SaltFactory.createSCorpus();
		corpus3.setName("subCorpus2");

		corpGraph.addSubCorpus(corpus1, corpus2);
		corpGraph.addSubCorpus(corpus1, corpus3);

		SDocument doc = null;

		doc = SaltFactory.createSDocument();
		doc.setName("doc1");
		corpGraph.addDocument(corpus1, doc);

		doc = SaltFactory.createSDocument();
		doc.setName("doc2");
		corpGraph.addDocument(corpus1, doc);

		doc = SaltFactory.createSDocument();
		doc.setName("doc3");
		corpGraph.addDocument(corpus2, doc);

		doc = SaltFactory.createSDocument();
		doc.setName("doc4");
		corpGraph.addDocument(corpus2, doc);

		return (corpGraph);
	}

	/**
	 * 
	 * Creates a complete {@link SaltProject} object having the complex
	 * structure
	 * 
	 * <pre>
	 * 
	 *            rootCorpus
	 *           /         \
	 * 	subCorp1           subCorp2
	 * 	/      \            /       \
	 * doc1   doc2         doc3     doc4
	 * </pre>
	 * 
	 * @return
	 */
	public static SaltProject createSaltProject() {
		// Creating a new salt project, this is the main object and contains all
		// the others.
		SaltProject saltProject = SaltFactory.createSaltProject();
		saltProject.setName("sampleSaltProject");
		// this works, because after createCorpusStructure() was called, only
		// one graph exists in salt project
		SCorpusGraph corpGraph = SaltFactory.createSCorpusGraph();

		corpGraph = createCorpusStructure(corpGraph);

		saltProject.addCorpusGraph(corpGraph);
		for (SDocument document : corpGraph.getDocuments()) {
			createSDocumentStructure(document);
		}
		return (saltProject);
	}

	/**
	 * Creates the following structure:
	 * 
	 * <pre>
	 *            rootCorpus
	 *       /                    \
	 *   subCorp1               subCorp2
	 *  /       \              /        \
	 * doc1     doc2         doc3      doc4
	 * </pre>
	 * 
	 * @throws IOException
	 * @throws SAXException
	 */
	public static SCorpusGraph createCorpusStructure() {
		SCorpusGraph corpGraph = SaltFactory.createSCorpusGraph();
		createCorpusStructure(corpGraph);
		return (corpGraph);
	}

	/**
	 * Creates the following structure:
	 * 
	 * <pre>
	 *             rootCorpus
	 *       /                     \
	 *   subCorp1               subCorp2
	 *  /       \             /         \
	 * doc1    doc2         doc3       doc4
	 * </pre>
	 * 
	 * @throws IOException
	 * @throws SAXException
	 */
	public static SCorpusGraph createCorpusStructure(SCorpusGraph corpGraph1) {
		if (corpGraph1 == null) {
			throw new SaltSampleException("Cannot create example, because the given sCorpusGraph is empty.");
		}
		corpGraph1.setId("corpusGraph1");
		SCorpus corpusRoot = SaltFactory.createSCorpus();
		corpusRoot.setName("rootCorpus");
		corpGraph1.addNode(corpusRoot);
		SCorpus corpusSub1 = SaltFactory.createSCorpus();
		corpusSub1.setName("subCorpus1");
		SCorpus corpusSub2 = SaltFactory.createSCorpus();
		corpusSub2.setName("subCorpus2");

		corpGraph1.addSubCorpus(corpusRoot, corpusSub1);
		corpGraph1.addSubCorpus(corpusRoot, corpusSub2);

		SDocument doc = null;

		doc = SaltFactory.createSDocument();
		doc.setName("doc1");
		corpGraph1.addDocument(corpusSub1, doc);

		doc = SaltFactory.createSDocument();
		doc.setName("doc2");
		corpGraph1.addDocument(corpusSub1, doc);

		doc = SaltFactory.createSDocument();
		doc.setName("doc3");
		corpGraph1.addDocument(corpusSub2, doc);

		doc = SaltFactory.createSDocument();
		doc.setName("doc4");
		corpGraph1.addDocument(corpusSub2, doc);

		return (corpGraph1);
	}

	/**
	 * Creates the following structure:
	 * 
	 * <pre>
	 * rootCorpus | doc1
	 * </pre>
	 * 
	 * @throws IOException
	 * @throws SAXException
	 */
	public static SCorpusGraph createCorpusStructure_simple() {
		SCorpusGraph corpGraph = SaltFactory.createSCorpusGraph();
		corpGraph.setId("corpusGraph1");
		SCorpus corpus = SaltFactory.createSCorpus();
		corpus.setName("rootCorpus");
		corpGraph.addNode(corpus);

		SDocument doc = null;
		doc = SaltFactory.createSDocument();
		doc.setName("doc1");
		corpGraph.addDocument(corpus, doc);

		return (corpGraph);
	}

	/**
	 * The primary text, which is used for the samples.
	 */
	public static final String PRIMARY_TEXT_EN = "Is this example more complicated than it appears to be?";
	/** Primary text of speaker1 **/
	public static final String PRIMARY_TEXT_EN_SPK1 = PRIMARY_TEXT_EN;
	/** Primary text of speaker2 **/
	public static final String PRIMARY_TEXT_EN_SPK2 = "Uhm oh yes!";
	/**
	 * The primary text, which is used for the samples.
	 */
	public static final String PRIMARY_TEXT_DE = "Ist dieses Beispiel komplizierter als es zu sein scheint?";
	/**
	 * The name of the morphologic layer containing the tokens.
	 */
	public static final String MORPHOLOGY_LAYER = "morphology";
	/** iso 639-1 language code for english **/
	public static final String LANG_EN = "en";
	/** iso 639-1 language code for german **/
	public static final String LANG_DE = "de";

	/**
	 * Creates a {@link SDocumentGraph} containing to texts of two different
	 * speakers, who are aligned via the {@link STimeline} related to the
	 * {@link SToken} objects. The texts are {@value #PRIMARY_TEXT_EN_SPK1} and
	 * {@value #PRIMARY_TEXT_EN_SPK2}, which are tokenized by words. The words
	 * 'to' and 'Oh' have been said simultaneously and are overlapping via the
	 * timeline.
	 * 
	 * @param document
	 *            document to be filled
	 */
	public static void createDialogue(SDocument document) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		document.setDocumentGraph(SaltFactory.createSDocumentGraph());
		document.getDocumentGraph().createTextualDS(PRIMARY_TEXT_EN_SPK1);
		createTokens(document);
		document.getDocumentGraph().createTimeline();
		List<SRelation> timelineRelationsToDelete = new ArrayList<>();
		for (STimelineRelation timelineRelation : document.getDocumentGraph().getTimelineRelations()) {
			timelineRelationsToDelete.add(timelineRelation);
		}

		for (SRelation rel : timelineRelationsToDelete) {
			document.getDocumentGraph().removeRelation(rel);
		}

		// add SOrderRelations for speaker 1
		SToken lastSTok = null;
		int lastPointOfTime = 0;
		for (SToken tok : document.getDocumentGraph().getTokens()) {
			if (lastSTok != null) {
				SOrderRelation rel = SaltFactory.createSOrderRelation();
				rel.setSource(lastSTok);
				rel.setTarget(tok);
				document.getDocumentGraph().addRelation(rel);
			}

			// set timeline
			STimelineRelation sTimeRel = SaltFactory.createSTimelineRelation();
			sTimeRel.setSource(tok);
			sTimeRel.setTarget(document.getDocumentGraph().getTimeline());
			sTimeRel.setStart(lastPointOfTime);
			lastPointOfTime += 1;
			if (lastPointOfTime == 10) {
				lastPointOfTime += 1;
			}
			sTimeRel.setEnd(lastPointOfTime);
			document.getDocumentGraph().addRelation(sTimeRel);

			lastSTok = tok;
		}

		// create text of speaker2
		STextualDS sText2 = document.getDocumentGraph().createTextualDS(PRIMARY_TEXT_EN_SPK2);

		SToken spk2_tok0 = createToken(0, 3, sText2, document, null);
		STimelineRelation timeRel0 = SaltFactory.createSTimelineRelation();
		timeRel0.setSource(spk2_tok0);
		timeRel0.setTarget(document.getDocumentGraph().getTimeline());
		timeRel0.setStart(7);
		timeRel0.setEnd(9);
		document.getDocumentGraph().addRelation(timeRel0);

		SToken spk2_tok1 = createToken(4, 6, sText2, document, null);
		STimelineRelation sTimeRel1 = SaltFactory.createSTimelineRelation();
		sTimeRel1.setSource(spk2_tok1);
		sTimeRel1.setTarget(document.getDocumentGraph().getTimeline());
		sTimeRel1.setStart(9);
		sTimeRel1.setEnd(10);
		document.getDocumentGraph().addRelation(sTimeRel1);

		SToken spk2_tok2 = createToken(7, 11, sText2, document, null);
		STimelineRelation timeRel2 = SaltFactory.createSTimelineRelation();
		timeRel2.setSource(spk2_tok2);
		timeRel2.setTarget(document.getDocumentGraph().getTimeline());
		timeRel2.setStart(10);
		timeRel2.setEnd(11);
		document.getDocumentGraph().addRelation(timeRel2);

		// add SOrderRelations for speaker 2
		SOrderRelation sOrd1 = SaltFactory.createSOrderRelation();
		sOrd1.setSource(spk2_tok0);
		sOrd1.setTarget(spk2_tok1);
		document.getDocumentGraph().addRelation(sOrd1);

		SOrderRelation sOrd2 = SaltFactory.createSOrderRelation();
		sOrd2.setSource(spk2_tok1);
		sOrd2.setTarget(spk2_tok2);
		document.getDocumentGraph().addRelation(sOrd2);
	}

	/**
	 * Creates an {@link STextualDS} object containing the primary text
	 * {@link SampleGenerator#PRIMARY_TEXT_EN} and adds the object to the
	 * {@link SDocumentGraph} being contained by the given {@link SDocument}
	 * object. TODO WHAT HAS BEEN SUPPOSED TO BE SHOWN HERE? THE ORIGINAL TEXT
	 * OR THE LINK TO THE STRING OBJECT?
	 * 
	 * @param document
	 *            the document, to which the created {@link STextualDS} object
	 *            will be added FEHLT IN SAMPLE GENERATOR
	 * @return returns the created primary text
	 */
	public static STextualDS createPrimaryData(SDocument document) {
		return (createPrimaryData(document, LANG_EN));
	}

	/**
	 * Creates a {@link STextualDS} object containing the primary text
	 * {@link SampleGenerator#PRIMARY_TEXT_EN}, which is either an english text
	 * or its german translation and adds the object to the
	 * {@link SDocumentGraph} being contained by the given {@link SDocument}
	 * object.
	 * 
	 * @param document
	 *            the document, to which the created {@link STextualDS} object
	 *            will be added
	 * @param language
	 *            the language of the resource to be created, {@link #LANG_EN}
	 *            for english, {@link #LANG_DE} for german
	 * @return returns the created {@link STextualDS} object
	 */
	public static STextualDS createPrimaryData(SDocument document, String language) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		if (document.getDocumentGraph() == null) {
			document.setDocumentGraph(SaltFactory.createSDocumentGraph());
		}
		STextualDS textualDS = null;
		// creating the primary text depending on the language
		textualDS = SaltFactory.createSTextualDS();
		if (LANG_EN.equalsIgnoreCase(language)) {
			textualDS.setText(PRIMARY_TEXT_EN);
		} else if (LANG_DE.equalsIgnoreCase(language)) {
			textualDS.setText(PRIMARY_TEXT_DE);
		}
		// adding the text to the document-graph
		document.getDocumentGraph().addNode(textualDS);
		// creating the primary text depending on the language
		return (textualDS);
	}

	/**
	 * Creates a set of {@link SToken} objects tokenizing the primary text
	 * {@link SampleGenerator#PRIMARY_TEXT_EN} in to the following tokens:
	 * <ul>
	 * <li>Is</li>
	 * <li>this</li>
	 * <li>example</li>
	 * <li>more</li>
	 * <li>complicated</li>
	 * <li>than</li>
	 * <li>it</li>
	 * <li>appears</li>
	 * <li>to</li>
	 * <li>be</li>
	 * <li>?</li>
	 * </ul>
	 * The created {@link SToken} objects and corresponding
	 * {@link STextualRelation} objects are added to the given {@link SDocument}
	 * object.
	 * 
	 * @param document
	 *            the document, to which the created {@link SToken} objects will
	 *            be added
	 */
	public static void createTokens(SDocument document) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		if (document.getDocumentGraph() == null) {
			document.setDocumentGraph(SaltFactory.createSDocumentGraph());
		}
		if (document.getDocumentGraph().getTextualDSs().isEmpty()) {
			createPrimaryData(document);
		}
		createTokens(document, document.getDocumentGraph().getTextualDSs().get(0));
	}

	/**
	 * Creates a set of {@link SToken} objects tokenizing the primary text
	 * {@link SampleGenerator#PRIMARY_TEXT_EN} or
	 * {@link SampleGenerator#PRIMARY_TEXT_DE} depending on the given
	 * {@link STextualDS} object in to the following tokens:
	 * <ul>
	 * <li>Is</li>
	 * <li>this</li>
	 * <li>example</li>
	 * <li>more</li>
	 * <li>complicated</li>
	 * <li>than</li>
	 * <li>it</li>
	 * <li>appears</li>
	 * <li>to</li>
	 * <li>be</li>
	 * <li>?</li>
	 * </ul>
	 * or
	 * <ul>
	 * <li>Ist</li>
	 * <li>dieses</li>
	 * <li>Beispiel</li>
	 * <li>komplizierter</li>
	 * <li>als</li>
	 * <li>es</li>
	 * <li>zu</li>
	 * <li>sein</li>
	 * <li>scheint</li>
	 * <li>?</li>
	 * </ul>
	 * The created {@link SToken} objects and corresponding
	 * {@link STextualRelation} objects are added to the given {@link SDocument}
	 * object.
	 * 
	 * @param document
	 *            the document, to which the created {@link SToken} objects will
	 *            be added
	 * @return list of created {@link SToken} objects
	 */
	public static List<SToken> createTokens(SDocument document, STextualDS textualDS) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		// as a means to group elements, layers (SLayer) can be used. here, a
		// layer
		// named "morphology" is created and the tokens will be added to it
		SLayer morphLayer = SaltFactory.createSLayer();
		morphLayer.setName(MORPHOLOGY_LAYER);
		document.getDocumentGraph().addLayer(morphLayer);

		List<SToken> retVal = new Vector<SToken>();

		if (textualDS.getText().equals(PRIMARY_TEXT_EN)) {
			retVal.add(createToken(0, 2, textualDS, document, morphLayer)); // Is
			retVal.add(createToken(3, 7, textualDS, document, morphLayer)); // this
			retVal.add(createToken(8, 15, textualDS, document, morphLayer)); // example
			retVal.add(createToken(16, 20, textualDS, document, morphLayer)); // more
			retVal.add(createToken(21, 32, textualDS, document, morphLayer)); // complicated
			retVal.add(createToken(33, 37, textualDS, document, morphLayer)); // than
			retVal.add(createToken(38, 40, textualDS, document, morphLayer)); // it
			retVal.add(createToken(41, 48, textualDS, document, morphLayer)); // supposed
			retVal.add(createToken(49, 51, textualDS, document, morphLayer)); // to
			retVal.add(createToken(52, 54, textualDS, document, morphLayer)); // be
			retVal.add(createToken(54, 55, textualDS, document, morphLayer)); // ?
		} else if (textualDS.getText().equals(PRIMARY_TEXT_DE)) {
			retVal.add(createToken(0, 3, textualDS, document, morphLayer)); // Ist
			retVal.add(createToken(4, 10, textualDS, document, morphLayer)); // dieses
			retVal.add(createToken(11, 19, textualDS, document, morphLayer)); // Beipsiel
			retVal.add(createToken(20, 33, textualDS, document, morphLayer)); // komplizierter
			retVal.add(createToken(34, 37, textualDS, document, morphLayer)); // als
			retVal.add(createToken(38, 40, textualDS, document, morphLayer)); // es
			retVal.add(createToken(41, 43, textualDS, document, morphLayer)); // zu
			retVal.add(createToken(44, 48, textualDS, document, morphLayer)); // sein
			retVal.add(createToken(49, 56, textualDS, document, morphLayer)); // scheint
			retVal.add(createToken(56, 57, textualDS, document, morphLayer)); // ?
		}
		return (retVal);
	}

	/**
	 * Creates a {@link SToken} covering the passed position and returns it.
	 * 
	 * @param start
	 * @param end
	 * @param textualDS
	 * @param document
	 * @param layer
	 * @return created {@link SToken} object
	 */
	public static SToken createToken(int start, int end, STextualDS textualDS, SDocument document, SLayer layer) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		if (document.getDocumentGraph() == null) {
			document.setDocumentGraph(SaltFactory.createSDocumentGraph());
		}
		if (document.getDocumentGraph().getTextualDSs().isEmpty()) {
			createPrimaryData(document);
			textualDS = document.getDocumentGraph().getTextualDSs().get(0);
		}
		SToken sToken = SaltFactory.createSToken();
		document.getDocumentGraph().addNode(sToken);
		if (layer != null) {
			layer.getNodes().add(sToken);
		}
		STextualRelation sTextRel = SaltFactory.createSTextualRelation();
		sTextRel.setSource(sToken);
		sTextRel.setTarget(textualDS);
		sTextRel.setStart(start);
		sTextRel.setEnd(end);
		document.getDocumentGraph().addRelation(sTextRel);
		return (sToken);
	}

	// TODO Documentation
	public static void createParallelData(SDocument document) {
		createParallelData(document, true);
	}

	/**
	 * Creates a small parallel corpus, containing an english and a german text.
	 * The english text is {@value #PRIMARY_TEXT_EN}, the german text is
	 * {@value #PRIMARY_TEXT_DE}. Both are tokenized by word borders.
	 * 
	 * @param document
	 *            he document containing the {@link STextualDS} objects
	 */
	public static void createParallelData(SDocument document, boolean setTypeForPointRel) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		STextualDS pd_EN = createPrimaryData(document, LANG_EN);
		STextualDS pd_DE = createPrimaryData(document, LANG_DE);

		List<SToken> englishToks = createTokens(document, pd_EN);
		List<SToken> germanToks = createTokens(document, pd_DE);

		SPointingRelation pointRel = null;

		pointRel = (SPointingRelation) document.getDocumentGraph().createSRelation(englishToks.get(0), germanToks.get(0), SALT_TYPE.SPOINTING_RELATION, "align=en_de");
		if (setTypeForPointRel)
			pointRel.setType("align");
		pointRel = (SPointingRelation) document.getDocumentGraph().createSRelation(englishToks.get(1), germanToks.get(1), SALT_TYPE.SPOINTING_RELATION, "align=en_de");
		if (setTypeForPointRel)
			pointRel.setType("align");
		pointRel = (SPointingRelation) document.getDocumentGraph().createSRelation(englishToks.get(2), germanToks.get(2), SALT_TYPE.SPOINTING_RELATION, "align=en_de");
		if (setTypeForPointRel)
			pointRel.setType("align");
		pointRel = (SPointingRelation) document.getDocumentGraph().createSRelation(englishToks.get(5), germanToks.get(4), SALT_TYPE.SPOINTING_RELATION, "align=en_de");
		if (setTypeForPointRel)
			pointRel.setType("align");
		pointRel = (SPointingRelation) document.getDocumentGraph().createSRelation(englishToks.get(6), germanToks.get(5), SALT_TYPE.SPOINTING_RELATION, "align=en_de");
		if (setTypeForPointRel)
			pointRel.setType("align");
		pointRel = (SPointingRelation) document.getDocumentGraph().createSRelation(englishToks.get(7), germanToks.get(6), SALT_TYPE.SPOINTING_RELATION, "align=en_de");
		if (setTypeForPointRel)
			pointRel.setType("align");
		pointRel = (SPointingRelation) document.getDocumentGraph().createSRelation(englishToks.get(8), germanToks.get(7), SALT_TYPE.SPOINTING_RELATION, "align=en_de");
		if (setTypeForPointRel)
			pointRel.setType("align");
		pointRel = (SPointingRelation) document.getDocumentGraph().createSRelation(englishToks.get(9), germanToks.get(8), SALT_TYPE.SPOINTING_RELATION, "align=en_de");
		if (setTypeForPointRel)
			pointRel.setType("align");
		List<SToken> sTokens = new ArrayList<>();
		sTokens.add(englishToks.get(3));
		sTokens.add(englishToks.get(4));
		SSpan sSpan = document.getDocumentGraph().createSpan(sTokens);
		pointRel = (SPointingRelation) document.getDocumentGraph().createSRelation(sSpan, germanToks.get(3), SALT_TYPE.SPOINTING_RELATION, "align=en_de");
		if (setTypeForPointRel)
			pointRel.setType("align");
	}

	/**
	 * Creates a small parallel corpus, containing an english and a german text.
	 * The english text is {@value #PRIMARY_TEXT_EN}, the german text is
	 * {@value #PRIMARY_TEXT_DE}. Both are tokenized by word borders. TODO
	 * INSUFFICIENT DOCUMENTATION
	 * 
	 * @param document
	 *            he document containing the {@link STextualDS} objects
	 */
	public static void createUntypedParallelData(SDocument document) {
		createParallelData(document, false);
	}

	/**
	 * Creates morphological annotations (pos and lemma) for the tokenized
	 * sample and adds them to each {@link SToken} object as
	 * {@link SPOSAnnotation} or {@link SLemmaAnnotation} object.
	 * <table>
	 * <tr>
	 * <td>token</td>
	 * <td>pos</td>
	 * <td>lemma</td>
	 * </tr>
	 * <tr>
	 * <td>Is</td>
	 * <td>VBZ</td>
	 * <td>be</td>
	 * </tr>
	 * <tr>
	 * <td>this</td>
	 * <td>DT</td>
	 * <td>this</td>
	 * </tr>
	 * <tr>
	 * <td>example</td>
	 * <td>NN</td>
	 * <td>example</td>
	 * </tr>
	 * <tr>
	 * <td>more</td>
	 * <td>ABR</td>
	 * <td>more</td>
	 * </tr>
	 * <tr>
	 * <td>complicated</td>
	 * <td>JJ</td>
	 * <td>complicated</td>
	 * </tr>
	 * <tr>
	 * <td>than</td>
	 * <td>IN</td>
	 * <td>than</td>
	 * </tr>
	 * <tr>
	 * <td>it</td>
	 * <td>PRP</td>
	 * <td>it</td>
	 * </tr>
	 * <tr>
	 * <td>appears</td>
	 * <td>VBZ</td>
	 * <td>appear</td>
	 * </tr>
	 * <tr>
	 * <td>to</td>
	 * <td>TO</td>
	 * <td>to</td>
	 * </tr>
	 * <tr>
	 * <td>be</td>
	 * <td>VB</td>
	 * <td>be</td>
	 * </tr>
	 * </table>
	 * 
	 * @param document
	 *            the document containing the {@link SToken} and
	 *            {@link STextualDS} objects
	 */
	public static void createMorphologyAnnotations(SDocument document) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		if (document.getDocumentGraph() == null) {
			document.setDocumentGraph(SaltFactory.createSDocumentGraph());
		}
		if (document.getDocumentGraph().getTextualDSs().isEmpty()) {
			createPrimaryData(document);
			createTokens(document);
		}
		List<SToken> sTokens = Collections.synchronizedList(document.getDocumentGraph().getTokens());

		{// adding part-of speech annotations
			SPOSAnnotation sPOSAnno = null;

			// a list of all part-of-speech annotations for the words Is (VBZ),
			// this (DT) ... be (VB)
			String[] posAnnotations = { "VBZ", "DT", "NN", "RBR", "JJ", "IN", "PRP", "VBZ", "TO", "VB", "." };
			for (int i = 0; i < sTokens.size(); i++) {
				sPOSAnno = SaltFactory.createSPOSAnnotation();
				sPOSAnno.setValue(posAnnotations[i]);
				sTokens.get(i).addAnnotation(sPOSAnno);
			}
		}// adding part-of speech annotations

		{// adding lemma annotations
			SLemmaAnnotation sLemmaAnno = null;

			// a list of all lemma annotations for the words Is (be), this
			// (this) ... be (be)
			String[] posAnnotations = { "be", "this", "example", "more", "complicated", "than", "it", "appear", "to", "be", "?" };
			for (int i = 0; i < sTokens.size(); i++) {
				sLemmaAnno = SaltFactory.createSLemmaAnnotation();
				sLemmaAnno.setValue(posAnnotations[i]);
				sTokens.get(i).addAnnotation(sLemmaAnno);
			}
		}// adding lemma annotations

	}

	/**
	 * Creates {@link SSpan} object above the tokenization.
	 * <table border="1">
	 * <tr>
	 * <td>contrast-focus</td>
	 * <td colspan="9">topic</td>
	 * </tr>
	 * <tr>
	 * <td>Is</td>
	 * <td>this</td>
	 * <td>example</td>
	 * <td>more</td>
	 * <td>complicated</td>
	 * <td>than</td>
	 * <td>it</td>
	 * <td>appears</td>
	 * <td>to</td>
	 * <td>be</td>
	 * </tr>
	 * </table>
	 * 
	 * @param document
	 */
	public static void createInformationStructureSpan(SDocument document) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		if (document.getDocumentGraph() == null) {
			document.setDocumentGraph(SaltFactory.createSDocumentGraph());
		}
		if ((document.getDocumentGraph().getTokens() == null) || (document.getDocumentGraph().getTokens().size() == 0)) {
			if ((document.getDocumentGraph().getTextualDSs() == null) || (document.getDocumentGraph().getTextualDSs().size() == 0)) {
				SampleGenerator.createPrimaryData(document);
			}
			SampleGenerator.createTokens(document);
		}

		List<SToken> sTokens = Collections.synchronizedList(document.getDocumentGraph().getTokens());

		SSpan span = null;
		SSpanningRelation spanRel = null;
		// creating a span node as placeholder for information-structure
		// annotation
		span = SaltFactory.createSSpan();
		span.setName("IS_span1");
		// adding the created span to the document-graph
		document.getDocumentGraph().addNode(span);
		// creating an annotation for information-structure
		// creating a relation to connect a token with the span
		spanRel = SaltFactory.createSSpanningRelation();
		// setting the span as source of the relation
		spanRel.setSource(span);
		// setting the first token as target of the relation
		spanRel.setTarget(sTokens.get(0));
		// adding the created relation to the document-graph
		document.getDocumentGraph().addRelation(spanRel);

		span = SaltFactory.createSSpan();
		span.setName("IS_span2");
		document.getDocumentGraph().addNode(span);
		for (int i = 1; i < sTokens.size(); i++) {
			spanRel = SaltFactory.createSSpanningRelation();
			spanRel.setSource(span);
			spanRel.setTarget(sTokens.get(i));
			document.getDocumentGraph().addRelation(spanRel);
		}
	}

	/**
	 * Annotates the {@link SSpan} objects above the tokenization with
	 * information structural annotations.
	 * 
	 * @param document
	 */
	public static void createInformationStructureAnnotations(SDocument document) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		if (document.getDocumentGraph() == null) {
			document.setDocumentGraph(SaltFactory.createSDocumentGraph());
		}
		if (document.getDocumentGraph().getTextualDSs().isEmpty()) {
			createPrimaryData(document);
		}
		if (document.getDocumentGraph().getNodesByName("IS_span1").size() == 0) {
			createInformationStructureSpan(document);
		}
		SAnnotation sAnno = null;

		sAnno = SaltFactory.createSAnnotation();
		// setting the name of the annotation
		sAnno.setName("Inf-Struct");
		// setting the value of the annotation
		sAnno.setValue("contrast-focus");
		// adding the annotation to the placeholder span
		document.getDocumentGraph().getSpans().get(0).addAnnotation(sAnno);

		sAnno = SaltFactory.createSAnnotation();
		sAnno.setName("Inf-Struct");
		sAnno.setValue("topic");
		document.getDocumentGraph().getSpans().get(1).addAnnotation(sAnno);
	}

	/**
	 * Creates a syntax structure for the given {@link SDocument} object. If it
	 * does not already contain a primary text and a tokenization, this method
	 * calls {@link #createPrimaryData(SDocument)} and
	 * {@link #createTokens(SDocument)}.
	 * 
	 * @param document
	 */
	public static void createSyntaxStructure(SDocument document) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		if (document.getDocumentGraph() == null)
			document.setDocumentGraph(SaltFactory.createSDocumentGraph());

		if ((document.getDocumentGraph().getTokens() == null) || (document.getDocumentGraph().getTokens().size() == 0)) {
			if ((document.getDocumentGraph().getTextualDSs() == null) || (document.getDocumentGraph().getTextualDSs().size() == 0))
				SampleGenerator.createPrimaryData(document);
			SampleGenerator.createTokens(document);
		}
		List<SToken> sTokens = Collections.synchronizedList(document.getDocumentGraph().getTokens());

		// creating variables for the eInstance of the SaltFactory and for the
		// SDocumentGraph
		// (this is just for convenience)
		SDocumentGraph docGraph = document.getDocumentGraph();

		// creating the constituent nodes of the syntax tree
		// these nodes are of the type SStructure
		SStructure root = SaltFactory.createSStructure();
		SStructure sq = SaltFactory.createSStructure();
		SStructure np1 = SaltFactory.createSStructure();
		SStructure adjp1 = SaltFactory.createSStructure();
		SStructure adjp2 = SaltFactory.createSStructure();
		SStructure sbar = SaltFactory.createSStructure();
		SStructure s1 = SaltFactory.createSStructure();
		SStructure np2 = SaltFactory.createSStructure();
		SStructure vp1 = SaltFactory.createSStructure();
		SStructure s2 = SaltFactory.createSStructure();
		SStructure vp2 = SaltFactory.createSStructure();
		SStructure vp3 = SaltFactory.createSStructure();

		// there are two methods named "addNode" for a SDocumentGraph
		// the first one simply adds the single parameter of the type SNode to
		// the SDocumentGraph
		// the second one requires three arguments: two SNodes and a SALT_TYPE
		// this method will create a SRelation between the two SNodes. The type
		// of the SRelation is determined by
		// the SALT_TYPE, but only four SALT_TYPEs are allowed:
		// SDOMINANCE_RELATION, SPOINTING_RELATION,
		// SSPANNING_RELATION and STEXTUAL_RELATION. For the hierarchical
		// structure that is intended to build, SDOMINANCE_RELATION is used.
		// the first SNode (the source of the relation) is required to be
		// contained in the SDocumentGraph already, so when building such
		// a tree, the root node has to be added to the SDocumentGraph before
		// establishing the relations between the other nodes.

		// creating a variable for the type of relation between the constituents
		// (dominance relation)
		// (this is just for convenience)
		SALT_TYPE domRel = SALT_TYPE.SDOMINANCE_RELATION;

		// adding the root SNode to the SDocumentGraph
		docGraph.addNode(root);

		// adding the target nodes to the SDocumentGraph and creating
		// SDominanceRelations between the respective nodes
		// (addNode returns the created SDominanceRelation, but it it not used
		// here)
		docGraph.addNode(root, sq, domRel);
		docGraph.addNode(sq, sTokens.get(0), domRel); // "Is"
		docGraph.addNode(sq, np1, domRel);
		docGraph.addNode(np1, sTokens.get(1), domRel); // "this"
		docGraph.addNode(np1, sTokens.get(2), domRel); // "example"
		docGraph.addNode(sq, adjp1, domRel);
		docGraph.addNode(adjp1, adjp2, domRel);
		docGraph.addNode(adjp2, sTokens.get(3), domRel); // "more"
		docGraph.addNode(adjp2, sTokens.get(4), domRel); // "complicated"
		docGraph.addNode(adjp1, sbar, domRel);
		docGraph.addNode(sbar, sTokens.get(5), domRel); // "than"
		docGraph.addNode(sbar, s1, domRel);
		docGraph.addNode(s1, np2, domRel);
		docGraph.addNode(np2, sTokens.get(6), domRel); // "it"
		docGraph.addNode(s1, vp1, domRel);
		docGraph.addNode(vp1, sTokens.get(7), domRel); // "appears"
		docGraph.addNode(vp1, s2, domRel);
		docGraph.addNode(s2, vp2, domRel);
		docGraph.addNode(vp2, sTokens.get(8), domRel); // "to"
		docGraph.addNode(vp2, vp3, domRel);
		docGraph.addNode(vp3, sTokens.get(9), domRel); // "be"
		docGraph.addNode(root, sTokens.get(10), domRel); // "?"

		// creating a layer named "syntax" for the constituents of the tree
		SLayer syntaxLayer = SaltFactory.createSLayer();
		syntaxLayer.setName("syntax");
		docGraph.addLayer(syntaxLayer);

		// adding the constituents to the syntax layer
		syntaxLayer.getNodes().add(root);
		syntaxLayer.getNodes().add(sq);
		syntaxLayer.getNodes().add(np1);
		syntaxLayer.getNodes().add(adjp1);
		syntaxLayer.getNodes().add(adjp2);
		syntaxLayer.getNodes().add(sbar);
		syntaxLayer.getNodes().add(s1);
		syntaxLayer.getNodes().add(np2);
		syntaxLayer.getNodes().add(vp1);
		syntaxLayer.getNodes().add(s2);
		syntaxLayer.getNodes().add(vp2);
		syntaxLayer.getNodes().add(vp3);
	}

	/**
	 * This method creates the categorical annotations for the nodes of the
	 * sample syntax tree created in
	 * {@link SampleGenerator#createSyntaxStructure(SDocument)}.
	 * 
	 * @param document
	 */
	public static void createSyntaxAnnotations(SDocument document) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		if (document.getDocumentGraph() == null || document.getDocumentGraph().getLayerByName("syntax").isEmpty()) {
			createSyntaxStructure(document);
		}
		List<SStructure> sStructures = Collections.synchronizedList(document.getDocumentGraph().getStructures());
		String[] annotations = { "ROOT", "SQ", "NP", "ADJP", "ADJP", "SBar", "S", "NP", "VP", "S", "VP", "VP" };
		int i = 0;
		for (SStructure sStructure : sStructures) {
			sStructure.createAnnotation(null, "const", annotations[i]);
			i++;
		}

	}

	/**
	 * This method creates the sample's dependency annotation.
	 * 
	 * @param document
	 */
	public static void createDependencies(SDocument document) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		/* is there a document graph? */
		if (document.getDocumentGraph() == null) {
			document.setDocumentGraph(SaltFactory.createSDocumentGraph());
		}
		SDocumentGraph docGraph = document.getDocumentGraph();
		/* is there primary data? */
		if ((docGraph.getTextualDSs() == null) || (docGraph.getTextualDSs().size() == 0)) {
			SampleGenerator.createPrimaryData(document);
		}
		/* is there a tokenization of the primary data? */
		if ((docGraph.getTokens() == null) || (docGraph.getTokens().size() == 0)) {
			SampleGenerator.createTokens(document);
		}

		List<SToken> sTokens = docGraph.getSortedTokenByText();
		SLayer depLayer = SaltFactory.createSLayer();
		depLayer.setName("dependencies");
		depLayer.createMetaAnnotation(null, "tagset", "penn treebank");
		document.getDocumentGraph().addLayer(depLayer);

		/*
		 * -- create dependency annotation (PennTreebank scheme) for EXPECTED
		 * tokens --
		 */

		// cop(complicated-5, Is-1) "Is"
		SPointingRelation depRel = SaltFactory.createSPointingRelation();
		depRel.setSource(sTokens.get(4));
		depRel.setTarget(sTokens.get(0));
		depRel.createAnnotation(null, "dependency", "cop");
		docGraph.addRelation(depRel);
		depLayer.addRelation(depRel);

		// det(example-3, this-2) "this"
		depRel = SaltFactory.createSPointingRelation();
		depRel.setSource(sTokens.get(2));
		depRel.setTarget(sTokens.get(1));
		depRel.createAnnotation(null, "dependency", "det");
		docGraph.addRelation(depRel);
		depLayer.addRelation(depRel);

		// nsubj(complicated-5, example-3) "example"
		depRel = SaltFactory.createSPointingRelation();
		depRel.setSource(sTokens.get(4));
		depRel.setTarget(sTokens.get(2));
		depRel.createAnnotation(null, "dependency", "nsubj");
		docGraph.addRelation(depRel);
		depLayer.addRelation(depRel);

		// advmod(complicated-5, more-4) "more"
		depRel = SaltFactory.createSPointingRelation();
		depRel.setSource(sTokens.get(4));
		depRel.setTarget(sTokens.get(3));
		depRel.createAnnotation(null, "dependency", "advmod");
		docGraph.addRelation(depRel);
		depLayer.addRelation(depRel);

		// mark(appears-8, than-6) "than"
		depRel = SaltFactory.createSPointingRelation();
		depRel.setSource(sTokens.get(7));
		depRel.setTarget(sTokens.get(5));
		depRel.createAnnotation(null, "dependency", "mark");
		docGraph.addRelation(depRel);
		depLayer.addRelation(depRel);

		// nsubj(appears-8, it-7) "it"
		depRel = SaltFactory.createSPointingRelation();
		depRel.setSource(sTokens.get(7));
		depRel.setTarget(sTokens.get(6));
		depRel.createAnnotation(null, "dependency", "nsubj");
		docGraph.addRelation(depRel);
		depLayer.addRelation(depRel);

		// advcl(complicated-5, appears-8) "appears"
		depRel = SaltFactory.createSPointingRelation();
		depRel.setSource(sTokens.get(4));
		depRel.setTarget(sTokens.get(7));
		depRel.createAnnotation(null, "dependency", "advcl");
		docGraph.addRelation(depRel);
		depLayer.addRelation(depRel);

		// aux(be-10, to-9) "to"
		depRel = SaltFactory.createSPointingRelation();
		depRel.setSource(sTokens.get(9));
		depRel.setTarget(sTokens.get(8));
		depRel.createAnnotation(null, "dependency", "aux");
		docGraph.addRelation(depRel);
		depLayer.addRelation(depRel);

		// xcomp(appears-8, be-10) "be"
		depRel = SaltFactory.createSPointingRelation();
		depRel.setSource(sTokens.get(7));
		depRel.setTarget(sTokens.get(9));
		depRel.createAnnotation(null, "dependency", "xcomp");
		docGraph.addRelation(depRel);
		depLayer.addRelation(depRel);
	}

	/**
	 * 
	 * @param document
	 */
	public static void createAnaphoricAnnotations(SDocument document) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}
		if (document.getDocumentGraph() == null) {
			createPrimaryData(document);
			createTokens(document);
		}
		List<SToken> sTokens = Collections.synchronizedList(document.getDocumentGraph().getTokens());

		// creating a span as placeholder, which contains the tokens for "this"
		// and "example"
		SSpan sSpan = SaltFactory.createSSpan();
		// adding the created span to the document-graph
		document.getDocumentGraph().addNode(sSpan);

		// creating a relation between the span and the tokens
		SSpanningRelation sSpanRel = null;
		sSpanRel = SaltFactory.createSSpanningRelation();
		sSpanRel.setSource(sSpan);
		sSpanRel.setTarget(sTokens.get(1));
		document.getDocumentGraph().addRelation(sSpanRel);
		sSpanRel = SaltFactory.createSSpanningRelation();
		sSpanRel.setSource(sSpan);
		sSpanRel.setTarget(sTokens.get(2));
		document.getDocumentGraph().addRelation(sSpanRel);

		// creating a pointing relations
		SPointingRelation sPointingRelation = SaltFactory.createSPointingRelation();
		// setting token "it" as source of this relation
		sPointingRelation.setSource(sTokens.get(6));
		// setting span "this example" as target of this relation
		sPointingRelation.setTarget(sSpan);
		// adding the created relation to the document-graph
		document.getDocumentGraph().addRelation(sPointingRelation);
		// adding the type to the relation
		sPointingRelation.setType("anaphoric");
		// creating an anaphoric relation with the use of pointing relations
		// between the Tokens {"it"} and {"this", "example"}

	}

	/**
	 * 
	 * @param document
	 */
	public static void createSDocumentStructure(SDocument document) {
		if (document == null) {
			throw new SaltSampleException("Cannot create example, because the given document is empty.");
		}

		// create SDocumentGraph object and set it to SDocument object
		document.setDocumentGraph(SaltFactory.createSDocumentGraph());
		// create the primary text
		createPrimaryData(document);
		// create tokenization
		createTokens(document);
		// create token Annotations
		createMorphologyAnnotations(document);
		// create spans
		createInformationStructureSpan(document);
		// create span annotations
		createInformationStructureAnnotations(document);
		// create Structures
		createSyntaxStructure(document);
		// create Structure annotations
		createSyntaxAnnotations(document);
		// create pointing relations
		createAnaphoricAnnotations(document);
	}
}
