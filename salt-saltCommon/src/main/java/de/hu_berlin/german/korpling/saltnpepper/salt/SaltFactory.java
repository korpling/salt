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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.impl.SaltFactoryImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

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
	public static final String FILE_ENDING_SALT= "salt"; 
	
	/**
	 * The file ending to store a dot model.
	 */
	public static final String FILE_ENDING_DOT= "dot";
	
	/**
	 * The file ending for xml files to store a SALT model.
	 */
	public static final String FILE_ENDING_GRAF= "graf"; 
	
	/**
	 * Default name of the saltProject file.
	 */
	public static final String FILE_SALT_PROJECT= "saltProject"+"."+FILE_ENDING_SALT; 
	
	/**
	 * Namespace of e.g. {@link SFeature} objects used by salt. 
	 */
	public static final String NAMESPACE_SALT= "salt";
	/**
	 * URI scheme for Salt.
	 */
	public final static String URI_SALT_SCHEMA="salt:";
	
	/**
	 * Returns a qualified name for the passed namespace and name.
	 * This is computed as follows:<br>
	 * namespace + {@value Label#NS_SEPERATOR} + name
	 * @param namespace namespace part of the qualified name
	 * @param name name part of the qualified name
	 */
	public String createQName(String namespace, String name);
	
	/** Name of created {@link SProcessingAnnotation} for global id for {@link SDocument} **/
	public final static String PA_GLOBALID_NAME="globalID";
	/**
	 * Returns a global ID for the passed {@link SDocument} object, in case it is set.
	 * Null otherwise.
	 * <br/>
	 * The global id is retrieved via a {@link SProcessingAnnotation} having the namespace
	 * {@link #PA_GLOBALID_NS} and the name {@link #PA_GLOBALID_NAME}. This {@link SProcessingAnnotation}
	 * for instance is set in method {@link #createGlobalId(SElementId)}.
	 * @param sDOcument Object to retrieve global id.
	 * @return String value for global id, if one is given.
	 */
	public String getGlobalId(SElementId sDocumentId);
	
	/**
	 * Creates a global id for the passed {@link SElementId}. The {@link SElementId} must 
	 * correspond to a {@link SDocument}. 
	 * @param sDocumentId {@link SElementId} corresponding to a {@link SDocument}
	 * @return a global identifier which is unique in entire salt project
	 */
	public String createGlobalId(SElementId sDocumentId);
	
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
	public EObject load(URI objectURI);
	
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
	 * @param idxOfSCorpusGraph index of graph to be load, note that the list of graphs starts with 0
	 */
	public SCorpusGraph loadSCorpusGraph(URI sCorpusGraphUri, Integer idxOfSCorpusGraph);
	
	/**
	 * Persists the given {@link SDocumentGraph} object as SaltXML file at the 
	 * location given by the passed {@link URI} object. 
	 * The {@link URI} of where the {@link SDocumentGraph} is stored as {@link SFeature} by calling 
	 * {@link SDocument#setSDocumentGraphLocation(URI)}, in case of the given {@link SDocumentGraph} is contained
	 * by an {@link SDocument} object. 
	 * @param sDocumentGraph {@link SDocumentGraph} object to persist
	 * @param sDocumentGraphLocation location of where to persist object as {@link URI}
	 */
	public void saveSDocumentGraph(SDocumentGraph sDocumentGraph, URI sDocumentGraphLocation);

	/**
	 * Loads a {@link SDocumentGraph} object and returns it. The location of where to find the SaltXML containing 
	 * the {@link SDocumentGraph} object is given by the passed {@link URI} object.
	 * @param sDocumentGraphLocation location of SaltXML to load {@link SDocumentGraph} object.
	 */
	public SDocumentGraph loadSDocumentGraph(URI sDocumentGraphLocation);
	
	/**
	 * moves the content of <code>source</code> to <code>target</code>. 
	 * Caution: Object contained in <code>source</code> will be moved, which from <code>target</code>
	 * to <code>source</code>, which will mean, that object are not content of <code>source</code>
	 * any more after using {@link #move(SCorpusGraph, SCorpusGraph)}.   
	 * @param source {@link SCorpusGraph} delivering the content to move
	 * @param target {@link SCorpusGraph} object to where the content will be moved
	 */
	public void move(SCorpusGraph source, SCorpusGraph target);
}
