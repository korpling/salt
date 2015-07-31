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
package de.hu_berlin.german.korpling.saltnpepper.salt.common.tokenizer;

import java.util.HashSet;

/**
 * This offers a set of english abbreviations. The set is supplied by a {@link HashSet} object which is returned, when 
 * calling the methode {@link #createAbbriviations()}. The returned object is a static one and therefore initialized
 * only once. The set of abbreviations is reimplemented in Java with permission from the original  
 * abbreviation sets used by the TreeTagger by Helmut Schmid (see http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/).
 *   
 * @author Florian Zipser
 *
 */
public class AbbreviationEN 
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
	 * Returns a set of english abbreviations, used by the TreeTagger by Helmut Schmid (see http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/).
	 * @return set of english abbreviations
	 */
	private static HashSet<String> init()
	{
		HashSet<String> abbreviations= new HashSet<String>(1300);
		abbreviations.add("Adm.");
		abbreviations.add("Ala.");
		abbreviations.add("Ariz.");
		abbreviations.add("Ark.");
		abbreviations.add("Aug.");
		abbreviations.add("Ave.");
		abbreviations.add("Bancorp.");
		abbreviations.add("Bhd.");
		abbreviations.add("Brig.");
		abbreviations.add("Bros.");
		abbreviations.add("CO.");
		abbreviations.add("CORP.");
		abbreviations.add("COS.");
		abbreviations.add("Ca.");
		abbreviations.add("Calif.");
		abbreviations.add("Canada-U.S.");
		abbreviations.add("Canadian-U.S.");
		abbreviations.add("Capt.");
		abbreviations.add("Cia.");
		abbreviations.add("Cie.");
		abbreviations.add("Co.");
		abbreviations.add("Col.");
		abbreviations.add("Colo.");
		abbreviations.add("Conn.");
		abbreviations.add("Corp.");
		abbreviations.add("Cos.");
		abbreviations.add("D-Mass.");
		abbreviations.add("Dec.");
		abbreviations.add("Del.");
		abbreviations.add("Dept.");
		abbreviations.add("Dr.");
		abbreviations.add("Drs.");
		abbreviations.add("Etc.");
		abbreviations.add("Feb.");
		abbreviations.add("Fla.");
		abbreviations.add("Ft.");
		abbreviations.add("Ga.");
		abbreviations.add("Gen.");
		abbreviations.add("Gov.");
		abbreviations.add("Hon.");
		abbreviations.add("INC.");
		abbreviations.add("Ill.");
		abbreviations.add("Inc.");
		abbreviations.add("Ind.");
		abbreviations.add("Jan.");
		abbreviations.add("Japan-U.S.");
		abbreviations.add("Jr.");
		abbreviations.add("Kan.");
		abbreviations.add("Korean-U.S.");
		abbreviations.add("Ky.");
		abbreviations.add("La.");
		abbreviations.add("Lt.");
		abbreviations.add("Ltd.");
		abbreviations.add("Maj.");
		abbreviations.add("Mass.");
		abbreviations.add("Md.");
		abbreviations.add("Messrs.");
		abbreviations.add("Mfg.");
		abbreviations.add("Mich.");
		abbreviations.add("Minn.");
		abbreviations.add("Miss.");
		abbreviations.add("Mo.");
		abbreviations.add("Mr.");
		abbreviations.add("Mrs.");
		abbreviations.add("Ms.");
		abbreviations.add("Neb.");
		abbreviations.add("Nev.");
		abbreviations.add("No.");
		abbreviations.add("Nos.");
		abbreviations.add("Nov.");
		abbreviations.add("Oct.");
		abbreviations.add("Okla.");
		abbreviations.add("Ont.");
		abbreviations.add("Ore.");
		abbreviations.add("Pa.");
		abbreviations.add("Ph.");
		abbreviations.add("Prof.");
		abbreviations.add("Prop.");
		abbreviations.add("Pty.");
		abbreviations.add("Rep.");
		abbreviations.add("Reps.");
		abbreviations.add("Rev.");
		abbreviations.add("S.p.A.");
		abbreviations.add("Sen.");
		abbreviations.add("Sens.");
		abbreviations.add("Sept.");
		abbreviations.add("Sgt.");
		abbreviations.add("Sino-U.S.");
		abbreviations.add("Sr.");
		abbreviations.add("St.");
		abbreviations.add("Ste.");
		abbreviations.add("Tenn.");
		abbreviations.add("Tex.");
		abbreviations.add("U.S.-U.K.");
		abbreviations.add("U.S.-U.S.S.R.");
		abbreviations.add("Va.");
		abbreviations.add("Vt.");
		abbreviations.add("W.Va.");
		abbreviations.add("Wash.");
		abbreviations.add("Wis.");
		abbreviations.add("Wyo.");
		abbreviations.add("a.k.a.");
		abbreviations.add("a.m.");
		abbreviations.add("anti-U.S.");
		abbreviations.add("cap.");
		abbreviations.add("days.");
		abbreviations.add("etc.");
		abbreviations.add("ft.");
		abbreviations.add("i.e.");
		abbreviations.add("non-U.S.");
		abbreviations.add("office/dept.");
		abbreviations.add("p.m.");
		abbreviations.add("president-U.S.");
		abbreviations.add("s.r.l.");
		abbreviations.add("v.");
		abbreviations.add("v.B.");
		abbreviations.add("v.w.");
		abbreviations.add("vs.");
		return(abbreviations);
	}
}
