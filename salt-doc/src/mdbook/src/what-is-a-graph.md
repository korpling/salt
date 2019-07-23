# What is a graph?

Since Salt is a totally graph based model, it is important to have a
basic understanding of what a graph is.

A graph is a very simple, but not a linguistic structure. So we need to
abstract over linguistic data to press them into such a structure. To
give a simple explanation of what a graph is, let us forget linguistics
for a moment and think about humans and their relationships. Imagine a
set of humans for instance your family or friends. In a graph, each of
these humans will represent one node. The relationship, for instance
between exactly two humans then is defined as a relation. In other
words, a relation connects two nodes. Now the relations between humans
can be very different, so for instance the relation between a couple can
be described as a love relation, whereas the relation between an
employee and her/his boss could be described as a work relation. This
example shows us that the relations between nodes can be very different,
as well as human relations could be. To differentiate the types of
relations, they could be labeled. The same goes for the nodes: they also
could be labeled, for instance with the human\'s name it represents.
Returning to linguistics, this means, when we can model humans and their
relationships as a graph, we can also model linguistic artifacts as a
graph. For instance we can model texts, tokens etc. as nodes, linguistic
categorization as labels and relations between them as relations. In the
following, this will become clearer.

As we now have an informal understanding of what a graph is, we provide
a formal definition of what we consider a graph to be. To model Salt, we
enhanced the general directed graph structure, which is \\( G= (V, E) \\)
with:

-   \\( V \\) being a set of nodes and

-   \\( E \\) being a set of directed relations with \\( e= (v_1~ \in V, v_2 \in V) \in E \\).