package de.hub.corpling.salt.saltCore.modules;

import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SRelation;

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
