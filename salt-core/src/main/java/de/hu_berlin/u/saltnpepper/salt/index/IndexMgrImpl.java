package de.hu_berlin.u.saltnpepper.salt.index;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;

@SuppressWarnings("serial")
public class IndexMgrImpl implements IndexMgr {
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	private Map<String, Multimap<Object, Object>> indexes;
	private Map<String, Class<?>> indexKeyTypes;
	private Map<String, Class<?>> indexValueTypes;

	private final boolean threadSafe;

	public IndexMgrImpl() {
		this(false);
	}

	public IndexMgrImpl(boolean threadSafe) {
		this.threadSafe = threadSafe;

		indexes = Maps.newHashMap();
		indexKeyTypes = Maps.newHashMap();
		indexValueTypes = Maps.newHashMap();
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> void createIndex(String indexId, Class<K> keyType, Class<V> valueType) {
		createIndex(indexId, keyType, valueType, -1, -1);
	}

	/** {@inheritDoc} **/
	public <K, V> void createIndex(String indexId, Class<K> keyType, Class<V> valueType, int expectedKeys, int expectedValuesPerKey) {
		if (threadSafe) {
			lock.writeLock().lock();
			try {
				createIndex_intern(indexId, keyType, valueType, expectedKeys, expectedValuesPerKey);
			} finally {
				lock.writeLock().unlock();
			}
		} else {
			createIndex_intern(indexId, keyType, valueType, expectedKeys, expectedValuesPerKey);
		}
	}

	private <K, V> void createIndex_intern(String indexId, Class<K> keyType, Class<V> valueType, int expectedKeys, int expectedValuesPerKey) {
		if (this.containsIndex(indexId)) {
			throw new SaltException("Cannot add the given index, because an index with this id already exists: " + indexId);
		}
		if ((expectedKeys > 0) && (expectedValuesPerKey > 0)) {
			indexes.put(indexId, ArrayListMultimap.create(expectedKeys, expectedValuesPerKey));
		} else {
			indexes.put(indexId, ArrayListMultimap.create());
		}
		indexKeyTypes.put(indexId, keyType);
		indexValueTypes.put(indexId, valueType);
	}

	/** {@inheritDoc} **/
	@Override
	public boolean containsIndex(String indexId) {
		if (threadSafe) {
			lock.readLock().lock();
			try {
				return indexes.containsKey(indexId);
			} finally {
				lock.readLock().unlock();
			}
		} else {
			return indexes.containsKey(indexId);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> boolean put(String indexId, K key, V value) {
		if (threadSafe) {
			lock.writeLock().lock();
		}

		try {
			if (indexId != null && key != null && value != null) {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);
				if (keyClass != null && valueClass != null) {
					if (keyClass.isAssignableFrom(key.getClass()) && valueClass.isAssignableFrom(value.getClass())) {
						return indexes.get(indexId).put(key, value);
					} else {
						if (!keyClass.isAssignableFrom(key.getClass())) {
							throw new ClassCastException("The type passed key '" + key.getClass() + "' is not assignable to '" + keyClass + "'. ");
						}
						if (!valueClass.isAssignableFrom(value.getClass())) {
							throw new ClassCastException("The type passed value '" + value.getClass() + "' is not assignable to '" + valueClass + "'. ");
						}
					}
				}
			}
			return false;
		} finally {
			if (threadSafe) {
				lock.writeLock().unlock();
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> boolean putAll(String indexId, K key, Collection<V> values) {
		if (threadSafe) {
			lock.writeLock().lock();
		}

		try {
			if (indexId != null && key != null && values != null && !values.isEmpty()) {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);

				if (keyClass.isAssignableFrom(key.getClass()) && valueClass.isAssignableFrom(values.iterator().next().getClass())) {
					return indexes.get(indexId).putAll(key, values);
				}
			}
			return false;
		} finally {
			if (threadSafe) {
				lock.writeLock().unlock();
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> V get(String indexId, K key) {
		List<V> result = getAll(indexId, key);
		if (result.isEmpty()) {
			return null;
		} else {
			return result.iterator().next();
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> List<V> getAll(String indexId, K key) {
		if (indexId != null && key != null) {
			if (threadSafe) {
				lock.readLock().lock();
			}

			try {
				Collection<Object> col= indexes.get(indexId).get(key);
				if (col instanceof List){
					return (Collections.unmodifiableList((List<V>) col));	
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
	public <K> boolean containsKey(String indexId, K key) {
		return !getAll(indexId, key).isEmpty();
	}

	/** {@inheritDoc} **/
	@Override
	public <K> boolean remove(String indexId, K key) {
		if (indexId != null && key != null) {
			if (threadSafe) {
				lock.writeLock().lock();
			}

			try {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				if (keyClass != null && keyClass.isAssignableFrom(key.getClass())) {
					return !indexes.get(indexId).removeAll(key).isEmpty();
				}
			} finally {
				if (threadSafe) {
					lock.writeLock().unlock();
				}
			}
		}
		return false;
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> boolean remove(String indexId, K key, V value) {
		if (indexId != null && key != null && value != null) {
			if (threadSafe) {
				lock.writeLock().lock();
			}

			try {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);
				if (keyClass != null && valueClass != null && keyClass.isAssignableFrom(key.getClass()) && valueClass.isAssignableFrom(value.getClass())) {
					return indexes.get(indexId).remove(key, value);
				}

			} finally {
				if (threadSafe) {
					lock.writeLock().unlock();
				}
			}
		}
		return false;
	}

	/** {@inheritDoc} **/
	@Override
	public boolean removeIndex(String indexId) {
		if (threadSafe) {
			lock.writeLock().lock();
			try {
				if (indexes.remove(indexId) == null) {
					indexKeyTypes.remove(indexId);
					indexValueTypes.remove(indexId);
					return true;
				}
				return false;
			} finally {
				lock.writeLock().unlock();
			}
		} else {
			if (indexes.remove(indexId) == null) {
				indexKeyTypes.remove(indexId);
				indexValueTypes.remove(indexId);
				return true;
			}
			return false;
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void clearIndex(String indexId) {
		if (threadSafe) {
			lock.writeLock().lock();
		}

		try {
			Multimap<Object, Object> idx = indexes.get(indexId);
			if (idx != null) {
				idx.clear();
			}
		} finally {
			if (threadSafe) {
				lock.writeLock().unlock();
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void removeAll() {
		if (threadSafe) {
			lock.writeLock().lock();
			try {
				indexes.clear();
				indexKeyTypes.clear();
				indexValueTypes.clear();
			} finally {
				lock.writeLock().unlock();
			}
		} else {
			indexes.clear();
			indexKeyTypes.clear();
			indexValueTypes.clear();
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
	public <V> boolean removeValue(V element) {
		boolean result = false;

		if (element != null) {
			if (threadSafe) {
				lock.writeLock().lock();
			}

			try {
				for (Entry<String, Multimap<Object, Object>> e : indexes.entrySet()) {
					// only search for the value if it is possible to store this
					// type of data in the index
					if (indexValueTypes.get(e.getKey()).isAssignableFrom(element.getClass())) {
						result = e.getValue().values().remove(element) || result;
					}
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
	public <V> boolean removeValue(String indexId, V element) {
		boolean result = false;

		if (indexId != null && element != null) {
			if (threadSafe) {
				lock.writeLock().lock();
			}

			try {
				Multimap<Object, Object> idx = indexes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);

				if (idx != null && valueClass != null && valueClass.isAssignableFrom(element.getClass())) {
					result = idx.values().remove(element);
				}
			} finally {
				if (threadSafe) {
					lock.writeLock().unlock();
				}
			}
		}

		return result;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (String indexId : indexes.keySet()) {
			str.append(indexId);
			str.append(": ");
			Multimap<Object, Object> index = indexes.get(indexId);
			str.append(index);
			str.append(",\n");
		}

		return (str.toString());
	}
}
