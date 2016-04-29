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
package org.corpus_tools.salt.common.tokenizer.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Vector;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.tokenizer.Tokenizer;
import org.junit.Before;
import org.junit.Test;

import com.neovisionaries.i18n.LanguageCode;

/**
 * 
 * Tests the class TTTokenizer.
 * 
 * @author Florian Zipser
 *
 */
public class TokenizerTest {
	private Tokenizer fixture = null;

	/**
	 * @param fixture
	 *            the fixture to set
	 */
	public void setFixture(Tokenizer fixture) {
		this.fixture = fixture;
	}

	/**
	 * @return the fixture
	 */
	public Tokenizer getFixture() {
		return fixture;
	}

	@Before
	public void setUp() {
		this.setFixture(new Tokenizer());
	}

	@Test
	public void testLANGUAGE_DESCRIPTION() {
		assertEquals(LanguageCode.de, getFixture().mapISOLanguageCode("german"));
		assertEquals(LanguageCode.en, getFixture().mapISOLanguageCode("english"));
		assertEquals(LanguageCode.fr, getFixture().mapISOLanguageCode("french"));
		assertEquals(LanguageCode.it, getFixture().mapISOLanguageCode("italian"));
	}

	@Test
	public void testDetectLanguage() {
		String text = null;

		text = "The Java Text Categorizing Library (JTCL) is a pure java 1.5 implementation of libTextCat which in turn is \"a library that was primarily developed for language guessing, a task on which it is known to perform with near-perfect accuracy\".";
		assertEquals(LanguageCode.en, getFixture().checkLanguage(text));

		text = "Die Java-Text Kategorisierung Library (JTCL) ist eine reine Java 1.5 Implementierung von libtextcat die wiederum \"eine Bibliothek, die vor allem für die Sprache zu raten, eine Aufgabe, auf denen bekannt ist, mit nahezu perfekter Genauigkeit durchzuführen ist, wurde entwickelt.\"";
		assertEquals(LanguageCode.de, getFixture().checkLanguage(text));

		text = "La bibliothèque Java Catégorisation Texte (JTCL) est un pur Java 1.5 mise en œuvre de libtextcat qui à son tour \"une bibliothèque qui a été développé pour la langue deviner Primar, une tâche sur laquelle il est connu de réaliser avec une précision quasi-parfaite.\"";
		assertEquals(LanguageCode.fr, getFixture().checkLanguage(text));

		text = "Text Library Java Categorizzare (JTCL) è un puro Java 1.5 realizzazione di libtextcat che a sua volta è \"una libreria che è stato sviluppato per la lingua indovinare Primar, un compito su cui è conosciuto per eseguire con precisione quasi perfetta.\"";
		assertEquals(LanguageCode.it, getFixture().checkLanguage(text));
	}

	// TODO test the detection of abbreviations, by 1) giving a specific file,
	// 2) giving a folder (giving a language and not) and 3) using default
	// abbrevs
	static class Token {
		String text;
		Integer startPos;
		Integer endPos;

		public Token(String text, int startPos, int endPos) {
			this.text = text;
			this.startPos = startPos;
			this.endPos = endPos;
		}
	}

