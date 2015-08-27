package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.visjs;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

public interface Filter {
	
	public boolean outputNode (SNode node);
	
	public boolean outputRelation (SRelation relation);
		

}
