Comparing Salt models {#isomorphie}
====

The comparison of models is a main feature in Salt. 
- allows you to compare two models and check whether they are identical or not
- further it generates a diff between models, to check where are the differences
- since Salt is a graph model, comparison is reducable to an isomorphie check, that means to check all nodes, relations and layers and the labels above them

- compare to document structures, 
~~~{.java}
SDocument doc1 = createSampleGraph();
SDocument doc2 = createSampleGraph();
SampleGenerator.createDocumentStructure(doc1);
SampleGenerator.createDocumentStructure(doc2);

doc1.getDocumentGraph().isIsomorph(other);
~~~
- the method doc1.getDocumentGraph().isIsomorph(doc1); returns true, if and only if the entire document structure of doc1 is equal to doc2
- in this case the returned value is true

- to check where are the differences in two models use findDiffs
~~~{.java}
SDocument doc1 = createSampleGraph();
SDocument doc2 = createSampleGraph();
SampleGenerator.createPrimaryData(doc1);
SampleGenerator.createTokens(doc2);

doc1.getDocumentGraph().isIsomorph(other);
~~~

- sometimes models are not only equal when everything is equal, sometimes specific elements do not need to be equal
- for instance the ids of elements in Salt are arbritrary, which means two models can be equal along their primary data, their tokenization and along their annoattions but have different ids
- in that case the difference and isomorphie mechanism of Salt allows to exclude specific elements from the comparison
- see the exclude options
- sample how t use options
		
		
public static final String OPTION_IGNORE_FEATURES = "ignoreFeatures";
	/**
	 * When true, differences in {@link SAnnotation} have no influence on
	 * isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_ANNOTATIONS = "ignoreAnnotations";
	/**
	 * When true, differences in {@link SMetaAnnotation} have no influence on
	 * isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_META_ANNOTATIONS = "ignoreMetaAnnotstaions";
	/**
	 * When true, differences in {@link SProcessingAnnotation} have no influence
	 * on isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_PROCESSING_ANNOTATIONS = "ignoreProcessingAnnotations";
	/**
	 * When true, differences in id have no influence on isomorphie and will not
	 * produce any differences.
	 */
	public static final String OPTION_IGNORE_ID = "ignoreId";
	/**
	 * When true, differences in name have no influence on isomorphie and will
	 * not produce any differences.
	 */
	public static final String OPTION_IGNORE_NAME = "ignoreName";
	/**
	 * When true, layers will not be checked when computing isomorphie and
	 * differences.
	 */
	public static final String OPTION_IGNORE_LAYER = "ignoreLayer";