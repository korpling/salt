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
package de.hu_berlin.german.korpling.saltnpepper.salt;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hu_berlin.german.korpling.saltnpepper.salt.impl.SaltFactoryImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsFactory;

public interface SaltFactory extends SaltCommonFactory, SaltSemanticsFactory{
	/**
	 * The singleton instance of the SaltFactory class. This factory creates all objects defined by the Salt model.
	 * @generated
	 */
	SaltFactory eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.impl.SaltFactoryImpl.init();
	
	/**
	 * Returns a {@link ResourceSet} object, which is initialized with all {@link Resource} objects to load
	 * and store Salt object into the different available formats. 
	 */
	ResourceSet resourceSet= SaltFactoryImpl.getResourceSet();
	
	/**
	 * The file ending for xml files to store a SALT model.
	 */
	public final String FILE_ENDING_SALT= "salt"; 
	
	/**
	 * The file ending to store a dot model.
	 */
	public final String FILE_ENDING_DOT= "dot";
	
	/**
	 * The file ending for xml files to store a SALT model.
	 */
	public final String FILE_ENDING_GRAF= "graf"; 
	
	/**
	 * Default name of the saltProject file.
	 */
	public final String FILE_SALT_PROJECT= "saltProject"+"."+FILE_ENDING_SALT; 
	
	/**
	 * Converts the given class, if it is a class of the Salt model into its corresponding {@link STYPE_NAME}.
	 * @param class to convert
	 * @return {@link STYPE_NAME} of given class
	 */
	public STYPE_NAME convertClazzToSTypeName(Class<? extends EObject> clazz); 
	
	/**
	 * Converts the given {@link STYPE_NAME}, into the corresponding class.
	 * @param type to convert
	 * @return corresponding class
	 */
	public Class<? extends EObject> convertSTypeNameToClazz(STYPE_NAME sType);
	
	/**
	 * Loads an object coming from a SaltXML (.{@link SaltFactory#FILE_ENDING_SALT}) and returns it.
	 * @param objectURI {@link URI} to SaltXML file containing the object
	 * @return loaded object
	 */
	public Object load(URI objectURI);
	
	/**
	 * Loads a SaltProject from given uri and returns it as object structure.
	 * @return returns a saltProject, which is filled with data comming from corpus in uri 
	 */
	public SaltProject loadSaltProject(URI saltProjectPath);
	
	/**
	 * Loads the given SaltXML file (.{@value SaltFactory#FILE_ENDING_SALT}) into this object. If the 
	 * given SaltXML file does not contain a {@link SCorpusGraph} object persisting, an exception
	 * will be thrown. If the SaltXML file contains persistings for more than one {@link SCorpusGraph}
	 * object, the first one will be load (analog to {@link #load(URI, 0)}).
	 * @param sCorpusGraphUri the {@link URI} to locate the SaltXML file  
	 */
	public SCorpusGraph loadSCorpusGraph(URI sCorpusGraphURI);

	/**
	 * Loads the given SaltXML file (.{@value SaltFactory#FILE_ENDING_SALT}) into this object. If the 
	 * given SaltXML file does not contain a {@link SCorpusGraph} object persisting, an exception
	 * will be thrown. The parameter <code>numOfSCorpusGraph</code> determines which object shall
	 * be load, in case of the given SaltXML file contains more than one persisting of
	 * {@link SCorpusGraph} objects.
	 * @param sCorpusGraphUri the {@link URI} to locate the SaltXML file
	 * @param numOfSCorpusGraph number of graph to be load, note that the list of graphs starts with 0
	 */
	public SCorpusGraph loadSCorpusGraph(URI sCorpusGraphUri, Integer numOfSCorpusGraph);
}