	public List<Token> createCase1() {
		List<Token> expectedToken = new Vector<Token>();
		expectedToken.add(new Token("Die", 0, 3));
		expectedToken.add(new Token("Ölpest", 4, 10));
		expectedToken.add(new Token("im", 11, 13));
		expectedToken.add(new Token("Golf", 14, 18));
		expectedToken.add(new Token("von", 19, 22));
		expectedToken.add(new Token("Mexiko", 23, 29));
		expectedToken.add(new Token("sei", 30, 33));
		expectedToken.add(new Token("eine", 34, 38));
		expectedToken.add(new Token("\"", 39, 40));
		expectedToken.add(new Token("f�rchterliche", 40, 53));
		expectedToken.add(new Token("Trag�die", 54, 62));
		expectedToken.add(new Token(",", 62, 63));
		expectedToken.add(new Token("f�r", 64, 67));
		expectedToken.add(new Token("die", 68, 71));
		expectedToken.add(new Token("ich", 72, 75));
		expectedToken.add(new Token("als", 76, 79));
		expectedToken.add(new Token("Verantwortlicher", 80, 96));
		expectedToken.add(new Token("bei", 97, 100));
		expectedToken.add(new Token("BP", 101, 103));
		expectedToken.add(new Token("immer", 104, 109));
		expectedToken.add(new Token("eine", 110, 114));
		expectedToken.add(new Token("gro�e", 115, 120));
		expectedToken.add(new Token("Verantwortung", 121, 134));
		expectedToken.add(new Token("f�hlen", 135, 141));
		expectedToken.add(new Token("werde", 142, 147));
		expectedToken.add(new Token("\"", 147, 148));
		expectedToken.add(new Token(",", 148, 149));
		expectedToken.add(new Token("erkl�rte", 150, 158));
		expectedToken.add(new Token("der", 159, 162));
		expectedToken.add(new Token("scheidende", 163, 173));
		expectedToken.add(new Token("Konzernchef", 174, 185));
		expectedToken.add(new Token("Hayward", 186, 193));
		expectedToken.add(new Token(".", 193, 194));
		expectedToken.add(new Token("BP", 195, 197));
		expectedToken.add(new Token("werde", 198, 203));
		expectedToken.add(new Token("sich", 204, 208));
		expectedToken.add(new Token("durch", 209, 214));
		expectedToken.add(new Token("den", 215, 218));
		expectedToken.add(new Token("Vorfall", 219, 226));
		expectedToken.add(new Token("ver�ndern", 227, 236));
		expectedToken.add(new Token("und", 237, 240));
		expectedToken.add(new Token("solle", 241, 246));
		expectedToken.add(new Token("unter", 247, 252));
		expectedToken.add(new Token("neuer", 253, 258));
		expectedToken.add(new Token("F�hrung", 259, 266));
		expectedToken.add(new Token("in", 267, 269));
		expectedToken.add(new Token("diese", 270, 275));
		expectedToken.add(new Token("Phase", 276, 281));
		expectedToken.add(new Token("starten", 282, 289));
		expectedToken.add(new Token(",", 289, 290));
		expectedToken.add(new Token("begr�ndete", 291, 301));
		expectedToken.add(new Token("er", 302, 304));
		expectedToken.add(new Token("seinen", 305, 311));
		expectedToken.add(new Token("R�ckzug", 312, 319));
		expectedToken.add(new Token("zum", 320, 323));
		expectedToken.add(new Token("1.", 324, 326));
		expectedToken.add(new Token("Oktober", 327, 334));
		expectedToken.add(new Token(".", 334, 335));
		return (expectedToken);
	}

	/**
	 * checks the following text via TokenizeToToken:
	 * "Die �lpest im Golf von Mexiko sei eine \"f�rchterliche Trag�die, f�r die ich als Verantwortlicher bei BP immer eine gro�e Verantwortung f�hlen werde\", erkl�rte der scheidende Konzernchef Hayward. BP werde sich durch den Vorfall ver�ndern und solle unter neuer F�hrung in diese Phase starten, begr�ndete er seinen R�ckzug zum 1. Oktober."
	 */
	@Test
	public void testCase1() {
		String text = "Die Ölpest im Golf von Mexiko sei eine \"f�rchterliche Trag�die, f�r die ich als Verantwortlicher bei BP immer eine gro�e Verantwortung f�hlen werde\", erkl�rte der scheidende Konzernchef Hayward. BP werde sich durch den Vorfall ver�ndern und solle unter neuer F�hrung in diese Phase starten, begr�ndete er seinen R�ckzug zum 1. Oktober.";
		List<Token> expectedToken = this.createCase1();

		SDocumentGraph sDocGraph = SaltFactory.createSDocumentGraph();
		STextualDS sTextualDS = sDocGraph.createTextualDS(text);
		getFixture().setsDocumentGraph(sDocGraph);
		getFixture().tokenize(sTextualDS);

		assertEquals(expectedToken.size(), sDocGraph.getTokens().size());

		int i = 0;
		for (STextualRelation sTextRel : sDocGraph.getTextualRelations()) {
			assertTrue(expectedToken.size() >= i);
			assertNotNull(expectedToken.get(i));
			assertNotNull(sTextRel.getSource());
			assertNotNull(sTextRel.getTarget());
			assertEquals(expectedToken.get(i).startPos, sTextRel.getStart());
			assertEquals(expectedToken.get(i).endPos, sTextRel.getEnd());
			assertEquals(expectedToken.get(i).text, sTextRel.getTarget().getText().substring(sTextRel.getStart(), sTextRel.getEnd()));
			i++;
		}
	}

