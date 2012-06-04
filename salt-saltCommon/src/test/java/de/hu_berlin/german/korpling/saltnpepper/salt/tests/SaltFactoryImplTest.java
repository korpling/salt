/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.tests;

import java.io.File;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import junit.framework.TestCase;

public class SaltFactoryImplTest extends TestCase 
{
	public static final String FILE_RESOURCE_DIR_GENERAL= "./src/test/resources/";
	public static final String FILE_RESOURCE_DIR= "./src/test/resources/SaltFactory/";
	private SaltFactory fixture= null;

	public void setFixture(SaltFactory fixture) {
		this.fixture = fixture;
	}

	public SaltFactory getFixture() {
		return fixture;
	}
	
	@Override
	public void setUp()
	{
		this.setFixture(SaltFactory.eINSTANCE);
	}
	
	public void testLoadSaltProject()
	{
		
	}
	
	/**
	 * Tests the loading of a {@link SCorpusGraph} in a SaltXML file containing a {@link SaltProject} object.
	 * This method tests: 
	 * <ol>
	 * <li>the loading of a graph in a SaltProject file containing no {@link SCorpusGraph} object</li>
	 * <li>the loading of a graph in a SaltProject file containing exactly one {@link SCorpusGraph} object</li>
	 * <li>the loading of a graph in a SaltProject file containing more than one {@link SCorpusGraph} objects</li>
	 * </ol> 
	*/
	public void testLoadSCorpusGraph__URI() 
	{
		SCorpusGraph sCorpusGraph= null;
		
		//case1
		File testFile= new File(FILE_RESOURCE_DIR+ "case2/"+ SaltFactory.FILE_SALT_PROJECT);
		assertTrue("Cannot run test, because file does not exist '"+testFile.getAbsolutePath()+"'.", testFile.exists());
		try {
			this.getFixture().loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()));
			fail("Shall throw an exception");
		} catch (Exception e) 
		{		}
		
		//case2
		testFile= new File(FILE_RESOURCE_DIR+ "case3/"+ SaltFactory.FILE_SALT_PROJECT);
		assertTrue("Cannot run test, because file does not exist '"+testFile.getAbsolutePath()+"'.", testFile.exists());
		sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()));
		assertEquals("mySCorpusGraph1", sCorpusGraph.getSName());
		
		//case3
		testFile= new File(FILE_RESOURCE_DIR+ "case4/"+ SaltFactory.FILE_SALT_PROJECT);
		assertTrue("Cannot run test, because file does not exist '"+testFile.getAbsolutePath()+"'.", testFile.exists());
		sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()));
		assertEquals("mySCorpusGraph1", sCorpusGraph.getSName());
	}

	/**
	 * Tests the loading of a {@link SCorpusGraph} in a SaltXML file containing a {@link SaltProject} object,
	 * containing three {@link SCorpusGraph} objects.
	 */
	public void testLoadSCorpusGraph__URI_Integer() {
		SCorpusGraph sCorpusGraph= null;
		
		File testFile= new File(FILE_RESOURCE_DIR+ "case4/"+ SaltFactory.FILE_SALT_PROJECT);
		assertTrue("Cannot run test, because file does not exist '"+testFile.getAbsolutePath()+"'.", testFile.exists());
		
		sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()), 0);
		assertEquals("mySCorpusGraph1", sCorpusGraph.getSName());
		
		sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()), 1);
		assertEquals("mySCorpusGraph2", sCorpusGraph.getSName());
		
		sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()), 2);
		assertEquals("mySCorpusGraph3", sCorpusGraph.getSName());
	}
	
}
