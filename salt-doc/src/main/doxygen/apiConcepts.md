Salt api concepts {#apiConcepts}
==========

Factory pattern
=================

The Salt's api uses the factory pattern (see https://en.wikipedia.org/wiki/Factory_method_pattern). That means the propper way to create a Salt object is to call the create method of the Salt factory. For instance to create a Token use:

~~~{.java}
SaltFactory.createToken();
~~~

The same goes for all the other Salt elements. The default factory will create an instance of @ref org.corpus_tools.salt.common.impl.STokenImpl which implements the interface @ref org.corpus_tools.salt.common.SToken. To realize the factory pattern, we need to split an element into an interface and an implementation. This allows to exchange the implementation behing the interface. 
Parallel to all Salt elements the SaltFactory itself is split into an interface and an implementation. The default implementation is the class @ref org.corpus_tools.salt.impl.SaltFactoryImpl. But you can exchange the factory for instance to enable the notification mechanism (see  \ref notification) by setting a new factory implementation:

~~~{.java}
SaltFactory.setFactory(NEW_FACTORY_IMPLEMENTATION);
~~~

You can also implement your own factory and inject it.

Bidirectional references{#bidirectionalReferences}
=================

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