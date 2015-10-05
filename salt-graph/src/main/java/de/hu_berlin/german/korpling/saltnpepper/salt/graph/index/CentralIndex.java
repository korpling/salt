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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index;

import com.google.common.collect.ImmutableList;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mgr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class manages a set of Index objects, for faster access on {@link Graph} members. Such an {@link Index} object indexes a single object (so called value) or a set of objects (so called values) by using a unique key for indexing them. In case of the {@link Index} object is of type  {@link SimpleIndex}, each key has exactly one value in case of the {@link Index} object is of type {@link ComplexIndex}, each key has a list of values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.CentralIndex#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.CentralIndex#getNumOfIndexes <em>Num Of Indexes</em>}</li>
 * </ul>
 * </p>
 */
public interface CentralIndex  {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	<K,V> void addIndex(String indexId, Class<K> keyType, Class<V> valueType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	boolean hasIndex(String indexId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	boolean removeIndex(String indexId);
	void clearIndex(String indexId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	void removeAll();

	<K,V> boolean put(String indexId, K key, V value);
	<K,V> boolean putAll(String indexId, K key, Collection<V> values);
	
	<K,V> V get(String indexId, K key);
	<K, V> EList<V> getAll(String indexId, K key);
	
	<K> boolean remove(String indexId, K key);
	<K, V> boolean remove(String indexId, K key, V value);
	<K> boolean containsKey(String indexId, K key);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	<V> boolean removeElement(V element);
	<V> boolean removeElement(String indexId, V element);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	boolean removeAllElements(Collection<?> element);

} // CentralIndex
