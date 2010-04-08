package de.hub.corpling.salt.saltCore.modules.util;

import java.util.Hashtable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osgi.service.log.LogService;

import de.hub.corpling.graph.Edge;
import de.hub.corpling.graph.Node;
import de.hub.corpling.graph.exceptions.GraphException;
import de.hub.corpling.graph.modules.GraphTraverser;
import de.hub.corpling.graph.modules.GraphTraverserObject;
import de.hub.corpling.graph.modules.TraversalObject;
import de.hub.corpling.graph.modules.GraphTraverser.GRAPH_TRAVERSE_MODE;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.modules.CycleCheckerListener;
import de.hub.corpling.salt.saltCore.modules.SGraphAccessorModule;
import de.hub.corpling.salt.saltCore.modules.CycleCheckerListener.CYCLE_LEVELS;
import de.hub.corpling.salt.saltExceptions.SaltModuleException;

public class CycleChecker_old implements TraversalObject
{
//============================== start sDocumentGraph-accessor	
	/**
	 * The graph to be checked
	 */
	private SGraph sGraph= null;
	/**
	 * @param sDocumentGraph the sDocumentGraph to set
	 */
	public void setSGraph(SGraph sGraph) {
		this.sGraph = sGraph;
	}

	/**
	 * @return the sDocumentGraph
	 */
	public SGraph getSGraph() {
		return sGraph;
	}
//============================== end sDocumentGraph-accessor

//============================== start LogService
	private LogService logService= null;
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
//============================== end LogService
	/**
	 * The listener which will be called by callback in case of a cycle has been detected.
	 */
	private CycleCheckerListener listener= null;
	
	/**
	 * @param listener the listener to set
	 */
	public void setListener(CycleCheckerListener listener) {
		this.listener = listener;
	}

	/**
	 * @return the listener
	 */
	public CycleCheckerListener getListener() {
		return listener;
	}
	
	
	/**
	 * 
	 * @param listener
	 */
	public void start(CycleCheckerListener listener)
	{
		if (listener!= null)
		{	
			this.setListener(listener);
			this.start();
		}
	}
	
