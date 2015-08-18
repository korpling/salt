/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.u.saltnpepper.salt.util;

import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextOverlappingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimeOverlappingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;

public enum SALT_TYPE {
	//
	STEXTUAL_DS("STEXTUAL_DS", STextualDS.class),
	//
	SSEQUENTIAL_DS("SSEQUENTIAL_DS", SSequentialDS.class),
	//
	SMEDIAL_DS("SMEDIAL_DS", SMedialDS.class),
	//
	STOKEN("STOKEN", SToken.class),
	//
	SSPAN("SSPAN", SSpan.class),
	//
	SSTRUCTURE("SSTRUCTURE", SStructure.class),
	//
	STEXTUAL_RELATION("STEXTUAL_RELATION", STextualRelation.class),
	//
	SMEDIAL_RELATION("SMEDIAL_RELATION", SMedialRelation.class),
	//
	SSPANNING_RELATION("SSPANNING_RELATION", SSpanningRelation.class),
	//
	SDOMINANCE_RELATION("SDOMINANCE_RELATION", SDominanceRelation.class),
	//
	SPOINTING_RELATION("SPOINTING_RELATION", SPointingRelation.class),
	//
	STEXT_OVERLAPPING_RELATION("STEXT_OVERLAPPING_RELATION", STextOverlappingRelation.class),
	//
	STIME_OVERLAPPING_RELATION("STIME_OVERLAPPING_RELATION", STimeOverlappingRelation.class),
	//
	SSEQUENTIAL_RELATION("SSEQUENTIAL_RELATION", SSequentialRelation.class),
	//
	SORDER_RELATION("SORDER_RELATION", SOrderRelation.class),
	//
	SDOCUMENT("SDOCUMENT", SDocument.class),
	//
	SCORPUS("SCORPUS", SCorpus.class);

	/** Name of the Salt type **/
	private String name = null;

	/**
	 * @return the name of the Salt type
	 */
	public String getName() {
		return name;
	}

	/** Java class which represents this Salt type **/
	private Class<?> javaType = null;

	/**
	 * @return the java class which represents this Salt type
	 */
	public Class<?> getJavaType() {
		return javaType;
	}

	private SALT_TYPE(String name, Class<?> javaType) {
		this.name = name;
		this.javaType = javaType;
	}
} // STYPE_NAME
