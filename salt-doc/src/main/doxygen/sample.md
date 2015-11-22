Generating sample models {#sample}
====

With Salt's [SampleGenerator](@ref org.corpus_tools.salt.samples.SampleGenerator) we provide a mechanism to easily create a simple sample in Salt. Next to other use cases, this could be very useful for instance to create tests for Pepper modules.
Before we dig into the detail, we want to start with a short sample:

~~~{.java}
// create the primary text
SampleGenerator.createPrimaryData(document);
// create tokenization
SampleGenerator.createTokens(document);
// create token Annotations
SampleGenerator.createMorphologyAnnotations(document);
// create spans
SampleGenerator.createInformationStructureSpan(document);
// create span annotations
SampleGenerator.createInformationStructureAnnotations(document);
// create Structures
SampleGenerator.createSyntaxStructure(document);
// create Structure annotations
SampleGenerator.createSyntaxAnnotations(document);
// create pointing relations
SampleGenerator.createAnaphoricAnnotations(document);
~~~

In this snippet we generate a sample document structure step by step. Our sample model has a single primary text "Is this sample more complicated than it appears to be?". The text is tokenized and annotated with part-of-speech and lemma annotations. Further the tokens are grouped into spans and annotated with information structure, before a constituent tree is created. Last but not least a simple anaphoric reference is created to relate "this sample" and "it".

We started with this sample to demonstrate that step can be done separately. In case you need all of the named annotations, you can also generate it at once with the following snippet:
~~~{.java}
SampleGenerator.createDocumentStructure(SaltFactory.createSDocument());
~~~

Additionally to the described sample document structure, with the SampleGenerator you can generate much more sample data like dialogue data, dependency annotations and more. To get a closer look of what is possible with the sample Generator, at this stage to point to it's [java documentation](@ref org.corpus_tools.salt.samples.SampleGenerator). 

You can also generate a corpus structure having 1 root corpus and two sub corpora with 2 documents each:
~~~ 
          rootCorpus
         /         \
   subCorpus1     subCorpus2
   /      \       /       \
doc1   doc2     doc3     doc4
~~~

To create a corpus structure, you can use one of the following methods depending on the return type you need:

* (@ref org.corpus_tools.salt.samples.SampleGenerator#createCorpusStructure(SaltProject))
* (@ref org.corpus_tools.salt.samples.SampleGenerator#createSaltProject())
* (@ref org.corpus_tools.salt.samples.SampleGenerator#createCorpusStructure())
* (@ref org.corpus_tools.salt.samples.SampleGenerator#createCorpusStructure(SCorpusGraph))
* (@ref org.corpus_tools.salt.samples.SampleGenerator#createCorpusStructure_simple())

