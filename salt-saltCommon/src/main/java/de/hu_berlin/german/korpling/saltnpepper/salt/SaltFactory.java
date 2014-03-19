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

import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.omg.PortableInterceptor.ServerIdHelper;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.impl.SaltFactoryImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
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
	
	/** Separator between name and namespace**/
	public static final String NS_SEPERATOR= Label.NS_SEPERATOR;
	/**
	 * default SType string for SRelations which do not have a SType
	 */
	public static final String DEFAULT_STYPE= NAMESPACE_SALT+Label.NS_SEPERATOR+"NULL";
	
	/**
	 * default SType string for SOrderRelations which do not have a SType
	 */
	public static final String DEFAULT_STYPE_SORDERRELATION= "default_seg";
	
	/**
	 * Stores the passed {@link Econtent} to a dot file located by the passed
	 * {@link URI}.<br/>
	 * <strong>Note, that only a set of {@link Econtent} types is supported</strong>  
	 * @param content A SaltProject, SCorpusGraph or SDocumentGraph
	 * @param outputURI locating the place to store dot file
	 */
	public void save_DOT(EObject content, URI outputURI);
	/**
	 * Stores the passed {@link Econtent} to a dot file located by the passed
	 * {@link URI}.<br/>
	 * <strong>Note, that only a set of {@link Econtent} types is supported</strong>  
	 * @param content A SaltProject, SCorpusGraph or SDocumentGraph
	 * @param outputURI locating the place to store dot file
	 * @param options a map of options to customize the storing behavior
	 */
	public void save_DOT(EObject content, URI outputURI, Map<?,?> options);
	
	
	/**
	 * Returns a qualified name for the passed namespace and name.
	 * This is computed as follows:<br>
	 * namespace + {@value Label#NS_SEPERATOR} + name
	 * @param namespace namespace part of the qualified name
	 * @param name name part of the qualified name
	 */
	public String createQName(String namespace, String name);
	
	/**
	 * Returns a global ID for the passed object (either if {@link SElementId} belongs to {@link SDocument} or {@link SCorpus} object). A global id only can be returned, if the element is contained 
	 * in a {@link SCorpusGraph} object. If this is not the case, the {@link ServerIdHelper} is returned.
	 * @param sElementId Object to retrieve global id.
	 * @return String value for global id, if one is given.
	 */
	public String getGlobalId(SElementId sElementId);
	
	/**
	 * Moves all {@link SAnnotation} objects from <code>from</code> to <code>to</code>.
	 * @param from {@link SAnnotatableElement} object from which {@link SAnnotation} object should be moved
	 * @param to {@link SAnnotatableElement} object to which {@link SAnnotation} object should be moved
	 */
	public void moveSAnnotations(SAnnotatableElement from, SAnnotatableElement to);
	
	/**
	 * Moves all {@link SMetaAnnotation} objects from <code>from</code> to <code>to</code>.
	 * @param from {@link SMetaAnnotatableElement} object from which {@link SMetaAnnotation} object should be moved
	 * @param to {@link SMetaAnnotatableElement} object to which {@link SMetaAnnotation} object should be moved
	 */
	public void moveSMetaAnnotations(SMetaAnnotatableElement from, SMetaAnnotatableElement to);
	/**
	 * Converts the given class, if it is a class of the Salt model into its corresponding {@link STYPE_NAME}.
	 * @param class to convert
	 * @return {@link STYPE_NAME} of given class
	 */
	public HashSet<STYPE_NAME> convertClazzToSTypeName(Class<? extends EObject>... clazz); 
	
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
	 * @param numOfSCorpusGraph number of graph to be load, note that the list of graphs starts with 0
	 */
	public SCorpusGraph loadSCorpusGraph(URI sCorpusGraphUri, Integer numOfSCorpusGraph);
	
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