	/**
	 * Starts the cycle checking.
	 * Will only be executed if a CycleCheckerListener is given.
	 */
	@SuppressWarnings("unchecked")
	public void start()
	{
		if (this.getSGraph()== null)
			throw new GraphException("Cannot check cycles in an empty graph.");
		if (this.listener!= null)
		{//if a listener is given	
			if (	(this.getSGraph().getSNodes().size()!= 0) &&
					(this.getSGraph().getSRelations().size()!= 0))
			{//if graph contains nodes and edges	
				EList<SNode> rootNodes= null;
				{//try to use some root nodes if they exists
					SGraphAccessorModule sGraphAccessor= new SGraphAccessorModule();
					sGraphAccessor.setSGraph(this.getSGraph());
					rootNodes= sGraphAccessor.getSRoots();
				}//try to use some root nodes if they exists
				
				{//init traversal
					this.visitedNodesLevel1= new BasicEList<SNode>();
					this.visitedNodesLevel2= new Hashtable<String, EList<SNode>>();
					this.visitedNodesLevel3= new Hashtable<String, Hashtable<String,EList<SNode>>>();
					this.notVisitedNodes= new BasicEList<SNode>();
					this.numOfNotVisitedNodes= 0;
//					this.cyclesLevel1= new BasicEList<List<SNode>>();
				}//init traversal
				
				if (rootNodes!= null)
				{//if some roots exists, start with them	
					System.out.println("==================> checking cycles by roots");
					
					GraphTraverser graphTraverser= new GraphTraverser();
					graphTraverser.setLogService(this.getLogService());
					graphTraverser.setGraph(this.getSGraph());
					GraphTraverserObject travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
					travObj.start((EList<Node>) (EList<? extends SNode>) rootNodes);
					travObj.waitUntilFinished();
					for (Exception e:  travObj.getExceptions())
					{
						if (this.getLogService()!= null)
							this.getLogService().log(LogService.LOG_ERROR, e.getMessage());
						throw(new SaltModuleException("An exception occurs while computing cycles of graph '"+this.getSGraph().getSId()+".", e));
					}
				}//if some roots exists, start with them
				
				if (numOfNotVisitedNodes < this.getSGraph().getNumOfNodes())
				{//check if all nodes have been traversed
					for (SNode sNode: this.getSGraph().getSNodes())
					{//compute list of not yet visited nodes
						if (!this.visitedNodesLevel1.contains(sNode))
							this.notVisitedNodes.add(sNode);
					}//compute list of not yet visited nodes
					while (notVisitedNodes.size()!= 0)
					{//do until all nodes has been visited
						System.out.println("==================> checking cycles with no roots");
						int numOfNotVisitedNodes= this.notVisitedNodes.size();
						GraphTraverser graphTraverser= new GraphTraverser();
						graphTraverser.setLogService(this.getLogService());
						graphTraverser.setGraph(this.getSGraph());
						GraphTraverserObject travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
						travObj.start(this.notVisitedNodes.get(0));
						travObj.waitUntilFinished();
						for (Exception e:  travObj.getExceptions())
						{
							if (this.getLogService()!= null)
								this.getLogService().log(LogService.LOG_ERROR, e.getMessage());
							throw(new SaltModuleException("An exception occurs while computing cycles of graph '"+this.getSGraph().getSId()+".", e));
						}
						if (numOfNotVisitedNodes== this.notVisitedNodes.size())
							throw new SaltModuleException("An exception occurs while computing cycles for subgraphs with no roots of graph '"+this.getSGraph().getSId()+"'. After computing cycles the number of not visited nodes is the same as before ("+numOfNotVisitedNodes+" hasn´t been visited).");
					}//do until all nodes has been visited
				}//check if all nodes have been traversed
			}//if graph contains nodes and edges
		}//if a listener is given
	}
	
	protected SNode[] getShortCycle(EList<SNode> longCycle, SNode duplicatedNode)
	{
//		List<SNode> shortCycle= null;
		SNode[] shortCycle= null;
		int lastIndex= longCycle.lastIndexOf(duplicatedNode);
	
		shortCycle= new SNode[(longCycle.size()-lastIndex)+1];
		int arrayIdx= 0;
		for (int i= lastIndex; i< longCycle.size(); i++)
		{
			shortCycle[arrayIdx]= longCycle.get(i);
			arrayIdx++;
		}
		shortCycle[arrayIdx]= duplicatedNode;
		
		return(shortCycle);
	}
	
	/**
	 * stores the visited nodes for level-1: nodes
	 */
	private EList<SNode> visitedNodesLevel1= null;
	/**
	 * stores the visited nodes for level-2: class-name, nodes
	 */
	private Hashtable<String, EList<SNode>> visitedNodesLevel2= null;
	/**
	 * stores the visited nodes for level-3: class-name, stype, nodes
	 */
	private Hashtable<String, Hashtable<String,EList<SNode>>> visitedNodesLevel3= null;
	
