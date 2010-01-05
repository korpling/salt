package de.hub.corpling.salt.saltCommon.modules;

import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hub.corpling.graph.Edge;
import de.hub.corpling.graph.Node;
import de.hub.corpling.graph.modules.GraphTraverser;
import de.hub.corpling.graph.modules.GraphTraverserObject;
import de.hub.corpling.graph.modules.TraversalObject;
import de.hub.corpling.graph.modules.GraphTraverser.GRAPH_TRAVERSE_MODE;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpan;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructuredNode;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltExceptions.SaltModuleException;

public class SDocumentStructureAccessor extends SDocumentStructureModule implements TraversalObject
{
	private enum TRAVERSAL_TYPE {OVERLAPPED_TEXT, OVERLAPPED_TIME, OVERLAPPED_TOKENS_BY_TEXTUALRELATION};
	
	/**
	 * This object stores a pair of id and traversal type.
	 * @author Administrator
	 *
	 */
	private class TraversalTypeId
	{
		public TRAVERSAL_TYPE travType= null;
		public Long id= null;
	}
	
	/**
	 * List which stores all pairs, for traversal Type and id. This is necessary for Traversing graph
	 */
	private EList<TraversalTypeId> typeIDList= null;
	
	/**
	 * Adds a traversalTypeId object to the list.
	 */
	private void addTTid(Long id, TRAVERSAL_TYPE tType)
	{
		if (this.typeIDList== null)
			this.typeIDList= new BasicEList<TraversalTypeId>();
		TraversalTypeId ttId= new TraversalTypeId();
		ttId.id= id;
		ttId.travType= tType;
		this.typeIDList.add(ttId);
	}
	
	/**
	 * Returns all SToken objects which refers to points of time in the given interval.
	 * @param sStart
	 * @param sEnd
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EList<SToken> getSTokensByTimeInterval(Integer sStart, Integer sEnd)
	{
		EList<Class<? extends SNode>> classes= new BasicEList<Class<? extends SNode>>();
		classes.add(SToken.class);
		EList<SToken> sTokens= ((EList<SToken>) (EList<? extends SNode>)this.getSNodesByTimeInterval(sStart, sEnd, classes));
		
		return(sTokens);
	}
	
	/**
	 * Returns all SSpan objects which refers to points of time in the given interval.
	 * @param sStart
	 * @param sEnd
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EList<SSpan> getSSpanByTimeInterval(Integer sStart, Integer sEnd)
	{
		EList<Class<? extends SNode>> classes= new BasicEList<Class<? extends SNode>>();
		classes.add(SSpan.class);
		EList<SSpan> sSpans= ((EList<SSpan>) (EList<? extends SNode>)this.getSNodesByTimeInterval(sStart, sEnd, classes));
		
		return(sSpans);
	}
	
	/**
	 * Returns all SSpan objects which refers to points of time in the given interval.
	 * @param sStart
	 * @param sEnd
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EList<SNode> getSNodeByTimeInterval(Integer sStart, Integer sEnd)
	{
		EList<Class<? extends SNode>> classes= new BasicEList<Class<? extends SNode>>();
		classes.add(SNode.class);
		EList<SNode> sNodes= ((EList<SNode>) (EList<? extends SNode>)this.getSNodesByTimeInterval(sStart, sEnd, classes));
		
		return(sNodes);
	}
	
	//TODO this method has to traverse graph
	private EList<SNode> getSNodesByTimeInterval(Integer sStart, Integer sEnd, EList<Class<? extends SNode>> nodeClasses)
	{
		if (this.getSDocumentGraph()== null)
			new SaltModuleException("Cannot start method please set the document graph first.");
			
		EList<SNode> nodes= null;
		for (STimelineRelation timeRel: this.getSDocumentGraph().getSTimelineRelations())
		{//walk through all time-relations
			if (	(timeRel.getSStart() >= sStart) &&
					(timeRel.getSEnd() <= sEnd))
			{//timeRel is in the interval
				for (Class<? extends SNode> nodeClass: nodeClasses)
				{
					if (nodes== null)
						nodes= new BasicEList<SNode>();
					if (nodeClass.isInstance(timeRel.getSSource()))
					{//source is of correct type
						nodes.add(timeRel.getSSource());
					}
				}
			}
		}
		return(nodes);
	}
	
	/**
	 * This class stores a pair of points of time (pot) or points of text. A start pot and an end pot.
	 * @author Administrator
	 *
	 */
	public class POTPair
	{
		private Integer startPOT= null;
		private Integer endPOT= null;
		
