package org.corpus_tools.salt.graph.impl;

import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;

public class GraphImpl extends AbstractGraphImpl<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>>
{

  @Override
  protected Relation<Node, Node> cast(Relation<? extends Node, ? extends Node> relation)
  {
    // This is always safe since we now that the non-generic part is always an instance of "Relation"
    // and the generic part is also compatible.
    @SuppressWarnings("unchecked")
    Relation<Node, Node> retVal = (Relation<Node, Node>) relation;
    return retVal;
  }

}
