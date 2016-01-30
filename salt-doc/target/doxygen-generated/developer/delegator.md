# Expanding Salt {#dev_delegator}

Salt offers the possibility via the use of the [delegator pattern](https://en.wikipedia.org/wiki/Delegation_pattern), to extend the behavior of its base types: org.corpus_tools.salt.graph.Graph, org.corpus_tools.salt.graph.Node, org.corpus_tools.salt.graph.Relation, org.corpus_tools.salt.graph.Layer and org.corpus_tools.salt.graph.Label. 

How to use the extension mechanism see \ref delegator.

To realize this mechanism, each class contains a constructor consuming one of Salt's base types. This is always the same type the class is derived from. For instance all types which are derived from Node consumes an object of type Node e.g. SToken, SSpan, SStructure, ... . 
To delegate the behavior from the delegator to the delegate each public method needs to check whether the internal variable _delegate_ is set. If true, the delegate's implementation needs to be called. For instance the methods setGraph() and getGraph() in class Node:

~~~{.java}
	/** {@inheritDoc Relation#getGraph()} **/
	@Override
	public Graph getGraph() {
		if (getDelegate() != null) {
			return (getDelegate().getGraph());
		}
		return (graph);
	}

	/** {@inheritDoc Relation#setGraph(Graph)} **/
	@Override
	public void setGraph(Graph graph) {
		if (getDelegate() != null) {
			delegate.setGraph(graph);
			return;
		}
		...
	}
~~~

Take care, that in case of bidirectional references it is to check, which object (delegator/ delegate) has to point to which other object (delegator/ delegate). Let us take the reference between Graph and Node for instance, than the bidirectional reference should look like this:

~~~
	Delegator (Graph)  <\   />  Delegator(Node)
	    ||               \ /        ||                          
	    ||                X         ||
	    \/               / \        \/
	Delegate (Graph)            Delegate (Node) 
~~~

This ensures, when Graph.getNodes() is called, the node delegator is returned and when Node.getGraph() is called, the graph delegator is returned.