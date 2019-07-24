# Corpus-structure

A corpus-structure structures an entire corpus into smaller logical
units. Such units are a corpus, a subcorpus and a document. Often the
structuring goes along with the logical structure of the real data.
Imagine your corpus represents a collection of writings of an author,
then you may have one subcorpus per writing, which itself contains
subcorpora representing the chapters or articles, which again might be
divided into paragraphs etc. Dividing data has two main benefits, a
logical and a practical. From a logical point of view, the
corpus-structure keeps the hierarchical relation of units as given in
the real world item. And from a practical point of view, it keeps things
simple. For instance several human annotators can work on several units
in parallel. Furthermore this will also speed up automatic processing,
since data fits easier into main memory and indexes on them can be kept
small.

As a quick reference, the [appendix](../appendix.md#corpus-structure) gives a short
description and an overview of the inheritance hierarchy of the elements
being part of the corpus-structure.

## Corpus

As mentioned above, a corpus is an element to organize your data.
Similar to a folder in a filesystem, it groups the underlying parts
(files and other folders). Abstractly spoken, a corpus is a
selfcontaining structure which contains documents or further corpora.
When a corpus contains another corpus, we call the container corpus the
super corpus and the contained corpus the sub corpus. A corpus which is
not contained by another corpus is called a root corpus. Each corpus can
contain an unbound number of corpora. With this mechanism we now can
represent a hierarchy as mentioned above. A corpus representing a
collection of writings can contain further corpora, each representing a
book. A book corpus itself can contain corpora representing a chapter,
and so on. In Salt, a corpus is represented by the `SCorpus` element.
Two `SCorpus` objects can be set into a \"super corpus sub
corpus\"-relation by connecting them with a `SCorpusRelation` object.

## Document

A document is a logical partition which represents the end point of the
corpus-structure hierarchy. Partitioning data means that no relations
between data of two partitions are allowed. More concretely spoken, a
document normally contains a single text and all annotations
corresponding to it, but no interlinks between texts of different
documents or their annotations. A text can be a paragraph, a chapter, an
article or even an entire book. But a text can also be understood as the
logical interpretation of it and be realized in several languages
(called parallel text), or in case of historical texts in several
normalized or diplomatic surrogates. These texts are often interlinked
between same tokens (here \'same\' means the same meaning, for instance
in different languages). In that case all surrogates of a text **HAVE
TO** belong to the same partition (document). Next to a logical
partitioning, creating such documents has a high influence on processing
speed and main memory. Therefore we highly recommend to keep documents
as small as possible (as long as allowed by the linguistic logic
behind). A document in Salt is represented by the type `SDocument` and
can be grouped to a corpus or subcorpus by attaching it to a `SCorpus`.
To mark a `SDocument` as being part of a `SCorpus`, just connect them
via a `SDocumentCorpusRelation`.

## Corpus graph

Since Salt is graph based over and over, the corpus-structure is
represented as a graph, called the `SCorpusGraph`. This graph realizes a
directed tree structure, whose nodes are corpora (`SCorpus`) and
documents (`SDocument`) as shown in the following figure.

![Elements being part of the corpus-structure (class
diagram)](../../images/model_corpusGraph.png)

For those who prefer samples over
UML diagrams, the following figure shows a
corpus-structure containing three `SCorpus` objects *superCorpus*,
*subCorpus1* and *subCorpus2* and four `SDocument` objects *doc1*,
*doc2*, *doc3* and *doc4*. Two objects of type `SCorpusRelation` connect
the *superCorpus* with *subCorpus1* and *subCorpus2*. Four objects of
type `SDocumentCorpusRelation` connect the sub corpus subCorpus1 with
documents *doc1* and *doc2* and sub corpus *subCorpus2* with documents
*doc3* and *doc4*.


![corpus-structure sample (simplified object diagram)](../../images/sample_corpusStructure.png)

## Meta annotations

Meta annotations are very useful for corpora to document, for instance,
the creation process or the aim of the corpus. These information are
supposed to give a person working with this corpus additional
non-linguistic information. For instance which tools have been used,
which persons have annotated the corpus, when was the corpus annotated
and so on. Let\'s give an example: A meta annotation describing the date
of the origin would have the `name`=\"date\" and the `value`=\"1487\"
and an empty `namespace` can be added to a `SCorpus`. Salt is an open
model, which means, there are no limitations on naming a meta
annotation. Further, Salt does not interpret them, therefore the meta
annotation for determining the author can also be named \'*creator*\' or
something else instead of \'*author*\'.

The most convenient way to use meta annotations is to add a meta
annotation to a document or a corpus node. But since a meta annotation
is just a label of a specific type, you are free to add it to each node
or relation in the Salt model.