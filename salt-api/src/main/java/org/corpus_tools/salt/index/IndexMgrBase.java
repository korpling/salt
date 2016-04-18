package org.corpus_tools.salt.index;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

@SuppressWarnings("serial")
public abstract class IndexMgrBase {
	
	
	private static class IndexHolder<K, V> implements Serializable {

		final Multimap<K, V> map;
		final IndexID<K,V> indexId;
		
		public IndexHolder(IndexID<K,V> indexId,
				int expectedKeys, int expectedValuesPerKey) {
			Preconditions.checkNotNull(indexId);

			this.indexId = indexId;
			
			if ((expectedKeys > 0) && (expectedValuesPerKey > 0)) {
				this.map = ArrayListMultimap.create(expectedKeys, expectedValuesPerKey);
			} else {
				this.map = ArrayListMultimap.create();
			}
		}
	}
	
	private final Map<IndexID<?,?>, IndexHolder<?,?>> indexes;
	
	public IndexMgrBase() {
		this.indexes = Maps.newHashMap();
	}

	protected<K,V> Multimap<K,V >getIdx(IndexID<K,V> indexId) {
		
		IndexHolder<?,?> untypedIdx = indexes.get(indexId);
		
		if(untypedIdx == null) {
			return null;
		}
		
		if(untypedIdx.indexId.getKeyClass().isAssignableFrom(indexId.getKeyClass()) 
				&& untypedIdx.indexId.getValueClass().isAssignableFrom(indexId.getValueClass())) {
			// We can safely cast this since we checked both classes are compatible
			// and he putIdx(...) function makes sure that the key and value types are synchronized.
			@SuppressWarnings("unchecked")
			IndexHolder<K,V> typedIdx = (IndexHolder<K,V>) untypedIdx;
			return typedIdx.map;
		} 
		return null;
	}
	
	protected<V> List<Multimap<?,V>> getIdxForValueType(Class<V> valueClass) {
		
		List<Multimap<?, V>> result = new ArrayList<>();
		
		for(IndexHolder<?, ?> indexHolder : indexes.values()) {
			if (indexHolder.indexId.getValueClass().isAssignableFrom(valueClass)) {
				@SuppressWarnings("unchecked")
				Multimap<?, V> typedMap = (Multimap<?, V>) indexHolder.map;
				result.add(typedMap);
			}
		}
		
		return result;
	}
	
	protected<K,V> boolean createIdx(IndexID<K,V> indexId, int expectedKeys, int expectedValuesPerKey) {
		
		IndexHolder<K, V> idx = new IndexHolder<>(indexId, expectedKeys, expectedValuesPerKey);
		return indexes.put(indexId, idx) == null;
	}
	
	protected boolean containsIdx(IndexID<?,?> indexId) {
		return indexes.containsKey(indexId);
	}
	
	protected boolean removeIdx(IndexID<?,?> indexId) {
		return indexes.remove(indexId) == null;
	}
	
	protected void clear() {
		indexes.clear();
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Map.Entry<IndexID<?,?>, IndexHolder<?,?>> indexEntry : indexes.entrySet()) {
			str.append(indexEntry.getKey());
			str.append(": ");
			str.append(indexEntry.getValue().map);
			str.append(",\n");
		}

		return (str.toString());
	}
}
