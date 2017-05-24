/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.index;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.corpus_tools.salt.exceptions.SaltException;

import com.google.common.collect.Multimap;

public class IndexMgrImpl extends IndexMgrBase implements IndexMgr {
	private static final long serialVersionUID = 4911375442102018598L;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final boolean threadSafe;

	public IndexMgrImpl() {
		this(false);
	}

	public IndexMgrImpl(boolean threadSafe) {
		this.threadSafe = threadSafe;
	}

	/**
	 * {@inheritDoc}
	 **/
	@Override
	public <K, V> void createIndex(IndexID<K, V> indexId) {
		createIdx(indexId, -1, -1);
	}

	/**
	 * {@inheritDoc}
	 **/
	@Override
	public <K, V> void createIndex(IndexID<K, V> indexId, int expectedKeys, int expectedValuesPerKey) {
		if (threadSafe) {
			lock.writeLock().lock();
			try {
				createIndex_intern(indexId, expectedKeys, expectedValuesPerKey);
			} finally {
				lock.writeLock().unlock();
			}
		} else {
			createIndex_intern(indexId, expectedKeys, expectedValuesPerKey);
		}
	}

	private <K, V> void createIndex_intern(IndexID<K, V> indexId, int expectedKeys, int expectedValuesPerKey) {
		if (this.containsIdx(indexId)) {
			throw new SaltException(
					"Cannot add the given index, because an index with this id already exists: " + indexId);
		}
		createIdx(indexId, expectedKeys, expectedValuesPerKey);
	}

