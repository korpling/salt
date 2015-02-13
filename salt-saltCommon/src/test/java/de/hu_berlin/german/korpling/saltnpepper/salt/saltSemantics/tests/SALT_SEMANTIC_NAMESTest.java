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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.tests;

import java.util.HashMap;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES;
import junit.framework.TestCase;

/**
 * Tests the methods isSimilar and getSaltSemanticName of enum SALT_SEMANTIC_NAMES 
 * @author hildebax
 *
 */
public class SALT_SEMANTIC_NAMESTest extends TestCase {

	public SALT_SEMANTIC_NAMESTest(String name) {
		super(name);
	}

	/**
	 * tests isSimilar and getSaltSemanticName of enum SALT_SEMANTIC_NAMES
	 */
	public void testIsSimilar() {
		HashMap<SALT_SEMANTIC_NAMES, String[]> semNameMap = new HashMap<SALT_SEMANTIC_NAMES,String[]>();
		semNameMap.put(SALT_SEMANTIC_NAMES.POS,                new String[] {"part-of-speech:Test","Part-Of-Speech:Test","PART-OF-SPEECH:Test","pos:Test","Pos:Text","POS:Test","partofspeech:Test","PartOfSpeech:Test","PARTOFSPEECH:Test"});
		semNameMap.put(SALT_SEMANTIC_NAMES.LEMMA,              new String[] {"Lemma:Test","lemma:Test","LEMMA:Test","Lemmatisation:Test","lemmatisation:Test","LEMMATISATION","Lemmatization:Test","lemmatization:Test","LEMMATIZATION:Test","Lemmata:Test","lemmata:Test","LEMMATA:Test"});
		semNameMap.put(SALT_SEMANTIC_NAMES.CAT,                new String[] {"cat:Test","Cat:Test","CAT:Test","category:Test","Category:Test","CATEGORY:Test"});
		semNameMap.put(SALT_SEMANTIC_NAMES.TYPE,               new String[] {});
		semNameMap.put(SALT_SEMANTIC_NAMES.TEXT_UNIT,          new String[] {});
		semNameMap.put(SALT_SEMANTIC_NAMES.TEXT_UNIT_WORD,     new String[] {"word:Test","Word:Test","WORD:Test"});
	    semNameMap.put(SALT_SEMANTIC_NAMES.TEXT_UNIT_SENTENCE, new String[] {"sentence:Test","Sentence:Test","SENTENCE:Test"});
		
		SAnnotation sAnnotation = SaltCommonFactory.eINSTANCE.createSAnnotation();
		for (SALT_SEMANTIC_NAMES mapSemName:SALT_SEMANTIC_NAMES.VALUES) {
			for (SALT_SEMANTIC_NAMES testSemName:SALT_SEMANTIC_NAMES.VALUES) {
				for (String testString:semNameMap.get(testSemName)) {
					sAnnotation.setQName(testString);
					if (mapSemName.equals(testSemName)) {
						assertEquals(true, SALT_SEMANTIC_NAMES.isSimilar(sAnnotation, mapSemName));
						assertEquals(mapSemName, SALT_SEMANTIC_NAMES.getSaltSemanticName(sAnnotation));
					}
					else {
						assertEquals(false, SALT_SEMANTIC_NAMES.isSimilar(sAnnotation, mapSemName));
						if (SALT_SEMANTIC_NAMES.getSaltSemanticName(sAnnotation).equals(mapSemName)) {
							fail("return value of getSaltSemanticName is wrong");
						}
					}
				}
			}
		}
	}

	/**
	 * calls testIsSimilar
	 */
	public void testGetSaltSemanticName() {
		testIsSimilar();
	}

}