	/**
	 * Stores the nodes, which hasn´t been visited for second check
	 */
	private EList<SNode> notVisitedNodes= null;
	private int numOfNotVisitedNodes= 0;
	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Edge edge, Node currNode, long order) 
	{
		Boolean retVal= true;
		SNode sNode = (SNode) currNode;
		String currRelClass= null;
		SRelation sRelation= null;
		if (edge!= null)
		{
			sRelation= (SRelation) edge;
			currRelClass= sRelation.getClass().getSimpleName();
		}
		
		if (sRelation== null)
			System.out.println("null --> "+currNode.getId());
		else
			System.out.println(edge.getSource().getId()+" -["+sRelation.getClass().getSimpleName()+"|"+sRelation.getSTypes()+"]-> "+currNode.getId());
		 		
		{//checking level-1 cycles
			System.out.println("visited nodes of level-1: "+visitedNodesLevel1);
			if (visitedNodesLevel1.contains(sNode))
			{//node has been visited
				System.out.println("cycle-1 DETECTED");
				this.listener.cycleDetected(CYCLE_LEVELS.LEVEL_1, null, null, this.getShortCycle(visitedNodesLevel1, sNode));
			}//node has been visited
			else 
			{
				numOfNotVisitedNodes++;
				if (notVisitedNodes!= null)
					notVisitedNodes.remove(sNode);
			}
			if (	(sRelation!= null) &&
					(	(visitedNodesLevel1.size()== 0) ||
						(!visitedNodesLevel1.get(visitedNodesLevel1.size()-1).equals(sRelation.getSSource()))))
			{
				visitedNodesLevel1.add(sRelation.getSSource());
			}
			visitedNodesLevel1.add(sNode);
		}//checking level-1 cycles
		{//checking level-2 cylces
			if (sRelation!= null)
			{
				EList<SNode> slot= this.visitedNodesLevel2.get(currRelClass);
				if (slot!= null)
				{
					if (slot.contains(sNode))
					{//node has been visited
						this.listener.cycleDetected(CYCLE_LEVELS.LEVEL_2, sRelation.getClass(), null, this.getShortCycle(slot, sNode));
					}//node has been visited
				}
				else
				{//create new slot for SRelation-type
					slot= new BasicEList<SNode>();
					this.visitedNodesLevel2.put(currRelClass, slot);
				}//create new slot for SRelation-type
				{//if the last element of slot isn´t the source of current relation, add the source of current relation (this have to be done, because of it is missing otherwise)
					if (	(slot.size()== 0) ||
							(!slot.get(slot.size()-1).equals(sRelation.getSSource())))
						slot.add(sRelation.getSSource());
				}//if the last element of slot isn´t the source of current relation, add the source of current relation
					
				slot.add(sNode);
			}
		}//checking level-2 cylces
		{//checking level-3 cylces
			if (sRelation!= null)
			{
				if (	(sRelation.getSTypes()!= null)&&
						(sRelation.getSTypes().size()> 0))
				{	
					Hashtable<String, EList<SNode>> table= this.visitedNodesLevel3.get(currRelClass);
					if (table== null)
					{//if table does not exist, create and add it
						table= new Hashtable<String, EList<SNode>>();
						this.visitedNodesLevel3.put(currRelClass, table);
					}//if table does not exist, create and add it
					
					for (String sType : sRelation.getSTypes())
					{//for every sType of sRelation	
						EList<SNode> slot= table.get(sType);
						if (slot!= null)
						{//if a slot for sType already exists
							if (slot.contains(sNode))
							{//node has been visited
								this.listener.cycleDetected(CYCLE_LEVELS.LEVEL_3, sRelation.getClass(), sType, this.getShortCycle(slot, sNode));
								retVal= false;
							}//node has been visited
						}//if a slot for sType already exists
						else
						{//no slot for sType exists, create one
							slot= new BasicEList<SNode>();
							table.put(sType, slot);
						}//no slot for sType exists, create one
						{//if the last element of slot isn´t the source of current relation, add the source of current relation (this have to be done, because of it is missing otherwise)
							if (	(slot.size()== 0) ||
									(!slot.get(slot.size()-1).equals(sRelation.getSSource())))
								slot.add(sRelation.getSSource());
						}//if the last element of slot isn´t the source of current relation, add the source of current relation
						slot.add(sNode);
					}//for every sType of sRelation
				}
			}
		}//checking level-3 cylces
		return(retVal);
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_MODE traversalMode, Long traversalId,
			Node currNode, Edge edge, Node fromNode, long order) {
		
	}

	@Override
	public void nodeReached(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Node currNode, Edge edge, Node fromNode,
			long order) {
	}
}
