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
package org.corpus_tools.salt;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SMedialDS;
import org.corpus_tools.salt.common.SMedialRelation;
import org.corpus_tools.salt.common.SOrderRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSequentialDS;
import org.corpus_tools.salt.common.SSequentialRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextOverlappingRelation;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.STimeOverlappingRelation;
import org.corpus_tools.salt.common.STimelineRelation;
import org.corpus_tools.salt.common.SToken;

public enum SALT_TYPE {
	//
	STEXTUAL_DS(STextualDS.class),
	//
	SSEQUENTIAL_DS(SSequentialDS.class),
	//
	SMEDIAL_DS(SMedialDS.class),
	//
	STOKEN(SToken.class),
	//
	SSPAN(SSpan.class),
	//
	SSTRUCTURE(SStructure.class),
	//
	STEXTUAL_RELATION(STextualRelation.class),
	//
	STIMELINE_RELATION(STimelineRelation.class),
	//
	SMEDIAL_RELATION(SMedialRelation.class),
	//
	SSPANNING_RELATION(SSpanningRelation.class),
	//
	SDOMINANCE_RELATION(SDominanceRelation.class),
	//
	SPOINTING_RELATION(SPointingRelation.class),
	//
	STEXT_OVERLAPPING_RELATION(STextOverlappingRelation.class),
	//
	STIME_OVERLAPPING_RELATION(STimeOverlappingRelation.class),
	//
	SSEQUENTIAL_RELATION(SSequentialRelation.class),
	//
	SORDER_RELATION(SOrderRelation.class),
	//
	SDOCUMENT(SDocument.class),
	//
	SCORPUS(SCorpus.class);

	/** Java class which represents this Salt type **/
	private Class<?> javaType = null;

	/**
	 * @return the java class which represents this Salt type
	 */
	public Class<?> getJavaType() {
		return javaType;
	}

	private SALT_TYPE(Class<?> javaType) {
		this.javaType = javaType;
	}

	private static final ReadWriteLock lock = new ReentrantReadWriteLock();

	/**
	 * the map of {@link SALT_TYPE} and {@link Class}.
	 */
	private static Map<SALT_TYPE, Class<? extends Object>> sType2clazzMap = null;

	/**
	 * Returns map of {@link SALT_TYPE} and {@link Class}.
	 * 
	 * @return a map of {@link SALT_TYPE} and the corresponding class in Salt
	 */
	protected static Map<SALT_TYPE, Class<? extends Object>> getSType2clazz() {
		if (sType2clazzMap == null) {
			lock.writeLock().lock();
			if (sType2clazzMap == null) {
				sType2clazzMap = Collections.synchronizedMap(new HashMap<SALT_TYPE, Class<? extends Object>>());
				for (SALT_TYPE type : SALT_TYPE.values()) {
					sType2clazzMap.put(type, type.getJavaType());
				}
			}
			lock.writeLock().unlock();
		}
		return (sType2clazzMap);
	}

	/**
	 * Converts the given class, if it is a class of the Salt model into its
	 * corresponding {@link SALT_TYPE}.
	 * 
	 * @param classes
	 *            to convert
	 * @return {@link SALT_TYPE} of passed class
	 */
	@SafeVarargs
	public static Set<SALT_TYPE> class2SaltType(Class<? extends Object>... classes) {
		HashSet<SALT_TYPE> retVal = new HashSet<SALT_TYPE>();

		Set<SALT_TYPE> keys = getSType2clazz().keySet();
		for (SALT_TYPE sType : keys) {
			Class<? extends Object> clazz1 = getSType2clazz().get(sType);
			for (Class<? extends Object> clazz : classes) {
				if (clazz1.isAssignableFrom(clazz)) {
					retVal.add(sType);
				}
			}
		}
		return (retVal);
	}
}
