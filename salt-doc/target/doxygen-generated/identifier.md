### Identifiers in Salt

Each node, relation, graph and layer in Salt gets a unique identifier called _Identifier_. Such an identifier is organized like an URI. The inner structure of a URI is shown here:

~~~{}
[scheme:][//authority][path][?query][#fragment]
~~~
The scheme of these identifiers is 'salt', in the current version, the Salt ids also does not support an authority or a query. The path is organized following the tree structure of the corpus structure, starting with the name (_Name_ value) of the root corpus, via an unbound number of sub-corpora, and ends with the document. The identifier for each element is computed automatically by extending the identifier of its parent element. For instance the identifier of a sub corpus named 'corp2' is computed by extending the identifier of its parent corpus 'corp1'. For instance the identifier for a document named 'doc1', being contained in corpus 'corp2', which is contained in corpus 'corp1' (which is the root) would look like this:

~~~{}
salt:/corp1/corp2/doc1
~~~

The same mechanism of creating identifiers of the corpus structure is used for elements of the document structure. But the name of these elements is given in the fragment part. Since the content of the document structure is not necessarily a tree-like structure, it is not possible to have a unique path from an element to its root. For instance a token named 'tok1' added to the document having the identifier 'salt/corp1/corp2/doc1' receives the identifier:

~~~{}
salt:/corp1/corp2/doc1#tok1
~~~

The same holds for relations. These URIs or _Identifier_s can be used to identify and search for elements in the corresponding graphs. You can access the id by calling:

~~~{.java}
tok1.getIdentifier();
~~~

or its String representation by 

~~~{.java}
tok1.getId();
~~~

