### Persist and Load {#persist}



Persisting a model is very easy: Only a nonempty [SaltProject](@ref org.corpus_tools.salt.common.SaltProject) object and a valid local URI are needed. The following snippet shows how to persist an entire model.

~~~{.java}
saltProject.saveSaltProject(URI);
~~~

Please note, that the URI used as parameter is **not** a URI of type _java.net.URI_ - it is of type _org.eclipse.emf.common.util.URI_.

To load a valid SaltXML document, create an empty _SaltProject_ object and call the load method as shown in the following snippet.

~~~{.java}
saltProject = SaltFactory.createSaltProject();
saltProject.loadSaltProject(URI);
~~~
Salt document structrues can get very large, and maintaining a bunch od them in main memory can get problematical. Therefore Salt contains a mechanism to persist single document structures.
The following snippet shows how to store a single document.
~~~{.java}
// storing
sampleDocument.saveDocumentGraph(URI);
// loading
sampleDocument.loadDocumentGraph(URI);
~~~