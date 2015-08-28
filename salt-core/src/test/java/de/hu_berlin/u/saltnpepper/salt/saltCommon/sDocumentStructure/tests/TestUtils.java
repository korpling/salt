package de.hu_berlin.u.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltWrongParameterException;

public class TestUtils {

	/** Tests whether returned graph is of type {@link SDocumentGraph}. **/
	public static void testSetGetGraph(SNode fixture){
		try{
			fixture.setGraph(SaltFactory.createSCorpusGraph());
			fail();
		}catch (SaltWrongParameterException e){}
		fixture.setGraph(SaltFactory.createSDocumentGraph());
		assertTrue(fixture.getGraph() instanceof SDocumentGraph);
	}
	/** Tests whether returned graph is of type {@link SDocumentGraph}. **/
	public static void testSetGetGraph(SRelation<? extends SNode,? extends SNode> fixture){
		try{
			fixture.setGraph(SaltFactory.createSCorpusGraph());
			fail();
		}catch (SaltWrongParameterException e){}
		fixture.setGraph(SaltFactory.createSDocumentGraph());
		assertTrue(fixture.getGraph() instanceof SDocumentGraph);
	}
}
