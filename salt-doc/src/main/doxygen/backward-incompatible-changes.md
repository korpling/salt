Backward incompatible changes {#incompatible-changes-salt-api}
=======================

This documents what developers using the Salt API have to change when updating to a new major Salt version.
In general we use semantic versioning (http://semver.org/) and this page only highlights backwards incompatible changes 
for each major version update.


From Salt 3 to 4 {#changes-salt-3-to-4}
================

SNode
-----


- The function `SNode.setGraph(...)` was removed. Use [SGraph.addNode(...)](@ref org.corpus_tools.salt.common.SGraph#addNode) instead.
~~~{.java}
// old
myNode.setGraph(myGraph);
  
// new
myGraph.addNode(myNode);
~~~
- The function `SNode.addLayer(...)` was removed. Use [SLayer.addNode(...)](@ref org.corpus_tools.salt.core.SLayer#addNode) instead.
~~~{.java}
// old
myNode.addLayer(myLayer);
  
// new
myLayer.addNode(myNode);
~~~

SRelation
-----


- The function `SRelation.setGraph(...)` was removed. Use [SGraph.addRelation(...)](@ref org.corpus_tools.salt.common.SGraph#addRelation) instead.
~~~{.java}
// old
myRelation.setGraph(myGraph);
  
// new
myGraph.addNode(myRelation);
~~~




GraphTraverseHandler
-------------------


- Relation arguments in the callback functions [nodeReached(...)](@ref org.corpus_tools.salt.core.GraphTraverseHandler#nodeReached),
[nodeLeft(...)](@ref org.corpus_tools.salt.core.GraphTraverseHandler#nodeLeft) and
[checkConstraint(...)](@ref org.corpus_tools.salt.core.GraphTraverseHandler#checkConstraint) now use 
~~~{.java}
SRelation<? extends SNode, ? extends SNode>
~~~
instead of 
~~~{.java}
SRelation<SNode, SNode>
~~~
as type definition.


SGraph
-------------------

- [getInRelations(String id)](@ref org.corpus_tools.salt.common.SGraph#getInRelations) and
[getOutRelations(String id)](@ref org.corpus_tools.salt.common.SGraph#getOutRelations)  
now use 
~~~{.java}
List<SRelation<? extends SNode, ? extends SNode>>
~~~
instead of 
~~~{.java}
List<SRelation<SNode, SNode>>
~~~
as return type. In a lot of cases you can just use
~~~{.java}
List<SRelation<?,?>> 
~~~
if you are not interested in the specific type of the source and target nodes.


    