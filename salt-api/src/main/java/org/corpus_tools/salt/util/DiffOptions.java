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
package org.corpus_tools.salt.util;

import java.util.Hashtable;

import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SMetaAnnotation;
import org.corpus_tools.salt.core.SProcessingAnnotation;

/**
 * This class defines an option map to customize the isomorphie check of two
 * graphs. For instance you can suppress the check for ids of nodes, relations
 * etc. during the isomorphie comparison. To supress the id check set
 * {@link DiffOptions#OPTION_IGNORE_ID} to true: <code>
 * <pre>
 * put(OPTION_IGNORE_ID, true);
 * </pre>
 * </code> The default settings are specified in
 * {@link DiffOptions#Diff_Options()}.
 * 
 * 
 * @author florian
 *
 */
@SuppressWarnings("serial")
public class DiffOptions extends Hashtable<String, Boolean> {

	/**
	 * When true, differences in {@link SFeature} have no influence on
	 * isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_FEATURES = "ignoreFeatures";
	/**
	 * When true, differences in {@link SAnnotation} have no influence on
	 * isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_ANNOTATIONS = "ignoreAnnotations";
	/**
	 * When true, differences in {@link SMetaAnnotation} have no influence on
	 * isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_META_ANNOTATIONS = "ignoreMetaAnnotstaions";
	/**
	 * When true, differences in {@link SProcessingAnnotation} have no influence
	 * on isomorphie and will not produce any differences.
	 */
	public static final String OPTION_IGNORE_PROCESSING_ANNOTATIONS = "ignoreProcessingAnnotations";
	/**
	 * When true, differences in id have no influence on isomorphie and will not
	 * produce any differences.
	 */
	public static final String OPTION_IGNORE_ID = "ignoreId";
	/**
	 * When true, differences in name have no influence on isomorphie and will
	 * not produce any differences.
	 */
	public static final String OPTION_IGNORE_NAME = "ignoreName";
	/**
	 * When true, layers will not be checked when computing isomorphie and
	 * differences.
	 */
	public static final String OPTION_IGNORE_LAYER = "ignoreLayer";

	/**
	 * Creates a new option map, to compute the differences in an isomorphic
	 * comparison of graphs.
	 * <p>
	 * The default settings are:
	 * <ul>
	 * <li>{@link DiffOptions#OPTION_IGNORE_ANNOTATIONS}: false</li>
	 * <li>{@link DiffOptions#OPTION_IGNORE_META_ANNOTATIONS}: false</li>
	 * <li>{@link DiffOptions#OPTION_IGNORE_PROCESSING_ANNOTATIONS}: true</li>
	 * <li>{@link DiffOptions#OPTION_IGNORE_FEATURES}: false</li>
	 * <li>{@link DiffOptions#OPTION_IGNORE_ID}: false</li>
	 * <li>{@link DiffOptions#OPTION_IGNORE_NAME}: false</li>
	 * <li>{@link DiffOptions#OPTION_IGNORE_LAYER}: false</li>
	 * </ul>
	 * </p>
	 */
	public DiffOptions() {
		put(OPTION_IGNORE_ANNOTATIONS, false);
		put(OPTION_IGNORE_META_ANNOTATIONS, false);
		put(OPTION_IGNORE_PROCESSING_ANNOTATIONS, true);
		put(OPTION_IGNORE_FEATURES, false);
		put(OPTION_IGNORE_ID, true);
		put(OPTION_IGNORE_NAME, true);
		put(OPTION_IGNORE_LAYER, false);
	}

	/**
	 * Adds an option and returns this option object. If the key or value is
	 * null, nothing will be done.
	 */
	public DiffOptions setOption(String key, Boolean value) {
		if (key != null && value != null) {
			put(key, value);
		}
		return (this);
	}
}
