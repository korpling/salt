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
package de.hu_berlin.u.saltnpepper.salt.util.internal.persistence.dot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DOTEdge {
	public String fromId = null;
	public String toId = null;
	public String color = null;
	public String style = null;
	public List<String> labels = new ArrayList<>();

	public String toString() {
		String retStr = "";
		retStr = "<" + fromId + "> -> <" + toId + ">";
		// open properties
		retStr = retStr + "[";

		List<String> props = new LinkedList<String>();

		// color
		if (this.color != null) {
			props.add("color=" + color);
		}
		// style
		if (this.style != null) {
			props.add("style=" + style);
		}

		if ((labels != null) && (labels.size() > 0)) {
			String labelStr = "label=\"";
			boolean printSep = false;
			for (String label : labels) {
				if (printSep) {
					labelStr = labelStr + ", ";
				}
				printSep = true;
				labelStr = labelStr + label;
			}
			labelStr = labelStr + "\"";
			props.add(labelStr);
		}

		Iterator<String> it = props.iterator();
		while (it.hasNext()) {
			retStr += it.next();
			if (it.hasNext()) {
				retStr += ",";
			}
		}

		// close properties
		retStr = retStr + "];";
		return (retStr);
	}
}