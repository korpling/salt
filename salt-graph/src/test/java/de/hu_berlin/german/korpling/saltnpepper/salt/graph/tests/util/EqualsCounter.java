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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests.util;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.EdgeImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifierImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.NodeImpl;

public class EqualsCounter 
{
	public static void count()
	{
		System.out.println("time to compare Node.equals(): "+ NodeImpl.equalTime);
		System.out.println("\tnumber of trues: "+ NodeImpl.eTrues);
		System.out.println("\tnumber of falses: "+ NodeImpl.eFalses);
		System.out.println("\taverage time of equals: "+ NodeImpl.equalTime / (NodeImpl.eFalses+ NodeImpl.eTrues));
		System.out.println("time to compare Edge.equals(): "+ EdgeImpl.equalTime);
		System.out.println("\tnumber of trues: "+ EdgeImpl.eTrues);
		System.out.println("\tnumber of falses: "+ EdgeImpl.eFalses);
		System.out.println("\taverage time of equals: "+ EdgeImpl.equalTime / (EdgeImpl.eFalses+ EdgeImpl.eTrues));
		System.out.println("time to compare Graph.equals(): "+ GraphImpl.equalTime);
		System.out.println("time to compare Layer.equals(): "+ LayerImpl.equalTime);
		System.out.println("time to compare Label.equals(): "+ LabelImpl.equalTime);
		System.out.println("time to compare Identifier.equals(): "+ IdentifierImpl.equalTime);
		System.out.println("time to compare IdentifiableElementImpl.equals(): "+ IdentifiableElementImpl.equalTime);
		
		Long totalEqualTime= 	NodeImpl.equalTime+
								EdgeImpl.equalTime+
								GraphImpl.equalTime+
								LayerImpl.equalTime+
								LabelImpl.equalTime+
								IdentifierImpl.equalTime+
								IdentifiableElementImpl.equalTime;
		
		System.out.println("time to compare all: "+ totalEqualTime);
		
	}
}
