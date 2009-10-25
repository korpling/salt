package de.hub.corpling.salt.saltCommon.modules.tests;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.modules.SDocumentStructureModule;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import junit.framework.TestCase;

public class SDocumentStructureModuleTest extends TestCase 
{
	private SDocumentStructureModule fixture= null;

	public void setFixture(SDocumentStructureModule fixture) {
		this.fixture = fixture;
	}

	public SDocumentStructureModule getFixture() {
		return fixture;
	} 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception 
	{
		setFixture(new SDocumentStructureModule());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	/**
	 */
	public void testGetGraph() 
	{
		SDocumentGraph sDocGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sDocGraph);
		assertEquals(sDocGraph, this.getFixture().getSDocumentGraph());
	}
}
