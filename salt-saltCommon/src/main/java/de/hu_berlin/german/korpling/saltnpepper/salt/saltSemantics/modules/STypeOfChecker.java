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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.modules;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SSentenceAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SWordAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsFactory;


public class STypeOfChecker 
{
	/**
	 * Checks if the given SAnnotation object respresents is equals to a SPOSANnotation
	 * @param sAnno object which have to be checked
	 * @return true, iff the Annotation, is conform to SPOSAnnotation
	 */
	public static Boolean isOfTypeSPOSAnnotation(SAnnotation sAnno)
	{
		Boolean retVal= false;
		if (sAnno instanceof SPOSAnnotation)
			retVal= true;
		else
		{
			SPOSAnnotation sPosAnno= SaltSemanticsFactory.eINSTANCE.createSPOSAnnotation();
			retVal= sPosAnno.isSPOSAnnotation(sAnno);
		}
		return(retVal);
	}
	
	/**
	 * Checks if the given SAnnotation object respresents is equals to a SLemmaANnotation
	 * @param sAnno object which have to be checked
	 * @return true, iff the Annotation, is conform to SLemmaAnnotation
	 */
	public static Boolean isOfTypeSLemmaAnnotation(SAnnotation sAnno)
	{
		Boolean retVal= false;
		if (sAnno instanceof SLemmaAnnotation)
			retVal= true;
		else
		{
			SLemmaAnnotation sLemmaAnno= SaltSemanticsFactory.eINSTANCE.createSLemmaAnnotation();
			retVal= sLemmaAnno.isSLemmaAnnotation(sAnno);
		}
		return(retVal);
	}
	
	/**
	 * Checks if the given SStructuredNode object respresents the text unit 'Sentence'. This is
	 * true, iff this node has an annotation which is conform to the SSentenceAnnotation.
	 * @param sStructuredNode node which have to be checked
	 * @return true, iff the node has an Annotation, which is conform to SSentenceAnnotation
	 */
	public static Boolean isOfTypeSentence(SStructuredNode sStructuredNode)
	{
		Boolean retVal= false;
		SSentenceAnnotation sSentenceAnno= SaltSemanticsFactory.eINSTANCE.createSSentenceAnnotation();
		for (SAnnotation sAnno: sStructuredNode.getSAnnotations())
		{
			if (sSentenceAnno.isSSentenceAnnotation(sAnno))
			{
				retVal= true;
				break;
			}
		}
		return(retVal);
	}
	
	/**
	 * Checks if the given SStructuredNode object respresents the text unit 'word'. This is
	 * true, iff this node has an annotation which is conform to the SWordAnnotation.
	 * @param sStructuredNode node which have to be checked
	 * @return true, iff the node has an Annotation, which is conform to SWordAnnotation
	 */
	public static Boolean isOfTypeWord(SStructuredNode sStructuredNode)
	{
		Boolean retVal= false;
		SWordAnnotation sWordAnno= SaltSemanticsFactory.eINSTANCE.createSWordAnnotation();
		for (SAnnotation sAnno: sStructuredNode.getSAnnotations())
		{
			if (sWordAnno.isSWordAnnotation(sAnno))
			{
				retVal= true;
				break;
			}
		}
		return(retVal);
	}
}
