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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;

public class SFeaturableElementAccessor 
{
	public void addSFeature(	SFeaturableElement sFeatElem,
								SFeature SFeature) 
	{
		sFeatElem.addLabel(SFeature);
	}

	public SFeature getSFeature(	SFeaturableElement sFeatElem,
									String fullName) 
	{
		SFeature sFeatAnno= null;
		Label label= sFeatElem.getLabel(fullName);
		if (label instanceof SFeature)
			sFeatAnno= (SFeature) label;
		return(sFeatAnno);
	}

	@SuppressWarnings("unchecked")
	public EList<SFeature> getSFeatures(SFeaturableElement sFeatElem) 
	{
		EList<SFeature> sFeatAnnos= null;
		ArrayList<SFeature> sFeatAnnosList = new ArrayList<SFeature>();
		for (Label label: sFeatElem.getLabels() ) 
		{
			if (label instanceof SFeature)
				sFeatAnnosList.add((SFeature) label);
		}
		sFeatAnnos= new EcoreEList.UnmodifiableEList((InternalEObject)sFeatElem,
												SaltCorePackage.eINSTANCE.getSFeaturableElement_SFeatures(),
												sFeatAnnosList.size(), sFeatAnnosList.toArray());
		return(sFeatAnnos);	
	}
	
	/**
	 * Returns a SFeature-object with the given namespace and name.
	 * @param sNamespace namespace of searched feature 
	 * @param sFeatureName name of searched feature 
	 */
	public SFeature getSFeature(	SFeaturableElement sFeatElem, 
									String sNamespace, 
									String sFeatureName) 
	{
		SFeature retVal= null;
		Label label= sFeatElem.getLabel(sNamespace, sFeatureName);
		if (label instanceof SFeature)
			retVal= (SFeature) label;
		return(retVal);
	}
	
	public SFeature createSFeature(SFeaturableElement sFeatElem, String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		SFeature retVal = SaltCoreFactory.eINSTANCE.createSFeature();
		retVal.setSNS(sNS);
		retVal.setSName(sName);
		retVal.setSValue(sValue);
		sFeatElem.addSFeature(retVal);
		return retVal;
	}

}
