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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsFactory;

public interface SaltFactory extends SaltCommonFactory, SaltSemanticsFactory{
	/**
	 * The singleton instance of the SaltFactory. This factory creates all objects defined by the Salt model.
	 * @generated
	 */
	SaltFactory eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.impl.SaltFactoryImpl.init();
	
	/**
	 * The file ending for xml files to store a SALT model.
	 */
	public final String SALT_FILE_ENDING= "salt"; 
	
	/**
	 * The file ending for xml files to store a SALT model.
	 */
	public final String GRAF_FILE_ENDING= "graf"; 
	
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
	 * Loads a SaltProject from given uri and returns it as object structure.
	 * @return returns a saltProject, which is filled with data comming from corpus in uri 
	 */
	public SaltProject loadSaltProject(URI saltProjectPath);
}
