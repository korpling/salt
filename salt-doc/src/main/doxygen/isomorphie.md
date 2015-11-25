Comparing Salt models {#isomorphie}
====

The comparison of models is a main feature in Salt. Often it is necessary to detect differences between two models, for instance when having a new version of your data, it might be interesting to see what has changed. Or for instance when implementing a Pepper module you might want to test what your module is doing and compare it with a gold model to find bugs. 
 For those use cases Salt provides a mechanism to either check whether two models are identical or not or to find differences between the models. Since Salt is a graph-based model, comparison is reducible to an isomorphism check. An isomorphism means, that for each node in one graph a node in the other graph exists having the same properties. The same goes for relations and layers. Two labels (annotations, meta annotations etc.) are isomorph, if their namespace, name and value are identical.  
The following snippet shows the comparison of two document structures: 
 
~~~{.java}
SDocument doc1 = createSampleGraph();
SDocument doc2 = createSampleGraph();
SampleGenerator.createDocumentStructure(doc1);
SampleGenerator.createDocumentStructure(doc2);

doc1.getDocumentGraph().isIsomorph(other);
~~~

The method *doc1.getDocumentGraph().isIsomorph(doc1);* returns true, if and only if the entire document structure of *doc1* is equal to *doc2*. Which in this case is *true*.

But in case the return value is not true, in many use cases, it is not enough only to know whether two graphs are isomorph. Furthermore it is important to know where are exactly the differences. Therefore Salt provides the method @ref org.corpus_tools.salt.common.SDocumentGraph#findDiffs(SDocumentGraph other) which returns a list of all differences between the two graphs. The use of the method is analog to the method @ref org.corpus_tools.salt.common.SDocumentGraph#isIsomorph(SDocumentGraph other).
 
~~~{.java}
SDocument doc1 = createSampleGraph();
SDocument doc2 = createSampleGraph();
SampleGenerator.createPrimaryData(doc1);
SampleGenerator.createTokens(doc2);

doc1.getDocumentGraph().isIsomorph(other);
~~~

Identical but,...
====

Sometimes it is not necessary to have absolutely identical graphs. Sometimes you are only interested in having an identical structure, but not identical annotation values, or you are not interested in meta annotations or in identical identifiers. 
For those use cases both methods @ref org.corpus_tools.salt.common.SDocumentGraph#findDiffs(SDocumentGraph other) and @ref org.corpus_tools.salt.common.SDocumentGraph#isIsomorph(SDocumentGraph other) offers you the possibility to pass a list of options defining one or more exceptions. For instance the following snippet shows how to compare two graphs except comparing the ids of nodes, relations and layers:

~~~{.java}
SDocument doc1 = createSampleGraph();
SDocument doc2 = createSampleGraph();
SampleGenerator.createPrimaryData(doc1);
SampleGenerator.createTokens(doc2);

doc1.getDocumentGraph().isIsomorph(doc2.getDocumentGraph(), (new DiffOptions()).setOption(DiffOptions.OPTION_IGNORE_ID, true));
~~~

The class [DiffOptions](@ref org.corpus_tools.salt.util.DiffOptions) defines a set of fields to switch on/off the comparison for specific properties. Passing an object of that type to the *findDiff* or *isIsomorph* will customize the comparison. For an easier implementation, the method @ref org.corpus_tools.salt.util.DiffOptions#setOption returns the option object itself. Thus enables the concatenation of multiple customizations.

~~~{.java}
new DiffOptions()).setOption(DiffOptions.OPTION_IGNORE_ID, true).setOption(DiffOptions.OPTION_IGNORE_FEATURES, true).setOption(DiffOptions.OPTION_IGNORE_LAYER, true)
~~~
		
For a full list of all possible options the the documentation of class [DiffOptions](@ref org.corpus_tools.salt.util.DiffOptions).