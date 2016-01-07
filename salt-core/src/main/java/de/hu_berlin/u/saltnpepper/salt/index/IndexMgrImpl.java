package de.hu_berlin.u.saltnpepper.salt.index;

import com.google.common.base.Preconditions;
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
import java.io.Serializable;

/**
 * 
 * @author florian
 * @author Thomas Krause
 *
 */
@SuppressWarnings("serial")
public class IndexMgrImpl implements IndexMgr {
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	private static class Index<K,V> implements Serializable {
		
		final Multimap<K, V> map;
		final Class<K> keyClass;
		final Class<V> valueClass;

		public Index(Multimap<K, V> map, Class<K> keyClass, Class<V> valueClass) {
			Preconditions.checkNotNull(map);
			Preconditions.checkNotNull(keyClass);
			Preconditions.checkNotNull(valueClass);
			
			this.map = map;
			this.keyClass = keyClass;
			this.valueClass = valueClass;
		}
		
	}
	
	private Map<String, Index> indexes;
	private final boolean threadSafe;

	public IndexMgrImpl() {
		this(false);
	}

	public IndexMgrImpl(boolean threadSafe) {
		this.threadSafe = threadSafe;

		indexes = Maps.newHashMap();
	}

	/** 
	 * {@inheritDoc}
	 **/
	@Override
	public <K, V> void createIndex(String indexId, Class<K> keyType, Class<V> valueType) {
		createIndex(indexId, keyType, valueType, -1, -1);
	}

	/** 
	 * {@inheritDoc}
	**/
	@Override
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
		Multimap<K,V> map;
		if ((expectedKeys > 0) && (expectedValuesPerKey > 0)) {
			map = ArrayListMultimap.create(expectedKeys, expectedValuesPerKey);
		} else {
			map = ArrayListMultimap.create();
		}
		indexes.put(indexId, new Index<>(map, keyType, valueType));
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
				Index idx = indexes.get(indexId);
				if (idx != null) {
					if (idx.keyClass.isAssignableFrom(key.getClass()) && idx.valueClass.isAssignableFrom(value.getClass())) {
						return idx.map.put(key, value);
					} else {
						if (!idx.keyClass.isAssignableFrom(key.getClass())) {
							throw new ClassCastException("The type passed key '" + key.getClass() + "' is not assignable to '" + idx.keyClass + "'. ");
						}
						if (!idx.valueClass.isAssignableFrom(value.getClass())) {
							throw new ClassCastException("The type passed value '" + value.getClass() + "' is not assignable to '" + idx.valueClass + "'. ");
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
				Index idx = indexes.get(indexId);
				
			
				if (idx.keyClass.isAssignableFrom(key.getClass()) && idx.valueClass.isAssignableFrom(values.iterator().next().getClass())) {
					return idx.map.putAll(key, values);
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
				Index idx = indexes.get(indexId);
				if(idx != null) {
					Collection<V> col= idx.map.get(key);
					if (col instanceof List){
						return (Collections.unmodifiableList((List<V>) col));	
					} else {
						return Collections.unmodifiableList(new ArrayList<>(col));
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
				Index idx = indexes.get(indexId);
				if (idx != null && idx.keyClass.isAssignableFrom(key.getClass())) {
					return !idx.map.removeAll(key).isEmpty();
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
				Index idx = indexes.get(indexId);

				if (idx != null && idx.keyClass.isAssignableFrom(key.getClass()) 
						&& idx.valueClass.isAssignableFrom(value.getClass())) {
					return idx.map.remove(key, value);
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
					return true;
				}
				return false;
			} finally {
				lock.writeLock().unlock();
			}
		} else {
			if (indexes.remove(indexId) == null) {
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
			Index idx = indexes.get(indexId);
			if (idx != null) {
				idx.map.clear();
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
			} finally {
				lock.writeLock().unlock();
			}
		} else {
			indexes.clear();
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
				for (Entry<String, Index> e : indexes.entrySet()) {
					// only search for the value if it is possible to store this
					// type of data in the index
					if (e.getValue().valueClass.isAssignableFrom(element.getClass())) {
						result = e.getValue().map.values().remove(element) || result;
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
				Index idx = indexes.get(indexId);

				if (idx != null && idx.valueClass.isAssignableFrom(element.getClass())) {
					result = idx.map.values().remove(element);
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
		for (Map.Entry<String, Index> indexEntry : indexes.entrySet()) {
			str.append(indexEntry.getKey());
			str.append(": ");
			str.append(indexEntry.getValue().map);
			str.append(",\n");
		}

		return (str.toString());
	}
}
