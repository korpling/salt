# Appendix

## Corpus-structure

**Corpus-structure (inheritance graph)**
![corpus-structure (inheritance graph)](images/inheritanceGraph_corpusStructure.png)

**Overview over all elements of corpus-structure**

| element                 | short description                                                                                      |
|-------------------------|--------------------------------------------------------------------------------------------------------|
| SCorpusGraph            | A graph representing the corpus-structure itself, see [Corpus graph](#sec_corpusGraph).                |
| *SNode*                 | An abstract node, from which all other nodes are derived from, see [What is Salt?](#sec_salt).         |
| SCorpus                 | A container for documents or other corpora, see [Corpus](#sec_corpus).                                 |
| SDocument               | A container for primary data and annotations, see [Document](#sec_document).                           |
| *SRelation*             | An abstract relation, from which all other relations are derived from, see [What is Salt?](#sec_salt). |
| SCorpusRelation         | Connects a super corpus with a sub corpus, see [Corpus-structure](#sec_corpusStructure).               |
| SCorpusDocumentRelation | Connects a corpus with a document, see [Corpus-structure](#sec_corpusStructure).                       |

## Document-structure

  --------------------------------------------------------------------------
  element                      short description
  ---------------------------- ---------------------------------------------
  SDocumentGraph               A graph representing the document-structure
                               itself, see [Corpus graph](#sec_corpusGraph).

  *SNode*                      An abstract node, from which all other nodes
                               are derived from, see [What is
                               Salt?](#sec_salt).

  *SSequentialDS*              An abstract node used to model sequential
                               datasources. Sequential here means, that you
                               can address an interval of the datasource by
                               determing a start and a end position.

  *SStructuredNode*            An abstract node which is used for technical
                               purposes, to constraint the kind of nodes
                               being target of for instance
                               SDominanceRelations, SPointingRelations.

  STextualDS                   A node representing primary texts, see
                               [Primary data](#sec_primData).

  SMedialDS                    A node representing audio data, see [Audio
                               data](#sec_audioData).

  STimeline                    A common timeline for all objects in the
                               document-structure, for instance to model
                               time in dialogue data. There could be only
                               one timeline object for one
                               document-structure. See [Time
                               management](#sec_time).

  SToken                       Smallest annotatable unit of primary data,
                               for instance a character, syllable, word
                               etc., see [Tokenization](#sec_tokenization).

  SSpan                        A node to model sets in a graph, to collect a
                               number of tokens and to annotate them at
                               once, see [Spans of tokens](#sec_spans).

  SStructure                   A node to model hierarchies, for instance for
                               syntax trees, see
                               [Hierarchies](#sec_hierarchies).

  *SRelation*                  An abstract relation, from which all other
                               relations are derived from, see [What is
                               Salt?](#sec_salt).

  *SSequentialRelation*        An abstract relation which provides to
                               address an interval (start and end value) in
                               a data source, see [Time
                               management](#sec_time).

  *STimeOverlappingRelation*   An abstract relation marking the implementing
                               relation to be a relation, giving the
                               overlapped time interval from its target to
                               its source (a kind of a contrary
                               inheritance).

  *STextOverlappingRelation*   An abstract relation marking the implementing
                               relation to be a relation, giving the
                               overlapped textual interval from its target
                               to its source (a kind of a contrary
                               inheritance).

  STimelineRelation            A relation to connect a token with the common
                               timeline, see [Time management](#sec_time).

  STextualRelation             A relation to connect a token with the a
                               primary text, see [Primary
                               data](#sec_primData).

  SMedialRelation              A relation to connect a token with the a
                               audio data object, see [Audio
                               data](#sec_audioData).

  SSpanningRelation            A relation used to create a set in a graph,
                               this is used to connect a token with a span
                               object, see [Spans of tokens](#sec_spans).

  SDominanceRelation           A relation to represent hierarchies, see
                               [Hierarchies](#sec_hierarchies).

  SPointingRelation            A loose relation to connect each kind of node
                               with another one, see [Loose
                               relation](#sec_pointingRelation).

  SOrderRelation               A relation to create an explicit order of
                               tokens, see [Ordering tokens](#sec_order).
  --------------------------------------------------------------------------

  : Overview over all elements of document-structure