	/**
	 * checks the following text via TokenizeToText:
	 * "Die �lpest im Golf von Mexiko sei eine \"f�rchterliche Trag�die, f�r die ich als Verantwortlicher bei BP immer eine gro�e Verantwortung f�hlen werde\", erkl�rte der scheidende Konzernchef Hayward. BP werde sich durch den Vorfall ver�ndern und solle unter neuer F�hrung in diese Phase starten, begr�ndete er seinen R�ckzug zum 1. Oktober."
	 */
	@Test
	public void testCase2() {
		String text = "Die Ölpest im Golf von Mexiko sei eine \"f�rchterliche Trag�die, f�r die ich als Verantwortlicher bei BP immer eine gro�e Verantwortung f�hlen werde\", erkl�rte der scheidende Konzernchef Hayward. BP werde sich durch den Vorfall ver�ndern und solle unter neuer F�hrung in diese Phase starten, begr�ndete er seinen R�ckzug zum 1. Oktober.";
		List<Token> expectedToken = this.createCase1();

		SDocumentGraph sDocGraph = SaltFactory.createSDocumentGraph();
		STextualDS sTextualDS = sDocGraph.createTextualDS(text);
		getFixture().setsDocumentGraph(sDocGraph);
		getFixture().tokenize(sTextualDS, LanguageCode.de);

		assertEquals(expectedToken.size(), sDocGraph.getTokens().size());

		int i = 0;
		for (STextualRelation sTextRel : sDocGraph.getTextualRelations()) {
			assertTrue(expectedToken.size() >= i);
			assertNotNull(expectedToken.get(i));
			assertNotNull(sTextRel.getSource());
			assertNotNull(sTextRel.getTarget());
			assertEquals(expectedToken.get(i).startPos, sTextRel.getStart());
			assertEquals(expectedToken.get(i).endPos, sTextRel.getEnd());
			assertEquals(expectedToken.get(i).text, sTextRel.getTarget().getText().substring(sTextRel.getStart(), sTextRel.getEnd()));
			i++;
		}
	}

	/**
	 * checks the following text via TokenizeToToken, tests tokenizing with
	 * starting blank " Die"
	 */
	@Test
	public void testCase4() {
		String text = "Die Ölpest";
		List<Token> expectedToken = null;

		expectedToken = new Vector<Token>();
		expectedToken.add(new Token("Die", 0, 3));
		expectedToken.add(new Token("Ölpest", 4, 10));

		SDocumentGraph sDocGraph = SaltFactory.createSDocumentGraph();
		STextualDS sTextualDS = sDocGraph.createTextualDS(text);
		getFixture().setsDocumentGraph(sDocGraph);
		getFixture().tokenize(sTextualDS, LanguageCode.de);

		assertEquals(expectedToken.size(), sDocGraph.getTokens().size());

		int i = 0;
		for (STextualRelation sTextRel : sDocGraph.getTextualRelations()) {
			assertTrue(expectedToken.size() >= i);
			assertNotNull(expectedToken.get(i));
			assertNotNull(sTextRel.getSource());
			assertNotNull(sTextRel.getTarget());
			assertEquals(expectedToken.get(i).startPos, sTextRel.getStart());
			assertEquals(expectedToken.get(i).endPos, sTextRel.getEnd());
			assertEquals(expectedToken.get(i).text, sTextRel.getTarget().getText().substring(sTextRel.getStart(), sTextRel.getEnd()));
			i++;
		}
	}

