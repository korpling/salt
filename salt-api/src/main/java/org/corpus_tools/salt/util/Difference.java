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
package org.corpus_tools.salt.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.graph.IdentifiableElement;
import org.corpus_tools.salt.graph.Label;

/**
 * Objects of this class are produces by
 * {@link SDocumentGraph#findDiffs(SDocumentGraph)} to determine differences
 * between two {@link SDocumentGraph} objects.
 * 
 * @author florian
 */
@SuppressWarnings("serial")
public class Difference implements Serializable {
	/** Object of graph template, if this difference type has one **/
	public Object templateObject;
	/** Object of graph other, if this difference type has one **/
	public Object otherObject;
	/** Object containing the given object, e.g. used for layers **/
	public Object container;
	/** type of the difference **/
	public DIFF_TYPES diffType;

	public Set<Difference> subDiffs = null;

	public void addSubDiffs(Set<Difference> subDiffs) {
		this.subDiffs = subDiffs;
	}

	public Difference(Object templateObject, Object otherObject, Object container, DIFF_TYPES diffType) {
		this.templateObject = templateObject;
		this.otherObject = otherObject;
		this.container = container;
		this.diffType = diffType;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(diffType.toString());

		str.append(" compared <");
		if (templateObject != null) {
			if (templateObject instanceof IdentifiableElement) {
				str.append(((IdentifiableElement) templateObject).getId());
			} else if (templateObject instanceof Label) {
				Label label = (Label) templateObject;
				str.append(label.toString());
			}
		}
		str.append("> with <");

		if (otherObject != null) {
			if (otherObject instanceof IdentifiableElement) {
				str.append(((IdentifiableElement) otherObject).getId());
			} else if (otherObject instanceof Label) {
				Label label = (Label) otherObject;
				str.append(label.toString());
			}
		}
		str.append(">");

		if (subDiffs != null) {
			str.append(" because of:");
			Iterator<Difference> iterator = subDiffs.iterator();
			while (iterator.hasNext()) {
				str.append("\n	" + iterator.next().toString());
			}
		}

		return str.toString();
	}
}
