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

import com.google.common.collect.ImmutableList;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import java.util.LinkedList;
import java.util.List;

/**
 * Provides some methods for an easier access to objects being contained by a given {@link SDocumentGraph}
 * object. 
 * 
 * @author Florian Zipser
 *
 */
public class SDataSourceAccessor extends SDocumentStructureModule implements SGraphTraverseHandler
{
//==================================== start: accessing concerning timeline	
	/**
	 * Returns all {@link SToken} objects which refer to the passed {@link SDataSourceSequence} object. The passed object
	 * determines the borders of the sequence by the values <em>sStart</em> and <em>sEnd</em> and the type of
	 * datasource by the instance <em>sSequentialDS</em>.
	 * @param sDataSourceSequence an object determing the sequence to which the returned {@link SToken} objects refer to. 
	 * @return a list of {@link SToken} objects which refer or overlap the passed sequence 
	 */
	public EList<SToken> getSTokensBySequence(SDataSourceSequence sDataSourceSequence)
	{
		EList<Class<? extends SNode>> classes= new BasicEList<Class<? extends SNode>>();
		classes.add(SToken.class);
		@SuppressWarnings("unchecked")
		EList<SToken> sTokens= ((EList<SToken>) (EList<? extends SNode>)this.getSNodesBySequence(sDataSourceSequence, classes));
		
		return(sTokens);
	}
	
	/**
	 * Returns all {@link SSpan} objects which refer to the passed {@link SDataSourceSequence} object. The passed object
	 * determines the borders of the sequence by the values <em>sStart</em> and <em>sEnd</em> and the type of
	 * datasource by the instance <em>sSequentialDS</em>.
	 * @param sDataSourceSequence an object determing the sequence to which the returned {@link SSpan} objects refer to. 
	 * @return a list of {@link SSpan} objects which refer or overlap the passed sequence 
	 */
	public EList<SSpan> getSSpanBySequence(SDataSourceSequence sDataSourceSequence)
	{
		EList<Class<? extends SNode>> classes= new BasicEList<Class<? extends SNode>>();
		classes.add(SSpan.class);
		@SuppressWarnings("unchecked")
		EList<SSpan> sSpans= ((EList<SSpan>) (EList<? extends SNode>)this.getSNodesBySequence(sDataSourceSequence, classes));
		
		return(sSpans);
	}
	
	/**
	 * Returns all {@link SStructure} objects which refer to the passed {@link SDataSourceSequence} object. The passed object
	 * determines the borders of the sequence by the values <em>sStart</em> and <em>sEnd</em> and the type of
	 * datasource by the instance <em>sSequentialDS</em>.
	 * @param sDataSourceSequence an object determing the sequence to which the returned {@link SStructure} objects refer to. 
	 * @return a list of {@link SStructure} objects which refer or overlap the passed sequence 
	 */
	public EList<SStructure> getSStructureBySequence(SDataSourceSequence sDataSourceSequence)
	{
		EList<Class<? extends SNode>> classes= new BasicEList<Class<? extends SNode>>();
		classes.add(SStructure.class);
		@SuppressWarnings("unchecked")
		EList<SStructure> sStructs= ((EList<SStructure>) (EList<? extends SNode>)this.getSNodesBySequence(sDataSourceSequence, classes));
		
		return(sStructs);
	}
	
