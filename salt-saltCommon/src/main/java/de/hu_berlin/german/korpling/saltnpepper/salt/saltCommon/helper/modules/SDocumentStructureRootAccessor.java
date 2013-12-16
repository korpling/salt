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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules;

import java.util.HashSet;
import java.util.Hashtable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltEmptyParameterException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltInvalidModelException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

public class SDocumentStructureRootAccessor extends SDocumentStructureModule
{
//========================= start: getting roots for given Relation type (Class) =========================	
	/**
	 * Returns all SNode objects which are roots for the given SRelation Subtype. Means, that all SNode-objects
	 * will be returned as roots, which have no incoming SRelation-objects of the given subtype clazz. 
	 * <br/>
	 * Attention: Only  the subtypes {@link STYPE_NAME#SPOINTING_RELATION}, {@link STYPE_NAME#SSPANNING_RELATION} and {@link STYPE_NAME#SDOMINANCE_RELATION}
	 * are supported yet.
	 * <br/>
	 * @param clazz Subclass of SRelation which shall be used for computing roots
	 * @return a list of SNode-objects which are roots 
	 */
	@SuppressWarnings("unchecked")
	public EList<SNode> getRootsBySRelation(STYPE_NAME sType)
	{
		EList<SNode> retVal= null;
		if (this.getSDocumentGraph()== null)
			new SaltModuleException("Cannot start method please set the document graph first.");
		
		if (sType== null)
			throw new SaltEmptyParameterException("sType", "getSRootsByRelation", this.getClass());
		
		if (	(!STYPE_NAME.SDOMINANCE_RELATION.equals(sType)) &&
				(!STYPE_NAME.SPOINTING_RELATION.equals(sType)) &&
				(!STYPE_NAME.SSPANNING_RELATION.equals(sType)))
		{// if the relation type isn't supported throw exception
			throw new SaltModuleException("Cannot compute roots for given SRelation type '"+sType+"', because it isn't supported yet. Supported subtypes are only: SPointingRelation, SSpanningRelation and SDominanceRelation");
		}// if the subtype isn't supported throw exception
			
		
		EList<SRelation> relations= null;
		{//compute all relations of subtype
			if (STYPE_NAME.SPOINTING_RELATION.equals(sType))
				relations= (EList<SRelation>) (EList<? extends SRelation>) this.getSDocumentGraph().getSPointingRelations();
			else if (STYPE_NAME.SDOMINANCE_RELATION.equals(sType)) 
				relations= (EList<SRelation>) (EList<? extends SRelation>) this.getSDocumentGraph().getSDominanceRelations();
			else if (STYPE_NAME.SSPANNING_RELATION.equals(sType))
				relations= (EList<SRelation>) (EList<? extends SRelation>) this.getSDocumentGraph().getSSpanningRelations();
		}//compute all relations of subtype
		if (relations!= null)
		{
			retVal= new BasicEList<SNode>();
			HashSet<SNode> notRootElements= new HashSet<SNode>();
			for (SRelation relation: relations)
			{
				//mark destination as no root
				if (!notRootElements.contains(relation.getSTarget()))
					notRootElements.add(relation.getSTarget());
				//if source is not also a destination
				if (	(!notRootElements.contains(relation.getSSource())) &&
						(!retVal.contains(relation.getSSource())))
					retVal.add(relation.getSSource());
				//remove wrong stored nodes in retList
				if (retVal.contains(relation.getSTarget()))
					retVal.remove(relation.getSTarget());
			}
		}
		return (retVal);
	}
	
	/**
	 * map of sTypes and corresponding list of SNodes, for method getRootsBySRelationSType
	 */
	private Hashtable<String, EList<SNode>> sType2Roots= null;
	
	/**
	 * puts an sType and an SNode in the map for storing them for method getRootsBySRelationSType.
	 * @param sType
	 * @param sNode
	 */
	private void storeSType2SNode(String sType, SNode sNode)
	{
		if (sType2Roots== null)
			sType2Roots= new Hashtable<String, EList<SNode>>();
		EList<SNode> vector= sType2Roots.get(sType);
		if (vector==null)
		{	
			vector= new BasicEList<SNode>();
			this.sType2Roots.put(sType, vector);
		}
		if (!vector.contains(sNode))
			vector.add(sNode);
	}
	
