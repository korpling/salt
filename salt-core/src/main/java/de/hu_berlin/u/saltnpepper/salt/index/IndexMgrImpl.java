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

public class IndexMgrImpl implements IndexMgr {
	private final ReadWriteLock L = new ReentrantReadWriteLock();

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
			L.writeLock().lock();
		}
		try {
			if (this.hasIndex(indexId)) {
				throw new SaltException("Cannot add the given index, because an index with this id already exists: " + indexId);
			}
			if ((expectedKeys > 0) && (expectedValuesPerKey > 0)) {
				indexes.put(indexId, ArrayListMultimap.create(expectedKeys, expectedValuesPerKey));
			} else {
				indexes.put(indexId, ArrayListMultimap.create());
			}
			indexKeyTypes.put(indexId, keyType);
			indexValueTypes.put(indexId, valueType);
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public boolean hasIndex(String indexId) {
		if (threadSafe) {
			L.readLock().lock();
		}
		try {
			return indexes.containsKey(indexId);
		} finally {
			if (threadSafe) {
				L.readLock().unlock();
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> boolean put(String indexId, K key, V value) {
		if (threadSafe) {
			L.writeLock().lock();
		}

		try {
			if (indexId != null && key != null && value != null) {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);
				if (keyClass != null && valueClass != null && keyClass.isAssignableFrom(key.getClass()) && valueClass.isAssignableFrom(value.getClass())) {
					return indexes.get(indexId).put(key, value);
				}
			}
			return false;
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public <K, V> boolean putAll(String indexId, K key, Collection<V> values) {
		if (threadSafe) {
			L.writeLock().lock();
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
				L.writeLock().unlock();
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
				L.readLock().lock();
			}

			try {
				return (Collections.unmodifiableList((List<V>) indexes.get(indexId).get(key)));
			} finally {
				if (threadSafe) {
					L.readLock().unlock();
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
				L.writeLock().lock();
			}

			try {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				if (keyClass != null && keyClass.isAssignableFrom(key.getClass())) {
					return !indexes.get(indexId).removeAll(key).isEmpty();
				}
			} finally {
				if (threadSafe) {
					L.writeLock().unlock();
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
				L.writeLock().lock();
			}

			try {
				Class<?> keyClass = indexKeyTypes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);
				if (keyClass != null && valueClass != null && keyClass.isAssignableFrom(key.getClass()) && valueClass.isAssignableFrom(value.getClass())) {
					return indexes.get(indexId).remove(key, value);
				}

			} finally {
				if (threadSafe) {
					L.writeLock().unlock();
				}
			}
		}
		return false;
	}

	/** {@inheritDoc} **/
	@Override
	public boolean removeIndex(String indexId) {
		if (threadSafe) {
			L.writeLock().lock();
		}

		try {
			if (indexes.remove(indexId) == null) {
				indexKeyTypes.remove(indexId);
				indexValueTypes.remove(indexId);
				return true;
			}
			return false;
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void clearIndex(String indexId) {
		if (threadSafe) {
			L.writeLock().lock();
		}

		try {
			Multimap<Object, Object> idx = indexes.get(indexId);
			if (idx != null) {
				idx.clear();
			}
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void removeAll() {
		if (threadSafe) {
			L.writeLock().lock();
		}

		try {
			indexes.clear();
			indexKeyTypes.clear();
			indexValueTypes.clear();
		} finally {
			if (threadSafe) {
				L.writeLock().unlock();
			}
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
				L.writeLock().lock();
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
					L.writeLock().unlock();
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
				L.writeLock().lock();
			}

			try {
				Multimap<Object, Object> idx = indexes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);

				if (idx != null && valueClass != null && valueClass.isAssignableFrom(element.getClass())) {
					result = idx.values().remove(element);
				}
			} finally {
				if (threadSafe) {
					L.writeLock().unlock();
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
		StringBuilder str= new StringBuilder();
		for (String indexId: indexes.keySet()){
			str.append(indexId);
			str.append(": ");
			Multimap<Object, Object> index=  indexes.get(indexId);
			str.append(index);
			str.append(",\n");
		}
		
		return(str.toString()); 
	}
}
