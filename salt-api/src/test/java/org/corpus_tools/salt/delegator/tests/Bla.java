package org.corpus_tools.salt.delegator.tests;

import static org.junit.Assert.*;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SToken;
import org.junit.Before;
import org.junit.Test;

public class Bla {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);
		
		SDocumentGraph graph= SaltFactory.createSDocumentGraph();
		SToken tok1= SaltFactory.createSToken();
		
		
		System.out.println("-----------------------------------> add");
		graph.addNode(tok1);
		System.out.println("-----------------------------------> get graph");
		System.out.println(tok1.getGraph());
	}

}
