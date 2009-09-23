/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.SaltProject;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Salt Project</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SaltProjectTest extends TestCase {

	/**
	 * The fixture for this Salt Project test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltProject fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SaltProjectTest.class);
	}

	/**
	 * Constructs a new Salt Project test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltProjectTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Salt Project test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SaltProject fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Salt Project test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltProject getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SaltCommonFactory.eINSTANCE.createSaltProject());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	public void testSCorpusGraphs()
	{
		EList<SCorpusGraph> corpGraphs= new BasicEList<SCorpusGraph>();
		for (int i= 0; i < 10; i++)
		{
			SCorpusGraph corpGraph= SaltCommonFactory.eINSTANCE.createSCorpusGraph();
			corpGraphs.add(corpGraph);
			this.getFixture().getSCorpusGraphs().add(corpGraph);
		}
		
		assertTrue(corpGraphs.containsAll(this.getFixture().getSCorpusGraphs()));
		assertTrue(this.getFixture().getSCorpusGraphs().containsAll(corpGraphs));
	}
} //SaltProjectTest
