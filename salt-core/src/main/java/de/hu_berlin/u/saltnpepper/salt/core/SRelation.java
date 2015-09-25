package de.hu_berlin.u.saltnpepper.salt.core;

import de.hu_berlin.u.saltnpepper.graph.Relation;

public interface SRelation<S extends SNode, T extends SNode> extends Relation<S, T>, SAnnotationContainer, SNamedElement, STypedElement, SPathElement {

}
