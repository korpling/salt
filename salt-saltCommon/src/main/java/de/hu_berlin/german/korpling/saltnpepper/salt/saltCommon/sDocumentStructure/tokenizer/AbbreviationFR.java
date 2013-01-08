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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tokenizer;

import java.util.HashSet;

/**
 * This offers a set of french abbreviations. The set is supplied by a {@link HashSet} object which is returned, when 
 * calling the methode {@link #createAbbriviations()}. The returned object is a static one and therefore initialized
 * only once. The set of abbreviations is reimplemented in Java with permission from the original  
 * abbreviation sets used by the TreeTagger by Helmut Schmid (see http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/).
 *   
 * @author Florian Zipser
 *
 */
public class AbbreviationFR 
{
	/**
	 * all abbreviations
	 */
	private static HashSet<String> abbreviations= null;
	
	public static HashSet<String> createAbbriviations()
	{
		if (abbreviations== null)
			abbreviations= init();
		return(abbreviations);
	}
	
	/**
	 * Returns a set of french abbreviations, used by the TreeTagger by Helmut Schmid (see http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/).
	 * @return set of french abbreviations
	 */
	private static HashSet<String> init()
	{
		HashSet<String> abbreviations= new HashSet<String>(1300);
		abbreviations.add("rendez-vous");
		abbreviations.add("d'abord");
		abbreviations.add("d'accord");
		abbreviations.add("d'ailleurs");
		abbreviations.add("d'apr?s");
		abbreviations.add("d'autant");
		abbreviations.add("d'?uvre");
		abbreviations.add("d'oeuvre");
		abbreviations.add("c'est-?-dire");
		abbreviations.add("moi-m?me");
		abbreviations.add("toi-m?me");
		abbreviations.add("lui-m?me");
		abbreviations.add("elle-m?me");
		abbreviations.add("nous-m?mes");
		abbreviations.add("vous-m?mes");
		abbreviations.add("eux-m?mes");
		abbreviations.add("elles-m?mes");
		abbreviations.add("par-ci");
		abbreviations.add("par-l?");
		abbreviations.add("Rendez-vous");
		abbreviations.add("D'abord");
		abbreviations.add("D'accord");
		abbreviations.add("D'ailleurs");
		abbreviations.add("D'apr?s");
		abbreviations.add("D'autant");
		abbreviations.add("D'?uvre");
		abbreviations.add("D'oeuvre");
		abbreviations.add("C'est-?-dire");
		abbreviations.add("Moi-m?me");
		abbreviations.add("Toi-m?me");
		abbreviations.add("Lui-m?me");
		abbreviations.add("Elle-m?me");
		abbreviations.add("Nous-m?mes");
		abbreviations.add("Vous-m?mes");
		abbreviations.add("Eux-m?mes");
		abbreviations.add("Elles-m?mes");
		abbreviations.add("Par-ci");
		abbreviations.add("Par-l?");
		abbreviations.add("Arg.");
		abbreviations.add("Aus.");
		abbreviations.add("Aut.");
		abbreviations.add("Cag.");
		abbreviations.add("Cl.");
		abbreviations.add("Corp.");
		abbreviations.add("Corresp.");
		abbreviations.add("E.");
		abbreviations.add("Esp.");
		abbreviations.add("Etc.");
		abbreviations.add("Fr.");
		abbreviations.add("Fra.");
		abbreviations.add("G.");
		abbreviations.add("H.");
		abbreviations.add("I.");
		abbreviations.add("Inc.");
		abbreviations.add("Incr.");
		abbreviations.add("Inscr.");
		abbreviations.add("It.");
		abbreviations.add("Ita.");
		abbreviations.add("Jap.");
		abbreviations.add("K.");
		abbreviations.add("P.");
		abbreviations.add("R.");
		abbreviations.add("R?g.");
		abbreviations.add("R?n.");
		abbreviations.add("Tch.");
		abbreviations.add("T?l.");
		abbreviations.add("V.");
		abbreviations.add("W.");
		abbreviations.add("Yam.");
		abbreviations.add("abst.");
		abbreviations.add("adj.");
		abbreviations.add("adm.");
		abbreviations.add("app.");
		abbreviations.add("av.");
		abbreviations.add("b.");
		abbreviations.add("cf.");
		abbreviations.add("corp.");
		abbreviations.add("diss.");
		abbreviations.add("div.");
		abbreviations.add("dr.");
		abbreviations.add("etc.");
		abbreviations.add("expr.");
		abbreviations.add("g.");
		abbreviations.add("id.");
		abbreviations.add("inscr.");
		abbreviations.add("maj.");
		abbreviations.add("p.");
		abbreviations.add("r.");
		abbreviations.add("rad.");
		abbreviations.add("ratt.");
		abbreviations.add("sc.");
		abbreviations.add("suffr.");
		abbreviations.add("t?l.");
		abbreviations.add("vot.");
		abbreviations.add("?col.");
		abbreviations.add("?d.");
		abbreviations.add("?tiq.");
		
		return(abbreviations);
	}
}