	/**
	 * Returns all {@link SNode} objects which refer to the passed {@link SDataSourceSequence} object. The passed object
	 * determines the borders of the sequence by the values <em>sStart</em> and <em>sEnd</em> and the type of
	 * datasource by the instance <em>sSequentialDS</em>.
	 * @param sDataSourceSequence an object determing the sequence to which the returned {@link SNode} objects refer to. 
	 * @return a list of {@link SNode} objects which refer or overlap the passed sequence 
	 */
	public EList<? extends SNode> getSNodeBySequence(SDataSourceSequence sDataSourceSequence)
	{
//		EList<Class<? extends SNode>> classes= new BasicEList<Class<? extends SNode>>();
//		classes.add(SNode.class);
//		@SuppressWarnings("unchecked")
//		EList<SNode> sNodes= ((EList<SNode>) (EList<? extends SNode>)this.getSNodesBySequence(sDataSourceSequence, classes));
//		
//		return(sNodes);
		
		EList<Class<? extends SNode>> classes= new BasicEList<Class<? extends SNode>>();
		classes.add(SNode.class);
		EList<? extends SNode> sNodes= this.getSNodesBySequence(sDataSourceSequence, classes);
		
		return(sNodes);
	}
	
	/**
	 * Searches for all {@link SNode} objects of the given node type, which cover the given sequence.  
	 * @param sDataSourceSequence sequence, which is overlapped
	 * @param nodeClasses type of nodes to be returned
	 * @return nodes, which overlaps the given sequence
	 */
	private EList<SNode> getSNodesBySequence(SDataSourceSequence sDataSourceSequence, EList<Class<? extends SNode>> nodeClasses)
	{
		if (sDataSourceSequence== null)
			new SaltModuleException("Cannot start returning nodes overlapping a data source, because the 'sDataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
		if (sDataSourceSequence.getSStart()== null)
			new SaltModuleException("Cannot start returning nodes overlapping a data source, because the 'sStart' value of the 'sDataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
		if (sDataSourceSequence.getSEnd()== null)
			new SaltModuleException("Cannot start returning nodes overlapping a data source, because the 'sEnd' value of the 'sDataSourceSequence' object, determining the sequence which shall be overlapped is empty.");
		if (this.getSDocumentGraph()== null)
			new SaltModuleException("Cannot start method please set the document graph first.");
			
		EList<SNode> nodes= null;
		EList<? extends SSequentialRelation> sSeqRels= null;
		if (sDataSourceSequence.getSSequentialDS() instanceof STextualDS)
			sSeqRels= this.getSDocumentGraph().getSTextualRelations();
		else if (sDataSourceSequence.getSSequentialDS() instanceof STimeline)
			sSeqRels=this.getSDocumentGraph().getSTimelineRelations();
		else 
			throw new SaltModuleException("Cannot compute overlaped nodes, because the given dataSource is not supported by this method.");
		for (SSequentialRelation sSeqRel: sSeqRels)
		{//walk through all sequential relations
			if (	(sDataSourceSequence.getSSequentialDS().equals(sSeqRel.getSTarget()))&&
					(sSeqRel.getSStart() >= sDataSourceSequence.getSStart()) &&
					(sSeqRel.getSEnd() <= sDataSourceSequence.getSEnd()))
			{//sequential relation is in the interval
				for (Class<? extends SNode> nodeClass: nodeClasses)
				{
					if (nodes== null)
						nodes= new BasicEList<SNode>();
					if (nodeClass.isInstance(sSeqRel.getSSource()))
					{//source is of correct type
						nodes.add(sSeqRel.getSSource());
					}
				}
			}//sequential relation is in the interval
		}//walk through all sequential relations
		return(nodes);
	}
	
	/**
	 * {@inheritDoc SDocumentGraph#isContinuousByText(EList)}
	 * First sorts the given lists, than searches first occurance of first node in subSNodeList in fullSNodeList. Starting
	 * from this index, the method compares each element in subSNodeList to element i in fullSNodeList. If one is not equal the method 
	 * returns false.
	 */
	//TODO must be enabled for all SNode lists and not only SToken lists
	public boolean isContinuousByText(EList<? extends SNode> subSNodeList, EList<? extends SNode> fullSNodeList)
	{
		if (this.getSDocumentGraph()== null)
			new SaltModuleException("Cannot start method 'getContinuously(EList<SToken>, EList<SToken>)' please set the document graph first.");
		
		Boolean retVal= null;
		//compute sorted list of overlapped tokens by the given sStructuredNode
		@SuppressWarnings("unchecked")
		EList<SToken> overlappedSTokens= getSortedSTokenByText((EList<SToken>)subSNodeList);
		
		retVal= true;
		
		Integer posOfFirstOverlappedToken= fullSNodeList.indexOf(overlappedSTokens.get(0));
		int ctr= 0;
		SToken sTokInAllTokens= null;
		for (SToken sToken: overlappedSTokens)
		{
			//count the token in fullSTokenList
			sTokInAllTokens= (SToken) fullSNodeList.get(posOfFirstOverlappedToken+ ctr);
			if (sToken.hashCode()!=sTokInAllTokens.hashCode())
			{//tokens at same position relative to their list are not equal
				retVal= false;
				break;
			}//tokens at same position relative to their list are not equal
			ctr++;
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc SDocumentGraph#isContinuousByText(EList)}
	 */
	public boolean isContinuousByText(EList<SNode> subSNodeList)
	{
		return(this.isContinuousByText(subSNodeList, this.getSortedSTokenByText()));
	}
	
	/**
	 * {@inheritDoc SDocumentGraph#sortSTokenByText()}
	 */
	public void sortSTokenByText()
	{
		if (this.getSDocumentGraph()== null)
			new SaltModuleException("Cannot start method please set the document graph first.");
		
		if (this.getSDocumentGraph().getSTokens()!= null)
		{
			STokenSStartComparator comparator = new STokenSStartComparator();
			comparator.setSDocumentGraph(this.getSDocumentGraph());

			//sort tokens
			EList<SToken> tokens = getSDocumentGraph().getCentralIndex()
					.getAll(SDocumentGraph.IDX_SNODETYPE, SToken.class);
			List<SToken> mutableTokens = new LinkedList<SToken>(tokens);
			Collections.sort(mutableTokens, comparator);
			getSDocumentGraph().getCentralIndex().remove(SDocumentGraph.IDX_SNODETYPE, SToken.class);
			getSDocumentGraph().getCentralIndex()
					.putAll(SDocumentGraph.IDX_SNODETYPE, SToken.class, mutableTokens);
			
			STextualRelationSStartComparator comparatortextrels = new STextualRelationSStartComparator();
			comparatortextrels.setSDocumentGraph(this.getSDocumentGraph());
			
			//sort textual relations
			EList<STextualRelation> textualRelations = getSDocumentGraph().getCentralIndex()
					.getAll(SDocumentGraph.IDX_SRELATIONTYPE, STextualRelation.class);
			List<STextualRelation> mutableTextualRelations = new LinkedList<STextualRelation>(textualRelations);
			Collections.sort(mutableTextualRelations, comparatortextrels);
			getSDocumentGraph().getCentralIndex().remove(SDocumentGraph.IDX_SRELATIONTYPE, STextualRelation.class);
			getSDocumentGraph().getCentralIndex()
					.putAll(SDocumentGraph.IDX_SRELATIONTYPE, STextualRelation.class, mutableTextualRelations);
			
		}
	}
	
	/**
	 * {@inheritDoc SDocumentGraph#getSortedSTokenByText(EList)}
	 */
	public EList<SToken> getSortedSTokenByText(EList<SToken> sTokens2sort)
	{
		if (this.getSDocumentGraph()== null)
			new SaltModuleException("Cannot start method please set the document graph first.");
		
		EList<SToken> retVal= null;
		if (sTokens2sort!= null)
		{	
			STokenSStartComparator comparator= new STokenSStartComparator();
			comparator.setSDocumentGraph(this.getSDocumentGraph());
			retVal= new BasicEList<SToken>();
			retVal.addAll(sTokens2sort);
			//sort tokens
			Collections.sort(retVal, comparator);
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc SDocumentGraph#getSortedSTokenByText()}
	 */
	public EList<SToken> getSortedSTokenByText()
	{
		EList<SToken> retVal= null;
		if (this.getSDocumentGraph()== null)
			new SaltModuleException("Cannot start method please set the document graph first.");
		
		if (	(this.getSDocumentGraph().getSTextualDSs()!= null)&&
				(this.getSDocumentGraph().getSTextualDSs().size()> 0))
		{
			retVal= new BasicEList<SToken>();
			for (STextualDS sTextualDS: this.getSDocumentGraph().getSTextualDSs())
			{	
				SDataSourceSequence sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
				sequence.setSSequentialDS(sTextualDS);
				sequence.setSStart(0);
				sequence.setSEnd((sTextualDS.getSText()!= null)?sTextualDS.getSText().length():0);
				EList<SToken> sTokens= this.getSTokensBySequence(sequence);
				if (sTokens!= null)
					retVal.addAll(this.getSortedSTokenByText(sTokens));
			}
		}
		return(retVal);
	}
	
	/**
	 * {@inheritDoc SDocumentGraph#getOverlappedDSSequences(SNode, EList)}
	 */
	public EList<SDataSourceSequence> getOverlappedDSSequences(SNode sNode, EList<STYPE_NAME> sRelationTypes) {
		EList<SNode> rootSNodes= new BasicEList<SNode>();
		rootSNodes.add(sNode);
		return(this.getOverlappedDSSequences(rootSNodes, sRelationTypes));
	}
	
	/**
	 * {@inheritDoc SDocumentGraph#getOverlappedDSSequences(SNode, EList)}
	 */
	//TODO this method can be fasten up, by remembering the overlapped sequences for each node and not traverse deeper, when the sequence is already computed for a node
	public EList<SDataSourceSequence> getOverlappedDSSequences(EList<SNode> sNodes, EList<STYPE_NAME> sRelationTypes) {
		
		this.relationTypes2Traverse= sRelationTypes;
		this.getSDocumentGraph().traverse(sNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.toString(), this);
		return(this.sDataSourceSequences);
	}
// ====================================================== start: traversing mechanism
	/**
	 * types of traversions, used by the several methods, used as id for traversion
	 */
	private enum TRAVERSION_TYPE {OVERLAPPED_DS_SEQUENCES};
	
	/**
	 * in case of traversion type is {@link TRAVERSION_TYPE#OVERLAPPED_DS_SEQUENCES}, here are the relation types, which shall
	 * be used for traversion 
	 */
	private EList<STYPE_NAME> relationTypes2Traverse= null;
	
	/**
	 * in case of traversion type is {@link TRAVERSION_TYPE#OVERLAPPED_DS_SEQUENCES}, the results are stored here
	 */
	private EList<SDataSourceSequence> sDataSourceSequences= null;
	
	/**
	 * in case of traversion type is {@link TRAVERSION_TYPE#OVERLAPPED_DS_SEQUENCES}, stores the last seen data source
	 */
	private SDataSourceSequence lastSeenDSSequence= null;
	
	@Override
	public void nodeReached(	GRAPH_TRAVERSE_TYPE traversalType,
								String traversalId, 
								SNode currSNode, 
								SRelation sRelation, 
								SNode fromSNode,
								long order) 
	{
//		System.out.println("nodeReached('"+currSNode+"',)");
		if (TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.equals(TRAVERSION_TYPE.valueOf(traversalId)))
		{//TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
			if (currSNode instanceof SSequentialDS)
			{
				SSequentialDS dataSource= (SSequentialDS) currSNode;
				SDataSourceSequence sequence= null;
				if (this.sDataSourceSequences== null)
					this.sDataSourceSequences= new BasicEList<SDataSourceSequence>();
				for (SDataSourceSequence dsSequence: this.sDataSourceSequences)
				{//search for correct sequence, containing the datasource if it was already found
					if (dsSequence.getSSequentialDS().equals(dataSource))
					{
						sequence=dsSequence;
						this.lastSeenDSSequence= dsSequence;
						break;
					}
				}//search for correct sequence, containing the datasource if it was already found
				if (sequence== null)
				{//sequence haven't been visit -> create it
					sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
					sequence.setSSequentialDS(dataSource);
					this.lastSeenDSSequence= sequence;
					this.sDataSourceSequences.add(sequence);
				}//sequence haven't been visit -> create it
			}
		}//TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
	}

	/**
	 * 
	 */
	@Override
	public void nodeLeft(	GRAPH_TRAVERSE_TYPE traversalType, 
							String traversalId,
							SNode currSNode, 
							SRelation sRelation, 
							SNode fromSNode, 
							long order) 
	{
//		System.out.println("nodeLeft('"+currSNode+"',)");
		if (TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.equals(TRAVERSION_TYPE.valueOf(traversalId)))
		{//TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
			if (currSNode instanceof SSequentialDS)
			{//check if current start and end value is smaller or bigger, than reset
				SSequentialRelation seqRel= (SSequentialRelation) sRelation;
				try{
					if (	(sRelation== null)&&
							(currSNode instanceof SSequentialDS))
					{
						this.lastSeenDSSequence.setSSequentialDS((SSequentialDS)currSNode);
						this.lastSeenDSSequence.setSStart(((SSequentialDS)currSNode).getSStart());
						this.lastSeenDSSequence.setSEnd(((SSequentialDS)currSNode).getSEnd());
					}
					else
					{
						if (	(this.lastSeenDSSequence.getSStart()== null)||
								(seqRel.getSStart()< this.lastSeenDSSequence.getSStart()))
						{//if start value wasn't set or is higher than current one
							this.lastSeenDSSequence.setSStart(seqRel.getSStart());
						}
						if ( 	(this.lastSeenDSSequence.getSEnd()== null)||
								(seqRel.getSEnd()> this.lastSeenDSSequence.getSEnd()))
						{//if end value wasn't set or is higher than current one
							this.lastSeenDSSequence.setSEnd(seqRel.getSEnd());
						}
					}
				}catch (NullPointerException e) {
					if (seqRel.getSStart()== null)
						throw new SaltModuleException("Cannot return overlapped SDataSourceSequences, because the graph is inconsistent. The sStart value the SSequentialRelation '"+seqRel+"' is not set.", e);
					else if (seqRel.getSEnd()== null)
						throw new SaltModuleException("Cannot return overlapped SDataSourceSequences, because the graph is inconsistent. The sEnd value the SSequentialRelation '"+seqRel+"' is not set.", e);
					else throw e;
				}
			}//check if current start and end value is smaller or bigger, than reset
		}//TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
		
	}

	@Override
	public boolean checkConstraint(	GRAPH_TRAVERSE_TYPE traversalType,
									String traversalId, 
									SRelation sRelation, 
									SNode currSNode, 
									long order) 
	{
//		System.out.println("checkConstraint('"+currSNode+"',)");
		boolean retVal= false;
		if (TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES.equals(TRAVERSION_TYPE.valueOf(traversalId)))
		{//TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
			if (sRelation!= null)
			{
				if (	(	(this.relationTypes2Traverse.contains(STYPE_NAME.STEXT_OVERLAPPING_RELATION))||
							(this.relationTypes2Traverse.contains(STYPE_NAME.SSEQUENTIAL_RELATION)))	&&
						(sRelation instanceof STextOverlappingRelation))
				{
					retVal= true;
				}
				else if (	(	(this.relationTypes2Traverse.contains(STYPE_NAME.STIME_OVERLAPPING_RELATION))||
								(this.relationTypes2Traverse.contains(STYPE_NAME.SSEQUENTIAL_RELATION)))	&&
							(sRelation instanceof STimeOverlappingRelation))
				{
					retVal= true;
				}
			}
			else retVal= true;
				
		}//TRAVERSION_TYPE.OVERLAPPED_DS_SEQUENCES
		return(retVal);
	}
	
}
