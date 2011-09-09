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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.model;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

public class DOTNode
{
	public String id= null;
	public String shape= null;
	public String color= null;
	public String style= null;
	public EList<String> labels= new BasicEList<String>();
	
	public String toString()
	{
		String retStr= "";
		//print name of node
		retStr= "<" + id + ">";
		
		//open properties
		retStr= retStr+ "[";
		//shape
		if (this.shape!= null) retStr= retStr+ "shape= "+ shape +",";
		//color
		if (this.color!= null) retStr= retStr+ "color= "+ color+",";
		//style
		if (this.style!= null) retStr= retStr+ "style= "+ style+",";
		if ((labels!= null) && (labels.size()> 0))
		{	
			retStr= retStr + "label=\"{{"+id + "}|";
			boolean printSep= false;
			for (String label: labels)
			{
				if (printSep)
					retStr= retStr + "|";
				printSep= true;
				retStr= retStr +"{"+ label+"}";
			}
			retStr= retStr + "}\"";
		}
		//close properties
		retStr= retStr + "]";
		return(retStr);
	}
}
