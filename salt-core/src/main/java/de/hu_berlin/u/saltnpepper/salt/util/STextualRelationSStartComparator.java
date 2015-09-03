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
package de.hu_berlin.u.saltnpepper.salt.util;

import java.util.Comparator;

import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltParameterException;

/**
 * 
 * @author Florian Zipser
 */
public class STextualRelationSStartComparator implements Comparator<STextualRelation> {

	private SDocumentGraph documentGraph = null;

	/**
	 * Returns the {@link SDocumentGraph} object which contains the tokens to be
	 * compared.
	 * 
	 * @return documentGraph container graph
	 */
	public SDocumentGraph getDocumentGraph() {
		return documentGraph;
	}

	/**
	 * Sets the {@link SDocumentGraph} object which contains the tokens to be
	 * compared.
	 * 
	 * @param documentGraph
	 *            container graph
	 */
	public void setDocumentGraph(SDocumentGraph documentGraph) {
		this.documentGraph = documentGraph;
	}

	/**
	 * Returns -1 if o1 has less text position than o2, 0 if both have equal
	 * positions and 1 if o1 has higher text position than o2.
	 */
	@Override
	public int compare(STextualRelation o1, STextualRelation o2) {
		int retVal = 0;
		if (o1 == null) {
			new SaltParameterException("Cannot compare the given STextualRelation-objects, because first one is null.");
		}
		if (o2 == null) {
			new SaltParameterException("Cannot compare the given STextualRelation-objects, because second one is null.");
		}

		// both textual relations are equal
		if (o1.getStart().equals(o2.getStart())) {
			retVal = 0;
		} else if (o1.getStart() < o2.getStart()) {
			retVal = -1;
		} else if (o1.getStart() > o2.getStart()) {
			retVal = 1;
		}
		return (retVal);
	}
}
