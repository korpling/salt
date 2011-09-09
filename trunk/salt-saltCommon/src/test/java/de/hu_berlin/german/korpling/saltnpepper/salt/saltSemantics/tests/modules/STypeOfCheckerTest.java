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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.tests.modules;

import junit.framework.TestCase;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.modules.STypeOfChecker;

public class STypeOfCheckerTest extends TestCase 
{
	private STypeOfChecker fixture= null;

	public void setFixture(STypeOfChecker fixture) {
		this.fixture = fixture;
	}

	public STypeOfChecker getFixture() {
		return fixture;
	}
	
	public void testIsOfTypeSentence()
	{
		SSpan span= SaltCommonFactory.eINSTANCE.createSSpan();
		assertFalse(STypeOfChecker.isOfTypeSentence(span));
		
		span.addSAnnotation(SaltSemanticsFactory.eINSTANCE.createSSentenceAnnotation());
		assertTrue(STypeOfChecker.isOfTypeSentence(span));
	}
	
	public void testIsOfTypeWord()
	{
		SSpan span= SaltCommonFactory.eINSTANCE.createSSpan();
		assertFalse(STypeOfChecker.isOfTypeWord(span));
		
		span.addSAnnotation(SaltSemanticsFactory.eINSTANCE.createSWordAnnotation());
		assertTrue(STypeOfChecker.isOfTypeWord(span));
	}
	
	public void testIsOfTypeSPOSAnnotation()
	{
		SAnnotation sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
		assertFalse(STypeOfChecker.isOfTypeSPOSAnnotation(sAnno));
		
		SPOSAnnotation sPosAnno= SaltSemanticsFactory.eINSTANCE.createSPOSAnnotation();
		assertTrue(STypeOfChecker.isOfTypeSPOSAnnotation(sPosAnno));
		
		sAnno.setSNS(sPosAnno.getSNS());
		sAnno.setSName(sPosAnno.getSName());
		assertTrue(STypeOfChecker.isOfTypeSPOSAnnotation(sAnno));
	}
	
	public void testIsOfTypeSLemmaAnnotation()
	{
		SAnnotation sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
		assertFalse(STypeOfChecker.isOfTypeSLemmaAnnotation(sAnno));
		
		SLemmaAnnotation sLemmaAnno= SaltSemanticsFactory.eINSTANCE.createSLemmaAnnotation();
		assertTrue(STypeOfChecker.isOfTypeSLemmaAnnotation(sLemmaAnno));
		
		sAnno.setSNS(sLemmaAnno.getSNS());
		sAnno.setSName(sLemmaAnno.getSName());
		assertTrue(STypeOfChecker.isOfTypeSLemmaAnnotation(sAnno));
	}
}
