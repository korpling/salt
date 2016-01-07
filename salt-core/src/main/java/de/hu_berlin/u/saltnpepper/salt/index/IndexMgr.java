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
package de.hu_berlin.u.saltnpepper.salt.index;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * The index manager provides a mechanism to register indexes. An index relates
 * a set of nodes, relations or layers with an identifier. Each index is also
 * identified by an identifier, which is also used to access its elements. <br/>
 * A new index could be created via {@link #addIndex(String, Class, Class)}.
 * 
 * @author florian
 * @author Thomas Krause
 *
 */
public interface IndexMgr extends Serializable {

	/**
	 * Creates a new index which could be accessed via the passed identifier.
	 * The index can handle keys and values of the passed types.
	 * 
	 * @param indexId
	 *            identifier to access the index or its elements
	 * @param keyType
	 *            type of the keys in the index
	 * @param valueType
	 *            type of the values in the index
	 * @param <K>
	 * @param <V> 
	 */
	public <K, V> void createIndex(String indexId, Class<K> keyType, Class<V> valueType);

	/**
	 * Creates a new index which could be accessed via the passed identifier.
	 * The index can handle keys and values of the passed types.
	 * 
	 * @param indexId
	 *            identifier to access the index or its elements
	 * @param keyType
	 *            type of the keys in the index
	 * @param valueType
	 *            type of the values in the index
	 * @param expectedKeys
	 *            number of expected keys of the index, this parameter is used
	 *            for initialization optimization. -1 means no expected size
	 * @param expectedValuesPerKey
	 *            number of expected values per key of the index, this parameter
	 *            is used for initialization optimization.
	 * @param <K>
	 * @param <V>
	 */
	public <K, V> void createIndex(String indexId, Class<K> keyType, Class<V> valueType, int expectedKeys, int expectedValuesPerKey);

	/**
	 * Checks if an index with the passed identifier is registered.
	 * 
	 * @param indexId
	 *            identifier of the index
	 * @return true if an index with the passed identifier exists, false
	 *         otherwise
	 */
	public boolean containsIndex(String indexId);

	/**
	 * Removes the index with the passed identifier.
	 * 
	 * @param indexId
	 *            identifier of the index
	 * @return true if the identifier could be removed successfully, false
	 *         otherwise
	 */
	public boolean removeIndex(String indexId);

	/**
	 * Removes all entries contained in the index with the passed identifier
	 * 
	 * @param indexId
	 *            identifier of the index
	 */
	public void clearIndex(String indexId);

	/**
	 * Removes all index from the index manager.
	 */
	public void removeAll();

	/**
	 * Adds a new value to the index having the passed identifier under the
	 * passed key. If no such index exists, nothing is added.
	 * 
	 * @param indexId
	 *            identifier of the index
	 * @param key
	 *            the key to access the passed value
	 * @param value
	 *            the value to be added to the index
	 * @return true, if the entry was successfully added, false otherwise
	 * @param <K>
	 * @param <V>
	 */
	public <K, V> boolean put(String indexId, K key, V value);

	/**
	 * Adds a collection of values to the index having the passed identifier
	 * under the passed key. If no such index exists, nothing is added.
	 * 
	 * @param indexId
	 *            identifier of the index
	 * @param key
	 *            the key to access the passed value
	 * @param values
	 *            the values to be added to the index
	 * @return true, if the values were added successfully, false otherwise
	 * @param <K>
	 * @param <V>
	 */

	public <K, V> boolean putAll(String indexId, K key, Collection<V> values);

	/**
	 * Returns the value corresponding to the passed key, which is contained in
	 * the index with the passed identifier.
	 * 
	 * @param indexId
	 *            identifier of the index
	 * @param key
	 *            corresponding key to the returned value
	 * @return value matching the passed key
	 * @param <K>
	 * @param <V>
	 */
	public <K, V> V get(String indexId, K key);

	/**
	 * Returns the set of values corresponding to the passed key, which is
	 * contained in the index with the passed identifier.
	 * 
	 * @param indexId
	 *            identifier of the index
	 * @param key
	 *            corresponding key to the returned set of values
	 * @return set of values matching the passed key
	 * @param <K>
	 * @param <V>
	 */
	public <K, V> List<V> getAll(String indexId, K key);

	/**
	 * Removes the value or collection of values corresponding to the passed key
	 * contained in the index having the passed identifier. To remove a single
	 * value in a set of values use method
	 * {@link #remove(String, Object, Object)}.
	 * 
	 * @param indexId
	 *            identifier of the index
	 * @param key
	 *            key corresponding to the value or values to be removed
	 * @return true if the value or set of values were removed successfully,
	 *         false otherwise
	 * @param <K>
	 */
	public <K> boolean remove(String indexId, K key);

	/**
	 * Removes the passed value corresponding to the passed key contained in the
	 * index having the passed identifier.
	 * 
	 * @param indexId
	 *            identifier of the index
	 * @param key
	 *            key corresponding to the value to be removed
	 * @param value
	 * @return true if the value were removed successfully, false otherwise
	 * @param <K>
	 * @param <V>
	 */
	public <K, V> boolean remove(String indexId, K key, V value);

	/**
	 * Returns whether the index having the passed identifier contains the
	 * passed key.
	 * 
	 * @param indexId
	 *            identifier of the index
	 * @param key
	 *            key to be searched for
	 * @return true when the index contains such a key
	 * @param <K>
	 */
	public <K> boolean containsKey(String indexId, K key);

	/**
	 * Removes the passed value from all registered indexes.
	 * 
	 * @param value
	 *            the value to be removed
	 * @return true, if the value was removed successfully
	 * @param <V>
	 */
	public <V> boolean removeValue(V value);

	/**
	 * Removes the passed value from the indexes having the passed identifier.
	 * 
	 * @param indexId
	 * @param value
	 *            the value to be removed
	 * @return true, if the value was removed successfully
	 * @param <V>
	 */
	public <V> boolean removeValue(String indexId, V value);
}