		public Integer getStartPot()
		{ return(startPOT);}
		public Integer getEndPot()
		{ return(endPOT);}
	}
	
	private POTPair currPOTPair= null;
	/**
	 * Returns a pair of starting and ending point of time corresponding to the given SNode-object.
	 * @param sNode the node to which the pair has to be searched
	 * @return pair of points of time
	 */
	public POTPair getPOT(SNode sNode)
	{
		POTPair potPair= null;
		this.currPOTPair= new POTPair();
		GraphTraverser graphTraverser= new GraphTraverser();
		graphTraverser.setGraph(this.getSDocumentGraph());
		GraphTraverserObject travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
		this.addTTid(travObj.getId(), TRAVERSAL_TYPE.OVERLAPPED_TIME);
		travObj.start(sNode);
		travObj.waitUntilFinished();
		
		potPair= this.currPOTPair;
		return(potPair);
	}
// ======================== start: getting text interval ========================
	/**
	 * Returns a pair of starting and ending point of text corresponding to the given SNode-object.
	 * @param sNode the node to which the pair has to be searched
	 * @return pair of points of text
	 */
	public POTPair getSTextPOT(SNode sNode)
	{
		POTPair potPair= null;
		this.currPOTPair= new POTPair();
		
		GraphTraverser graphTraverser= new GraphTraverser();
		graphTraverser.setGraph(this.getSDocumentGraph());
		GraphTraverserObject travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
		this.addTTid(travObj.getId(), TRAVERSAL_TYPE.OVERLAPPED_TEXT);
		travObj.start(sNode);
		travObj.waitUntilFinished();
		if (	(this.sTextDS!= null) &&
				(this.sTextDS.getSText()!= null) &&
				(!this.sTextDS.getSText().equalsIgnoreCase("")))
		{
			this.currPOTPair.startPOT= this.startTextPos;
			this.currPOTPair.endPOT= this.endTextPos;
//			retString= this.sTextDS.getSText().substring(this.startTextPos, this.endTextPos);
		}
		
		potPair= this.currPOTPair;
		return(potPair);
	}
// ======================== end: getting text interval ========================
	/**
	 * a list in which the textual overlapped tokens will be stored 
	 */
	private EList<SToken> sOverlappedTokens= null;
	
	/**
	 * Returns a list of tokens wchich are indirectly related to the given sStructuredNode-object 
	 * by STextualOverlapplingRelation.
	 * @param sStructuredNode node whos subtree has to be searched for tokens
	 * @return list of Stoken-objects
	 */
	public EList<SToken> getSTextualOverlappedTokens(SStructuredNode sStructuredNode)
	{
		EList<SToken> retList= null;
		this.sOverlappedTokens= new BasicEList<SToken>();
		GraphTraverser graphTraverser= new GraphTraverser();
		graphTraverser.setGraph(this.getSDocumentGraph());
		GraphTraverserObject travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
		this.addTTid(travObj.getId(), TRAVERSAL_TYPE.OVERLAPPED_TOKENS_BY_TEXTUALRELATION);
		travObj.start(sStructuredNode);
		travObj.waitUntilFinished();
		if (	(this.sOverlappedTokens!= null) && 
				(this.sOverlappedTokens.size()!= 0))
			retList= this.sOverlappedTokens;
		return(retList);
	}
	
//========================= start: getting overlapped text =========================	
	
