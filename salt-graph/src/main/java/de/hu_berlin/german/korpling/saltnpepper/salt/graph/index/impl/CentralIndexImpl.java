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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.CentralIndex;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mgr</b></em>'.
 * <!-- end-user-doc -->
 * 
 */
public class CentralIndexImpl implements CentralIndex 
{
	private final ReadWriteLock L = new ReentrantReadWriteLock();
	
	private Map<String, Multimap<Object,Object>> indexes;
	private Map<String, Class<?>> indexKeyTypes;
	private Map<String, Class<?>> indexValueTypes;

	public CentralIndexImpl()
	{
		indexes = Maps.newHashMap();
		indexKeyTypes = Maps.newHashMap();
		indexValueTypes = Maps.newHashMap();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public <K,V> void addIndex(String indexId, Class<K> keyType, Class<V> valueType) 
	{
		L.writeLock().lock();
		try
		{
			if (this.hasIndex(indexId))
				throw new GraphException("Cannot add the given index, because an index with this id already exists: "+ indexId);

			indexes.put(indexId, LinkedHashMultimap.create());
			indexKeyTypes.put(indexId, keyType);
			indexValueTypes.put(indexId, valueType);
		}
		finally
		{
			L.writeLock().unlock();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public boolean hasIndex(String indexId) 
	{
		L.readLock().lock();
		try
		{
			return indexes.containsKey(indexId);
		}
		finally
		{
			L.readLock().unlock();
		}
	}

	@Override
	public <K, V> boolean put(String indexId, K key, V value)
	{
		L.writeLock().lock();
		try
		{
			if(indexId != null && key != null && value != null)
			{
				Class<?> keyClass = indexKeyTypes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);

				if(keyClass.isAssignableFrom(key.getClass()) 
						&& valueClass.isAssignableFrom(value.getClass()))
				{
					return indexes.get(indexId).put(key, value);
				}
			}
			return false;
		}
		finally
		{
			L.writeLock().unlock();
		}
	}
	

	@Override
	public <K, V> V get(String indexId, K key)
	{
		ImmutableList<V> result = getAll(indexId, key);
		if(result.isEmpty())
		{
			return null;
		}
		else
		{
			return result.iterator().next();
		}
	}

	@Override
	public <K, V> ImmutableList<V> getAll(String indexId, K key)
	{
		if(indexId == null && key == null)
		{
			L.readLock().lock();
			try
			{
				Class<?> keyClass = indexKeyTypes.get(indexId);
				if(keyClass.isAssignableFrom(key.getClass()))
				{
					return ImmutableList
							.copyOf((Collection<V>) indexes.get(indexId).get(key));
				}
			}
			finally
			{
				L.readLock().unlock();
			}
		}
		return ImmutableList.copyOf(new LinkedList<V>());
	}

	@Override
	public <K> boolean containsKey(String indexId, K key)
	{
		return !getAll(indexId, key).isEmpty();
	}
	
	

	@Override
	public <K> boolean remove(String indexId, K key)
	{
		if(indexId == null && key == null)
		{
			L.writeLock().lock();
			try
			{
				Class<?> keyClass = indexKeyTypes.get(indexId);
				if(keyClass != null && keyClass.isAssignableFrom(key.getClass()))
				{
					return !indexes.get(indexId).removeAll(key).isEmpty();
				}
			}
			finally
			{
				L.writeLock().unlock();
			}
		}
		return false;
	}

	@Override
	public <K, V> boolean remove(String indexId, K key, V value)
	{
		if(indexId == null && key == null)
		{
			L.writeLock().lock();
			try
			{
				Class<?> keyClass = indexKeyTypes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);
				if(keyClass != null && valueClass != null
						&& keyClass.isAssignableFrom(key.getClass())
						&& valueClass.isAssignableFrom(value.getClass()))
				{
					return indexes.get(indexId).remove(key, value);
				}
			}
			finally
			{
				L.writeLock().unlock();
			}
		}
		return false;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public boolean removeIndex(String indexId) 
	{
		L.writeLock().lock();
		try
		{
			if(indexes.remove(indexId) == null)
			{
				indexKeyTypes.remove(indexId);
				indexValueTypes.remove(indexId);
				return true;
			}
			return false;
		}
		finally
		{
			L.writeLock().unlock();
		}
	}

	@Override
	public void clearIndex(String indexId)
	{
		L.writeLock().lock();
		try
		{
			Multimap<Object, Object> idx = indexes.get(indexId);
			if(idx != null)
			{
				idx.clear();
			}
			indexKeyTypes.remove(indexId);
			indexValueTypes.remove(indexId);
		}
		finally
		{
			L.writeLock().unlock();
		}
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void removeAll() 
	{
		L.writeLock().lock();
		try
		{
			indexes.clear();
			indexKeyTypes.clear();
			indexValueTypes.clear();
		}
		finally
		{
			L.writeLock().unlock();
		}
	}

	/**
	 * Removes the given element from all indexes.
	 * @param element - the element which shall be removed
	 * @return true, if removing was successful 
	 */
	@Override
	public <V> boolean removeElement(V element) 
	{
		boolean result = false;
		
		if(element != null)
		{
			L.writeLock().lock();
			try
			{
				for(Entry<String, Multimap<Object, Object>> e : indexes.entrySet())
				{
					// only search for the value if it is possible to store this
					// type of data in the index
					if(indexValueTypes.get(e.getKey()).isAssignableFrom(element.getClass()))
					{
						result = e.getValue().values().remove(element) || result;
					}
				}
			}
			finally
			{
				L.writeLock().unlock();
			}
		}
		return result;
	}

	@Override
	public <V> boolean removeElement(String indexId, V element)
	{
		boolean result = false;
		
		if(indexId != null && element != null)
		{
			L.writeLock().lock();
			try
			{
				Multimap<Object,Object> idx = indexes.get(indexId);
				Class<?> valueClass = indexValueTypes.get(indexId);

				if(idx != null && valueClass != null 
					&& valueClass.isAssignableFrom(element.getClass()))
				{
					result = idx.values().remove(element);
				}
			}
			finally
			{
				L.writeLock().unlock();
			}
		}
		
		return result;
	}
	
	

	@Override
	public boolean removeAllElements(Collection<?> element)
	{
		boolean result = false;
		L.writeLock().lock();
		try
		{
			for(Multimap<?, ?> index : indexes.values())
			{
				result = index.values().removeAll(element) || result;
			}
		}
		finally
		{
			L.writeLock().unlock();
		}
		return result;
	}
	
	
	
	
} //IndexMgrImpl