	/**
	 * Returns all nodes, which are roots for the given relation-class respects to the given SType of the traversed
	 * relation. The following example shows the different to the method getRootsBySRelation():
	 * Imagine the following graphFor example: node1 ->t1 node2, node2 ->t2-> node3.
	 * Also imagine, that -> is a relation of same class with sType=t1 respectivly sType=t2
	 * The returned roots will be node1 and node 2, because of node1 is the root of a subgraph for 
	 * relation.sType=t1 and node2 is the root of the subgraph for relation.sType=t2. Whereas the returned 
	 * nodes of getRootsBySRelation() is only node1. 
	 * @param clazz class of Relation to be traversed for searching roots
	 * @return a map of types, with corresponding lists of root nodes
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, EList<SNode>> getRootsBySRelationSType(STYPE_NAME sType)
	{
		return(getRootsBySRelationSType((Class<? extends SRelation>) SaltFactory.eINSTANCE.convertSTypeNameToClazz(sType)));
	}
	
	/**
	 * Returns all nodes, which are roots for the given relation-class respects to the given SType of the traversed
	 * relation. The following example shows the different to the method getRootsBySRelation():
	 * Imagine the following graphFor example: node1 ->t1 node2, node2 ->t2-> node3.
	 * Also imagine, that -> is a relation of same class with sType=t1 respectivly sType=t2
	 * The returned roots will be node1 and node 2, because of node1 is the root of a subgraph for 
	 * relation.sType=t1 and node2 is the root of the subgraph for relation.sType=t2. Whereas the returned 
	 * nodes of getRootsBySRelation() is only node1. 
	 * @param clazz class of Relation to be traversed for searching roots
	 * @return a map of types, with corresponding lists of root nodes
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, EList<SNode>> getRootsBySRelationSType(Class<? extends SRelation> clazz)
	{
		if (clazz== null)
			throw new SaltEmptyParameterException("clazz", "getRootsBySRelationSType", this.getClass());
		if (this.getSDocumentGraph()== null)
			throw new SaltException("Cannot compute roots, because there is no SDocumentGraph set to traverse.");
		Class<? extends SRelation> currRelationType= null; 
		currRelationType= clazz;
		Hashtable<String, EList<SNode>> retVal= null;
		EList<SRelation> relations= null;
		{//compute all relations
			if (clazz.equals(SPointingRelation.class)) 
				relations= (EList<SRelation>) (EList<? extends SRelation>) this.getSDocumentGraph().getSPointingRelations();
			else if (clazz.equals(SDominanceRelation.class)) 
				relations= (EList<SRelation>) (EList<? extends SRelation>) this.getSDocumentGraph().getSDominanceRelations();
			else if (clazz.equals(SSpanningRelation.class)) 
				relations= (EList<SRelation>) (EList<? extends SRelation>) this.getSDocumentGraph().getSSpanningRelations();
			else if (clazz.equals(SOrderRelation.class)) 
				relations= (EList<SRelation>) (EList<? extends SRelation>) this.getSDocumentGraph().getSOrderRelations();
		}//compute all relations
		for (SRelation currentRel: relations)
		{//walk through relations
			//stores if one of the parents is of same class
			boolean parentHasSameClass= false;
			//a table to notice, for which sTypes a relation has to be stored
			Hashtable<String, Boolean> storeSType= new Hashtable<String, Boolean>();
			if (currentRel.getSource()== null)
				throw new SaltInvalidModelException("Cannot compute roots, because there is a SRelation object '"+currentRel.getSId()+"' having no source node.");
			for (Edge edge: this.getSDocumentGraph().getInEdges(currentRel.getSSource().getSId()))
			{//walk through all incoming relations of currentRelation.sSource
				if (currRelationType.isInstance(edge))
				{//regard only current relation type 		
					parentHasSameClass= true;
					SRelation parentRelation= (SRelation) edge;
					if (currentRel.getSTypes()!= null)
					{	
						for (String sType: currentRel.getSTypes())
						{//store the source node of current relation for every type, which is not contained by parent relation
							if (parentRelation.getSTypes().contains(sType))
							{//don't store source, if any parent Relation has not all types of current relation
								storeSType.put(sType, false);
							}//store node, if parent Relation has not all types of current relation
							else
							{	
								if (storeSType.get(sType)== null)
								{
									storeSType.put(sType, true);
								}
							}
						}//store the source node of current relation for every type, which is not contained by parent relation
					}
				}//regard only current relation type
			}//walk through all incoming relations of currentRelation.sSource
			if (storeSType.size()> 0)
			{
				for (String sType: currentRel.getSTypes())
				{
					if (storeSType.get(sType))
					{
						this.storeSType2SNode(sType, currentRel.getSSource());
					}
				}
			}
			if (!parentHasSameClass)
			{//there was no parent of class --> store source of current node
				if (currentRel.getSTypes()!= null)
				{	
					for (String sType: currentRel.getSTypes())
					{
						this.storeSType2SNode(sType, currentRel.getSSource());
					}
				}
			}//there was no parent of class --> store source of current node
		}//walk through all relations
		retVal= this.sType2Roots;
	
		return(retVal);
	}
//========================= end: getting roots for given Relation type (Class) =========================
}
