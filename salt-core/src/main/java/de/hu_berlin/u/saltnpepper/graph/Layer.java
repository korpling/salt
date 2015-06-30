package de.hu_berlin.u.saltnpepper.graph;

/**
 * A layer is a grouping mechanism for nodes and edges, and can also contain
 * further layers (called sub layers). The containment relation implements a
 * recursive structure for layers, to build hierarchies. In general this
 * mechanism enables the creation of sub graphs. But note that a layer cannot be
 * contained by itself, so cycles of layers are not possible.
 * 
 * @author florian
 *
 */
public interface Layer {

}
