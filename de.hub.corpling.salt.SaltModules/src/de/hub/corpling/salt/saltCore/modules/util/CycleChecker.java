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

public class CycleChecker implements TraversalObject
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
					this.visitedRelationsLevel1= new BasicEList<SRelation>();
					this.visitedRelationsLevel2= new Hashtable<String, EList<SRelation>>();
					this.visitedRelationsLevel3= new Hashtable<String, Hashtable<String,EList<SRelation>>>();
					this.notVisitedRelations= new BasicEList<SRelation>();
					this.numOfNotVisitedRelations= 0;
//					this.cyclesLevel1= new BasicEList<List<SNode>>();
				}//init traversal
				
				if (rootNodes!= null)
				{//if some roots exists, start with them	
					System.out.println("==================> checking cycles by roots");
					
					GraphTraverser graphTraverser= new GraphTraverser();
					graphTraverser.setLogService(this.getLogService());
					graphTraverser.setGraph(this.getSGraph());
					GraphTraverserObject travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
					travObj.setCycleSafe(false);
					travObj.start((EList<Node>) (EList<? extends SNode>) rootNodes);
					travObj.waitUntilFinished();
					for (Exception e:  travObj.getExceptions())
					{
						if (this.getLogService()!= null)
							this.getLogService().log(LogService.LOG_ERROR, e.getMessage());
						throw(new SaltModuleException("An exception occurs while computing cycles of graph '"+this.getSGraph().getSId()+".", e));
					}
				}//if some roots exists, start with them
				
				if (numOfNotVisitedRelations < this.getSGraph().getNumOfNodes())
				{//check if all nodes have been traversed
					for (SRelation sRelation: this.getSGraph().getSRelations())
					{//compute list of not yet visited nodes
						if (!this.visitedRelationsLevel1.contains(sRelation))
							this.notVisitedRelations.add(sRelation);
					}//compute list of not yet visited nodes
					while (notVisitedRelations.size()!= 0)
					{//do until all nodes has been visited
						System.out.println("==================> checking cycles with no roots");
						int numOfNotVisitedRelations= this.notVisitedRelations.size();
						GraphTraverser graphTraverser= new GraphTraverser();
						graphTraverser.setLogService(this.getLogService());
						graphTraverser.setGraph(this.getSGraph());
						GraphTraverserObject travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
						travObj.setCycleSafe(false);
						travObj.start(this.notVisitedRelations.get(0).getSSource());
						travObj.waitUntilFinished();
						for (Exception e:  travObj.getExceptions())
						{
							if (this.getLogService()!= null)
								this.getLogService().log(LogService.LOG_ERROR, e.getMessage());
							throw(new SaltModuleException("An exception occurs while computing cycles of graph '"+this.getSGraph().getSId()+".", e));
						}
						if (numOfNotVisitedRelations== this.notVisitedRelations.size())
							throw new SaltModuleException("An exception occurs while computing cycles for subgraphs with no roots of graph '"+this.getSGraph().getSId()+"'. After computing cycles the number of not visited nodes is the same as before ("+numOfNotVisitedRelations+" hasn´t been visited).");
					}//do until all nodes has been visited
				}//check if all nodes have been traversed
			}//if graph contains nodes and edges
		}//if a listener is given
	}
	
	protected SNode[] getShortCycle(EList<SRelation> longCycle, SRelation duplicatedSRelation)
	{
//		List<SNode> shortCycle= null;
		SNode[] shortCycle= null;
		int lastIndex= longCycle.lastIndexOf(duplicatedSRelation);
		
		{//debug
			System.out.print("longCycle: ");
			for (SRelation sRelation: longCycle)
				System.out.print("longCycle: "+sRelation.getSSource().getSId()+ "-->"+ sRelation.getSTarget().getSId()+"; ");
			System.out.println();
		}//debug
		
		shortCycle= new SNode[(longCycle.size()-lastIndex)+1];
		int arrayIdx= 0;
		for (int i= lastIndex; i< longCycle.size(); i++)
		{
			System.out.println("adding node to cycle: "+ longCycle.get(i).getSSource());
			shortCycle[arrayIdx]= longCycle.get(i).getSSource();
			arrayIdx++;
		}
		System.out.println("adding node to cycle: "+ duplicatedSRelation.getSTarget());
		shortCycle[arrayIdx]= duplicatedSRelation.getSTarget();
		
		return(shortCycle);
	}
	
	/**
	 * stores the visited nodes for level-1: nodes
	 */