	/**
	 * TextualDS from which text will be get
	 */
	private STextualDS sTextDS= null;
	/**
	 * start of text in textDS
	 */
	private Integer startTextPos= null;
	/**
	 * end of text in textDS
	 */
	private Integer endTextPos= null;
	/**
	 * Returns the text which is overlapped by directly or indirectly by the given SNode-object. 
	 * This method traverses graph by using relations, which have a positive feature text_overlapping. 
	 * @param sNode
	 * @return
	 */
	public String getSOverlappedText(SNode sNode)
	{
		//TODO can be replaced by calling getTextPOT(SNode sNode) and getting the text by substring with pot 
		String retString= null;
		{//init for run
			sTextDS= null;
			startTextPos= null;
			endTextPos= null;
		}
		GraphTraverser graphTraverser= new GraphTraverser();
		graphTraverser.setGraph(this.getSDocumentGraph());
		GraphTraverserObject travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
		this.addTTid(travObj.getId(), TRAVERSAL_TYPE.OVERLAPPED_TEXT);
		travObj.start(sNode);
		travObj.waitUntilFinished();
		if (	(this.sTextDS!= null) &&
				(this.sTextDS.getSText()!= null) &&
				(!this.sTextDS.getSText().equalsIgnoreCase("")))
			retString= this.sTextDS.getSText().substring(this.startTextPos, this.endTextPos);
		return(retString);
	}
//========================= end: getting overlapped text =========================
	/**
	 * Returns true, if the given list of tokens is continuous in order of start position
	 * related to textual resource.
	 * @param sTokenList list to check against sTokens of sDocumentGraph
	 * @return true, if list is continuous
	 */
	public Boolean getContinuously(EList<SToken> sTokenList)
	{
		Boolean retVal= null;
		//compute sorted list of overlapped tokens by the given sStructuredNode
		EList<SToken> overlappedSTokens= getSTokensSortedByText(sTokenList);
		//compute a sort list of all tokens
		EList<SToken> allTokens= getSTokensSortedByText();
		
		retVal= true;
		Integer posOfSTokenInAllTokens= null;
		for (SToken sToken: overlappedSTokens)
		{
			Integer newPosition= allTokens.indexOf(sToken);
			if (posOfSTokenInAllTokens!= null)
			{	
				if (newPosition != posOfSTokenInAllTokens +1)
				{
					retVal= false;
					break;
				}
			}
			posOfSTokenInAllTokens= newPosition;
		}
		
		return(retVal);
	}
	
	
	/**
	 * Returns all SToken-objects contained in given list in order  
	 * of start-position of text. This method will sort the list of tokens by bubble sort.
	 * @return list of tokens in order of left text position
	 */
	public EList<SToken> getSTokensSortedByText(EList<SToken> sTokens2sort)
	{
		if (this.getSDocumentGraph()== null)
			new SaltModuleException("Cannot start method please set the document graph first.");
		
		STokenSStartComparator comparator= new STokenSStartComparator();
		comparator.setsDocumentGraph(this.getSDocumentGraph());
		EList<SToken> retVal= new BasicEList<SToken>(sTokens2sort);
		//sort tokens
		Collections.sort(retVal, comparator);
		
		return(retVal);
	}
	
	/**
	 * Returns all SToken-objects contained by settet SDocumentGraph in order 
	 * of start-position of text. This method will sort the list of tokens by bubble sort.
	 * @return list of tokens in order of left text position
	 */
	public EList<SToken> getSTokensSortedByText()
	{
		if (this.getSDocumentGraph()== null)
			new SaltModuleException("Cannot start method please set the document graph first.");
		
		return(this.getSTokensSortedByText(this.getSDocumentGraph().getSTokens()));
//		EList<SToken> retVal= null;
//		if (this.getSDocumentGraph()== null)
//			new SaltModuleException("Cannot start method please set the document graph first.");
//		
//		Object[][] tokenPosArray= new Object[this.getSDocumentGraph().getSTokens().size()][3];
//		int posArrayIdx= 0;
//		//search through all tokens in document, and store them with left and right span info in an array
////		SDocumentGraph contentDocGraph= null;
//		for (SToken sToken : this.getSDocumentGraph().getSTokens())
//		{
//			tokenPosArray[posArrayIdx][0]= sToken;
//			for (Edge edge : this.getSDocumentGraph().getOutEdges(sToken.getId()))
//			{
//				if (edge instanceof STextualRelation)
//				{
//					tokenPosArray[posArrayIdx][1]= ((STextualRelation)edge).getSStart();
//					tokenPosArray[posArrayIdx][2]= ((STextualRelation)edge).getSEnd();
//				}
//					
//			}
//			posArrayIdx++;
//			
//		}
//		retVal= new BasicEList<SToken>();
//		
//		long numOfTok= tokenPosArray.length;
//		boolean changed= false;
//		do
//		{
//			changed= false;
//			for (int i= 0; i< tokenPosArray.length-1; i++)
//			{
//				if (((Integer)tokenPosArray[i][1]) > ((Integer)tokenPosArray[i+1][1]))
//				{
//					//temprorary data
//					SToken tmpToken= (SToken)tokenPosArray[i][0];
//					Integer tmpLeft= (Integer) tokenPosArray[i][1];
//					Integer tmpRight= (Integer) tokenPosArray[i][2];
//					//override
//					tokenPosArray[i][0]= tokenPosArray[i+1][0];
//					tokenPosArray[i][1]= tokenPosArray[i+1][1];
//					tokenPosArray[i][2]= tokenPosArray[i+1][2];
//					//write back temprorary data
//					tokenPosArray[i+1][0]= tmpToken;
//					tokenPosArray[i+1][1]= tmpLeft;
//					tokenPosArray[i+1][2]= tmpRight;
//					changed= true;
//				}
//				numOfTok--;
//			}
//		} while ((changed) && (numOfTok >= 1));
//		
//		for (int i= 0; i < tokenPosArray.length; i++)
//		{
//			retVal.add((SToken)tokenPosArray[i][0]);
//		}
//
//		
//		return(retVal);
	}
//========================= start: getting roots for given Relation type (Class) =========================
	
