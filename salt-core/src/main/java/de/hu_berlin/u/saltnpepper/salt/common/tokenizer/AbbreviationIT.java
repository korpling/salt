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
package de.hu_berlin.u.saltnpepper.salt.common.tokenizer;

import java.util.HashSet;

/**
 * This offers a set of italian abbreviations. The set is supplied by a
 * {@link HashSet} object which is returned, when calling the method
 * {@link #createAbbriviations()}. The returned object is a static one and
 * therefore initialized only once. The set of abbreviations is reimplemented in
 * Java with permission from the original abbreviation sets used by the
 * TreeTagger by Helmut Schmid (see
 * http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/).
 * 
 * @author Florian Zipser
 *
 */
public class AbbreviationIT {
	/**
	 * all abbreviations
	 */
	private static HashSet<String> abbreviations = null;

	public static synchronized HashSet<String> createAbbriviations() {
		if (abbreviations == null) {
			abbreviations = init();
		}
		return (abbreviations);
	}

	/**
	 * Returns a set of italian abbreviations, used by the TreeTagger by Helmut
	 * Schmid (see
	 * http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/).
	 * 
	 * @return set of italian abbreviations
	 */
	private static HashSet<String> init() {
		HashSet<String> abbreviations = new HashSet<String>(79);
		abbreviations.add("All.");
		abbreviations.add("Art.");
		abbreviations.add("B.");
		abbreviations.add("Cap.");
		abbreviations.add("Cfr.");
		abbreviations.add("D.");
		abbreviations.add("Doc.");
		abbreviations.add("E.");
		abbreviations.add("Em.");
		abbreviations.add("F.");
		abbreviations.add("G.");
		abbreviations.add("Gen.");
		abbreviations.add("H.");
		abbreviations.add("Ind.");
		abbreviations.add("J.");
		abbreviations.add("K.");
		abbreviations.add("Ltd.");
		abbreviations.add("M.");
		abbreviations.add("Med.");
		abbreviations.add("N.");
		abbreviations.add("On.");
		abbreviations.add("P.");
		abbreviations.add("Pag.");
		abbreviations.add("Ph.");
		abbreviations.add("Prof.");
		abbreviations.add("Q.");
		abbreviations.add("R.");
		abbreviations.add("Racc.");
		abbreviations.add("Rec.");
		abbreviations.add("Rep.");
		abbreviations.add("Sig.");
		abbreviations.add("St.");
		abbreviations.add("U.");
		abbreviations.add("W.");
		abbreviations.add("Z.");
		abbreviations.add("art.");
		abbreviations.add("artt.");
		abbreviations.add("c.");
		abbreviations.add("ca.");
		abbreviations.add("cap.");
		abbreviations.add("cfr.");
		abbreviations.add("cit.");
		abbreviations.add("cm.");
		abbreviations.add("def.");
		abbreviations.add("doc.");
		abbreviations.add("ecc.");
		abbreviations.add("em.");
		abbreviations.add("emm.");
		abbreviations.add("es.");
		abbreviations.add("etc.");
		abbreviations.add("f.");
		abbreviations.add("g.");
		abbreviations.add("id.");
		abbreviations.add("imp.");
		abbreviations.add("m.");
		abbreviations.add("n.");
		abbreviations.add("nn.");
		abbreviations.add("ob.");
		abbreviations.add("on.");
		abbreviations.add("onn.");
		abbreviations.add("op.");
		abbreviations.add("p.");
		abbreviations.add("pag.");
		abbreviations.add("pagg.");
		abbreviations.add("par.");
		abbreviations.add("pp.");
		abbreviations.add("prof.");
		abbreviations.add("q.");
		abbreviations.add("r.");
		abbreviations.add("reg.");
		abbreviations.add("riv.");
		abbreviations.add("s.");
		abbreviations.add("sec.");
		abbreviations.add("segg.");
		abbreviations.add("sig.");
		abbreviations.add("u.");
		abbreviations.add("v.");
		abbreviations.add("");
		abbreviations.add("vol.");
		return (abbreviations);
	}
}
