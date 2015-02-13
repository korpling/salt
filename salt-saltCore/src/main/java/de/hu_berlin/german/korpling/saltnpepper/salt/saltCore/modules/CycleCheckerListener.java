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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.modules;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

/**
 * 
 * @author Florian Zipser
 * @deprecated since Salt 1.1.3
 */
public interface CycleCheckerListener 
{
	/**
	 * Levels on which cycles can be detected.
	 * @author Administrator
	 *
	 */
	public enum CYCLE_LEVELS {LEVEL_1, LEVEL_2, LEVEL_3};
	
	public void cycleDetected(	CYCLE_LEVELS cycleLevel, 
								Class<? extends SRelation> sRelationClass,
								String sRelationSType,
								SNode[] nodesInCycle);
}
