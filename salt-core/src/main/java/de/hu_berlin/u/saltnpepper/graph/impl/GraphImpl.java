package de.hu_berlin.u.saltnpepper.graph.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.util.Index;
import de.hu_berlin.u.saltnpepper.graph.util.IndexImpl;

public class GraphImpl extends IdentifiableElementImpl implements Graph, NamedElement{
	/**
	 * name of index for node-types
	 */
	public static final String IDX_SNODETYPE=	"idx_sNodeType";
	/**
	 * name of index for relation-types
	 */
	public static final String IDX_SRELATIONTYPE=	"idx_sRelationType";
	
	private Index index= null;
	public Index getIndex(){
		return(index);
	}
	
	public GraphImpl(){
		index= new IndexImpl();
	}
	
	private List<NodeImpl> nodes= null;
	public List<NodeImpl> getNodes(){
		if (nodes== null){
			nodes= Collections.synchronizedList(new ArrayList<NodeImpl>());
		}
		return(Collections.unmodifiableList(nodes));
	}
	
	private List<EdgeImpl> edges= null;
	public List<EdgeImpl> getEdges(){
		if (edges== null){
			edges= Collections.synchronizedList(new ArrayList<EdgeImpl>());
		}
		return(Collections.unmodifiableList(edges));
	}
	
	private List<Layer> layers= null;
	public List<Layer> getLayers(){
		if (layers== null){
			layers= Collections.synchronizedList(new ArrayList<Layer>());
		}
		return(Collections.unmodifiableList(layers));
	}
	
	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
}