	/**
	 * Returns all SNode objects which are roots for the given SRelation Subtype. Means, that all SNode-objects
	 * will be returned as roots, which have no incoming SRelation-objects of the given subtype clazz. 
	 * <br/>
	 * Attention: Only  the subtypes SPointingRelation, SSpanningRelation and SDominanceRelation 
	 * are supported yet.
	 * <br/>
	 * @param clazz Subclass of SRelation which shall be used for computing roots
	 * @return a list of SNode-objects which are roots 
	 */
	//TODO another handling, that all Subtypes of relations are possible not just SPointingRelation, SSpanningRelation and SDominanceRelation
	@SuppressWarnings("unchecked")
	public EList<SNode> getRootsBySRelation(Class<? extends SRelation> clazz)
	{
		EList<SNode> retVal= null;
		if (this.getSDocumentGraph()== null)
			new SaltModuleException("Cannot start method please set the document graph first.");
		
		if (clazz== null)
			throw new SaltModuleException("Cannot compute roots for given SRelation subtype, becuase it is null.");
		if (	(!clazz.equals(SPointingRelation.class)) &&
				(!clazz.equals(SSpanningRelation.class)) &&
				(!clazz.equals(SDominanceRelation.class)))
		{// if the subtype isn´t supported throw exception
			throw new SaltModuleException("Cannot compute roots for given SRelation subtype '"+clazz+"', because it isn´t supported yet. Supported subtypes are only: SPointingRelation, SSpanningRelation and SDominanceRelation");
		}// if the subtype isn´t supported throw exception
			
		
		EList<SRelation> relations= null;
		{//compute all relations of subtype
			if (clazz.equals(SPointingRelation.class)) 
				relations= (EList<SRelation>) (EList<? extends SRelation>) this.getSDocumentGraph().getSPointingRelations();
			else if (clazz.equals(SDominanceRelation.class)) 
				relations= (EList<SRelation>) (EList<? extends SRelation>) this.getSDocumentGraph().getSDominanceRelations();
			else if (clazz.equals(SSpanningRelation.class)) 
				relations= (EList<SRelation>) (EList<? extends SRelation>) this.getSDocumentGraph().getSSpanningRelations();
		}//compute all relations of subtype
		if (relations!= null)
		{
			retVal= new BasicEList<SNode>();
			EList<SNode> notRootElements= new BasicEList<SNode>();
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
//========================= end: getting roots for given Relation type (Class) =========================
	
	
	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Edge edge, Node currNode, long order) 
	{
//		System.out.println("checkConstraint(traversalMode: "+ traversalMode+ ", currNode: "+ currNode.getId()+ ")");
		SRelation relation= null;
		if (edge== null);
		else if (!(edge instanceof SRelation))
			throw new SaltModuleException("Cannot traverse the given SDocumentGraph, because there is an edge, which is not of type SRelation: "+edge.getId()+ ".");
		else relation = (SRelation) edge;
		
		TRAVERSAL_TYPE currTType= null;
		{//search for current traversal type
			for (TraversalTypeId ttId: this.typeIDList)
			{
				if (ttId.id.equals(traversalId))
				{
					currTType= ttId.travType;
					break;
				}
			}
		}
		
		Boolean retVal= false;
		
		//traversal type is OVERLAPPED_TEXT
		if (currTType.equals(TRAVERSAL_TYPE.OVERLAPPED_TEXT))
		{
			if (relation== null)
				retVal= true;
			else if (relation instanceof STextOverlappingRelation)
			{
				retVal= ((STextOverlappingRelation)relation).isSTextOverlapping();
			}
			else
				retVal= false;
		}
		//traversal type is OVERLAPPED_TIME
		else if (currTType.equals(TRAVERSAL_TYPE.OVERLAPPED_TIME))
		{
			if (relation== null)
				retVal= true;
			else if (relation instanceof STimeOverlappingRelation)
			{
				retVal= ((STimeOverlappingRelation)relation).isSTimeOverlapping();
			}
			else
			{
				retVal= false;
			}
		}
		//traversal type is OVERLAPPED_TOKENS_BY_TEXTUALRELATION
		else if (currTType.equals(TRAVERSAL_TYPE.OVERLAPPED_TOKENS_BY_TEXTUALRELATION))
		{
			if (relation== null)
				retVal= true;
			else if (relation instanceof STextOverlappingRelation)
			{
				retVal= ((STextOverlappingRelation)relation).isSTextOverlapping();
			}
			else
			{
				retVal= false;
			}
		}
//		System.out.println("checkConstraint(traversalMode: "+ traversalMode+ ", currNode: "+ currNode.getId()+ ")-->"+retVal);
		return(retVal);
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_MODE traversalMode, Long traversalId,
			Node currNode, Edge edge, Node fromNode, long order) 
	{
//		System.out.println("nodeLeft(traversalMode: "+ traversalMode+ ", currNode: "+ currNode.getId()+ ")");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nodeReached(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Node currNode, Edge edge, Node fromNode,
			long order) 
	{
//		System.out.println("nodeReached(traversalMode: "+ traversalMode+ ", currNode: "+ currNode.getId()+ ")");
		SRelation relation= null;
		if (edge== null);
		else if (!(edge instanceof SRelation))
			throw new SaltModuleException("Cannot traverse the given SDocumentGraph, because there is an edge, which is not of type SRelation: "+edge.getId()+ ".");
		else relation= (SRelation) edge;
		if (!(currNode instanceof SNode))
			throw new SaltModuleException("Cannot traverse the given SDocumentGraph, because there is an edge, which is not of type SNode: "+currNode.getId()+ ".");
		
		SNode currSNode= (SNode) currNode;
		
		TRAVERSAL_TYPE currTType= null;
		{//search for current traversal type
			for (TraversalTypeId ttId: this.typeIDList)
			{
				if (ttId.id.equals(traversalId))
				{
					currTType= ttId.travType;
					break;
				}
			}
		}
		//traversal type is OVERLAPPED_TEXT
		if (currTType.equals(TRAVERSAL_TYPE.OVERLAPPED_TEXT))
		{
			if (currSNode instanceof STextualDS)
				this.sTextDS= (STextualDS) currSNode;
			if (relation instanceof STextualRelation)
			{
				if (this.startTextPos== null)
					this.startTextPos= ((STextualRelation)relation).getSStart();
				if (this.endTextPos== null)
					this.endTextPos= ((STextualRelation)relation).getSEnd();
				if (((STextualRelation)relation).getSStart() < this.startTextPos)
					this.startTextPos= ((STextualRelation)relation).getSStart(); 
				if (((STextualRelation)relation).getSEnd() > this.endTextPos)
					this.endTextPos= ((STextualRelation)relation).getSEnd(); 
			}
		}
		//traversal type is OVERLAPPED_TIME
		else if (currTType.equals(TRAVERSAL_TYPE.OVERLAPPED_TIME))
		{
			if (relation instanceof STimelineRelation)
			{
				if (this.currPOTPair.startPOT== null)
					this.currPOTPair.startPOT= ((STimelineRelation)relation).getSStart();
				if (this.currPOTPair.endPOT== null)
					this.currPOTPair.endPOT= ((STimelineRelation)relation).getSEnd();
				if (((STimelineRelation)relation).getSStart() < this.currPOTPair.startPOT)
					this.currPOTPair.startPOT= ((STimelineRelation)relation).getSStart(); 
				if (((STimelineRelation)relation).getSEnd() > this.currPOTPair.endPOT)
					this.currPOTPair.endPOT= ((STimelineRelation)relation).getSEnd(); 
			}
		}
		//traversal type is OVERLAPPED_TIME
		else if (currTType.equals(TRAVERSAL_TYPE.OVERLAPPED_TOKENS_BY_TEXTUALRELATION))
		{
			if (relation instanceof STextOverlappingRelation)
			{
				// if node is a token, put it into list
				if (currSNode instanceof SToken) 
				{
					if (!this.sOverlappedTokens.contains((SToken) currSNode))
						this.sOverlappedTokens.add((SToken) currSNode);
				}
			}
		}
	}
}