	/**
	 * checks the following text via TokenizeToToken, tests tokenizing with
	 * ending blank "Feigenblatt  "
	 */
	@Test
	public void testCase5() {
		String text = "Feigenblatt  ";
		List<Token> expectedToken = null;

		expectedToken = new Vector<Token>();
		expectedToken.add(new Token("Feigenblatt", 0, 11));

		SDocumentGraph sDocGraph = SaltFactory.createSDocumentGraph();
		STextualDS sTextualDS = sDocGraph.createTextualDS(text);
		getFixture().setsDocumentGraph(sDocGraph);
		getFixture().tokenize(sTextualDS, LanguageCode.de);

		assertEquals(expectedToken.size(), sDocGraph.getTokens().size());

		int i = 0;
		for (STextualRelation sTextRel : sDocGraph.getTextualRelations()) {
			assertTrue(expectedToken.size() >= i);
			assertNotNull(expectedToken.get(i));
			assertNotNull(sTextRel.getSource());
			assertNotNull(sTextRel.getTarget());
			assertEquals(expectedToken.get(i).startPos, sTextRel.getStart());
			assertEquals(expectedToken.get(i).endPos, sTextRel.getEnd());
			assertEquals(expectedToken.get(i).text, sTextRel.getTarget().getText().substring(sTextRel.getStart(), sTextRel.getEnd()));
			i++;
		}
	}

	/**
	 * checks the following text via TokenizeToToken, tests tokenizing two times
	 * with same TTTokenizer object " Die"
	 */
	@Test
	public void testCase6() {
		String text = "Die Ölpest";
		List<Token> expectedToken = null;

		expectedToken = new Vector<Token>();
		expectedToken.add(new Token("Die", 0, 3));
		expectedToken.add(new Token("Ölpest", 4, 10));

		SDocumentGraph sDocGraph = SaltFactory.createSDocumentGraph();
		STextualDS sTextualDS = sDocGraph.createTextualDS(text);
		getFixture().setsDocumentGraph(sDocGraph);
		getFixture().tokenize(sTextualDS, LanguageCode.de);

		assertEquals(expectedToken.size(), sDocGraph.getTokens().size());

		int i = 0;
		for (STextualRelation sTextRel : sDocGraph.getTextualRelations()) {
			assertTrue(expectedToken.size() >= i);
			assertNotNull(expectedToken.get(i));
			assertNotNull(sTextRel.getSource());
			assertNotNull(sTextRel.getTarget());
			assertEquals(expectedToken.get(i).startPos, sTextRel.getStart());
			assertEquals(expectedToken.get(i).endPos, sTextRel.getEnd());
			assertEquals(expectedToken.get(i).text, sTextRel.getTarget().getText().substring(sTextRel.getStart(), sTextRel.getEnd()));
			i++;
		}
	}

	/**
	 * checks the following text via TokenizeToToken:
	 * "O.K., so the answer's obvious."
	 */
	@Test
	public void testCase7() {
		String text = "O.K., so the answer's obvious.";
		List<Token> expectedToken = new Vector<Token>();
		expectedToken.add(new Token("O.K.", 0, 4));
		expectedToken.add(new Token(",", 4, 5));
		expectedToken.add(new Token("so", 6, 8));
		expectedToken.add(new Token("the", 9, 12));
		expectedToken.add(new Token("answer", 13, 19));
		expectedToken.add(new Token("'s", 19, 21));
		expectedToken.add(new Token("obvious", 22, 29));
		expectedToken.add(new Token(".", 29, 30));

		SDocumentGraph sDocGraph = SaltFactory.createSDocumentGraph();
		STextualDS sTextualDS = sDocGraph.createTextualDS(text);
		getFixture().setsDocumentGraph(sDocGraph);
		getFixture().tokenize(sTextualDS, LanguageCode.en);

		assertEquals(expectedToken.size(), sDocGraph.getTokens().size());
		
		int i = 0;
		for (STextualRelation sTextRel : sDocGraph.getTextualRelations()) {
			assertTrue(expectedToken.size() >= i);
			assertNotNull(expectedToken.get(i));
			assertNotNull(sTextRel.getSource());
			assertNotNull(sTextRel.getTarget());
			assertEquals(expectedToken.get(i).startPos, sTextRel.getStart());
			assertEquals(expectedToken.get(i).endPos, sTextRel.getEnd());
			assertEquals(expectedToken.get(i).text, sTextRel.getTarget().getText().substring(sTextRel.getStart(), sTextRel.getEnd()));
			i++;
		}
	}
	
