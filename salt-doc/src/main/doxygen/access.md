Access a Salt model {#access}
======

After we have shown how to create a Salt model, we now show some methods to access its data.
If you start reading from here, and did not already have a Salt model, you can use the class SampleGenerator, to generate predefined sample models.

~~~{.java}
SDocument sampleDocument = SaltFactory.createSDocument();
SampleGenerator.createSDocumentStructure(sampleDocument);
SDocumentGraph docGraph = sampleDocument.getDocumentGraph();
~~~

The following snippet exemplifies accessing a Salt model. If you copy the following lines and run the code you won't see anything. There are no outputs in the code below.

~~~{.java}
//access all primary text nodes (getting a list)
docGraph.getTextualDSs();
//access the primary text of the first primary text node
docGraph.getTextualDSs().get(0).getText();
	
//access all token nodes (getting a list)
docGraph.getTokens();
//access the primary text, which is overlapped by the first token (note: changing the returned text has no effects)
docGraph.getText(docGraph.getTokens().get(0));
//access all annotations of the first token
docGraph.getTokens().get(0).getAnnotations();
		
//access the relations between all tokens and their primary text nodes
docGraph.getTextualRelations();
//access the interval determining the overlapped text of the first relation (which probably is related to the first token)
docGraph.getTextualRelations().get(0).getStart();
docGraph.getTextualRelations().get(0).getEnd();
		
//access all span nodes  (getting a list)
docGraph.getSpans();
//access the primary text, which is overlapped by the first span (note: changing the returned text has no effects)
docGraph.getText(docGraph.getSpans().get(0));
//access all relations between all spans and their tokens 
docGraph.getSpanningRelations();
		
//access all hierarchical nodes (structures)
docGraph.getStructures();
//access the primary text, which is overlapped by the first structure (note: changing the returned text has no effects)
docGraph.getText(docGraph.getStructures().get(0));
//access all dominance relations (relations between all structures and their other nodes)
docGraph.getDominanceRelations();
//access all annotations of the first dominance relation
docGraph.getDominanceRelations().get(0).getAnnotations();
		
//access all pointing relations 
docGraph.getPointingRelations();
//access all annotations of the first pointing relation
docGraph.getDominanceRelations().get(0).getAnnotations();
		
//access all roots of the document graph
docGraph.getRoots();
		
//access all nodes and relations contained in the document graph
docGraph.getNodes();
docGraph.getRelations();
		
//access all outgoing relations of a node (the first structure node)
List<SRelation<SNode, SNode>> out= docGraph.getOutRelations(docGraph.getStructures().get(0).getId());
//access all incoming relations of a node (the first structure node)
List<SRelation<SNode, SNode>> in= docGraph.getInRelations(docGraph.getStructures().get(0).getId());
~~~

Another and very powerful mechanism to access a Salt model is the traversal of a Salt graph. Traversing in Salt means, that along a traversing order each node and relation in the Salt graph is visited. Via a callback the traversal give you the chance to react on the current node and relation. For more information, please read the article @ref traverse.  