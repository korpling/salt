Backward incompatible changes {#incompatible-changes-salt-api}
=======================

This documents what developers using the Salt API have to change when updating to a new major Salt version.
In general we use semantic versioning (http://semver.org/) and this page only highlights backwards incompatible changes 
for each major version update.


From Salt 3 to 4 {#changes-salt-3-to-4}
================


GraphTraverseHandler
-------------------


- Relation arguments in the callback functions [nodeReached(...)](@ref org.corpus_tools.salt.core.GraphTraverseHandler#nodeReached),
[nodeLeft(...)](@ref org.corpus_tools.salt.core.GraphTraverseHandler#nodeLeft) and
[checkConstraint(...)](@ref org.corpus_tools.salt.core.GraphTraverseHandler#checkConstraint) now use 

    SRelation<? extends SNode, ? extends SNode>
instead of 

    SRelation<SNode, SNode>
as type definition.


SGraph
-------------------

- [getInRelations(String id)](@ref org.corpus_tools.salt.common.SGraph#getInRelations) and
[getOutRelations(String id)](@ref org.corpus_tools.salt.common.SGraph#getOutRelations)  
now use 

    List<SRelation<? extends SNode, ? extends SNode>>
instead of 

    List<SRelation<SNode, SNode>>
as return type. In a lot of cases you can just use

    List<SRelation<?,?>> 
if you are not interested in the specific type of the source and target nodes.