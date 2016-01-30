## Bidirectional references {#bidirectionalReferences}


In Salt a lot of references between two objects are bidirectional. Bidirectional means, that object _A_ refers to object _B_ and object _B_ refers to object _A_. For instance the reference between a graph and a node is such a bidirectional reference. That means when a node is added to a graph, you can access the node via @ref org.corpus_tools.salt.graph.Graph#getNodes() and you can access the graph via @ref org.corpus_tools.salt.graph.Node#getGraph(). 

The same goes for removing an object. For instance when removing the node from graph via via @ref org.corpus_tools.salt.graph.Graph#removeNode(), the reference from the node to the graph is also removed (via @ref org.corpus_tools.salt.graph.Node#getGraph() will return null).

Other bidirectional references are:

* Graph <--> Node
* Graph <--> Relation
* Graph <--> Layer
* Graph <--> Label
* Node <--> Label
* Relation <--> Label
* Layer <--> Label