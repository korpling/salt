package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.visjs;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

public interface ExportFilter {
	
	public boolean excludeNode (SNode node);
	
	public boolean excludeRelation (SRelation relation);
		

}