//	private EList<SNode> VisitedRelationsLevel1= null;
	private EList<SRelation> visitedRelationsLevel1= null;
	/**
	 * stores the visited nodes for level-2: class-name, nodes
	 */
	private Hashtable<String, EList<SRelation>> visitedRelationsLevel2= null;
	/**
	 * stores the visited nodes for level-3: class-name, stype, nodes
	 */
	private Hashtable<String, Hashtable<String,EList<SRelation>>> visitedRelationsLevel3= null;
	
	/**
	 * Stores the nodes, which hasn´t been visited for second check
	 */
	private EList<SRelation> notVisitedRelations= null;
	private int numOfNotVisitedRelations= 0;
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
			System.out.println("visited relations of level-1: "+visitedRelationsLevel1);
			if (visitedRelationsLevel1.contains(sRelation))
			{//node has been visited
				System.out.println("cycle-1 DETECTED");
				this.listener.cycleDetected(CYCLE_LEVELS.LEVEL_1, null, null, this.getShortCycle(visitedRelationsLevel1, sRelation));
				retVal= false;
			}//node has been visited
			else 
			{
				numOfNotVisitedRelations++;
				if (notVisitedRelations!= null)
					notVisitedRelations.remove(sNode);
			}
			if (	(sRelation!= null) &&
					(	(visitedRelationsLevel1.size()== 0) ||
							(!visitedRelationsLevel1.get(visitedRelationsLevel1.size()-1).equals(sRelation.getSSource()))))
			{
				visitedRelationsLevel1.add(sRelation);
			}
		}//checking level-1 cycles
		{//checking level-2 cylces
			if (sRelation!= null)
			{
				EList<SRelation> slot= this.visitedRelationsLevel2.get(currRelClass);
				if (slot!= null)
				{
					if (slot.contains(sNode))
					{//node has been visited
//						this.listener.cycleDetected(CYCLE_LEVELS.LEVEL_2, sRelation.getClass(), null, this.getShortCycle(slot, sNode));
					}//node has been visited
				}
				else
				{//create new slot for SRelation-type
					slot= new BasicEList<SRelation>();
					this.visitedRelationsLevel2.put(currRelClass, slot);
				}//create new slot for SRelation-type
				{//if the last element of slot isn´t the source of current relation, add the source of current relation (this have to be done, because of it is missing otherwise)
					if (	(slot.size()== 0) ||
							(!slot.get(slot.size()-1).equals(sRelation.getSSource())))
						slot.add(sRelation);
				}//if the last element of slot isn´t the source of current relation, add the source of current relation
			}
		}//checking level-2 cylces
		{//checking level-3 cylces
			if (sRelation!= null)
			{
				if (	(sRelation.getSTypes()!= null)&&
						(sRelation.getSTypes().size()> 0))
				{	
					Hashtable<String, EList<SRelation>> table= this.visitedRelationsLevel3.get(currRelClass);
					if (table== null)
					{//if table does not exist, create and add it
						table= new Hashtable<String, EList<SRelation>>();
						this.visitedRelationsLevel3.put(currRelClass, table);
					}//if table does not exist, create and add it
					
					for (String sType : sRelation.getSTypes())
					{//for every sType of sRelation	
						EList<SRelation> slot= table.get(sType);
						if (slot!= null)
						{//if a slot for sType already exists
							if (slot.contains(sNode))
							{//node has been visited
								this.listener.cycleDetected(CYCLE_LEVELS.LEVEL_3, sRelation.getClass(), sType, this.getShortCycle(slot, sRelation));
								retVal= false;
							}//node has been visited
						}//if a slot for sType already exists
						else
						{//no slot for sType exists, create one
							slot= new BasicEList<SRelation>();
							table.put(sType, slot);
						}//no slot for sType exists, create one
						{//if the last element of slot isn´t the source of current relation, add the source of current relation (this have to be done, because of it is missing otherwise)
							if (	(slot.size()== 0) ||
									(!slot.get(slot.size()-1).equals(sRelation.getSSource())))
								slot.add(sRelation);
						}//if the last element of slot isn´t the source of current relation, add the source of current relation
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
