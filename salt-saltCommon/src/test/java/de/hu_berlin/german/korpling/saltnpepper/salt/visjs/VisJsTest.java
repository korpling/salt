package de.hu_berlin.german.korpling.saltnpepper.salt.visjs;

import org.junit.Test;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

public class VisJsTest implements SGraphTraverseHandler{

	//@Test
	public void test(){
		SDocument doc= SaltFactory.eINSTANCE.createSDocument();
		SampleGenerator.createSDocumentStructure(doc);
		
		System.out.println("All texts:\t\t"+ doc.getSDocumentGraph().getSTextualDSs());
		System.out.println("getting the primary text:\t\t"+ doc.getSDocumentGraph().getSTextualDSs().get(0).getSText());
		
		System.out.println("All tokens:\t\t"+ doc.getSDocumentGraph().getSTokens());
		System.out.println("getting the overlapped text for a token:\t\t"+ doc.getSDocumentGraph().getSText(doc.getSDocumentGraph().getSTokens().get(0)));
		System.out.println("getting annotations of a token: \t\t"+doc.getSDocumentGraph().getSTokens().get(0).getSAnnotations());
		
		System.out.println("All spans: "+ doc.getSDocumentGraph().getSSpans());
		System.out.println("getting the overlapped text for a span:\t\t"+ doc.getSDocumentGraph().getSText(doc.getSDocumentGraph().getSSpans().get(0)));
		
		System.out.println("All structures: "+ doc.getSDocumentGraph().getSStructures());
		System.out.println("getting the overlapped text for a structure:\t\t"+ doc.getSDocumentGraph().getSText(doc.getSDocumentGraph().getSStructures().get(0)));
		
		System.out.println("All relations between tokens and text: "+ doc.getSDocumentGraph().getSTextualRelations());
		System.out.println("Getting the textual interval of a textual relation: ["+ doc.getSDocumentGraph().getSTextualRelations().get(0).getSStart()+", "+doc.getSDocumentGraph().getSTextualRelations().get(0).getSEnd());
		System.out.println("All relations between spans and tokens: "+ doc.getSDocumentGraph().getSSpanningRelations());
		System.out.println("All dominance relations: "+ doc.getSDocumentGraph().getSDominanceRelations());
		System.out.println("All pointing relations: "+ doc.getSDocumentGraph().getSPointingRelations());
		
		System.out.println("getting all root nodes: "+ doc.getSDocumentGraph().getSRoots());
		
		//traversing the graph in depth first top down mode beginning with its roots
		doc.getSDocumentGraph().traverse(doc.getSDocumentGraph().getSRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "td", this);
		
		//traversing the graph form the tokens to the top
		doc.getSDocumentGraph().traverse(doc.getSDocumentGraph().getSTokens(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST, "bu", this, false);
		
	}

	@Override
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation sRelation,
			SNode fromNode, long order) {
		if (sRelation!= null){
			System.out.println(sRelation+"-->"+currNode);
		}
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation edge,
			SNode fromNode, long order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation edge,
			SNode currNode, long order) {
		// TODO Auto-generated method stub
		return true;
	}

}
