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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

public class SProcessingAnnotatableElementAccessor 
{
	public void addSProcessingAnnotation(	SProcessingAnnotatableElement sProcElem,
											SProcessingAnnotation sProcessingAnnotation) 
	{
		sProcElem.addLabel(sProcessingAnnotation);
	}

	public SProcessingAnnotation getSProcessingAnnotation(	SProcessingAnnotatableElement sProcElem,
															String qName) 
	{
		SProcessingAnnotation sProcAnno= null;
		Label label= sProcElem.getLabel(qName);
		if (label instanceof SProcessingAnnotation)
			sProcAnno= (SProcessingAnnotation) label;
		return(sProcAnno);
	}

	@SuppressWarnings("unchecked")
	public EList<SProcessingAnnotation> getSProcessingAnnotations(SProcessingAnnotatableElement sProcElem) 
	{
		EList<SProcessingAnnotation> sProcAnnos= null;
		ArrayList<SProcessingAnnotation> sProcAnnosList = new ArrayList<SProcessingAnnotation>();
		for (Label label: sProcElem.getLabels() ) 
		{
			if (label instanceof SProcessingAnnotation)
				sProcAnnosList.add((SProcessingAnnotation) label);
		}
		sProcAnnos= new EcoreEList.UnmodifiableEList((InternalEObject)sProcElem,
												SaltCorePackage.eINSTANCE.getSProcessingAnnotatableElement_SProcessingAnnotations(),
												sProcAnnosList.size(), sProcAnnosList.toArray());
		return(sProcAnnos);	
	}

	public SProcessingAnnotation createSProcessingAnnotation(SProcessingAnnotatableElement sProcElem, String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		SProcessingAnnotation retVal = SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
		retVal.setSNS(sNS);
		retVal.setSName(sName);
		retVal.setSValue(sValue);
		sProcElem.addSProcessingAnnotation(retVal);
		return retVal;
	}

}