	/** {@inheritDoc} **/
	@Override
	public boolean containsIndex(IndexID<?, ?> indexId) {
		if (threadSafe) {
			lock.readLock().lock();
			try {
				return containsIdx(indexId);
			} finally {
				lock.readLock().unlock();
			}
		} else {
			return containsIdx(indexId);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> boolean put(IndexID<K, V> indexId, K key, V value) {

		if (indexId != null && key != null && value != null) {
			if (threadSafe) {
				lock.writeLock().lock();
				try {
					return put_internal(indexId, key, value);
				} finally {
					lock.writeLock().unlock();
				}
			} else {
				return put_internal(indexId, key, value);
			}
		}
		return false;
	}

	private <K, V> boolean put_internal(IndexID<K, V> indexId, K key, V value) {
		Multimap<K, V> idx = getIdx(indexId);
		if (idx != null) {
			return idx.put(key, value);
		} else {
			return false;
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> boolean putAll(IndexID<K, V> indexId, K key, Collection<? extends V> values) {

		if (indexId != null && key != null && values != null && !values.isEmpty()) {
			if (threadSafe) {
				lock.writeLock().lock();
				try {
					return putAll_internal(indexId, key, values);
				} finally {
					lock.writeLock().unlock();
				}
			} else {
				return putAll_internal(indexId, key, values);
			}
		}
		return false;
	}

	private <K, V> boolean putAll_internal(IndexID<K, V> indexId, K key, Collection<? extends V> values) {
		Multimap<K, V> idx = getIdx(indexId);
		if (idx != null) {
			return idx.putAll(key, values);
		} else {
			return false;
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> V get(IndexID<K, V> indexId, K key) {
		V result = null;
		if (indexId != null && key != null) {
			if (threadSafe) {
				lock.readLock().lock();
			}

			try {
				Multimap<K, V> idx = getIdx(indexId);
				if (idx != null) {
					Collection<V> values = idx.get(key);
					if (!values.isEmpty()) {
						result = values.iterator().next();
					}
				}
			} finally {
				if (threadSafe) {
					lock.readLock().unlock();
				}
			}
		}
		return result;
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> List<V> getAll(IndexID<K, V> indexId, K key) {
		if (indexId != null && key != null) {
			if (threadSafe) {
				lock.readLock().lock();
			}

			try {
				Multimap<K, V> idx = getIdx(indexId);
				if (idx != null) {
					Collection<V> values = idx.get(key);
					if (values instanceof List) {
						return Collections.unmodifiableList((List<V>) values);
					} else {
						return new ArrayList<>(values);
					}
				}
			} finally {
				if (threadSafe) {
					lock.readLock().unlock();
				}
			}
		}
		return (Collections.unmodifiableList(new ArrayList<V>()));
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> boolean containsKey(IndexID<K, V> indexId, K key) {
		boolean result = false;
		if (indexId != null && key != null) {
			if (threadSafe) {
				lock.readLock().lock();
				try {
					result = containsKey_internal(indexId, key);
				} finally {
					lock.readLock().unlock();
				}
			} else {
				result = containsKey_internal(indexId, key);
			}
		}
		return result;
	}

	private <K, V> boolean containsKey_internal(IndexID<K, V> indexId, K key) {
		Multimap<K, V> idx = getIdx(indexId);

		if (idx != null) {
			return idx.containsKey(key);
		} else {
			return false;
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K> boolean remove(IndexID<K, ?> indexId, K key) {
		if (indexId != null && key != null) {
			if (threadSafe) {
				lock.writeLock().lock();
				try {
					return remove_internal(indexId, key);
				} finally {
					lock.writeLock().unlock();
				}
			} else {
				return remove_internal(indexId, key);
			}
		}
		return false;
	}

	private <K> boolean remove_internal(IndexID<K, ?> indexId, K key) {
		Multimap<K, ?> idx = getIdx(indexId);
		if (idx != null) {
			return !idx.removeAll(key).isEmpty();
		} else {
			return false;
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> boolean remove(IndexID<K, V> indexId, K key, V value) {
		if (indexId != null && key != null && value != null) {
			if (threadSafe) {
				lock.writeLock().lock();
				try {
					return remove_internal(indexId, key, value);
				} finally {
					lock.writeLock().unlock();
				}
			} else {
				return remove_internal(indexId, key, value);
			}
		}
		return false;
	}

	public <K, V> boolean remove_internal(IndexID<K, V> indexId, K key, V value) {
		Multimap<K, V> idx = getIdx(indexId);

		if (idx != null) {
			return idx.remove(key, value);
		} else {
			return false;
		}
	}

	/** {@inheritDoc} **/
	@Override
	public boolean removeIndex(IndexID<?, ?> indexId) {
		if (threadSafe) {
			lock.writeLock().lock();
			try {
				return removeIdx(indexId);
			} finally {
				lock.writeLock().unlock();
			}
		} else {
			return removeIdx(indexId);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void clearIndex(IndexID<?, ?> indexId) {

		if (threadSafe) {
			lock.writeLock().lock();
			try {
				clearIndex_internal(indexId);
			} finally {
				lock.writeLock().unlock();
			}
		} else {
			clearIndex_internal(indexId);
		}
	}

	private void clearIndex_internal(IndexID<?, ?> indexId) {
		Multimap<?, ?> idx = getIdx(indexId);
		if (idx != null) {
			idx.clear();
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void removeAll() {
		if (threadSafe) {
			lock.writeLock().lock();
			try {
				super.clear();
			} finally {
				lock.writeLock().unlock();
			}
		} else {
			super.clear();
		}
	}

	/**
	 * Removes the given element from all indexes.
	 * 
	 * @param element
	 *            - the element which shall be removed
	 * @return true, if removing was successful
	 */
	@Override
	public <V> boolean removeValue(V element, Class<V> valueClass) {
		boolean result = false;

		if (element != null && valueClass != null) {
			if (threadSafe) {
				lock.writeLock().lock();
			}
			try {
				// only search for the value if it is possible to store this
				// type of data in the index
				for (Multimap<?, V> map : getIdxForValueType(valueClass)) {
					result = map.values().remove(element) || result;
				}
			} finally {
				if (threadSafe) {
					lock.writeLock().unlock();
				}
			}
		}
		return result;
	}

	/** {@inheritDoc} **/
	@Override
	public <V> boolean removeValue(IndexID<?, V> indexId, V element) {
		boolean result = false;

		if (indexId != null && element != null) {
			if (threadSafe) {
				lock.writeLock().lock();
				try {
					result = removeValue_internal(indexId, element);
				} finally {
					lock.writeLock().unlock();
				}
			} else {
				result = removeValue_internal(indexId, element);
			}
		}
		return result;
	}

	private <V> boolean removeValue_internal(IndexID<?, V> indexId, V element) {
		Multimap<?, V> idx = getIdx(indexId);

		if (idx != null) {
			return idx.values().remove(element);
		} else {
			return false;
		}
	}
}
