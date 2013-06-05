package de.hu_berlin.german.korpling.saltnpepper.salt.tests;

import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import junit.framework.TestCase;

public class GetSTokensTest extends TestCase {

	private SDocumentGraph fixture= null;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.setFixture(SaltFactory.eINSTANCE.createSDocumentGraph());
		long timeStamp= System.currentTimeMillis();
		SToken tok= null;
		for (int i=0; i< 30000; i++)
		{
			tok= SaltFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(tok);
		}
		timeStamp= System.currentTimeMillis() -timeStamp;
		System.out.println("creation time: "+ timeStamp+" ms");
	}
	
	public SDocumentGraph getFixture() {
		return fixture;
	}


	public void setFixture(SDocumentGraph fixture) {
		this.fixture = fixture;
	}
	
	public void testSGetSTokensPerformance()
	{
		EList<SToken> tokens= null;
		long timeStamp= System.currentTimeMillis();
		for (int i= 0; i<1000; i++)
		{
			tokens= this.getFixture().getSTokens();
		}
		
		timeStamp= System.currentTimeMillis() -timeStamp;
		System.out.println("access time: "+ timeStamp+" ms");
	}

}
