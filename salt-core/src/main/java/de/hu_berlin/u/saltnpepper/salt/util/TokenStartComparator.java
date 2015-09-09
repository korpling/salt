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
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltParameterException;

/**
 * 
 * @author Florian Zipser
 */
public class TokenStartComparator implements Comparator<SToken> {
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
	public int compare(SToken o1, SToken o2) {
		int retVal = 0;
		if (o1 == null) {
			new SaltParameterException("Cannot compare the given SToken-objects, bacause first one is null.");
		}
		if (o2 == null) {
			new SaltParameterException("Cannot compare the given SToken-objects, bacause second one is null.");
		}
		STextualRelation sTextRelO1 = null;
		for (SRelation rel : getDocumentGraph().getOutRelations(o1.getId())) {
			if (rel instanceof STextualRelation) {
				sTextRelO1 = (STextualRelation) rel;
				break;
			}
		}

		STextualRelation sTextRelO2 = null;
		for (SRelation rel : getDocumentGraph().getOutRelations(o2.getId())) {
			if (rel instanceof STextualRelation) {
				sTextRelO2 = (STextualRelation) rel;
				break;
			}
		}

		// both tokens are equal
		if (sTextRelO1.getStart().equals(sTextRelO2.getStart())) {
			retVal = 0;
		} else if (sTextRelO1.getStart() < sTextRelO2.getStart()) {
			retVal = -1;
		} else if (sTextRelO1.getStart() > sTextRelO2.getStart()) {
			retVal = 1;
		}

		return (retVal);
	}
}