	@Test
	public void testDefaultCliticsWithExplicitLanguage() {
		String text = "ou ceux-là mêmes qu'il s'affirmaient";
//		String text = "Riuscire all'università spesso significa riuscire il primo anno, quando intorno ai giovani studenti regna incontrastato l'anonimato e l'incertezza. È per questo che l'Unione degli Universitari organizza ogni anno per tutti i nuovi studenti dei banchetti di informazione e di accoglienza, in cui viene distribuito del materiale informativo. Lo scopo? Permettere ai nuovi arrivati di capire il funzionamento dell'università, l'organizzazione degli studi, il metodo di lavoro migliore e soprattutto come evitare scogli noti ormai so lo ai veterani. La prima cosa da capire è che gli studi all'università sono completamente differenti da quelli liceali e che necessitano, per questo, di un diverso approccio e in particolare, di una grande capacità di autogestirsi. Non avrete più infatti il professore che sceglierà per voi le tematiche da affrontare nè le interrogazioni giornaliere a scandire i tempi dei vostri studi. Dovrete fare tutto da soli. Per questo è importante seguire, almeno per i primi mesi, i corsi dei professori. Sappiamo che questo potrebbe risultare stressante soprattutto per quanti credevano di aver finalmente chiuso con levatacce di primo mattino e con ore passate immobili nei banchi. È bene sapere infatti che in tutte le università le lezio ni del primo anno risultano sempre piuttosto affollate";
		List<Token> expectedToken = new Vector<Token>();
//		expectedToken.add(new Token("Riuscire", 0, 8));
//		expectedToken.add(new Token("all'", 9, 13));
//		expectedToken.add(new Token("università", 13, 23));

		expectedToken.add(new Token("ou", 0, 2));
		expectedToken.add(new Token("ceux", 3, 7));
		expectedToken.add(new Token("-là", 7, 10));
		expectedToken.add(new Token("mêmes", 11, 16));
		expectedToken.add(new Token("qu'", 17, 20));
		expectedToken.add(new Token("il", 20, 22));
		expectedToken.add(new Token("s-", 23, 25));
		expectedToken.add(new Token("affirmaient", 25, 36));

		
		SDocumentGraph sDocGraph = SaltFactory.createSDocumentGraph();
		STextualDS sTextualDS = sDocGraph.createTextualDS(text);
		getFixture().setsDocumentGraph(sDocGraph);
//		getFixture().tokenize(sTextualDS, LanguageCode.it);
		getFixture().tokenize(sTextualDS, LanguageCode.fr);
		
		int i = 0;
		for (STextualRelation sTextRel : sDocGraph.getTextualRelations()) {
			assertTrue(expectedToken.size() >= i);
			assertNotNull(expectedToken.get(i));
			assertNotNull(sTextRel.getSource());
			assertNotNull(sTextRel.getTarget());
			assertEquals(expectedToken.get(i).startPos, sTextRel.getStart());
			assertEquals(expectedToken.get(i).endPos, sTextRel.getEnd());
			assertEquals(expectedToken.get(i).text, sTextRel.getTarget().getText().substring(sTextRel.getStart(), sTextRel.getEnd()));
			i++;
		}
		
		System.out.println("FINAL TOKENS:\n");
		int y = 1;
		for (STextualRelation sTextRel : sDocGraph.getTextualRelations()) {
			System.out.println(y + ": " + sTextRel.getTarget().getText().substring(sTextRel.getStart(), sTextRel.getEnd()));
			y++;
		}

	}
}
