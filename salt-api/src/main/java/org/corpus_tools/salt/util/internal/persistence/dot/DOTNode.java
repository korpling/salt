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
package org.corpus_tools.salt.util.internal.persistence.dot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DOTNode {
	public String id = null;
	public String shape = null;
	public String color = null;
	public String style = null;
	public List<String> labels = new ArrayList<>();

	public String toString() {
		StringBuilder retStr = new StringBuilder();
		// print name of node
		retStr.append("<");
		retStr.append(id);
		retStr.append(">");

		// open properties
		retStr.append("[");

		List<String> props = new LinkedList<String>();
		if (shape != null) {
			props.add("shape=" + shape);
		}
		if (color != null) {
			props.add("color=" + color);
		}
		if (style != null) {
			props.add("style=" + style);
		}

		if ((labels != null) && (labels.size() > 0)) {
			StringBuilder labelStr = new StringBuilder(); 
			labelStr.append("label=\"{{" + id + "}|");
			boolean printSep = false;
			for (String label : labels) {
				if (printSep) {
					labelStr.append("|");
				}
				printSep = true;
				labelStr.append("{" + label + "}");
			}
			labelStr.append("}\"");
			props.add(labelStr.toString());
		}

		Iterator<String> it = props.iterator();
		while (it.hasNext()) {
			retStr.append(it.next());
			if (it.hasNext()) {
				retStr.append(",");
			}
		}

		// close properties
		retStr.append("];");
		return (retStr.toString());
	}
}
